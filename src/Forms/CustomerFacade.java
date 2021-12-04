/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import CRSClasses.*;
import CRSClasses.Commands.*;
import java.io.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 * A Facade for the customer interface to handle operations on reservation objects
 */
public class CustomerFacade {

    ObjectInputStream ois;
    ObjectOutputStream oos;

    public CustomerFacade(ObjectInputStream ois, ObjectOutputStream oos) {
        this.ois = ois;
        this.oos = oos;
    }

    public String handle(String type, Reservation res) {
        String result;
        try {
            // For making a new reservation
            if (type.equalsIgnoreCase("MakeNew")) {
                oos.writeObject(new MakeReservation(res));
                oos.flush();
                result = ois.readUTF();
                return result;
            // For Cancelling a customer reservation
            } else if (type.equalsIgnoreCase("Cancel")) {
                oos.writeObject(new CancelReservation(res));
                oos.flush();
                result = ois.readUTF();
                        return result;
            // For initiating handover from customer
            } else if (type.equalsIgnoreCase("handover")) {
                Date current = new Date(System.currentTimeMillis());
                if (current.before(res.getFrom())){
                    return "Cannot Deliver A Car which reservation's date has not begun";
                }
                double extra_cost = res.calcPenalty(); // Calculate late penalty
                if (extra_cost > 0) { // if there is a penalty cost
                    int choice = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), "You are late on your car return, you will have to pay extra:" + extra_cost + "To resume handover.");
                    if (choice == JOptionPane.OK_OPTION) {
                        res.setAdditionalCost(extra_cost);
                        oos.writeObject(new Handover(res));
                        oos.flush();
                        return "Handover sent to admin";
                    } else {
                        return "Operation Cancelled";
                    }
                } else { // if there is no penalty then send request immediatly
                    oos.writeObject(new Handover(res));
                    oos.flush();
                    return "Handover sent to admin";
                }
            }
        } catch (IOException ex) {
            Logger.getLogger("CustomerFacadeLog").log(Level.SEVERE, "ERROR in Making new reservation", ex);
        }
        return "No valid operations found!";
    }
}
