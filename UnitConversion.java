/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;
import java.util.Scanner;

/**
 * This program will help do quick unit conversion for frequently converted units
 * we want to convert Farenheit into Celcius, miles into kilometers, and pounds into kilograms
 * @author josht
 */
public class UnitConversion {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("If you're an American and you want to travel to any other part of the world");
        System.out.println("you'll need to do a few quick conversion if you want to fit in.");
        System.out.println("This conversion program will help do that work for you.");
        System.out.println("So let's start with a few questions.");
        System.out.println(" ");
        System.out.println("First, what's the temperature outside right now?");
        double fTemp = userInput.nextDouble();
        double returnedTemp = convertFtoC(fTemp);
        System.out.println("Wrong!  You probably entered the temperature in Farenheit.  In the rest of the world ");
        System.out.println("we would say that it is " + returnedTemp + " degrees Celcius outside.");
        System.out.println(" ");
        System.out.println("Now, how many miles away do you live from your place of employment?");
        double miles = userInput.nextDouble();
        double returnedDist = convertMilesToKilometers(miles);
        System.out.println("That's great.  But in the rest of the world we would say that you live " + returnedDist + " kilometers");
        System.out.println("away from where you work.");
        System.out.println(" ");
        System.out.println("Finally, how much do you weigh?");
        double pounds = userInput.nextDouble();
        double returnedWeight = convertPoundsToKilos(pounds);
        System.out.println("Oh, so close.  You probably entered your weight in pounds, but in actuality");
        System.out.println("you weigh " + returnedWeight + " kilograms.");
        System.out.println(" ");
        System.out.println("Now don't you feel just a bit more well-traveled?");
    } // closes main method
    
    public static double convertFtoC(double fTemp){
        // the formula to convert farenheit to celcius is (F-32)/1.8=C
        double returnedTemp = ((fTemp - 32) / 1.8);
        return returnedTemp;
    } // closes temp conversion method
    
    public static double convertMilesToKilometers(double miles){
        // the formula to convert miles to kilometers is (miles/5)*8=km
        double returnedDist = (miles/5)*8;
        return returnedDist;
    } // closes distance conversion method
    
    public static double convertPoundsToKilos(double pounds){
        // the formula to convert pounds to kilograms is lb*0.45359237=kg
        double returnedWeight = pounds * 0.45359237;
        return returnedWeight;
    } // closes weight conversion method
} // closes class
