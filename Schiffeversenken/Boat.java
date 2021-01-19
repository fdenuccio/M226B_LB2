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
    private int groesse; // Grüsse des Boots (2,3,4)
    private int index;   // Index zöhlt hoch beim hinzuf'gen der Teile
    
    public Boat(int groesse){
       this.groesse = groesse;
       bootsteile = new Kaestchen[groesse];
       index = 0;   // Moch kein Teil zugefügt
    }
   
    
    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public int getIndex() {
       return index;
    }
    
     public int getGroesse() {
       return groesse;
    }  
    
    public void addTeil(Kaestchen k) {
       // Test of müglich
       bootsteile[index] = k;
       index++;
    }
}
