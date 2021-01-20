import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.Inet4Address;

/**
 * Write a description of class Server here.
 * 
 * @author Jenia Isler
 * @version 16.01.2021
 */
public class Server  
{
    //deklarierter Server Port
    private static final int SERVER_PORT = 9000;
    
    public String Client_IP = null;
    
    /**
     * Constructor for objects of class Server
     */
    public Server()
    {
    }
    
    public Server(boolean jsonObject){
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    public static void ServerSocket() throws IOException{
        ServerSocket listener = new ServerSocket(SERVER_PORT);

        // TODO [Popup] Waiting for client connection
        Socket client = listener.accept();
        // TODO [Popup] Client connected


        
        
        //get IPAdress of client
        InetSocketAddress sockaddr = (InetSocketAddress)client.getRemoteSocketAddress();
        InetAddress inaddr = sockaddr.getAddress();
        Inet4Address in4addr = (Inet4Address)inaddr;
        byte[] ip4bytes = in4addr.getAddress(); // returns byte[4]
        String ip4string = in4addr.toString();
        
        System.out.println(ip4string);
        
        
        // for Buffer outgoing messages
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // for Buffer incoming messages
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));


        //close
        out.close();
        in.close();

        //
        listener.close();

    }
    
    
    public static String SocketGetJSON() throws IOException{
        
        System.out.println("[SERVER] Waiting for client connection on Port: " + SERVER_PORT + "...");
        
        ServerSocket listener = new ServerSocket(SERVER_PORT);

        // TODO [Popup] Waiting for client connection
        Socket client = listener.accept();
        // TODO [Popup] Client connected


        // for Buffer outgoing messages
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // for Buffer incoming messages
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        //get String form incoming buffer
        String jsonString = in.readLine();
        
        // returns JSON Sting
        

        //close
        out.close();
        in.close();

        //close listener
        listener.close();
        
        return jsonString;
    }

}
