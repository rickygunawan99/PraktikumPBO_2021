package view;

import controller.AdminController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoginAdminGui extends CreatComp {
    private final AdminController admin = new AdminController();

    private final String TITLE = "LOGIN ADMIN";

    JLabel labelid = new JLabel("Id");
    JLabel labelpass = new JLabel("Password");
    JTextField fieldid = new JTextField();
    JTextField fieldpass = new JTextField();
    JLabel gambaricon = new JLabel();
    JButton btnlogin = new JButton("Login");
    JButton btnexit = new JButton("Exit");

    public LoginAdminGui(){
        initWindow();
        initComponent();
        initActionEvent();
        initMouseAction();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(270,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(){
        labelid.setFont(new Font("Arial",Font.PLAIN,12));
        addComp(labelid, 18,110,60,20);
        labelpass.setFont(new Font("Arial",Font.PLAIN,12));
        addComp(labelpass,18,140,60,20);

        addComp(fieldid,110,110,135,20);
        addComp(fieldpass,110,140,135,21);

        String path = "src/Images/supicon.jpg";
        BufferedImage bf;

        btnlogin.setBackground(Color.WHITE);
        btnlogin.setForeground(Color.BLACK);
        btnlogin.setFocusPainted(false);
        addComp(btnlogin, 130,170,70,30);

        btnexit.setBackground(Color.WHITE);
        btnexit.setForeground(Color.BLACK);
        btnexit.setFocusPainted(false);
        addComp(btnexit, 50,170,70,30);

        addComp(gambaricon,40,5,180,120);
        try {
            bf = ImageIO.read(new File(path));
            Image gambar = bf.getScaledInstance(180,120,Image.SCALE_SMOOTH);
            gambaricon.setIcon(new ImageIcon(gambar));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initActionEvent(){
        btnexit.addActionListener(e -> {
            new HomeGui().setVisible(true);
            dispose();
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = fieldid.getText();
                String pass = fieldpass.getText();

                if (id.length() != 0 && pass.length() != 0) {
                    int cek = admin.login(id,pass);
                    if(cek != 0){
                        JOptionPane.showMessageDialog(null, "Berhasil Login");
                        new AdminGuiTransaksi(cek).setVisible(true);
                        dispose();
                    }
                    else{
                        fieldid.setText(null);
                        fieldpass.setText(null);
                        JOptionPane.showMessageDialog(null,"Login gagal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Field tidak boleh kosong");
                }
            }
        });
    }

    private void initMouseAction(){
        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.BLUE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.BLACK);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
