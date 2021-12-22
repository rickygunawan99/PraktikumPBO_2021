package Views07256;

import Controller07256.SepatuController07256;

import javax.swing.*;
import java.awt.*;

public class TableSepatuGui07256 extends JFrame{
    private final SepatuController07256 sepatu = new SepatuController07256();
    private final String TITLE= "GUDANG SEPATU";
    JLabel labeltitle = new JLabel("GUDANG SEPAT`U");
    JTable table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JScrollPane sp = new JScrollPane(table);
    JButton btncreate = new JButton("INSERT");
    JButton btnedit = new JButton("EDIT");
    JButton btndelete = new JButton("DELETE");
    JLabel temp = new JLabel();
    JButton btnrefresh = new JButton("Reresh");

    public TableSepatuGui07256(){
        initWindow();
        initComponent();
        initActionEvent();
    }

    private void initWindow(){
        setTitle(TITLE);
        setSize(470,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void initComponent(){
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        labeltitle.setFont(new Font("Arial",Font.BOLD,18));
        northPanel.add(labeltitle);
        add(northPanel,BorderLayout.NORTH);


        table.setModel(sepatu.getSepatuTable07256());
        add(sp, BorderLayout.CENTER);

        btncreate.setFocusPainted(false);
        btnedit.setFocusPainted(false);
        btndelete.setFocusPainted(false);
        btnrefresh.setFocusPainted(false);

        southPanel.add(btncreate);
        southPanel.add(btnedit);
        southPanel.add(btndelete);
        southPanel.add(btnrefresh);

        add(southPanel,BorderLayout.SOUTH);
    }

    private void initActionEvent(){
        btndelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            temp.setText(table.getValueAt(row,0).toString());
            if(sepatu.deleteSepatu07256(Integer.parseInt(temp.getText())) > 0){
                JOptionPane.showMessageDialog(null,"DELETE BERHASIL");
                table.setModel(sepatu.getSepatuTable07256());
            }else{
                JOptionPane.showMessageDialog(null,"DELETE GAGAL");
            }
        });

        btnedit.addActionListener(e -> {
            try {
                int row = table.getSelectedRow();
                temp.setText(table.getValueAt(row,0).toString());
                new EditGui07256(Integer.parseInt(temp.getText())).setVisible(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        btncreate.addActionListener(e -> {
            new RegisterGui07256().setVisible(true);
            //action
        });

        btnrefresh.addActionListener(e -> {
            table.setModel(sepatu.getSepatuTable07256());
        });
    }
}
