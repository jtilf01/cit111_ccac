/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects1;
import java.util.Random;
/**
 *
 * @author josht
 */
public class FoodLand {
    // establishing variables to determine amount of food consumed
    public static int donutRemaining;
    public static int burgerRemaining;
    public static int milkshakeRemaining;
    
    public static void main(String[] args){
        // calling each of the three food objects, beginning with donut
        System.out.println("Please enjoy this complimentary donut while\n" +
                "you make your burger and shake selection.");
        Donut compDonut1;
        compDonut1 = new Donut();
        compDonut1.name = "Toby";
        int bitesize = getBiteSize();
        eatDonut(compDonut1, bitesize);
        System.out.println(" ");
        
        // calling the burger object
        System.out.println("Now that you've enjoyed your appetizer, let's get your entree.");
        Burger burger1;
        burger1 = new Burger();
        bitesize = getBiteSize();
        eatBurger(burger1, bitesize);
        System.out.println(" ");
        
        // calling the milkshake object
        System.out.println("Great! Now you're going to need something to wash that down with.\n"
            + "Let's select a milkshake.");
        Milkshake shake1;
        shake1 = new Milkshake();
        bitesize = getBiteSize();
        drinkShake(shake1, bitesize);
        
        // summing up the meal
        System.out.println(" ");
        System.out.println("Now you've got your appetizer, your entree and your drink.");
        System.out.println("Enjoy your meal.");
        System.out.println(" ");
        mealResolution();
        
    } // closes main
    
    public static int eatDonut(Donut dobject, int bitesize){
        System.out.println("*You have decided to name your donut "
        + dobject.name + ".*");
        // bitesize limit can reflect very hungry to not so much
        dobject.simulateEating(bitesize);
        donutRemaining = dobject.getPercRemaining();
        return donutRemaining;
    } // closes eatDonut
    
    public static int eatBurger(Burger bobject, int bitesize){
        bobject.toppings();
        bobject.sizeFriesAndVeg();
        System.out.println("So you want a " + bobject.size + " burger with: ");
        if(bobject.pickles){
            System.out.println("Pickles");
        }
        if(bobject.onions){
            System.out.println("Onions");
        }
        if(bobject.lettuce){
            System.out.println("Lettuce");
        }
        if(bobject.tomato){
            System.out.println("Tomato");
        }
        if(bobject.ketchup){
            System.out.println("Ketchup");
        }
        if(bobject.mustard){
            System.out.println("Mustard");
        }
        if(bobject.mayo){
            System.out.println("Mayo");
        }
        if(bobject.cheese){
            System.out.println("Cheese");
        }
        if(bobject.fries){
            System.out.println("With a side of fries");
        }
        if(bobject.impossibleBurger){
            System.out.println("All on a vegetarian patty");
        }
        bobject.eatBurger(bitesize);
        burgerRemaining = bobject.remainingBurger();
        return burgerRemaining;
    } // closes eatBurger
    
    public static int drinkShake(Milkshake mobject, int bitesize){
        mobject.selectShake();
        System.out.println("That's a " + mobject.size + " " + mobject.flavor + "?");
        System.out.println("That shake comes with: ");
        if(mobject.sprinkles){
            System.out.println("Sprinkles");
        }
        if(mobject.cookieDough){
            System.out.println("Cookie Dough");
        }
        if(mobject.oreos){
            System.out.println("Oreos");
        }
        if(mobject.nuts){
            System.out.println("Nuts");
        }
        if(mobject.cake){
            System.out.println("Cake");
        }
        
        mobject.milkshakeDrank(bitesize);
        milkshakeRemaining = mobject.milkshakeRemaining();
        return milkshakeRemaining;
    } // closes drinkShake
    
    public static void mealResolution(){
        int totalConsumption = donutRemaining + burgerRemaining + milkshakeRemaining;
        double percentConsumed = (totalConsumption / 300.00) * 100.00;
        
        System.out.println("-------------------------------------------");
        System.out.println("You ate " + percentConsumed + "% of your meal.");
        if(percentConsumed > 85){
            System.out.println("Wow.  You were hungry.");
        }
        System.out.println("-------------------------------------------");
    }
    
    public static int getBiteSize(){
        // creating random variable to shake up bite sizes
        Random rand = new Random();
        int bitesize = rand.nextInt(100);
        return bitesize;
    }
} // closes class
