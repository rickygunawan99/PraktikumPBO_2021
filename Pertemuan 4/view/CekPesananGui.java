package view;

import Entity.TransaksiEntity;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CekPesananGui extends CreatComp{
    TransaksiController transaksi = new TransaksiController();
    private final String TITLE = "CEK PESANAN";

    JLabel labeljudul = new JLabel("CEK PEMESANAN");
    JLabel labelid = new JLabel("Id Pemesanan");
    JTextField fieldid = new JTextField();
    JButton btncari = new JButton("Cari");

    JLabel labelnama = new JLabel("Nama");
    JTextField fieldnama = new JTextField();

    JLabel labelnotelp = new JLabel("No Telp");
    JTextField fieldnotelp = new JTextField();

    JLabel labelvoucher = new JLabel("Voucher");
    JTextField fieldvoucher = new JTextField();

    JLabel labelnominal = new JLabel("Jumlah");
    JTextField fieldnominal = new JTextField();

    JLabel labelharga = new JLabel("Harga");
    JTextField fieldharga = new JTextField();

    JLabel labelidakun = new JLabel("Id akun");
    JTextField fieldidakun = new JTextField();

    JLabel labelnamaakun = new JLabel("Nama akun");
    JTextField fieldnamaakun = new JTextField();

    JLabel labelstatus = new JLabel("Status Transaksi");
    JTextField fieldstatus = new JTextField();

    JButton exitbtn = new JButton("Exit");

    public CekPesananGui(){
        initWindow();
        initComponent();
        actionEvent();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(310,470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(){
        labeljudul.setFont(new Font("Times New Roman",Font.BOLD,18));
        addComp(labeljudul,70,10,200,40);

        labelid.setFont(new Font("Segoe Ui",Font.PLAIN,12));
        addComp(labelid,12,58,105,20);

        addComp(fieldid,12,87,205,25);

        btncari.setFont(new Font("Arial",Font.PLAIN,12));
        btncari.setFocusPainted(false);
        addComp(btncari,230,87,60,25);


        addComp(labelnama,12,130,60,20);
        addComp(labelnotelp,12,160,60,20);
        addComp(labelvoucher,12,190,60,20);
        addComp(labelnominal,12,220,60,20);
        addComp(labelharga,12,250,60,20);
        addComp(labelidakun,12,280,60,20);
        addComp(labelnamaakun,12,310,90,20);
        addComp(labelstatus,12,340,120,20);

        fieldnama.setEditable(false);
        fieldnotelp.setEditable(false);
        fieldvoucher.setEditable(false);
        fieldnominal.setEditable(false);
        fieldharga.setEditable(false);
        fieldidakun.setEditable(false);
        fieldnamaakun.setEditable(false);
        fieldstatus.setEditable(false);

        addComp(fieldnama,115,130,150,20);
        addComp(fieldnotelp,115,160,150,20);
        addComp(fieldvoucher,115,190,150,20);
        addComp(fieldnominal,115,220,150,20);
        addComp(fieldharga,115,250,150,20);
        addComp(fieldidakun,115,280,150,20);
        addComp(fieldnamaakun,115,310,150,20);
        addComp(fieldstatus,115,340,150,20);

        exitbtn.setBackground(Color.WHITE);
        exitbtn.setForeground(Color.BLACK);
        exitbtn.setFocusPainted(false);
        addComp(exitbtn,105,380,70,30);
    }

    private void actionEvent(){

        btncari.addActionListener(e -> {
            if(fieldid.getText().length()!=0){
                int id = Integer.parseInt(fieldid.getText());

                TransaksiEntity tr = transaksi.getTransaksi(id);

                if(tr!=null){
                    initPemesanan(tr);
                }else{
                    JOptionPane.showMessageDialog(null,"Id tidak ditemukan");
                    clear();
                }
            }
        });

        exitbtn.addActionListener(e -> {
            new HomeGui().setVisible(true);
            dispose();
        });
    }

    private void initPemesanan(TransaksiEntity t){

        fieldnama.setText(t.getPembeli().getNama());
        fieldnotelp.setText(t.getPembeli().getNotelp());
        fieldvoucher.setText(t.getProduk().getNama_produk());
        fieldnominal.setText(t.getProduk().getNominal());
        fieldharga.setText(t.getProduk().getHarga_produk());
        fieldidakun.setText(t.getPembeli().getId_game());
        fieldnamaakun.setText(t.getPembeli().getNama_akun());
        if(t.getStatus_transaksi() != 0)
            fieldstatus.setText("Sudah Diproses");
        else
            fieldstatus.setText("Belum diproses");
    }

    private void clear(){
        fieldnama.setText(null);
        fieldnotelp.setText(null);
        fieldvoucher.setText(null);
        fieldnominal.setText(null);
        fieldharga.setText(null);
        fieldidakun.setText(null);
        fieldnamaakun.setText(null);
        fieldstatus.setText(null);
    }

}
