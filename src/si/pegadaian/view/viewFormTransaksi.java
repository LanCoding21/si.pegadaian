/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.view;

import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import si.pegadaian.controller.controllerTransaksi;
import si.pegadaian.db.koneksiDatabase;

/**
 *
 * @author user-pc
 */
public class viewFormTransaksi extends javax.swing.JInternalFrame {
    private String nama;
    public String nip;
    public int id_barang;
    public int noKtp;
    public Date tempo;
    public Double pinjam;
    /**
     * Creates new form formTransaksi
     */
    public String no="";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    public controllerTransaksi cT;
    public viewLoginInternal vL;
    public DefaultTableModel model;
    public DefaultTableModel modelTebus;
    private String sql = "";
    
    viewListDataBarang vlb;
    viewListDataCustomer vlc;
    public viewFormTransaksi(String nama, String nip) {
        initComponents();
       viewLoginInternal log=new viewLoginInternal();
        this.nama=nama;
        this.nip=nip;
        
        dibayarLB.setEnabled(false);
        kembalianLB.setEnabled(false);
        bayarTF.setEnabled(false);
        kembalianTF.setEnabled(false);
        hitungPanjangBT.setEnabled(false);
        hitungTransaksiBT.setEnabled(false);
        customerTF.setEnabled(false);
        barangTF.setEnabled(false);
        jumlahPinjamanTF.setEnabled(false);
        jumlahTebusanTF.setEnabled(false);
        jatuhTempo.setEnabled(false);
        hitungHariBT.setEnabled(false);
        dataGadaiTF.setEnabled(false);
        tanggalTebusan.setEnabled(false);
        hariTF.setEnabled(false);
        hitungBT.setEnabled(false);
        dendaTF.setEnabled(false);
        simpanBT.setEnabled(false);
        perpanjangBT.setEnabled(false);
        simpanTebusBT.setEnabled(false);
        deleteTebusBT.setEnabled(true);
        deleteBT.setEnabled(true);
        
        vlc= new viewListDataCustomer(this);
        vlb= new viewListDataBarang(this);
        
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        tglSekarangTF.setText(dateFormat1.format(date));

//        tampil_customer();
//        tampil_barang();
//        tampil_gadai();
        cT = new controllerTransaksi(this);

        model = new DefaultTableModel();
        tabelTransaksi.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama Petugas");
        model.addColumn("Nama Nasabah");
        model.addColumn("Kode Barang");
        model.addColumn("Tanggal Gadai");
        model.addColumn("Jatuh Tempo");
        model.addColumn("Jumlah Pinjaman");
        model.addColumn("Jumlah Tebusan");
        model.addColumn("Keterangan");

        tampilDataTransaksi("");

        modelTebus = new DefaultTableModel();
        tabelTebusan.setModel(modelTebus);
        modelTebus.addColumn("ID");
        modelTebus.addColumn("Nama Petugas");
        modelTebus.addColumn("Nama Nasabah");
        modelTebus.addColumn("Kode Barang");
        modelTebus.addColumn("Jatuh Tempo");
        modelTebus.addColumn("Tanggal Tebusan");
        modelTebus.addColumn("Jumlah Pinjaman");
        modelTebus.addColumn("Jumlah Tebusan");
        modelTebus.addColumn("Denda");
        modelTebus.addColumn("Total Tebusan");
        modelTebus.addColumn("Keterangan");

        tampilDataTebusan("");
    }
    

    public JTextField getBarangTF() {
        return barangTF;
    }

    

    public JLabel getBunga() {
        return bungaLB;
    }

    public JTextField getCustomerTF() {
        return customerTF;
    }

    public JDateChooser getTanggalTebusan() {
        return tanggalTebusan;
    }
    
    

    public JTextField getJumlahPinjamanTF() {
        return jumlahPinjamanTF;
    }

    public JTextField getDataGadaiTF() {
        return dataGadaiTF;
    }

    

    public JTextField getDendaTF() {
        return dendaTF;
    }

    public JTextField getHariTF() {
        return hariTF;
    }

    public JDateChooser getJatuhTempo() {
        return jatuhTempo;
    }

    public JTextField getJumlahTebusanTF() {
        return jumlahTebusanTF;
    }

    public JTextField getBayarTF() {
        return bayarTF;
    }

