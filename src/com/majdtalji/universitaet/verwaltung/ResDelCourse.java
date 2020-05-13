/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majdtalji.universitaet.verwaltung;

import com.majdtalji.universitaet.db.ConnectionDataBase;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import universitaet.MainMenu;

/**
 *
 * @author Majd
 */
public class ResDelCourse extends javax.swing.JFrame {

    /**
     * Creates new form ResDelCourse
     */
    Connection con = null;
    PreparedStatement com = null;
    ResultSet rst = null;

    int value;

    public ResDelCourse() {
        initComponents();

        jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
//                setBackground(Color.getHSBColor(0, 204, 204));
                setBackground(Color.yellow);
                setForeground(Color.red);
                setFont(new Font(jTable1.getFont().getFamily(), jTable1.getFont().getStyle(), 14));
                return super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }

        });

//        tableDatabase();
    }

    private int tableDatabase(int id) {

        try {

            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT * FROM student WHERE id_student = '" + id + "'");
            rst = com.executeQuery();
            if (rst.next()) {
                //        		id_course+name_course+hour+name_doctor+salary_one_hour+semester
                con = ConnectionDataBase.getConnection();
                com = con.prepareStatement("SELECT * FROM course WHERE semester = '" + MainMenu.semester + "'");
                rst = com.executeQuery();

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                while (rst.next()) {

                    //              id_student	id_course	name_course	hour	name_doctor	mark1	mark2
                    PreparedStatement com1 = con.prepareStatement("SELECT * FROM register_student_course WHERE id_student = '" + id + "' and name_course = '" + rst.getString("name_course") + "'");
                    ResultSet rst1 = com1.executeQuery();
                    if (rst1.next()) {
                        model.addRow(new Object[]{true, rst.getString("id_course"), rst.getString("name_course"), rst.getFloat("hour"), rst.getString("name_doctor")});
                    } else {
                        model.addRow(new Object[]{false, rst.getString("id_course"), rst.getString("name_course"), rst.getFloat("hour"), rst.getString("name_doctor")});

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Die Studentnummer existiert nicht", "Existiert", 2);
                return 2;
            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }
        return 1;
    }

    private int deleteCourseFromStudent(int id) {

        try {

            con = ConnectionDataBase.getConnection();
            com = con.prepareStatement("SELECT * FROM student WHERE id_student = '" + id + "'");
            rst = com.executeQuery();
            if (rst.next()) {
                //        		id_course+name_course+hour+name_doctor+salary_one_hour+semester
                con = ConnectionDataBase.getConnection();
                com = con.prepareStatement("SELECT * FROM register_student_course WHERE id_student = '" + id + "'");
                rst = com.executeQuery();

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                while (rst.next()) {
                    //              id_student	id_course	name_course	hour	name_doctor	mark1	mark2
                    model.addRow(new Object[]{true, rst.getString("id_course"), rst.getString("name_course"), rst.getFloat("hour"), rst.getString("name_doctor")});

                }
            } else {
                JOptionPane.showMessageDialog(null, "Die Studentnummer existiert nicht", "Existiert", 2);
                return 2;
            }

        } catch (Exception e) {
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }
        return 1;
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
        jLabel1 = new javax.swing.JLabel();
        res = new javax.swing.JButton();
        del = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        install = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kurs Student hinzufügen oder löschen");
        setIconImage(new ImageIcon(getClass().getResource("/image/icon-hochschule.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Kurs Student hinzufügen oder löschen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        res.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        res.setText("Anmeldung");
        res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resActionPerformed(evt);
            }
        });

        del.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        del.setText("Abmeldung");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("Abbrechen");
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kursanmeldung", "Kursnummer", "Kursname", "Anzahl Stunden", "Kurs Doctor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 0));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 204));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        install.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        install.setText("Bestätigen");
        install.setEnabled(false);
        install.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(install, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, 69, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(res)
                    .addComponent(del)
                    .addComponent(cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(install)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(847, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resActionPerformed

        try {
            String str = JOptionPane.showInputDialog(null, "Geben Sie die Studentnummer ein!", "Kurs anmelden", JOptionPane.QUESTION_MESSAGE);
            value = Integer.parseInt(str);

            if (JOptionPane.OK_OPTION == 0 && !str.equals("")) {
                int result = tableDatabase(value);
                if (result == 1) {
                    res.setEnabled(false);
                    del.setEnabled(false);
                    cancel.setEnabled(true);
                    install.setEnabled(true);
                    install.setText("Bestätigen anmelden");
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_resActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed

        try {
            String str = JOptionPane.showInputDialog(null, "Geben Sie die Studentnummer ein!", "Kurs abmelden", JOptionPane.QUESTION_MESSAGE);
            value = Integer.parseInt(str);

            if (JOptionPane.OK_OPTION == 0 && !str.equals("")) {
                int result = deleteCourseFromStudent(value);
                if (result == 1) {
                    res.setEnabled(false);
                    del.setEnabled(false);
                    cancel.setEnabled(true);
                    install.setEnabled(true);
                    install.setText("Bestätigen abmelden");
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_delActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        res.setEnabled(true);
        del.setEnabled(true);
        cancel.setEnabled(false);
        install.setEnabled(false);
        install.setText("Bestätigen");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

    }//GEN-LAST:event_cancelActionPerformed

    private void installActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installActionPerformed

        if (install.getText().equals("Bestätigen anmelden")) {
            installInsert();
        } else {
            installDelete();
        }

    }//GEN-LAST:event_installActionPerformed

    private void installInsert() {
        //   id_student + id_course + name_course + hour + name_doctor + mark1 + mark2
        try {

            for (int row = 0; row < jTable1.getRowCount(); row++) {
                if (jTable1.getModel().getValueAt(row, 0).equals(true)) {

                    String nameCourse = jTable1.getModel().getValueAt(row, 2).toString();

                    con = ConnectionDataBase.getConnection();
                    com = con.prepareStatement("SELECT * FROM register_student_course WHERE id_student = '" + value + "' and name_course = '" + nameCourse + "'");
                    rst = com.executeQuery();

                    int idCourse = Integer.parseInt(jTable1.getModel().getValueAt(row, 1).toString());
                    float hour = Float.parseFloat(jTable1.getModel().getValueAt(row, 3).toString());
                    String nameDoctor = jTable1.getModel().getValueAt(row, 4).toString();

                    if (!rst.next()) {
                        com = con.prepareStatement("INSERT INTO `register_student_course`(`id_student`, `id_course`, `name_course`, `hour`, `name_doctor`, `mark1`, `mark2`) VALUES ('" + value + "','" + idCourse + "','" + nameCourse + "','" + hour + "','" + nameDoctor + "','0','0')");
                        com.execute();

                        {
//                            id_course+name_course+hour+name_doctor+salary_one_hour+semester
                            com = con.prepareStatement("SELECT * FROM course WHERE id_course = '" + idCourse + "'");
                            rst = com.executeQuery();
                            rst.next();
                            float hourCourse = rst.getFloat("hour");
                            float salaryOneHour = rst.getFloat("salary_one_hour");
                            float kostetKurs = hourCourse * salaryOneHour;

//                            id_student+name_student+password+mobile+gender+avg+required_amount+amount_paid+rest_of_the_fees
                            com = con.prepareStatement("SELECT * FROM student WHERE id_student = '" + value + "'");
                            rst = com.executeQuery();
                            rst.next();

                            float amountit = rst.getFloat("required_amount");
                            float restFees = rst.getFloat("rest_of_the_fees");

                            amountit += kostetKurs;
                            restFees += kostetKurs;

                            com = con.prepareStatement("UPDATE student SET required_amount ='" + amountit + "', rest_of_the_fees ='" + restFees + "' WHERE id_student='" + value + "'");
                            com.execute();
                        }
                    }

                }
            }

            JOptionPane.showMessageDialog(null, "Abschluss der Registrierung von Studentenkursen.", "Die Registrierung endet", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
                rst.close();
            } catch (Exception ex) {
            }
        }

    }

    private void installDelete() {

        try {

            for (int row = 0; row < jTable1.getRowCount(); row++) {
                if (jTable1.getModel().getValueAt(row, 0).equals(false)) {

                    String nameCourse = jTable1.getModel().getValueAt(row, 2).toString();

                    con = ConnectionDataBase.getConnection();
                    com = con.prepareStatement("DELETE FROM `register_student_course`  WHERE id_student = '" + value + "' and name_course = '" + nameCourse + "'");
                    com.execute();

                    {
//                            id_course+name_course+hour+name_doctor+salary_one_hour+semester
                            com = con.prepareStatement("SELECT * FROM course WHERE name_course = '" + nameCourse + "'");
                            rst = com.executeQuery();
                            rst.next();
                            float hourCourse = rst.getFloat("hour");
                            float salaryOneHour = rst.getFloat("salary_one_hour");
                            float kostetKurs = hourCourse * salaryOneHour;

//                            id_student+name_student+password+mobile+gender+avg+required_amount+amount_paid+rest_of_the_fees
                            com = con.prepareStatement("SELECT * FROM student WHERE id_student = '" + value + "'");
                            rst = com.executeQuery();
                            rst.next();

                            float amountit = rst.getFloat("required_amount");
                            float restFees = rst.getFloat("rest_of_the_fees");

                            amountit -= kostetKurs;
                            restFees -= kostetKurs;

                            com = con.prepareStatement("UPDATE student SET required_amount ='" + amountit + "', rest_of_the_fees ='" + restFees + "' WHERE id_student='" + value + "'");
                            com.execute();
                        }
                }
            }

            JOptionPane.showMessageDialog(null, "Abschluss der Stornierung von Studentenkursen.", "Die Stornierung endet", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
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
            java.util.logging.Logger.getLogger(ResDelCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResDelCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResDelCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResDelCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResDelCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton del;
    private javax.swing.JButton install;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton res;
    // End of variables declaration//GEN-END:variables
}
