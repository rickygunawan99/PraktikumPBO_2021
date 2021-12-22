package view;

import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;

public class BeliVoucher extends CreatComp{
    private final TransaksiController transaksi = new TransaksiController();
    private final String TITLE = "Beli Voucher";
    private ProdukEntity produk;

    JLabel labelvoucher = new JLabel("Voucher");
    JTextField fieldvoucher = new JTextField();

    JLabel labelnominal = new JLabel("Jumlah");
    JTextField fieldnominal = new JTextField();

    JLabel labelharga = new JLabel("Harga");
    JTextField fieldharga = new JTextField();

    JLabel labelnama = new JLabel("Nama");
    JTextField fieldnama = new JTextField();

    JLabel labelnotelp = new JLabel("No Telp");
    JTextField fieldnotelp = new JTextField();

    JLabel labelidakun = new JLabel("Id akun");
    JTextField fieldidakun = new JTextField();

    JLabel labelnamaakun = new JLabel("Nama akun");
    JTextField fieldnamaakun = new JTextField();

    JLabel labelbayar = new JLabel("Bayar");
    JTextField fieldbayar = new JTextField();

    JLabel labeljumlah = new JLabel("Jumlah Beli");
    JTextField fieldjumlah = new JTextField();

    JButton btnok = new JButton("OK");
    JButton btnback = new JButton("Back");
    JButton btninc = new JButton("+");
    JButton btndec = new JButton("-");


    public BeliVoucher(final int id){
        initWindow();
        initComponent(id);
        initActionEvent(id);
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

    private void initComponent(final int id){
        addComp(labelvoucher,10,35,65,25);
        addComp(labelnominal,10,70,65,25);
        addComp(labelharga,10,105,65,25);
        addComp(labelnama,10,140,65,25);
        addComp(labelnotelp,10,175,65,25);
        addComp(labelidakun,10,210,65,25);
        addComp(labelnamaakun,10,245,65,25);
        addComp(labelbayar,10,280,65,25);
        addComp(labeljumlah,10,315,75,25);

        addComp(fieldvoucher,155,35,110,25);
        addComp(fieldnominal,155,70,110,25);
        addComp(fieldharga,155,105,110,25);
        addComp(fieldnama,155,140,110,25);
        addComp(fieldnotelp,155,175,110,25);
        addComp(fieldidakun,155,210,110,25);
        addComp(fieldnamaakun,155,245,110,25);
        addComp(fieldbayar,155,280,110,25);
        addComp(fieldjumlah,155,315,35,25);

        fieldvoucher.setEditable(false);
        fieldnominal.setEditable(false);
        fieldharga.setEditable(false);
        fieldjumlah.setEditable(false);
        ;
        btnok.setBackground(Color.WHITE);
        addComp(btnok,130,380,70,25);
        btnback.setBackground(Color.WHITE);
        addComp(btnback,45,380,70,25);

        btninc.setBackground(Color.WHITE);
        btninc.setBackground(Color.BLACK);
        btninc.setForeground(Color.WHITE);
        btninc.setFocusPainted(false);
        btninc.setBorder(null);
        addComp(btninc,195,315,25,25);

        btndec.setBackground(Color.WHITE);
        btndec.setBackground(Color.BLACK);
        btndec.setForeground(Color.WHITE);
        btndec.setFocusPainted(false);
        btndec.setBorder(null);
        addComp(btndec,230,315,25,25);

        produk = transaksi.getProduk(id);
        fieldvoucher.setText(produk.getNama_produk());
        fieldnominal.setText(produk.getNominal());
        fieldharga.setText(produk.getHarga_produk());
        fieldjumlah.setText("1");
    }

    private void initActionEvent(final int id){
        btnback.addActionListener(e -> {
            dispose();
            new PilihVoucher().setVisible(true);
        });

        btninc.addActionListener(e -> {
            int ctr = Integer.parseInt(fieldjumlah.getText())+1;
            int harga = Integer.parseInt(produk.getHarga_produk()) * ctr;
            fieldjumlah.setText(String.valueOf(ctr));
            fieldharga.setText(String.valueOf(harga));
        });

        btndec.addActionListener(e -> {
            int ctr = Integer.parseInt(fieldjumlah.getText())-1;
            int harga = Integer.parseInt(produk.getHarga_produk()) * ctr;
            fieldjumlah.setText(String.valueOf(ctr));
            fieldharga.setText(String.valueOf(harga));
        });

        btnok.addActionListener(e -> {
            if(fieldidakun.getText().length()!=0){
                int balance = Integer.parseInt(fieldbayar.getText()) - Integer.parseInt(fieldharga.getText());
                if(balance >= 0){
                    int cek = transaksi.insertTransaksi(0,
                    new PembeliEntity(fieldnama.getText(),fieldidakun.getText(),fieldnamaakun.getText(),fieldnotelp.getText()),
                    new ProdukEntity(fieldnominal.getText(),fieldvoucher.getText(), fieldharga.getText(),0),0,
                            String.valueOf(fieldbayar.getText()),Integer.parseInt(fieldjumlah.getText()));
                    if(cek > 0)
                        JOptionPane.showMessageDialog(null,
                                "Transaksi berhasil, id transaksi : " + transaksi.getIdTransaksi());
                    dispose();
                    new HomeGui().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Gagal transaksi");
                }
            }else
                JOptionPane.showMessageDialog(null,"ID Akun tidak ditemukan");
        });
    }
}

