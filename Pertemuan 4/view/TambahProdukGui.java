package view;

import Entity.ProdukEntity;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;

public class TambahProdukGui extends CreatComp{
    private final TransaksiController transaksi = new TransaksiController();
    private final String TITLE = "Tambah Produk";

    JLabel judul = new JLabel("Tambah barang");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelnominal = new JLabel("Nominal");
    JLabel labelharga = new JLabel("Harga");
    JTextField fieldnama = new JTextField();
    JTextField fieldnominal = new JTextField();
    JTextField fieldharga = new JTextField();
    JButton btncancel = new JButton("Cancel");
    JButton btnok = new JButton("Simpan");


    public TambahProdukGui(){
        initWindow();
        initComponenet();
        initAction();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(285,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponenet(){
        judul.setFont(new Font("Arial",Font.BOLD,17));
        addComp(judul,70,13,180,40);
        addComp(labelnama,13,60,80,25);
        addComp(labelnominal,13,110,80,25);
        addComp(labelharga,13,160,80,25);
        addComp(fieldnama,97,60,150,25);
        addComp(fieldnominal,97,110,150,25);
        addComp(fieldharga,97,160,150,25);

        btncancel.setBackground(Color.WHITE);
        addComp(btncancel,40,220,80,25);
        btnok.setBackground(Color.WHITE);
        addComp(btnok,140,220,80,25);
    }

    private void initAction(){
        btncancel.addActionListener(e -> {
            dispose();
        });

        btnok.addActionListener(e -> {
            if (fieldnama.getText().length() != 0 && fieldnominal.getText().length() != 0 &&
                    fieldharga.getText().length() != 0) {
                ProdukEntity produk = new ProdukEntity(fieldnominal.getText(),fieldnama.getText(),
                        fieldharga.getText(),0);
                if(transaksi.insertProduk(produk)>0){
                    JOptionPane.showMessageDialog(null,"Berhasil tambah produk");
                    dispose();

                }else{
                    JOptionPane.showMessageDialog(null,"Gagal tambah produk");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Data tidak boleh kosong");
                clearField();
            }
        });
    }

    private void clearField(){
        fieldharga.setText(null);
        fieldnominal.setText(null);
        fieldnama.setText(null);
    }
}
