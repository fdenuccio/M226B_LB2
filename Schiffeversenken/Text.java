import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Text here.
 * 
 * @author Jenia Isler 
 * @version 21.01.2021
 */
public class Text extends Actor
{   
    
    private String text;
    
    public Text(){
        text = "setze deine Boote und bestätige";
        
    }
    
    public void act() 
    {
        refreshText();
        
    }
    
    
    
    private void refreshText(){
        setImage(new GreenfootImage(text, 60, Color.BLACK, Color.WHITE));
    }
    
    public void setText(String t){
        text = t;
        setImage(new GreenfootImage(t, 60, Color.BLACK, Color.WHITE));
    }
}
