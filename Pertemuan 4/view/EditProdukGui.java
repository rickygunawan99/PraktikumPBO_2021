package view;

import Entity.ProdukEntity;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;

public class EditProdukGui extends CreatComp{
    private final TransaksiController transaksi = new TransaksiController();
    private final String TITLE = "EDIT PRODUK";
    JLabel labelnama = new JLabel("Nama Produk");
    JLabel labelnominal = new JLabel("Jumlah");
    JLabel labelharga = new JLabel("Harga");
    JTextField fieldnama = new JTextField();
    JTextField fieldnominal = new JTextField();
    JTextField fieldharga = new JTextField();
    JButton btnreset = new JButton("Reset");
    JButton btncancel = new JButton("Cancel");
    JButton btnsave = new JButton("Save");

    private ProdukEntity produk;

    public EditProdukGui(final int id){
        initWindow();
        initComponent(id);
        initActionEvent(id);
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(245,310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(final int id){
        addComp(labelnama, 14,57,80,20);
        addComp(labelnominal,14,86,70,20);
        addComp(labelharga, 14,115,69,19);

        fieldnama.setEditable(false);
        addComp(fieldnama,108,57,108,20);
        addComp(fieldnominal,108,86,108,20);
        addComp(fieldharga,108,115,108,20);

        btncancel.setFont(new Font("Arial",Font.PLAIN,11));
        btncancel.setFocusPainted(false);
        btncancel.setBackground(Color.WHITE);
        addComp(btncancel,38,158,70,30);

        btnreset.setFont(new Font("Arial",Font.PLAIN,13));
        btnreset.setFocusPainted(false);
        btnreset.setBackground(Color.WHITE);
        addComp(btnreset,125,158,70,30);

        btnsave.setFont(new Font("Arial",Font.PLAIN,13));
        btnsave.setFocusPainted(false);
        btnsave.setBackground(Color.WHITE);
        addComp(btnsave,81,205,70,30);


        produk = transaksi.getProduk(id);
        fieldnama.setText(produk.getNama_produk());
        fieldnominal.setText(produk.getNominal());
        fieldharga.setText(produk.getHarga_produk());
    }

    private void initActionEvent(final int id){
        btncancel.addActionListener(e -> {
            dispose();
        });

        btnreset.addActionListener(e -> {
            fieldnama.setText(produk.getNama_produk());
            fieldnominal.setText(produk.getNominal());
            fieldharga.setText(produk.getHarga_produk());
        });

        btnsave.addActionListener(e -> {
            ProdukEntity tempProduk = new ProdukEntity(fieldnominal.getText(),fieldnama.getText(),
                    fieldharga.getText(),0);
            if(transaksi.updateProduk(id,tempProduk) > 0 ){
                JOptionPane.showMessageDialog(null,"Berhasil update");
                dispose();
            }
        });
    }
}
