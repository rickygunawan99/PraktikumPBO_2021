package view;

import controller.AdminController;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;

public class AdminGuiTransaksi extends CreatComp{
    private final AdminController admin = new AdminController();
    private final TransaksiController transaksi = new TransaksiController();

    private final String TITLE = "ADMIN GUI";

    JLabel labeljudul = new JLabel("Data Transaksi");
    JButton btnback = new JButton("<< Exit");
    JButton btnaddadmin = new JButton("Reg Admin");
    JButton btndelete = new JButton("Delete");
    JButton btnproses = new JButton("Proses");
    JButton btnlistproduk = new JButton("List Produk");
    JTable table = new JTable();
    JScrollPane sp = new JScrollPane(table);
    JButton btneditprofil = new JButton("Edit Profile");
    JLabel labeltemp = new JLabel();

    public AdminGuiTransaksi(final int id){
        initWindow();
        initComponent();
        initEvent(id);
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(685,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labeljudul.setFont(new Font("Arial",Font.BOLD,18));
        addComp(labeljudul,255,13,250,35);

        btnback.setBackground(Color.WHITE);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        addComp(btnback,2,2,70,20);

        btndelete.setBackground(Color.BLACK);
        btndelete.setForeground(Color.WHITE);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        addComp(btndelete,9,70,70,20);

        btnproses.setBackground(Color.BLACK);
        btnproses.setForeground(Color.WHITE);
        btnproses.setFocusPainted(false);
        btnproses.setBorder(null);
        addComp(btnproses,9,100,70,20);

        btneditprofil.setBackground(Color.BLACK);
        btneditprofil.setForeground(Color.WHITE);
        btneditprofil.setFocusPainted(false);
        btneditprofil.setBorder(null);
        addComp(btneditprofil,9,131,70,20);

        btnaddadmin.setBackground(Color.BLACK);
        btnaddadmin.setForeground(Color.WHITE);
        btnaddadmin.setFocusPainted(false);
        btnaddadmin.setBorder(null);
        addComp(btnaddadmin,9,160,70,20);

        btnlistproduk.setBackground(Color.BLACK);
        btnlistproduk.setForeground(Color.WHITE);
        btnlistproduk.setFocusPainted(false);
        btnlistproduk.setBorder(null);
        addComp(btnlistproduk,230,225,200,35);

        table.setModel(transaksi.getTransactionTable());
        addComp(sp,107,68,545,150);
    }

    private void initEvent(final int id){
        btnlistproduk.addActionListener(e -> {
            dispose();
            new AdminGuiProduk(id).setVisible(true);
        });

        btnback.addActionListener(e -> {
            dispose();
            new HomeGui().setVisible(true);
        });

        btndelete.addActionListener(e -> {
            int row = Integer.parseInt(labeltemp.getText());
            if(transaksi.deleteTransaksi(row) > 0){
                JOptionPane.showMessageDialog(null, "Berhasil delete");
                table.setModel(transaksi.getTransactionTable());
            }
        });

        btnproses.addActionListener(e -> {
            int row = table.getSelectedRow();
            labeltemp.setText(table.getValueAt(row,0).toString());
            if(admin.updateStatusTransaksi(Integer.parseInt(labeltemp.getText())) > 0) {
                JOptionPane.showMessageDialog(null,"Update berhasil");
                table.setModel(transaksi.getTransactionTable());
            }
        });

        btneditprofil.addActionListener(e -> {
            new ProfilAdminGui(id).setVisible(true);
        });

        btnaddadmin.addActionListener(e -> {
            new RegisAdminGui().setVisible(true);
        });
    }
}
