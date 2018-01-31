import java.util.ArrayList;

/**
 * Created by Lior on 1/30/2018.
 */
public class Node extends Bucket {

    private ArrayList<Bucket> buckets;

    Node(String pref) {
        super(pref);
        this.buckets = new ArrayList<>();
    }


    //Finds the correct child for prefix and ask him to give predictions
    @Override
    protected Word[] search(String prefix) {
        for(Bucket bucket : buckets){
            if (prefix.startsWith(bucket.getPref())){
                return bucket.getPredictions(prefix);
            }
        }
        return new Word[3];
    }

    @Override
    public Word insert(String word) {
        //Inserts word to my correct child (if not exists yet, create and insert)
        Bucket b = getBucket(word);
        if(b == null){
            char nextChar = word.charAt(pref.length() + 1); //child for this node prefix and the next letter of the word
            b = new Leaf(pref + nextChar);
            buckets.add(b);
        }
        return b.insert(word);
    }

    //Finds the correct bucket for pref. If not exists, returns null.
    private Bucket getBucket(String pref){
        for(Bucket bucket : buckets){
            if (pref.startsWith(bucket.getPref())){
                return bucket;
            }
        }
        return null;
    }


}
