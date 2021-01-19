import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Jenia Isler  
 * @version 16.01.2021
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private boolean first = true;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
            
    
    }
    
    public void act(){
        
        if(first){
            
            if(ActasServer()){
                startServer();
            }else{
                startClient();
            }
            
            first = false;
        }
        
    }
    
    public void startServer(){
        try{
            
        Server.ServerSocket()/*SocketGetJSON()*/;
    }  catch(Exception e){
        e.printStackTrace();
        System.out.println(e);
    }
    }
    
    public void startClient(){
        try{
            
        Client.ServerSocket();
    }  catch(Exception e){
        e.printStackTrace();
        System.out.println(e);
    }
    }
    
    
    
    public boolean ActasServer(){
        
        String response = null;
        
        do{
            
            response = Greenfoot.ask("Are you a Host [yes/no]");
            
        } while(!(response.contains("yes") || response.contains("no")));
        
    
        if(response.contains("yes")){

            return true;
        }else{return false;}
    }
}


