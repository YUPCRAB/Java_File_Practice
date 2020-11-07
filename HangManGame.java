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



import java.util.Scanner;

public class HangManGame {
    private String AWord;

    public String getAWord() {
        return AWord;
    }

    public void setAWord(String aWord) {
        AWord = aWord;
    }

    public HangManGame() {
    }

    public HangManGame(String aWord) {
        AWord = aWord;
    }

    public void PlayThisGame() {
        String s = "*";
        int missed = 0;
        int lenOfWord = getAWord().length();
        String startWord = new String(new char[lenOfWord]).replace('\0', '*');
        StringBuilder gusdWord = new StringBuilder(startWord);
        StringBuilder gusdLetter = new StringBuilder();
        Scanner input = new Scanner(System.in);
        while(gusdWord.indexOf(s) != -1) /* if there are still any "*" in guessed word */
        {
            System.out.print("Word: " + gusdWord + "\nTake a guess and enter a letter please: ");
            
            String nextChar = input.next();
            if(getAWord().indexOf(nextChar) != -1) /* if input is correct */
            {
                if(gusdWord.indexOf(nextChar) != -1)
                {
                    System.out.println(nextChar + " is already in the word. Please take a guess with another letter.");
                }
                else
                {
                    int p = getAWord().indexOf(nextChar); /* find first position */
                    while((p < lenOfWord) && (p != -1)) /* when first occurance is not at the last position && still has another occurance */
                    {
                        gusdWord.setCharAt(p, nextChar.charAt(0));
                        p = getAWord().indexOf(nextChar, p+1);
                    }
                }
            }
            else
            {
                if(gusdLetter.indexOf(nextChar) == -1) /* if input has not been guesses before */
                {
                    System.out.println(nextChar + " is not in the word. Please try again.\n");
                    gusdLetter.append(nextChar);
                    missed++;
                }
                else
                {
                    System.out.println("You already tried " + nextChar + " and it's not in the word. Please try another letter.\n");
                }
            }        
        }
        
        if(missed == 0 || missed == 1)
        {
            System.out.println("\nThe word is " + getAWord() + ". You missed " + missed + " time. WOW Amazing!");
        }
        else if(missed > 1 && missed <= 5)
        {
            System.out.println("\nThe word is " + getAWord() + ". You missed " + missed + " times. Good Job!");
        }
        else
        {
            System.out.println("\nThe word is " + getAWord() + ". You missed " + missed + " times.");
        }
    }
}
