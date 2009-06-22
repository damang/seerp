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

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpAzienda() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    /**
     *
     * @param az
     * @throws java.sql.SQLException
     * @throws it.seerp.storage.Exception.DatiErratiEx
     */
    public void inserimento(Azienda az) throws SQLException, DatiErratiEx {
        PreparedStatement stmt = null;

        String query = "INSERT INTO azienda(citta,email,fax,indirizzo,nazione,PIVA,regioneSociale,telefono)" +
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

    /**
     *
     * @param az
     * @return
     * @throws java.sql.SQLException
     * @throws it.seerp.storage.Exception.DatiErratiEx
     */
    public Azienda modifica(Azienda az) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;
        String query = "UPDATE azienda SET citta=?,email=?,fax=?,indirizzo=?,nazione=?,PIVA=?,regioneSociale=?,telefono=?" +
                "where idAzienda=?";
        stmt = (PreparedStatement) conn.prepareStatement(query);

        stmt.setString(1, az.getCitta());
        stmt.setString(2, az.getEmail());
        stmt.setString(3, az.getFax());
        stmt.setString(4, az.getIndirizzo());
        stmt.setString(5, az.getNazione());
        stmt.setString(6, az.getPIVA());
        stmt.setString(7, az.getRagioneSociale());
        stmt.setString(8, az.getTelefono());
        stmt.setInt(9, az.getIdAzienda());

        stmt.execute();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return az;
    }

    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     */
    public Azienda visualizza() throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Azienda az = null;

        String sql = "SELECT idAzienda,citta,email,fax,indirizzo,nazione,piva,regioneSociale,telefono" +
                    "FROM azienda";
        stmt = (PreparedStatement) conn.prepareStatement(sql);

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
