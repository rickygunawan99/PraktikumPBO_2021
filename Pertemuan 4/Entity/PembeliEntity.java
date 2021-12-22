package Entity;

public class PembeliEntity extends ManusiaEntity{

    private String id_game, nama_akun, notelp;

    public PembeliEntity(String nama, String id_game, String nama_akun, String notelp) {
        super(nama);
        this.id_game = id_game;
        this.nama_akun = nama_akun;
        this.notelp = notelp;
    }

    public String getNotelp() {
        return notelp;
    }

    public String getId_game() {
        return id_game;
    }

    public String getNama_akun() {
        return nama_akun;
    }

    public void setId_game(String id_game) {
        this.id_game = id_game;
    }

    public void setNama_akun(String nama_akun) {
        this.nama_akun = nama_akun;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
