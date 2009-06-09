/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Fornitore;
import it.seerp.application.bean.BeanGuiFornitore;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpFornitore extends OpExtraAzienda {

    public OpFornitore(){
    super();
    }

    /** Metodo che permette la visualizzazione della lista dei Fornitori
     * @return ArrayList contenente la lista dei  Fornitori
     * @throws java.sql.SQLException
     */
    public ArrayList<Fornitore> elencaFornitore()throws SQLException{

         ArrayList<Fornitore> list = new ArrayList<Fornitore>();
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
                Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) , rs.getInt(20));
                                         //Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono,     String email,     String ruolo,       String note,     Boolean v,  Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva,      String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore
                fornitore.setListAppuntamenti(this.getAppuntamentiFornitore(rs.getInt(18))); // chiedi a Luisa
                fornitore.setListContratti(this.getContrattiFornitore(rs.getInt(19)));
                list.add(fornitore);
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


     /** Metodo che permette la ricerca di un Fornitore
      * @param cognome
      * cognome del Fornitore da ricercare
      * @param ruolo
      * ruolo che il Fornitore ricopre all'interno dell'azienda
      * @return la lista dei Fornitori che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Fornitore> ricercaFornitore(String cognome, String ruolo)throws SQLException{

         ArrayList<Fornitore> list = new ArrayList<Fornitore>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Fornitore"
                                    + "where cognome ="+ cognome +"AND" + "where ruolo="+ ruolo);

            // Define the resource list
            while (rs.next()) {
                Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) , rs.getInt(20));
                                         //Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono,     String email,     String ruolo,       String note,     Boolean v,  Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva,      String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore
                fornitore.setListAppuntamenti(this.getAppuntamentiFornitore(rs.getInt(18))); // chiedi a Luisa
                fornitore.setListContratti(this.getContrattiFornitore(rs.getInt(19)));

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


     /** Metodo che permette di eliminare un Fornitore già esistente
      * @param user
      * user del Fornitore da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Fornitore user)throws SQLException{

           ArrayList<Fornitore> list = new ArrayList<Fornitore>();
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
                Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) , rs.getInt(20));
                                         //Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono,     String email,     String ruolo,       String note,     Boolean v,  Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva,      String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore
                fornitore.setListAppuntamenti(this.getAppuntamentiFornitore(rs.getInt(18))); // chiedi a Luisa
                fornitore.setListContratti(this.getContrattiFornitore(rs.getInt(19)));

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
      * user del Fornitore da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Fornitore user)throws SQLException{
          ArrayList<Fornitore> list = new ArrayList<Fornitore>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("UPDATE Fornitore SET Visible='f'"
                                    + "where username ="+ user);
                  // Define the resource list
            while (rs.next()) {
                Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) , rs.getInt(20));
                                         //Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono,     String email,     String ruolo,       String note,     Boolean v,  Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva,      String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore
                fornitore.setListAppuntamenti(this.getAppuntamentiFornitore(rs.getInt(18))); // chiedi a Luisa
                fornitore.setListContratti(this.getContrattiFornitore(rs.getInt(19)));

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


    /** Metodo per inserire un nuovo Fornitore
     * @param user
     * user del Fornitore da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Fornitore user)throws SQLException{

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement ("INSERT INTO Fornitore VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


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
            stmt.setInt(20, user.getIdFornitore());


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


    /** Metodo che permette la modifica di un Fornitore presente nel sistema
     * @param user
     * user del Fornitore da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Fornitore modifica(Fornitore user)throws SQLException{

        ArrayList<BeanGuiFornitore> list = new ArrayList<BeanGuiFornitore>();
        Connection con = null;
        PreparedStatement stmt = null;


        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();


            // Create a statement
            stmt = con.prepareStatement("UPDATE Fornitore VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idUtente="+ user.getIdUtente());

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
            stmt.setInt(20, user.getIdFornitore());

            stmt.execute();
                            // Force the commit
            con.commit();
            fornitore= this.visualizza(user.getIdUtente());

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
      return fornitore;

        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Fornitore
     * @param id
     * id del Fornitore
     * @return il bean con i dettagli del Fornitore
     * @throws java.sql.SQLException
     */
    public Fornitore visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Fornitore fornitore = null;

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
                Fornitore fornitore = new Fornitore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) , rs.getInt(20));
                                         //Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono,     String email,     String ruolo,       String note,     Boolean v,  Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva,      String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore
                fornitore.setListAppuntamenti(this.getAppuntamentiFornitore(rs.getInt(18))); // chiedi a Luisa
                fornitore.setListContratti(this.getContrattiFornitore(rs.getInt(19)));
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

        return fornitore;

        throw new UnsupportedOperationException("Not supported yet.");
    }


     /**
     * metodo che si occupa di ricercare tutti gli appuntamenti legati ad un cliente grazie all'id del cliente
     * @param id identificativo del cliente
     * @return lista degli appuntamenti associati al cliente
     * @throws java.sql.SQLException
     */
    public ArrayList<Appuntamento> getAppuntamentiFornitore(Integer id) throws SQLException {

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
                    "  from fornitore, appuntamentoAssociato, appuntamento" + " where idFornitore=fornitore " + "and appuntamento=idAppuntamento;" + "and idFornitore=" + id);

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
     * metodo che si occupa di ricercare tutti i contratti legati ad un cliente grazie all'id del cliente
     * @param id identificativo del cliente
     * @return lista dei contratti associati al cliente
     * @throws java.sql.SQLException
     */
    public ArrayList<Contratto> getContrattiFornitore(Integer id) throws SQLException {

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
                    "  from fornitore, contrattoAssociato, contratto" + " where idFornitore=fornitore " + "and contratto=idContratto;" + "and idFornitore=" + id);

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
