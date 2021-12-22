package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class HomeGui extends CreatComp{
    private final String TNR = "Times New Roman";
    private final String TITLE = "Home";

    JLabel labeljudul = new JLabel("TOP UP APPLICATION");
    JButton btnbeli = new JButton("BELI VOUCHER");
    JButton btncek = new JButton("CEK PEMESANAN");
    JLabel supportby = new JLabel("Supported by");
    JButton supporticon = new JButton();

    public HomeGui(){
        initWindow();
        initComponent();
        initMouseAction();
        initActionEvent();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(320,310);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void initComponent(){
        labeljudul.setFont(new Font(TNR, Font.BOLD,17));
        addComp(labeljudul,60,20,200,35);

        btnbeli.setFont(new Font(TNR,Font.PLAIN,20));
        btnbeli.setBackground(Color.WHITE);
        btnbeli.setForeground(Color.BLACK);
        btnbeli.setFocusPainted(false);
        addComp(btnbeli,60,70,182,63);

        btncek.setFont(new Font(TNR,Font.PLAIN,17));
        btncek.setBackground(Color.WHITE);
        btncek.setForeground(Color.BLACK);
        btncek.setFocusPainted(false);
        addComp(btncek,60,150,182,63);

        supportby.setFont(new Font("Consolas",Font.PLAIN,8));
        addComp(supportby,185,240,65,21);
        supporticon.setBounds(233,233,50,30);
        supporticon.setIcon(new ImageIcon(getImage()));
        supporticon.setBorder(null);
        supporticon.setFocusPainted(false);
        add(supporticon);
    }

    void initMouseAction(){
        btnbeli.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnbeli.setBackground(Color.CYAN);
                btnbeli.setForeground(Color.BLUE);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnbeli.setBackground(Color.WHITE);
                btnbeli.setForeground(Color.BLACK);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        btncek.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                btncek.setBackground(Color.CYAN);
                btncek.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btncek.setBackground(Color.WHITE);
                btncek.setForeground(Color.BLACK);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        supporticon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

    }

    private void initActionEvent(){
        supporticon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginAdminGui().setVisible(true);
                dispose();
            }
        });

        btnbeli.addActionListener(e -> {
            new PilihVoucher().setVisible(true);
            dispose();
        });

        btncek.addActionListener(e -> {
            new CekPesananGui().setVisible(true);
            dispose();
        });
    }

    private Image getImage(){
        String path = "src/Images/supicon.jpg";
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(path));
        }catch (Exception e){
            e.printStackTrace();
        }
        Image resize = bufferedImage.getScaledInstance(50,30,Image.SCALE_SMOOTH);
        return resize;
    }

}
