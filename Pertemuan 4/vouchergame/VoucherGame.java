package vouchergame;

import Entity.PembeliEntity;
import Entity.ProdukEntity;
import Entity.TransaksiEntity;
import controller.AdminController;
import controller.PembeliController;
import controller.TransaksiController;

import java.util.Scanner;

public class VoucherGame {
    private Scanner scan = new Scanner(System.in);
    private final TransaksiController transaksiController = new TransaksiController();
    private final AdminController adminController = new AdminController();
    private final PembeliController pembeliController = new PembeliController();


    public void run(){
        menu();
    }

    private void menu(){
        int pil;

        do {
           System.out.println("""
                SELAMAT DATANG DI APLIKASI ...
                1. Beli
                2. Cek proses transaksi 
                0. Exit""");
            System.out.print("Input : ");
            pil = scan.nextInt();

            switch (pil){
                case 1 -> beliVoucher();
                case 2 -> viewTransaksiById();
                case 7 -> loginAdmin();
                default -> System.out.println(".........");
            }
        }while (pil!=0);
    }


    private void beliVoucher(){
        if (transaksiController.getProduk().size() != 0) {
            System.out.println("-----------------------");
            System.out.println("Beli Voucher");
            System.out.println("-----------------------");
            System.out.print("Nama : ");
            String nama =scan.next();
            System.out.print("No telp : ");
            String notelp = scan.next();
            System.out.println("----------------------------");

            System.out.println("Id\tVoucher\tNominal\t\tHarga");
            for(ProdukEntity produk : transaksiController.getProduk())
            {
                System.out.println("| " +produk.toString() + " |");
            }

            System.out.println("-----------------------------");
            System.out.print("Pilih produk : ");
            int pilih_produk = scan.nextInt();
            System.out.print("Jumlah yang ingin dibeli : ");
            int jumlah_dibeli = scan.nextInt();
            System.out.print("Username : ");
            String username = scan.next();
            System.out.print("ID game : ");
            String id = scan.next();
            System.out.println("----------------");
            System.out.print("Total harga : ");
            int total_harga = Integer.parseInt(transaksiController.getProduk(pilih_produk).getHarga_produk()) *
                    jumlah_dibeli;
            System.out.println(total_harga);
            System.out.print("Total bayar : ");
            int total_bayar = scan.nextInt();

            if(total_bayar >= total_harga) {
                pembeliController.insert(new PembeliEntity(nama,id,username,notelp));
                int transaksi = transaksiController.insertTransaksi(0,
                        new PembeliEntity(nama, id, username, notelp),
                        new ProdukEntity(String.valueOf(jumlah_dibeli), transaksiController.getProduk(pilih_produk)
                                .getNama_produk(),
                                transaksiController.getProduk(pilih_produk).getHarga_produk(),0),
                        0,
                        String.valueOf(total_bayar),jumlah_dibeli);

                if(transaksi > 0) {
                    System.out.println("Transaksi berhasil");
                    System.out.println("Id transaksi : " + transaksiController.getIdTransaksi());
                }
                else
                    System.out.println("Transaksi gagal");

            }else{
                System.out.println("Saldo tidak mencukupi");
            }
        }
    }

    private void viewTransaksiById(){
        System.out.print("Masukan id transaksi : ");
        int id = scan.nextInt();
        System.out.println("----------------------------------------");

        if(transaksiController.getTransaksi(id)!=null){
            TransaksiEntity tf = transaksiController.getTransaksi(id);
            System.out.println("Nomor transaksi : " + tf.getNomor_transaksi());
            System.out.println("===========================");
            System.out.println("Nama pembeli : " + tf.getPembeli().getNama());
            System.out.println("No telp : " + tf.getPembeli().getNotelp());
            System.out.println("Voucher : " + tf.getProduk().getNama_produk());
            System.out.println("Nominal : " + tf.getProduk().getNominal());
            System.out.println("Harga   : " + tf.getProduk().getHarga_produk());
            System.out.println("ID      : " + tf.getPembeli().getId_game());
            System.out.println("IGN     : " + tf.getPembeli().getNama_akun());
            System.out.println("Uang    : " + tf.getBayar());
            int kembalian = Integer.parseInt(tf.getBayar())-Integer.parseInt(tf.getProduk().getHarga_produk());
            System.out.println("Kembali : " + kembalian);
            System.out.print("Status transaksi : ");
            System.out.println(tf.getStatus_transaksi()==0 ? "Sedang diproses" : "Sudah diproses");
        }else
            System.out.println("Transaksi tidak ditemukan");

        System.out.println("----------------------------------------");
    }

