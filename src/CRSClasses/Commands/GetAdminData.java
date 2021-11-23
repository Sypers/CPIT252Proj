/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses.Commands;
import CRSClasses.CarRentalDBMethods;
import CRSClasses.*;
import com.sun.media.jfxmedia.logging.Logger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.logging.Level;
/**
 *
 * @author winDows
 */
public class GetAdminData implements Command {
    private Admin admin;
    
    public GetAdminData(Admin admin){
        this.admin=admin;
        
    }

    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos, Connection c) {
       try{
           ArrayList<Car> available = CarRentalDBMethods.getCars(c);
           oos.writeObject(available);
           ArrayList<Reservation> Res= CarRentalDBMethods.getActiveRes(c);
           oos.writeObject(Res);
           ArrayList<Reservation> ResH= CarRentalDBMethods.getHandovers(c);
           oos.writeObject(ResH);
           oos.flush();
       }catch(IOException ex){
           java.util.logging.Logger.getLogger(GetAdminData.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
