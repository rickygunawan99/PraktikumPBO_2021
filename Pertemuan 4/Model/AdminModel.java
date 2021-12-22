package Model;

import Entity.AdminEntity;

import java.sql.SQLException;

public class AdminModel extends ModelAbstract{

    public AdminModel(){
        connect();
    }

    public int insertData(AdminEntity admin){
        sql = "INSERT INTO admin(nama,id_admin,no_telp,password) VALUES (?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,admin.getNama());
            ps.setString(2,admin.getId());
            ps.setString(3,admin.getNotelp());
            ps.setString(4,admin.getPassword());

            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int cekData(String id, String password){
        sql = "SELECT * FROM admin WHERE id_admin = ? AND password = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public AdminEntity getAdmin(int id){
        sql = "SELECT * FROM admin WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                return new AdminEntity(rs.getString("nama"),rs.getString("id_admin"),
                        rs.getString("password"),rs.getString("no_telp"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int deleteTransaksi(int id){
        sql = "DELETE FROM datatransaksi WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int updateStatusTransaksi(int id){
        sql = "UPDATE datatransaksi SET status = 1 WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateProfil(int id, AdminEntity admin){
        sql = "UPDATE admin SET nama = ?, no_telp = ?, password = ? WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,admin.getNama());
            ps.setString(2,admin.getNotelp());
            ps.setString(3,admin.getPassword());
            ps.setInt(4,id);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
