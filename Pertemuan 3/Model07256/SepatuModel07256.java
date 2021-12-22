package Model07256;

import Entites07256.SepatuEntity07256;
import java.sql.SQLException;
import java.util.ArrayList;

public class SepatuModel07256 extends ModelAbstract07256 {

    public SepatuModel07256(){
        connect();
    }

    public int createSepatu07256(SepatuEntity07256 sepatu){
        sql07256 = "INSERT INTO gudangsepatu(nama,stock,size) VALUES (?,?,?)";
        int row = 0;
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setString(1,sepatu.getNama07256());
            ps07256.setInt(2,sepatu.getStock07256());
            ps07256.setInt(3,sepatu.getSize07256());
            row = ps07256.executeUpdate();
        }catch (SQLException e){
            System.out.println("Failed to create");
            e.printStackTrace();
        }
        return row;
    }

    public ArrayList<SepatuEntity07256> getSepatu07256(){
        ArrayList<SepatuEntity07256> listSepatu07256 = new ArrayList<>();
        sql07256 = "SELECT * FROM gudangsepatu";
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            rs07256 = ps07256.executeQuery();

            while (rs07256.next()){
                listSepatu07256.add(new SepatuEntity07256(
                        rs07256.getInt("id"),
                        rs07256.getString("nama"),
                        rs07256.getInt("stock"),
                        rs07256.getInt("size")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listSepatu07256;
    }

    public int updateSepatu07256(int id, SepatuEntity07256 sepatu){
        sql07256 = "UPDATE gudangsepatu SET nama = ?, stock = ?, size = ? WHERE id = ?";
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setString(1,sepatu.getNama07256());
            ps07256.setInt(2,sepatu.getStock07256());
            ps07256.setInt(3,sepatu.getSize07256());
            ps07256.setInt(4,id);
            return ps07256.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateSepatu07256(int id, int stock_baru){
        sql07256 = "UPDATE gudangsepatu SET stock = ? WHERE id = ?";
        int row = 0;
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setInt(1,stock_baru);
            ps07256.setInt(2,id);
            row = ps07256.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    public int updateSize07256(int id, int new_size){
        sql07256 = "UPDATE gudangsepatu SET size = ? WHERE id = ?";
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setInt(1,new_size);
            ps07256.setInt(2,id);
            return ps07256.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteSepatu07256(int id){
        sql07256 = "DELETE FROM gudangsepatu WHERE id = ?";
        int row = 0;

        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setInt(1,id);
            row = ps07256.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    public SepatuEntity07256 getSepatu07256(int id){
        sql07256 = "SELECT * FROM gudangsepatu WHERE id = ?";
        try {
            ps07256 = conn07256.prepareStatement(sql07256);
            ps07256.setInt(1,id);

            rs07256 = ps07256.executeQuery();

            if(rs07256.next()){
                return new SepatuEntity07256(rs07256.getInt("id"), rs07256.getString("nama"),
                        rs07256.getInt("stock"), rs07256.getInt("size"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
