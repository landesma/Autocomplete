import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by Lior on 1/31/2018.
 */
public class AutoCompleter {

    private Leaf[] buckets;
    private Word[] currentPredictions;

    public AutoCompleter(String fileName){
        buckets = createBuckets(fileName);
    }

    //Creates 26 leafs (a-z), reads words from file and inserts them into the data structure.
    private Leaf[] createBuckets(String fileName) {

        Leaf[] buckets = new Leaf[26];
        for (char c = 'a'; c <= 'z'; c++) {
            int i = c - 'a';
            buckets[i] = new Leaf(Character.toString(c));
        }

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(word -> buckets[word.charAt(0) - 'a'].insert(word)); //deducting 'a' maps a word to it's bucket
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buckets;
    }


    public Word[] completePrefix(String prefix){

        char c = prefix.charAt(0);
        currentPredictions = buckets[c - 'a'].getPredictions(prefix);
        Arrays.sort(currentPredictions, Comparator.comparingInt(Word::getCount));
        return currentPredictions;

    }

    //For better predictions in the future
    public void updateChoice(int choice, String prefix){
        if (currentPredictions[2-choice] != null) {
            buckets[prefix.charAt(0) - 'a'].insert(currentPredictions[2-choice].getWord());
        }
    }

}
