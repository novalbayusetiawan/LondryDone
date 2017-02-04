/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author VINDANV
 */
public class transaksi extends javax.swing.JFrame {
    Statement stt;
    ResultSet rss;
    Connection con = koneksi.getConnection();
    DefaultTableModel model2;
    private String stat;
    //JComboBox comboBox = new JComboBox();
    public static String id_transaksi;
    /**
     * Creates new form status
     */
    public transaksi() {
        
        initComponents();
        tabel_transaksi();
        tampil_tabel_transaksi();
        
    }
    private void tabel_transaksi(){
        model2 = new DefaultTableModel();
        tabelTransaksi.setModel(model2);
        model2.addColumn("Id Nota");
        model2.addColumn("Nama");
        model2.addColumn("Harga");
        model2.addColumn("Tanggal Masuk");
        model2.addColumn("Tanggal Keluar");
        model2.addColumn("Status");
//        tabelTransaksi.getColumnModel().getColumn(5).setMinWidth(100);
//        tabelTransaksi.getColumnModel().getColumn(0).setPreferredWidth(30);
    }
    
    private void tampil_tabel_transaksi(){
        try{
             stt = con.createStatement();
        
        switch (filter.getSelectedIndex()) {
            case 0:
                String sql = "SELECT "
                        + "transaksi.id_transaksi, konsumen.nama,transaksi.harga_transaksi, "
                        + "transaksi.tanggal_masuk, transaksi.tanggal_keluar, "
                        + "transaksi.status "
                        + "FROM transaksi "
                        + "LEFT JOIN konsumen ON "
                        + "(konsumen.id_konsumen = transaksi.id_konsumen) "
                        + "LEFT JOIN operator ON "
                        + "(transaksi.id_operator = operator.id_operator) ";
                rss = stt.executeQuery(sql);
                break;
                case 1:
                sql = "SELECT "
                       + "transaksi.id_transaksi, konsumen.nama,transaksi.harga_transaksi, "
                        + "transaksi.tanggal_masuk, transaksi.tanggal_keluar, "
                        + "transaksi.status "
                        + "FROM transaksi "
                        + "LEFT JOIN konsumen ON "
                        + "(konsumen.id_konsumen = transaksi.id_konsumen) "
                        + "LEFT JOIN operator ON "
                        + "(transaksi.id_operator = operator.id_operator) "
                        + "where transaksi.status='Belum diproses'";
                rss = stt.executeQuery(sql);
                break;
            case 2:
                sql = "SELECT "
                       + "transaksi.id_transaksi, konsumen.nama,transaksi.harga_transaksi, "
                        + "transaksi.tanggal_masuk, transaksi.tanggal_keluar, "
                        + "transaksi.status "
                        + "FROM transaksi "
                        + "LEFT JOIN konsumen ON "
                        + "(konsumen.id_konsumen = transaksi.id_konsumen) "
                        + "LEFT JOIN operator ON "
                        + "(transaksi.id_operator = operator.id_operator) "
                        + "where transaksi.status='Sedang diproses'";
                rss = stt.executeQuery(sql);
                break;
            case 3:
                sql = "SELECT "
                       + "transaksi.id_transaksi, konsumen.nama,transaksi.harga_transaksi, "
                        + "transaksi.tanggal_masuk, transaksi.tanggal_keluar, "
                        + "transaksi.status "
                        + "FROM transaksi "
                        + "LEFT JOIN konsumen ON "
                        + "(konsumen.id_konsumen = transaksi.id_konsumen) "
                        + "LEFT JOIN operator ON "
                        + "(transaksi.id_operator = operator.id_operator) "
                        + "where transaksi.status='Sudah selesai'";
                rss = stt.executeQuery(sql);
                break;
            case 4:
                sql = "SELECT "
                       + "transaksi.id_transaksi, konsumen.nama,transaksi.harga_transaksi, "
                        + "transaksi.tanggal_masuk, transaksi.tanggal_keluar, "
                        + "transaksi.status "
                        + "FROM transaksi "
                        + "LEFT JOIN konsumen ON "
                        + "(konsumen.id_konsumen = transaksi.id_konsumen) "
                        + "LEFT JOIN operator ON "
                        + "(transaksi.id_operator = operator.id_operator) "
                        + "where transaksi.status='Sudah diambil'";
                rss = stt.executeQuery(sql);
                break;
            default:
                break;
        }       tabelTransaksi.setAutoCreateRowSorter(true);
        try{
            while(rss.next()){
                Object[] o = new Object[9];
                o[0] = rss.getString(1);
                o[1] = rss.getString(2);
                o[2] = rss.getString(3);
                o[3] = rss.getString(4);
                o[4] = rss.getString(5);
                o[5] = rss.getString(6);
                model2.addRow(o);
                
            }
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void DeleteData(){
        try{
            stt = con.createStatement();
            int row = tabelTransaksi.getSelectedRow();
            String idx = tabelTransaksi.getValueAt(row, 0).toString();
            String sql = "DELETE FROM transaksi where id_transaksi='"+idx+"'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Berhasil Hapus");
        }catch(SQLException e){
            System.out.println("Error wal");
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

        jMenuItem7 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        update_konsumen = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        filter = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        Panel_Navigation1 = new javax.swing.JPanel();
        menu_transaksi = new javax.swing.JLabel();
        menu_home = new javax.swing.JLabel();
        menu_isi_data = new javax.swing.JLabel();
        menu_konsumen = new javax.swing.JLabel();
        menu_tentang = new javax.swing.JLabel();
        menu_keluar = new javax.swing.JLabel();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 497));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/add.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "SELURUH TRANSAKSI KONSUMEN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelTransaksi);

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Belum diproses", "Sedang diproses", "Sudah selesai", "Sudah diambil" }));
        filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterItemStateChanged(evt);
            }
        });
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(679, 679, 679)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Panel_Navigation1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Navigation1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Navigation1.setPreferredSize(new java.awt.Dimension(722, 99));

        menu_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/images/icon-transaksi.png"))); // NOI18N
        menu_transaksi.setText("Transaksi");
        menu_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_transaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_transaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_transaksiMouseClicked(evt);
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

        javax.swing.GroupLayout Panel_Navigation1Layout = new javax.swing.GroupLayout(Panel_Navigation1);
        Panel_Navigation1.setLayout(Panel_Navigation1Layout);
        Panel_Navigation1Layout.setHorizontalGroup(
            Panel_Navigation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Navigation1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(menu_home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_isi_data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_konsumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_tentang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_Navigation1Layout.setVerticalGroup(
            Panel_Navigation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Navigation1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(Panel_Navigation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu_home)
                    .addComponent(menu_isi_data)
                    .addComponent(menu_transaksi)
                    .addComponent(menu_konsumen)
                    .addComponent(menu_tentang)
                    .addComponent(menu_keluar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update_konsumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(692, 692, 692))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel_Navigation1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2))
                            .addComponent(Panel_Navigation1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_konsumen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_konsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_konsumenActionPerformed
        if(id_transaksi != null){
            new lihat_edit().setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data dulu");
        }
    }//GEN-LAST:event_update_konsumenActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(id_transaksi != null){
            DeleteData();
            tabel_transaksi();
            tampil_tabel_transaksi();
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data dulu");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new isi_data().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterActionPerformed

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged
        tabel_transaksi();
        tampil_tabel_transaksi();
    }//GEN-LAST:event_filterItemStateChanged

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        int baris = tabelTransaksi.getSelectedRow();
        id_transaksi = ""+tabelTransaksi.getModel().getValueAt(baris, 0);
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        id_transaksi = null;
    }//GEN-LAST:event_formWindowActivated

    private void menu_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_transaksiMouseClicked
        new transaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_transaksiMouseClicked

    private void menu_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_homeMouseClicked
        new awalan().setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }
    public static String getIdTransaksi(){
        return id_transaksi;
    }
    public static void setIdTransaksi(String id){
        transaksi.id_transaksi = id;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Navigation1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel menu_home;
    private javax.swing.JLabel menu_isi_data;
    private javax.swing.JLabel menu_keluar;
    private javax.swing.JLabel menu_konsumen;
    private javax.swing.JLabel menu_tentang;
    private javax.swing.JLabel menu_transaksi;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JButton update_konsumen;
    // End of variables declaration//GEN-END:variables
}