    public JTextField getKembalianTF() {
        return kembalianTF;
    }

    
    
    public JTextField getTglSekarangTF() {
        return tglSekarangTF;
    }

    public JLabel getTotalTebusan() {
        return totalTebusan;
    }

    public JComboBox<String> getTransaksiCB() {
        return transaksiCB;
    }

    public JTable getTabelTransaksi() {
        return tabelTransaksi;
    }
    
   

    public void tampilDataTransaksi(String data) {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        if (data.equals("")) {
            sql = "SELECT No_gadai,Nama_petugas,Nama_nasabah, Kode_barang, Tgl_gadai, Jatuh_tempo,Jumlah_pinjaman,Jumlah_tebusan,Keterangan "
                    + "FROM gadai gd, barang br, nasabah ns, petugas pt WHERE gd.Barang_Kode_barang=br.Kode_barang AND gd.Petugas_Nip=pt.Nip AND gd.Nasabah_Ktp=ns.Ktp AND Keterangan='Belum Ditebus' ";
        } else {
            sql = "SELECT No_gadai,Nama_petugas,Nama_nasabah, Kode_barang, Tgl_gadai, Jatuh_tempo,Jumlah_pinjaman,Jumlah_tebusan,Keterangan"
                    + " FROM gadai gd, barang br, nasabah ns, petugas pt "
                    + "WHERE gd.Barang_Kode_barang=br.Kode_barang "
                    + "AND gd.Petugas_Nip=pt.Nip "
                    + "AND gd.Nasabah_Ktp=ns.Ktp "
                    + "AND Keterangan='Belum Ditebus'"
                    + "AND Kode_barang LIKE '" + data + "%'";
        }

        try {
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] hasil;
                hasil = new Object[9];//karena ada 6 field ditabel pelanggan
                hasil[0] = res.getInt("No_gadai");
                hasil[1] = res.getString("Nama_petugas");
                hasil[2] = res.getString("Nama_nasabah");
                hasil[3] = res.getString("Kode_barang");
                hasil[4] = res.getString("Tgl_gadai");
                hasil[5] = res.getString("Jatuh_tempo");
                hasil[6] = res.getString("Jumlah_pinjaman");
                hasil[7] = res.getString("Jumlah_tebusan");
                hasil[8] = res.getString("Keterangan");

                model.addRow(hasil);
                
                no=res.getString("No_gadai");
                pinjam=Double.parseDouble(res.getString("Jumlah_pinjaman"));
                
                try{
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                Date date = new Date();
                Date date2 = sdf.parse(String.valueOf(res.getString("Jatuh_tempo")));
                tempo=date2;
                
                
                }catch (Exception e){
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tampilDataTebusan(String data) {
        modelTebus.getDataVector().removeAllElements();
        modelTebus.fireTableDataChanged();

        if (data.equals("")) {
            sql = "SELECT No_gadai,Nama_petugas,Nama_nasabah, Kode_barang, Jatuh_tempo, Tgl_tebusan, Jumlah_pinjaman,Jumlah_tebusan,Denda, Total_tebusan, Keterangan "
                    + "FROM gadai gd, barang br, nasabah ns, petugas pt WHERE gd.Barang_Kode_barang=br.Kode_barang AND gd.Petugas_Nip=pt.Nip AND gd.Nasabah_Ktp=ns.Ktp AND Keterangan='Sudah Ditebus'";
        } else {
            sql = "SELECT No_gadai,Nama_petugas,Nama_nasabah, Kode_barang, Tgl_gadai, Jatuh_tempo,Jumlah_pinjaman,Jumlah_tebusan,Keterangan"
                    + " FROM gadai gd, barang br, nasabah ns, petugas pt "
                    + "WHERE gd.Barang_Kode_barang=br.Kode_barang "
                    + "AND gd.Petugas_Nip=pt.Nip "
                    + "AND gd.Nasabah_Ktp=ns.Ktp "
                    + "AND Jatuh_tempo LIKE '" + data + "%'";
        }

        try {
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] hasil;
                hasil = new Object[11];//karena ada 6 field ditabel pelanggan
                hasil[0] = res.getInt("No_gadai");
                hasil[1] = res.getString("Nama_petugas");
                hasil[2] = res.getString("Nama_nasabah");
                hasil[3] = res.getString("Kode_barang");
                hasil[4] = res.getString("Jatuh_tempo");
                hasil[5] = res.getString("Tgl_tebusan");
                hasil[6] = res.getString("Jumlah_pinjaman");
                hasil[7] = res.getString("Jumlah_tebusan");
                hasil[8] = res.getString("Denda");
                hasil[9] = res.getString("Total_tebusan");
                hasil[10] = res.getString("Keterangan");

                modelTebus.addRow(hasil);
                
                no=res.getString("No_gadai");
            
                
                

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        transaksiCB = new javax.swing.JComboBox<>();
        tglSekarangTF = new javax.swing.JTextField();
        jumlahPinjamanTF = new javax.swing.JTextField();
        hitungHariBT = new javax.swing.JButton();
        hariTF = new javax.swing.JTextField();
        jumlahTebusanTF = new javax.swing.JTextField();
        hitungBT = new javax.swing.JButton();
        dendaTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        totalTebusan = new javax.swing.JLabel();
        bungaLB = new javax.swing.JLabel();
        simpanBT = new javax.swing.JButton();
        deleteBT = new javax.swing.JButton();
        perpanjangBT = new javax.swing.JButton();
        detailBT = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        cariTransaksiTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jatuhTempo = new com.toedter.calendar.JDateChooser();
        tanggalTebusan = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        simpanTebusBT = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        deleteTebusBT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTebusan = new javax.swing.JTable();
        customerTF = new javax.swing.JTextField();
        barangTF = new javax.swing.JTextField();
        dataGadaiTF = new javax.swing.JTextField();
        dibayarLB = new javax.swing.JLabel();
        bayarTF = new javax.swing.JTextField();
        kembalianTF = new javax.swing.JTextField();
        hitungPanjangBT = new javax.swing.JButton();
        hitungTransaksiBT = new javax.swing.JButton();
        kembalianLB = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Form Transaksi");

        jLabel1.setText("Transaksi");

        jLabel2.setText("Customer");

        jLabel3.setText("Tanggal Sekarang");

        jLabel4.setText("Jumlah Pinjaman");

        jLabel6.setText("Jatuh Tempo");

        jLabel7.setText("Jumlah Tebusan");

        jLabel8.setText("Data Gadai");

        jLabel9.setText("Tanggal Tebusan");

        jLabel10.setText("Hari");

        jLabel11.setText("Denda");

        transaksiCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Gadai", "Tebusan", "Perpanjang", " " }));
        transaksiCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiCBActionPerformed(evt);
            }
        });

