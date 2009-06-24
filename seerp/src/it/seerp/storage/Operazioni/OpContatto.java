package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;

import it.seerp.storage.ejb.Contatto;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpContatto extends OpExtraAzienda {
    Connection connessione = null;


    /**
     *
     * @throws java.sql.SQLException
     */
    public OpContatto() throws SQLException {
        super();
    }

    /** Metodo che permette la visualizzazione della lista dei Contatti
     * @return ArrayList contenente la lista dei Contatti
     * @throws java.sql.SQLException*/
    public ArrayList<Contatto> elencaContatto() throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        ArrayList<Contatto> list = new ArrayList<Contatto>();
       
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT idUtente,username,password,citta,prov," +
                    "telefono,cap,email,Ruolo,visibilita,cognome,nome,ragioneSociale," +
                    "piva,fax FROM utente,extraazienda WHERE idUtente=idExtraAzienda and Ruolo='Contatto' and visibilita= true";
         stmt = (PreparedStatement) connessione.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            Contatto c = new Contatto();
            c.setIdUtente(rs.getInt(1));
            c.setUsername(rs.getString(2));
            c.setPassword(rs.getString(3));
            c.setCitta(rs.getString(4));
            c.setProvincia(rs.getString(5));
            c.setTelefono(rs.getString(6));
            c.setCap(rs.getString(7));
            c.setEmail(rs.getString(8));
            c.setTipo(rs.getString(9));
            c.setNote(rs.getString(10));
            c.setVisible(rs.getBoolean(11));
            c.setCognome(rs.getString(12));
            c.setNome(rs.getString(13));
            c.setRagioneSociale(rs.getString(14));
            c.setPIva(rs.getString(15));
            c.setFax(rs.getString(16));
            //Integer idUtente, String username, String password, String città, String ruol 5, String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, String cognome, String nome, String ragioneSociale 15, String pIva, String fax) {

            list.add(c);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(connessione);
        return list;
    }

    /** Metodo che permette la ricerca di un Contatto
     * @param id
     * @param user
     * @return la lista dei Contatti che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
 /*   public ArrayList<Contatto> ricercaContatto(Integer id, String user) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        ArrayList<Contatto> list = this.elencaContatto();

        return list;
    }

    /** Metodo che permette di eliminare un Contatto già esistente
     * @param user
     * user del Contatto da eliminare
     * @throws java.sql.SQLException*/
  /*  public void elimina(Contatto user) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
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
                            throw new SQLException("Transizione fallita");

            }
        stmt.close();
        ConnectionPool.releaseConnection(connessione);

    }

    /** Metodo per inserire un nuovo Contatto
     * @param user
     * user del Contatto da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Contatto user) throws SQLException {
        connessione = ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmte = null;
        Statement stmt1 = connessione.createStatement();
        String sqlTest = "SELECT piva FROM extraazienda WHERE piva= '" + user.getPIva() + "'";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("contatto già esistente nel database");
        } else {
            try {
                connessione.setAutoCommit(false);
                String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) VALUES(?,?,?,?,?,?,?,?,?,true)";
                super.inserimento(user);

                String sqle = "INSERT INTO extraazienda(idExtraAzienda,nome,cognome,fax,piva,ragioneSociale,Ruolo,feedback)" +
                        "VALUES(LAST_INSERT_ID(),?,?,?,?,?,'Contatto',?)";


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
                stmt.setBoolean(10, user.getVisible());
                stmte = (PreparedStatement) connessione.prepareStatement(sqle);
                stmte.setString(1, user.getNome());
                stmte.setString(2, user.getCognome());
                stmte.setString(3, user.getFax());
                stmte.setString(4, user.getPIva());
                stmte.setString(5, user.getRagioneSociale());
                stmte.setInt(6, user.getFeedback());

               stmt.execute();
                stmte.execute();

                connessione.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                connessione.rollback();
                          /*  throw new SQLException("Transizione fallita");*/

            }

            stmt.close();
            ConnectionPool.releaseConnection(connessione);
        }

    }

    /** Metodo che permette la modifica di un Contatto presente nel sistema
     * @param user
     * user del Contatto da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx
     */
 /*   public Contatto modifica(Contatto user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmte = null;
        
        Statement stmt1 = connessione.createStatement();
        String sqlTest = "SELECT idUtente,username,password,citta,ruolo,prov," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM contatto,utente,extraazienda WHERE idExtraAzienda=idUtente and idExtraAzienda=idContatto and pIva='" + user.getPIva();
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("contatto già esistente nel database");
        } else {

 try {
                connessione.setAutoCommit(false);
                String sqlu = "UPDATE utente(username,password,email,citta,prov,telefono" +
                        "CAP,note,tipo,visibilita) SET username=?,password=?,email=?,citta=?,prov=?," +
                        "telefono=?,CAP=?,note=?,tipo=?,visibilita=?";
                String sqle = "UPDATE extraazienda(nome,cognome,fax,piva,ragioneSociale,codiceFiscale)" +
                        "SET nome=?,cognome=?,fax=?,piva=?,ragioneSociale=?,codiceFiscale=?";


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
                stmt.setString(10, user.getVisible().toString());
                stmte = (PreparedStatement) connessione.prepareStatement(sqle);
                stmte.setString(1, user.getNome());
                stmte.setString(2, user.getCognome());
                stmte.setString(3, user.getFax());
                stmte.setString(4, user.getPIva());
                stmte.setString(5, user.getRagioneSociale());

                stmt.execute();
                stmte.execute();

                connessione.commit();
            } catch (SQLException e) {
                connessione.rollback();
                            throw new SQLException("Transizione fallita");

            }

        }
        stmt.close();

        ConnectionPool.releaseConnection(connessione);

        return user;
    }

    /** Metodo che permette la visualizzazione dei dettagli di un Contatto
     * @param id
     * id del Contatto
     * @return il bean con i dettagli del Contatto
     * @throws java.sql.SQLException*/
    public Contatto visualizzaDati(Integer id) throws SQLException {
        connessione = ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contatto c = null;



        String sql ="SELECT idUtente,username,password,citta,prov," +
                    "telefono,cap,email,Ruolo,note,visibilita,cognome,nome,ragioneSociale," +
                    "piva,fax FROM utente,extraazienda WHERE idUtente=idExtraAzienda and idExtraAzienda=?";


        stmt = (PreparedStatement) connessione.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();


        // Define the resource list
        while (rs.next()) {

            c = new Contatto();
            c.setIdUtente(rs.getInt(1));
            c.setUsername(rs.getString(2));
            c.setPassword(rs.getString(3));
            c.setCitta(rs.getString(4));
            c.setProvincia(rs.getString(5));
            c.setTelefono(rs.getString(6));
            c.setCap(rs.getString(7));
            c.setEmail(rs.getString(8));
            c.setRuolo(rs.getString(9));
            c.setNote(rs.getString(10));
            c.setVisible(rs.getBoolean(11));
            c.setCognome(rs.getString(12));
            c.setNome(rs.getString(13));
            c.setRagioneSociale(rs.getString(14));
            c.setPIva(rs.getString(15));
            c.setFax(rs.getString(16));
           

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(connessione);
        return c;

    }
}
