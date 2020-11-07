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



public class LetterCounter {
    private String someString;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public LetterCounter() {
    }

    public LetterCounter(String someString) {
        setSomeString(someString);
    }

    public void countAllLetterOccur () {
        String Alph = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        for(int i = 0; i < Alph.length(); i++)
        {
            char thisLetter = Alph.charAt(i);
            long Letter = getSomeString().chars().filter(ch -> ch == thisLetter).count();
            System.out.println("Number of " + thisLetter + "'s: " + Letter);
        }
    }
}
