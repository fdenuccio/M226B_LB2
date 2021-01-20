import java.io.*;  
import java.net.*;  
/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client  
{
    // instance variables - replace the example below with your own
    private int x;
    

    /**
     * Constructor for objects of class Client
     */
    public Client()
    {
        connect();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void connect()
    {
        try{      
            Socket s=new Socket("localhost",7777);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            dout.writeUTF("Hello Server");  
            dout.flush();  
            dout.close();  
            s.close();  
        }catch(Exception e){System.out.println(e);}  
    }  
}

