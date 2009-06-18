/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;


import com.mysql.jdbc.Statement;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Ruolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peppe
 */
public class OpRuolo implements OpeEntity<Ruolo,String>{
    private Connection conn;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpRuolo() throws SQLException {

        conn = (Connection) ConnectionPool.getConnection();
    }

    public void inserimento(Ruolo bean) throws SQLException {
        
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Ruolo Values (?);";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, bean.getNome());
            // Execute the query
        stmt.execute();

        stmt.close();
        ConnectionPool.releaseConnection(conn);

           
    }

    public Ruolo modifica(Ruolo bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Ruolo visualizza(String id) throws SQLException {
         PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Ruolo where nome=?;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
             // Execute the query
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        Ruolo r;
        if (rs.next()) {
            r= new Ruolo(rs.getString(1));
        }
        else r=null;
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return r;
    }

    public ArrayList<Ruolo> visualizzaElenco() throws SQLException {
        ArrayList<Ruolo> r= new ArrayList<Ruolo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Ruolo;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
             // Execute the query
        rs=stmt.executeQuery();
        while (rs.next())
            r.add(new Ruolo(rs.getString(1)));
         rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return r;
    }
}
