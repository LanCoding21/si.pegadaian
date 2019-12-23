/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import si.pegadaian.model.modelTransaksi;
import si.pegadaian.view.viewFormTransaksi;
import si.pegadaian.view.viewFormTransaksiKasir;


/**
 *
 * @author user-pc
 */
public class controllerTransaksi {
    private modelTransaksi mT;
    private viewFormTransaksi vFT;
    
    public controllerTransaksi(viewFormTransaksi vFT){
        this.vFT=vFT;

    }
    
    public void simpanTransaksiGadai(){
        
        
        mT.simpanDataTransaksi();
    }
    
    
    
    
    
}