        tglSekarangTF.setEditable(false);
        tglSekarangTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        hitungHariBT.setText("Hitung Hari");
        hitungHariBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungHariBTActionPerformed(evt);
            }
        });

        hariTF.setText("0");

        jumlahTebusanTF.setText("0");
        jumlahTebusanTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahTebusanTFActionPerformed(evt);
            }
        });

        hitungBT.setText("Hitung");
        hitungBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungBTActionPerformed(evt);
            }
        });

        dendaTF.setText("0");

        jLabel5.setText("Total Tebusan");

        jLabel12.setText("Bunga");

        jLabel13.setText("Rp. ");

        jLabel14.setText("Rp. ");

        simpanBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save-32.png"))); // NOI18N
        simpanBT.setText("Proses Transaksi");
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });

        deleteBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-property-32.png"))); // NOI18N
        deleteBT.setText("Delete");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        perpanjangBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-property-32.png"))); // NOI18N
        perpanjangBT.setText("Pepanjang");
        perpanjangBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perpanjangBTActionPerformed(evt);
            }
        });

        detailBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view-details-32.png"))); // NOI18N
        detailBT.setText("Detail");
        detailBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBTActionPerformed(evt);
            }
        });

        jLabel16.setText("Cari dengan Kode Barang");

        cariTransaksiTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariTransaksiTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariTransaksiTFKeyTyped(evt);
            }
        });

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelTransaksi);

        jatuhTempo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jatuhTempoPropertyChange(evt);
            }
        });

        jLabel17.setText("Barang");

        simpanTebusBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save-32.png"))); // NOI18N
        simpanTebusBT.setText("Save");
        simpanTebusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanTebusBTActionPerformed(evt);
            }
        });

        jLabel18.setText("Transaksi Tebusan");

        deleteTebusBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete-property-32.png"))); // NOI18N
        deleteTebusBT.setText("Delete");
        deleteTebusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTebusBTActionPerformed(evt);
            }
        });

        tabelTebusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelTebusan);

        customerTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerTFFocusLost(evt);
            }
        });
        customerTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customerTFMousePressed(evt);
            }
        });

        barangTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                barangTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                barangTFFocusLost(evt);
            }
        });
        barangTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barangTFMousePressed(evt);
            }
        });

        dataGadaiTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dataGadaiTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dataGadaiTFFocusLost(evt);
            }
        });
        dataGadaiTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataGadaiTFMousePressed(evt);
            }
        });

        dibayarLB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dibayarLB.setText("Dibayar");

        bayarTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bayarTF.setText("0");

        kembalianTF.setEditable(false);
        kembalianTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kembalianTF.setText("0");
        kembalianTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianTFActionPerformed(evt);
            }
        });

        hitungPanjangBT.setText("Hitung");
        hitungPanjangBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungPanjangBTActionPerformed(evt);
            }
        });

        hitungTransaksiBT.setText("Hitung Transaksi");
        hitungTransaksiBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungTransaksiBTActionPerformed(evt);
            }
        });

        kembalianLB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kembalianLB.setText("Kembalian");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(61, 61, 61)
                        .addComponent(dendaTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hariTF)
                            .addComponent(tanggalTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(hitungBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jumlahTebusanTF))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(dataGadaiTF))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jumlahPinjamanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(hitungHariBT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglSekarangTF)
                            .addComponent(transaksiCB, 0, 0, Short.MAX_VALUE)
                            .addComponent(customerTF)
                            .addComponent(barangTF))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel12))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(totalTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bungaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(simpanBT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(deleteBT)))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hitungTransaksiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addComponent(dibayarLB)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kembalianLB)
                                                .addComponent(kembalianTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(hitungPanjangBT)
                                            .addGap(153, 153, 153)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(117, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(perpanjangBT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(detailBT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(cariTransaksiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(70, 70, 70))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                                .addComponent(jScrollPane1))
                            .addGap(38, 38, 38)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpanTebusBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteTebusBT)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dibayarLB)
                    .addComponent(kembalianLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(totalTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(bungaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bayarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hitungPanjangBT)
                                    .addComponent(kembalianTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitungTransaksiBT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanBT)
                            .addComponent(deleteBT)
                            .addComponent(perpanjangBT)
                            .addComponent(detailBT)
                            .addComponent(cariTransaksiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanTebusBT)
                            .addComponent(jLabel18)
                            .addComponent(deleteTebusBT))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transaksiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tglSekarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jumlahPinjamanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hitungHariBT)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jumlahTebusanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dataGadaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(tanggalTebusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(hariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hitungBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dendaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahTebusanTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahTebusanTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahTebusanTFActionPerformed

    private void transaksiCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiCBActionPerformed
        // TODO add your handling code here:
        switch (transaksiCB.getSelectedIndex()) {
            case 0:
                
                break;
            case 1:
                customerTF.setEnabled(true);
                barangTF.setEnabled(true);
                jumlahPinjamanTF.setEnabled(true);
                jumlahPinjamanTF.setEnabled(true);
                jumlahPinjamanTF.setEditable(true);
                jumlahTebusanTF.setEnabled(true);
                totalTebusan.setEnabled(true);
                jatuhTempo.setEnabled(true);
                hitungHariBT.setEnabled(true);
                simpanBT.setEnabled(true);
                dataGadaiTF.setEnabled(false);
                tanggalTebusan.setEnabled(false);
                hariTF.setEnabled(false);
                hitungBT.setEnabled(false);
                dendaTF.setEnabled(false);
                perpanjangBT.setEnabled(false);
                simpanTebusBT.setEnabled(false);
                deleteTebusBT.setEnabled(false);
                deleteBT.setEnabled(true);
                
                break;
            case 2:
                customerTF.setEnabled(false);
                barangTF.setEnabled(false);
                jumlahPinjamanTF.setEditable(false);
                jatuhTempo.setEnabled(true);
                jumlahTebusanTF.setEditable(false);
                dataGadaiTF.setEnabled(true);
                tanggalTebusan.setEnabled(true);
                hariTF.setEnabled(true);
                hitungBT.setEnabled(true);
                dendaTF.setEnabled(true);
                simpanBT.setEnabled(false);
                hitungHariBT.setEnabled(false);
                perpanjangBT.setEnabled(false);
                deleteBT.setEnabled(false);
                detailBT.setEnabled(true);
                simpanTebusBT.setEnabled(false);
                deleteTebusBT.setEnabled(true);
                kembalianLB.setEnabled(true);
                dibayarLB.setEnabled(true);
                bayarTF.setEnabled(true);
                kembalianTF.setEnabled(true);
                hitungTransaksiBT.setEnabled(true);
                hitungPanjangBT.setEnabled(true);
                break;
            case 3:
                customerTF.setEnabled(false);
                barangTF.setEnabled(false);
                jumlahPinjamanTF.setEditable(false);
                jatuhTempo.setEnabled(true);
                jumlahTebusanTF.setEditable(false);
                hitungHariBT.setEnabled(false);
                dataGadaiTF.setEnabled(true);
                tanggalTebusan.setEnabled(false);
                hariTF.setEditable(false);
                hitungBT.setEnabled(false);
                dendaTF.setEditable(false);
                simpanBT.setEnabled(false);
                deleteBT.setEnabled(false);
                detailBT.setEnabled(false);
                perpanjangBT.setEnabled(true);
                simpanTebusBT.setEnabled(false);
                deleteTebusBT.setEnabled(false);
                dibayarLB.setEnabled(false);
                kembalianLB.setEnabled(false);
                kembalianTF.setEnabled(true);
                bayarTF.setEnabled(true);
                hitungPanjangBT.setEnabled(true);
                hitungTransaksiBT.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_transaksiCBActionPerformed

    private void cariTransaksiTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTransaksiTFKeyPressed
        // TODO add your handling code here:
        tampilDataTransaksi(cariTransaksiTF.getText());
    }//GEN-LAST:event_cariTransaksiTFKeyPressed

    private void cariTransaksiTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTransaksiTFKeyTyped
        // TODO add your handling code here:
        
//        tampilDataTebusan(cariTransaksiTF.getText());
    }//GEN-LAST:event_cariTransaksiTFKeyTyped

    private void hitungHariBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungHariBTActionPerformed
        // TODO add your handling code here:
        String pattern="yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        jatuhTempo.setDateFormatString("yyyy-MM-dd");
        Date date = new Date();
        

        try {
            int pinjaman = Integer.valueOf(jumlahPinjamanTF.getText());
            Date date1 = sdf.parse(String.valueOf(sdf.format(date)));
            Date date2 = sdf.parse(String.valueOf(sdf.format(jatuhTempo.getDate())));
            long selisih = date2.getTime() - date1.getTime();
            int telat = (int) TimeUnit.DAYS.convert(selisih, TimeUnit.MILLISECONDS);;
            if (telat > 14) {
                JOptionPane.showMessageDialog(rootPane, "Batas waktu Gadai" + "\n Tidak Boleh Lebih dari 14 Hari");
                simpanBT.setEnabled(false);
            } else if (telat < 0) {
                JOptionPane.showMessageDialog(rootPane, "Tanggal Jatuh Tempo " + "\n Tidak Sesuai");
                simpanBT.setEnabled(false);
            } else if (telat <= 14) {
                if (pinjaman < 800000) {
                    int tebusan = pinjaman + ((pinjaman * 10) / 100);
                    jumlahTebusanTF.setText(String.valueOf(tebusan));
                    double bunga2 = (pinjaman * 10) / 100;
                    bungaLB.setText(String.valueOf(bunga2));
                } else if (pinjaman >= 800000) {
                    int tebusan = pinjaman + ((pinjaman * 10) / 100) + 5000;
                    jumlahTebusanTF.setText((String.valueOf(tebusan)));
                    double bunga2 = (pinjaman * 10) / 100;
                    bungaLB.setText(String.valueOf(bunga2));
                }
                simpanBT.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tanggal Belum Dipilih");
                simpanBT.setEnabled(false);
            }
            
            
            return;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Data Belum Diisi Semuanya");
        }
        
        
        
        

        
    }//GEN-LAST:event_hitungHariBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
//        cT.simpanTransaksiGadai();
//        tampilDataTransaksi("");
        id_barang = vlb.id_barang;
        noKtp=vlc.ktp;
        cT.simpanTransaksiGadai();
        tampilDataTransaksi("");
    }//GEN-LAST:event_simpanBTActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        // TODO add your handling code here:
        cT.deleteTransaksiGadai();
        
        tampilDataTransaksi("");
    }//GEN-LAST:event_deleteBTActionPerformed

    private void customerTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerTFFocusGained
        // TODO add your handling code here:
