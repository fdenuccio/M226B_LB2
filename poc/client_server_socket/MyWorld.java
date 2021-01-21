import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                
                String response= null;
                
                do{
                    
                  response = Greenfoot.ask("Enter IP Address:");

                } while(!checkIP(response));
                
                startClient(response);
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

    public void startClient(String ip){
        try{

            Client.ServerSocket(ip);
        }  catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    private boolean checkIP(String ip){
        
        String regex = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(ip);
        
        if(matcher.matches()) {
            return true;
         } else {
            return false;
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

