import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Kaestchen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kaestchen extends Actor
{
    
    private int x;
    private int y;
    private GreenfootImage img;
    private int zustand; // Wasser, Schiff, Treffer, Versenkt
    private boolean links;
    
    private GreenfootImage bilder[] = {new GreenfootImage("wasser (Custom).jpg"), new GreenfootImage("treffer (Custom).jpg"), new GreenfootImage("versenkt (Custom).jpg")};
    private Boat boat;
    
    public Kaestchen(int x, int y, boolean links){
       this.x = x;
       this.y = y;
       this.links = links;
       zustand = 0; //wasser
       setImage(bilder[zustand]); // Image Wasser laden
       boat = null;
       
       
    }
    
    /**
     * Act - do whatever the Kaestchen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (Greenfoot.mouseClicked(this)) {
           // check if rechts
            fire();
        }
    }  
    
    private void fire() {
        // Send to other x, Y 
        // --: Rerurnwert wasser, treffer, versenkt
        /*switch (result) {
            case 0: {
                
                zustand++;
                setImage(bilder[zustand]);
                break;
            }
            case 1: {
                zustand++;

                setImage(bilder[zustand]);
                break;
            }
            case 2: {
                zustand++;

                setImage(bilder[zustand]);
                break;
            }
            case 3: {
                
                break;
            }
         } */
    }
    
    public void addToBoat(Boat b) {
       this.boat = boat;
       zustand = 1;
       setImage(bilder[zustand]);
       b.addTeil(this);
    }

    public int getZustand(){
        return zustand;
    }
}
   
