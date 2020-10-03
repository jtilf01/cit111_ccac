/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

/**
 *
 * @author josht
 */
public class RoadTrip {
    public static void main(String[] args){
        
        final double NEDS_MILES_PER_GALLON = 32.0;
        final double AVERAGE_GAS_PRICE = 2.65;
        
        // declaring and intializing variables
        String carMake = "1996 Mazda Protege";
        String carName = "Nedfry";
        int maxPassengers = 5; // primitive typ variable
        int currentNumberOfPassengers = 1;
        boolean carFull = false;
        double tripOdomter = 0.0;
        double cashOnHand = 300.00;
        double distanceToMoabUtah = 1806.0;
        boolean destinationReached = false;
        
        double legDistance; // declaring this variable but no intializing
        
        // simulation of the roadtrip
        System.out.println("***Road trip simulator***");
        System.out.println("--> Beginning of trip stats <--");
        System.out.println("Make of car: " + carMake + " that can carry: " + maxPassengers);
        System.out.println("Ther car's name is " + carName);
        System.out.println("Distance To Destination: " + distanceToMoabUtah);
        System.out.println("Full Car? " + carFull + "; Current odometer: " + tripOdomter);
        System.out.println("I have $" + cashOnHand + " to spend on this trip");
        System.out.println("Starting trip with " + currentNumberOfPassengers + " Passenger");
        System.out.println("Destination Reached? " + destinationReached);
        System.out.println("************************************************");
        System.out.println();
        System.out.println("Beginning leg 1:");
        //Calculate leg distance: 25% of total trip, stor in legDistance
        double decimalOfOneQuarter = .25;
        legDistance = distanceToMoabUtah * decimalOfOneQuarter;
        System.out.println("CHECK LEG DISTACE: " + legDistance);
        
        //increment trip odometer by leg distance, over-write odometer
        tripOdomter = tripOdomter + legDistance;
        
        //subtract leg distance from distanceTo destination, over-write distance
        distanceToMoabUtah = distanceToMoabUtah - legDistance;
        
        //"see" hitch hiker heading West
        System.out.println("Oh, look! A person who wants to go west, too!");
        
        //Check if there is room in the car, if so, pick up hitch hiker
        if(carFull == false){
            System.out.println("Car is not full, picking up hitcher");
            currentNumberOfPassengers = currentNumberOfPassengers + 1;
            // alternative shorter version currentnumberOfPassengers++
            
        } // closes if()
        
        //calculate price of gas for first leg and store in temp variable
        // gas price = (distance / milesPerGallon) * price per gallon
        double gasPriceForLeg = (legDistance / NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        
        //deduct $ spent on gas from money remaining and over-write tripBudget
        cashOnHand = cashOnHand - gasPriceForLeg;
        
        //reprint status of variables to the console
        
        System.out.println();
        System.out.println("****Variable stats at the end of leg 1****");
        System.out.println("Distance To Destination: " + distanceToMoabUtah);
        System.out.println("Full Car? " + carFull + "; Current odometer: " + tripOdomter);
        System.out.println("I have $" + cashOnHand + " to spend on this trip");
        System.out.println(currentNumberOfPassengers + " Passengers in car");
        System.out.println("Destination Reached? " + destinationReached);
        
        // Beginning of next leg of the trip
        System.out.println();
        System.out.println("Beginning leg 2:");
        double leg2Dist = 500.0;
        System.out.println("Planned travel distance for this leg: " + leg2Dist);
        System.out.println("Another couple of wayward westbound wanderers.");
        if(carFull == false){
            System.out.println("The more the merrier, I say.");
            currentNumberOfPassengers = currentNumberOfPassengers + 2;
            if(currentNumberOfPassengers >= 5){
                carFull = true;
            }
        }
        double leg2GasPrice = (leg2Dist/NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        System.out.println("The cost of fuel for this leg is $" + leg2GasPrice);
        System.out.println();
        System.out.println("****Variable stats at the end of leg 2****");
        distanceToMoabUtah = distanceToMoabUtah - leg2Dist;
        System.out.println("Distance To Destination: " + distanceToMoabUtah);
        tripOdomter = tripOdomter + leg2Dist;
        System.out.println("Full Car? " + carFull + "; Current odometer: " + tripOdomter);
        cashOnHand = cashOnHand - leg2GasPrice;
        System.out.println("I have $" + cashOnHand + " to spend on this trip");
        System.out.println(currentNumberOfPassengers + " Passengers in car");
        System.out.println("Destination Reached? " + destinationReached);
        
        System.out.println();
        System.out.println("Beginning final leg of trip:");
        System.out.println("Planned distance for this leg: " + distanceToMoabUtah);
        System.out.println("What in tarnation?  Two more hitchers!");
        
        if((currentNumberOfPassengers + 2) <= 5){
            System.out.println("Well hop on in you two.  We'll make room.");
        } else {
            System.out.println("Folks, I only have room for one, so it's one or none.  Are you willing to split?");
            System.out.println("Fair enough.  I wish you both the best of luck in your travels.");
        }
        double finalLegGasPrice = (distanceToMoabUtah / NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        System.out.println("The cost of fuel for the final leg is $" + finalLegGasPrice);
        cashOnHand = cashOnHand - finalLegGasPrice;
        destinationReached = true;
        
        System.out.println();
        System.out.println("****Variable stats at the end of the trip****");
        tripOdomter = tripOdomter + distanceToMoabUtah;
        distanceToMoabUtah = distanceToMoabUtah - distanceToMoabUtah;
        System.out.println("Distance To Destination: " + distanceToMoabUtah);
        System.out.println("Full Car? " + carFull + "; Current odometer: " + tripOdomter);
        System.out.println("I have $" + cashOnHand + " left in my pocket.");
        System.out.println(currentNumberOfPassengers + " Passengers in car");
        System.out.println("Destination Reached? " + destinationReached);
        
        
    } // close class main
    
} // close class RoadTrip
