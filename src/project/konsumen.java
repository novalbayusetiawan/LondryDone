/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.InputStream;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author VINDANV
 */
public class konsumen extends javax.swing.JFrame {
    Statement stt;
    ResultSet rss;
    DefaultTableModel model;
    Connection con = koneksi.getConnection();
    public static String id_transaksi;
    /**
     * Creates new form konsumen
     */
    private void tabel_konsumen(){
        model = new DefaultTableModel();
        tabelkonsumen.setModel(model);
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Telepon");
        model.addColumn("Total Bayar");
    }
    private void tampil_tabel_konsumen(){
        double tmp_harga = 0, total_harga = 0;
        try{
            stt = con.createStatement();
            String sql = "SELECT * FROM konsumen left join transaksi on "
                    + "(transaksi.id_konsumen=konsumen.id_konsumen) "
                    + "where transaksi.id_konsumen=konsumen.id_konsumen "
                    + "group by transaksi.id_transaksi";
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[5];
                o[0] = rss.getString("id_konsumen");
                o[1] = rss.getString("nama");
                o[2] = rss.getString("jalan");
                o[3] = rss.getString("telepon");
                o[4] = rss.getString("harga_transaksi");
                tmp_harga = Double.parseDouble(String.valueOf(o[4]));
                total_harga = total_harga+tmp_harga;
                model.addRow(o);
                
            }
            pendapatan.setText(""+total_harga);
            
        }catch(SQLException e){
            System.out.println("Error bor");
            System.out.println(e.getMessage());
        }
    }
    public konsumen() {
        initComponents();
        tabel_konsumen();
        tampil_tabel_konsumen();
        Object[] op = login_operator.getKasir();
        //HitungTotalPendapatan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Navigation3 = new javax.swing.JPanel();
        menu_transaksi2 = new javax.swing.JLabel();
        menu_home = new javax.swing.JLabel();
        menu_isi_data = new javax.swing.JLabel();
        menu_konsumen = new javax.swing.JLabel();
        menu_tentang = new javax.swing.JLabel();
        menu_keluar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pendapatan = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        update_konsumen = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkonsumen = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_Navigation3.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Navigation3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Navigation3.setPreferredSize(new java.awt.Dimension(722, 99));

        menu_transaksi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-transaksi.png"))); // NOI18N
        menu_transaksi2.setText("Transaksi");
        menu_transaksi2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_transaksi2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_transaksi2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_transaksi2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_transaksi2MouseClicked(evt);
            }
        });

        menu_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-home.png"))); // NOI18N
        menu_home.setText("Home");
        menu_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_homeMouseClicked(evt);
            }
        });

        menu_isi_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-form.png"))); // NOI18N
        menu_isi_data.setText("Form");
        menu_isi_data.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_isi_data.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_isi_data.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_isi_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_isi_dataMouseClicked(evt);
            }
        });

        menu_konsumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-konsumen.png"))); // NOI18N
        menu_konsumen.setText("Konsumen");
        menu_konsumen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_konsumen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_konsumen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_konsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_konsumenMouseClicked(evt);
            }
        });

        menu_tentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-about.png"))); // NOI18N
        menu_tentang.setText("Tentang");
        menu_tentang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_tentang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_tentang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_tentang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_tentangMouseClicked(evt);
            }
        });

        menu_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-logout.png"))); // NOI18N
        menu_keluar.setText("Keluar");
        menu_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_keluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_keluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_keluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_Navigation3Layout = new javax.swing.GroupLayout(Panel_Navigation3);
        Panel_Navigation3.setLayout(Panel_Navigation3Layout);
        Panel_Navigation3Layout.setHorizontalGroup(
            Panel_Navigation3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Navigation3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(menu_home)
                .addGap(10, 10, 10)
                .addComponent(menu_isi_data)
                .addGap(10, 10, 10)
                .addComponent(menu_transaksi2)
                .addGap(10, 10, 10)
                .addComponent(menu_konsumen)
                .addGap(10, 10, 10)
                .addComponent(menu_tentang)
                .addGap(10, 10, 10)
                .addComponent(menu_keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_Navigation3Layout.setVerticalGroup(
            Panel_Navigation3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Navigation3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(Panel_Navigation3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu_home)
                    .addComponent(menu_isi_data)
                    .addComponent(menu_transaksi2)
                    .addComponent(menu_konsumen)
                    .addComponent(menu_tentang)
                    .addComponent(menu_keluar))
                .addContainerGap())
        );

        jLabel1.setText("Total Pendapatan :");

        pendapatan.setText("0");
        pendapatan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/add.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        update_konsumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/edit.png"))); // NOI18N
        update_konsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_konsumenActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/del.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Data Konsumen", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(153, 255, 255));

        tabelkonsumen.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelkonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkonsumenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelkonsumen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/printer-icon-vector.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Navigation3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(update_konsumen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Navigation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_konsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(2, 2, 2))
                    .addComponent(pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)))
                .addGap(67, 67, 67))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    if(id_transaksi != null){
            try{
            stt = con.createStatement();
            int row = tabelkonsumen.getSelectedRow();
            String idx = tabelkonsumen.getValueAt(row, 0).toString();
            String sql = "DELETE FROM konsumen where id_konsumen='"+idx+"'";
            stt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error wal");
        }
        tabel_konsumen();
        tampil_tabel_konsumen();
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data dulu");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tabelkonsumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkonsumenMouseClicked
        int baris = tabelkonsumen.getSelectedRow();
        id_transaksi = ""+tabelkonsumen.getModel().getValueAt(baris, 0);
    }//GEN-LAST:event_tabelkonsumenMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new isi_data().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void update_konsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_konsumenActionPerformed
        if(id_transaksi != null){
            lihat_id_transaksi_dari_id_konsumen(id_transaksi);
            new lihat_edit().setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data dulu");
        }
    }//GEN-LAST:event_update_konsumenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection con = koneksi.getConnection();
        String NamaFile = "/laporan/Rekap_Konsumen.jasper";
        HashMap hash = new HashMap();
        try {
            runReportDefault(NamaFile,hash);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menu_transaksi2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_transaksi2MouseClicked
        new transaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_transaksi2MouseClicked

    private void menu_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_homeMouseClicked
        new awalan().setVisible(true);dispose();
    }//GEN-LAST:event_menu_homeMouseClicked

    private void menu_isi_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_isi_dataMouseClicked
        new isi_data().setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_isi_dataMouseClicked

    private void menu_konsumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_konsumenMouseClicked
        new konsumen().setVisible(true);dispose();
    }//GEN-LAST:event_menu_konsumenMouseClicked

    private void menu_tentangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_tentangMouseClicked
        new profil().setVisible(true);
    }//GEN-LAST:event_menu_tentangMouseClicked

    private void menu_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_keluarMouseClicked
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(this, "Yakin ingin Keluar Aplikasi?","Keluar",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION){
            new login_operator().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_menu_keluarMouseClicked
public void runReportDefault(String sourcefilename, HashMap hash) {
        Connection con = koneksi.getConnection();
        try {
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
            JasperPrint jprint = JasperFillManager.fillReport(report,hash, con);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
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
            java.util.logging.Logger.getLogger(konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new konsumen().setVisible(true);
            }
        });
    }
    private void HitungTotalPendapatan(){
        double Total = 0, HargaTK = 0;
        int TotalBaris = tabelkonsumen.getRowCount();
        try{
            for(int i = 0; i<TotalBaris;i++){
            HargaTK = Double.parseDouble(String.valueOf(tabelkonsumen.getModel().getValueAt(i, 4)));
            Total = Total+HargaTK;
            }
            pendapatan.setText(String.valueOf(Total));
        }catch(Exception e){
            System.out.println("masalah");
            System.out.println(e.getMessage());
        }
        
    }
    private void lihat_id_transaksi_dari_id_konsumen(String id){
        try{
            stt = con.createStatement();
            rss = stt.executeQuery("SELECT id_transaksi FROM "
                    + "transaksi WHERE id_konsumen='"+id+"'");
            rss.next();
            id_transaksi = rss.getString("id_transaksi");
            rss.close();
            transaksi.setIdTransaksi(id_transaksi);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Navigation3;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel menu_home;
    private javax.swing.JLabel menu_isi_data;
    private javax.swing.JLabel menu_keluar;
    private javax.swing.JLabel menu_konsumen;
    private javax.swing.JLabel menu_tentang;
    private javax.swing.JLabel menu_transaksi2;
    private javax.swing.JLabel pendapatan;
    private javax.swing.JTable tabelkonsumen;
    private javax.swing.JButton update_konsumen;
    // End of variables declaration//GEN-END:variables
}
