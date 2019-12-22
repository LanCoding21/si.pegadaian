/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.model;

import java.util.Date;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */
public class modelTransaksiKasir {
    private int noGadaiModel;
    private Date tanggalModel;
    private Date jatuhTempoModel;
    private double jumlahPinjamanModel;
    private String terbilangModel;
    private Date tanggalTebusanModel;
    private double jumlahTebusanModel;
    private double dendaModel;
    private double totalTebusanModel;
    private String keteranganModel;
    private int kodeBarangModel;
    private int nipPetugasModel;
    private int ktpCustomerModel;
    
    koneksiDatabase koneksi=new koneksiDatabase();
    
    public modelTransaksiKasir(){
        
    }

    public int getNoGadaiModel() {
        return noGadaiModel;
    }

    public void setNoGadaiModel(int noGadaiModel) {
        this.noGadaiModel = noGadaiModel;
    }

    public Date getTanggalModel() {
        return tanggalModel;
    }

    public void setTanggalModel(Date tanggalModel) {
        this.tanggalModel = tanggalModel;
    }

    public Date getJatuhTempoModel() {
        return jatuhTempoModel;
    }

    public void setJatuhTempoModel(Date jatuhTempoModel) {
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

    public Date getTanggalTebusanModel() {
        return tanggalTebusanModel;
    }

    public void setTanggalTebusanModel(Date tanggalTebusanModel) {
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
    
    
}
