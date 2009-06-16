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

        String sql = "SELECT * FROM Dipendente where Visible='true'";
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

        String sql = "DELETE * FROM Dipendente where username =?";
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
     * user dell'utente da eliminare
     * @throws java.sql.SQLException
     */
    public void eliminazioneLogica(Dipendente user) throws SQLException {

        PreparedStatement stmt = null;

        String sql = "UPDATE Dipendente SET Visible='false' where username = ?";
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
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM Dipendente WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("dipendente già esistente nel database");
        } else {
            String sql = "INSERT INTO Dipendente (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            /*
             * Integer idUtente1, String username2, String password3, String città4,
            String provincia5, String telefono6, String cap7, String email8, String note9,
            String tipo10, String cognome11, String nome12, String codiceFiscale13, Ruolo ruolo14, Boolean v15
             */

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getCap());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getNote());
            stmt.setString(10, user.getTipo());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getRuolo().getNome());
            stmt.setBoolean(15, user.getVisible());
            stmt.execute();
        }
        stmt.close();
        ConnectionPool.releaseConnection(con);

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
        Dipendente dipendente = null;


        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM Dipendente WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("dipendete già esistente nel database");
        } else {

            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Dipendente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getCap());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getNote());
            stmt.setString(10, user.getTipo());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getRuolo().getNome());
            stmt.setBoolean(15, user.getVisible());

            stmt.execute();

            dipendente = this.visualizzaDati(dipendente.getIdUtente());

        }
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return dipendente;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro dei dipendendenti
     * @param id
     * id del membro dei dipendenti
     * @return il bean con i dettagli del membro del personale
     * @throws SQLException
     */
    public Dipendente visualizzaDati(Integer id) throws SQLException {
        Dipendente dipendente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        String sql = "SELECT * FROM Dipendente where idDipendente= ? ";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, id.toString());
        // Execute the query
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            dipendente = new Dipendente(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                    rs.getString(11), rs.getString(12), rs.getString(13), new Ruolo(rs.getString(14)),
                    rs.getBoolean(15));

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return dipendente;

    }
}
