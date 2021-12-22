package Model;

import Helper07256.KoneksiDB_07256;

import java.sql.*;

public abstract class ModelAbstract {
    protected String sql;
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement ps;
    protected ResultSet rs;

    protected void connect(){
        this.conn = KoneksiDB_07256.getConnection_07256();
    }
}
