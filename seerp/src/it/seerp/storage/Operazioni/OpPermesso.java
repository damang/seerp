/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.Operazioni;

import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.jaas.ejb.Permesso;
import it.seerp.storage.ejb.jaas.PermessoCollection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;

/**
 *
 * @author peppe
 */
public class OpPermesso implements OpeEntity<Permesso, Integer> {

    private Connection conn;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpPermesso() throws SQLException {
    }

    public void inserimento(Permesso bean) throws SQLException {
        /*    PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Ruolo Values (?);";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, bean.getNome());
        // Execute the query
        stmt.execute();
         */
    }

    public Permesso modifica(Permesso bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Permesso visualizza(Integer id) throws SQLException {
        /*    PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Ruolo where id=?;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        // Execute the query
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        Ruolo r= new Ruolo(rs.getString(1));
        return r;*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PermessoCollection getAllPermission() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
        PermessoCollection r = new PermessoCollection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM permesso;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery();
        while (rs.next()) {
            r.add(new Permesso(rs.getInt(1), rs.getString("task"), rs.getString("action")));
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return r;

    }

    @Override
    public ArrayList<Permesso> visualizzaElenco() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPermessoID(String task, String action) throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT idPermesso FROM permesso where task=? and action=?;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        // Execute the query
        stmt.setString(1, task);
        stmt.setString(2, action);
        rs = stmt.executeQuery();
        int i;
        if (rs.next()) {
            i = rs.getInt(1);
        } else {
            i = -1;
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return i;
    }
}
