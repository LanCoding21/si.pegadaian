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
public class modelPetugas {
    private int nipModel;
    private String namaModel;
    private String alamatModel;
    private String usernameModel;
    private String passwordModel;
    private String levelModel;
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelPetugas(){
        
    }

    public int getNipModel() {
        return nipModel;
    }

    public void setNipModel(int nipModel) {
        this.nipModel = nipModel;
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

    public String getUsernameModel() {
        return usernameModel;
    }

    public void setUsernameModel(String usernameModel) {
        this.usernameModel = usernameModel;
    }

    public String getPasswordModel() {
        return passwordModel;
    }

    public void setPasswordModel(String passwordModel) {
        this.passwordModel = passwordModel;
    }

    public String getLevelModel() {
        return levelModel;
    }

    public void setLevelModel(String levelModel) {
        this.levelModel = levelModel;
    }
    
    public void simpanDataPetugas(){
        String sql=("INSERT INTO petugas (Nip, Nama, alamat, username, password, level)"
                    +"VALUES('"+getNipModel()+"', '"+getNamaModel()+"'"
                    + ", '"+getAlamatModel()+"','"+getUsernameModel()+"','"+getPasswordModel()+"'"
                    + ",'"+getLevelModel()+"')");
        try{
            PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dsimpan"+ex);
          }
    }
    
    public void updateDataPetugas(){
    String sql="UPDATE petugas SET Nama = '"+getNamaModel()+"'"
            +",alamat= '"+getAlamatModel()+"'"
            +",username='"+getUsernameModel()+"'"
            +",password='"+getPasswordModel()+"'"
            +",level="+getLevelModel()
            +"' WHERE Ktp='"+getNipModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Diupdate"+ex);
          }
    }
    
    public void deleteDataPetugas(){
    String sql="DELETE FROM petugas WHERE Nip="+"'"+getNipModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+ex);
          }
    }
}
