import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main{

    //a list of all possible 5 letter words in English
//    public static HashSet<String> dictionary = new HashSet<>();

    //a smaller list of words for selecting the target word from (i.e. the word the player needs to guess)
//    public static ArrayList<String> targetWords = new ArrayList<>();

    public static void main(String[] args) {
        //load in the two word lists
//        try{
//            Scanner in_dict  = new Scanner(new File("gameDictionary.txt"));
//            while(in_dict.hasNext()){
//                dictionary.add(in_dict.next());
//            }
//
//            Scanner in_targets = new Scanner(new File("targetWords.txt"));
//            while(in_targets.hasNext()){
//                targetWords.add(in_targets.next());
//            }
//            in_dict.close();
//            in_targets.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        new Wordle();
    }

    //use this method for selecting a word. It's important for marking that the word you have selected is printed out to the console!
//    public static String getTarget(){
//        Random r = new Random();
//        String target = targetWords.get(r.nextInt(targetWords.size()));
//        //don't delete this line.
//        System.out.println(target);
//        return target;
//    }
}
