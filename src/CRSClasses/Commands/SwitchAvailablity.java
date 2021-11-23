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
public class SwitchAvailablity implements Command{
    Car car;
    
    public SwitchAvailablity(Car C){
        this.car=C;
    }
    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos, Connection c) {
       CarRentalDBMethods.changeAvailability(c, car);
    }
    
}
