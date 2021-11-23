/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses.Commands;
import CRSClasses.CarRentalDBMethods;
import CRSClasses.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;


/**
 *
 * @author winDows
 */
public class ConfirmDelivery implements Command{
    Reservation res;

    public ConfirmDelivery(Reservation res) {
        this.res = res;
    }
    
    
    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos, Connection c) {
        res.setStatus("Ended");
        res.setReturndate(new Date(System.currentTimeMillis()));
        CarRentalDBMethods.Handover(c, res);
    }
    
}
