/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import si.pegadaian.controller.controllerLogin;
import si.pegadaian.db.koneksiDatabase;
import si.pegadaian.view.viewLoginInternal;

/**
 *
 * @author user-pc
 */

public class modelLogin {
    private int Nip;
    private String Nama;
    private String alamat;
    private String username;
    private String Password;
    private String Hakakses;
    
    private controllerLogin cL;
    
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelLogin(){
        
    }

    public int getNip() {
        return Nip;
    }

    public void setNip(int Nip) {
        this.Nip = Nip;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getHakakses() {
        return Hakakses;
    }

    public void setHakakses(String Hakakses) {
        this.Hakakses = Hakakses;
    }
    
    
}
