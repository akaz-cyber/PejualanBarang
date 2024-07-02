    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fbarang extends javax.swing.JFrame {
private DefaultTableModel model;

    /**
     * Creates new form 
     */
    public fbarang() {
    
initComponents();   
model = new DefaultTableModel();
tableinput.setModel(model);
model.addColumn("kd_barang");
model.addColumn("nama_barang");
model.addColumn("jumlah_barang");
model.addColumn("harga_beli");
model.addColumn("harga_jual");
loadData();
kode();
    }
   public final void loadData() {
    btn_simpan.setEnabled(true);
    btn_hapus.setEnabled(false);
    btn_edit.setEnabled(false);
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();

    try {
        Connection c = Koneksi.getKoneksi();
        Statement s = c.createStatement();
        String sql = "SELECT * FROM tbl_barang";
        ResultSet r = s.executeQuery(sql);
        
        while (r.next()) {
            Object[] o = new Object[5];
            o[0] = r.getString("kd_barang");
            o[1] = r.getString("nama_barang");
            o[2] = r.getString("jumlah_barang");
            o[3] = r.getString("harga_beli");
            o[4] = r.getString("harga_jual");
            model.addRow(o);
        }
        
        r.close();
        s.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void kode() { 
    try {
        Connection c = Koneksi.getKoneksi();
        Statement s = c.createStatement();
        String sql = "SELECT * FROM tbl_barang ORDER BY kd_barang DESC";
        ResultSet r = s.executeQuery(sql);
        
        if (r.next()) {
            String nofak = r.getString("kd_barang").substring(1);
            String AN = "" + (Integer.parseInt(nofak) + 1);
            String Nol = "";
            
            if (AN.length() == 1) {
                Nol = "000";
            } else if (AN.length() == 2) {
                Nol = "00";
            } else if (AN.length() == 3) {
                Nol = "0";
            } else if (AN.length() == 4) {
                Nol = "";
            }
            
            txt_kdbarang.setText("B" + Nol + AN);
        } else {
            txt_kdbarang.setText("B0001");
        }
        
        r.close();
        s.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void exitActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    fmenu fb = new fmenu();
    fb.setVisible(true);
    this.setVisible(false);
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
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableinput = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_kdbarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_jumlahbarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_hargabeli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_hargajual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 66, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Pengelolahan data barang");

        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        tableinput.setModel(new javax.swing.table.DefaultTableModel(
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
        tableinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableinputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableinput);

        jLabel2.setText("Kode barang");

        txt_kdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdbarangActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama barang");

        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah barang ");

        txt_jumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbarangActionPerformed(evt);
            }
        });

        jLabel5.setText("harga beli");

        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });

        jLabel6.setText("Cari");

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });

        btn_simpan.setText("simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel7.setText("Harga jual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txt_jumlahbarang)
                            .addComponent(txt_hargabeli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_simpan)
                            .addComponent(btn_hapus)
                            .addComponent(btn_edit))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_jumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_hargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_kdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdbarangActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
  if (txt_kdbarang.getText().equals("") || txt_namabarang.getText().equals("") || txt_jumlahbarang.getText().equals("") || txt_hargabeli.getText().equals("") || txt_hargajual.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "elektronik berkah", JOptionPane.INFORMATION_MESSAGE);
    } else {
        try {
            int jbarang = Integer.parseInt(txt_jumlahbarang.getText());
            int hbeli = Integer.parseInt(txt_hargabeli.getText());
            int hjual = Integer.parseInt(txt_hargajual.getText());

            String kbarang = txt_kdbarang.getText();
            String nbarang = txt_namabarang.getText();
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String tgl = date.toString();

            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO tbl_barang (kd_barang, nama_barang, jumlah_barang, harga_beli, harga_jual, tanggal_masuk) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kbarang);
            p.setString(2, nbarang);
            p.setInt(3, jbarang);
            p.setInt(4, hbeli);
            p.setInt(5, hjual);
            p.setString(6, tgl);
            p.executeUpdate();
            p.close(); 

            loadData();
            kode();
            txt_namabarang.setText("");
            txt_jumlahbarang.setText("");
            txt_hargabeli.setText("");
            txt_hargajual.setText("");
            JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "elektronik berkah", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harap masukkan nilai numerik yang valid untuk jumlah barang, harga beli, dan harga jual", "elektronik berkah", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Terjadi Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try {
String sql ="delete from tbl_barang where kd_barang='"+txt_kdbarang.getText()+"'";
java.sql.Connection conn=(Connection)Koneksi.getKoneksi();
java.sql.PreparedStatement pst=conn.prepareStatement(sql);
pst.execute();
JOptionPane.showMessageDialog(this, "berhasil di hapus");
} catch (Exception e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
loadData();
txt_kdbarang.setText("");
txt_namabarang.setText("");
txt_jumlahbarang.setText("");
txt_hargabeli.setText("");
txt_hargajual.setText("");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if (txt_kdbarang.getText().equals("") ||
    txt_namabarang.getText().equals("") ||
    txt_jumlahbarang.getText().equals("") ||
    txt_hargabeli.getText().equals("") ||
    txt_hargajual.getText().equals("")) {
    
    JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Elektronik Berkah", JOptionPane.INFORMATION_MESSAGE);
} else {
    int i = tableinput.getSelectedRow();
    if (i == -1) {
        return;
    }
    
    String user = (String) model.getValueAt(i, 0);
    
    try {
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE tbl_barang SET nama_barang = ?, jumlah_barang = ?, harga_beli = ?, harga_jual = ? WHERE kd_barang = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, txt_namabarang.getText());
        p.setString(2, txt_jumlahbarang.getText());
        p.setString(3, txt_hargabeli.getText());
        p.setString(4, txt_hargajual.getText());
        p.setString(5, txt_kdbarang.getText());
        p.executeUpdate();
        p.close();
    } catch (SQLException e) {
        System.out.println("Terjadi Error: " + e.getMessage());
    } finally {
        loadData();
        txt_kdbarang.setText("");
        txt_namabarang.setText("");
        txt_jumlahbarang.setText("");
        txt_hargabeli.setText("");
        txt_hargajual.setText("");
        btn_simpan.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Elektronik Berkah", JOptionPane.INFORMATION_MESSAGE);
    }
}


    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_jumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahbarangActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
