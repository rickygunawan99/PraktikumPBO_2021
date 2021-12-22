package Model;

import Entity.PembeliEntity;

import java.util.ArrayList;

public class PembeliModel extends ModelAbstract{
    public PembeliModel(){
        connect();
    }

    public int insertPembeli(PembeliEntity pembeli){
        sql = "INSERT INTO datapembeli(nama,nama_akun,id_akun,notelp) VALUES (?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,pembeli.getNama());
            ps.setString(2, pembeli.getNama_akun());
            ps.setString(3,pembeli.getId_game());
            ps.setString(4,pembeli.getNotelp());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<PembeliEntity> getPembeli(){
        sql = "SELECT * FROM datapembeli";
        ArrayList<PembeliEntity> pembeli = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pembeli.add(new PembeliEntity(rs.getString("nama"), rs.getString("id_akun"),
                        rs.getString("nama_akun"),rs.getString("notelp")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PembeliEntity getPembeli(int id){
        sql = "SELECT * FROM datapembeli WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            rs = ps.executeQuery();

            if(rs.next()){
                return new PembeliEntity(rs.getString("nama"), rs.getString("id_akun"),
                        rs.getString("nama_akun"),rs.getString("notelp"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
