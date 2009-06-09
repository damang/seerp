/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpResponsabile extends OpPersonale {

     public OpResponsabile(){
    super();
    }

     /** Metodo che permette la visualizzazione della lista dei Responsabili
     * @return ArrayList contenente la lista dei responsabili
     * @throws java.sql.SQLException
     */
    public ArrayList<Responsabile> elencaResponsabile()throws SQLException{

        ArrayList<Responsabile> list = new ArrayList<Responsabile>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Responsabile");

            // Define the resource list
            while (rs.next()) {
                Responsabile responsabile = new Responsabile (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                 //                                         Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo,     Integer idPersonale, String cognome, String nome, String codiceFiscale,     String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idResponsabile) {
                responsabile.setListaPermessi(this.getPermessiResponsabile(rs.getInt(15))); // chiedi a Luisa
                responsabile.setListaRuoli(this.getRuoloResponsabile(rs.getInt(16)));
                list.add(responsabile);
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



     /** Metodo che permette la ricerca di un Responsabile
      * @param cognome
      * cognome del Responsabile da ricercare
      * @param ruolo
      * ruolo che il Responsabile ricopre all'interno dell'azienda
      * @return la lista dei Responsabili che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Responsabile> ricercaResponsabile(String cognome, String ruolo)throws SQLException{

          ArrayList<Responsabile> list = new ArrayList<Responsabile>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Responsabile"
                                    + "where cognome ="+ cognome +"AND" + "where ruolo="+ ruolo);

            // Define the resource list
            while (rs.next()) {
                Responsabile responsabile = new Responsabile (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                 //                                         Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo,     Integer idPersonale, String cognome, String nome, String codiceFiscale,     String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idResponsabile) {
                responsabile.setListaPermessi(this.getPermessiResponsabile(rs.getInt(15))); // chiedi a Luisa
                responsabile.setListaRuoli(this.getRuoloResponsabile(rs.getInt(16)));
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
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Responsabile già esistente
      * @param user
      * user del Responsabile da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Responsabile user)throws SQLException{

          ArrayList<Responsabile> list = new ArrayList<Responsabile>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM Responsabile"
                                    + "where username ="+ user);

              // Define the resource list
            while (rs.next()) {
                Responsabile responsabile = new Responsabile (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                 //                                         Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo,     Integer idPersonale, String cognome, String nome, String codiceFiscale,     String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idResponsabile) {
                responsabile.setListaPermessi(this.getPermessiResponsabile(rs.getInt(15))); // chiedi a Luisa
                responsabile.setListaRuoli(this.getRuoloResponsabile(rs.getInt(16)));

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
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Responsabile
     * @param user
     * user del Responsabile da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Responsabile user)throws SQLException{

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement ("INSERT INTO Cliente VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

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
            stmt.setInt(18, user.getIdResponsabile());

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


    /** Metodo che permette la modifica di un Responsabile presente nel sistema
     * @param user
     * user del Responsabile da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Responsabile modifica(Responsabile user)throws SQLException{

        ArrayList<BeanGuiResponsabile> list = new ArrayList<BeanGuiResponsabile>();
        Connection con = null;
        PreparedStatement stmt = null;
        Responsabile responsabile = null;

        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();


            // Create a statement
            stmt = con.prepareStatement("UPDATE Responsabile VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idUtente="+ user.getIdUtente());

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
            stmt.setInt(18, user.getIdResponsabile());

            stmt.execute();
                            // Force the commit
            con.commit();
            responsabile = this.visualizza(user.getIdUtente());

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
      return responsabile;

        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Responsabile
     * @param id
     * id del Responsabile
     * @return il bean con i dettagli del Responsabile
     * @throws java.sql.SQLException
     */
    public Responsabile visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Responsabile responsabile = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Responsabile" +
                    "where idUtente= " + id);

            // Define the resource list
            while (rs.next()) {
                responsabile = new Responsabile (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                 //                                         Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo,     Integer idPersonale, String cognome, String nome, String codiceFiscale,     String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idResponsabile) {
                responsabile.setListaPermessi(this.getPermessiResponsabile(rs.getInt(15))); // chiedi a Luisa
                responsabile.setListaRuoli(this.getRuoloResponsabile(rs.getInt(16)));
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

        return responsabile;

        throw new UnsupportedOperationException("Not supported yet.");}

 /**
     * metodo che si occupa di ricercare tutti i permessi legati ad un responsabile grazie all'id del responsabile
     * @param id identificativo del responsabile
     * @return lista dei permessi associati al responsabile
     * @throws java.sql.SQLException
     */
    public ArrayList<Permesso> getPermessiResponsabile(Integer id) throws SQLException {

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
                    "  from responsabile, permessoAssociato, permesso" + " where idResponsabile=responsabile " + "and permesso=idPermesso;" + "and idResponsabile=" + id);

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

 public ArrayList<Ruolo> getRuoloResponsabile(Integer id) throws SQLException {

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
                    "  from responsabile, ruoloAssociato, ruolo" + " where idResponsabile=responsabile " + "and ruolo=idRuolo;" + "and idResponsabile=" + id);

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

