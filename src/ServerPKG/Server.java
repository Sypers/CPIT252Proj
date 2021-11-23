
package ServerPKG;


import java.io.*;
import java.net.*;
import java.sql.*;

public class Server {

  
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // TODO code application logic here
            Connection c;
            c = DBConnection.getInstance("jdbc:mysql://localhost:3306/carrentaldb?zeroDateTimeBehavior=convertToNull" , "root" , "").getConnection();
            System.out.println("Database connected");
            ServerSocket SS = new ServerSocket(2001);
            while (true) {
                Socket s = SS.accept();
                System.out.println("Client Connected");
                ClientThread t = new ClientThread(s,c);
                t.start();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
