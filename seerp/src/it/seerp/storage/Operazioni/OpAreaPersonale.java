package it.seerp.storage.operazioni;

import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.Operazioni.OpPersonale;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Ila
 */
public class OpAreaPersonale extends OpPersonale {

    private Connection conn;

    public OpAreaPersonale() throws SQLException {

        conn = (Connection) ConnectionPool.getConnection();

    }

    /** Metodo che permette la visualizzazione dei dettagli
     * di un membro del personale nella propria area personale
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException*/
    @Override
    public Personale visualizzaDati(Integer id) throws SQLException {

        return super.visualizzaDati(id);
    }

    public Utente modificaPassword(Utente u) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE Utente (password) SET (?) where idUtente=" + u.getIdUtente();
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, u.getPassword());

            stmt.execute();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }

        return u;
    }
}
