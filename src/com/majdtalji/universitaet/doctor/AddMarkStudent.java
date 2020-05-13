/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majdtalji.universitaet.doctor;

import com.majdtalji.universitaet.db.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import universitaet.Login;
import javax.swing.ImageIcon;

/**
 *
 * @author Majd
 */
public class AddMarkStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddMarkStudent
     */
    int idStudent;
    boolean trueFalse = false;

    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;

    public AddMarkStudent() {
        initComponents();

        String idStr = JOptionPane.showInputDialog(null, "Geben Sie die Studentnummer ein.");
        idStudent = Integer.parseInt(idStr);

        info();
        courseDoctor();
    }

    private void courseDoctor() {

        PreparedStatement com1 = null;
        ResultSet rst1 = null;

        try {
//            id_course+name_course+hour+name_doctor+salary_one_hour+semester
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT * FROM course WHERE name_doctor = '" + Login.user + "'");
            rst = com.executeQuery();

            while (rst.next()) {
                //            id_student + id_course + name_course + hour + name_doctor + mark1 + mark2
                com1 = con.prepareStatement("SELECT * FROM register_student_course WHERE id_student = '" + idStudent + "' and name_course = '" + rst.getString("name_course") + "'");
                rst1 = com1.executeQuery();
                if (rst1.next()) {
                    chooseCourse.addItem(rst.getString("name_course"));
                }
            }

            chooseCourse.setSelectedIndex(-1);
            trueFalse = true;

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }
    }

    private void info() {
        //id_student + name_student + password + mobile + gender + avg + required_amount + amount_paid + rest_of_the_fees
        try {
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT * FROM student WHERE id_student = '" + idStudent + "'");
            rst = com.executeQuery();

            if (rst.next()) {

                id.setText(idStudent + "");
                name.setText(rst.getString("name_student"));
                this.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Die Studentnummer existiert nicht", "Existiert", 2);
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

        jPanel1 = new javax.swing.JPanel();
        oldPassLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        oldPassLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        oldPassLabel4 = new javax.swing.JLabel();
        speichern = new javax.swing.JButton();
        oldPassLabel5 = new javax.swing.JLabel();
        mark1 = new javax.swing.JTextField();
        mark2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chooseCourse = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Punkte hinzufügen");
        setIconImage(new ImageIcon(getClass().getResource("/image/icon-hochschule.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(oldPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldPassLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel)
                    .addComponent(id)
                    .addComponent(oldPassLabel2)
                    .addComponent(name))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        oldPassLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel4.setText("Mittelpunkt von 50");

        speichern.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        speichern.setForeground(new java.awt.Color(255, 0, 0));
        speichern.setText("Speichern");
        speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichernActionPerformed(evt);
            }
        });

        oldPassLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oldPassLabel5.setText("Endlichpunkt von 50");

        mark1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mark1.setEnabled(false);

        mark2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mark2.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Kurs auswählen");

        chooseCourse.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        chooseCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chooseCourseItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addComponent(chooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(oldPassLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oldPassLabel5)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mark1)
                            .addComponent(mark2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(speichern, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chooseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel4)
                    .addComponent(mark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassLabel5)
                    .addComponent(mark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(speichern)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(633, 243));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichernActionPerformed

        if (chooseCourse.getSelectedIndex() != -1) {

            float m1, m2;

            m1 = Float.parseFloat(mark1.getText());
            if (mark1.getText().equals("")) {
                m1 = 0;
            }

            m2 = Float.parseFloat(mark2.getText());
            if (mark2.getText().equals("")) {
                m2 = 0;
            }

            try {
                con = ConnectionDataBase.getConnection();
                com = con.prepareStatement("UPDATE `register_student_course` SET `mark1`='" + m1 + "',`mark2`='" + m2 + "' WHERE id_student = '" + idStudent + "' and name_course = '" + chooseCourse.getSelectedItem().toString() + "'");
                com.execute();

                JOptionPane.showMessageDialog(null, "Dem Student wurden Punkte hinzugefügt.");

                chooseCourse.setSelectedIndex(-1);

                mark1.setText("");
                mark1.setEnabled(false);
                mark2.setText("");
                mark2.setEnabled(false);

                updateDataBaseAVG();

            } catch (Exception e) {
            } finally {
                try {
                    con.close();
                    rst.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", 2);

                }
            }
        } else {

            JOptionPane.showMessageDialog(null, "Wählen Sie den Kurs aus.", "Wahl", 2);

        }

    }//GEN-LAST:event_speichernActionPerformed

    private void updateDataBaseAVG() {

        float sumMark = 0;
        float countMark = 0;
        try {
            //          //            id_student + id_course + name_course + hour + name_doctor + mark1 + mark2
            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT mark1, mark2 FROM register_student_course WHERE id_student = '" + idStudent + "'");
            rst = com.executeQuery();

            while (rst.next()) {

                float sum = rst.getFloat("mark1") + rst.getFloat("mark2");
                if (sum >= 60) {
                    sumMark += sum;
                    countMark++;
                }

            }

            float avg = sumMark / (countMark == 0 ? 1 : countMark);

            //id_student + name_student + password + mobile + gender + avg + required_amount + amount_paid + rest_of_the_fees
            com = con.prepareStatement("UPDATE student SET avg='" + avg + "' WHERE id_student='" + idStudent + "'");
            com.execute();

        } catch (Exception e) {

        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }

    }

    private void chooseCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chooseCourseItemStateChanged

        if (trueFalse && chooseCourse.getSelectedIndex() != -1) {

//            PreparedStatement com1 = null;
//            ResultSet rst1 = null;
            try {

                //            id_student + id_course + name_course + hour + name_doctor + mark1 + mark2
                con = ConnectionDataBase.getConnection();
                com = con.prepareStatement("SELECT mark1 , mark2 FROM register_student_course WHERE id_student = '" + idStudent + "' and name_course = '" + chooseCourse.getSelectedItem().toString() + "'");
                rst = com.executeQuery();

                if (rst.next()) {

                    mark1.setText(rst.getFloat("mark1") + "");
                    mark2.setText(rst.getFloat("mark2") + "");

                    mark1.setEnabled(true);
                    mark2.setEnabled(true);

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
    }//GEN-LAST:event_chooseCourseItemStateChanged

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
            java.util.logging.Logger.getLogger(AddMarkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMarkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMarkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMarkStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMarkStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chooseCourse;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mark1;
    private javax.swing.JTextField mark2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel oldPassLabel;
    private javax.swing.JLabel oldPassLabel2;
    private javax.swing.JLabel oldPassLabel4;
    private javax.swing.JLabel oldPassLabel5;
    private javax.swing.JButton speichern;
    // End of variables declaration//GEN-END:variables
}