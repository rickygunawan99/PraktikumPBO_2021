package view;

import controller.TransaksiController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PilihVoucher extends CreatComp{
    private final TransaksiController transaksi = new TransaksiController();
    private final String TITLE = "PILIH VOUCHER";
    private final String TNR = "Times new roman";
    JLabel labeljudul = new JLabel("TOP UP VOUCHER GAME");
    JLabel labeltemp = new JLabel();
    JButton btnpilih = new JButton("PILIH");
    JButton btnback = new JButton("<< Exit");

    JTable tabel = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    JScrollPane scrollPane = new JScrollPane(tabel);


    public PilihVoucher(){
        initWindow();
        initComponent();
        mouseListener();
        eventListener();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(540,420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){
        labeljudul.setFont(new Font(TNR,Font.BOLD,17));
        addComp(labeljudul,165,25,222,33);

        tabel.setModel(transaksi.getTableProduk());
        tabel.setFont(new Font(TNR,Font.PLAIN,14));
        tabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addComp(scrollPane,30,75,465,250);

        btnpilih.setFont(new Font("Consolas",Font.BOLD,14));
        btnpilih.setFocusPainted(false);
        addComp(btnpilih,30,330,465,30);

        btnback.setFont(new Font("Consolas",Font.PLAIN,15));
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        btnback.setBackground(Color.WHITE);
        addComp(btnback,0,5,70,30);
    }

    private void mouseListener(){
        btnpilih.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnpilih.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnpilih.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnpilih.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnpilih.setForeground(Color.BLACK);
            }
        });

        btnback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnback.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnback.setForeground(Color.BLACK);
            }
        });
    }

    private void eventListener(){

        btnback.addActionListener(e -> {
            new HomeGui().setVisible(true);
            dispose();
        });

        btnpilih.addActionListener(e -> {
            int row = tabel.getSelectedRow();
            labeltemp.setText(tabel.getValueAt(row,0).toString());
            new BeliVoucher(Integer.parseInt(labeltemp.getText())).setVisible(true);
            dispose();
        });
    }
}
