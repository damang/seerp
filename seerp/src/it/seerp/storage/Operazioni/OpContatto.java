package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;

import it.seerp.storage.ejb.Contatto;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpContatto extends OpExtraAzienda {

    Connection con = null;

    public OpContatto() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione della lista dei Contatti
     * @return ArrayList contenente la lista dei Contatti
     * @throws java.sql.SQLException*/
    public ArrayList<Contatto> elencaContatto() throws SQLException {

        ArrayList<Contatto> list = new ArrayList<Contatto>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale," +
                "pIva,fax FROM contratto,utente,extraazienda where visibilita='true' and idUtente=idExtraAzienda and idExtraAzienda=idContatto";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);


        // Define the resource list
        while (rs.next()) {
            Contatto contatto = new Contatto(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10), rs.getString(11),
                    rs.getBoolean(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getInt(18));
            // Integer idUtente, String username, String password, String città, String ruol 5 , String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, String cognome, String nome, String ragioneSociale 15, String pIva, String fax, Integer feedback) {

            list.add(contatto);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return list;
    }

    /** Metodo che permette la ricerca di un Contatto
     * @param cognome
     * cognome del Contatto da ricercare
     * @param ruolo
     * ruolo che il Contatto ricopre all'interno dell'azienda
     * @return la lista dei Contatti che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Contatto> ricercaContatto(Integer id, String user) throws SQLException {

        ArrayList<Contatto> list = this.elencaContatto();

        return list;
    }

    /** Metodo che permette di eliminare un Contatto già esistente
     * @param user
     * user del Contatto da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Contatto user) throws SQLException {

        PreparedStatement stmt = null;

        String sql = "DELETE idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale," +
                "pIva,fax FROM contatto,utente,extraazienda" + "where idUtente=idExtraAzienda and idExtraAzienda=idContatto and username =" + user;

        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        // Execute the query
        stmt.executeQuery(sql);
        stmt.close();
        ConnectionPool.releaseConnection(con);

    }

    /** Metodo per inserire un nuovo Contatto
     * @param user
     * user del Contatto da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Contatto user) throws SQLException {

        PreparedStatement stmt = null;
        PreparedStatement stmte = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM contatto,extraazienda,utente WHERE partitaiva='" + user.getPIva();
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("contatto già esistente nel database");
        } else {
           try{
                    con.setAutoCommit(false);
                String sqlu = "INSERT INTO utente(idUtente,username,password,email,citta,prov,telefono" +
                        "CAP,note,tipo,visibilita) VALUES(LAST_INSERT_ID()+1,?,?,?,?,?,?,?,?,?,?)";
                String sqle = "INSERT INTO extraazienda(idExtraAzienda,nome,cognome,fax,piva,ragioneSociale,Ruolo,codiceFiscale)" +
                        "VALUES(LAST_INSERT_ID(),?,?,?,?,'Contatto',?)";


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
                stmte = (PreparedStatement) con.prepareStatement(sqle);
                stmt.setString(1, user.getNome());
                stmt.setString(2, user.getCognome());
                stmt.setString(3, user.getFax());
                stmt.setString(4, user.getPIva());
                stmt.setString(5,user.getRagioneSociale());

                stmt.execute();
                stmte.execute();

                con.commit();
            }catch(SQLException e){
                 con.rollback();}

                stmt.close();
                ConnectionPool.releaseConnection(con);
    }
    }

    /** Metodo che permette la modifica di un Contatto presente nel sistema
     * @param user
     * user del Contatto da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/
    public Contatto modifica(Contatto user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        Contatto contatto = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM contatto,utente,extraazienda WHERE idExtraAzienda=idUtente and idExtraAzienda=idContatto and pIva='" + user.getPIva();
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("contatto già esistente nel database");
        } else {


            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE contatto,utente,extraazienda(idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=idExtraAzienda and idExtraAzienda=idContatto idUtente=" + user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getRuolo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getCap());
            stmt.setString(9, user.getEmail());
            stmt.setString(10, user.getRuolo());
            stmt.setString(11, user.getNote());
            stmt.setBoolean(12, user.getVisible());

            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());

            stmt.setInt(18, user.getFeedback());

            stmt.execute();

            contatto = (Contatto) this.visualizza(user.getIdUtente());

        }
        stmt.close();

        ConnectionPool.releaseConnection(con);

        return contatto;
    }

    /** Metodo che permette la visualizzazione dei dettagli di un Contatto
     * @param id
     * id del Contatto
     * @return il bean con i dettagli del Contatto
     * @throws java.sql.SQLException*/
    public Contatto visualizzaDati(Integer id) throws SQLException {
        Contatto contatto = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;



        String sql = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM contatto,utente,extraazienda" + "where idUtente=idExtraAzienda and idExtraAzienda=idContatto and idUtente= " + id;

        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, id.toString());
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {

            contatto = new Contatto(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10), rs.getString(11),
                    rs.getBoolean(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getInt(18));
        // Integer idUtente, String username, String password, String città, String ruol 5, String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome 15, String ragioneSociale, String pIva, String fax, Integer idContatto, Integer feedback) {

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return contatto;
    }
}
