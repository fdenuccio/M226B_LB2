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

    public int x;
    public int y;
    private GreenfootImage img;
    private int zustand; // Wasser, Schiff, Treffer, Versenkt
    public boolean links;
    
    private Knopf knopf;

    private GreenfootImage bilder[] = {new GreenfootImage("wasser (Custom).jpg"),new GreenfootImage("Kaestchen (Custom).png"), new GreenfootImage("treffer (Custom).jpg"), new GreenfootImage("versenkt (Custom).jpg")};
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
        
        knopf = ((getWorld()).getObjects(Knopf.class)).get(0);
        
        if (!links){
            if (Greenfoot.mouseClicked(this)) {
                // check if rechts
                //fire();
                
                setState(2);
                
                
                
                knopf.bombCord(getCords());
                
            }
        }
    }  

    private void fire() {
        //Send to other x, Y 
        // --: Returnwert wasser,schiff, treffer, versenkt
        switch (zustand){
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
        } 
    }

    public void setState( int state){
        

        switch (zustand){
            case 0: {

                setImage(bilder[state]);
                break;
            }
            case 1: {

                setImage(bilder[state]);
                break;
            }
            case 2: {

                setImage(bilder[state]);
                break;
            }
            case 3: {

                break;
            }
        }
    }
    
    public String getCords(){
          String corx = String.valueOf(x);
          String cory = String.valueOf(y);
          
          
          
          return corx + cory;
          
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

