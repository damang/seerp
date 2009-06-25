/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.Operazioni;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpFornitore extends OpExtraAzienda {

    Connection conness = null;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpFornitore() throws SQLException {
        super();

    }

    /** Metodo che permette la visualizzazione della lista dei Fornitori
     * @return ArrayList contenente la lista dei  Fornitori
     * @throws java.sql.SQLException*/
    public ArrayList<Fornitore> elencaFornitore() throws SQLException {
        conness = (Connection) ConnectionPool.getConnection();
        ArrayList<Fornitore> list = new ArrayList<Fornitore>();

        Statement stmt = null;
        ResultSet rs = null;


        String sql = "SELECT idUtente,username,password,citta,ruolo,prov," +
                "telefono,cap,email,ruolo,note,visibilita,cognome,nome,ragioneSociale,piva," +
                "fax FROM utente,extraazienda where  idUtente=idExtraAzienda  and visibilita=true and ruolo='Fornitore'";
        stmt = (PreparedStatement) conness.prepareStatement(sql);

        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10), rs.getString(11),
                    rs.getBoolean(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17));
            // Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax) {

            list.add(fornitore);
        }

        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conness);

        return list;
    }

    /** Metodo che permette la ricerca di un Fornitore
     * @param cognome
     * cognome del Fornitore da ricercare
     * @param ruolo
     * ruolo che il Fornitore ricopre all'interno dell'azienda
     * @return la lista dei Fornitori che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException
    public ArrayList<Fornitore> ricercaFornitore(String cognome, String ruolo) throws SQLException {

    ArrayList<Fornitore> list = this.elencaFornitore();

    return list;

    }

    /** Metodo che permette di eliminare un Fornitore già esistente
     * @param user
     * user del Fornitore da eliminare
     * @throws java.sql.SQLException
    public void elimina(Fornitore user) throws SQLException {
    conness = ConnectionPool.getConnection();
    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    try {
    conness.setAutoCommit(false);
    String sqlu = "Delete * from utente where username=?";
    String sqle = "Delete * extraazienda where idExtraAzienda=?";


    stmt = (PreparedStatement) conness.prepareStatement(sqlu);
    stmt1 = (PreparedStatement) conness.prepareStatement(sqle);
    stmt.setString(1, user.getUsername());
    stmt1.setInt(1, user.getIdUtente());

    stmt.execute();
    stmt1.execute();

    conness.commit();
    } catch (SQLException e) {
    conness.rollback();
    throw new SQLException("Transizione fallita");

    }
    stmt.close();
    ConnectionPool.releaseConnection(conness);
    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user del Fornitore da eliminare
     * @throws java.sql.SQLException
    private void eliminazioneLogica(Fornitore user) throws SQLException {
    PreparedStatement stmt = null;


    String sql = "UPDATE utente(visibilita) SET visibilita='false'";

    // Create a statement
    stmt = (PreparedStatement) conness.prepareStatement(sql);

    // Execute the query
    stmt.executeQuery();

    stmt.close();
    ConnectionPool.releaseConnection(conness);


    }

    /** Metodo per inserire un nuovo Fornitore
     * @param user
     * user del Fornitore da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Fornitore user) throws SQLException, DatiDuplicatiEx {

        conness = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmte = null;
        PreparedStatement stmtv = null;
        Statement stmt1 = conness.createStatement();
        String sqlTest = "SELECT piva FROM extraazienda WHERE piva= '" + user.getPIva() + "'";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("contatto già esistente nel database");
        } else {
            try {
                conness.setAutoCommit(false);
                String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) VALUES(?,?,?,?,?,?,?,?,?,true)";
                String sqle = "INSERT INTO extraazienda(idExtraAzienda,nome,cognome,fax,piva,ragioneSociale,Ruolo,codiceFiscale)" +
                        "VALUES(LAST_INSERT_ID(),?,?,?,?,?,'Fornitore',?)";
                String sqla = "INSERT INTO agenda (idAgenda) VALUES(LAST_INSERT_ID()) ";

                stmt = (PreparedStatement) conness.prepareStatement(sqlu);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getCitta());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getNote());
                stmt.setString(9, user.getTipo());
                // stmt.setString(10, user.getVisible().toString());
                stmte = (PreparedStatement) conness.prepareStatement(sqle);
                stmte.setString(1, user.getNome());
                stmte.setString(2, user.getCognome());
                stmte.setString(3, user.getFax());
                stmte.setString(4, user.getPIva());
                stmte.setString(5, user.getRagioneSociale());
                stmte.setString(6, user.getCodiceFiscale());

                stmtv = (PreparedStatement) conness.prepareStatement(sqla);

                
                stmt.execute();
                stmte.execute();
                stmtv.execute();


                conness.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                conness.rollback();
            }

            stmt.close();
            ConnectionPool.releaseConnection(conness);
        }


    }

    /** Metodo che permette la modifica di un Fornitore presente nel sistema
     * @param user
     * user del Fornitore da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx

    public Fornitore modifica(Fornitore user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
    PreparedStatement stmt = null;
    PreparedStatement stmte = null;



    Statement stmt1 = conness.createStatement();
    String sqlTest = "SELECT idUtente,username,password,città,ruol,provincia," +
    "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
    "fax FROM fornitore,utente,extraazienda WHERE  idUtente=idExtraAzienda and idExtraAzienda=idFornitore and nome='" + user.getPIva();
    ResultSet rs = stmt1.executeQuery(sqlTest);

    if (rs.next()) {
    throw new DatiDuplicatiEx("utente già esistente nel database");
    } else {
    try {
    conness.setAutoCommit(false);
    String sqlu = "UPDATE utente(username,password,email,citta,prov,telefono" +
    "CAP,note,tipo,visibilita) SET username=?,password=?,email=?,citta=?,prov=?," +
    "telefono=?,CAP=?,note=?,tipo=?,visibilita=?";
    String sqle = "UPDATE extraazienda(nome,cognome,fax,piva,ragioneSociale,codiceFiscale)" +
    "SET nome=?,cognome=?,fax=?,piva=?,ragioneSociale=?,codiceFiscale=?";


    stmt = (PreparedStatement) conness.prepareStatement(sqlu);
    stmt.setString(1, user.getUsername());
    stmt.setString(2, user.getPassword());
    stmt.setString(3, user.getEmail());
    stmt.setString(4, user.getCitta());
    stmt.setString(5, user.getProvincia());
    stmt.setString(6, user.getTelefono());
    stmt.setString(7, user.getCap());
    stmt.setString(8, user.getNote());
    stmt.setString(9, user.getTipo());
    stmt.setString(10, user.getVisible().toString());
    stmte = (PreparedStatement) conness.prepareStatement(sqle);
    stmte.setString(1, user.getNome());
    stmte.setString(2, user.getCognome());
    stmte.setString(3, user.getFax());
    stmte.setString(4, user.getPIva());
    stmte.setString(5, user.getRagioneSociale());

    stmt.execute();
    stmte.execute();

    conness.commit();
    } catch (SQLException e) {
    conness.rollback();
    throw new SQLException("Transizione fallita");

    }
    }
    stmt.close();
    ConnectionPool.releaseConnection(conness);

    return user;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un Fornitore
     * @param id
     * id del Fornitore
     * @return il bean con i dettagli del Fornitore
     * @throws java.sql.SQLException*/
    @Override
    public Fornitore visualizzaDati(Integer id) throws SQLException {
        conness = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fornitore fornitore = null;



        String sql = "SELECT idUtente,username,password,citta,prov," +
                "telefono,cap,email,Ruolo,note,visibilita,cognome,nome,ragioneSociale," +
                "piva,fax,codiceFiscale FROM utente,extraazienda WHERE idUtente=idExtraAzienda and idExtraAzienda=?";
        // String sql = "SELECT * FROM extraazienda where idExtraAzienda= ? ";

        stmt = (PreparedStatement) conness.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();


        // Define the resource list
        while (rs.next()) {
            fornitore = new Fornitore();
            fornitore.setIdUtente(rs.getInt(1));
            fornitore.setUsername(rs.getString(2));
            fornitore.setPassword(rs.getString(3));
            fornitore.setCitta(rs.getString(4));
            fornitore.setProvincia(rs.getString(5));
            fornitore.setTelefono(rs.getString(6));
            fornitore.setCap(rs.getString(7));
            fornitore.setEmail(rs.getString(8));
            fornitore.setRuolo(rs.getString(9));
            fornitore.setNote(rs.getString(10));
            fornitore.setVisible(rs.getBoolean(11));
            fornitore.setCognome(rs.getString(12));
            fornitore.setNome(rs.getString(13));
            fornitore.setRagioneSociale(rs.getString(14));
            fornitore.setPIva(rs.getString(15));
            fornitore.setFax(rs.getString(16));
            fornitore.setCodiceFiscale(rs.getString(17));

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conness);
        return fornitore;

    }
}
