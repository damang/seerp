package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Dipendente;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;

import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Matteo
 */
public class OpDipendente extends OpPersonale {

    Connection con = null;

    /**
     * costruttore
     * @throws java.sql.SQLException
     */
    public OpDipendente() throws SQLException {
        super();
        con = (Connection) ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione
     * della lista dei dipendenti
     * @return ArrayList contenente la lista dei dipendenti
     * @throws java.sql.SQLException*/
    public ArrayList<Dipendente> elencaDipendente() throws SQLException {

        ArrayList<Dipendente> list = new ArrayList<Dipendente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT idUtente,username,password,citta,prov,telefono," +
                "cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita " +
                "FROM Dipendente,Utente,Personale where idUtente=idpersonale and idPersonale=idDipendente and visibilita=true";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);


        /*
         * Integer idUtente1, String username2, String password3, String città4,
        String provincia5, String telefono6, String cap7, String email8, String note9,
        String tipo10, String cognome11, String nome12, String codiceFiscale13, Ruolo ruolo14, Boolean v15
         */
        // Define the resource list
        while (rs.next()) {
            Dipendente dipendente = new Dipendente(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                    rs.getString(11), rs.getString(12), rs.getString(13), new Ruolo(rs.getString(14)),
                    rs.getBoolean(15));
            list.add(dipendente);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return list;
    }

    /** Metodo che permette la ricerca di un membro dei dipendenti
     * @return la lista dei membri dei dipendente che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException
     */
    public ArrayList<Dipendente> ricercaDipendente() throws SQLException {
        ArrayList<Dipendente> list = this.elencaDipendente();
        return list;
    }

    /** Metodo che permette di eliminare un membro dei dipendenti già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException
     */
    public void elimina(Dipendente user) throws SQLException {

        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            con.setAutoCommit(false);
            String sql = "DELETE  FROM utente where username = ?";
            String sql1 = "DELETE  FROM personale where idPersonale=?";
            String sql2 = "DELETE  FROM dipendente where idDipendente=?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt1 = (PreparedStatement) con.prepareStatement(sql1);
            stmt2 = (PreparedStatement) con.prepareStatement(sql2);
            stmt.setString(1, user.getUsername());
            stmt1.setInt(1, user.getIdUtente());
            stmt2.setInt(1, user.getIdUtente());
            // Execute the query
            System.out.println(   stmt.execute());
            System.out.println( stmt1.execute());
            System.out.println( stmt2.execute());
            con.commit();
        } catch (SQLException se) {
            con.rollback();
            se.printStackTrace();
            System.out.println("eliminazione fallita");
        }
        stmt.close();
        stmt1.close();
        stmt2.close();
        ConnectionPool.releaseConnection(con);

    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException
     */
    public void eliminazioneLogica(Dipendente user) throws SQLException {

        PreparedStatement stmt = null;

        String sql = "UPDATE Dipendente (visibilita)" +
                " SET visibilita='false' where username = ?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);

        // Execute the query
        stmt.executeQuery();
        stmt.close();
        ConnectionPool.releaseConnection(con);
    }

    /** Metodo per inserire un nuovo membro dei dipiendenti
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Dipendente user) throws SQLException, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        PreparedStatement stmtp = null;
        PreparedStatement stmtd = null;

        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,citta,prov,telefono," +
                "cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita" +
                " FROM dipendente,personale,utente WHERE codiceFiscale='" + user.getCodiceFiscale() + "' and idUtente=idPersonale and idPersonale=idDipendente";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("dipendente già esistente nel database");
        } else {
            try {
                con.setAutoCommit(false);
                String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) VALUES(?,?,?,?,?,?,?,?,?,true)";
                String sqlp = "INSERT INTO personale(idPersonale,nome,cognome,codicefiscale,ruolo)" +
                        "VALUES(LAST_INSERT_ID(),?,?,?,?)";
                String sqlr = "INSERT INTO dipendente (idDipendente)" +
                        "VALUES(LAST_INSERT_ID())";

                stmt = (PreparedStatement) con.prepareStatement(sqlu);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getCitta());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getNote());
                stmt.setString(9, user.getTipo());
                //stmt.setString(10, user.getVisible().toString());
                stmtp = (PreparedStatement) con.prepareStatement(sqlp);
                stmtp.setString(1, user.getNome());
                stmtp.setString(2, user.getCognome());
                stmtp.setString(3, user.getCodiceFiscale());
                stmtp.setString(4, user.getRuolo().getNome());
                stmtd = (PreparedStatement) con.prepareStatement(sqlr);
                stmt.execute();
                stmtp.execute();
                stmtd.execute();
                con.commit();
            } catch (SQLException se) {
                      con.rollback();
            }

            stmt.close();
            ConnectionPool.releaseConnection(con);

        }
    }

    /** Metodo che permette la modifica di un membro dei dipendenti presente nel sistema
     * @param user
     * user del membro dei dipendenti da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx
     */
    public Dipendente modifica(Dipendente user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        PreparedStatement stmtP = null;


        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,citta,provincia,telefono," +
                "cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita FROM Dipendente WHERE codiceFiscale='" + user.getCodiceFiscale() + "'" +
                "and idUtente=idPersonale and idPersonale=idDipendente ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("dipendete già esistente nel database");
        } else {
            try {
                con.setAutoCommit(false);
                String sqlu = "UPDATE Utente(username,password,email,citta,prov,telefono" +
                        "CAP,note,tipo,visibilita) SET username=?,,password=?,email=?,citta=?,prov=?," +
                        "telefono=?,CAP=?,note=?,tipo=?,visibilita=?";
                String sqlp = "UPDATE Personale(nome,cognome,codicefiscale,ruolo)" +
                        "SET nome=?,cognome=?,codicefiscale=?,ruolo=? ";

                stmt = (PreparedStatement) con.prepareStatement(sqlu);
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
                stmtP = (PreparedStatement) con.prepareStatement(sqlp);
                stmtP.setString(1, user.getNome());
                stmtP.setString(2, user.getCognome());
                stmtP.setString(3, user.getCodiceFiscale());
                stmtP.setString(4, user.getRuolo().getNome());
                stmt.execute();
                stmtP.execute();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.out.println("modifica fallita");
            }
        }
        return user;
    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro dei dipendendenti
     * @param id
     * id del membro dei dipendenti
     * @return il bean con i dettagli del membro del personale
     * @throws SQLException
     */
    @Override
    public Dipendente visualizzaDati(Integer id) throws SQLException {
        Dipendente dipendente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        String sql = "SELECT idUtente,username,password,citta,prov,telefono,Cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita" +
                " FROM utente,personale where idUtente=idPersonale and idPersonale=? ";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            dipendente = new Dipendente(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                    rs.getString(11), rs.getString(12), rs.getString(13), new Ruolo(rs.getString(14)),
                    rs.getBoolean(15));
            System.out.println("lu"+ rs.getString(1));
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return dipendente;

    }
}
