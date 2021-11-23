/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses;

import CRSClasses.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hammo
 */
public class CarRentalDBMethods {

    public static double getCustCredit(Connection c,String id) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = c.prepareStatement("select credit from user where id=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            double credit = rs.getDouble(1);
            return credit;
        } catch (SQLException e) {
            System.out.println(e);
            return -10000.0;
        }
    }
    
    public static Customer getCust(Connection c, String searchid) {
        PreparedStatement ps;
        ResultSet rs;
        Customer cust = null;
        try {
            ps = c.prepareStatement("select * from user where id=?");
            ps.setString(1, searchid);
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString(1);
            String Cname = rs.getString(2);
            String email = rs.getString(3);
            String pass = rs.getString(4);
            double credit = rs.getDouble(5);
            cust = new Customer(id, Cname, email, pass, credit);
            return cust;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Car> getCars(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Car> allcars = new ArrayList<>();
        try {
            ps = c.prepareStatement("select * from CAR");
            rs = ps.executeQuery();
            while (rs.next()) {
                String cid = rs.getString(1);
                String name = rs.getString(2);
                int model = rs.getInt(3);
                boolean available = rs.getBoolean(4);
                double cost = rs.getDouble(5);
                Car car;
                car = new Car(cid, name, model, available, cost);    
                allcars.add(car);
            }
            return allcars;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Car> getAvailCars(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ps = c.prepareStatement("select * from CAR where isAvailable=1");
            rs = ps.executeQuery();
            while (rs.next()) {
                String cid = rs.getString(1);
                String name = rs.getString(2);
                int model = rs.getInt(3);
                boolean available = rs.getBoolean(4);
                double cost = rs.getDouble(5);
                Car car;
                car = new Car(cid, name, model, available, cost);    
                cars.add(car);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return cars;
        }
    }

    public static ArrayList<Reservation> getActiveRes(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Reservation> allres = new ArrayList<>();
        ArrayList<Car> allcars = getCars(c);
        ArrayList<Customer> allcust = getCustomers(c);
        try {
            ps = c.prepareStatement("select * from RESERVATION where status='ACTIVATED'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String rid = rs.getString(1);
                String ssn = rs.getString(2);
                String carid = rs.getString(3);
                java.sql.Date from = rs.getDate(4);
                java.sql.Date to = rs.getDate(5);
                java.sql.Date returnD = rs.getDate(6);
                String state = rs.getString(7);
                double cost = rs.getDouble(8);
                double AdditionalCost = rs.getDouble(9);
                Car car = Car.search(carid, allcars);
                Customer cust = Customer.search(ssn, allcust);
                allres.add(new Reservation(rid, car, cust, from, to, returnD, state, cost,AdditionalCost));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return allres;
        }
    }

    public static ArrayList<Reservation> getHandovers(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Reservation> allres = new ArrayList<>();
        ArrayList<Car> allcars = getCars(c);
        ArrayList<Customer> allcust = getCustomers(c);
        try {
            ps = c.prepareStatement("select * from RESERVATION where status='Handover'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String rid = rs.getString(1);
                String ssn = rs.getString(2);
                String carid = rs.getString(3);
                java.sql.Date from = rs.getDate(4);
                java.sql.Date to = rs.getDate(5);
                java.sql.Date returnD = rs.getDate(6);
                String state = rs.getString(7);
                double cost = rs.getDouble(8);
                double AdditionalCost = rs.getDouble(9);
                Car car = Car.search(carid, allcars);
                Customer cust = Customer.search(ssn, allcust);
                allres.add(new Reservation(rid, car, cust, from, to, returnD, state, cost,AdditionalCost));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return allres;
        }
    }

    public static ArrayList<Reservation> getRes(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Reservation> allres = new ArrayList<>();
        ArrayList<Car> allcars = getCars(c);
        ArrayList<Customer> allcust = getCustomers(c);
        try {
            ps = c.prepareStatement("select * from RESERVATION");
            rs = ps.executeQuery();
            while (rs.next()) {
                String rid = rs.getString(1);
                String ssn = rs.getString(2);
                String carid = rs.getString(3);
                java.sql.Date from = rs.getDate(4);
                java.sql.Date to = rs.getDate(5);
                java.sql.Date returnD = rs.getDate(6);
                String state = rs.getString(7);
                double cost = rs.getDouble(8);
                double AdditionalCost = rs.getDouble(9);
                Car car = Car.search(carid, allcars);
                Customer cust = Customer.search(ssn, allcust);
                allres.add(new Reservation(rid, car, cust, from, to, returnD, state, cost,AdditionalCost));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return allres;
        }
    }

    public static ArrayList<Customer> getCustomers(Connection c) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Customer> custs = new ArrayList<>();
        try {
            ps = c.prepareStatement("select * from User where id like 'UC%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                double credit = rs.getDouble(5);
                Customer cust = new Customer(id, name, email, pass, credit);
                custs.add(cust);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            return custs;
        }
    }

    public static ArrayList<Reservation> getCustRes(Connection c, Customer cust) {
        ArrayList<Reservation> CustRes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Car> allcars = getCars(c);
        try {
            ps = c.prepareStatement("select * from reservation where CustomerID=?");
            ps.setString(1, cust.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                String rid = rs.getString(1);
                String ssn = rs.getString(2);
                String carid = rs.getString(3);
                java.sql.Date from = rs.getDate(4);
                java.sql.Date to = rs.getDate(5);
                java.sql.Date returnD = rs.getDate(6);
                String state = rs.getString(7);
                double cost = rs.getDouble(8);
                double AdditionalCost = rs.getDouble(9);
                Car car = Car.search(carid, allcars);
                Reservation res = new Reservation(rid, car, cust, from, to, returnD, state, cost,AdditionalCost);
                CustRes.add(res);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            return CustRes;
        }
    }

    public static int countRes(Connection c) {
        int x = 0;
        try {

            PreparedStatement ps = c.prepareStatement("select count(*) from reservation");
            ResultSet rs = ps.executeQuery();
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return x;
    }

    public static int countCust(Connection c) {
        int x = 0;
        try {
            PreparedStatement ps = c.prepareStatement("select count(*) from user");
            ResultSet rs = ps.executeQuery();
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return x;
    }

    public static int countCar(Connection c) {
        int x = 0;
        try {
            PreparedStatement ps = c.prepareStatement("select count(*) from car");
            ResultSet rs = ps.executeQuery();
            rs.next();
            x = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return x;
    }

    public static void addRes(Connection c, Reservation rv) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("insert into reservation values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, rv.getRid());
            ps.setString(2, rv.getCus().getId());
            ps.setString(3, rv.getCar().getCid());
            ps.setDate(4, (Date) rv.getFrom());
            ps.setDate(5, (Date) rv.getTo());
            ps.setDate(6, (Date) rv.getReturndate());
            ps.setString(7, rv.getStatus());
            ps.setDouble(8, rv.getCost());
            ps.setDouble(9, rv.getAdditionalCost());
            boolean result = ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addCust(Connection c, Customer cust) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("inesrt into user values (?,?,?,?,?)");
            ps.setString(1, cust.getId());
            ps.setString(2, cust.getName());
            ps.setString(3, cust.getEmail());
            ps.setString(4, cust.getPassword());
            ps.setDouble(5, cust.getCredit());
            ps.execute();
            System.out.println("Customer Registered");
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalDBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void changeAvailability(Connection c, Car car) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = c.prepareStatement("select * from car where id=?");
            ps.setString(1, car.getCid());
            rs = ps.executeQuery();
            rs.next();
            boolean avail = rs.getBoolean("isavailable");
            if (avail) {
//                rs.next();
//                rs.updateBoolean("available", false);
//                rs.updateRow();
                ps = c.prepareStatement("update car set isAvailable='0' where id=?");
                ps.setString(1, car.getCid());
                ps.execute();
            } else {
//                rs.next();
//                rs.updateBoolean("available", true);
//                rs.updateRow();
                ps = c.prepareStatement("update car set isAvailable='1' where id=?");
                ps.setString(1, car.getCid());
                ps.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }

    public static void changeReservation(Connection c, Reservation old, Reservation newR) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("update reservation set fromDate=?,toDate=?,returnDate=null,cost=?,cid=?,status=? where rid=?");
            ps.setDate(1, (Date) newR.getFrom());
            ps.setDate(2, (Date) newR.getTo());
            ps.setDouble(3, newR.getCost());
            ps.setString(4, newR.getCar().getCid());
            ps.setString(5, newR.getStatus());
            ps.setString(6, old.getRid());
            ps.execute();
            System.out.println("Reservation Updated!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void updateCredit(Connection c, Customer cust) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("update user set credit = ? where id=?");
            ps.setDouble(1, cust.getCredit());
            ps.setString(2, cust.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalDBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateRes(Connection c, Reservation old, Reservation newR) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("update reservation set fromDate=? , toDate=?, cost=? where id=?");
            ps.setDate(1, (Date) newR.getFrom());
            ps.setDate(2, (Date) newR.getTo());
            ps.setDouble(3, newR.getCost());
            ps.setString(4, old.getRid());
            int executeUpdate = ps.executeUpdate();
            System.out.println("Res. Updated: " + executeUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalDBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cancelRes(Connection c, Reservation res) {
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("update reservation set status='Canceled' where id=?");
            ps.setString(1, res.getRid());
            ps.execute();            
            ps = c.prepareStatement("update user set credit=? where id=?");
            ps.setDouble(1, res.getCost() + res.getCus().getCredit());
            ps.setString(2, res.getCus().getId());
            ps.execute();            
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalDBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Used by the customer and admin
    public static void Handover(Connection c, Reservation R) {
        PreparedStatement ps;
        try {
            if (R.getStatus().equalsIgnoreCase("Handover")) {
                ps = c.prepareStatement("update reservation set status='Handover' where id=?");
                ps.setString(1, R.getRid());
                ps.executeUpdate();
            } else if (R.getStatus().equalsIgnoreCase("Ended")) {
                ps = c.prepareStatement("update reservation set status='Ended' , ReturnDate=?, penalty=? where id=?");
                ps.setDate(1, (Date) R.getReturndate());
                ps.setDouble(2, R.getAdditionalCost());
                ps.setString(3, R.getRid());
                ps.executeUpdate();
                if (R.getReturndate().after(R.getTo())) {
                    R.getCus().setCredit(R.getCus().getCredit() - R.calcPenalty());
                    updateCredit(c, R.getCus());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalDBMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
