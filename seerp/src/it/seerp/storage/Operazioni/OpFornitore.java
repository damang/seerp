/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;
import it.seerp.storage.ejb.Fornitore;

import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpFornitore extends OpExtraAzienda {

    Connection con = null;

    public OpFornitore() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione della lista dei Fornitori
     * @return ArrayList contenente la lista dei  Fornitori
     * @throws java.sql.SQLException*/
    public ArrayList<Fornitore> elencaFornitore() throws SQLException {

        ArrayList<Fornitore> list = new ArrayList<Fornitore>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        String sql = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM fornitore where Visible='true'";
        stmt = (PreparedStatement) con.prepareStatement(sql);
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
        ConnectionPool.releaseConnection(con);

        return list;
    }

    /** Metodo che permette la ricerca di un Fornitore
     * @param cognome
     * cognome del Fornitore da ricercare
     * @param ruolo
     * ruolo che il Fornitore ricopre all'interno dell'azienda
     * @return la lista dei Fornitori che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Fornitore> ricercaFornitore(String cognome, String ruolo) throws SQLException {

        ArrayList<Fornitore> list = this.elencaFornitore();

        return list;

    }

    /** Metodo che permette di eliminare un Fornitore già esistente
     * @param user
     * user del Fornitore da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Fornitore user) throws SQLException {

        PreparedStatement stmt = null;


        String sql = "DELETE idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM fornitore" + "where username =" + user;

        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        // Execute the query
        stmt.executeQuery(sql);

        stmt.close();
        ConnectionPool.releaseConnection(con);
    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user del Fornitore da eliminare
     * @throws java.sql.SQLException*/
    private void eliminazioneLogica(Fornitore user) throws SQLException {
        PreparedStatement stmt = null;


        String sql = "UPDATE fornitore(Visible) SET Visible='false'" + "where username =" + user;

        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);

        // Execute the query
        stmt.executeQuery();

        stmt.close();
        ConnectionPool.releaseConnection(con);


    }

    /** Metodo per inserire un nuovo Fornitore
     * @param user
     * user del Fornitore da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Fornitore user) throws SQLException, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM fornitore WHERE nome='" + user.getPIva();
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("utente già esistente nel database");
        } else {
            String sql = "INSERT INTO fornitore (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

            stmt.execute();
        }
        stmt.close();
        ConnectionPool.releaseConnection(con);

    }

    /** Metodo che permette la modifica di un Fornitore presente nel sistema
     * @param user
     * user del Fornitore da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/
    public Fornitore modifica(Fornitore user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
        PreparedStatement stmt = null;
        Fornitore fornitore = null;


        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM fornitore WHERE nome='" + user.getPIva();
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("utente già esistente nel database");
        } else {
        }

        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement("UPDATE fornitore(idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

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



        stmt.execute();

        fornitore = (Fornitore) this.visualizza(user.getIdFornitore());

        stmt.close();
        ConnectionPool.releaseConnection(con);

        return fornitore;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un Fornitore
     * @param id
     * id del Fornitore
     * @return il bean con i dettagli del Fornitore
     * @throws java.sql.SQLException*/
    public Fornitore visualizzaDati(Integer id) throws SQLException {


        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fornitore fornitore = null;


        String sql = "SELECT idUtente,username,password,città,ruol,provincia," +
                "telefono,cap,email,ruolo,note,v,cognome,nome,ragioneSociale,pIva," +
                "fax FROM fornitore" +
                "where idUtente= " + id;

        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, id.toString());
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            fornitore = new Fornitore(rs.getInt(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10), rs.getString(11),
                    rs.getBoolean(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17));

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return fornitore;
    }
}
