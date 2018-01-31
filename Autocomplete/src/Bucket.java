/**
 * Created by Lior on 1/30/2018.
 */
public abstract class Bucket {

    protected String pref;
    protected Word[] topThree;

    Bucket(String pref) {
        this.pref = pref;
        this.topThree = createEmptyPredictions();
    }

    public Word[] createEmptyPredictions(){

        Word[] predictions = new Word[3];
        for(int i=0;i<3;i++){
            predictions[i] = new Word("");
            predictions[i].setCount(0);
        }
        return predictions;
    }


    public String getPref() {
        return pref;
    }

    public Word[] getPredictions(String prefix) {
        //if prefix is exactly my prefix, I can simply return my top three words.
        if (prefix.equals(pref)) {
            return topThree;
        } else {
            //Ask my children (could be a node or a leaf)
            return search(prefix);
        }
    }


    //Checks if a candidate count is higher than one of the words in topThree.
    //if so, replace it.
    protected void updateTopThree(Word candidate) {

        if(!contains(candidate)) {
            int minWeight = Integer.MAX_VALUE;
            int indexOfMin = -1;

            for (int i = 0; i < 3; i++) {
                if (topThree[i].getCount() < minWeight) {
                    minWeight = topThree[i].getCount();
                    indexOfMin = i;
                }
            }

            if (candidate.getCount() > minWeight) {
                topThree[indexOfMin] = candidate;

            }

        }

    }

    private boolean contains(Word candidate) {
        for(int i = 0; i < 3; i ++){
            if(topThree[i] != null && topThree[i].equals(candidate)){
                return true;
            }
        }
        return false;
    }

    protected abstract Word insert(String word);
    protected abstract Word[] search(String prefix);

}
