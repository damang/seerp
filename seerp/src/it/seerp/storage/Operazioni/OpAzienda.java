package it.seerp.storage.Operazioni;

import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.ejb.Azienda;

/**
 *
 * @author Ila
 */
public class OpAzienda {

    private Connection conn;

    public OpAzienda() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    public void inserimento(Azienda az) throws SQLException, DatiErratiEx {
        PreparedStatement stmt = null;

        String query = "INSERT INTO azienda(citta,email,fax,indirizzo,nazione,PIVA,RagioneSociale,telefono)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        stmt = (PreparedStatement) conn.prepareStatement(query);

        stmt.setString(1, az.getCitta());
        stmt.setString(2, az.getEmail());
        stmt.setString(3, az.getFax());
        stmt.setString(4, az.getIndirizzo());
        stmt.setString(5, az.getNazione());
        stmt.setString(6, az.getPIVA());
        stmt.setString(7, az.getRagioneSociale());
        stmt.setString(8, az.getTelefono());

        stmt.execute();
        stmt.close();

        ConnectionPool.releaseConnection(conn);

    }

    public Azienda modifica(Azienda az) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;
        String query = "UPDATE azienda(citta,email,fax,indirizzo,nazione,PIVA,RagioneSociale,telefono)" +
                " SET (?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = (PreparedStatement) conn.prepareStatement(query);

        stmt.setString(1, az.getCitta());
        stmt.setString(2, az.getEmail());
        stmt.setString(3, az.getFax());
        stmt.setString(4, az.getIndirizzo());
        stmt.setString(5, az.getNazione());
        stmt.setString(6, az.getPIVA());
        stmt.setString(7, az.getRagioneSociale());
        stmt.setString(8, az.getTelefono());

        stmt.execute();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return az;
    }

    public Azienda visualizza(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Azienda az = null;

        String sql = "SELECT idAzienda,citta,email,fax,indirizzo,nazione,piva,ragioneSociale,telefono" +
                " FROM azienda WHERE idAzienda= ?";
        stmt = (PreparedStatement) conn.prepareStatement(sql);

        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {

            az = new Azienda(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getInt(9));
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return az;
    }
}
