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
public class Herbivore {
    // we need variables to track an herbivore's energy level and to determine
    // when it attains enough energy to reproduce.  We'll hard code the reproduction
    // threshold variable to keep things simple
    private double currentEnergy;
    private final double REPRODUCTIONTHRESHOLD = 5.0;
    
    // another variable will help track an herbivore's success in finding food
    // if it doesn't find food, it will take an energy penalization and risk starving
    private double dayStartEnergy;
    
    // we need variables to track an herbivore's location, which unlike the plant
    // object will be dynamic and constantly changing
    private int currentX;
    private int currentY;
    
    // a foodtype variable will ensure that carnivores eat this object but not plants
    public final String FOODTYPE="PREY";
    
    // because herbivores will occasionally be eaten, we'll need to track that variable
    private boolean eaten = false;
    
    // an herbivore can die of starvation too, so we'll track that second way to 
    // die in a different variable to help keep stats
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
    
    // our herbivores will need to be mobile, so we'll write a method that can
    // modify their location.  The user will set the herbiovore class' speed, 
    // which will represent how far they can "walk" in a given day, but each
    // "step" will be only one unit, either in the x direction or y or both diagonally
    public double dayWalk(int dailySteps, Plant[] array, int plantTotal){
        // this for loop represents an entire day's activity, the methods called
        // after the loop are an end of day account based on the herbivore's 
        // success in finding food and not getting eaten itself
        double plantsConsumedDaily = 0;
        if(eaten==false && starved==false){
            for(int s = 0; s < dailySteps; s++){
                Random direction = new Random();
                // we'll randomize the direction the herbivore moves in, giving it
                // a 50/50 chance of going either way
                int stepX = direction.nextInt(99);
                // before we randomize the herbivore's movement, we'll put a "tracker"
                // in so that if the herbivore is near a plant it will move toward it.
                // this will simulate a sense of smell
                boolean plantSmelled = false;
                for(int plantloc = 0; plantloc < plantTotal; plantloc++){
                    if(java.lang.Math.abs(currentX - array[plantloc].getX()) > 5 
                            || java.lang.Math.abs(currentY - array[plantloc].getY()) > 5){
                        break;
                    } else {
                        plantSmelled = true;
                        if(array[plantloc].getX() < currentX){
                            currentX -= 1;
                        } else if(array[plantloc].getX() > currentX){
                            currentX += 1;
                        } else if(array[plantloc].getX() == currentX){
                            currentX += 0;
                        }
                        if(array[plantloc].getY() < currentY){
                            currentY -= 1;
                        } else if(array[plantloc].getY() > currentY){
                            currentY += 1;
                        } else if(array[plantloc].getY() == currentY){
                            currentY += 0;
                        }
                    }
                } 
                if(plantSmelled == false){
                    if(stepX <= 49){
                        // we need to prevent the herbivore from leaving the simulation
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
                        // we need to prevent the herbivore from leaving the simulation
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
                // after each step we'll need to compare an herbivore's current 
                // location to the running list of plant locations.  If the herbivore's
                // location matches a plant's, that plant will be eaten.
                boolean plantConsumed = compareLocation(array, plantTotal);
                if(plantConsumed){
                    plantsConsumedDaily += 1;
                }
            } // closes total daily step for loop
        }
        return plantsConsumedDaily;
    } // close walk method
    
    // this method compares the herbivore's current location with each plant's 
    // static location, if there is a match, the method call's a method in the 
    // plant object designating the plant as having been eaten
    public boolean compareLocation(Plant [] array, int arrayCap){
        // the herbivore might not find food, if so it could potentially starve
        // we need to track if it found food 
        boolean consumed = false;
        for(int c = 0; c < arrayCap; c++){
            if(currentX == array[c].getX() && currentY == array[c].getY()){
                currentEnergy += 1;
                consumed = array[c].gotEaten();
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
        // that means the herbivore was unsuccessful in it's foraging and it will
        // risk starving
        if(eaten==false && starved==false){
            if(currentEnergy == dayStartEnergy){
                currentEnergy = currentEnergy - 1;
                dayStartEnergy = currentEnergy;
                // the herbivore can go a few days without eating so we'll hard set
                // the starvation value
                if(currentEnergy <= -3){
                    starved = true;
                    // changing the location of the herbivore takes it out of the simulation
                    // so it can't interact with other objects;
                    currentX = 55555;
                    currentY = 55555;
                }
            }
            return starved;
        } else {
            return false;
        }
    } // closes starvation method
    
    // our herbivore might get eaten too.  If so, it needs to be removed from the
    // simulation
    public boolean consumed(){
        eaten = true;
        currentX = 55556;
        currentY = 55556;
        return eaten;
    }
    
    public double getCurrentEnergy(){
        return currentEnergy;
    }
    public double getDayStartEnergy(){
        return dayStartEnergy;
    }
    
} // closes class
