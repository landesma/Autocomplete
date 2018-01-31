/**
 * Created by Lior on 1/30/2018.
 */
public class Word {

    private String word;
    private int count;


    public Word(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void setCount(int newCount){
        count = newCount;
    }

    //In the default method count would be checked too.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Word)) {
            return false;
        }
        Word other = (Word) obj;
        return word.equals(other.word);
    }
}
