

package it.seerp.storage.Operazioni;


import com.mysql.jdbc.Statement;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.jaas.PermessoCollection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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

        
    }

    private void insertIncarico(Connection conn,PreparedStatement stmt, Ruolo bean) throws SQLException {
        String sql = "insert into incarico set ruolo=?, permesso= (SELECT idPermesso from permesso where task=? and `action`=?);";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        PermessoCollection b = bean.getListPermesso();
        stmt.setString(1, bean.getNome());
        for (int i = 0; i < b.size(); i++) {
            stmt.setString(2, b.get(i).getName());
            stmt.setString(3, b.get(i).getActions());
            stmt.execute();
        }
    }
    public void inserimento(Ruolo bean) throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Ruolo Values (?);";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, bean.getNome());
            // Execute the query
        stmt.execute();
        insertIncarico(conn, stmt, bean);
               
            // Execute the query
        stmt.close();
        ConnectionPool.releaseConnection(conn);

           
    }

    public Ruolo modifica(Ruolo bean) throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;

        String sql = "Delete from incarico where ruolo=?;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, bean.getNome());
            // Execute the query
        stmt.execute();
        insertIncarico(conn, stmt, bean);
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return bean;
    }

    public Ruolo visualizza(String id) throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
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
        conn = (Connection) ConnectionPool.getConnection();
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
    public void elimina(Ruolo bean) throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        String sql = "Delete from ruolo where nome=?;";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, bean.getNome());
        stmt.execute();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
    }

    public ArrayList<Ruolo> GetListaRuoli(Ruolo ruol)throws SQLException{
        conn = (Connection) ConnectionPool.getConnection();
        ArrayList<Ruolo> r= new ArrayList<Ruolo>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ruolo,permesso WHERE ruolo.nome like '?%'";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
             // Execute the query
        stmt.setString(1,ruol.getNome());
        rs=stmt.executeQuery();
        while (rs.next())
        {
        r.add(new Ruolo(rs.getString(1)));
         rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);}
        return r;
        }


    
}
