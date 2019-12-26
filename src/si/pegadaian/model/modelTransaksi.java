/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */
public class modelTransaksi {
    private int noGadaiModel;
    private String tanggalModel;
    private String jatuhTempoModel;
    private double jumlahPinjamanModel;
    private String terbilangModel;
    private String tanggalTebusanModel;
    private double jumlahTebusanModel;
    private double dendaModel;
    private double totalTebusanModel;
    private String keteranganModel;
    private int kodeBarangModel;
    private int nipPetugasModel;
    private int ktpCustomerModel;
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelTransaksi(){
        
    }

    public int getNoGadaiModel() {
        return noGadaiModel;
    }

    public void setNoGadaiModel(int noGadaiModel) {
        this.noGadaiModel = noGadaiModel;
    }

    public String getTanggalModel() {
        return tanggalModel;
    }

    public void setTanggalModel(String tanggalModel) {
        this.tanggalModel = tanggalModel;
    }

    public String getJatuhTempoModel() {
        return jatuhTempoModel;
    }

    public void setJatuhTempoModel(String jatuhTempoModel) {
        this.jatuhTempoModel = jatuhTempoModel;
    }

    public double getJumlahPinjamanModel() {
        return jumlahPinjamanModel;
    }

    public void setJumlahPinjamanModel(double jumlahPinjamanModel) {
        this.jumlahPinjamanModel = jumlahPinjamanModel;
    }

    public String getTerbilangModel() {
        return terbilangModel;
    }

    public void setTerbilangModel(String terbilangModel) {
        this.terbilangModel = terbilangModel;
    }

    public String getTanggalTebusanModel() {
        return tanggalTebusanModel;
    }

    public void setTanggalTebusanModel(String tanggalTebusanModel) {
        this.tanggalTebusanModel = tanggalTebusanModel;
    }

    public double getJumlahTebusanModel() {
        return jumlahTebusanModel;
    }

    public void setJumlahTebusanModel(double jumlahTebusanModel) {
        this.jumlahTebusanModel = jumlahTebusanModel;
    }

    public double getDendaModel() {
        return dendaModel;
    }

    public void setDendaModel(double dendaModel) {
        this.dendaModel = dendaModel;
    }

    public double getTotalTebusanModel() {
        return totalTebusanModel;
    }

    public void setTotalTebusanModel(double totalTebusanModel) {
        this.totalTebusanModel = totalTebusanModel;
    }

    public String getKeteranganModel() {
        return keteranganModel;
    }

    public void setKeteranganModel(String keteranganModel) {
        this.keteranganModel = keteranganModel;
    }

    public int getKodeBarangModel() {
        return kodeBarangModel;
    }

    public void setKodeBarangModel(int kodeBarangModel) {
        this.kodeBarangModel = kodeBarangModel;
    }

    public int getNipPetugasModel() {
        return nipPetugasModel;
    }

    public void setNipPetugasModel(int nipPetugasModel) {
        this.nipPetugasModel = nipPetugasModel;
    }

    public int getKtpCustomerModel() {
        return ktpCustomerModel;
    }

    public void setKtpCustomerModel(int ktpCustomerModel) {
        this.ktpCustomerModel = ktpCustomerModel;
    }
    
    public void simpanDataTransaksi(){
        String sql=("INSERT INTO gadai (Tgl_gadai,Jatuh_tempo,Jumlah_pinjaman,Jumlah_tebusan,Keterangan,Barang_Kode_barang,Petugas_Nip,Nasabah_Ktp)"
                    +"VALUES('"+getTanggalModel()+"'"
                    + ", '"+getJatuhTempoModel()+"','"+getJumlahPinjamanModel()+"'"
                    + ",'"+getJumlahTebusanModel()+"','"+getKeteranganModel()+"','"+getKodeBarangModel()+"','"+getNipPetugasModel()+"','"+getKtpCustomerModel()+"')");
        try{
            PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dsimpan"+ex);
          }
    }
    
    public void parsing(){
        String sql=("SELECT No_gadai FROM gadai");
        try{
            PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dsimpan"+ex);
          }
    }
    
    public void deleteDataTransaksi(){
    String sql="DELETE FROM gadai WHERE No_gadai="+"'"+getNoGadaiModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
         
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+ex);
          }
    }
    
    public void updateDataTebus(){
    String sql="UPDATE gadai SET Tgl_tebusan = '"+getTanggalTebusanModel()+"'"
            +",Jumlah_tebusan= '"+getJumlahTebusanModel()+"'"
            +",Denda='"+getDendaModel()+"'"
            +",Total_tebusan='"+getTotalTebusanModel()+"'"
            +",Keterangan='"+getKeteranganModel()
            +"' WHERE No_gadai='"+getNoGadaiModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Data Berhasil Ditebus");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Data Gagal Ditebus"+ex);
          }
    }
    
    public void updateDataPerpanjang(){
    String sql="UPDATE gadai SET Jatuh_tempo = '"+getJatuhTempoModel()+"' WHERE No_gadai='"+getNoGadaiModel()+"'";
    try {
         PreparedStatement eksekusi=koneksi.getKoneksi().prepareStatement(sql);
         eksekusi.execute();
        
         JOptionPane.showMessageDialog(null, "Jatuh Tempo Berhasil Diperpanjang");
        } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Jatuh Tempo Gagal Diperpanjang"+ex);
          }
    }
    
    
    
    
}
