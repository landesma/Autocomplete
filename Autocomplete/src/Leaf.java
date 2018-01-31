import javafx.collections.transformation.SortedList;

import java.util.ArrayList;


/**
 * Created by Lior on 1/30/2018.
 */
public class Leaf extends Bucket {

    private ArrayList<Word> words;

    Leaf(String pref) {
        super(pref);
        this.words = new ArrayList<Word>();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    @Override
    protected Word insert(String word) {

        Word w = new Word(word);
        Word toAdd;

        //First, check if the word already exists and update counter accordingly. else, add it to this Leaf words.
        int index = words.indexOf(w);
        if (index != -1) {
            toAdd = words.get(index);
            toAdd.increment();

        } else {
            toAdd = new Word(word);
            words.add(toAdd);
        }

        updateTopThree(toAdd);  //Implemented in super class (Bucket)
        return toAdd;
    }



    @Override
    protected Word[] search(String prefix) {

        Word[] predictions = createEmptyPredictions();

        //Find the 3 moat frequent words that starts with this prefix
        for (Word word : words) {
            if (word.getWord().startsWith(prefix)) {
                //if this is a relevant word, check if it's count greater.
                for (int indexOfPredictions = 0; indexOfPredictions < 3; indexOfPredictions++) {
                    if (predictions[indexOfPredictions].getCount() < word.getCount()) {
                        predictions[indexOfPredictions] = word;
                        break;
                    }
                }
            }
        }
        return predictions;
    }

}
