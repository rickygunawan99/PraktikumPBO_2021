package Views07256;
import Controller07256.SepatuController07256;
import Entites07256.SepatuEntity07256;
import javax.swing.*;
import java.awt.*;

public class RegisterGui07256 extends JFrame {
    private final SepatuController07256 sepatu = new SepatuController07256();

    JLabel labeljudul = new JLabel("INSERT SEPATU");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelstock = new JLabel("Stock");
    JLabel labelsize = new JLabel("Ukuran");
    JTextField fieldnama = new JTextField();
    JTextField fieldstock = new JTextField();
    JTextField fieldsize = new JTextField();
    JButton btnexit = new JButton("Exit");
    JButton btnsave = new JButton("Tambah");

    public RegisterGui07256(){
        initWindow();
        initComponent();
        initActionEvent();
    }

    private void initWindow(){
        setTitle("INSERT SEPATU");
        setSize(250,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(){

        labeljudul.setBounds(50,17,150,40);
        labeljudul.setFont(new Font("Arial",Font.BOLD,17));
        add(labeljudul);

        labelnama.setBounds(10,110,55,20);
        add(labelnama);
        labelstock.setBounds(10,150,55,20);
        add(labelstock);
        labelsize.setBounds(10,190,55,20);
        add(labelsize);

        fieldnama.setBounds(85,110,125,20);
        add(fieldnama);
        fieldstock.setBounds(85,150,125,20);
        add(fieldstock);
        fieldsize.setBounds(85,190,125,20);
        add(fieldsize);

        btnexit.setFocusPainted(false);
        btnexit.setBounds(35,230,55,25);
        add(btnexit);
        btnsave.setFocusPainted(false);
        btnsave.setBounds(115,230,85,25);
        add(btnsave);
    }

    private void initActionEvent(){
        btnexit.addActionListener(e -> {
            dispose();
        });

        btnsave.addActionListener(e -> {
            SepatuEntity07256 newSepatu = new SepatuEntity07256(
                    0,
                    fieldnama.getText(),
                    Integer.parseInt(fieldstock.getText()),
                    Integer.parseInt(fieldsize.getText())
            );
            if(labelnama.getText().length()!=0 && labelstock.getText().length()!=0&&labelsize.getText().length()!=0){
                if(sepatu.createSepatu07256(newSepatu) > 0){
                    JOptionPane.showMessageDialog(null,"Insert berhasil");
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Field tidak boleh kosong");
            }
        });
    }
}
