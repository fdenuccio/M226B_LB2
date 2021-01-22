import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Write a description of class Client here.
 * 
 * @author Jenia Isler   
 * @version 16.01.2021
 */
public class Client  
{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9000;

    /**
     * Constructor for objects of class Client
     */
    public Client()
    {
    }

    public static void ServerSocket() throws IOException{
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        
        socket.close();
    }
    
    public static void ServerSocket(String ip) throws IOException{
        //connect to server with new Socket
        Socket socket = new Socket(ip, SERVER_PORT);
        System.out.println("Connected to Server (" + ip + ") on Port " + SERVER_PORT);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        out.println("hoi du");
        System.out.println(in.readLine());
        
        socket.close();
    }
    
    
    public static void sendSocket(String ip, String cords) throws IOException{
        //connect to server with new Socket
        Socket socket = new Socket(ip, SERVER_PORT);
        System.out.println("Connected to Server (" + ip + ") on Port " + SERVER_PORT);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        out.println(cords);
        
        socket.close();
    }
    
}
