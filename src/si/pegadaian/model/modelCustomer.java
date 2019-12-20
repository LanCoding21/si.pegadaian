/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */
public class modelCustomer {
    private int ktpModel;
    private String namaModel;
    private String alamatModel;
    private String hpModel;
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelCustomer(){
        
    }

    public int getKtpModel() {
        return ktpModel;
    }

    public void setKtpModel(int ktpModel) {
        this.ktpModel = ktpModel;
    }

    public String getNamaModel() {
        return namaModel;
    }

    public void setNamaModel(String namaModel) {
        this.namaModel = namaModel;
    }

    public String getAlamatModel() {
        return alamatModel;
    }

    public void setAlamatModel(String alamatModel) {
        this.alamatModel = alamatModel;
    }

    public String getHpModel() {
        return hpModel;
    }

    public void setHpModel(String hpModel) {
        this.hpModel = hpModel;
    }
    
    public void simpanDataCustomer(){
        String sql=("INSERT INTO nasabah (Ktp, Nama, Alamat, Hp)"
                    +"VALUES('"+getKtpModel()+"', '"+getNamaModel()+"'"
                    + ", '"+getAlamatModel()+"','"+getHpModel()+"')");
        try{
            PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dsimpan"+ex);
          }
        }
    
    public void updateDataCustomer(){
    String sql="UPDATE nasabah SET Nama = '"+getNamaModel()+"'"
            +",Alamat= '"+getAlamatModel()+"'"
            +",Hp='"+getHpModel()
            +"' WHERE Ktp='"+getKtpModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Diupdate"+ex);
          }
    }
    
    public void deleteDataCustomer(){
    String sql="DELETE FROM nasabah WHERE Ktp="+"'"+getKtpModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+ex);
          }
    }
}
