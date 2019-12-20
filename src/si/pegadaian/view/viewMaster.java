/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.view;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author user-pc
 */
public class viewMaster extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewMaster
     */
    
    viewCustomer vM= new viewCustomer();
    viewBarang vB= new viewBarang();
    viewPetugas vP= new viewPetugas();
    
    public viewMaster() {
        initComponents();
    }

    public JButton getPetugasBT() {
        return petugasBT;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerBT = new javax.swing.JButton();
        barangBT = new javax.swing.JButton();
        petugasBT = new javax.swing.JButton();
        masterPanel = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        customerBT.setText("Customer");
        customerBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerBTMouseClicked(evt);
            }
        });
        customerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBTActionPerformed(evt);
            }
        });

        barangBT.setText("Barang");
        barangBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangBTMouseClicked(evt);
            }
        });
        barangBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangBTActionPerformed(evt);
            }
        });

        petugasBT.setText("Petugas");
        petugasBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petugasBTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout masterPanelLayout = new javax.swing.GroupLayout(masterPanel);
        masterPanel.setLayout(masterPanelLayout);
        masterPanelLayout.setHorizontalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        masterPanelLayout.setVerticalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(customerBT)
                .addGap(18, 18, 18)
                .addComponent(barangBT)
                .addGap(18, 18, 18)
                .addComponent(petugasBT)
                .addContainerGap(441, Short.MAX_VALUE))
            .addComponent(masterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerBT)
                    .addComponent(barangBT)
                    .addComponent(petugasBT))
                .addGap(18, 18, 18)
                .addComponent(masterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerBTMouseClicked
        // TODO add your handling code here:
        this.masterPanel.remove(vB);
        this.masterPanel.remove(vP);
        this.masterPanel.add(vM);
        vM.show();
        
    }//GEN-LAST:event_customerBTMouseClicked

    private void barangBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangBTMouseClicked
        // TODO add your handling code here:
        
        this.masterPanel.remove(vM);
        this.masterPanel.remove(vP);
        this.masterPanel.add(vB);
        vB.show();
        
        
    }//GEN-LAST:event_barangBTMouseClicked

    private void petugasBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasBTMouseClicked
        // TODO add your handling code here:
        this.masterPanel.remove(vB);
        this.masterPanel.remove(vM);
        this.masterPanel.add(vP);
        vP.show();
    }//GEN-LAST:event_petugasBTMouseClicked

    private void barangBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barangBTActionPerformed

    private void customerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barangBT;
    private javax.swing.JButton customerBT;
    private javax.swing.JPanel masterPanel;
    private javax.swing.JButton petugasBT;
    // End of variables declaration//GEN-END:variables
}
