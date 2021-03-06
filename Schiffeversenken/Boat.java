import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    private Kaestchen[] bootsteile;
    private int groesse; // Grösse des Boots (2,3,4)
    private int index;   // Index zählt hoch beim hinzufügen der Teile

    /**
     * Constructor for objects of class Boat
     * 
     * @param groesse   enter size of boat
     * 
     */
    public Boat(int groesse){
        this.groesse = groesse;
        bootsteile = new Kaestchen[groesse];
        index = 0;   // Noch kein Teil zugefügt
    }

    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 

    /** 
     * get Index of this Boat
     * 
     * @return Index value
     */
    public int getIndex() {
        return index;
    }

    /** 
     * get size of this Boat
     * 
     * @return size value
     */
    public int getGroesse() {
        return groesse;
    }  

    /** 
     * adds a new field
     * 
     * @param k     reference to a field
     */
    public void addTeil(Kaestchen k) {
        // Test of möglich
        bootsteile[index] = k;
        index++;
    }
}
