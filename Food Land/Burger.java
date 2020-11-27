/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects1;
import java.util.Scanner;

/**
 *
 * @author josht
 */
public class Burger {
    // logistic variables
    public int percRemaining = 100;
    public String size; // small, medium, or large
    
    // toppings
    public boolean pickles;
    public boolean onions;
    public boolean lettuce;
    public boolean tomato;
    public boolean ketchup;
    public boolean mustard;
    public boolean mayo;
    public boolean cheese;
    
    // side of fries
    public boolean fries;
    
    // vegetarian option
    public boolean impossibleBurger;
    
// scanner object for user input
    Scanner input = new Scanner(System.in);
    
    public void eatBurger(int percEaten){
        // random % bite sizes limited to 12%
        percRemaining = percRemaining - percEaten;
    } // close eatBurger
    
    public int remainingBurger(){
        return percRemaining;
    } // closes remainingBurger
    
    public void toppings(){
        System.out.println("What would you like on your burger? (y/n)");
        System.out.println("Pickles?");
        String custResponse = input.nextLine();
        if(custResponse.equals("n")){
            pickles = false;
        }else{
            pickles = true;
        }
        System.out.println("Onions?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            onions = false;
        }else{
            onions = true;
        }
        System.out.println("Lettuce?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            lettuce = false;
        }else{
            lettuce = true;
        }
        System.out.println("Tomatoes?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            tomato = false;
        }else{
            tomato = true;
        }
        System.out.println("Ketchup?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            ketchup = false;
        }else{
            ketchup = true;
        }
        System.out.println("Mustard?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            mustard = false;
        }else{
            mustard = true;
        }
        System.out.println("Mayo?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            mayo = false;
        }else{
            mayo = true;
        }
        System.out.println("Cheese?");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            cheese = false;
        }else{
            cheese = true;
        }
    } // closes toppings
    
    public void sizeFriesAndVeg(){
        System.out.println("What size of meal would you like? (s/m/l)");
        String custResponse = input.nextLine();
        if(custResponse.equals("s")){
            size = "Small";
        } else if(custResponse.equals("m")){
            size = "Medium";
        } else {
            size = "Large";
        }
        System.out.println("Would you like fries with that? (y/n)");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            fries = false;
        }else{
            fries = true;
        }
        System.out.println("Would you like to make that vegetarian? (y/n)");
        custResponse = input.nextLine();
        if(custResponse.equals("n")){
            impossibleBurger = false;
        }else{
            impossibleBurger = true;
        }
    }
    
} // closes class
