import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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

    public int punkte;

    public Kaestchen lastkasten;
    
    public boolean wasbombed;

    public Knopf() {
        started = false;
        punkte = 0;
        wasbombed = false;
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
                
                text.setText("warte auf Gegner...");
                
                try{
                    if (wasbombed)
                    {
                        chosenCords = chosenCords + "1";
                    }
                    Client.sendSocket(oponendIP, chosenCords);
                    wasbombed = false;
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println(e);
                }

                receiveCords();

            }

        }
        if (punkte == 7){
            text.setText("du hast gewonnen");
            
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

    public void bombCord(String cord){
        chosenCords = cord;
    }

    public void setreceivedCord(String cord){
        
        text.setText("du bist dran!");
        
        int x = Integer.parseInt(String.valueOf(cord.charAt(0)));
        int y = Integer.parseInt(String.valueOf(cord.charAt(1)));
        int z = 0;
        if (cord.length() == 3){
            z = Integer.parseInt(String.valueOf(cord.charAt(2)));

            System.out.println("state value: " + z);
            

        }

        System.out.println("received x cor: " + x);
        System.out.println("received y cor: " + y);

        MyWorld world = (MyWorld) getWorld();
        List<Kaestchen> kaestchen = getWorld().getObjects(Kaestchen.class);
        for (Kaestchen kasten : kaestchen){
            if (kasten.x == x && kasten.y == y && kasten.links){
                
                if(z == 1){
                    lastkasten.setState(3);
                }
                
                kasten.setState(2);
                
                //lastkasten = kasten;
            }
        }

    }

    private void receiveCords(){
        try{
            receivedCord = Server.receiveSocket();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        System.out.println(receivedCord);

        setreceivedCord(receivedCord);

    }

    public void startServer(){
        try{
            text.setText("starte Server");
            oponendIP = Server.ServerSocket()/*SocketGetJSON()*/;
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

