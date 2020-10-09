/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.util.Scanner;

/**
 *
 * @author josht
 */
public class BeFriends {
    public static void main(String[] args){
        
        // setting up scanner to take in user input
        Scanner userInput = new Scanner(System.in);
        int answer;
        int subAnswer;
        
        // establishing base scores and counter to measure friend-ability 
        final int BESTFRIENDS = 160;
        final int FRIENDS = 125;
        final int ACQUAINTANCES = 100;
        int friendCounter = 0;
        int qCounter = 0;
        
        System.out.println("**********************************************");
        System.out.println("*             CAN WE BE FRIENDS?             *");
        System.out.println("**********************************************");
        System.out.println("  ");
        System.out.println("Please answer the following questions to determine if we can be friends.");
        System.out.println("You do want to be friends, don't you?");
        
        while(qCounter < 5){
            qCounter += 1;
            System.out.println(" ");
            System.out.println("Question " + qCounter +":");
            System.out.println("Remeber: 0 = no, 1 = yes");
            if(qCounter == 1){
                System.out.println("Do you have a sense of humor?");
                answer = userInput.nextInt();
                if(answer == 0){
                    System.out.println("Hmm, interesting.");
                    friendCounter -= 15;
                } else if(answer == 1) {
                    System.out.println("So do I!");
                    friendCounter += 30;
                    System.out.println("Do you like stand up or something more collaborative like a sitcom?");
                    System.out.println("0 = Standup; 1 = Collaborative comedy");
                    subAnswer = userInput.nextInt();
                    if(subAnswer == 0){
                        System.out.println("Me too!");
                        friendCounter += 20;
                    } else {
                        System.out.println("Yeah, that's good.");
                        friendCounter += 10;
                    }
                } else {
                    System.out.println("You did not enter a valid option.");
                }
            } // closes q1 if
            else if(qCounter == 2){
                System.out.println("Do you like indian food?");
                answer = userInput.nextInt();
                if(answer == 0){
                    System.out.println("Fascinating.");
                    friendCounter -= 15;
                } else if(answer == 1){
                    System.out.println("Get out of town! Me too!");
                    friendCounter += 15;
                } else {
                    System.out.println("You must enter a 0 or 1.");
                }
                System.out.println("Do you like Mexican food?");
                subAnswer = userInput.nextInt();
                if(subAnswer == 0){
                    System.out.println("I see");
                    friendCounter -= 10;
                } else if(subAnswer == 1){
                    System.out.println("Me too!");
                    friendCounter += 10;
                    System.out.println("Do you like your food with a lot of spicy heat?");
                    int subSubAnswer = userInput.nextInt();
                    if(subSubAnswer == 0){
                        System.out.println("That's cool.");
                    } else if(subSubAnswer == 1){
                        System.out.println("That's awesome!");
                        friendCounter += 10;
                    }
                } else {
                    System.out.println("You must enter a 0 or 1.");
                }
            } // closes q2 if
            else if(qCounter == 3){
                System.out.println("Do you like philosophy and science?");
                answer = userInput.nextInt();
                if(answer == 0){
                    System.out.println("Fair enough.");
                } else if(answer == 1){
                    System.out.println("Me too!");
                    friendCounter += 30;
                    System.out.println("Do you like physics?");
                    subAnswer = userInput.nextInt();
                    if(subAnswer == 0){
                        System.out.println("To each their own.");
                    } else if(subAnswer == 1){
                        friendCounter += 15;
                        System.out.println("Me too!");
                        System.out.println("Do you like to ponder the big questions?");
                        int subSubAnswer = userInput.nextInt();
                        if(subSubAnswer == 0){
                            System.out.println("Interesting.");
                        } else if(subSubAnswer == 1){
                            System.out.println("Bigger is better, I say.");
                            friendCounter += 15;
                        } else {
                            System.out.println("You must enter a 0 or 1.");
                        }
                    } else {
                        System.out.println("You must enter a 0 or 1.");
                    }
                } else {
                    System.out.println("You must enter a 0 or 1.");
                }
            } // closes q3 if
            else if(qCounter == 4){
                System.out.println("Do you like soccer?");
                answer = userInput.nextInt();
                if(answer == 0){
                    System.out.println("Not a sports person, eh?");
                } else if(answer == 1){
                    System.out.println("Ain't nothing like a good game of footie, amirite?");
                    friendCounter += 10;
                    System.out.println("Do you prefer to watch the game or play it?");
                    System.out.println("0 = watch; 1 = play");
                    subAnswer = userInput.nextInt();
                    if(subAnswer == 0){
                        System.out.println("I can respect that.");
                    } else if(subAnswer == 1){
                        System.out.println("I'm a player myself.");
                        friendCounter += 10;
                    } else{
                        System.out.println("You must enter a 0 or 1.");
                    }
                } else{
                    System.out.println("You must enter a 0 or 1.");
                }
            } // closes q4 if
            else if(qCounter == 5){
                System.out.println("Do you like board games?");
                answer = userInput.nextInt();
                if(answer == 0){
                    System.out.println("Ok.");
                } else if(answer == 1){
                    System.out.println("Me too!");
                    friendCounter += 10;
                    System.out.println("Do you like to play traditional board games like Monopoly, ");
                    System.out.println("or more modern niche games like The Red Dragon Inn?");
                    System.out.println("0 = Monopoly; 1 = The Red Dragon Inn; 2 = I've never heard of The Red Dragon Inn but it sounds awesome.");
                    subAnswer = userInput.nextInt();
                    if(subAnswer == 0){
                        System.out.println("It is a classic.");
                    } else if(subAnswer == 1){
                        System.out.println("Me too!");
                        friendCounter += 10;
                    } else if(subAnswer == 2) {
                        System.out.println("I see you have the heart of an adventurer!");
                        friendCounter += 15;
                    }
                    else {
                        System.out.println("You must enter a 0 or 1.");
                    }
                } else {
                    System.out.println("You must enter a 0 or 1.");
                }
            } // closes q5 if
        } // closes primary while
        System.out.println("FRIEND SCORE = " + friendCounter);
        System.out.println("Well, that's the questionaire.  Based on the results I can see that you and I will be: ");
        if(friendCounter >= ACQUAINTANCES){
            if(friendCounter >= FRIENDS){
                if(friendCounter >= BESTFRIENDS){
                    System.out.println("Best Friends, obviously!");
                }
                else
                    System.out.println("Friends.");
            }
            else
                System.out.println("Just acquaintances.");
        } else {
            System.out.println("Better off going our separate ways.");
        } // closes score tally if
        
    } // closes main
    
} //  closes class
