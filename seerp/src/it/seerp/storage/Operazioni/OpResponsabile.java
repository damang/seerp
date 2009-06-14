package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Responsabile;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

/** Classe riguardante la gestione Personale
 *
 * @author Matteo
 */
public class OpResponsabile extends OpeUtente {

    Connection con = null;

    /**
     * costruttore per la classe
     * @throws java.sql.SQLException
     */
    public OpResponsabile() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione
     * della lista dei responsabili
     * @return ArrayList contenente la lista dei responsabili
     * @throws java.sql.SQLException*/
    public ArrayList<Responsabile> elencaResponsabile() throws SQLException {

        ArrayList<Responsabile> list = new ArrayList<Responsabile>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Responsabile where Visible='true'";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                Responsabile responsabile = new Responsabile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getBoolean(16), rs.getInt(17));
                list.add(responsabile);
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

    /** Metodo che permette la ricerca di un membro dei responsabili
     * @return la lista dei membri dei responsabili che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Responsabile> ricercaResponsabile() throws SQLException {
        ArrayList<Responsabile> list = this.elencaResponsabile();
        return list;
    }

    /** Metodo che permette di eliminare un membro dei responsabili già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Responsabile user) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE * FROM Responsabile where username =?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
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
    public void eliminazioneLogica(Responsabile user) throws SQLException {

        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Responsabile SET Visible='false' where username = ?";
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

    /** Metodo per inserire un nuovo responsabile
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Responsabile user) throws SQLException, DatiDuplicatiEx {


        PreparedStatement stmt = null;
        try {

            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Responsabile WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("responsabile già esistente nel database");
            } else {
                String sql = "INSERT INTO Responsabile (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
                stmt.setInt(17, user.getIdResponsabile());
                stmt.execute();
            }
        } catch (SQLException se) {
            System.out.println("errore di inserimento del responsabile");

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

    /** Metodo che permette la modifica di un membro dei responsabili presente nel sistema
     * @param user
     * user del membro dei responsabili da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx
     */
    public Responsabile modifica(Responsabile user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        Responsabile responsabile = null;

        try {

            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Responsabile WHERE codiceFiscale='" + user.getCodiceFiscale() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("responsabile già esistente nel database");
            } else {

                // Create a statement
                stmt = (PreparedStatement) con.prepareStatement("UPDATE Responsabile VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

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
                stmt.setInt(17, user.getIdResponsabile());

                stmt.execute();

                responsabile = (Responsabile) this.visualizzaDati(user.getIdResponsabile());

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
        return responsabile;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro dei responsabili
     * @param id
     * id del membro dei responsabili
     * @return il bean con i dettagli del membro del personale
     * @throws SQLException
     */
    public Responsabile visualizzaDati(Integer id) throws SQLException {
        Responsabile responsabile = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            String sql = "SELECT * FROM Responbile where idResponsabile= ? ";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                responsabile = new Responsabile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getBoolean(16), rs.getInt(17));

                PreparedStatement stmt1;
                String sql2 = "Select nome From Ruolo,Responsabile where idRuolo=ruolo and idResponsabile = ?";
                stmt1 = (PreparedStatement) con.prepareStatement(sql2);
                stmt1.setInt(1, responsabile.getIdResponsabile());
                ResultSet rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    Ruolo ruolo = new Ruolo(rs.getString(1));
                    responsabile.addRuolo(ruolo);
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

        return responsabile;

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

        try {
            String sql = "Select nome From Ruolo,Responsabile where idRuolo=ruolo and idResponsabile = ?";
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