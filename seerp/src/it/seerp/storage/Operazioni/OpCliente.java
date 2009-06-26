package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;

import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;

/**
 *
 * @author LuNy
 */
public class OpCliente extends OpExtraAzienda {

    Connection connessione = null;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpCliente() throws SQLException {
        super();

    }

    /** Metodo che permette la visualizzazione della lista dei Clienti
     * @return ArrayList contenente la lista dei Clienti
     * @throws java.sql.SQLException*/
    public ArrayList<Cliente> elencaCliente() throws SQLException {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
        connessione = (Connection) ConnectionPool.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT idUtente,username,password,citta,prov," +
                "telefono,cap,email,Ruolo,note,visibilita,cognome,nome,ragioneSociale," +
                "piva,fax FROM utente,extraazienda WHERE idUtente=idExtraAzienda and Ruolo='Cliente' and visibilita= true";
        stmt = (PreparedStatement) connessione.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdUtente(rs.getInt(1));
            cliente.setUsername(rs.getString(2));
            cliente.setPassword(rs.getString(3));
            cliente.setCitta(rs.getString(4));
            cliente.setProvincia(rs.getString(5));
            cliente.setTelefono(rs.getString(6));
            cliente.setCap(rs.getString(7));
            cliente.setEmail(rs.getString(8));
            cliente.setTipo(rs.getString(9));
            cliente.setNote(rs.getString(10));
            cliente.setVisible(rs.getBoolean(11));
            cliente.setCognome(rs.getString(12));
            cliente.setNome(rs.getString(13));
            cliente.setRagioneSociale(rs.getString(14));
            cliente.setPIva(rs.getString(15));
            cliente.setFax(rs.getString(16));
            //Integer idUtente, String username, String password, String città, String ruol 5, String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, String cognome, String nome, String ragioneSociale 15, String pIva, String fax) {

            list.add(cliente);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(connessione);
        return list;
    }

