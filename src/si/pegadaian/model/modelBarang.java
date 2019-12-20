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
public class modelBarang {
    private int kodeBarangModel;
    private String namaBarangModel;
    private String typeModel;
    private String warnaModel;
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelBarang(){
        
    }

    public int getKodeBarangModel() {
        return kodeBarangModel;
    }

    public void setKodeBarangModel(int kodeBarangModel) {
        this.kodeBarangModel = kodeBarangModel;
    }

    public String getNamaBarangModel() {
        return namaBarangModel;
    }

    public void setNamaBarangModel(String namaBarangModel) {
        this.namaBarangModel = namaBarangModel;
    }

    public String getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(String typeModel) {
        this.typeModel = typeModel;
    }

    public String getWarnaModel() {
        return warnaModel;
    }

    public void setWarnaModel(String warnaModel) {
        this.warnaModel = warnaModel;
    }

    public void simpanDataBarang(){
        String sql=("INSERT INTO barang (Kode_barang, Nama_barang, Type, Warna)"
                    +"VALUES('"+getKodeBarangModel()+"', '"+getNamaBarangModel()+"'"
                    + ", '"+getTypeModel()+"','"+getWarnaModel()+"')");
        try{
            PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dsimpan"+ex);
          }
        }
    
    public void updateDataBarang(){
    String sql="UPDATE barang SET Nama_barang = '"+getNamaBarangModel()+"'"
            +",Type= '"+getTypeModel()+"'"
            +",Warna='"+getWarnaModel()
            +"' WHERE Kode_barang='"+getKodeBarangModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Diupdate"+ex);
          }
    }
    
    public void deleteDataBarang(){
    String sql="DELETE FROM barang WHERE Kode_barang="+"'"+getKodeBarangModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+ex);
          }
    }
}
