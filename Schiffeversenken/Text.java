import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Text here.
 * 
 * @author Jenia Isler 
 * @version 21.01.2021
 */
public class Text extends Actor
{   
    // Instancevariable containig text for the Actor
    private String text;
    
    /**
     * Constructor for objects of class Text.
     * 
     */
    public Text(){
        text = "setze deine Boote und bestätige";
        
    }
    
    /**
     * Act - do whatever the Kaestchen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        refreshText();
        
    }
    
    
    /**
     * resets Image to Text of Instancevariable
     */
    private void refreshText(){
        setImage(new GreenfootImage(text, 60, Color.BLACK, Color.WHITE));
    }
    
    /**
     * sets the Greenfoot Image to a set Text and Stops game if player won or lost
     * 
     * @param  t       enter a String that is suppost to show as Image
     */
    public void setText(String t){
        text = t;
               
        setImage(new GreenfootImage(t, 60, Color.BLACK, Color.WHITE));
        
        if (t == "Du hast gewonnen!" || t == "Du hast gewonnen!"){
            Greenfoot.stop();
        }
    }
}
