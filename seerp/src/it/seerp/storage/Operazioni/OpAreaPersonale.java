package it.seerp.storage.operazioni;

import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Operazioni.OpPersonale;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ila
 */
public class OpAreaPersonale extends OpPersonale {

    @Override
    public Personale visualizzaDati(Integer id) throws SQLException {

        /** Metodo che permette la visualizzazione dei dettagli
         * di un membro del personale nella propria area personale
         * @param id
         * id del membro del personale
         * @return il bean con i dettagli del membro del personale
         * @throws java.sql.SQLException
         */
        return super.visualizzaDati(id);
    }

    public Utente modificaPassword(Utente u) throws SQLException, DatiErrati {


        // throw new UnsupportedOperationException("Not supported yet.");
        Connection con = null;
        PreparedStatement stmt = null;
        Utente ute = new Utente();

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            // Create a statement
            stmt = con.prepareStatement("UPDATE Utente SET (?)" + "where idUtente=" + ute.getIdUtente());
            stmt.setString(1, ute.getPassword());


            stmt.execute();
            // Force the commit
            con.commit();
            ute = this.visualizza(ute.getIdUtente());
        } // Force the commit
        catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        return ute;
    }
}
