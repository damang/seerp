/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Dipendente;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Permesso;
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
public class OpDipendente extends OpPersonale {

   public OpDipendente(){
    super();
    }

    /** Metodo che permette la visualizzazione
     * della lista dei Dipendenti
     * @return ArrayList contenente la lista dei Dipendenti
     * @throws java.sql.SQLException
     */
    public ArrayList<Dipendente> elencaDipendente()throws SQLException{

        ArrayList<Dipendente> list = new ArrayList<Dipendente>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Dipendente");

            // Define the resource list
            while (rs.next()) {
                Dipendente dipendente = new Dipendente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                                                     //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti
                dipendente.setListaPermessi(this.getPermessiDipendente(rs.getInt(15))); // chiedi a Luisa
                dipendente.setListaRuoli(this.getRuoloDipendente(rs.getInt(16)));
                dipendente.setListAppuntamenti(this.getAppuntamentiDipendente(rs.getInt(19)));
                dipendente.setListContratti(this.getContrattiDipendente(rs.getInt(20)));
                list.add(dipendente);
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


     /** Metodo che permette la ricerca di un Dipendente
      * @param cognome
      * cognome del Dipendente da ricercare
      * @param ruolo
      * ruolo che il Dipendente ricopre all'interno dell'azienda
      * @return la lista dei Dipendenti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Dipendente> ricercaDipendente(String cognome, String ruolo)throws SQLException{

         ArrayList<Dipendente> list = new ArrayList<Dipendente>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Dipendente"
                                    + "where cognome ="+ cognome +"AND" + "where Ruolo="+ ruolo);

            // Define the resource list
            while (rs.next()) {
                Dipendente dipendente = new Dipendente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                                                     //Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti
                dipendente.setListaPermessi(this.getPermessiDipendente(rs.getInt(15))); // chiedi a Luisa
                dipendente.setListaRuoli(this.getRuoloDipendente(rs.getInt(16)));
                dipendente.setListAppuntamenti(this.getAppuntamentiDipendente(rs.getInt(19)));
                dipendente.setListContratti(this.getContrattiDipendente(rs.getInt(20)));

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

        throw new UnsupportedOperationException("Not supported yet.");
     }


     /** Metodo che permette di eliminare un Dipendente già esistente
      * @param user
      * user del Dipendente da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Dipendente user)throws SQLException{
         ArrayList<Dipendente> list = new ArrayList<Dipendente>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM Cliente"
                                    + "where username ="+ user);

              // Define the resource list
            while (rs.next()) {
                Dipendente dipendente = new Dipendente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                                                   //  Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti
                dipendente.setListaPermessi(this.getPermessiDipendente(rs.getInt(15))); // chiedi a Luisa
                dipendente.setListaRuoli(this.getRuoloDipendente(rs.getInt(16)));
                dipendente.setListAppuntamenti(this.getAppuntamentiDipendente(rs.getInt(19)));
                dipendente.setListContratti(this.getContrattiDipendente(rs.getInt(20)));

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


     /** Nasconde il Dipendente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user del Dipendente da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Dipendente user)throws SQLException{

          ArrayList<Dipendente> list = new ArrayList<Dipendente>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("UPDATE Dipendente SET Visible='f'"
                                    + "where username ="+ user);
                  // Define the resource list
            while (rs.next()) {
                Dipendente dipendente = new Dipendente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                                                   //  Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti
                dipendente.setListaPermessi(this.getPermessiDipendente(rs.getInt(15))); // chiedi a Luisa
                dipendente.setListaRuoli(this.getRuoloDipendente(rs.getInt(16)));
                dipendente.setListAppuntamenti(this.getAppuntamentiDipendente(rs.getInt(19)));
                dipendente.setListContratti(this.getContrattiDipendente(rs.getInt(20)));

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


    /** Metodo per inserire un nuovo Dipendente
     * @param user
     * user del Dipendente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Dipendente user)throws SQLException{
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
            stmt.setString(9. user.getRuolo());
            stmt.setInt(10, user.getIdPersonale());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getTipo());
            stmt.setArrayList(15, user.getListaPermessi());
            stmt.setArrayList(16, user.getListaRuoli());
            stmt.setBoolean(17, user.getVisible());
            stmt.setInt(18, user.getIdDipendente());
            stmt.setArrayList(19, user.getListAppuntamenti());
            stmt.setArrayList(20, user.getListContratti());

 
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


    /** Metodo che permette la modifica di un Dipendente presente nel sistema
     * @param user
     * user del Dipendente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Dipendente modifica(Dipendente user)throws SQLException{

        ArrayList<BeanGuiDipendente> list = new ArrayList<BeanGuiDipendente>();
        Connection con = null;
        PreparedStatement stmt = null;


        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();


            // Create a statement
            stmt = con.prepareStatement("UPDATE Dipendente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idDipendente="+ user.getIdDipendente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getProvincia());
            stmt.setString(6, user.getTelefono());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getNote());
            stmt.setString(9. user.getRuolo());
            stmt.setInt(10, user.getIdPersonale());
            stmt.setString(11, user.getCognome());
            stmt.setString(12, user.getNome());
            stmt.setString(13, user.getCodiceFiscale());
            stmt.setString(14, user.getTipo());
            stmt.setArrayList(15, user.getListaPermessi());
            stmt.setArrayList(16, user.getListaRuoli());
            stmt.setBoolean(17, user.getVisible());
            stmt.setInt(18, user.getIdDipendente());
            stmt.setArrayList(19, user.getListAppuntamenti());
            stmt.setArrayList(20, user.getListContratti());
            stmt.execute();
                            // Force the commit
            con.commit();
            dipendente = this.visualizza(user.getIdUtente());

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
      return dipendente;
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Dipendente
     * @param id
     * id del Dipendente
     * @return il bean con i dettagli del Dipendente
     * @throws java.sql.SQLException
     */
    public Dipendente visualizzaDati(Integer id) throws SQLException{

         Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Dipendente where idUtente=" + id);

            // Define the resource list
            while (rs.next()) {
                 Dipendente dipendente = new Dipendente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getBoolean(17), rs.getInt(18) );
                                                   //  Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti
                dipendente.setListaPermessi(this.getPermessiDipendente(rs.getInt(15))); // chiedi a Luisa
                dipendente.setListaRuoli(this.getRuoloDipendente(rs.getInt(16)));
                dipendente.setListAppuntamenti(this.getAppuntamentiDipendente(rs.getInt(19)));
                dipendente.setListContratti(this.getContrattiDipendente(rs.getInt(20)));

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


        return dipendente;




        throw new UnsupportedOperationException("Not supported yet.");}

 /**
     * metodo che si occupa di ricercare tutti gli appuntamenti legati ad un dipendente grazie all'id del cliente
     * @param id identificativo del dipendente
     * @return lista degli appuntamenti associati al dipendente
     * @throws java.sql.SQLException
     */
    public ArrayList<Appuntamento> getAppuntamentiDipendente(Integer id) throws SQLException {

        ArrayList<Appuntamento> list = new ArrayList<Appuntamento>();
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
                    "  from dipendente, appuntamentoAssociato, appuntamento" + " where idDipendente=dipendente " + "and appuntamento=idAppuntamento;" + "and idDipendente=" + id);

            while (rs.next()) {
                Appuntamento appuntamento = new Appuntamento(rs.getDate(1), rs.getTime(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7));
                // Date data, Time ora, Integer idAppuntamento, String note, Integer dipendente, Integer extraAzienda, Boolean notifica
                list.add(appuntamento);
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

/**
     * metodo che si occupa di ricercare tutti i contratti legati ad un dipendente grazie all'id del cliente
     * @param id identificativo del dipendente
     * @return lista dei contratti associati al dipendente
     * @throws java.sql.SQLException
     */
    public ArrayList<Contratto> getContrattiDipendente(Integer id) throws SQLException {

        ArrayList<Contratto> list = new ArrayList<Contratto>();
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
                    "  from dipendente, contrattoAssociato, contratto" + " where idDipendente=dipendente " + "and contratto=idContratto;" + "and idDipendente=" + id);

            while (rs.next()) {
                Contratto contratto = new Contratto(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8));

                contratto.setListPagamento(this.getPagamentiContratto(rs.getInt(9)));
                contratto.setListServizio(this.getServizioContratto(rs.getInt(10)));
                list.add(contratto);
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

     /**
     * metodo che si occupa di ricercare tutti i permessi legati ad un dipendente grazie all'id del responsabile
     * @param id identificativo del dipendente
     * @return lista dei permessi associati al dipendente
     * @throws java.sql.SQLException
     */
    public ArrayList<Permesso> getPermessiDipendente(Integer id) throws SQLException {

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
                    "  from dipendente, permessoAssociato, permesso" + " where idDipendente=dipendente " + "and permesso=idPermesso;" + "and idDipendente=" + id);

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

 public ArrayList<Ruolo> getRuoloDipendente(Integer id) throws SQLException {

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
                    "  from dipendente, ruoloAssociato, ruolo" + " where idDipendente=dipendente " + "and ruolo=idRuolo;" + "and idDipendente=" + id);

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
