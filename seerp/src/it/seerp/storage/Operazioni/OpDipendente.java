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

    Connection conne = null;

    /**
     * costruttore
     * @throws java.sql.SQLException
     */
    public OpDipendente() throws SQLException {
        super();

    }

    /** Metodo che permette la visualizzazione
     * della lista dei dipendenti
     * @return ArrayList contenente la lista dei dipendenti
     * @throws java.sql.SQLException*/
    public ArrayList<Dipendente> elencaDipendente() throws SQLException {
        conne = (Connection) ConnectionPool.getConnection();
        ArrayList<Dipendente> list = new ArrayList<Dipendente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT idUtente,username,password,citta,prov,telefono," +
                "cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita,indirizzo " +
                "FROM Dipendente,Utente,Personale where idUtente=idPersonale and idPersonale=idDipendente and visibilita=true";
        stmt = (PreparedStatement) conne.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);
        // Define the resource list
        while (rs.next()) {
            Dipendente dip = new Dipendente();
            dip.setIdUtente(rs.getInt(1));
            dip.setUsername(rs.getString(2));
            dip.setPassword(rs.getString(3));
            dip.setCitta(rs.getString(4));
            dip.setProvincia(rs.getString(5));
            dip.setTelefono(rs.getString(6));
            dip.setCap(rs.getString(7));
            dip.setEmail(rs.getString(8));
            dip.setNote(rs.getString(9));
            dip.setTipo(rs.getString(10));
            dip.setCognome(rs.getString(11));
            dip.setNome(rs.getString(12));
            dip.setCodiceFiscale(rs.getString(13));
            dip.setRuolo(new Ruolo(rs.getString(13)));
            dip.setVisible(rs.getBoolean(14));
             dip.setIndirizzo(rs.getString(15));
            list.add(dip);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conne);
        return list;
    }

    /** Metodo che permette la ricerca di un membro dei dipendenti
     * @return la lista dei membri dei dip che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException

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
        conne = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            conne.setAutoCommit(false);
            String sql = "DELETE  FROM utente where username = ?";
            String sql1 = "DELETE  FROM personale where idPersonale=?";
            String sql2 = "DELETE  FROM dipendente where idDipendente=?";
            // Create a statement
            stmt = (PreparedStatement) conne.prepareStatement(sql);
            stmt1 = (PreparedStatement) conne.prepareStatement(sql1);
            stmt2 = (PreparedStatement) conne.prepareStatement(sql2);
            stmt.setString(1, user.getUsername());
            stmt1.setInt(1, user.getIdUtente());
            stmt2.setInt(1, user.getIdUtente());
            // Execute the query
            stmt.execute();
            stmt1.execute();
            stmt2.execute();
            conne.commit();
        } catch (SQLException se) {
            conne.rollback();
            se.printStackTrace();
            throw new SQLException("Transizione fallita");

        }
        stmt.close();
        stmt1.close();
        stmt2.close();
        ConnectionPool.releaseConnection(conne);

    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException

    public void eliminazioneLogica(Dipendente user) throws SQLException {
    conne = (Connection) ConnectionPool.getConnection();
    PreparedStatement stmt = null;

    String sql = "UPDATE Dipendente (visibilita)" +
    " SET visibilita='false' where username = ?";
    // Create a statement
    stmt = (PreparedStatement) conne.prepareStatement(sql);

    // Execute the query
    stmt.executeQuery();
    stmt.close();
    ConnectionPool.releaseConnection(conne);
    }

    /** Metodo per inserire un nuovo membro dei dipiendenti
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Dipendente user) throws SQLException, DatiDuplicatiEx {
        conne = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmtp = null;
        PreparedStatement stmtd = null;
        PreparedStatement stmtv = null;
        Statement stmt1 = conne.createStatement();



        try {
            conne.setAutoCommit(false);
            String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita,indirizzo) VALUES(?,?,?,?,?,?,?,?,?,true,?)";
            String sqlp = "INSERT INTO personale(idPersonale,nome,cognome,codicefiscale,ruolo)" +
                    "VALUES(LAST_INSERT_ID(),?,?,?,?)";
            String sqlr = "INSERT INTO dipendente (idDipendente)" +
                    "VALUES(LAST_INSERT_ID())";
            String sqla = "INSERT INTO agenda (idAgenda) VALUES(LAST_INSERT_ID()) ";
            stmt = (PreparedStatement) conne.prepareStatement(sqlu);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getCap());
            stmt.setString(8, user.getNote());
            stmt.setString(9, user.getTipo());
            stmt.setString(10, user.getIndirizzo());
            //stmt.setString(10, user.getVisible().toString());
            stmtp = (PreparedStatement) conne.prepareStatement(sqlp);
            stmtp.setString(1, user.getNome());
            stmtp.setString(2, user.getCognome());
            stmtp.setString(3, user.getCodiceFiscale());
            stmtp.setString(4, user.getRuolo().getNome());
            stmtd = (PreparedStatement) conne.prepareStatement(sqlr);
            stmtv = (PreparedStatement) conne.prepareStatement(sqla);
            stmt.execute();
            stmtp.execute();
            stmtd.execute();

            stmtv.execute();

            conne.commit();
        } catch (SQLException se) {

            switch (se.getErrorCode()) {
                case 1062:
                    throw new DatiDuplicatiEx("Username già assegnato ad un altro utente");

                case 1364:
                    throw new SQLException("la password è obligatoria!");

                default:
                    conne.rollback();
                    throw new SQLException("Transizione fallita");
            }

        }

        stmt.close();
        ConnectionPool.releaseConnection(conne);


    }

    /** Metodo che permette la modifica di un membro dei dipendenti presente nel sistema
     * @param user
     * user del membro dei dipendenti da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx

    public Dipendente modifica(Dipendente user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

    PreparedStatement stmt = null;
    PreparedStatement stmtP = null;
    conne = (Connection) ConnectionPool.getConnection();

    Statement stmt1 = conne.createStatement();
    String sqlTest = "SELECT idUtente,username,password,citta,provincia,telefono," +
    "cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita FROM Dipendente WHERE codiceFiscale='" + user.getCodiceFiscale() + "'" +
    "and idUtente=idPersonale and idPersonale=idDipendente ";
    ResultSet rs = stmt1.executeQuery(sqlTest);

    if (rs.next()) {
    throw new DatiDuplicatiEx("dipendete già esistente nel database");
    } else {
    try {
    conne.setAutoCommit(false);
    String sqlu = "UPDATE Utente(username,password,email,citta,prov,telefono" +
    "CAP,note,tipo,visibilita) SET username=?,,password=?,email=?,citta=?,prov=?," +
    "telefono=?,CAP=?,note=?,tipo=?,visibilita=?";
    String sqlp = "UPDATE Personale(nome,cognome,codicefiscale,ruolo)" +
    "SET nome=?,cognome=?,codicefiscale=?,ruolo=? ";

    stmt = (PreparedStatement) conne.prepareStatement(sqlu);
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
    stmtP = (PreparedStatement) conne.prepareStatement(sqlp);
    stmtP.setString(1, user.getNome());
    stmtP.setString(2, user.getCognome());
    stmtP.setString(3, user.getCodiceFiscale());
    stmtP.setString(4, user.getRuolo().getNome());
    stmt.execute();
    stmtP.execute();
    conne.commit();
    } catch (SQLException e) {
    conne.rollback();
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
        Dipendente dip = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        conne = (Connection) ConnectionPool.getConnection();

        String sql = "SELECT idUtente,username,password,citta,prov,telefono,Cap,email,note,tipo,cognome,nome,codiceFiscale,ruolo,visibilita" +
                " FROM utente,personale where idUtente=idPersonale and idPersonale=? ";
        // Create a statement
        stmt = (PreparedStatement) conne.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            dip = new Dipendente();
            dip.setIdUtente(rs.getInt(1));
            dip.setUsername(rs.getString(2));
            dip.setPassword(rs.getString(3));
            dip.setCitta(rs.getString(4));
            dip.setProvincia(rs.getString(5));
            dip.setTelefono(rs.getString(6));
            dip.setCap(rs.getString(7));
            dip.setEmail(rs.getString(8));
            dip.setNote(rs.getString(9));
            dip.setTipo(rs.getString(10));
            dip.setCognome(rs.getString(11));
            dip.setNome(rs.getString(12));
            dip.setCodiceFiscale(rs.getString(13));
            dip.setRuolo(new Ruolo(rs.getString(14)));
            dip.setVisible(rs.getBoolean(15));
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conne);

        return dip;

    }
}
