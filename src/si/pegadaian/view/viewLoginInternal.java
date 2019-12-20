/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import main.appUtama;
import main.appUtamaAdmin;
import main.appUtamaKasir;
import si.pegadaian.controller.controllerLogin;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */
public class viewLoginInternal extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewLoginInternal
     */
    private controllerLogin cL;
    private viewMaster vM;

    public viewLoginInternal(viewMaster vM) {
        this.vM= vM;
    }
    public viewLoginInternal() {
        initComponents();
        cL=new controllerLogin(this);
        
    }

    public JPasswordField getPasswordPF() {
        return passwordPF;
    }

    public JTextField getUsernameTF() {
        return usernameTF;
    }

    public JComboBox<String> getHakAkses() {
        return hakAkses;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        hakAkses = new javax.swing.JComboBox<>();
        loginBT = new javax.swing.JButton();
        batalBT = new javax.swing.JButton();
        passwordPF = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(null);
        setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Hak Akses");

        hakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Admin", "Kasir" }));

        loginBT.setText("Login");
        loginBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTActionPerformed(evt);
            }
        });

        batalBT.setText("Batal");
        batalBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(loginBT)
                                        .addGap(50, 50, 50)
                                        .addComponent(batalBT))
                                    .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordPF))))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBT)
                    .addComponent(batalBT))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTActionPerformed
        // TODO add your handling code here:
        String password = String.valueOf(passwordPF.getPassword());
        boolean login = false;
        String level = "";
        
        try {
            PreparedStatement stmt = koneksiDatabase.getKoneksi()
                    .prepareStatement("SELECT password, Hakakses FROM petugas WHERE username = ?");
            stmt.setString(1, usernameTF.getText());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {                    
                    level = rs.getString("Hakakses");
                    String h = hakAkses.getSelectedItem().toString();
                    if(level.equals(h)){
                        login = true;
                    }else{
                        login = false;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewLoginInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!login) {
            JOptionPane.showMessageDialog(this, "User tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            switch(level) {
                
                case "Admin":
                    dispose();
                    appUtamaAdmin aUA=new appUtamaAdmin();
                    aUA.setVisible(true);
                    break;
                case "Kasir":
                    dispose();
                    appUtamaKasir aUK=new appUtamaKasir();
                    aUK.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Level akses tidak diketahui.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_loginBTActionPerformed

    private void batalBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTActionPerformed
        // TODO add your handling code here:
        cL.bersihkan();
    }//GEN-LAST:event_batalBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalBT;
    private javax.swing.JComboBox<String> hakAkses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginBT;
    private javax.swing.JPasswordField passwordPF;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
