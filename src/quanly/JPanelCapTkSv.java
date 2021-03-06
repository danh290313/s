/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly;

import design.DataBaseHelper;
import java.awt.Color;
import java.awt.Font;
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
public class JPanelCapTkSv extends javax.swing.JPanel {

    /**
     * Creates new form JPanelCapTkSv
     */
    public JPanelCapTkSv() {
        initComponents();
        initData();
        jButtonXoa.setEnabled(false);
        jLabelMaSv.setForeground(Color.RED);
        jTableDSSV.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 14));
    }
    boolean  flag2 = false, flag3 = false;
    DefaultTableModel model = new DefaultTableModel();
    public void initData()
    {   
        model = (DefaultTableModel) jTableDSSV.getModel();
        String sql = "SELECT masv,hoten,phai,ngaysinh,diachi, CASE WHEN (masv IN (SELECT maTK FROM taikhoan)) THEN 1  ELSE 0\n" +
"END AS DATAOTK FROM sinhvien order by cast(substring(MaSV,3,10) as int)";
        model.setRowCount(0);
        try(Connection con = DataBaseHelper.getConnection();
                Statement smt = con.createStatement();)
        {   
            Vector vt;
            ResultSet rs = smt.executeQuery(sql);
            while(rs.next())
            {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3).equals("0") ? "Nam":"Nữ");
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                model.addRow(vt);
            }
            jTableDSSV.setModel(model);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }
    
    public void timKiemSv(String s)
    {   
        model = (DefaultTableModel) jTableDSSV.getModel();
        String sql = "SELECT masv,hoten,phai,ngaysinh,diachi, CASE WHEN (masv IN (SELECT maTK FROM taikhoan)) THEN 1  ELSE 0\n" +
"END AS DATAOTK FROM sinhvien sv where sv.masv like N'%"+s+"%' or hoten like N'%"+s+"%' or diachi like N'%"+s+"%' or ngaysinh like N'%"+s+"%'";
        model.setRowCount(0);
        try(Connection con = DataBaseHelper.getConnection();
                Statement smt = con.createStatement();)
        {   
            Vector vt;
            ResultSet rs = smt.executeQuery(sql);
            while(rs.next())
            {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3).equals("0") ? "Nam":"Nữ");
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                model.addRow(vt);
            }
            jTableDSSV.setModel(model);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
        System.out.println("" + sql);
        
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
        jTableDSSV = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelMaSv = new javax.swing.JLabel();
        jLabelTtk = new javax.swing.JLabel();
        jTextTenTk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbPassNew = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbConfirmPass = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(956, 608));

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));

        jTableDSSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Họ và Tên", "Phái", "NGày Sinh", "Địa Chỉ", "Tài Khoản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDSSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDSSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDSSV);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tìm Kiếm:");
        jLabel7.setMaximumSize(new java.awt.Dimension(90, 22));
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 13));

        jTextTimKiem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextTimKiem.setPreferredSize(new java.awt.Dimension(79, 13));
        jTextTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTimKiemActionPerformed(evt);
            }
        });
        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(89, 32));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(89, 32));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tài Khoản Sinh Viên");
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

        jLabel12.setBackground(new java.awt.Color(255, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("       Mã Sinh Viên: ");
        jPanel1.add(jLabel12);

        jLabelMaSv.setBackground(new java.awt.Color(255, 204, 204));
        jLabelMaSv.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jLabelMaSv);

        jLabelTtk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTtk.setText("       Tài Khoản:");
        jPanel1.add(jLabelTtk);

        jTextTenTk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel1.add(jTextTenTk);
        jPanel1.add(jLabel9);

        lbPassNew.setForeground(new java.awt.Color(255, 0, 0));
        lbPassNew.setText(" ");
        jPanel1.add(lbPassNew);
        jPanel1.add(jLabel10);

        lbConfirmPass.setForeground(new java.awt.Color(255, 0, 0));
        lbConfirmPass.setText(" ");
        jPanel1.add(lbConfirmPass);

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOK.setText("Tạo");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);

        jButtonXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonXoa);

        jButtonLamMoi.setText("Làm Mới");
        jButtonLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLamMoi)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDSSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDSSVMouseClicked
        
        jButtonXoa.setEnabled(true);
        int row = jTableDSSV.getSelectedRow();
        if(row>=0)
        {
          jLabelMaSv.setText(jTableDSSV.getValueAt(row, 0).toString().toUpperCase());
        }

    }//GEN-LAST:event_jTableDSSVMouseClicked

    private void jTextTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTimKiemActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        timKiemSv(jTextTimKiem.getText());
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        int kt = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?");
        if (kt == JOptionPane.CANCEL_OPTION) {
            return;
        } else if (kt == JOptionPane.OK_OPTION) {
            String sql = "delete from taikhoan where maTK=?";
            try (Connection con = DataBaseHelper.getConnection();
                PreparedStatement smt = con.prepareStatement(sql);) {
                smt.setString(1, jLabelMaSv.getText());

                int kt2 = smt.executeUpdate();
                if (kt2 > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }
                initData();
               

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        
            String sql = "insert into taikhoan values(?,?,CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2),?)";
            try (Connection con = DataBaseHelper.getConnection();
                PreparedStatement smt = con.prepareStatement(sql)) {
                
                smt.setString(1, jLabelMaSv.getText());
                smt.setString(2, jTextTenTk.getText());
                smt.setString(3, "123456");
                smt.setString(4, "VT3");
               
                int kt2 = smt.executeUpdate();
                if (kt2 > 0) {
                    JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công");
                }
                initData();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        
        
        
    }//GEN-LAST:event_btnOKActionPerformed

    public void lamMoi() {       
        initData();
        jLabelMaSv.setText("");
        jTextTenTk.setText("");
        lbPassNew.setText("");
        jTextTimKiem.setText("");
        jButtonXoa.setEnabled(false);
    }
    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_jButtonLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMaSv;
    private javax.swing.JLabel jLabelTtk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDSSV;
    private javax.swing.JTextField jTextTenTk;
    private javax.swing.JTextField jTextTimKiem;
    private javax.swing.JLabel lbConfirmPass;
    private javax.swing.JLabel lbPassNew;
    // End of variables declaration//GEN-END:variables
}
