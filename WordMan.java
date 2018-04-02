package edu.bsu.cs222;

import java.util.Scanner;

public class WordMan {

    Scanner words = new Scanner(System.in);
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

        Scanner scan = new Scanner(System.in);

        while(guessesLeft>0){
            char input= scan.next().charAt(0);

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
            }

            System.out.print(spaces);
            System.out.println("\t Number of guesses left: " + guessesLeft);
        }
        if(guessesLeft==0){
            System.out.println("GAME OVER");
        }
    }

}
