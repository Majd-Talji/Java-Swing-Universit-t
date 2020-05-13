/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majdtalji.universitaet.student;

import com.majdtalji.universitaet.db.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import universitaet.Login;

/**
 *
 * @author Majd
 */
public class Avarge extends javax.swing.JFrame {

    /**
     * Creates new form Avarge
     */
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;

    public Avarge() {
        initComponents();

        id.setText(Login.id);
        name.setText(Login.user);

        info();
    }

    private void info() {

        float total = 0;
        float countHours = 0;
        float countFail = 0;
        try {
            //          //            id_student + id_course + name_course + hour + name_doctor + mark1 + mark2
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT mark1, mark2, hour FROM register_student_course WHERE id_student = '" + Integer.parseInt(Login.id) + "'");
            rst = com.executeQuery();

            while (rst.next()) {

                float sum = rst.getFloat("mark1") + rst.getFloat("mark2");
                countHours += rst.getFloat("hour");
                total += (sum * rst.getFloat("hour"));

                if (sum < 60) {
                    countFail += rst.getFloat("hour");
                }

            }

            float avg = total / countHours;
            avgLabel.setText(String.valueOf(avg));
            greateLabel.setText(KashfMark.tagder(avg));

            nS.setText(String.valueOf(countHours - countFail) + " Stunde");
            nF.setText(String.valueOf(countFail) + " Stunde");

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

        jPanel1 = new javax.swing.JPanel();
        oldPassLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        oldPassLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        oldPassLabel1 = new javax.swing.JLabel();
        avgLabel = new javax.swing.JLabel();
        oldPassLabel3 = new javax.swing.JLabel();
        greateLabel = new javax.swing.JLabel();
        oldPassLabel4 = new javax.swing.JLabel();
        oldPassLabel5 = new javax.swing.JLabel();
        nF = new javax.swing.JLabel();
        nS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kumulierte GPA");
        setIconImage(new ImageIcon(getClass().getResource("/image/icon-hochschule.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        oldPassLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel.setText("Student Nummer :");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setText("-----------------");

        oldPassLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel2.setText("Student Name :");

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setText("-----------------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oldPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(oldPassLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel)
                    .addComponent(id)
                    .addComponent(oldPassLabel2)
                    .addComponent(name))
                .addContainerGap())
        );

        oldPassLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel1.setForeground(new java.awt.Color(0, 0, 255));
        oldPassLabel1.setText("Kumulatives GPA :");

        avgLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        avgLabel.setText("-----------------");

        oldPassLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel3.setForeground(new java.awt.Color(0, 0, 255));
        oldPassLabel3.setText("Allgemeine Wertschätzung des Students :");

        greateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greateLabel.setText("-----------------");

        oldPassLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel4.setForeground(new java.awt.Color(0, 0, 255));
        oldPassLabel4.setText("Anzahl der Stunden des Erfolgs :");

        oldPassLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel5.setForeground(new java.awt.Color(0, 0, 255));
        oldPassLabel5.setText("Anzahl der Stunden der Durchfallen :");

        nF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nF.setText("-----------------");

        nS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nS.setText("-----------------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oldPassLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oldPassLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(greateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oldPassLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nS, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oldPassLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel1)
                    .addComponent(avgLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel3)
                    .addComponent(greateLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel4)
                    .addComponent(nS))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel5)
                    .addComponent(nF))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(564, 238));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Avarge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avarge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avarge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avarge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Avarge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avgLabel;
    private javax.swing.JLabel greateLabel;
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nF;
    private javax.swing.JLabel nS;
    private javax.swing.JLabel name;
    private javax.swing.JLabel oldPassLabel;
    private javax.swing.JLabel oldPassLabel1;
    private javax.swing.JLabel oldPassLabel2;
    private javax.swing.JLabel oldPassLabel3;
    private javax.swing.JLabel oldPassLabel4;
    private javax.swing.JLabel oldPassLabel5;
    // End of variables declaration//GEN-END:variables
}
