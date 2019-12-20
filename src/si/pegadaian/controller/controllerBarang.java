/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import si.pegadaian.model.modelBarang;
import si.pegadaian.model.modelCustomer;
import si.pegadaian.view.viewBarang;
import si.pegadaian.view.viewCustomer;

/**
 *
 * @author user-pc
 */
public class controllerBarang {
    private modelBarang mB;
    private viewBarang vB;
    
    public controllerBarang(viewBarang vB){
        this.vB=vB;
    }
    
    public void bersihkan(){
        vB.getKodeBarangTF().setText("");
        vB.getNamaBarangTF().setText("");
        vB.getTypeTF().setText("");
        vB.getWarnaTF().setText("");
        
    }
    
    public void simpanBarang(){
        mB=new modelBarang();
//        mB.setKodeBarangModel(Integer.parseInt(vB.getKodeBarangTF().getText()));
        mB.setNamaBarangModel(vB.getNamaBarangTF().getText());
        mB.setTypeModel(vB.getTypeTF().getText());
        mB.setWarnaModel(vB.getWarnaTF().getText());
        
        mB.simpanDataBarang();
    }
    
    public void updateBarang(){
         mB=new modelBarang();
         mB.setKodeBarangModel(Integer.parseInt(vB.getKodeBarangTF().getText()));
        mB.setNamaBarangModel(vB.getNamaBarangTF().getText());
        mB.setTypeModel(vB.getTypeTF().getText());
        mB.setWarnaModel(vB.getWarnaTF().getText());
        
        mB.updateDataBarang();
    }
    
    public void deleteBarang(){
        mB=new modelBarang();
        mB.setKodeBarangModel(Integer.parseInt(vB.getKodeBarangTF().getText()));
        
        mB.deleteDataBarang();
    }
    
}