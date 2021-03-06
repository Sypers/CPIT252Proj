/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import CRSClasses.*;
import CRSClasses.Commands.*;
import java.io.*;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class CustomerForm extends javax.swing.JFrame implements RetrieveData {

    private Customer customer;
    private Socket soc;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ArrayList<Car> cars;
    private ArrayList<Reservation> myRes;
    private DefaultTableModel Tmodel;
    private DefaultListModel Lmodel;
    private CustomerFacade handler;

    /**
     * Creates new form CustomerForm
     */
    public CustomerForm(Customer c) {
        try {
            initComponents();
            this.customer = c;
            this.soc = new Socket("localhost", 2001);
            this.oos = new ObjectOutputStream(soc.getOutputStream());
            this.ois = new ObjectInputStream(soc.getInputStream());
            this.handler = new CustomerFacade(ois, oos);
            getData();
        } catch (IOException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CustomerForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        FromText = new javax.swing.JTextField();
        ToText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CalculateButton = new javax.swing.JButton();
        MakeResButton = new javax.swing.JButton();
        CancelResButton = new javax.swing.JButton();
        DeliverCarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setText("From Date");

        jLabel2.setText("To Date");

        CalculateButton.setText("Calculate Cost");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        MakeResButton.setText("Make Reservation");
        MakeResButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeResButtonActionPerformed(evt);
            }
        });

        CancelResButton.setText("Cancel Reservation");
        CancelResButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelResButtonActionPerformed(evt);
            }
        });

        DeliverCarButton.setText("Deliver Car");
        DeliverCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliverCarButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Welcome, ....  Your Credit Balance:");

        jLabel5.setText("Active Reservations");

        jLabel6.setText("Available Cars");

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FromText)
                            .addComponent(ToText)
                            .addComponent(CalculateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MakeResButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelResButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeliverCarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FromText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ToText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalculateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MakeResButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelResButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeliverCarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefreshButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        getData();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        // TODO add your handling code here:
        try {
            Date from = Date.valueOf(FromText.getText());
            Date to = Date.valueOf(ToText.getText());
            Car car = cars.get(jList1.getSelectedIndex());
            double cost = Reservation.calcCost(car, from, to);
            JOptionPane.showMessageDialog(rootPane, "The Reservation Cost of " + from.toString() + " - " + to.toString() + " costs: " + cost, "Cost of Reservation", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(rootPane, "Enter a Valid Date (Format = YYYY-MM-DD)", "ERROR!", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(rootPane, "Please select a car from the available car list", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CalculateButtonActionPerformed
    // Creates A Reservation
    private void MakeResButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeResButtonActionPerformed
        // Get User Input from textboxes and a car from the list
        try {
            Date from = Date.valueOf(FromText.getText());
            Date to = Date.valueOf(ToText.getText());
            Car car = cars.get(jList1.getSelectedIndex());
            // Create A New Reservation Object
            Reservation Res = new Reservation(car, customer, from, to, Reservation.calcCost(car, from, to));
            // Pass The Reservation to the facade object to send request to server
            String result = handler.handle("MakeNew", Res);
            JOptionPane.showMessageDialog(rootPane, result);
            getData();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(rootPane, "Choose a car from the car list", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(rootPane, "Enter a Valid Date (Format = YYYY-MM-DD)", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_MakeResButtonActionPerformed
    // Cancel A Reservation
    private void CancelResButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelResButtonActionPerformed

        // Get Reservation from the table
        Reservation Res = myRes.get(jTable1.getSelectedRow());
        // Pass Reservation to Facade handler to send cancel request to server
        String result = handler.handle("cancel", Res);
        JOptionPane.showMessageDialog(rootPane, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        getData();
    }//GEN-LAST:event_CancelResButtonActionPerformed
    // Initiate Car Handover from customer
    private void DeliverCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliverCarButtonActionPerformed
        // Get Reservation from the table
        Reservation Res = myRes.get(jTable1.getSelectedRow());
        // Check for reservation status (must be activated to initiate handover)
        if (Res.getStatus().equalsIgnoreCase("ACTIVATED")) {
            // pass reservation to facade handler to send handover initiation request to server
            String result = handler.handle("handover", Res);
            JOptionPane.showMessageDialog(rootPane, result);
            getData();
        } else {
            JOptionPane.showMessageDialog(rootPane, "You didnt choose an ACTIVATED Reservation.");
        }
    }//GEN-LAST:event_DeliverCarButtonActionPerformed
    // Fill Table and List With Proper Data from database
    @Override
    public void getData() {
        try {
            String[] table = {"RID", "From", "To", "Return Date", "Car", "Cost", "Penalty", "Status"};
            Tmodel = new DefaultTableModel(table, 0);
            Lmodel = new DefaultListModel();
            oos.writeObject(new GetCustomerData(customer));
            oos.flush();
            cars = (ArrayList<Car>) ois.readObject();
            myRes = (ArrayList<Reservation>) ois.readObject();
            this.customer.setCredit(ois.readDouble());
            for (int i = 0; i < cars.size(); i++) {
                Lmodel.addElement(cars.get(i));
            }
            Object[] rowData = new Object[8];
            // Fill table rows
            for (int i = 0; i < myRes.size(); i++) {
                rowData[0] = myRes.get(i).getRid();
                rowData[1] = myRes.get(i).getFrom();
                rowData[2] = myRes.get(i).getTo();
                rowData[3] = myRes.get(i).getReturndate();
                rowData[4] = myRes.get(i).getCar().getName();
                rowData[5] = myRes.get(i).getCost();
                rowData[6] = myRes.get(i).getAdditionalCost();
                rowData[7] = myRes.get(i).getStatus();
                Tmodel.addRow(rowData);
            }
            jTable1.setModel(Tmodel);
            jList1.setModel(Lmodel);
            jLabel4.setText("Welcome " + this.customer.getName() + ", Your Credit Balance is " + this.customer.getCredit());
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger("CustomerLogger").log(Level.SEVERE, "Error in Displaying data\n", e.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton CancelResButton;
    private javax.swing.JButton DeliverCarButton;
    private javax.swing.JTextField FromText;
    private javax.swing.JButton MakeResButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JTextField ToText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
