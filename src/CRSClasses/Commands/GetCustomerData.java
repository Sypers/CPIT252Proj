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
 * @author Administrator
 */
public class GetCustomerData implements Command{
    private Customer cust;

    public GetCustomerData(Customer cust) {
        this.cust = cust;
    }

    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos,Connection c) {
        try {
            //Logger.logMsg(Logger.INFO, "Getting Customer " + this.cust.getName() + " Data...");
            ArrayList<Car> availcars = CarRentalDBMethods.getAvailCars(c);
            ArrayList<Reservation> custRes = CarRentalDBMethods.getCustRes(c, cust);
            double credit = CarRentalDBMethods.getCustCredit(c, cust.getId());
            oos.writeObject(availcars);
            oos.writeObject(custRes);
            oos.writeDouble(credit);
            oos.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GetCustomerData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
