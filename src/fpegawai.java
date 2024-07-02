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
import javax.swing.ButtonGroup;

public class fpegawai extends javax.swing.JFrame {

    private DefaultTableModel model;
    private ButtonGroup genderGroup;

    /**
     * Creates new form fpegawai
     */
    public fpegawai() {
        initComponents();
        model = new DefaultTableModel();
        table.setModel(model);

        model.addColumn("username");
        model.addColumn("password");
        model.addColumn("jenis_kelamin");
        model.addColumn("email");
        model.addColumn("no_telp");
        model.addColumn("agama");
        model.addColumn("alamat");

        genderGroup = new ButtonGroup(); // Inisialisasi ButtonGroup
        genderGroup.add(Radiolaki);      // Tambahkan Radiolaki ke ButtonGroup
        genderGroup.add(Radioperempuan); // Tambahkan Radioperempuan ke ButtonGroup

        loadData();

    }

    public final void loadData() {
        btn_tambah.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_login";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("username");
                o[1] = r.getString("password");
                o[2] = r.getString("jenis_kelamin");
                o[3] = r.getString("email");
                o[4] = r.getString("no_telp");
                o[5] = r.getString("agama");
                o[6] = r.getString("alamat");
                model.addRow(o);
            }

            r.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fusename = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Radiolaki = new javax.swing.JRadioButton();
        Radioperempuan = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fnotelphon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cagama = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        falamat = new javax.swing.JTextArea();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        fpassword = new javax.swing.JPasswordField();
        fchangepassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        femail = new javax.swing.JTextField();

        jCheckBox2.setText("jCheckBox2");

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 66, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Pengelola data pegawai");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("username :");

        jLabel3.setText("password :");

        jLabel4.setText("Retype    :");

