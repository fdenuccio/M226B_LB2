import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Knopf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knopf extends Actor
{
    /**
     * Act - do whatever the Knopf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean started = false;
    
    private Text text;
    
    
    public Knopf() {
        
    }
    
    public void act() 
    {
        text = ((getWorld()).getObjects(Text.class)).get(0);
        
        if (Greenfoot.mouseClicked(this)) {
           
            if (!started){
                text.setText("started");
                
                roundPrep();
                
                started = true;
                
            }
            
            
        }
    }
    
    private void roundPrep(){
        
        if(checkInput.ActasServer()){
                startServer();
            }else{
                
                String response= null;
                
                do{
                    
                  response = Greenfoot.ask("Enter IP Address:");

                } while(!checkInput.checkIP(response));
                
                startClient(response);
            }
        }
        
    public void startServer(){
        try{
            text.setText("starte Server");
            Server.ServerSocket()/*SocketGetJSON()*/;
        }  catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    public void startClient(String ip){
        try{
            text.setText("starte Client");
            Client.ServerSocket(ip);
        }  catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
    
    
        
    }
    
    
    

    
