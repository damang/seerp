/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Banca;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiBanca;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author LuNy
 */
public class OpBanca {
     public OpBanca(){
    super();
    }
     
     
     /** Metodo che permette la visualizzazione della lista delle banche
     * @return ArrayList contenente la lista delle banche
     * @throws java.sql.SQLException
     */
    public ArrayList<Banca> elencaBanca()throws SQLException{
        ArrayList<Banca> list = new ArrayList<Banca>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Banca");

            // Define the resource list
            while (rs.next()) {
                Banca banca = new Banca (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11));
                                    //(1String stato, 2Date data, 3Integer durata, 4String tipo, 5String note, 6Integer dipendente, Integer extraAzienda)
                banca.getListPagamento(this.setListPagamento(rs.getArrayList(12))); // chiedi a Luisa
                
                list.add(banca);
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


     /** Metodo che permette la ricerca di un Cliente
      * @param agenzia
      * cognome del Cliente da ricercare
      * @param città
      * ruolo che il Cliente ricopre all'interno dell'azienda
      * @return la lista dei Clienti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Banca> ricercaBanca(String agenzia, String città)throws SQLException{

         ArrayList<Banca> list = new ArrayList<Banca>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Banca"
                                    + "where Agenzia ="+ agenzia +"AND" + "where Città="+ città);

            // Define the resource list
            while (rs.next()) {
                Banca banca = new Banca (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11));
                                    //(1String stato, 2Date data, 3Integer durata, 4String tipo, 5String note, 6Integer dipendente, Integer extraAzienda)
                banca.getListPagamento(this.setListPagamento(rs.getArrayList(12)));
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



     /** Metodo che permette di eliminare una Banca già esistente
      * @param agenzia
      * user della Banca da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Banca id)throws SQLException{

          ArrayList<Banca> list = new ArrayList<Banca>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;

            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("DELETE * FROM Banca"
                                    + "where idBanca ="+ id);

              // Define the resource list
            while (rs.next()) {
                Banca banca = new Banca (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11));
                                    //(1String stato, 2Date data, 3Integer durata, 4String tipo, 5String note, 6Integer dipendente, Integer extraAzienda)
                banca.getListPagamento(this.setListPagamento(rs.getArrayList(12)));

            }
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



    /** Metodo per inserire un nuova Banca
     * @param agenzia
     * user del Cliente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Banca agenzia)throws SQLException{


        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Banca VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, agenzia.getAgenzia());
            stmt.setString(2, agenzia.getAbi());
            stmt.setString(3, agenzia.getCab());
            stmt.setString(4, agenzia.getCittà());
            stmt.setString(5, agenzia.getProvincia());
            stmt.setString(6, agenzia.getIndirizzo());
            stmt.setString(7, agenzia.getCap());
            stmt.setString(8, agenzia.getFiliale());
            stmt.setString(9, agenzia.getNazione());
            stmt.setDouble(10, agenzia.getImportoInDare());
            stmt.setDouble(11, agenzia.getImportoInAvere());
            stmt.setArrayList(12, agenzia.getListPagamento());
           
          

            stmt.execute();

            conn.commit();
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
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        } throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di una Banca presente nel sistema
     * @param idBanca
     * identificativo della banca da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Banca modifica(Banca id)throws SQLException{

        ArrayList<BeanGuiBanca> list = new ArrayList<BeanGuiBanca>();
        Connection con = null;
       
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            PreparedStatement stmt = null;
            // Create a statement
            stmt = con.prepareStatement("UPDATE Banca VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"+"where idBanca="+ id);
            stmt.setString(1, id.getAgenzia());
            stmt.setString(2, id.getAbi());
            stmt.setString(3, id.getCab());
            stmt.setString(4, id.getCittà());
            stmt.setString(5, id.getProvincia());
            stmt.setString(6, id.getIndirizzo());
            stmt.setString(7, id.getCap());
            stmt.setString(8, id.getFiliale());
            stmt.setString(9, id.getNazione());
            stmt.setDouble(10, id.getImportoInDare());
            stmt.setDouble(11, id.getImportoInAvere());
            stmt.setArrayList(12, id.getListPagamento());
           
        } finally {

            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }

        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di una Banca
     * @param id
     * id della Banca
     * @return il bean con i dettagli della  Banca
     * @throws java.sql.SQLException
     */
    public Banca visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Banca" +
                    "where idBanca= " + id);

            // Define the resource list
            while (rs.next()) {
                Banca banca = new Banca (rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11));
                                    //(1String stato, 2Date data, 3Integer durata, 4String tipo, 5String note, 6Integer dipendente, Integer extraAzienda)
                banca.setListPagamento(this.getPagamentoBanca(rs.getArrayList(12)));


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


        return banca;


    }
        


 /**
     * metodo che si occupa di ricercare tutti i pagamenti legati ad una banca grazie all'id della banca
     * @param id identificativo della banca
     * @return lista dei appuntamenti associati al cliente
     * @throws java.sql.SQLException
     */
    public ArrayList<Pagamento> getPagamentoBanca(Integer id) throws SQLException {

        ArrayList<Pagamento> list = new ArrayList<Pagamento>();
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
                    "  from banca, pagamentoAssociato, pagamento" + " where idBanca=banca " + "and pagamento=idPagamento;" + "and idBanca=" + id);

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getDouble(4), rs.getString5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                                                  // String note, Date dataScadenza, String descrizione, Double importo, String modalitaPagamento, String stato, String altreInformazioni, Integer idPagamento, Integer contratto, Integer banca
                list.add(pagamento);
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
