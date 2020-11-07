/**********************************************
Workshop #4
Course:     JAC444 - 2020Fall
Last Name:  Xie
First Name: Yushi
ID:         142358167
Section:    NCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:       18-Oct-2020
**********************************************/


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        boolean nonstop = true;
        Scanner input = new Scanner(System.in);
        while(nonstop)
        {
            System.out.println("\n********** Let's start a hangman game!!! **********");
            /* read file */
            FileHelper hangmanFile = new FileHelper("hangman.txt");
            ArrayList <String> dictionary = hangmanFile.readFile();

            /* get word */
            int totalwords = dictionary.size();
            int rdmPosition = (int) ((Math.random() * totalwords));
            String rdmWord = dictionary.get(rdmPosition);

            /* start game */
            HangManGame hangmanGame = new HangManGame(rdmWord);
            hangmanGame.PlayThisGame();

            /* write in file */
            System.out.print("Please enter a new word to be added to our hangman dictionary: ");
            String newWord = input.next();
            hangmanFile.wirteTofile(newWord);

            /* start a new game? */
            System.out.print("Do you want to start another game? You answer: ");
            String yourAnswer = input.next();
            if(yourAnswer.charAt(0) == 'n')
            {
                nonstop = false;
            }
        };

        System.out.println("\n********** Let's count the letter occurrences in a document!!! **********");
        System.out.print("Please enter a document name (with extention): ");
        /* read file */
        String letterCountFileName = input.next();
        FileHelper letterCountFile = new FileHelper(letterCountFileName);
        ArrayList <String> countLetter = letterCountFile.readFile();

        /* count letters */
        String t = "";
        for (int i = 0; i < countLetter.size(); i++)
        {
            t += countLetter.get(i);
        }

        LetterCounter LC = new LetterCounter(t);
        LC.countAllLetterOccur();

        input.close();
    }
}
