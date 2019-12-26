/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import si.pegadaian.view.viewMaster;

/**
 *
 * @author user-pc
 */
public class SiPegadaianMvc {
    private static String nama="";
    private static String nip="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        appUtama utama=new appUtama(nama,nip);
        utama.setVisible(true);
//        view vM=new viewMaster();
//        vM.setVisible(true);
//        wallpaper wal=new wallpaper();
//        wal.setVisible(true);
        
      
    }
    
}
