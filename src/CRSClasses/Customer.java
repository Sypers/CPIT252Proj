/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Customer implements User{
    private String id;
    private String name;
    private String email;
    private String password;
    private double credit;

    public Customer(String id,String name, String email, String password,double credit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.credit = credit;
    }

    public Customer() {
        this.name = "Omar";
        this.email = "omar2@gmail.com";
        this.password = "qwerty";
        this.credit = 500;
        this.id = "UC000";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    
    public static Customer search(String ID,ArrayList<Customer> cust) {
        for(Customer c:cust) {
            if (ID.equalsIgnoreCase(c.getId()))
                return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + " - ID: " + this.id + " - Credit: " + this.credit;
    }
    
    
}
