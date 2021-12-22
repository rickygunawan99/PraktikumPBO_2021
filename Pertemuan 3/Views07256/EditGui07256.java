package Views07256;

import Controller07256.SepatuController07256;
import Entites07256.SepatuEntity07256;

import javax.swing.*;
import java.awt.*;

public class EditGui07256 extends JFrame{
    private final String TITLE = "EDIT SEPATU";
    private SepatuEntity07256 tempSepatu;
    private final SepatuController07256 sepatu = new SepatuController07256();

    JLabel labeljudul = new JLabel("EDIT SEPATU");
    JLabel labelid = new JLabel("Id");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelstock = new JLabel("Stock");
    JLabel labelsize = new JLabel("Ukuran");
    JTextField fieldid = new JTextField();
    JTextField fieldnama = new JTextField();
    JTextField fieldstock = new JTextField();
    JTextField fieldsize = new JTextField();
    JButton btnexit = new JButton("Exit");
    JButton btnsave = new JButton("Save");

    public EditGui07256(final int id){
        initWindow();
        initComponent(id);
        initActionEvent(id);
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(250,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initComponent(final int id){

        labeljudul.setBounds(50,17,130,30);
        labeljudul.setFont(new Font("Arial",Font.BOLD,17));
        add(labeljudul);

        labelid.setBounds(10,70,55,20);
        add(labelid);
        labelnama.setBounds(10,110,55,20);
        add(labelnama);
        labelstock.setBounds(10,150,55,20);
        add(labelstock);
        labelsize.setBounds(10,190,55,20);
        add(labelsize);

        fieldid.setBounds(85,70,125,20);
        fieldid.setEditable(false);
        add(fieldid);
        fieldnama.setBounds(85,110,125,20);
        add(fieldnama);
        fieldstock.setBounds(85,150,125,20);
        add(fieldstock);
        fieldsize.setBounds(85,190,125,20);
        add(fieldsize);

        tempSepatu = sepatu.getSepatu07256(id);
        fieldid.setText(String.valueOf(tempSepatu.getId07256()));
        fieldnama.setText(tempSepatu.getNama07256());
        fieldstock.setText(String.valueOf(tempSepatu.getStock07256()));
        fieldsize.setText(String.valueOf(tempSepatu.getSize07256()));

        btnexit.setFocusPainted(false);
        btnexit.setBounds(35,230,55,25);
        add(btnexit);
        btnsave.setFocusPainted(false);
        btnsave.setBounds(115,230,65,25);
        add(btnsave);
        setVisible(true);
    }

    private void initActionEvent(final int id){
        btnexit.addActionListener(e -> {
            dispose();
        });

        btnsave.addActionListener(e -> {
            SepatuEntity07256 temp = new SepatuEntity07256(
                    Integer.parseInt(fieldid.getText()),
                    fieldnama.getText(),
                    Integer.parseInt(fieldstock.getText()),
                    Integer.parseInt(fieldsize.getText())
            );
            if(labelnama.getText().length()!=0 && labelstock.getText().length()!=0&&labelsize.getText().length()!=0){
                if(sepatu.updateSepatu07256(id, temp) > 0){
                    JOptionPane.showMessageDialog(null,"Edit berhasil");
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Field tidak boleh kosong");
            }
        });
    }
}