model.fireTableDataChanged();
try {
Connection c = Koneksi.getKoneksi();
Statement s = c.createStatement();
String sql = "select * from tbl_barang where kd_barang like '%" + txt_cari.getText() + "%' or nama_barang like'%" + txt_cari.getText() + "%'or jumlah_barang like'" + txt_cari.getText() + "%' or harga_beli like'%" + txt_cari.getText() + "%' " + "or harga_jual like'%" + txt_cari.getText() +"%'";
ResultSet r = s.executeQuery(sql);
while (r.next()) {
Object[] o = new Object[5];
o[0] = r.getString("kd_barang");
o[1] = r.getString("nama_barang");
o[2] = r.getString("jumlah_barang");
o[3] = r.getString("harga_beli");
o[4] = r.getString("harga_jual");
model.addRow(o);
}
r.close();
s.close();
} catch (SQLException e) {
System.out.println("Terjadi Error");
} 

    }//GEN-LAST:event_txt_cariActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         fmenu fm = new fmenu();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableinputMouseClicked
        // TODO add your handling code here:
        btn_simpan.setEnabled(false);
btn_edit.setEnabled(true);
btn_hapus.setEnabled(true);
int i = tableinput.getSelectedRow();
if (i == -1) {
return;
}
String kbarang = (String) model.getValueAt(i, 0);
txt_kdbarang.setText(kbarang);
txt_kdbarang.setEnabled(false);
String nbarang = (String) model.getValueAt(i, 1);
txt_namabarang.setText(nbarang);
String jumlah = (String) model.getValueAt(i, 2);
txt_jumlahbarang.setText(jumlah);
String hbeli = (String) model.getValueAt(i, 3);
txt_hargabeli.setText(hbeli);
String hjual = (String) model.getValueAt(i, 4);
txt_hargajual.setText(hjual);
    }//GEN-LAST:event_tableinputMouseClicked

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
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableinput;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_jumlahbarang;
    private javax.swing.JTextField txt_kdbarang;
    private javax.swing.JTextField txt_namabarang;
    // End of variables declaration//GEN-END:variables
}
