package edu.bsu.cs222;

import java.util.Scanner;
import java.util.*;

public class WordMan {

    Scanner words = new Scanner(System.in);

    public void guess(String word, int guessesLeft) {

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

        Scanner scan = new Scanner(System.in);

        ArrayList<Character> list = new ArrayList<Character>();

        while(guessesLeft>0){
            char input= scan.next().charAt(0);

            if(list.contains(input)) {
                System.out.println("You already guessed that letter");
                continue;

            }

            list.add(input);

            if(word.contains(input + "")) {
                for(int j=0; j < word.length(); j++) {
                    if(word.charAt(j) == input) {
                        spaces[j] = input;
                    }
                }
            }
            else {
                guessesLeft--;
            }
            if(word.equals(String.valueOf(spaces))){
                System.out.println(spaces);
                System.out.println("WINNER WINNER CHICKEN DINNER");
                break;
            }

            System.out.print(spaces);
            System.out.println("\t Number of guesses left: " + guessesLeft);
        }
        if(guessesLeft==0){
            System.out.println("GAME OVER");
        }
    }

}
