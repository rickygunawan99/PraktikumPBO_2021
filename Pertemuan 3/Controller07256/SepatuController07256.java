package Controller07256;

import Entites07256.SepatuEntity07256;
import Model07256.SepatuModel07256;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class SepatuController07256 extends Controller {

    public ArrayList<SepatuEntity07256> getSepatu07256(){
        return Objects.requireNonNull(model(SepatuModel07256.class)).getSepatu07256();
    }

    public SepatuEntity07256 getSepatu07256(int id){
        return Objects.requireNonNull(model(SepatuModel07256.class)).getSepatu07256(id);
    }

    public int createSepatu07256(SepatuEntity07256 sepatu){
        return Objects.requireNonNull(model(SepatuModel07256.class)).createSepatu07256(sepatu);
    }

    public int updateSepatu07256(int id, SepatuEntity07256 sepatu){
        return Objects.requireNonNull(model(SepatuModel07256.class)).updateSepatu07256(id,sepatu);
    }

    public int deleteSepatu07256(int id){
        return Objects.requireNonNull(model(SepatuModel07256.class)).deleteSepatu07256(id);
    }

    public DefaultTableModel getSepatuTable07256(){
        DefaultTableModel table = new DefaultTableModel();
        Object[] column = {"Id","Nama","Stock","Size"};
        table.setColumnIdentifiers(column);

        getSepatu07256().forEach(sepatu -> {
            Object[] row = new Object[4];
            row[0] = sepatu.getId07256();
            row[1] = sepatu.getNama07256();
            row[2] = sepatu.getStock07256();
            row[3] = sepatu.getSize07256();
            table.addRow(row);
        });
        return table;
    }

}
