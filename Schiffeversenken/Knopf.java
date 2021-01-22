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

    private boolean started;

    private Text text;

    private String oponendIP;

    private String receivedCord;

    private boolean server;

    private String chosenCords/* temp zu löschen und setzten mit methode aus feld */ = "cordosXY";

    public Knopf() {

        started = false;

    }

    public void act() 
    {
        text = ((getWorld()).getObjects(Text.class)).get(0);

        if (Greenfoot.mouseClicked(this)) {

            if (!started){
                text.setText("started");

                prepRound();

                started = true;

                if (!server){

                    receiveCords();

                }

            }else{
                //normale runde nach start
                try{
                    Client.sendSocket(oponendIP, chosenCords);
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println(e);
                }

                receiveCords();

            }

        }
    }

    private void nextRound(){
        try{
            text.setText("starte Server");
            receivedCord = Server.receiveSocket()/*SocketGetJSON()*/;
        }  catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

    }

    private void prepRound(){
        if(checkInput.ActasServer()){
            startServer();
            server = true;
        }else{

            String response= null;

            do{

                response = Greenfoot.ask("Enter IP Address:");

            } while(!checkInput.checkIP(response));

            oponendIP = response;

            startClient(response);
        }
    }

    private void bombCord(String cord){

    }

    
    private void receiveCords(){
        try{
            receivedCord = Server.receiveSocket();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        
        System.out.println(receivedCord);
        
        bombCord(receivedCord);

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

