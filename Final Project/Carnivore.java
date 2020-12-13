/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;
import java.util.Random;

/**
 *
 * @author josht
 */
public class Carnivore {
    // we need variables to track a carnivore's energy level and to determine
    // when it attains enough energy to reproduce.  We'll hard code the reproduction
    // threshold variable to keep things simple
    private double currentEnergy;
    private final double REPRODUCTIONTHRESHOLD = 5.0;
    
    // another variable will help track a carnivore's success in finding food
    // if it doesn't find food, it will take an energy penalization and risk starving
    private double dayStartEnergy;
    
    // we need variables to track a carnivore's location which will dynamcially change
    private int currentX;
    private int currentY;
    
    // a carnivore can die of starvation, so we'll track that 
    private boolean starved = false;
    
    public void getStartLocation(){
        // using Random so that location variables need not be pre-determined
        // the area of the plane will be set, though, with the lower left corner
        // being location 0,0 and the upper right corner being 100,100
        Random rand = new Random();
        currentX = rand.nextInt(100);
        currentY = rand.nextInt(100);
    }// close start location method
    
    // we'll need to be able to access the herbivore's location so we'll write
    // methods to retrieve the variables
    public int getX(){
        return currentX;
    }
    public int getY(){
        return currentY;
    } // close get location methods
    
    // our carnivores will need to be mobile, so we'll write a method that can
    // modify their location.  The user will set the carnivore class' speed, 
    // which will represent how far they can "hunt" in a given day, but each
    // "step" will be only one unit, either in the x direction or y or both diagonally
    public double dayHunt(int dailySteps, Herbivore[] array, int herbTotal){
        // this for loop represents an entire day's activity, the methods called
        // after the loop are an end of day account based on the carnivore's 
        // success in finding food
        double herbsConsumedDaily = 0;
        if(starved==false){
            for(int s = 0; s < dailySteps; s++){
                Random direction = new Random();
                // we'll randomize the direction the carnivore moves in, giving it
                // a 50/50 chance of going either way
                int stepX = direction.nextInt(99);
                // before we randomize the carnivore's movement, we'll put a "tracker"
                // in so that if the carnivore is near prey it will move toward it.
                // this will simulate a sense of smell
                boolean preySmelled = false;
                for(int preyloc = 0; preyloc < herbTotal; preyloc++){
                    if(java.lang.Math.abs(currentX - array[preyloc].getX()) > 5 
                            || java.lang.Math.abs(currentY - array[preyloc].getY()) > 5){
                        break;
                    } else {
                        preySmelled = true;
                        if(array[preyloc].getX() < currentX){
                            currentX -= 1;
                        } else if(array[preyloc].getX() > currentX){
                            currentX += 1;
                        } else if(array[preyloc].getX() == currentX){
                            currentX += 0;
                        }
                        if(array[preyloc].getY() < currentY){
                            currentY -= 1;
                        } else if(array[preyloc].getY() > currentY){
                            currentY += 1;
                        } else if(array[preyloc].getY() == currentY){
                            currentY += 0;
                        }
                    }
                } 
                if(preySmelled == false){
                    if(stepX <= 49){
                        // we need to prevent the carnivore from leaving the simulation
                        // plane, so we'll turn it around if it reaches the edge
                        if(currentX <= 0){
                            currentX = 1;
                        } else {

                            currentX -= 1;
                        }
                    } else {
                        if(currentX >= 100){
                            currentX = 99;
                        } else {
                            currentX += 1;
                        }
                    }
                    int stepY = direction.nextInt(99);
                    if(stepY <= 49){
                        // we need to prevent the carnivore from leaving the simulation
                        // plane, so we'll turn it around if it reaches the edge
                        if(currentY <= 0){
                            currentY = 1;
                        } else {
                            currentY -= 1;
                        }
                    } else {
                        if(currentY >= 100){
                            currentY = 99;
                        } else {
                            currentY += 1;
                        }
                    }
                }
                // after each step we'll need to compare an carnivore's current 
                // location to the running list of prey locations.  If the carnivore's
                // location matches a prey's, that prey will be eaten.
                boolean herbConsumed = compareLocation(array, herbTotal);
                if(herbConsumed){
                    herbsConsumedDaily += 1;
                }
            } // closes total daily step for loop
        }
        return herbsConsumedDaily;
    } // close hunt method
    
    // this method compares the carnivore's current location with each prey's 
    // location, if there is a match, the method call's a method in the 
    // herbivore object designating the herbivore as having been eaten
    public boolean compareLocation(Herbivore [] array, int arrayCap){
        // the carnivore might not find food, if so it could potentially starve
        // we need to track if it found food 
        boolean consumed = false;
        for(int c = 0; c < arrayCap; c++){
            if(currentX == array[c].getX() && currentY == array[c].getY()){
                currentEnergy += 1;
                consumed = array[c].consumed();
            }
        }
        return consumed;
    }  // closes compare method
    
    public boolean reproduce(){
        if(currentEnergy >= REPRODUCTIONTHRESHOLD){
            currentEnergy = 0;
            return true;
        } else {
            return false;
        }
    } // close reproduction method
    
    public boolean starvation(){
        // if the currentEnergy variable is equal to the dayStartEnergy variable
        // that means the carnivore was unsuccessful in it's hunting and it will
        // risk starving
        if(starved==false){
            if(currentEnergy == dayStartEnergy){
                currentEnergy = currentEnergy - 1;
                dayStartEnergy = currentEnergy;
                // the carnivore can go a few days without eating so we'll hard set
                // the starvation value
                if(currentEnergy <= -3){
                    starved = true;
                    // changing the location of the carnivore takes it out of the simulation
                    // so it can't interact with other objects;
                    currentX = 22222;
                    currentY = 22222;
                }
            }
            return starved;
        } else {
            return false;
        }
    } // closes starvation method
    
} // closes class
