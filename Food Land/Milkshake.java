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
public class Milkshake {
    public int percRemaining = 100;
    // variables for milkshake additional goodies
    public boolean sprinkles;
    public boolean cookieDough;
    public boolean oreos;
    public boolean nuts;
    public boolean cake;
    
    // variables for size and base flavor
    public String size; // small, medium, large
    public String flavor; // ChocoChoco, Like Grandma Used to Make, or Birthday Cake
    
    // setting up Scanner
    Scanner input = new Scanner(System.in);
    
    // obligatory percent consumed method
    public void milkshakeDrank(int percEaten){
        percRemaining = percRemaining - percEaten;
    } 
    
    public int milkshakeRemaining(){
        return percRemaining;
    }
    
    // method to quick pick shake and fillers
    public void selectShake(){
        System.out.println("Would you like the ChocoChoco, the Just-Like-Grandma's \n" 
            + "or the Birthday Cake milkshake? (c/g/b)");
        String custResponse = input.nextLine();
        if(custResponse.equals("c")){
            flavor = "ChocoChoco";
            sprinkles = false;
            cookieDough = false;
            oreos = true;
            nuts = false;
            cake = false;
        } else if(custResponse.equals("g")){
            flavor = "Just-Like-Grandma's";
            sprinkles = false;
            cookieDough = true;
            oreos = false;
            nuts = true;
            cake = false;
        } else {
            flavor = "Birthday Cake";
            sprinkles = true;
            cookieDough = false;
            oreos = false;
            nuts = false;
            cake = true;
        }
        System.out.println("And how big will that be? (s/m/l)");
        custResponse = input.nextLine();
        if(custResponse.equals("s")){
            size = "Small";
        }
        if(custResponse.equals("m")){
            size = "Medium";
        } else {
            size = "Large";
        }
    } // close selectShake
} // close class
