/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import java.util.Random;

/**
 *
 * @author User
 */
public class GameUtil {
    static List<String> sentences;
    static String sentence;
    public static StringBuilder sentenceToShow;
    public static int numOfTryings;
    
    static{
        sentences.add("good luck");
        sentences.add("hello everyone");
        sentences.add("chani benziman");
        sentences.add("computer programming");
        
        chooseSentence();
        initSentenceToShow();
    }
    public static void chooseSentence() {
        Random rand = new Random();
        int index = rand.nextInt(sentences.size());
        sentence = sentences.get(index);
    }

    public static void initSentenceToShow() {
        sentenceToShow = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                sentenceToShow.append(' ');
            } else {
                sentenceToShow.append('-');
            }
        }
    }
    public static void updateSentenceToShow(char letter) {
    for (int i = 0; i < sentence.length(); i++) {
       if (sentence.charAt(i) == letter) {
            sentenceToShow.setCharAt(i, letter);
        }
    }
}
    public static void increaseNumOfTryings(){
        numOfTryings++;
    }
    public static  boolean checkWinning(){
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) =='-'){
                return false;
            }
        }
        return true;
    }

    
}
