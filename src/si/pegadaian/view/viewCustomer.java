/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.view;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import si.pegadaian.controller.controllerCustomer;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */

public class viewCustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form viesCustomer
     */
    public controllerCustomer cC;
    public DefaultTableModel model;
    public String sql="";
    public viewCustomer() {
        initComponents();
        cC= new controllerCustomer(this);
        
        model=new DefaultTableModel();
        tabelCustomer.setModel(model);
        model.addColumn("No KTP");
        model.addColumn("Nama");
        model.addColumn("No Hp");
        model.addColumn("Alamat");
        
        tampilDataCustomer("");
        
    }

    public JTextArea getAlamatTA() {
        return alamatTA;
    }

    public JTextField getCariTF() {
        return cariTF;
    }

    public JTextField getNamaTF() {
        return namaTF;
    }

    public JTextField getNoKtpTF() {
        return noKtpTF;
    }

    public JTextField getNoTelpTF() {
        return noTelpTF;
    }
    
    public void tampilDataCustomer(String data){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if(data.equals("")){
            sql= "SELECT * FROM nasabah";
        }else{
            sql="SELECT * FROM nasabah WHERE Nama LIKE '"+data+"%'";
        }
        
        try{
            Statement stat=(Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res= stat.executeQuery(sql);
            
            
            while(res.next()){
                Object[] hasil;
                hasil =new Object[4];//karena ada 6 field ditabel pelanggan
                hasil[0]=res.getInt("Ktp");
                hasil[1]=res.getString("Nama_nasabah");
                hasil[2]=res.getString("Alamat");
                hasil[3]=res.getString("Hp");
                
                model.addRow(hasil);
                
            }
        } catch(SQLException ex){
            Logger.getLogger(viewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void ambilDataTabel(){
        int index=tabelCustomer.getSelectedRow();
        String ktp=String.valueOf(tabelCustomer.getValueAt(index, 0));
        String nama=String.valueOf(tabelCustomer.getValueAt(index, 1));
        String alamat=String.valueOf(tabelCustomer.getValueAt(index, 2));
        String hp=String.valueOf(tabelCustomer.getValueAt(index, 3));
        
        noKtpTF.setText(ktp);
        namaTF.setText(nama);
        alamatTA.setText(alamat);
        noTelpTF.setText(hp);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noKtpTF = new javax.swing.JTextField();
        namaTF = new javax.swing.JTextField();
        noTelpTF = new javax.swing.JTextField();
        updateBT = new javax.swing.JButton();
        saveBT = new javax.swing.JButton();
        noKtp = new javax.swing.JLabel();
        deleteBT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        resetBT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        printTF = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cariTF = new javax.swing.JTextField();
        noKtp1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelCustomer = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamatTA = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setToolTipText("");

        updateBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-property-32.png"))); // NOI18N
        updateBT.setText("Update");
        updateBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTActionPerformed(evt);
            }
        });

        saveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save-32.png"))); // NOI18N
        saveBT.setText("Save");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });

        noKtp.setText("No KTP");

        deleteBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-property-32.png"))); // NOI18N
        deleteBT.setText("Delete");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama");

        resetBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sinchronize-32.png"))); // NOI18N
        resetBT.setText("Reset");
        resetBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTActionPerformed(evt);
            }
        });

        jLabel4.setText("No Telp");

        printTF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print-icon.png"))); // NOI18N
        printTF.setText("Print");
        printTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTFActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Form Data Customer");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        cariTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariTFKeyPressed(evt);
            }
        });

        noKtp1.setText("Cari data berdasarkan nama");

        tabelCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelCustomer);

        alamatTA.setColumns(20);
        alamatTA.setRows(5);
        jScrollPane2.setViewportView(alamatTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(noTelpTF, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(noKtp))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(noKtpTF, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(namaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(saveBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetBT)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(noKtp1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(printTF)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noKtp1)
                            .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noKtp)
                            .addComponent(noKtpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(noTelpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBT)
                            .addComponent(saveBT)
                            .addComponent(deleteBT)
                            .addComponent(resetBT))
                        .addGap(16, 16, 16)
                        .addComponent(printTF)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
        // TODO add your handling code here:
        cC.simpanCustomer();
        tampilDataCustomer("");
        cC.bersihkan();
    }//GEN-LAST:event_saveBTActionPerformed

    private void tabelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCustomerMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelCustomerMouseClicked

    private void updateBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTActionPerformed
        // TODO add your handling code here:
        cC.updateCustomer();
        tampilDataCustomer("");
        cC.bersihkan();
    }//GEN-LAST:event_updateBTActionPerformed

    private void resetBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTActionPerformed
        // TODO add your handling code here:
        cC.bersihkan();
    }//GEN-LAST:event_resetBTActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        // TODO add your handling code here:
        cC.deleteCustomer();
        cC.bersihkan();
        tampilDataCustomer("");
    }//GEN-LAST:event_deleteBTActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void printTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTFActionPerformed
        // TODO add your handling code here:
        try{
            koneksiDatabase print=new koneksiDatabase();
            Connection con=print.getKoneksi();
            InputStream input=getClass().getResourceAsStream("/report2.jrxml");
            JasperDesign design=JRXmlLoader.load(input);
            JasperReport report=JasperCompileManager.compileReport(design);
            JasperPrint jp=JasperFillManager.fillReport(report,null, con);
            JasperViewer.viewReport(jp,false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_printTFActionPerformed

    private void cariTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyPressed
        // TODO add your handling code here:
        tampilDataCustomer(cariTF.getText());
    }//GEN-LAST:event_cariTFKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatTA;
    private javax.swing.JTextField cariTF;
    private javax.swing.JButton deleteBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaTF;
    private javax.swing.JLabel noKtp;
    private javax.swing.JLabel noKtp1;
    private javax.swing.JTextField noKtpTF;
    private javax.swing.JTextField noTelpTF;
    private javax.swing.JButton printTF;
    private javax.swing.JButton resetBT;
    private javax.swing.JButton saveBT;
    private javax.swing.JTable tabelCustomer;
    private javax.swing.JButton updateBT;
    // End of variables declaration//GEN-END:variables
}
