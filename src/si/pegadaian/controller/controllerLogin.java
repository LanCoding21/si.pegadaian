/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import si.pegadaian.model.modelLogin;
import si.pegadaian.view.viewLoginInternal;

/**
 *
 * @author user-pc
 */
public class controllerLogin {
    private modelLogin mL;
    private viewLoginInternal vL;
    
    public controllerLogin(viewLoginInternal vL){
        this.vL=vL;
    }
    
    public void bersihkan(){
        vL.getUsernameTF().setText("");
        vL.getPasswordPF().setText("");
    }
    
}
