package edu.bsu.cs222;

import java.util.Scanner;

public class WordMan {

    Scanner scan = new Scanner(System.in);
    final int guessesLeft = 10;

    static public void guess(String word, int guessesLeft) {

        char[] spaces = new char[word.length()];
        int i = 0;
        while( i < word.length()) {
            spaces[i] = '_';
            if(word.charAt(i) == ' ') {
                spaces[i] = ' ';
            }
            i++;
        }
        System.out.print(spaces);
        System.out.println("\t Number of guesses left: " + guessesLeft);
    }

}
