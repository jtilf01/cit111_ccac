/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Scanner;

/**
 *
 * @author josht
 */
public class WildLand {
    // variable to denote the energy threshold a plant must achieve 
    // before it can reproduce, because this will be applicable for all plant
    // objects it should be set here and not in the plant object itself
    private static double reproductionEnergy;
    
    // variable needed to set starting count of organisms at the beginning 
    // of the simulation
    private static int startingPlants;
    private static int startingHerbivores;
    private static int startingCarnivores;
    private static int herbivoreSpeed;
    private static int carnivoreSpeed;
    
    /**
     * @param shadedPlant Testing variable to track % of shaded plants
     */
    private static double shadedPlant = 0;
    private static double totalPlants = 0;
    private static double totalPlantsEaten = 0;
    private static double totalHerbivores = 0;
    private static double totalHerbivoreStarved = 0;
    private static double totalHerbivoreEaten = 0;
    private static double totalCarnivores = 0;
    private static double totalCarnivoreStarved = 0;
    private static double totalCreatures = 0;
    
    // the final variable sets the number of days in a given simulation run
    private static int simDays = 100;
    
    public static void main(String[] args){
        System.out.println("Welcome to Wild Land. This is a simulation of a\n" +
                "a very basic ecosystm, containing only one species\n" +
                "of plant, one species of herbivore, and one\n" +
                "species of carnivore.");
        setReproEnergy();
        startNumber();
        // the high array cap allows us to add additional objects later on when
        // the organisms are dynamically created
        Plant[] plant = new Plant[999999];
        for(int p = 0; p < startingPlants; p++){
            plant[p] = new Plant();
            totalPlants += 1;
            totalCreatures += 1;
        }
        Herbivore[] herb = new Herbivore[999999];
        for(int h = 0; h < startingHerbivores; h++){
            herb[h] = new Herbivore();
            totalHerbivores += 1;
            totalCreatures += 1;
        }
        Carnivore[] carn = new Carnivore[999999];
        for(int c = 0; c < startingCarnivores; c++){
            carn[c] = new Carnivore();
            totalCarnivores += 1;
            totalCreatures += 1;
        }
        
        // each starting organism needs a starting location.  The plant location
        // will be static, but herbivores and carnivores will move around. We 
        // also need to know if the plant is in the shade.  These variables need 
        // to be set only once per plant
        for(int pstart = 0; pstart < startingPlants; pstart++){
            plant[pstart].getLocation();
            plant[pstart].shaded();
            if(plant[pstart].inShade()){
                shadedPlant += 1;
            }
        }
        for(int hstart = 0; hstart < startingHerbivores; hstart++){
            herb[hstart].getStartLocation();
        }
        for(int cstart = 0; cstart < startingCarnivores; cstart++){
            carn[cstart].getStartLocation();
        }
        
        fullSimulation(plant, herb, carn, simDays);
        
    } // closes main
    
    public static void output(){
        System.out.println(" ");
        System.out.println("Total number of plants produced: " + totalPlants);
        System.out.println("Number of plants in shade: " + shadedPlant);
        // % of plants in shade
        double stuntedPlant = (shadedPlant / totalPlants) * 100;
        System.out.println("% of plants in shade: " + stuntedPlant);
        System.out.println("Total number of plants eaten: " + totalPlantsEaten);
        double eatenPlant = (totalPlantsEaten / totalPlants) * 100;
        System.out.println("% of plants eaten: " + eatenPlant);
        System.out.println("Total number of herbivores produced: " + totalHerbivores);
        System.out.println("Total number of starved herbivores: " + totalHerbivoreStarved);
        double starvedHerbs = (totalHerbivoreStarved / totalHerbivores) * 100;
        System.out.println("% of herbivores that starved: " + starvedHerbs);
        System.out.println("Total number of herbivores eaten: " + totalHerbivoreEaten);
        double eatenHerbs = (totalHerbivoreEaten / totalHerbivores) * 100;
        System.out.println("% of herbivores eaten: " + eatenHerbs);
        System.out.println("Total number of carnivores produced: " + totalCarnivores);
        System.out.println("Total number of starved carnivores: " + totalCarnivoreStarved);
        double starvedCarns = (totalCarnivoreStarved / totalCarnivores) * 100;
        System.out.println("% of carnivores that starved: " + starvedCarns);
        
    }
    
