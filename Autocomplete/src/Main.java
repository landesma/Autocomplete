import java.util.*;

/**
 * Created by Lior on 1/30/2018.
 */
public class Main {

    public static void main(String[] args) {

        String fileName = "Autocomplete/src/word-list-short-52.txt";
        //Create
        AutoCompleter ac = new AutoCompleter(fileName);
        //Interact with user.
        Scanner sc = new Scanner(System.in);

        while (true) {
            String word = sc.next();
            if (Objects.equals("", word)) {
                break;
            }

            System.out.println("Please choose");
            printPredictions(ac.completePrefix(word));  //suggests words to user

            //get users choice and validate it
            char ch = sc.next().charAt(0);
            while(!(Character.isDigit(ch) &&  Character.getNumericValue(ch) <=2 && Character.getNumericValue(ch) >=0)){
                System.out.println("Choice is not valid, please choose again");
                ch = sc.next().charAt(0);
            }

            //For better predictions in the future
            ac.updateChoice(Character.getNumericValue(ch), word);
        }
    }

    private static void printPredictions(Word[] predictions){
        for (int i = 2; i >= 0; i--) {
            if (predictions[2-i] != null) {
                System.out.println(Integer.toString(2-i) + " - " + predictions[i].getWord());
            }
        }
    }




}
