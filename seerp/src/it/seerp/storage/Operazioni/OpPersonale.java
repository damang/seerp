package it.seerp.storage.Operazioni;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import it.seerp.storage.ejb.Personale;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;


import java.sql.ResultSet;
import java.sql.Statement;

/** Classe riguardante la gestione Personale
 *
 * @author matteo
 */
public class OpPersonale extends OpeUtente {

    Connection con = null;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpPersonale() throws SQLException {
        super();
        con = (Connection) ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione
     * della lista del Personale
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException*/
    public ArrayList<Personale> elencaPersonale() throws SQLException {

        ArrayList<Personale> list = new ArrayList<Personale>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Personale where Visible='true'";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            /*
             * Integer idUtente1, String username2, String password3, String città4,
            String provincia5, String telefono6,String cap7, String email8, String note9,
            String tipo10, String cognome11, String nome12, String codiceFiscale13, Boolean v14, String ruolo15
             */
            Personale personale = new Personale(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
                    rs.getString(13), rs.getBoolean(14), new Ruolo(rs.getString(15)));
            list.add(personale);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return list;
    }

    /** Metodo che permette la ricerca di un membro del personale
     * @param ruolo
     * ruolo che il membro del personale ricopre all'interno dell'azienda
     * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Personale> elencaPersonalePerRuolo(Ruolo ruolo) throws SQLException {
        con = (Connection) ConnectionPool.getConnection();
        ArrayList<Personale> list = new ArrayList<Personale>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM personale join utente on idPersonale=idUtente WHERE ruolo=? and visibilita=true";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, ruolo.getNome());
        rs = stmt.executeQuery();
        Personale p;
        // Define the resource list
        while (rs.next()) {
            /*
             * Integer idUtente1, String username2, String password3, String città4,
            String provincia5, String telefono6,String cap7, String email8, String note9,
            String tipo10, String cognome11, String nome12, String codiceFiscale13, Boolean v14, String ruolo15
             */
            p = new Personale();
            p.setIdUtente(rs.getInt("idPersonale"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("password"));
            p.setCap(rs.getString("cap"));
            p.setCitta(rs.getString("citta"));
            p.setCodiceFiscale(rs.getString("codicefiscale"));
            p.setCognome(rs.getString("cognome"));
            p.setEmail(rs.getString("email"));
            p.setNome(rs.getString("note"));
            p.setProvincia(rs.getString("prov"));
            p.setRuolo(new Ruolo(rs.getString("ruolo")));
            p.setTelefono(rs.getString("telefono"));
            p.setTipo(rs.getString("tipo"));
            p.setVisible(rs.getBoolean("visibilita"));
            list.add(p);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return list;
    }

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<Personale> ricercaPersonale() throws SQLException {
        ArrayList<Personale> list = this.elencaPersonale();
        return list;
    }

    /** Metodo che permette di eliminare un membro del personale già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Personale user) throws SQLException {
      /* PreparedStatement stmt = null;
        String sql = "DELETE * FROM Personale where username =?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        // Execute the query
        stmt.executeQuery(sql);
        stmt.close();
        ConnectionPool.releaseConnection(con);
    */
    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void eliminazioneLogica(Personale user) throws SQLException {
        /*
        PreparedStatement stmt = null;
        String sql = "UPDATE Personale SET Visible='false' where username = ?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);

        // Execute the query
        stmt.executeQuery();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        */
    }

    /** Metodo per inserire un nuovo membro del personale
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Personale user) throws SQLException {
        /*

        PreparedStatement stmt = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM Personale WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("personale già esistente nel database");
        } else {
            String sql = "INSERT INTO Personale (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
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
            stmt.setBoolean(14, user.getVisible());
            stmt.setString(15, user.getRuolo().getNome());

            stmt.execute();
        }
        stmt.close();
        ConnectionPool.releaseConnection(con);
         */
    }

    /** Metodo che permette la modifica di un membro del personale presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx
     */
    public Personale modifica(Personale user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
        /*
        PreparedStatement stmt = null;
        Personale personale = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM Personale WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("personale già esistente nel database");
        } else {

            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Personale VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

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
            stmt.setBoolean(14, user.getVisible());
            stmt.setString(15, user.getRuolo().getNome());

            stmt.execute();
        }
        stmt.close();
        ConnectionPool.releaseConnection(con);*/
        return null;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws SQLException
     */
    public Personale visualizzaDati(Integer id) throws SQLException {
        Personale personale = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;



        String sql = "SELECT * FROM Personale where idUtente= ? ";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, id.toString());
        // Execute the query
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            personale = new Personale(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
                    rs.getString(13), rs.getBoolean(14), new Ruolo(rs.getString(15)));

        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);



        return personale;

    }

    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<Ruolo> getRuoloPersonale(Integer id) throws SQLException {

        ArrayList<Ruolo> list = new ArrayList<Ruolo>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "Select nome From Ruolo,Personale where idRuolo=ruolo and idPersonale = ?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();

        while (rs.next()) {
            Ruolo ruolo = new Ruolo(rs.getString(1));
            list.add(ruolo);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return list;
    }
}
