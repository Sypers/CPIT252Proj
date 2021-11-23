/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBConnection {
    private static volatile DBConnection instance;
    private Connection c;
    private String url,name,password;
    
    private DBConnection (String url,String name,String pass){
        try {
            this.c = DriverManager.getConnection(url,name,pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBConnection getInstance(String url,String name, String pass) {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection(url,name,pass);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return c;
    }
    
}
