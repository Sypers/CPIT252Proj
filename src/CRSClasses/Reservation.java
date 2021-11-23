package CRSClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hammo
 */
public class Reservation implements ReservationPrototype,Serializable {

    private String rid;
    private Car car;
    private Customer cus;
    private Date from;
    private Date to;
    private Date Returndate;
    private String Status;
    private double cost,AdditionalCost;

    public Reservation() {
        this.rid = "R0234";
        this.car = new Car();
        this.cus = new Customer();
        this.from = new Date();
        this.to = to;
        this.Status = "UNCOFIRMED";
        this.cost = calcCost(car, from, to);
        this.AdditionalCost = 0;
    }
    
    public Reservation(Car car, Customer cus, Date from, Date to, double cost) {
        this.rid = "TBD";
        this.car = car;
        this.cus = cus;
        this.from = from;
        this.to = to;
        this.Status = "UNCOFIRMED";
        this.cost = calcCost(car, from, to);
        this.AdditionalCost = 0;
    }

    public Reservation(String rid, Car car, Customer cus, Date from, Date to, Date Returndate, String Active, double cost,double Additional) {
        this.rid = rid;
        this.car = car;
        this.cus = cus;
        this.from = from;
        this.to = to;
        this.Returndate = Returndate;
        this.Status = Active;
        this.cost = cost;
        this.AdditionalCost = this.AdditionalCost;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Date getReturndate() {
        return Returndate;
    }

    public void setReturndate(Date Returndate) {
        this.Returndate = Returndate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //Car car, Customer cus, Date from, Date to,
    public String checkRentals(ArrayList<Reservation> r) {
        for (Reservation rv : r) {
            if (!this.getRid().equals(rv.getRid())) {
                if (this.getCar().getCid().equals(rv.getCar().getCid())) {
                    if (rv.getStatus().equalsIgnoreCase("ACTIVATED")) {
                        if (this.getFrom().before(rv.getTo()) && rv.getFrom().before(this.getTo())) {
                            return "This Car is Unavailable from:" + rv.getFrom().toString() + " To: " + rv.getTo().toString();
                        }
                    }
                }
            }
        }
        return "OK";
    }

    public double calcChangeCost(Date from, Date to) {
        double d = 0;
        d = this.getCost() + (to.getTime() - from.getTime() / (1000 * 60 * 60 * 24) % 365) * 70;
        return d;
    }

    public static double calcCost(Car c, Date from, Date to) {
        double diff = to.getTime() - from.getTime();
        diff = TimeUnit.DAYS.convert((long) diff,TimeUnit.MILLISECONDS);
        double x = c.getCost() * diff;
        return x;
    }

    public double calcPenalty() {
        double diff = new Date().getTime() - this.getTo().getTime();
        diff = TimeUnit.DAYS.convert((long) diff,TimeUnit.MILLISECONDS);
        double x = (this.getCar().getCost() * diff * 1.30);
        return x;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Active) {
        this.Status = Active;
    }

    @Override
    public Reservation cloneRes() {
        try {
            return (Reservation) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public double getAdditionalCost() {
        return AdditionalCost;
    }

    public void setAdditionalCost(double AdditionalCost) {
        this.AdditionalCost = AdditionalCost;
    }

    @Override
    public String toString() {
        return "Reservation{" + "rid=" + rid + ", car=" + car + ", cus=" + cus + ", from=" + from + ", to=" + to + ", Returndate=" + Returndate + ", Status=" + Status + ", cost=" + cost + ", AdditionalCost=" + AdditionalCost + '}';
    }
}