//        viewListDataCustomer vlc= new viewListDataCustomer(this);
//        vlc.setVisible(true);
    }//GEN-LAST:event_customerTFFocusGained

    private void customerTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerTFFocusLost
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_customerTFFocusLost

    private void barangTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barangTFFocusLost
        // TODO add your handling code here:        
        
    }//GEN-LAST:event_barangTFFocusLost

    private void detailBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBTActionPerformed
        // TODO add your handling code here:
        if(tabelTransaksi.getSelectedRowCount() != 0){
            int selected = tabelTransaksi.getSelectedRow();
            viewListDataBarang vlb=new viewListDataBarang(this);
            vlb.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih.");
        }
    }//GEN-LAST:event_detailBTActionPerformed

    private void barangTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barangTFFocusGained
        // TODO add your handling code here:
//        viewListDataBarang vlb= new viewListDataBarang(this);
//        vlb.setVisible(true);
    }//GEN-LAST:event_barangTFFocusGained

    private void dataGadaiTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataGadaiTFFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dataGadaiTFFocusGained

    private void dataGadaiTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataGadaiTFFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dataGadaiTFFocusLost

    private void hitungBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungBTActionPerformed
        // TODO add your handling code here:
        try{
            DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            
            
            Date date2=dateFormat.parse(String.valueOf(sdf.format(tanggalTebusan.getDate())));
            Date date1=dateFormat.parse(String.valueOf(sdf.format(tempo)));
            
            long selisih = date2.getTime() - date1.getTime();
            int telat = (int) TimeUnit.DAYS.convert(selisih, TimeUnit.MILLISECONDS);
            if(date2.getTime() < date1.getTime()){
                JOptionPane.showMessageDialog(null, "Tanggal Jatuh Tempo Tidak Valid");
            }else{
                if(telat< 7){
                    hariTF.setText(String.valueOf(telat));
                    double denda = telat * 10000;
                    dendaTF.setText(String.valueOf(denda));
                    double total=denda + (Double.valueOf(jumlahTebusanTF.getText()));
                    totalTebusan.setText(String.valueOf(total));
                    bayarTF.setVisible(true);
                    kembalianTF.setVisible(true);
                    hitungPanjangBT.setVisible(true);
                    hitungTransaksiBT.setVisible(true);
                    dibayarLB.setVisible(true);
                    kembalianLB.setVisible(true);
                }else {
//                    
                }
            }
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Tanggal kembali belum dipilih");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_hitungBTActionPerformed

    private void kembalianTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianTFActionPerformed

    private void hitungPanjangBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungPanjangBTActionPerformed
        // TODO add your handling code here:
//        int index = jdatagadai.getSelectedIndex() - 1;
//        Gadai g = dao.loadGadai().get(index);
            
        double bayar = Double.valueOf(bayarTF.getText());
        double bunga2 = (pinjam * 10) / 100;
//
        if (bunga2 > bayar) {
            JOptionPane.showMessageDialog(rootPane, "Uang Anda Kurang");
        } else {
            kembalianTF.setText(String.valueOf(bayar - bunga2));
            cT.updatePerpanjang();
            tampilDataTransaksi("");
            cT.bersihTebusan();
//            JOptionPane.showMessageDialog(rootPane, "Perpanjang Tanggal Jatuh Tempo Berhasil");

      }
    }//GEN-LAST:event_hitungPanjangBTActionPerformed

    private void hitungTransaksiBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungTransaksiBTActionPerformed
        double total = Double.valueOf(totalTebusan.getText());
        double bayar = Double.valueOf(bayarTF.getText());
        double kembali = bayar - total;
        kembalianTF.setText(String.valueOf(kembali));
        if (kembali < 0) {
            JOptionPane.showMessageDialog(rootPane, "Uang Anda Kurang");
        } else {
            simpanTebusBT.setEnabled(true);
        }

    }//GEN-LAST:event_hitungTransaksiBTActionPerformed

    private void jatuhTempoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jatuhTempoPropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jatuhTempoPropertyChange

    private void simpanTebusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTebusBTActionPerformed
        // TODO add your handling code here:
        cT.updateTebus();
        tampilDataTebusan("");
        tampilDataTransaksi("");
    }//GEN-LAST:event_simpanTebusBTActionPerformed

    private void customerTFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTFMousePressed
        // TODO add your handling code here:
        vlc.tampilDataCustomer("");
        vlc.setVisible(true);
    }//GEN-LAST:event_customerTFMousePressed

    private void barangTFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangTFMousePressed
        // TODO add your handling code here:
        vlb.tampilDataBarang("");
        vlb.setVisible(true);
    }//GEN-LAST:event_barangTFMousePressed

    private void dataGadaiTFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataGadaiTFMousePressed
        // TODO add your handling code here:
        viewListDataGadai vlg= new viewListDataGadai(this);
        vlg.tampilDataGadai("");
        vlg.setVisible(true);
    }//GEN-LAST:event_dataGadaiTFMousePressed

    private void deleteTebusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTebusBTActionPerformed
        // TODO add your handling code here:
        cT.deleteTransaksiGadai();
        tampilDataTebusan("");
    }//GEN-LAST:event_deleteTebusBTActionPerformed

    private void perpanjangBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perpanjangBTActionPerformed
        // TODO add your handling code here:
        try {
                DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

                Date date2 = dateFormat.parse(String.valueOf(sdf.format(jatuhTempo.getDate())));
                Date date1 = dateFormat.parse(String.valueOf(sdf.format(tempo)));

                long selisih = date2.getTime() - date1.getTime();
                int telat = (int) TimeUnit.DAYS.convert(selisih, TimeUnit.MILLISECONDS);
                if (telat > 14) {
                    JOptionPane.showMessageDialog(rootPane, "Tanggal Perpanjang Tidak Lebih 14 Hari");
                } else {
                    bayarTF.setVisible(true);
                    kembalianTF.setVisible(true);
                    hitungPanjangBT.setVisible(true);
                    kembalianLB.setVisible(true);
                    dibayarLB.setVisible(true); 
                    double pinjaman = Double.valueOf(jumlahPinjamanTF.getText());
                    double bunga = (pinjaman * 10) / 100;
                    bungaLB.setText(String.valueOf(bunga));
                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_perpanjangBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barangTF;
    private javax.swing.JTextField bayarTF;
    private javax.swing.JLabel bungaLB;
    private javax.swing.JTextField cariTransaksiTF;
    private javax.swing.JTextField customerTF;
    private javax.swing.JTextField dataGadaiTF;
    private javax.swing.JButton deleteBT;
    private javax.swing.JButton deleteTebusBT;
    private javax.swing.JTextField dendaTF;
    private javax.swing.JButton detailBT;
    private javax.swing.JLabel dibayarLB;
    private javax.swing.JTextField hariTF;
    private javax.swing.JButton hitungBT;
    private javax.swing.JButton hitungHariBT;
    private javax.swing.JButton hitungPanjangBT;
    private javax.swing.JButton hitungTransaksiBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jatuhTempo;
    private javax.swing.JTextField jumlahPinjamanTF;
    private javax.swing.JTextField jumlahTebusanTF;
    private javax.swing.JLabel kembalianLB;
    private javax.swing.JTextField kembalianTF;
    private javax.swing.JButton perpanjangBT;
    private javax.swing.JButton simpanBT;
    private javax.swing.JButton simpanTebusBT;
    private javax.swing.JTable tabelTebusan;
    private javax.swing.JTable tabelTransaksi;
    private com.toedter.calendar.JDateChooser tanggalTebusan;
    private javax.swing.JTextField tglSekarangTF;
    private javax.swing.JLabel totalTebusan;
    private javax.swing.JComboBox<String> transaksiCB;
    // End of variables declaration//GEN-END:variables
}
