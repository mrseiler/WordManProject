package edu.bsu.cs222;

import java.util.Scanner;
import java.util.*;
import java.lang.Character;

public class WordMan {

    int guessesLeft = 7;
    Scanner scan = new Scanner(System.in);
    int player1Score = 0;
    int player2Score = 0;
    int turn = 0;

    Map<String, String> map = new HashMap<String, String>();

    FileReader filereader = new FileReader();
    String[] wordList = filereader.readArray("wordman");
    String[] definitionList = filereader.readArray("definitions");

    public void guess(String word, int guessesLeft) {

        char[] spaces = new char[word.length()];
        int i = 0;
        while( i < word.length()) {
            spaces[i] = '-';
            if(word.charAt(i) == ' ') {
                spaces[i] = ' ';
            }
            i++;
        }
        System.out.print(spaces);
        System.out.println("\t Number of guesses left: " + guessesLeft);

        Scanner scan = new Scanner(System.in);

        ArrayList<Character> list = new ArrayList<Character>();

        while(guessesLeft > 0){
            char input = scan.next().charAt(0);

            if(list.contains(input)) {
                System.out.print("You already guessed that letter");
                System.out.println("     Number of guesses left: " + guessesLeft);
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
                System.out.println("\nWINNER WINNER CHICKEN DINNER");
                System.out.println("The definition of " + word + " is " + map.get(word));
                if(turn == 0) {
                    player1Score++;
                    break;
                }
                else if(turn == 1) {
                    player2Score++;
                    break;
                }
                else {
                    break;
                }
            }

            System.out.print(spaces);
            System.out.println("\t Number of guesses left: " + guessesLeft);
        }
        if(guessesLeft==0){
            System.out.println("\nYOU LOSE");
            System.out.println("The word was: " + word);
            System.out.println("The definition of " + word + " is " + map.get(word));
        }
    }
    public void createMap() {
        for(int i = 0; i < wordList.length; i++) {
            map.put(wordList[i],definitionList[i]);
        }
    }

    public String randomWord() {
        Random rand = new Random();

        int r = rand.nextInt(wordList.length) + 1;
        String randomWord = wordList[r];
        return randomWord;
    }
    public void play() {

        System.out.println("How many players? (1 or 2)");
        int input = scan.nextInt();

        if(input == 1){
            guess(randomWord(), guessesLeft);
            if(playAgain() == true) {
                play();
            }
            else {
                System.exit(0);
                return;
            }
        }
        else if(input == 2) {
            withFriends();
        }
        else{
            System.out.println("Invalid Input");
            playAgain();
        }
    }
    public boolean playAgain() {

        System.out.println("Would you like to play again? (y or n)");
        char input = scan.next().charAt(0);

        if(input == 'y') {
            return true;
        }
        else if(input == 'n') {
            return false;
        }
        else {
            System.out.println("Invalid Input");
            playAgain();
        }
        return false;
    }

    public void withFriends() {

        if (turn == 0) {
            System.out.println("\nPlayer 1's Turn");
            guess(randomWord(), guessesLeft);
            turn = turn + 1;
            if (player1Score < 5) {
                System.out.println("Player 1's Score: " + player1Score);
                withFriends();
            }
            else if (player1Score == 5) {
                System.out.println("Player 1 Wins!!!");
            }
        }
        else if (turn == 1) {
            System.out.println("\nPlayer 2's Turn");
            guess(randomWord(), guessesLeft);
            turn = turn - 1;
            if (player2Score < 5) {
                System.out.println("Player 2's Score: " + player2Score);
                withFriends();
            }
            else if (player2Score == 5) {
                System.out.println("Player 2 Wins!!!");
            }
        }
    }
}