    public static void startNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many plants do we want to start the simulation with?");
        startingPlants = input.nextInt();
        System.out.println("Great.  And how many herbivores to start?");
        startingHerbivores = input.nextInt();
        System.out.println("Wonderful.  Now how many carnivores do we want to start with?");
        startingCarnivores = input.nextInt();
        System.out.println("We also need to get the speed our herbivores travel at\n" +
                "(Speed is how much distance an herbivore can travel in a day.)");
        herbivoreSpeed = input.nextInt();
        System.out.println("And what should be the speed of our carnivores?");
        carnivoreSpeed = input.nextInt();
    } // closes starting number method
    
    public static void setReproEnergy(){
        // we'll let the user determine how much energy a plant needs to acquire
        // before it can reproduce
        Scanner input = new Scanner(System.in);
        System.out.println("Each day the sun will pass over our environment,\n" +
                "supplying a certain amount of energy to our plants.\n" +
                "How many days must pass before our plants have\n" +
                "enough energy to reproduce?");
        reproductionEnergy = input.nextInt();
        if(reproductionEnergy <= 10){
            System.out.println("Great. After " + reproductionEnergy + " days, if a plant has not\n" +
                    "been eaten it will reproduce and make a new\n" +
                    "plant.  However, some plants are growing\n"+
                    "in the shade and will take twice as long to reproduce.");
        } else {
            System.out.println("Really?  Ok.  Let's see what happens.");
        }
    } // closes reproduction method
    
    // this method represents a full run of the program, it lasts as many cycles 
    // as the hard coded run time states
    public static void fullSimulation(Plant[] array, Herbivore[] herbArray, Carnivore[] carnArray, int runTime){
        // if we want to generate new organisms during the simulation, we'll need to 
        // keep track of the array number tally.  to do this we'll introduce 
        // new variables to keep a running tally
        int runningTally = startingPlants;
        int herbTally = startingHerbivores;
        int carnTally = startingCarnivores;
        // we'll need to keep track of how many organisms are added on a given 
        // day, but in order to prevent unjustified exponential growth, this 
        // variable needs to reset to 0 at the beginning of a day
        int dailyAddition = 0;
        int dailyHerbivores = 0;
        int dailyCarnivores = 0;
        // now we'll actually run our simulation for the full length of its
        // run time, only retrieving organism data after the simulation is complete
        for(int simRun = 0; simRun < runTime; simRun++){
            // if we add the runningTally inside the day event for loop, we'll get an error 
            // thrown every time, so we'll add to the tally outside of the for loop
            runningTally = runningTally + dailyAddition;
            herbTally = herbTally + dailyHerbivores;
            carnTally = carnTally + dailyCarnivores;
            // reseting daily addition so we aren't repeatedly adding the same plants
            // over and over again
            dailyAddition = 0;
            dailyHerbivores = 0;
            dailyCarnivores = 0;
            // this for loop represents a single day's events
            // going with total organism count let's all organisms run through their day, even
            // if there are different numbers of plants, herbivores, and carnivores
            for (int dp = 0; dp < totalCreatures; dp++){
                // we repeat the for loop so we can include a break statement such that
                // if the for loop iteration cap exceeds the plant total, which it
                // almost surely will, we can break out of the loop without breaking 
                // out of the daily loop, letting the day complete for all organisms
                for(int vp = 1; vp == 1; vp++){
                    if(dp >= runningTally){
                        break;
                    } else {
                        array[dp].dayPass();
                        boolean makeMore = array[dp].reproduce(reproductionEnergy);
                        if(makeMore){
                            array[(runningTally + dailyAddition)] = new Plant();
                            totalPlants += 1;
                            totalCreatures += 1;
                            array[(runningTally + dailyAddition)].getLocation();
                            array[(runningTally + dailyAddition)].shaded();
                            if(array[(runningTally + dailyAddition)].inShade()){
                                shadedPlant += 1;
                            } // close makeMore loop
                            dailyAddition += 1;
                        }
                    }
                }
                for(int hp = 1; hp == 1; hp++){
                    if(dp >= herbTally){
                        break;
                    } else {
                        totalPlantsEaten = totalPlantsEaten + herbArray[dp].dayWalk(herbivoreSpeed, array, runningTally);
                        boolean makeMoreHerbs = herbArray[dp].reproduce();
                        if(makeMoreHerbs){
                            herbArray[(herbTally + dailyHerbivores)] = new Herbivore();
                            totalHerbivores += 1;
                            totalCreatures += 1;
                            herbArray[(herbTally + dailyHerbivores)].getX();
                            herbArray[(herbTally + dailyHerbivores)].getY();
                            dailyHerbivores += 1;
                        } // close makeMoreHerbs loop
                        boolean starved = herbArray[dp].starvation();
                        if(starved){
                            totalHerbivoreStarved += 1;
                        }
                    }
                }
                for(int cp = 1; cp == 1; cp++){
                    if(dp >= carnTally){
                        break;
                    } else {
                        totalHerbivoreEaten = totalHerbivoreEaten + carnArray[dp].dayHunt(carnivoreSpeed, herbArray, herbTally);
                        boolean makeMoreCarns = carnArray[dp].reproduce();
                        if(makeMoreCarns){
                            carnArray[(carnTally + dailyCarnivores)] = new Carnivore();
                            totalCarnivores += 1;
                            totalCreatures += 1;
                            carnArray[(carnTally + dailyCarnivores)].getX();
                            carnArray[(carnTally + dailyCarnivores)].getY();
                            dailyCarnivores += 1;
                        } // close makeMoreHerbs loop
                        boolean starved = carnArray[dp].starvation();
                        if(starved){
                            totalCarnivoreStarved += 1;
                        }
                    }
                }
            } // closes single day loop
            System.out.println(" ");
            System.out.println("Day " + (simRun + 1) + " ended.");
            System.out.println("Total Plants: " + totalPlants);
            System.out.println("Total Herbivores: " + totalHerbivores);
            System.out.println("Total Carnivores: " + totalCarnivores);
            System.out.println("Total Organisms: " + totalCreatures);
        } // closes full sim run loop
        // now that the simulation is complete, we get the data on each of 
        // our plants
        output();
        // and the stats for our herbivores
        
    } // closes full simulation
    
} // closes class
