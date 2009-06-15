
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
public class OpContatto extends OpExtraAzienda{

     Connection con = null;


     public OpContatto()throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }
     
      /** Metodo che permette la visualizzazione della lista dei Contatti
     * @return ArrayList contenente la lista dei Contatti
     * @throws java.sql.SQLException*/

    public ArrayList<Contatto> elencaContatto()throws SQLException{

        ArrayList<Contatto> list = new ArrayList<Contatto>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

       try {
            String sql = "SELECT * FROM Personale where Visible='true'";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);


            // Define the resource list
            while (rs.next()) {
                Contatto contatto = new Contatto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18));
       // Integer idUtente, String username, String password, String città, String ruol 5 , String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, String cognome, String nome, String ragioneSociale 15, String pIva, String fax, Integer feedback) {

                list.add(contatto);
            }}

        catch (SQLException se) {
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
        }return list;
    }

     /** Metodo che permette la ricerca di un Contatto
      * @param cognome
      * cognome del Contatto da ricercare
      * @param ruolo
      * ruolo che il Contatto ricopre all'interno dell'azienda
      * @return la lista dei Contatti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException*/
  
     public  ArrayList<Contatto> ricercaContatto(Integer id, String user)throws SQLException{

         ArrayList<Contatto> list = this.elencaContatto();

        return list;
        }


     /** Metodo che permette di eliminare un Contatto già esistente
      * @param user
      * user del Contatto da eliminare
      * @throws java.sql.SQLException*/

     public void elimina(Contatto user)throws SQLException{

         PreparedStatement stmt = null;
        try {
            String sql ="DELETE * FROM Contatto"
                                    + "where username ="+ user;

           // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            // Execute the query
            stmt.executeQuery(sql);
        } catch (SQLException se) {
             System.out.println("errore nell'eliminazione del contatto");

        } finally {
            // Release the resources
          
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }

       
     

    /** Metodo per inserire un nuovo Contatto
     * @param user
     * user del Contatto da inserire
     * @throws java.sql.SQLException*/

    public void inserisci(Contatto user)throws SQLException {

         PreparedStatement stmt = null;
        try {
           Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Contatto WHERE partitaiva='" + user.getPIva() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("contatto già esistente nel database");
            } else {
                String sql = "INSERT INTO Contatto (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             stmt = (PreparedStatement) con.prepareStatement(sql);
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
            }
        } catch (SQLException se) {
            System.out.println("errore di inserimento del contatto");

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


    /** Metodo che permette la modifica di un Contatto presente nel sistema
     * @param user
     * user del Contatto da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/

    public Contatto modifica(Contatto user)throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        Contatto contatto = null;

        try {

            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM Contatto WHERE PIva='" + user.getPIva() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("contatto già esistente nel database");
            } else {


           // Create a statement
                stmt = (PreparedStatement) con.prepareStatement("UPDATE Personale VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

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

        } }
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
      return contatto;
        }

    /** Metodo che permette la visualizzazione dei dettagli di un Contatto
     * @param id
     * id del Contatto
     * @return il bean con i dettagli del Contatto
     * @throws java.sql.SQLException*/

    public Contatto visualizzaDati(Integer id) throws SQLException{
        Contatto contatto = null;
     
        PreparedStatement stmt = null;
        ResultSet rs = null;


       try {
            String sql ="SELECT * FROM Contatto" + "where idUtente= " + id;

           // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {

                 contatto = new Contatto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18));
       // Integer idUtente, String username, String password, String città, String ruol 5, String provincia, String telefono, String cap, String email, String ruolo 10, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome 15, String ragioneSociale, String pIva, String fax, Integer idContatto, Integer feedback) {

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


        return contatto;
    }
    
}