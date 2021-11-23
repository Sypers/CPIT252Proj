
package ServerPKG;


import CRSClasses.*;
import CRSClasses.Commands.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.io.EOFException;
import java.net.SocketException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


class ClientThread extends Thread {
    Connection c;
    Socket s;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Command command;

    public ClientThread(Socket s, Connection c) throws IOException {
        this.s = s;
        this.c = c;
        this.ois = new ObjectInputStream(s.getInputStream());
        this.oos = new ObjectOutputStream(s.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!(command instanceof QuitCommand)) {
                command = (Command) ois.readObject();
                command.execute(ois,oos,c);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
