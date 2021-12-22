package Entity;

public class ProdukEntity {
    private String nominal;
    private String nama_produk;
    private String harga_produk;
    private int id;

    public ProdukEntity(String nominal, String nama_produk, String harga_produk, int id) {
        this.nominal = nominal;
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
        this.id = id;
    }

    public String getNominal() {
        return nominal;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public int getId() {
        return id;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }

    @Override
    public String toString() {
        return  getId() + ". \t" + getNama_produk() +"\t " +
                        getNominal()  + "/qty \t " + getHarga_produk();
    }
}
