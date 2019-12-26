/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import si.pegadaian.model.modelTransaksi;
import si.pegadaian.view.viewFormTransaksi;
import si.pegadaian.view.viewFormTransaksiKasir;


/**
 *
 * @author user-pc
 */
public class controllerTransaksi {
    String pattern="yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date();
    private modelTransaksi mT;
    private viewFormTransaksi vFT;
    private String no;
    
    public controllerTransaksi(viewFormTransaksi vFT){
        this.vFT=vFT;

    }
    
    public void bersih(){
        vFT.getCustomerTF().setText("");
        vFT.getBarangTF().setText("");
        vFT.getJumlahPinjamanTF().setText("");
        vFT.getJumlahTebusanTF().setText("");
//        vFT.getJatuhTempo().setDateFormatString("");
    }
    
    public void bersihTebusan(){
        
        vFT.getBunga().setText("");
        vFT.getDataGadaiTF().setText("");
//        vFT.getTanggalTebusan().setDateFormatString("");
        vFT.getHariTF().setText("");
        vFT.getDendaTF().setText("");
        vFT.getTotalTebusan().setText("");
        vFT.getBayarTF().setText("");
        vFT.getKembalianTF().setText("");
    }
    
    public void simpanTransaksiGadai(){
        
        mT=new modelTransaksi();
        mT.setTanggalModel(vFT.getTglSekarangTF().getText());
        mT.setJatuhTempoModel(sdf.format(vFT.getJatuhTempo().getDate()));
        mT.setJumlahPinjamanModel(Double.parseDouble(vFT.getJumlahPinjamanTF().getText()));
        mT.setJumlahTebusanModel(Double.parseDouble(vFT.getJumlahTebusanTF().getText()));
        mT.setKodeBarangModel(vFT.id_barang);
        mT.setNipPetugasModel(Integer.parseInt(vFT.nip));
        mT.setKtpCustomerModel(vFT.noKtp);
        mT.setKeteranganModel("Belum Ditebus");
        
        mT.simpanDataTransaksi();
        bersih();
    }
    
    public void deleteTransaksiGadai(){
        mT=new modelTransaksi();
        mT.setNoGadaiModel(Integer.parseInt(vFT.no));
        
        mT.deleteDataTransaksi();
    }
    
    public void updateTebus(){
        mT=new modelTransaksi();
        mT.setNoGadaiModel(Integer.parseInt(vFT.no));
        mT.setTanggalTebusanModel(sdf.format(vFT.getTanggalTebusan().getDate()));
        mT.setJumlahTebusanModel(Double.parseDouble(vFT.getJumlahTebusanTF().getText()));
        mT.setDendaModel(Double.parseDouble(vFT.getDendaTF().getText()));
        mT.setTotalTebusanModel(Double.parseDouble(vFT.getTotalTebusan().getText()));
        mT.setKeteranganModel("Sudah Ditebus");
        
        mT.updateDataTebus();
        bersihTebusan();
    }
    
    public void updatePerpanjang(){
        mT=new modelTransaksi();
        mT.setNoGadaiModel(Integer.parseInt(vFT.no));
        mT.setJatuhTempoModel(sdf.format(vFT.getJatuhTempo().getDate()));
        
        mT.updateDataPerpanjang();
        
    }
    
    
    
}
