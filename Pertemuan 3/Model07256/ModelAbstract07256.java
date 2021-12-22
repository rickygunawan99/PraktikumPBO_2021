package Model07256;

import Helper07256.KoneksiDB_07256;

import java.sql.*;

public abstract class ModelAbstract07256 {
    protected String sql07256;
    protected Connection conn07256;
    protected PreparedStatement ps07256;
    protected ResultSet rs07256;

    public void connect(){
        conn07256 = KoneksiDB_07256.getConnection_07256();
    }
}
