
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Contatto;
import java.sql.SQLException;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import java.util.ArrayList;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.application.bean.BeanGuiContatto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpContatto extends OpExtraAzienda{

     public OpContatto(){
    super();
    }
     
      /** Metodo che permette la visualizzazione della lista dei Contatti
     * @return ArrayList contenente la lista dei Contatti
     * @throws java.sql.SQLException
     */
    public ArrayList<Contatto> elencaContatto()throws SQLException{

        ArrayList<Contatto> list = new ArrayList<Contatto>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Contatto");

            // Define the resource list
            while (rs.next()) {
                Contatto contatto = new Contatto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(20), rs.getInt(21));
                                   //          (Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
                contatto.setListAppuntamenti(this.getAppuntamentiContatto(rs.getInt(18))); // chiedi a Luisa
                contatto.setListContratti(this.getContrattiContatto(rs.getInt(19)));
                list.add(contatto);
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


     /** Metodo che permette la ricerca di un Contatto
      * @param cognome
      * cognome del Contatto da ricercare
      * @param ruolo
      * ruolo che il Contatto ricopre all'interno dell'azienda
      * @return la lista dei Contatti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Contatto> ricercaContatto(Integer id, String user)throws SQLException{

         ArrayList<Contatto> list = new ArrayList<Contatto>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Contatto"
                                    + "where IdUtente ="+ id +"AND" + "where Username="+ user);

            // Define the resource list
            while (rs.next()) {
                Contatto contatto = new Contatto (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(20), rs.getInt(21));
                                   //          (Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
                contatto.setListAppuntamenti(this.getAppuntamentiContatto(rs.getInt(18))); // chiedi a Luisa
                contatto.setListContratti(this.getContrattiContatto(rs.getInt(19)));

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


     /** Metodo che permette di eliminare un Contatto già esistente
      * @param user
      * user del Contatto da eliminare
      * @throws java.sql.SQLException
      */
     public ArrayList<Contatto> elimina(Contatto user)throws SQLException{

          ArrayList<Contatto> list = new ArrayList<Contatto>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM Contatto"
                                    + "where username ="+ user);

              // Define the resource list
            while (rs.next()) {
                Contatto contatto = new Contatto (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(20), rs.getInt(21));
                                   //          (Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
                contatto.setListAppuntamenti(this.getAppuntamentiContatto(rs.getInt(18))); // chiedi a Luisa
                contatto.setListContratti(this.getContrattiContatto(rs.getInt(19)));

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

    /** Metodo per inserire un nuovo Contatto
     * @param user
     * user del Contatto da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Contatto user)throws SQLException{

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement ("INSERT INTO Contatto VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                       //(Integer idUtente, String username, String password, String città, String ruolo, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
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
            stmt.setInt(20, user.getFeedback());


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


    /** Metodo che permette la modifica di un Contatto presente nel sistema
     * @param user
     * user del Contatto da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Contatto modifica(Contatto user)throws SQLException{

        ArrayList<BeanGuiContatto> list = new ArrayList<BeanGuiContatto>();
        Connection con = null;
        PreparedStatement stmt = null;


        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();

            // Create a statement
            stmt = con.prepareStatement("UPDATE Contatto VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"  +"where idUtente="+ user.getIdUtente());
           //(Integer idUtente, String username, String password, String città, String ruolo, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
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
            stmt.setInt(20, user.getFeedback());


            stmt.execute();
                            // Force the commit
            con.commit();
             contatto = this.visualizza(user.getIdUtente());

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
      return contatto;
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Contatto
     * @param id
     * id del Contatto
     * @return il bean con i dettagli del Contatto
     * @throws java.sql.SQLException
     */
    public Contatto visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Contatto" +
                    "where idUtente= " + id);

            // Define the resource list
            while (rs.next()) {
                Contatto contatto = new Contatto (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(20), rs.getInt(21));
                                   //          (Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idContatto, Integer feedback)
                contatto.setListAppuntamenti(this.getAppuntamentiContatto(rs.getInt(18))); // chiedi a Luisa
                contatto.setListContratti(this.getContrattiContatto(rs.getInt(19)));

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


        return contatto;
    }

        throw new UnsupportedOperationException("Not supported yet.");

    }

    public ArrayList<Appuntamento> getAppuntamentiContatto(Integer id) throws SQLException {

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
                    "  from contatto, appuntamentoAssociato, appuntamento" + " where idContatto=contatto " + "and appuntamento=idAppuntamento;" + "and idContatto=" + id);

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

     public ArrayList<Contratto> getContrattiContatto(Integer id) throws SQLException {

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
                    "  from contatto, contrattoAssociato, contratto" + " where idContatto=contatto " + "and contratto=idContratto;" + "and idContatto=" + id);

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

