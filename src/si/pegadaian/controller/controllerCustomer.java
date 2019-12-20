/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import si.pegadaian.model.modelCustomer;
import si.pegadaian.view.viewCustomer;

/**
 *
 * @author user-pc
 */
public class controllerCustomer {
    private modelCustomer mC;
    private viewCustomer vC;
    
    public controllerCustomer(viewCustomer vC){
        this.vC=vC;
    }
    
    public void bersihkan(){
        vC.getNoKtpTF().setText("");
        vC.getNamaTF().setText("");
        vC.getAlamatTA().setText("");
        vC.getNoTelpTF().setText("");
    }
    
    public void simpanCustomer(){
        mC=new modelCustomer();
        mC.setKtpModel(Integer.parseInt((vC.getNoKtpTF().getText())));
        mC.setNamaModel(vC.getNamaTF().getText());
        mC.setAlamatModel(vC.getAlamatTA().getText());
        mC.setHpModel(vC.getNoTelpTF().getText());
        
        mC.simpanDataCustomer();
    }
    
    public void updateCustomer(){
        mC=new modelCustomer();
        mC.setKtpModel(Integer.parseInt(vC.getNoKtpTF().getText()));
        mC.setNamaModel(vC.getNamaTF().getText());
        mC.setAlamatModel(vC.getAlamatTA().getText());
        mC.setHpModel(vC.getNoTelpTF().getText());
        
        mC.updateDataCustomer();
    }
    
    public void deleteCustomer(){
        mC=new modelCustomer();
        mC.setKtpModel(Integer.parseInt(vC.getNoKtpTF().getText()));
        
        mC.deleteDataCustomer();
    }
}