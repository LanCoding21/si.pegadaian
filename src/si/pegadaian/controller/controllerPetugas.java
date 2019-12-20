/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import si.pegadaian.model.modelCustomer;
import si.pegadaian.model.modelPetugas;
import si.pegadaian.view.viewPetugas;

/**
 *
 * @author user-pc
 */
public class controllerPetugas {
    private modelPetugas mP;
    private viewPetugas vP;
    
    public controllerPetugas(viewPetugas vP){
        this.vP=vP;
    }
    
    public void bersihkan(){
        vP.getNoKtpTF().setText("");
        vP.getNamaTF().setText("");
        vP.getUsernameTF().setText("");
        vP.getPasswordTF().setText("");
        vP.getAlamatTA().setText("");

    }
    
    public void simpanPetugas(){
        mP=new modelPetugas();
        mP.setNipModel(Integer.parseInt((vP.getNoKtpTF().getText())));
        mP.setNamaModel(vP.getNamaTF().getText());
        mP.setAlamatModel(vP.getAlamatTA().getText());
        mP.setUsernameModel(vP.getUsernameTF().getText());
        mP.setPasswordModel(vP.getPasswordTF().getText());
        switch (vP.getHakAksesCB().getSelectedIndex()) {
                case 1 :
                mP.setLevelModel("Admin");
                break;
                case 2:
                mP.setLevelModel("Kasir");
                break;
            }
        
        mP.simpanDataPetugas();
    }
    
    public void updatePetugas(){
        mP=new modelPetugas();
        mP.setNipModel(Integer.parseInt((vP.getNoKtpTF().getText())));
        mP.setNamaModel(vP.getNamaTF().getText());
        mP.setAlamatModel(vP.getAlamatTA().getText());
        mP.setUsernameModel(vP.getUsernameTF().getText());
        mP.setPasswordModel(vP.getPasswordTF().getText());
        switch (vP.getHakAksesCB().getSelectedIndex()) {
                case 1 :
                mP.setLevelModel("Admin");
                break;
                case 2:
                mP.setLevelModel("Kasir");
                break;
            }
        mP.updateDataPetugas();
    }
    
    public void deletePetugas(){
        mP=new modelPetugas();
        mP.setNipModel(Integer.parseInt((vP.getNoKtpTF().getText())));
        
        mP.deleteDataPetugas();
    }
}