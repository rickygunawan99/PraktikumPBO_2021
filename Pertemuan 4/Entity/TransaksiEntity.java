package Entity;

public class TransaksiEntity {
    private int nomor_transaksi;
    private int status_transaksi;
    private String bayar;
    private PembeliEntity pembeli;
    private ProdukEntity produk;

    public TransaksiEntity(int nomor_transaksi, int status_transaksi,
                           String bayar, PembeliEntity pembeli, ProdukEntity produk) {
        this.nomor_transaksi = nomor_transaksi;
        this.status_transaksi = status_transaksi;
        this.bayar = bayar;
        this.pembeli = pembeli;
        this.produk = produk;
    }

    public int getNomor_transaksi() {
        return nomor_transaksi;
    }

    public int getStatus_transaksi() {
        return status_transaksi;
    }

    public PembeliEntity getPembeli() {
        return pembeli;
    }

    public ProdukEntity getProduk() {
        return produk;
    }

    public String getBayar() {
        return bayar;
    }

    public void setNomor_transaksi(int nomor_transaksi) {
        this.nomor_transaksi = nomor_transaksi;
    }

    public void setStatus_transaksi(int status_transaksi) {
        this.status_transaksi = status_transaksi;
    }

    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }

    public void setProduk(ProdukEntity produk) {
        this.produk = produk;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }
}