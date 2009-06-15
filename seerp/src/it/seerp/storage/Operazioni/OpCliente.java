package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;


import it.seerp.storage.ejb.Cliente;
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
public class OpCliente extends OpExtraAzienda {

    Connection con = null;

    public OpCliente() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione della lista dei Clienti
     * @return ArrayList contenente la lista dei Clienti
     * @throws java.sql.SQLException*/
    public ArrayList<Cliente> elencaCliente() throws SQLException {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Cliente where Visible='true'";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));
// Integer idUtente, String username, String password, String città, String ruol 5, String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome 15, String ragioneSociale, String pIva, String fax, Integer idCliente) {

                list.add(cliente);
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

    
    

     /** Metodo che permette la ricerca di un Cliente
      * @param cognome
      * cognome del Cliente da ricercare
      * @param ruolo
      * ruolo che il Cliente ricopre all'interno dell'azienda
      * @return la lista dei Clienti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException*/
  
     public  ArrayList<Cliente> ricercaCliente(String cognome, String ruolo)throws SQLException{
         
             ArrayList<Cliente> list = this.elencaCliente();

        return list;
        
    }

    /** Metodo che permette di eliminare un Cliente già esistente
     * @param user
     * user del Cliente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Cliente user) throws SQLException {

        PreparedStatement stmt = null;
        try {
            String sql = "DELETE * FROM Cliente" + "where username =" + user;

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
     * user del Cliente da eliminare
     * @throws java.sql.SQLException*/
    public void eliminazioneLogica(Cliente user) throws SQLException {

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE cliente SET Visible='false' where username = ?";
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

    /** Metodo per inserire un nuovo Cliente
     * @param user
     * user del Cliente da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(Cliente user) throws SQLException, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        try {
            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Cliente WHERE nome='" + user.getPIva() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("utente già esistente nel database");
            } else {
                String sql = "INSERT INTO Cliente (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                stmt.setInt(1, user.getIdUtente());
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getCittà());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getEmail());
                stmt.setString(8, user.getNote());

                stmt.setInt(9, user.getIdExtraAzienda());
                stmt.setString(10, user.getCognome());
                stmt.setString(11, user.getNome());
                stmt.setString(12, user.getRagioneSociale());
                stmt.setString(13, user.getPIva());
                stmt.setString(14, user.getFax());
                stmt.setString(15, user.getRuolo());
                stmt.setInt(16, user.getIdCliente());

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

    /** Metodo che permette la modifica di un Cliente presente nel sistema
     * @param user
     * user del Cliente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/
    public Cliente modifica(Cliente user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
        PreparedStatement stmt = null;

        Cliente cliente = null;

        try {
            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Cliente WHERE nome='" + user.getPIva() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("utente già esistente nel database");
            } else {
            }
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getNote());
            stmt.setInt(9, user.getIdExtraAzienda());
            stmt.setString(10, user.getCognome());
            stmt.setString(11, user.getNome());
            stmt.setString(12, user.getRagioneSociale());
            stmt.setString(13, user.getPIva());
            stmt.setString(14, user.getFax());
            stmt.setString(15, user.getRuolo());
            stmt.setInt(16, user.getIdCliente());

            stmt.execute();
            cliente = (Cliente) this.visualizzaDati(user.getIdCliente());

        } // Force the commit
        catch (SQLException se) {
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
        return cliente;


    }

    /** Metodo che permette la visualizzazione dei dettagli di un Cliente
     * @param id
     * id del Cliente
     * @return il bean con i dettagli del Cliente
     * @throws java.sql.SQLException*/
    public Cliente visualizzaDati(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {

            String sql = "SELECT * FROM Cliente" +
                    "where idUtente= " + id;
            // String sql = "SELECT * FROM ExtraAzienda where idUtente= ? ";

            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery();


            // Define the resource list
            while (rs.next()) {
                cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));

               
            
        }} catch (SQLException se) {
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

        return cliente;

    }
}

