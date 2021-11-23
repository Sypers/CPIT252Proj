/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses.Commands;

import CRSClasses.CarRentalDBMethods;
import CRSClasses.Reservation;
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
public class MakeReservation implements Command {
    
    Reservation Res;
    
    public MakeReservation(Reservation Res) {
        this.Res = Res;
    }
    
    @Override
    public void execute(ObjectInputStream ois, ObjectOutputStream oos, Connection c) {
        try {
            System.out.println(Res.getCus());
            Res.setRid("R" + (CarRentalDBMethods.countRes(c) + 1));
            String check = Res.checkRentals(CarRentalDBMethods.getActiveRes(c));
            if (Res.getTo().compareTo(Res.getFrom()) > 0) {                
                if (Res.getFrom().after(new Date(System.currentTimeMillis()))) {
                    if (check.equalsIgnoreCase("ok")) {
                        if (Res.getCus().getCredit() >= Res.getCost()) {
                            Res.getCus().setCredit(Res.getCus().getCredit() - Res.getCost());
                            CarRentalDBMethods.updateCredit(c, Res.getCus());
                            oos.writeUTF(check);
                            Res.setStatus("ACTIVATED");
                            CarRentalDBMethods.addRes(c, Res);
                        } else {
                            check = "Your Credit Balance is insufficient, Credit: " + Res.getCus().getCredit() + " | Cost:" + Res.getCost();
                            oos.writeUTF(check);
                        }
                    } else {
                        oos.writeUTF(check);
                    }
                } else {
                    oos.writeUTF("Cant choose a date before today's date");
                }
            } else {
                oos.writeUTF("The start date has to be before the finish date");
            }
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(MakeReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