    /** Metodo che permette la ricerca di un Cliente
     * @param cognome
     * cognome del Cliente da ricercare
     * @param ruolo
     * ruolo che il Cliente ricopre all'interno dell'azienda
     * @return la lista dei Clienti che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException
    public ArrayList<Cliente> ricercaCliente(String cognome, String ruolo) throws SQLException {

    ArrayList<Cliente> list = this.elencaCliente();

    return list;

    }

    /** Metodo che permette di eliminare un Cliente già esistente
     * @param user
     * user del Cliente da eliminare
     * @throws java.sql.SQLException
    public void elimina(Cliente user) throws SQLException {

    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    try {
    connessione.setAutoCommit(false);
    String sqlu = "Delete * from utente where username=?";
    String sqle = "Delete * extraazienda where idExtraAzienda=?";
    stmt = (PreparedStatement) connessione.prepareStatement(sqlu);
    stmt1= (PreparedStatement) connessione.prepareStatement(sqle);
    stmt.setString(1, user.getUsername());
    stmt1.setInt(1,user.getIdUtente());

    stmt.execute();
    stmt1.execute();

    connessione.commit();
    } catch (SQLException e) {
    connessione.rollback();
    }
    stmt.close();
    ConnectionPool.releaseConnection(connessione);



    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user del Cliente da eliminare
     * @throws java.sql.SQLException*
    private void eliminazioneLogica(Cliente user) throws SQLException {

    PreparedStatement stmt = null;

    String sql = "UPDATE utente(visibilita) SET visible='false' where idUtente=?";
    // Create a statement
    stmt = (PreparedStatement) connessione.prepareStatement(sql);
    stmt.setInt(1, user.getIdUtente());
    // Execute the query
    stmt.executeQuery();

    stmt.close();

    ConnectionPool.releaseConnection(connessione);



    }

    /** Metodo per inserire un nuovo Cliente
     * @param user
     * user del Cliente da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Cliente user) throws SQLException, DatiDuplicatiEx {

        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmtv = null;
        PreparedStatement stmte = null;
        try {
            connessione.setAutoCommit(false);
            String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) VALUES(?,?,?,?,?,?,?,?,?,true)";
            super.inserimento(user);

            String sqle = "INSERT INTO extraazienda(idExtraAzienda,nome,cognome,fax,piva,ragioneSociale,Ruolo,codiceFiscale)" +
                    "VALUES(LAST_INSERT_ID(),?,?,?,?,?,'cliente',?)";

            String sqla = "INSERT INTO agenda (idAgenda) VALUES(LAST_INSERT_ID()) ";
            stmt = (PreparedStatement) connessione.prepareStatement(sqlu);
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
            stmte = (PreparedStatement) connessione.prepareStatement(sqle);
            stmte.setString(1, user.getNome());
            stmte.setString(2, user.getCognome());
            stmte.setString(3, user.getFax());
            stmte.setString(4, user.getPIva());
            stmte.setString(5, user.getRagioneSociale());
            stmte.setString(6, user.getCodiceFiscale());
            stmtv = (PreparedStatement) connessione.prepareStatement(sqla);
            stmt.execute();
            stmte.execute();
            stmtv.execute();

            connessione.commit();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062:
                    throw new SQLException("Username già assegnato ad un altro utente");

                case 1364:
                    throw new SQLException("la password è obligatoria!");

                  default:
                    connessione.rollback();
                    throw new SQLException("Transizione fallita");
          }
        }

        stmt.close();
        ConnectionPool.releaseConnection(connessione);

    }

    /** Metodo che permette la modifica di un Cliente presente nel sistema
     * @param user
     * user del Cliente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx

    public Cliente modifica(Cliente user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
    PreparedStatement stmt = null;
    PreparedStatement stmte = null;
    connessione = ConnectionPool.getConnection();
    /* Statement stmt1 = connessione.createStatement();
    String sqlTest = "SELECT idUtente,username,password,citta,ruol,provincia," +
    "telefono,cap,email,ruolo,note,visibilita,cognome,nome,ragioneSociale,pIva" +
    "fax FROM utente,extraazienda WHERE  idUtente=idExtraAzienda and nome='" + user.getPIva() + "' ";
    ResultSet rs = stmt1.executeQuery(sqlTest);

    if (rs.next()) {
    throw new DatiDuplicatiEx("utente già esistente nel database");
    } else {
    try {

    connessione.setAutoCommit(false);
    String sqlu = "UPDATE utente SET username=?,password=?,email=?,citta=?,prov=?," +
    "telefono=? WHERE idUtente=?";/*mettere visibilita tipo e cap
    String sqle = "UPDATE extraazienda SET piva=?,ragioneSociale=?" +
    "WHERE idExtraAzienda=?";/*nome,cognome=?,fax=?,codiceFiscale=?


    stmt = (PreparedStatement) connessione.prepareStatement(sqlu);
    stmt.setString(1, user.getUsername());
    stmt.setString(2, user.getPassword());
    stmt.setString(3, user.getEmail());
    stmt.setString(4, user.getCitta());
    stmt.setString(5, user.getProvincia());
    stmt.setString(6, user.getTelefono());
    //  stmt.setString(7, user.getCap());
    //stmt.setString(8, user.getNote());
    //   stmt.setString(9, user.getTipo());
    stmt.setInt(7, user.getIdUtente());
    //                stmt.setString(10, user.getVisible().toString());
    stmte = (PreparedStatement) connessione.prepareStatement(sqle);
    //  stmte.setString(1, user.getNome());
    //stmte.setString(2, user.getCognome());
    // stmte.setString(3, user.getFax());
    stmte.setString(1, user.getPIva());
    stmte.setString(2, user.getRagioneSociale());
    stmte.setInt(3, user.getIdUtente());

    stmt.execute();
    stmte.execute();

    connessione.commit();
    } catch (SQLException e) {
    e.printStackTrace();
    connessione.rollback();
    }


    stmt.close();
    ConnectionPool.releaseConnection(connessione);
    return user;


    }

    /** Metodo che permette la visualizzazione dei dettagli di un Cliente
     * @param id
     * id del Cliente
     * @return il bean connessione i dettagli del Cliente
     * @throws java.sql.SQLException*/
    @Override
    public Cliente visualizzaDati(Integer id) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;



        String sql = "SELECT idUtente,username,password,citta,prov," +
                "telefono,cap,email,Ruolo,note,visibilita,cognome,nome,ragioneSociale," +
                "piva,fax,codiceFiscale FROM utente,extraazienda WHERE idUtente=idExtraAzienda and idExtraAzienda=?";


        stmt = (PreparedStatement) connessione.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();


        // Define the resource list
        while (rs.next()) {

            cliente = new Cliente();
            cliente.setIdUtente(rs.getInt(1));
            cliente.setUsername(rs.getString(2));
            cliente.setPassword(rs.getString(3));
            cliente.setCitta(rs.getString(4));
            cliente.setProvincia(rs.getString(5));
            cliente.setTelefono(rs.getString(6));
            cliente.setCap(rs.getString(7));
            cliente.setEmail(rs.getString(8));
            cliente.setRuolo(rs.getString(9));
            cliente.setNote(rs.getString(10));
            cliente.setVisible(rs.getBoolean(11));
            cliente.setCognome(rs.getString(12));
            cliente.setNome(rs.getString(13));
            cliente.setRagioneSociale(rs.getString(14));
            cliente.setPIva(rs.getString(15));
            cliente.setFax(rs.getString(16));
            cliente.setCodiceFiscale(rs.getString(17));


        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(connessione);
        return cliente;

    }
}

