package Entity;

public class AdminEntity extends ManusiaEntity{
    String id, password, notelp;

    public AdminEntity(String nama, String id, String password, String notelp) {
        super(nama);
        this.id = id;
        this.password = password;
        this.notelp = notelp;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}

