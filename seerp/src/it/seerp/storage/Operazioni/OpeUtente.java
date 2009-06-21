package it.seerp.storage.Operazioni;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Utente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author matteo
 */
public class OpeUtente implements OpeEntity<Utente, Integer> {

    private Connection conn;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpeUtente() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    /*
     * metodo che permette di visualizzare l'elenco degli utenti
     * @return ArrayList<Utente> l'elenco degli utenti
     * @throws SQLException
     */
    public ArrayList<Utente> visualizzaElenco() throws SQLException {

        ArrayList<Utente> list = new ArrayList<Utente>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Create a statement
        String sql = "SELECT * FROM Utente where Visible='true'";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery();
        // Define the resource list
        while (rs.next()) {
            Utente utente = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));
            list.add(utente);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return list;
    }


    /*
     * metodo che permette di modificare i dati di un utente
     * @return Utente l'utente modificato
     * @throws SQLException
     * @throws DatiErratiEx
     */
    public Utente modifica(Utente user) throws SQLException, DatiErratiEx {
        conn = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
  

        /* Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT idUtente,username,password,citta,ruol,provincia," +
        "telefono,cap,email,ruolo,note,visibilita,cognome,nome,ragioneSociale,pIva" +
        "fax FROM utente,extraazienda WHERE  idUtente=idExtraAzienda and nome='" + user.getPIva() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
        throw new DatiDuplicatiEx("utente già esistente nel database");
        } else {*/

        String sqlu = "UPDATE utente SET username=?,password=?,email=?,citta=?,prov=?," +
                "telefono=? WHERE idUtente=?";/*mettere visibilita tipo e cap*/


        stmt = (PreparedStatement) conn.prepareStatement(sqlu);
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


        stmt.execute();





        stmt.close();
        ConnectionPool.releaseConnection(conn);
        return user;
    }

    /*
     * metodo che permette di inserire i dati di un utente
     * @param bean il bean di utente
     * @throws SQLException
     * @throws DatiErratiEx
     */
    public void inserimento(Utente user) throws SQLException {

        PreparedStatement stmt = null;




               String sqlu = "INSERT INTO utente(username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita) VALUES(?,?,?,?,?,?,?,?,?,true)";



                stmt = (PreparedStatement) conn.prepareStatement(sqlu);
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


               System.out.println(stmt.execute());




                stmt.close();
                ConnectionPool.releaseConnection(conn);
    }


    /**
     * metodo che permette di visualizzare i dati di un utente
     * @param id
     * @return Utente l'utente visualizzato
     * @throws SQLException
     * @throws DatiErratiEx
     */
    public Utente visualizza(Integer id) throws SQLException {

        Utente utente = new Utente();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Utente WHERE idUtente = ? ";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setInt(1, id);

        rs = stmt.executeQuery(sql);

        while (rs.next()) {

            utente = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));

        }

        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(conn);

        return utente;
    }

    /**
     * metodo che permette di visualizzare i dati degli utenti per effettuare una ricerca
     * @return ArrayList<Utente> la lista degli utenti per effetturare la ricerca
     * @throws java.sql.SQLException
     */
    public ArrayList<Utente> ricerca() throws SQLException {
        ArrayList<Utente> list = this.visualizzaElenco();

        return list;
    }

    /**
     * il metodo permette di eliminare logicamente un utente
     * @param ut
     * @throws java.sql.SQLException
     */
    public void eliminaLogica(Utente ut) throws SQLException {
        /*
        PreparedStatement stmt = null;

        String sql = "UPDATE Utente SET Visible='false' where username = ?";
        // Create a statement
        stmt = (PreparedStatement) conn.prepareStatement(sql);

        // Execute the query
        stmt.executeQuery();
        stmt.close();
        ConnectionPool.releaseConnection(conn);*/
    }

    /**
     *  metodo che permette l'eliminazione di un utente
     * @param ut
     * @throws java.sql.SQLException
     */
    public void elimina(Utente ut) throws SQLException {
        /*PreparedStatement stmt = null;
        String sql = "DELETE * FROM Utente where username =?";
        // Create a statement
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, ut.getUsername());
        // Execute the query
        stmt.executeQuery(sql);

        stmt.close();

        ConnectionPool.releaseConnection(conn);*/
    }
}



