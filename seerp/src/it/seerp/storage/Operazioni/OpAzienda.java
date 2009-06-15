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
        try {
            String query = "INSERT INTO Azienda VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )";

            stmt = (PreparedStatement) conn.prepareStatement(query);

            stmt.setInt(1, az.getIdAzienda());
            stmt.setString(2, az.getCittà());
            stmt.setString(3, az.getEmail());
            stmt.setString(4, az.getFax());
            stmt.setString(5, az.getIndirizzo());
            stmt.setString(6, az.getNazione());
            stmt.setString(7, az.getPIVA());
            stmt.setString(8, az.getRagioneSociale());
            stmt.setString(9, az.getTelefono());

            stmt.execute();

        } catch (SQLException se) {
            System.out.println("Errore di inserimento dei dati dell'azienda");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
    }

    public Azienda modifica(Azienda az) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        try {

            stmt = (PreparedStatement) conn.prepareStatement("UPDATE Azienda SET (?, ?, ?, ?, ?, ?,?,?,?)");

            stmt.setInt(1, az.getIdAzienda());
            stmt.setString(2, az.getCittà());
            stmt.setString(3, az.getEmail());
            stmt.setString(4, az.getFax());
            stmt.setString(5, az.getIndirizzo());
            stmt.setString(6, az.getNazione());
            stmt.setString(7, az.getPIVA());
            stmt.setString(8, az.getRagioneSociale());
            stmt.setString(9, az.getTelefono());

            stmt.execute();

        } catch (SQLException se) {
            System.out.println("Errore nella modifica dei dati dell'azienda");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return az;
    }

    public Azienda visualizza(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Azienda az = null;

        try {
            String sql = "SELECT * FROM Azienda WHERE idAzienda= ?";
            stmt = (PreparedStatement) conn.prepareStatement(sql);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {


                az = new Azienda(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9));


            }
        } catch (SQLException se) {
            System.out.println("Errore nella visualizzazione dei dati dell'azienda");

        } finally {
            // Release the resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return az;
    }
}
