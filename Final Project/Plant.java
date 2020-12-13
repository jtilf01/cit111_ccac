/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author josht
 */
public class Plant {
    
    // variable to denote how much energy a plant possesses at any given point
    // this variable will likely change frequently whereas the reproductionEnergy 
    // variable will remain static for any given run
    private double currentEnergy = 0;
    // boolean variabe: if true plant is in shade and receives a lower energy 
    // boost from the program's "sunlight" 
    private boolean inShade = false;
    // location variable needed so herbivore's are forced to locate their food
    // one variable for the x location and one for y so that the simulated environment
    // can be a two dimensional plane
    private int locationX;
    private int locationY;
    // variable needed to denote food type so that carnivores cannot consume plants
    public final String FOODTYPE = "PLANT";
    // if a plant gets eaten, we need to halt it's reproductive ability and remove 
    // it from the simulation, so we'll need to track it's eaten status
    private boolean eaten = false;
    
    public void getLocation(){
        // using Random so that location variables need not be pre-determined
        // the area of the plane will be set, though, with the lower left corner
        // being location 0,0 and the upper right corner being 100,100
        Random loc = new Random();
        locationX = loc.nextInt(100);
        locationY = loc.nextInt(100);
    }  // closes location method
    
    // the program will need access to the plants location so we'll need a method
    // to return each value
    public int getX(){
        return locationX;
    }
    public int getY(){
        return locationY;
    }
       
    public void shaded(){
        // we'll generate a random number from 1-100.  If the number is less than 
        // 33, we'll say the plant is in the shade.  This means that on average 1/3
        // of our plants will be growing in the shade.
        Random rand = new Random();
        int shade = rand.nextInt(100);
        if(shade <=33){
            
            inShade = true;
        }
    }  // closes shade method
    
    
    public void dayPass(){
        // for each day that passes our plant will receive some energy (1 if not 
        // in shade, 0.5 if in shade.  if the plant has been eaten it will not gain energy
        if(eaten == false){
            if(inShade){
                currentEnergy = currentEnergy + 0.5;
            } else {
                currentEnergy = currentEnergy + 1;
            }
        } else {
            currentEnergy = 0;
        }
    }  // closes passing day method
    
    // if our plant attains enough energy it will replicate and we'll need to pass
    // this fact back into our main 
    public boolean reproduce(double reproductionEnergy){
        if(currentEnergy >= reproductionEnergy){
            currentEnergy = 0;
            return true;
        } else {
            return false;
        }
    } // closes reproduction method
    
    // we need a method that will trigger when a plant gets eaten and stop the 
    // plants reproductive progress, effectively eliminating it from the simulation
    public boolean gotEaten(){
        eaten = true;
        // we'll modify the plants location removing it from the board so that 
        // it cannot interact with any other object
        locationX = 99999;
        locationY = 99999;
        return eaten;
    }
    
    public boolean inShade(){
        return inShade;
    }
    
    public double energy(){
        return currentEnergy;
    }
    
} // closes class
