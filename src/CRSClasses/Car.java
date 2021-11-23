package CRSClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hammo
 */
public class Car implements Serializable {
    private String cid;
    private String name;
    private int model;
    private boolean available;
    private double cost;

    public Car(){
        this.cid = "C334";
        this.name = "Honda Civic";
        this.model = 2019;
        this.available = true;
        this.cost = 190;
    }
    
    public Car(String name, int model, int cost) {
        this.name = name;
        this.model = model;
        this.cost = cost;
        this.available = true;
    }

    public Car(String cid, String name, int model, boolean available, double cost) {
        this.cid = cid;
        this.name = name;
        this.model = model;
        this.available = available;
        this.cost = cost;
    }
    
    
    
    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public static Car search (String c,ArrayList<Car> arr){
        for(Car SCar:arr) {
            if (c.equalsIgnoreCase(SCar.getCid()))
                return SCar;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getModel();
    }  

}