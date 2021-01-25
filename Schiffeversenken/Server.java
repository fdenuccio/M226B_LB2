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
 * @version 1.0
 */
public class Server  
{
    //constant declearing default server port
    private static final int SERVER_PORT = 9000;

    // instancevariable containing IP of previously connected Client
    public String Client_IP = null;

    /**
     * Constructor for objects of class Server
     */
    public Server()
    {
    }

    /**
     * creates a listening Server Socket waiting for a Connection from a Client
     * used for gameinitialisation
     * 
     * @return     The IP of the Connected Client 
     */

    public static String ServerSocket() throws IOException{
        System.out.println("[SERVER] Waiting for client connection on Port: " + SERVER_PORT + "...");

        ServerSocket listener = new ServerSocket(SERVER_PORT);

        // TODO [Popup] Waiting for client connection
        Socket client = listener.accept();
        // TODO [Popup] Client connected

        System.out.println("connected Client " + getIP(client));

        // for Buffer outgoing messages
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // for Buffer incoming messages
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.println("Server response: " + in.readLine());

        //close
        out.close();
        in.close();

        //
        listener.close();

        return getIP(client);

    }

    /**
     * creates a listening Server Socket waiting for a Connection from a Client
     * 
     * @return     The IP of the Connected Client 
     */
    public static String receiveSocket() throws IOException{

        String response;

        System.out.println("[SERVER] Waiting for client connection on Port: " + SERVER_PORT + "...");

        ServerSocket listener = new ServerSocket(SERVER_PORT);

        // TODO [Popup] Waiting for client connection
        Socket client = listener.accept();
        // TODO [Popup] Client connected

        System.out.println("connected Client " + getIP(client));

        // for Buffer outgoing messages
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // for Buffer incoming messages
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        response = in.readLine();

        //close
        out.close();
        in.close();

        //
        listener.close();

        return response;

    }

    /**
     * with a connected Socket gets IP of connected Client
     * 
     * @param   client  give reference to a open Socket connection
     * @return          The IP of the Connected Client 
     */
    public static String getIP(Socket client)
    {

        //get IPAdress of client
        InetSocketAddress sockaddr = (InetSocketAddress)client.getRemoteSocketAddress();
        InetAddress inaddr = sockaddr.getAddress();
        Inet4Address in4addr = (Inet4Address)inaddr;
        byte[] ip4bytes = in4addr.getAddress(); // returns byte[4]
        String ip4string = in4addr.toString().replace("/","");

        return ip4string;

    }

}
