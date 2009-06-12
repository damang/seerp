/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;


import it.seerp.storage.ejb.Personale;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/** Classe riguardante la gestione Personale
 *
 * @author LuNy
 */
public class OpPersonale extends OpeUtente {
    
    public OpPersonale(){
    super();
    }

  
    /** Metodo che permette la visualizzazione
     * della lista del Personale
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException*/
 
    public ArrayList<Personale> elencaPersonale()throws SQLException{

        ArrayList<Personale> list = new ArrayList<Personale>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Cliente");

            // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17) );
                                               //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email,        String note, String ruolo,   Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v
                personale.setListaPermessi(this.getPermessiPersonale(rs.getInt(15))); // chiedi a Luisa
                personale.setListaRuoli(this.getRuoliPersonale(rs.getInt(16)));
                list.add(personale);
            }}

        catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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

        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un membro del personale
      * @param cognome
      * cognome del membro del personale da ricercare
      * @param ruolo
      * ruolo che il membro del personale ricopre all'interno dell'azienda
      * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException*/
     
     public  ArrayList<Personale> ricercaPersonale(String cognome, String ruolo)throws SQLException{
         ArrayList<Personale> list = new ArrayList<Personale>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Personale"
                                    + "where cognome ="+ cognome +"AND" + "where ruolo="+ ruolo);

            // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17) );
                                               //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email,        String note, String ruolo,   Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v
                personale.setListaPermessi(this.getPermessiPersonale(rs.getInt(15))); // chiedi a Luisa
                personale.setListaRuoli(this.getRuoliPersonale(rs.getInt(16)));

            }}

              catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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

     public void elimina(Personale user)throws SQLException{

         ArrayList<Personale> list = new ArrayList<Personale>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM Personale"
                                    + "where username ="+ user);

              // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17) );
                                               //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email,        String note, String ruolo,   Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v
                personale.setListaPermessi(this.getPermessiPersonale(rs.getInt(15))); // chiedi a Luisa
                personale.setListaRuoli(this.getRuoliPersonale(rs.getInt(16)));
            }}

              catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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
       
        }


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException*/

     public void eliminazioneLogica(Personale user)throws SQLException{
         ArrayList<Personale> list = new ArrayList<Personale>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("UPDATE Personale SET Visible='f'"
                                    + "where username ="+ user);
                  // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17) );
                                               //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email,        String note, String ruolo,   Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v
                personale.setListaPermessi(this.getPermessiPersonale(rs.getInt(15))); // chiedi a Luisa
                personale.setListaRuoli(this.getRuoliPersonale(rs.getInt(16)));
            }}

              catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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
       


        }


    /** Metodo per inserire un nuovo membro del personale
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException*/
 
    public void inserisci(Personale user)throws SQLException{

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement ("INSERT INTO Personale (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getNote());
            stmt.setString(9, user.getRuolo());
            stmt.setInt(10, user.getIdPersonale());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getTipo());
            stmt.setArrayList(15, user.getListaPermessi());
            stmt.setArrayList(16, user.getListaRuoli());
            stmt.setBoolean(17, user.getVisible());


            stmt.execute();

            con.commit();
    }
         catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un membro del personale presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/

    public Personale modifica(Personale user)throws SQLException{

        ArrayList<BeanGuiPersonale> list = new ArrayList<BeanGuiPersonale>();
        Connection con = null;
        PreparedStatement stmt = null;
        Personale personale = null;

        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();


            // Create a statement
            stmt = con.prepareStatement("UPDATE Personale VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idUtente="+ user.getIdUtente());

             stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getNote());
            stmt.setString(9, user.getRuolo());
            stmt.setInt(10, user.getIdPersonale());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getTipo());
            stmt.setArrayList(15, user.getListaPermessi());
            stmt.setArrayList(16, user.getListaRuoli());
            stmt.setBoolean(17, user.getVisible());

            stmt.execute();
                            // Force the commit
            con.commit();
            personale = this.visualizza(user.getIdUtente());

        } // Force the commit
        catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
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

    public Personale visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Cliente" +
                    "where idUtente= " + id);

            // Define the resource list
            while (rs.next()) {
                Personale personale = new Personale (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17) );
                                               //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email,        String note, String ruolo,   Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v
                personale.setListaPermessi(this.getPermessiPersonale(rs.getInt(15))); // chiedi a Luisa
                personale.setListaRuoli(this.getRuoliPersonale(rs.getInt(16)));

            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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

    public ArrayList<Permesso> getPermessiPersonale(Integer id) throws SQLException {

        ArrayList<Permesso> list = new ArrayList<Permesso>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query

            rs = stmt.executeQuery("select *" +
                    "  from personale, permessoAssociato, permesso" + " where idPersonale=personale" + "and permesso=idPermesso" + "and idPersonale=" + id);
           


            while (rs.next()) {
                Permesso permesso = new Permesso(rs.getInt(1), rs.getString(2));
                // Date data, Time ora, Integer idAppuntamento, String note, Integer dipendente, Integer extraAzienda, Boolean notifica
                permesso.setListPersonale(this.getPersonalePermessi(rs.getInt(3)));
                permesso.setListRuolo(this,getRuoloPermessi(rs.getInt(4)));
                list.add(permesso);
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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

    public ArrayList<Ruolo> getRuoloPersonale(Integer id) throws SQLException {

        ArrayList<Ruolo> list = new ArrayList<Ruolo>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("select *" +
                    "  from personale, ruoloAssociato, ruolo" + " where idPersonale=personale " + "and ruolo=idRuolo;" + "and idPersonale=" + id);

            while (rs.next()) {
                Ruolo ruolo = new Ruolo(rs.getInt(1), rs.getString(2));

                ruolo.setListPersonale(this.getPersonaleRuolo(rs.getInt(3)));
                ruolo.setListPermessi(this.getPermessiRuolo(rs.getInt(4)));
                list.add(ruolo);
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }

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