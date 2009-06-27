package it.seerp.storage.Operazioni;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Azienda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ila
 */
public class OpInit implements OpeEntity<Amministratore, Azienda> {

    private Connection connessione = null;

    public OpInit() throws SQLException {
    }

    @Override
    public void inserimento(Amministratore user) throws SQLException {

        connessione = (Connection) ConnectionPool.getConnection();

        PreparedStatement stmt = null;
        PreparedStatement stmtp = null;
        PreparedStatement stmtd = null;
        PreparedStatement stmta = null;

        try {
            connessione.setAutoCommit(false);
            String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) " +
                    "VALUES(?,?,?,?,?,?,?,?,'personale',true)";
            String sqlp = "INSERT INTO personale(idPersonale,nome,cognome,codicefiscale,ruolo)" +
                    "VALUES(LAST_INSERT_ID(),?,?,?,'amministratore')";
            String sqlr = "INSERT INTO amministratore (idAmministratore)" +
                    "VALUES(LAST_INSERT_ID())";
            String sqla = "INSERT INTO azienda(idAzienda,email,nazione,piva,regioneSociale,telefono)" +
                    "VALUES(LAST_INSERT_ID(),?,?,?,?,?)";
            stmt = (PreparedStatement) connessione.prepareStatement(sqlu);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getCap());
            stmt.setString(8, user.getNote());
            // stmt.setString(9, user.getTipo());
            //stmt.setString(10, user.getVisible().toString());
            stmtp = (PreparedStatement) connessione.prepareStatement(sqlp);
            stmtp.setString(1, user.getNome());
            stmtp.setString(2, user.getCognome());
            stmtp.setString(3, user.getCodiceFiscale());

//           
            stmtd = (PreparedStatement) connessione.prepareStatement(sqlr);


            stmta = (PreparedStatement) connessione.prepareStatement(sqla);
            stmta.setString(1, user.getAzienda().getEmail());

            stmta.setString(2, user.getAzienda().getNazione());
            stmta.setString(3, user.getAzienda().getPIVA());
            stmta.setString(4, user.getAzienda().getRagioneSociale());
            stmta.setString(5, user.getAzienda().getTelefono());
            stmt.execute();
            stmtp.execute();
            stmtd.execute();
            stmta.execute();
            connessione.commit();

        } catch (SQLException se) {
            se.printStackTrace();
            connessione.rollback();

            throw new SQLException("Transizione fallita");
        }

    }

    public boolean check() throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmtp = null;
        ResultSet rs = null;

        String query = "SELECT * FROM amministratore WHERE idAmministratore >= 1";
        stmtp = (PreparedStatement) connessione.prepareStatement(query);
        rs = stmtp.executeQuery(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Amministratore modifica(Amministratore bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Amministratore visualizza(Azienda id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Amministratore> visualizzaElenco() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}