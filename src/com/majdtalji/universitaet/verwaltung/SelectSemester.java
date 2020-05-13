/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majdtalji.universitaet.verwaltung;

import com.majdtalji.universitaet.db.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import universitaet.MainMenu;

/**
 *
 * @author Majd
 */
public class SelectSemester extends javax.swing.JFrame {

    /**
     * Creates new form SelectSemester
     */
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;

    String semester;

    public SelectSemester() {
        initComponents();

        selectSemester();
    }

    private void selectSemester() {

        try {
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT * FROM semester");
            rst = com.executeQuery();

            rst.next();
            if (Integer.parseInt(rst.getString("first")) == 1) {
                semester = first.getText();
                first.setSelected(true);
            } else {
                semester = second.getText();
                second.setSelected(true);
            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        first = new javax.swing.JRadioButton();
        second = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Semester auswählen");
        setIconImage(new ImageIcon(getClass().getResource("/image/icon-hochschule.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ändern Semester");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(first);
        first.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        first.setForeground(new java.awt.Color(0, 0, 255));
        first.setText("Erstes Semester");

        buttonGroup1.add(second);
        second.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        second.setForeground(new java.awt.Color(0, 0, 255));
        second.setText("Zweites Semester");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Bearbeiten Semester");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(first)
                        .addGap(18, 18, 18)
                        .addComponent(second))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first)
                    .addComponent(second))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(330, 184));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (first.isSelected()) {
            if (first.getText().equals(semester)) {
                JOptionPane.showMessageDialog(null, "Kann nicht geändert werden, da das Semester bereits läuft!");
            } else {
                updateFirst();
            }
        } else if (second.isSelected()) {
            if (second.getText().equals(semester)) {
                JOptionPane.showMessageDialog(null, "Kann nicht geändert werden, da das Semester bereits läuft!");
            } else {
                updateSecond();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateFirst() {

        try {
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("UPDATE semester SET first ='1',second ='0'");
            com.execute();

            JOptionPane.showMessageDialog(null, "Die Änderung wurde auf das erste Semester vorgenommen");
            semester = first.getText();
            MainMenu.semester = 1;

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }

    }

    private void updateSecond() {

        try {
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("UPDATE semester SET first ='0',second ='1'");
            com.execute();

            JOptionPane.showMessageDialog(null, "Die Änderung wurde auf das zweite Semester vorgenommen");
            semester = second.getText();
            MainMenu.semester = 2;

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
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
            java.util.logging.Logger.getLogger(SelectSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectSemester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton first;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton second;
    // End of variables declaration//GEN-END:variables
}
