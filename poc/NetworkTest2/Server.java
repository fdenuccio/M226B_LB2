import java.io.*;  
import java.net.*;  
/**
 * Write a description of class Server here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Server  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Server
     */
    public Server()
    {
        createSocket();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void createSocket()
    {
        try{  
            ServerSocket ss=new ServerSocket(6666);  
            Socket s=ss.accept();//establishes connection   
            DataInputStream dis=new DataInputStream(s.getInputStream());  
            String  str=(String)dis.readUTF();  
            System.out.println("message= "+str);  
            ss.close();  
        }catch(Exception e){System.out.println(e);}  
    }  
}