        fusename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fusenameActionPerformed(evt);
            }
        });

        jLabel5.setText("Jenis kelamin");

        Radiolaki.setText("laki-laki");

        Radioperempuan.setText("perempuan");

        jLabel8.setText("No.Telp");

        jLabel10.setText("Agama");

        cagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "kristen", "katolik", "hindu", "buddha", "khonghucu" }));

        jLabel12.setText("Alamat");

        falamat.setColumns(20);
        falamat.setRows(5);
        jScrollPane1.setViewportView(falamat);

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setText("ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table);

        jLabel7.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btn_hapus)
                .addGap(90, 90, 90)
                .addComponent(btn_ubah)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_tambah)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Radiolaki)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Radioperempuan))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fpassword)
                                        .addComponent(fchangepassword, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fusename, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(14, 14, 14)
                                .addComponent(cagama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fnotelphon)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                    .addComponent(femail)))))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fusename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(fnotelphon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(cagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fchangepassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(femail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Radiolaki)
                        .addComponent(Radioperempuan)
                        .addComponent(jLabel5)
                        .addComponent(jLabel12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_ubah)
                    .addComponent(btn_tambah))
                .addGap(56, 56, 56)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if (fusename.getText().equals("")
                || new String(fpassword.getPassword()).equals("")
                || new String(fchangepassword.getPassword()).equals("")
                || (!Radiolaki.isSelected() && !Radioperempuan.isSelected())
                || femail.getText().equals("")
                || fnotelphon.getText().equals("")
                || cagama.getSelectedItem().equals("")
                || falamat.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "LENGKAPI DATA!", "Pegawai", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                String kusername = fusename.getText();
                String useremail = femail.getText();
                String tpassword = new String(fpassword.getPassword());
                String confirmpassword = new String(fchangepassword.getPassword());
                if (!tpassword.equals(confirmpassword)) {
                    JOptionPane.showMessageDialog(null, "PASSWORD TIDAK COCOK!", "Pegawai", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String jenisKelamin;
                if (Radiolaki.isSelected()) {
                    jenisKelamin = "Laki-laki";
                } else {
                    jenisKelamin = "Perempuan";
                }
                int noTelp = Integer.parseInt(fnotelphon.getText());
                String agama = cagama.getSelectedItem().toString();
                String alamat = falamat.getText();

                Connection c = Koneksi.getKoneksi();
                String sql = "INSERT INTO tbl_login (username, password, jenis_kelamin, email, no_telp, agama, alamat) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kusername);
                p.setString(2, tpassword);
                p.setString(3, jenisKelamin);
                p.setString(4, useremail);
                p.setInt(5, noTelp);
                p.setString(6, agama);
                p.setString(7, alamat);
                p.executeUpdate();
                p.close();
                loadData();

                fusename.setText("");
                femail.setText("");
                fpassword.setText("");
                fchangepassword.setText("");
                genderGroup.clearSelection();
                fnotelphon.setText("");
                cagama.setSelectedIndex(0);
                falamat.setText("");

                JOptionPane.showMessageDialog(null, "Data pegawai berhasil di tambahkan", "Aplikasi Penjualan",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                System.out.println("terjadi error");
            }

        }

    }//GEN-LAST:event_btn_tambahActionPerformed

    private void fusenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fusenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fusenameActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        if (fusename.getText().equals("")
                || new String(fpassword.getPassword()).equals("")
                || new String(fchangepassword.getPassword()).equals("")
                || (!Radiolaki.isSelected() && !Radioperempuan.isSelected())
                || femail.getText().equals("")
                || fnotelphon.getText().equals("")
                || cagama.getSelectedItem().equals("")
                || falamat.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "LENGKAPI DATA!", "Pegawai", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int i = table.getSelectedRow();
            if (i == -1) {
                JOptionPane.showMessageDialog(null, "PILIH DATA YANG AKAN DIUBAH!", "Pegawai", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String kusername = fusename.getText();
            String useremail = femail.getText();
            String tpassword = new String(fpassword.getPassword());
            String confirmpassword = new String(fchangepassword.getPassword());
            if (!tpassword.equals(confirmpassword)) {
                JOptionPane.showMessageDialog(null, "PASSWORD TIDAK COCOK!", "Pegawai", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String jenisKelamin;
            if (Radiolaki.isSelected()) {
                jenisKelamin = "Laki-laki";
            } else {
                jenisKelamin = "Perempuan";
            }

            int noTelp;
            try {
                noTelp = Integer.parseInt(fnotelphon.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nomor Telepon harus berupa angka!", "Pegawai", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String agama = cagama.getSelectedItem().toString();
            String alamat = falamat.getText();

            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "UPDATE tbl_login SET password = ?, jenis_kelamin = ?, email = ?, no_telp = ?, agama = ?, alamat = ? WHERE username = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, tpassword);
                p.setString(2, jenisKelamin);
                p.setString(3, useremail);
                p.setInt(4, noTelp);
                p.setString(5, agama);
                p.setString(6, alamat);
                p.setString(7, kusername);

                // Print the prepared statement for debugging
                System.out.println("Executing query: " + p.toString());

                int rowsUpdated = p.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);

                p.close();
                loadData();

                fusename.setText("");
                femail.setText("");
                fpassword.setText("");
                fchangepassword.setText("");
                genderGroup.clearSelection();
                fnotelphon.setText("");
                cagama.setSelectedIndex(0);
                falamat.setText("");

                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pegawai", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal mengubah data! " + e.getMessage(), "Pegawai", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Pegawai", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_ubahActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here

        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        int i = table.getSelectedRow();
        if (i == -1) {
            return;
        }
        // Mengambil data dari baris yang dipilih
        String username = (String) table.getValueAt(i, 0);
        String password = (String) table.getValueAt(i, 1);
        String jenisKelamin = (String) table.getValueAt(i, 2);
        String email = (String) table.getValueAt(i, 3);
        String noTelp = (String) table.getValueAt(i, 4);
        String agama = (String) table.getValueAt(i, 5);
        String alamat = (String) table.getValueAt(i, 6);

        // Mengisi form dengan data dari tabel
        fusename.setText(username);
        fpassword.setText(password);
        fchangepassword.setText(password);
        if (jenisKelamin.equals("Laki-laki")) {
            Radiolaki.setSelected(true);
        } else {
            Radioperempuan.setSelected(true);
        }
        femail.setText(email);
        fnotelphon.setText(noTelp);
        cagama.setSelectedItem(agama);
        falamat.setText(alamat);
    }//GEN-LAST:event_tableMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from tbl_login where username='" + fusename.getText() + "'";
            java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        fusename.setText("");
        femail.setText("");
        fpassword.setText("");
        fchangepassword.setText("");
        genderGroup.clearSelection();
        fnotelphon.setText("");
        cagama.setSelectedIndex(0);
        falamat.setText("");

    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         fmenu fm = new fmenu();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fpegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fpegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Radiolaki;
    private javax.swing.JRadioButton Radioperempuan;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> cagama;
    private javax.swing.JTextArea falamat;
    private javax.swing.JPasswordField fchangepassword;
    private javax.swing.JTextField femail;
    private javax.swing.JTextField fnotelphon;
    private javax.swing.JPasswordField fpassword;
    private javax.swing.JTextField fusename;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
