package Model;

import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransaksiModel extends ModelAbstract {

    public TransaksiModel(){
        connect();
    }

    public ArrayList<TransaksiEntity> getTransaksi(){
        ArrayList<TransaksiEntity> listTransaksi = new ArrayList<>();
        sql = "SELECT * FROM datatransaksi";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                listTransaksi.add(new TransaksiEntity(
                        rs.getInt("id"),
                        rs.getInt("status"),
                        rs.getString("total_bayar"),
                        new PembeliEntity(
                                rs.getString("nama"),
                                rs.getString("id_akun"),
                                rs.getString("nama_akun"),
                                rs.getString("notelp")
                        ),
                        new ProdukEntity(
                                rs.getString("nominal"),
                                rs.getString("voucher"),
                                rs.getString("harga"),
                                rs.getInt("id")
                        )
                ));
            }
            return listTransaksi;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int insertData(TransaksiEntity transaksiEntity, int jumlah){
        int row = 0;
        sql = "INSERT INTO datatransaksi(nama,notelp,voucher,nominal,harga,id_akun,nama_akun," +
                "total_bayar,kembalian,jumlah) VALUES (?,?,?,?,?,?,?,?,?,?)" ;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,transaksiEntity.getPembeli().getNama());
            ps.setString(2,transaksiEntity.getPembeli().getNotelp());
            ps.setString(3,transaksiEntity.getProduk().getNama_produk());
            ps.setString(4,transaksiEntity.getProduk().getNominal());
            ps.setString(5,transaksiEntity.getProduk().getHarga_produk());
            ps.setString(6,transaksiEntity.getPembeli().getId_game());
            ps.setString(7,transaksiEntity.getPembeli().getNama_akun());
            ps.setString(8,transaksiEntity.getBayar());
            int kembalian = Integer.parseInt(transaksiEntity.getBayar()) - Integer.parseInt(transaksiEntity.getProduk().getHarga_produk());
            ps.setString(9, String.valueOf(kembalian));
            ps.setInt(10,jumlah);

            row = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    public TransaksiEntity getTransaksi(int id){
        sql = "SELECT * FROM datatransaksi WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if(rs.next()){
                return new TransaksiEntity(rs.getInt("id"), rs.getInt("status"),
                        rs.getString("total_bayar"),
                        new PembeliEntity(rs.getString("nama"),rs.getString("id_akun"),
                                rs.getString("nama_akun"),rs.getString("notelp")),
                        new ProdukEntity(rs.getString("nominal"),rs.getString("voucher"),
                                rs.getString("harga"),rs.getInt("id")));
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
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int insertProduct(ProdukEntity produk, int id_produk){
        sql = "INSERT INTO produk(nama_produk,nominal,harga_produk,kode_produk) VALUES (?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,produk.getNama_produk());
            ps.setString(2,produk.getNominal());
            ps.setString(3,produk.getHarga_produk());
            ps.setInt(4,id_produk);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ProdukEntity getProduk(int id){
        sql = "SELECT * FROM produk WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if(rs.next()){
                return new ProdukEntity(rs.getString("nominal"),rs.getString("nama_produk"),
                        rs.getString("harga_produk"), rs.getInt("id"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int deleteProduk(int id){
        sql = "DELETE FROM produk WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public int updateProduk(int id, ProdukEntity produk){
        sql = "UPDATE produk SET nama_produk = ?, nominal=?, harga_produk=? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,produk.getNama_produk());
            ps.setString(2,produk.getNominal());
            ps.setString(3,produk.getHarga_produk());
            ps.setInt(4,id);
            return ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<ProdukEntity> getProduk(){
        ArrayList<ProdukEntity> produk = new ArrayList<>();
        sql = "SELECT * FROM produk";
        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()){
                produk.add(new ProdukEntity(rs.getString("nominal"),rs.getString("nama_produk"),
                        rs.getString("harga_produk"), rs.getInt("id")));
            }
            return produk;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public int getIdProduk(String nama_produk){
        sql = "SELECT id from listproduk WHERE nama = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nama_produk);

            rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("id");
            }else{
                return createNewProduct(nama_produk);
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int getIdTransaksi(){
        sql = "SELECT id FROM datatransaksi ORDER BY id DESC LIMIT 1";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public int createNewProduct(String nama_produk){
        sql = "SELECT id FROM listproduk ORDER BY kode DESC LIMIT 1";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            int newId;

            if(rs.next()) {
                newId = rs.getInt("id") + 1;
            } else
                newId = 1;

            return createNewProduct(nama_produk,newId);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int createNewProduct(String nama, int id){
        sql = "INSERT INTO listproduk(nama,kode) VALUES(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setInt(2,id);
            ps.executeUpdate();
            return id;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
