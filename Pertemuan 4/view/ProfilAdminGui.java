package view;

import Entity.AdminEntity;
import controller.AdminController;

import javax.swing.*;
import java.awt.*;

public class ProfilAdminGui extends CreatComp {
    private final AdminController adminCtr = new AdminController();
    private final String TITLE  = "Profil Admin";
    private AdminEntity admin;

    JLabel labeljudul = new JLabel("PROFIL");
    JLabel labelid = new JLabel("Id");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelnotelp = new JLabel("No Telp");
    JLabel labelpass = new JLabel("Password");
    JTextField fieldid = new JTextField();
    JTextField fieldnama = new JTextField();
    JTextField fieldnotelp = new JTextField();
    JTextField fieldpass = new JTextField();
    JButton btncancel = new JButton("Exit");
    JButton btnsave = new JButton("Simpan");

    public ProfilAdminGui(final int id){
        initWindow();
        initComponent(id);
        initActionEvent(id);
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

    private void initComponent(final int id){
        labeljudul.setFont(new Font("Arial",Font.BOLD,17));
        addComp(labeljudul,5,20,100,30);
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

        admin = adminCtr.getAdmin(id);
        fieldid.setText(admin.getId());
        fieldid.setEditable(false);
        fieldnama.setText(admin.getNama());
        fieldnotelp.setText(admin.getNotelp());
        fieldpass.setText(admin.getPassword());
    }

    private void initActionEvent(final int id){
        btncancel.addActionListener(e -> {
            dispose();
        });

        btnsave.addActionListener(e -> {
            AdminEntity newAdmin = new AdminEntity(fieldnama.getText(),fieldid.getText(),
                    fieldpass.getText(),fieldnotelp.getText());
            if(adminCtr.updateProfil(id,newAdmin) > 0){
                JOptionPane.showMessageDialog(null,"Berhasil edit profil");
                dispose();
            }
        });
    }
}
