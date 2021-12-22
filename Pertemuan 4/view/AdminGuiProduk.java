package view;

import controller.AdminController;
import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminGuiProduk extends CreatComp{
    private final AdminController admin = new AdminController();
    private final TransaksiController transaksi = new TransaksiController();

    private final String TITLE = "ADMIN GUI";

    JLabel labeljudul = new JLabel("Data Produk");
    JLabel labeltemp = new JLabel();
    JButton btnback = new JButton("<< Exit");
    JButton btnedit = new JButton("EDIT");
    JButton btndelete = new JButton("Delete");
    JButton btnlisttransaksi = new JButton("List Transaksi");
    JTable table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JScrollPane sp = new JScrollPane(table);
    JButton btnaddproduk = new JButton("(+) Produk");
    JButton btnrefresh = new JButton("Refresh");

    public AdminGuiProduk(final int id){
        initWindow();
        initComponent();
        initEvent(id);
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(500,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labeljudul.setFont(new Font("Arial",Font.BOLD,18));
        addComp(labeljudul,210,13,250,35);

        btnback.setBackground(Color.WHITE);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        addComp(btnback,2,2,70,20);

        btnedit.setBackground(Color.BLACK);
        btnedit.setForeground(Color.WHITE);
        btnedit.setFocusPainted(false);
        btnedit.setBorder(null);
        addComp(btnedit,9,60,70,20);

        btndelete.setBackground(Color.BLACK);
        btndelete.setForeground(Color.WHITE);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        addComp(btndelete,9,95,70,20);

        btnaddproduk.setFocusPainted(false);
        btnaddproduk.setBorder(null);
        btnaddproduk.setBackground(Color.RED);
        btnaddproduk.setForeground(Color.WHITE);
        addComp(btnaddproduk,9,130,70,20);

        btnlisttransaksi.setBackground(Color.BLACK);
        btnlisttransaksi.setForeground(Color.WHITE);
        btnlisttransaksi.setFocusPainted(false);
        btnlisttransaksi.setBorder(null);
        addComp(btnlisttransaksi,160,230,200,35);

        btnrefresh.setBackground(Color.WHITE);
        btnrefresh.setForeground(Color.GREEN);
        btnrefresh.setFocusPainted(false);
        btnrefresh.setBorder(null);
        addComp(btnrefresh,370,37,70,20);

        table.setModel(transaksi.getTableProduk());
        addComp(sp,107,68,350,150);
    }

    private void initEvent(final int id){
        btnlisttransaksi.addActionListener(e -> {
            new AdminGuiTransaksi(id).setVisible(true);
            dispose();
        });

        btnback.addActionListener(e -> {
            new HomeGui().setVisible(true);
            dispose();
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                labeltemp.setText(table.getValueAt(row,0).toString());
            }
        });

        btnaddproduk.addActionListener(e -> {
            new TambahProdukGui().setVisible(true);
        });

        btnrefresh.addActionListener(e -> {
            table.setModel(transaksi.getTableProduk());
        });

        btndelete.addActionListener(e -> {
            int row = Integer.parseInt(labeltemp.getText());
            if(transaksi.deleteProduk(row) > 0){
                JOptionPane.showMessageDialog(null,"Berhasil delete produk");
                table.setModel(transaksi.getTableProduk());
            }else{
                JOptionPane.showMessageDialog(null,"Gagal delete produk");
            }
        });

        btnedit.addActionListener(e -> {
            int row = Integer.parseInt(labeltemp.getText());
            new EditProdukGui(row).setVisible(true);
        });
    }
}
