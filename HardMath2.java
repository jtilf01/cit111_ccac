/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;
import java.util.Scanner;
import java.util.Random;

/**
 * adding randomized problems to HardMath program
 * @author josht
 */
public class HardMath2 {
    public static void main(String[] args){
        // establishing random number range for simple integer math problems
        final int UPPER_MAX = 10;
        Random randGenerator = new Random();
        
        // providing user input capability
        Scanner userInput = new Scanner(System.in);
        
        // providing quiz question and answer attempt caps
        final int QUIZ = 4;
        int quizQuestion = 0;
        final int MAX_ATTEMPTS = 3;
        int attempt = 0;
        
        // establishing counter variables to track correct/incorrect answers
        int correctAnswer = 0;
        int incorrectAnswer = 0;
        
        // beginning of program
        System.out.println("*****MATH QUIZ: BASIC LEVEL*****");
        
        while(quizQuestion < QUIZ){
            quizQuestion += 1;
            System.out.println("Question number " + quizQuestion + ":");
            // utilizing randomizer to generate math integers
            int intA = randGenerator.nextInt(UPPER_MAX);
            int intB = randGenerator.nextInt(UPPER_MAX);
            // creating basic equation from integers
            int intC = intA + intB;
            
            System.out.println("Calculate " + intA + " + " + intB + " and enter your answer:");
            
            while(attempt < MAX_ATTEMPTS){
                // allows user to enter a different answer with each attempt
                int answer = userInput.nextInt();
                if(answer < intC){
                    System.out.println("Incorrect!  Your answer is too low.");
                } else if(answer > intC) {
                    System.out.println("Incorrect! Your answer is too high.");
                } else {
                    System.out.println("Correct!");
                    correctAnswer += 1;
                    if(quizQuestion < QUIZ){
                        System.out.println("*************************");
                        System.out.println("Next Question:");
                        attempt = 0;
                        break;
                    } // closes sub-if
                    else {
                        break;
                    }
                } // closes attempt if block
                attempt += 1;
                if(attempt >= MAX_ATTEMPTS){
                    incorrectAnswer += 1;
                    System.out.println("You have answered incorrectly too many times.");
                    System.out.println("The correct answer is: " + intC);
                    System.out.println("*************************");
                    System.out.println("Next Question:");
                    attempt = 0;
                    break;
                } // closes out of attempts if block
                
            } // closes attempt while block
        } // closes main while block
        System.out.println("Well done. You have completed the quiz.");
        System.out.println("You have answered " + correctAnswer + " questions out of " + QUIZ + " correctly.");
        
    } // closes main
    
} // closes class
