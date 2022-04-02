/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danh
 */
public class JPanelTaoGv extends javax.swing.JFrame {

    /**
     * Creates new form JPanelTaoGv
     */
    DefaultTableModel model = new DefaultTableModel();
    public JPanelTaoGv() {
        initComponents();
        initData();
    }
    
    public void initData() {
        model = (DefaultTableModel) jTableGV.getModel();
        String sql = "select * from giangvien";
        model.setRowCount(0);
        try (Connection con = DataBaseHelper.getConnection();
                Statement smt = con.createStatement();) {
            Vector vt;
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                model.addRow(vt);
            }
            jTableGV.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGV = new javax.swing.JTable();
        jButtonTao = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DANH SÁCH GIẢNG VIÊN");

        jTableGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã GV", "Họ và Tên"
            }
        ));
        jTableGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGVMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableGVMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGV);

        jButtonTao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTao.setText("Tạo Login");
        jButtonTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoActionPerformed(evt);
            }
        });

        jButtonXoa.setText("Xóa Login");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonThoat.setText("Thoát");
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButtonTao)
                .addGap(107, 107, 107)
                .addComponent(jButtonXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonThoat)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTao)
                    .addComponent(jButtonXoa)
                    .addComponent(jButtonThoat))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGVMouseClicked

    }//GEN-LAST:event_jTableGVMouseClicked

    private void jTableGVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGVMousePressed

    }//GEN-LAST:event_jTableGVMousePressed

    private void jButtonTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaoActionPerformed
        // TODO add your handling code here:
        int row = jTableGV.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                "Bạn phải chọn tài khoản của giảng viên", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String maGv = jTableGV.getValueAt(row, 0).toString();
        new JPanelTaoTk(maGv).setVisible(true);

    }//GEN-LAST:event_jButtonTaoActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        
       int row = jTableGV.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this,
                        "Bạn phải chọn tài khoản của giảng viên", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int response = JOptionPane.showConfirmDialog(
                    this, "Bạn có muốn xóa tài khoản này không?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response != JOptionPane.YES_OPTION) {
                return;
            }
        
       String sql = "{call xoa_login(?)}";
            try (Connection con = DataBaseHelper.getConnection();
                PreparedStatement smt = con.prepareStatement(sql);) {
                smt.setString(1, jTableGV.getValueAt(row, 0).toString());

                smt.executeUpdate();

                JOptionPane.showMessageDialog(this, "xoa thanh cong");
               

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonThoatActionPerformed

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
            java.util.logging.Logger.getLogger(JPanelTaoGv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPanelTaoGv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPanelTaoGv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPanelTaoGv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPanelTaoGv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTao;
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGV;
    // End of variables declaration//GEN-END:variables
}