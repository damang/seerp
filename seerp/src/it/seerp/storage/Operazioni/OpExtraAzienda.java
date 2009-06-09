/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.ExtraAzienda;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author LuNy
 */
public class OpExtraAzienda extends OpeUtente {

     public OpExtraAzienda(){
    super();
    }

     /** Metodo che permette la visualizzazione della lista del personale ExtraAzienda
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException
     */
    public ArrayList<ExtraAzienda> elencaExtraAzienda()throws SQLException{

        ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM ExtraAzienda");

            // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                          // Integer idUtente, String username, String password, String città, String ruol,String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti)
                extraazienda.setListAppuntamenti(this.getAppuntamentiExtraAzienda(rs.getInt(18))); // chiedi a Luisa
                extraazienda.setListContratti(this.getContrattiExtraAzienda(rs.getInt(19)));
                list.add(extraazienda);
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


     /** Metodo che permette la ricerca di un membro del personale ExtraAzienda
      * @param cognome
      * cognome del membro del personale da ricercare
      * @param ruolo
      * ruolo che il membro del personale ricopre all'interno dell'azienda
      * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<ExtraAzienda> ricercaExtraAzienda(String cognome, String ruolo)throws SQLException{

         ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM ExtraAzienda"
                                    + "where cognome ="+ cognome +"AND" + "where ruolo="+ ruolo);

            // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                          // Integer idUtente, String username, String password, String città, String ruol,String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti)
                extraazienda.setListAppuntamenti(this.getAppuntamentiExtraAzienda(rs.getInt(18))); // chiedi a Luisa
                extraazienda.setListContratti(this.getContrattiExtraAzienda(rs.getInt(19)));

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


     /** Metodo che permette di eliminare un membro del personale ExtraAzienda già esistente
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(ExtraAzienda user)throws SQLException{

         ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM ExtraAzienda"
                                    + "where username ="+ user);

              // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                          // Integer idUtente, String username, String password, String città, String ruol,String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti)
                extraazienda.setListAppuntamenti(this.getAppuntamentiExtraAzienda(rs.getInt(18))); // chiedi a Luisa
                extraazienda.setListContratti(this.getContrattiExtraAzienda(rs.getInt(19)));


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


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(ExtraAzienda user)throws SQLException{

          ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("UPDATE Cliente SET Visible='f'"
                                    + "where username ="+ user);
                  // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                          // Integer idUtente, String username, String password, String città, String ruol,String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti)
                extraazienda.setListAppuntamenti(this.getAppuntamentiExtraAzienda(rs.getInt(18))); // chiedi a Luisa
                extraazienda.setListContratti(this.getContrattiExtraAzienda(rs.getInt(19)));

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


    /** Metodo per inserire un nuovo membro del personale ExtraAzienda
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(ExtraAzienda user)throws SQLException{
         Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement ("INSERT INTO ExtraAzienda VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getRuolo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getRuolo());
            stmt.setString(10, user.getNote());
            stmt.setBoolean(11, user.getVisible());
            stmt.setInt(12, user.getIdExtraAzienda());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());
            stmt.setArrayList(18, user.getListAppuntamenti());
            stmt.setArrayList(19, user.getListContratti());

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


    /** Metodo che permette la modifica di un membro del personale ExtraAzienda presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public ExtraAzienda modifica(ExtraAzienda user)throws SQLException{
        ArrayList<BeanGuiExtraAzienda> list = new ArrayList<BeanGuiExtraAzienda>();
        Connection con = null;
        PreparedStatement stmt = null;
        
       
        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();

           
            // Create a statement
            stmt = con.prepareStatement("UPDATE Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idUtente="+ user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getRuolo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getRuolo());
            stmt.setString(10, user.getNote());
            stmt.setBoolean(11, user.getVisible());
            stmt.setInt(12, user.getIdExtraAzienda());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());
            stmt.setArrayList(18, user.getListAppuntamenti());
            stmt.setArrayList(19, user.getListContratti());
            
            stmt.execute();
                            // Force the commit
            con.commit();
            extraazienda= this.visualizza(user.getIdUtente());

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
      return extraazienda;

        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale ExtraAzienda
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException
     */
    public ExtraAzienda visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM ExtraAzienda" +
                    "where idUtente= " + id);

            // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                          // Integer idUtente, String username, String password, String città, String ruol,String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti)
                extraazienda.setListAppuntamenti(this.getAppuntamentiExtraAzienda(rs.getInt(18))); // chiedi a Luisa
                extraazienda.setListContratti(this.getContrattiExtraAzienda(rs.getInt(19)));

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


        return extraazienda;

        throw new UnsupportedOperationException("Not supported yet.");}

     /**
     * metodo che si occupa di ricercare tutti gli appuntamenti legati ad un cliente grazie all'id del cliente
     * @param id identificativo del cliente
     * @return lista degli appuntamenti associati al cliente
     * @throws java.sql.SQLException
     */
    public ArrayList<Appuntamento> getAppuntamentiExtraAzienda(Integer id) throws SQLException {

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
                    "  from extraazienda, appuntamentoAssociato, appuntamento" + " where idExtraAzienda=extraazienda " + "and appuntamento=idAppuntamento;" + "and idExtraAzienda=" + id);

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
     * metodo che si occupa di ricercare tutti i contratti legati ad un ExtraAzienda grazie all'id dell'ExtraAzienda
     * @param id identificativo del cliente
     * @return lista dei contratti associati al cliente
     * @throws java.sql.SQLException
     */
    public ArrayList<Contratto> getContrattiExtraAzienda(Integer id) throws SQLException {

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
                    "  from ExtraAzienda, contrattoAssociato, contratto" + " where idExtraAzienda=extraazienda " + "and contratto=idContratto;" + "and idExtraAzienda=" + id);

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


}
