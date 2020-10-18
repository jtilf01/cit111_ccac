/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author josht
 */
public class Doors {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        
        System.out.println("*********     *********     *********");
        System.out.println("*  **   *     *  ***  *     * ***   *");
        System.out.println("*   *   *     * *   * *     *    *  *");
        System.out.println("*   *   *     *    *  *     * ***** *");
        System.out.println("*   *   *     *   *   *     *    *  *");
        System.out.println("*  ***  *     * ***** *     * ***   *");
        System.out.println("*********     *********     *********");
        System.out.println("Please enter the number of the door you wish to open.");
        int doorNum = input.nextInt();
        doorChoice(doorNum);
    } // closes main method
        // creating this method so that if an invalid door number is given 
        // the user is requested to choose again
        public static void doorChoice(int doorNum){
           switch (doorNum){
            case 1:
                rapidMath();
                break;
            case 2:
                String userName;
                System.out.println("What is your name? (First name only)");
                userName = input.next();
                nameLength(userName);
                break;
            case 3:
                numberGuesser();
                break;
            default:
                System.out.println("That is not a valid entry.  Please try again.");
                System.out.println("Select one of the doors to open: ");
                int tryAgain = input.nextInt();
                doorChoice(tryAgain);
        } // closes switch statement
    } // closes doorChoice method
        
        // The function of this method is to question the user with basic math problems.
        // If the user answers correctly the method loops again.  This keeps going until 
        // an incorrect answer is given.
        public static void rapidMath(){
            // the math problems are not predefined so a random number generator
            // is employed to supply the questions
            Random randNum = new Random();
            final int LIMIT = 10;
            int a = randNum.nextInt(LIMIT);
            int b = randNum.nextInt(LIMIT);
            int c = (a*a) + (b*b);
            System.out.println("What is " + a + " squared + " + b + " squared?");
            Scanner answer = new Scanner(System.in);
            int userAnswer = answer.nextInt();
            // if block compares user input with correct answer to determine next action
            if(userAnswer == c){
                System.out.println("Well done.  Next question: ");
                rapidMath();
            } else {
                System.out.println("That is incorrect.  Goodbye.");
                
            } // closes if
        } // closes rapidMath method
        
        //  This method simply takes the users name and displays
        // it's length.
        public static void nameLength(String userName){
            int nameLength = userName.length();
            System.out.println("Your name is " + nameLength + " letters long.");
        } //closes nameLength method
        
        // This method is simply a number guessing game with a limited number
        // of chances for the user to guess the number
        public static void numberGuesser(){
            Random randNum = new Random();
            final int UPPER_MAX = 10;
            int guessNum = randNum.nextInt(UPPER_MAX);
            System.out.println("I'm thinking of a number between 1 and " + UPPER_MAX);
            System.out.println("Can you guess what it is?  You have three tries.");
            int counter = 0;
            while(counter < 3){
                int userGuess = input.nextInt();
                counter += 1;
                if(userGuess == guessNum){
                    System.out.println("Wow! That's correct. You're a great guesser.");
                    break;
                } else if(counter >= 3){
                    System.out.println("Oh no. You're out of tries. You'll have to come back later.");
                } else if(userGuess != guessNum && counter < 3){
                    System.out.println("Nope. Sorry. Try again.");
                }
            } // closes while loop
            
        } // closes numberGuesser method
} // closes class
