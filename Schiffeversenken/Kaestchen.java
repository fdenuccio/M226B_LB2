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

    /**
     * Constructor for objects of class Kaestchen
     * 
     * @param x     enter x coordinate
     * @param y     enter y coordinate
     * @param links is this field on the left side?
     * 
     */
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

                if (!links){
                    knopf.lastkasten = this;
                }

                setState(2);

                knopf.bombCord(getCords());
            }
        }
    }  

    /* is now unnessesary but probalby would have been a easier solution
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
     */

    /**
     * Sets the state of a field to water, ship, bombed or destroyed 
     * 
     * @param state     value for changing state
     */
    public void setState( int state){

        switch (state){
            case 0: {
                zustand = state;
                setImage(bilder[state]);
                break;
            }
            case 1: {
                zustand = state;
                setImage(bilder[state]);
                break;
            }
            case 2: {
                if(zustand != 1){
                    zustand = state;
                    setImage(bilder[state]);
                }else {
                    setState(3);

                }
                break;
            }
            case 3: {
                knopf = ((getWorld()).getObjects(Knopf.class)).get(0);
                knopf.wasbombed = true;
                zustand = state;
                setImage(bilder[state]);

                if (!links){
                    knopf.punkte = knopf.punkte + 1;
                }

                break;
            }
        }
    }

    /**
     * Gets the coordinates of this field
     * 
     * @return String value containing the coordinates
     */
    public String getCords(){
        String corx = String.valueOf(x);
        String cory = String.valueOf(y);

        return corx + cory;

    }

    /**
     * adds a Boat to the field
     * 
     * @param b  give reference to a boat
     */
    public void addToBoat(Boat b) {
        this.boat = boat;
        zustand = 1;
        setImage(bilder[zustand]);
        b.addTeil(this);
    }

    /**
     * get current state of this field
     * 
     * @return value of current state
     * 
     */
    public int getZustand(){
        return zustand;
    }
}

