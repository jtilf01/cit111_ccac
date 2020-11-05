/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekB1_scope;
import java.util.Scanner;
import java.util.Random;

/**
 * This program simulates a small food shack that might be found on a Californian beach.
 * The food shack specializes in seafood, selling two main dishes - fish and chips and 
 * shrimp scampi.  
 * @author josht
 */
public class PointOfSail {
    // We'll need to tally our orders and make them accessible to all methods 
    // so that we can use the display method to display them to the console
    static double totalFishOrder = 0;
    static double totalShrimpOrder = 0;
    static double totalMoneyEarned = 0;
    // We'll also make the prices available to all methods so that they can be 
    // easily changed if we so desire.
    final static double FISHPRICE = 6.50;
    final static double SHRIMPPRICE = 7.25;
    // And we'll need to factor in the tax
    final static double TAXRATE = 0.07;
    
    public static void main(String[] args){
        // Since I'm looping back to the beginning anytime there is a new customer
        // I really don't want much to be happening in the main method.  We're really
        // just using this to get our loop started.
        orderUp();
    } // closes main
    
    public static void orderFish(double fishAmount, double shrimpAmount){
        System.out.println("The fish was freshly caught today.  How many would you like?");
        Scanner input = new Scanner(System.in);
        double quantity = input.nextDouble();
        totalFishOrder = totalFishOrder + quantity;
        // if customer ultimately orders shrimp as well, we'll need to track both
        // fish and shrimp quantities to carry over into the other relevant methods
        double nonFishOrder = shrimpAmount;
        double fishOrder = quantity;
        if(quantity <= 3){
            System.out.println("Copy that. " + quantity + " orders of Fish and Chips coming right up.");
            System.out.println("Is there anything else I can get you today?");
            String answer = input.next();
            if(answer.equals("yes") || answer.equals("y")){
                orderShrimp(fishOrder, nonFishOrder);
            } else{
                displayTotals(fishOrder, nonFishOrder);
            }
        } else {
            System.out.println("Whoa!  Feeding a family today I see.");
            System.out.println("No problem. We got " + quantity + " orders of Fish coming your way.");
            System.out.println("Would you like to order any else with that?");
            String answer = input.next();
            if(answer.equals("yes") || answer.equals("y")){
                orderShrimp(fishOrder, nonFishOrder);
            } else{
                displayTotals(fishOrder, nonFishOrder);
            }
        }
    } // closes Fish and Chips order method
    
    public static void orderShrimp(double fishAmount, double shrimpAmount){
        System.out.println("Going with the shellfish?  Nice.  How many will it be?");
        Scanner input = new Scanner(System.in);
        double quantity = input.nextDouble();
        totalShrimpOrder = totalShrimpOrder + quantity;
        // if the customer ultimately orders the fish as well, we'll need to track 
        // both fish and shrimp orders to carry these quantities over to the other
        // relevant methods
        double nonShrimpOrder = fishAmount;
        double shrimpOrder = quantity;
        if(quantity <= 3){
            System.out.println("You got it, dude. " + quantity + " orders of shrimp coming your way.");
            System.out.println("Is there anything else I can get you today?");
            String answer = input.next();
            if(answer.equals("yes") || answer.equals("y")){
                orderFish(nonShrimpOrder, shrimpOrder);
            } else{
                displayTotals(nonShrimpOrder, shrimpOrder);
            }
        } else {
            System.out.println("I see somebody loves those little shrimpies!");
            System.out.println("No problem. Get ready to pound down " + quantity + " orders of shrimp scampi.");
            System.out.println("Would you like to order any else with that?");
            String answer = input.next();
            if(answer.equals("yes") || answer.equals("y")){
                orderFish(nonShrimpOrder, shrimpOrder);
            } else{
                displayTotals(nonShrimpOrder, shrimpOrder);
            }
        }
    } // closes Shrimp Scampi order method
    
    public static void displayTotals(double fishAmount, double shrimpAmount){
        double subtotal = (fishAmount * FISHPRICE)+(shrimpAmount * SHRIMPPRICE);
        double total = subtotal * (1 + TAXRATE);
        totalMoneyEarned = totalMoneyEarned + total;
        System.out.println("***CUSTOMER ORDER INFORMATION***");
        System.out.println("Fish ordered: " + fishAmount);
        System.out.println("Shrimp ordered: " + shrimpAmount);
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("********************************");
        System.out.println(" ");
        // We want to determine if another customer is in line and if so, we want 
        // to start the order process over again.  If not, we want to display business
        // totals to account for all the transactions of the day.  To determine if 
        // another customer is in line, we'll use a randomized value.
        Random randValue = new Random();
        // the upper value of the randomly generated number gives us a slightly
        // greater chance of having another customer in line than not
        int anotherCust = randValue.nextInt(3);
        if(anotherCust >= 1){
            orderUp();
        } else {
           System.out.println(" ");
            System.out.println("***BUSINESS DAILY TOTAL TRACKER***");
            System.out.println("Total fish dishes sold: " + totalFishOrder);
            System.out.println("Total shrimp dishes sold: " + totalShrimpOrder);
            System.out.println("Total money earned: $" + String.format("%.2f", totalMoneyEarned));
            System.out.println("**********************************"); 
        }
    }// closes console display method
    
    // creating this method to keep the main simple and clean
    public static void orderUp(){
        System.out.println("********MENU*********");
        System.out.println("Fish and Chips: " + FISHPRICE);
        System.out.println("Shrimp Scampi: " + SHRIMPPRICE);
        System.out.println("*********************");
        System.out.println("Welcome to Point of Sail Seafood Shack!");
        System.out.println(" ");
        // Introducing a random variable here to provide a way of keeping the 
        // dialogue in the program from getting too monotonous. 
        Random rand = new Random();
        // The randomly generated integer will be between 0 and 2, providing an 
        // option of three randomized greetings
        int greeting = rand.nextInt(3);
        switch(greeting){
            case 0:
                System.out.println("Like, what can I get you, dude?");
                break;
            case 1:
                System.out.println("Waves sure are righteous today, you know?  Anyway, what'll it be, my man/lady?");
                break;
            case 2:
                System.out.println("May I, like, take your order or something?");
                break;
        } // close switch statement
        // initalize scanner element
        Scanner input = new Scanner(System.in);
        String custOrder = input.nextLine();
        // no orders quantities have been given yet so we need to establish a baseline
        // quantity so that we can call the order methods with the appropriate variables
        // required by these methods
        double fishAmount = 0;
        double shrimpAmount = 0;
        if(custOrder.equals("fish") || custOrder.equals("Fish") || 
                custOrder.equals("fish and chips") || custOrder.equals("Fish and Chips")){
            orderFish(fishAmount, shrimpAmount);
        } else if(custOrder.equals("shrimp") || custOrder.equals("Shrimp") || 
                custOrder.equals("shrimp scampi") || custOrder.equals("Shrimp Scampi")){
            orderShrimp(fishAmount, shrimpAmount);
        }
        
    } // closes order dialogue method
    
} // closes class
