package view;

import Entity.AdminEntity;
import controller.AdminController;

import javax.swing.*;
import java.awt.*;

public class RegisAdminGui extends CreatComp{
    private final AdminController adminCtr = new AdminController();
    private final String TITLE  = "Register Admin";

    JLabel labeljudul = new JLabel("REGISTER ADMIN");
    JLabel labelid = new JLabel("Id");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelnotelp = new JLabel("No Telp");
    JLabel labelpass = new JLabel("Password");
    JTextField fieldid = new JTextField();
    JTextField fieldnama = new JTextField();
    JTextField fieldnotelp = new JTextField();
    JTextField fieldpass = new JTextField();
    JButton btncancel = new JButton("Exit");
    JButton btnsave = new JButton("Regis");

    public RegisAdminGui(){
        initWindow();
        initComponent();
        initActionEvent();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(250,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(){
        labeljudul.setFont(new Font("Arial",Font.BOLD,17));
        addComp(labeljudul,5,20,150,30);
        addComp(labelid,5,80,60,25);
        addComp(labelnama,5,115,60,25);
        addComp(labelnotelp,5,150,60,25);
        addComp(labelpass,5,185,60,25);

        addComp(fieldid,75,80,140,25);
        addComp(fieldnama,75,115,140,25);
        addComp(fieldnotelp,75,150,140,25);
        addComp(fieldpass,75,185,140,25);

        btncancel.setBackground(Color.WHITE);
        addComp(btncancel,27,235,60,25);

        btnsave.setBackground(Color.WHITE);
        addComp(btnsave,110,235,80,25);

    }

    private void initActionEvent(){
        btncancel.addActionListener(e -> {
            dispose();
        });

        btnsave.addActionListener(e -> {
            if(fieldnama.getText().length()!=0 && fieldpass.getText().length()!=0){
                 AdminEntity newAdmin = new AdminEntity(fieldnama.getText(),fieldid.getText(),
                    fieldpass.getText(),fieldnotelp.getText());
                if(adminCtr.insertAdmin(newAdmin) > 0){
                    JOptionPane.showMessageDialog(null, "Berhasil tambah admin");
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Id telah terdaftar");
                }
            }
        });
    }
}
