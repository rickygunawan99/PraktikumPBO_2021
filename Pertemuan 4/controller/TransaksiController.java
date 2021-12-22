package controller;

import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TransaksiController extends ObjectModelController{

    public int insertTransaksi(int nomor_transaksi, PembeliEntity pembeli, ProdukEntity produk,
                               int status, String bayar, int jumlah){
        return transaksiModel.insertData(new TransaksiEntity(nomor_transaksi,status,bayar,pembeli,produk),jumlah);
    }

    public int deleteTransaksi(int id){
        return transaksiModel.deleteTransaksi(id);
    }

    public int insertProduk(ProdukEntity produk){
        return transaksiModel.insertProduct(new ProdukEntity(produk.getNominal(),
                        produk.getNama_produk(), produk.getHarga_produk(), 0),
                transaksiModel.getIdProduk(produk.getNama_produk()));
    }

    public int deleteProduk(int id){
        return transaksiModel.deleteProduk(id);
    }

    public int updateProduk(int id, ProdukEntity produk){
        return transaksiModel.updateProduk(id,produk);
    }

    public TransaksiEntity getTransaksi(int id){
        return transaksiModel.getTransaksi(id);
    }

    public ArrayList<TransaksiEntity> getTransaksi(){
        return transaksiModel.getTransaksi();
    }

    public ProdukEntity getProduk(int id){
        return transaksiModel.getProduk(id);
    }

    public ArrayList<ProdukEntity> getProduk(){
        return transaksiModel.getProduk();
    }

    public int getIdTransaksi(){
        return transaksiModel.getIdTransaksi();
    }

    public DefaultTableModel getTableProduk(){
        DefaultTableModel tabel = new DefaultTableModel();
        Object[] column = {"Id", "Voucher Game", "Jumlah", "Harga"};
        tabel.setColumnIdentifiers(column);
        for(ProdukEntity produk : getProduk()){
            Object[] row = new Object[4];
            row[0] = produk.getId();
            row[1] = produk.getNama_produk();
            row[2] = produk.getNominal();
            row[3] = produk.getHarga_produk();
            tabel.addRow(row);
        }
        return tabel;
    }

    public DefaultTableModel getTransactionTable(){
        DefaultTableModel table = new DefaultTableModel();
        Object[] column = {"Id","Nama","No Telp", "Jumlah", "Harga", "Id akun", "Total bayar", "Status"};
        table.setColumnIdentifiers(column);
        for(TransaksiEntity transaksi : getTransaksi()){
            Object[] row = new Object[8];
            row[0] = transaksi.getNomor_transaksi();
            row[1] = transaksi.getPembeli().getNama();
            row[2] = transaksi.getPembeli().getNotelp();
            row[3] = transaksi.getProduk().getNominal();
            row[4] = transaksi.getProduk().getHarga_produk();
            row[5] = transaksi.getPembeli().getId_game();
            row[6] = transaksi.getBayar();
            row[7] = transaksi.getStatus_transaksi();
            table.addRow(row);
        }
        return table;
    }
}