    public void showData(){
        if(transaksiController.getTransaksi().size()!=0){
            System.out.println("Data Transaksi");
            for(TransaksiEntity tf : transaksiController.getTransaksi()){
                System.out.println("---------------------------------");
                System.out.println("Nomor transaksi : " + tf.getNomor_transaksi());
                System.out.println("Nama pembeli : " + tf.getPembeli().getNama());
                System.out.println("No telp : " + tf.getPembeli().getNotelp());
                System.out.println("Voucher : " + tf.getProduk().getNama_produk());
                System.out.println("Nominal : " + tf.getProduk().getNominal());
                System.out.println("Harga   : " + tf.getProduk().getHarga_produk());
                System.out.println("ID      : " + tf.getPembeli().getId_game());
                System.out.println("IGN     : " + tf.getPembeli().getNama_akun());
                System.out.println("Uang    : " + tf.getBayar());
                int kembalian = Integer.parseInt(tf.getBayar())-Integer.parseInt(tf.getProduk().getHarga_produk());
                System.out.println("Kembali : " + kembalian);
                System.out.println("---------------------------------");
            }
        }
    }

    private void loginAdmin(){
        System.out.print("Id : ");
        String id = scan.next();
        System.out.print("Password : ");
        String pass = scan.next();
        int cek = adminController.login(id,pass);
        if(cek > 0){
            menuAdmin(cek);
        }else {
            System.out.println("Id / Password tidak ditemukan");
        }
    }

    private void menuAdmin(int idAdminLogin){
        int pil = -1;
        do
        {
            System.out.println("\t" + adminController.getAdmin(idAdminLogin).getNama());
            System.out.println("----------------------------------");
            System.out.println("\t Menu \t");
            System.out.println("----------------------------------");
            System.out.println("""
                    1. Insert Produk
                    2. Proses Transaksi
                    3. Hapus Transaksi
                    4. Cek daftar transaksi
                    """);
            System.out.print("Pilih : ");
            pil = scan.nextInt();

            switch (pil){
                case 1 -> insertProduk();
                case 2 -> prosesTransaksi();
                case 3 -> deleteTransaksi();
                case 4 -> showData();
            }
        }while (pil!=0);
    }

    private void insertProduk(){
        System.out.print("Masukan nama produk : ");
        String namaProduk = scan.next();
        System.out.print("Masukan nominal produk : ");
        String nominal = scan.next();
        System.out.print("Masukan Harga Produk : ");
        String hargaProduk = scan.next();

        if(transaksiController.insertProduk(new ProdukEntity(nominal,namaProduk,hargaProduk,0)) > 0){
            System.out.print("Produk berhasil ditambahkan");
        }else{
            System.out.println("Produk gagal ditambahkan");
        }
        System.out.println();
    }

    private void prosesTransaksi(){
        showData();
        System.out.println("-------------------------");
        System.out.print("Input id yang akan di proses : ");
        int proses = scan.nextInt();

        if(adminController.updateStatusTransaksi(proses) > 0)
            System.out.println("Berhasil Update");
        else
            System.out.println("Gagal Update");
    }

    private void deleteTransaksi(){
        System.out.print("Masukan id transaksi yang akan di delete : ");
        int id = scan.nextInt();
        if(adminController.deleteTransaksi(id) > 0)
            System.out.println("Delete berhasil");
        else
            System.out.println("Delete gagal");
    }
}
