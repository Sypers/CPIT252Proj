/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses.Commands;

import CRSClasses.CarRentalDBMethods;
import CRSClasses.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CancelReservation implements Command {

    Reservation Res;

    public CancelReservation(Reservation Res) {
        this.Res = Res;
    }

    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos, Connection c) {
        Date current = new Date(System.currentTimeMillis());
        try {
            if (current.before(Res.getFrom())) {
                CarRentalDBMethods.cancelRes(c, Res);
                oos.writeUTF("Reservation ID: " + Res.getRid() + " Canceled Successfully");
                oos.flush();
            } else {
                oos.writeUTF("Cannot Cancel Reservation: Reservation Cancel Period Ended");
                oos.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(CancelReservation.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
