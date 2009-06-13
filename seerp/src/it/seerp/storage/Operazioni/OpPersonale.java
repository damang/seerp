package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;

import it.seerp.storage.ejb.Personale;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

/** Classe riguardante la gestione Personale
 *
 * @author LuNy
 */
public class OpPersonale extends OpeUtente {

    Connection con = null;

    public OpPersonale() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione
     * della lista del Personale
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException*/
    public ArrayList<Personale> elencaPersonale() throws SQLException {

        ArrayList<Personale> list = new ArrayList<Personale>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Personale";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getBoolean(16));
                list.add(personale);
            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dell'elenco");

        } finally {
            // Release the resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        return list;
    }

    /** Metodo che permette la ricerca di un membro del personale
     * @param cognome
     * cognome del membro del personale da ricercare
     * @param ruolo
     * ruolo che il membro del personale ricopre all'interno dell'azienda
     * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Personale> ricercaPersonale(String cognome, String ruolo) throws SQLException {
        ArrayList<Personale> list = new ArrayList<Personale>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Personale where cognome = ? AND ruolo = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, cognome);
            stmt.setString(2, ruolo);
            // Execute the query
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getBoolean(16));
            }
        } catch (SQLException se) {
            System.out.println("errore nella ricerca");

        } finally {
            // Release the resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        return list;

    }

    /** Metodo che permette di eliminare un membro del personale già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Personale user) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE * FROM Personale where username =?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            // Execute the query
            stmt.executeQuery(sql);
        } catch (SQLException se) {
            System.out.println("errore nell'eliminazione del personale");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }

    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void eliminazioneLogica(Personale user) throws SQLException {

        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Personale SET Visible='false' where username = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);

            // Execute the query
            stmt.executeQuery();
        } catch (SQLException se) {
            System.out.println("errore nell'eliminazione logica dell'utente");

        } finally {
            // Release the resources

            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }



    }

    /** Metodo per inserire un nuovo membro del personale
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Personale user) throws SQLException {


        PreparedStatement stmt = null;
        try {

            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Personale WHERE nome='" + user.getCodiceFiscale() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("evento già esistente nel database");
            } else {
                String sql = "INSERT INTO Personale (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setInt(1, user.getIdUtente());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getCittà());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getEmail());
                stmt.setString(9, user.getNote());
                stmt.setString(10, user.getRuolo());
                stmt.setInt(11, user.getIdPersonale());
                stmt.setString(12, user.getCognome());
                stmt.setString(13, user.getNome());
                stmt.setString(14, user.getCodiceFiscale());
                stmt.setString(15, user.getTipo());
                stmt.setBoolean(16, user.getVisible());
                stmt.execute();
            }
        } catch (SQLException se) {
            System.out.println("errore di inserimento del personale");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
    }

    /** Metodo che permette la modifica di un membro del personale presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/
    public Personale modifica(Personale user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        Personale personale = null;

        try {

            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Personale WHERE nome='" + user.getCodiceFiscale() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("evento già esistente nel database");
            } else {

                // Create a statement
                stmt = (PreparedStatement) con.prepareStatement("UPDATE Personale VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

                stmt.setInt(1, user.getIdUtente());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getCittà());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getEmail());
                stmt.setString(9, user.getNote());
                stmt.setString(10, user.getRuolo());
                stmt.setInt(11, user.getIdPersonale());
                stmt.setString(12, user.getCognome());
                stmt.setString(13, user.getNome());
                stmt.setString(14, user.getCodiceFiscale());
                stmt.setString(15, user.getTipo());
                stmt.setBoolean(16, user.getVisible());

                stmt.execute();

                personale = this.visualizzaDati(user.getIdPersonale());

            }
        } catch (SQLException se) {
            System.out.println("errore nella modifica");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        return personale;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale*/
    public Personale visualizzaDati(Integer id) throws SQLException {
        Personale personale = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            String sql = "SELECT * FROM Cliente where idUtente= ? ";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                personale = new Personale(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getBoolean(16));

                PreparedStatement stmt1;
                String sql2 = "Select nome From Ruolo,Personale where idRuolo=ruolo and idPersonale = ?";
                stmt1 = (PreparedStatement) con.prepareStatement(sql2);
                stmt1.setInt(1, personale.getIdPersonale());
                ResultSet rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    Ruolo ruolo = new Ruolo(rs.getString(1));
                    personale.addRuolo(ruolo);
                }
            }
        } catch (SQLException se) {
            System.out.println("errore di visualizzazione");

        } finally {
            // Release the resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }

        return personale;

    }

    public ArrayList<Ruolo> getRuoloPersonale(Integer id) throws SQLException {

        ArrayList<Ruolo> list = new ArrayList<Ruolo>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
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
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dei permessi");

        } finally {
            // Release the resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        return list;
    }
}