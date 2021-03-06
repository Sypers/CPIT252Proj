/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import CRSClasses.*;
import CRSClasses.Commands.ConfirmDelivery;
import CRSClasses.Commands.GetAdminData;
import CRSClasses.Commands.SwitchAvailablity;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class AdminForm extends javax.swing.JFrame implements RetrieveData {

    Admin admin;
    private Socket soc;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ArrayList<Car> cars;
    private ArrayList<Reservation> myRes; // for active reservations
    private ArrayList<Reservation> myResHandOver; // for reservations ready to be delivered
    private DefaultTableModel Tmodel;
    private DefaultTableModel Tmode2;
    private DefaultTableModel Tmode3;

    public AdminForm() {
        initComponents();
    }

    AdminForm(Admin admin) {
        try {
            initComponents();
            this.admin = admin;
            this.soc = new Socket("localhost", 2001);
            this.oos = new ObjectOutputStream(soc.getOutputStream());
            this.ois = new ObjectInputStream(soc.getInputStream());
            jLabel4.setText("Logged in as: " + admin.getName());
            getData();
        } catch (IOException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ConfirmDelivery = new javax.swing.JButton();
        SwitchAva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Referesh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        ConfirmDelivery.setText("Confirm Delivery");
        ConfirmDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmDeliveryActionPerformed(evt);
            }
        });

        SwitchAva.setText("Switch Availability");
        SwitchAva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwitchAvaActionPerformed(evt);
            }
        });

        jLabel1.setText("Active Reservation");

        jLabel2.setText("Reservations Ready to be Finished");

        jLabel3.setText("Car List");

        Referesh.setText("Referesh");
        Referesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefereshActionPerformed(evt);
            }
        });

        jLabel4.setText("Logged in as: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Referesh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ConfirmDelivery)
                                    .addComponent(SwitchAva)
                                    .addComponent(jLabel4))
                                .addContainerGap(79, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ConfirmDelivery)
                        .addGap(87, 87, 87)))
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SwitchAva)
                        .addGap(64, 64, 64)
                        .addComponent(Referesh))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefereshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefereshActionPerformed
        getData();
    }//GEN-LAST:event_RefereshActionPerformed
    // Continue handover from admin side
    private void ConfirmDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmDeliveryActionPerformed
        try {
            oos.writeObject(new ConfirmDelivery(myResHandOver.get(jTable3.getSelectedRow())));
        } catch (Exception e) {
            Logger.getLogger("AdminLogger").log(Level.SEVERE, "Error in Confirm Delivery data\n", e.toString());
        }
    }//GEN-LAST:event_ConfirmDeliveryActionPerformed
    // Switch car availability to customers
    private void SwitchAvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwitchAvaActionPerformed
        try {
            Car C = cars.get(jTable1.getSelectedRow());
            oos.writeObject(new SwitchAvailablity(C));
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger("AdminLogger").log(Level.SEVERE, "Error in Switch Availability\n", ex.toString());
        }
    }//GEN-LAST:event_SwitchAvaActionPerformed
     // Fill Tables with proper data
    @Override
    public void getData() {
        String[] table2 = {"RID", "From", "To", "Return Date", "Car", "Cost", "Penalty", "Status"};
        Tmode2 = new DefaultTableModel(table2, 0);
        String[] table1 = {"CID", "Name", "Model", "Available", "Cost"};
        Tmodel = new DefaultTableModel(table1, 0);
        try {
            oos.writeObject(new GetAdminData(admin));
            oos.flush();
            cars = (ArrayList<Car>) ois.readObject();
            Object[] rowData = new Object[5];
            for (int i = 0; i < cars.size(); i++) {
                rowData[0] = cars.get(i).getCid();
                rowData[1] = cars.get(i).getName();
                rowData[2] = cars.get(i).getModel();
                rowData[3] = cars.get(i).isAvailable();
                rowData[4] = cars.get(i).getCost();
                Tmodel.addRow(rowData);
            }
            jTable1.setModel(Tmodel);
            //================================================================================
            myRes = (ArrayList<Reservation>) ois.readObject();
            Object[] rowData1 = new Object[8];
            for (int i = 0; i < myRes.size(); i++) {
                rowData1[0] = myRes.get(i).getRid();
                rowData1[1] = myRes.get(i).getFrom();
                rowData1[2] = myRes.get(i).getTo();
                rowData1[3] = myRes.get(i).getReturndate();
                rowData1[4] = myRes.get(i).getCar();
                rowData1[5] = myRes.get(i).getCost();
                rowData1[6] = myRes.get(i).getAdditionalCost();
                rowData1[7] = myRes.get(i).getStatus();
                Tmode2.addRow(rowData1);
            }
            jTable2.setModel(Tmode2);
            //=================================================================================
            Tmode3 = new DefaultTableModel(table2, 0);
            myResHandOver = (ArrayList<Reservation>) ois.readObject();
            Object[] rowData2 = new Object[8];
            for (int i = 0; i < myResHandOver.size(); i++) {

                rowData1[0] = myResHandOver.get(i).getRid();
                rowData2[1] = myResHandOver.get(i).getFrom();
                rowData2[2] = myResHandOver.get(i).getTo();
                rowData2[3] = myResHandOver.get(i).getReturndate();
                rowData2[4] = myResHandOver.get(i).getCar();
                rowData2[5] = myResHandOver.get(i).getCost();
                rowData2[6] = myResHandOver.get(i).getAdditionalCost();
                rowData2[7] = myResHandOver.get(i).getStatus();
                Tmode3.addRow(rowData2);

            }
            jTable3.setModel(Tmode3);

        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger("AdminLogger").log(Level.SEVERE, "Error in Displaying data\n", e.toString());
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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmDelivery;
    private javax.swing.JButton Referesh;
    private javax.swing.JButton SwitchAva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
   
}
