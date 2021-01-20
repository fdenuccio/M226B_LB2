import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Kaestchen[][] feldLinks;
    private Kaestchen[][] feldRechts;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        feldLinks = new Kaestchen[10][10];
        feldRechts = new Kaestchen[10][10];
        prepare();
        Knopf knopf1 = new Knopf();
        addObject(knopf1,500,400);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for(int x=0; x <10; x++) {
            for(int y=0; y <10; y++) {
                Kaestchen kaestchen = new Kaestchen(x,y, true);
                feldLinks[x][y] = kaestchen;
                addObject(kaestchen,150+x*20,150+y*20);
            }
        }
        for(int x=0; x <10; x++) {
            for(int y=0; y <10; y++) {
                Kaestchen kaestchen = new Kaestchen(x,y, false);
                feldRechts[x][y] = kaestchen;
                addObject(kaestchen,400+x*20,150+y*20);
            }
        }
        
        // Boat 2 füllen
        Boat boat2 = new Boat(2);
        feldLinks[4][5].addToBoat(boat2);
        feldLinks[4][6].addToBoat(boat2);
        // Boat 3 füllen
        Boat boat3 = new Boat(3);
        feldLinks[6][7].addToBoat(boat3);
        feldLinks[6][8].addToBoat(boat3);
        feldLinks[6][9].addToBoat(boat3);
        //Boat 4 füllen
        Boat boat4 = new Boat(4);
        feldLinks[2][2].addToBoat(boat4);
        feldLinks[2][3].addToBoat(boat4);
        
        //Doppelschleife x yè
        //feldLinks[x][z].getZustand   ---> Send to other
    }
}
