
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Cliente;
import java.util.ArrayList;
import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LuNy
 */
public class OpCliente extends OpExtraAzienda {

    public OpCliente(){
    super();
    }


    /** Metodo che permette la visualizzazione della lista dei Clienti
     * @return ArrayList contenente la lista dei Clienti
     * @throws java.sql.SQLException

    public ArrayList<Cliente> elencaCliente()throws SQLException{
        ArrayList<Cliente> list = new ArrayList<Cliente>();
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
                Cliente cliente = new Cliente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getBoolean(17) );
                                   
                cliente.setListAppuntamenti(this.getAppuntamentiCliente(rs.getInt(18))); // chiedi a Luisa
                cliente.setListContratti(this.getContrattiCliente(rs.getInt(19)));
                list.add(cliente);
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
      * @param cognome
      * cognome del Cliente da ricercare
      * @param ruolo
      * ruolo che il Cliente ricopre all'interno dell'azienda
      * @return la lista dei Clienti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
  
     public  ArrayList<Cliente> ricercaCliente(String cognome, String nome)throws SQLException{
         
             ArrayList<Cliente> list = new ArrayList<Cliente>();
             Connection con = null;
             Statement stmt = null;
             ResultSet rs = null;
             
            try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Cliente"
                                    + "where cognome ="+ cognome +"AND" + "where nome="+ nome);
 
            // Define the resource list
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getBoolean(17) );
               
                cliente.setListAppuntamenti(this.getAppuntamentiCliente(rs.getInt(18))); // chiedi a Luisa
                cliente.setListContratti(this.getContrattiCliente(rs.getInt(19)));
               
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


     /** Metodo che permette di eliminare un Cliente già esistente
      * @param user
      * user del Cliente da eliminare
      * @throws java.sql.SQLException
   

     public void elimina(String user)throws SQLException{

         ArrayList<Cliente> list = new ArrayList<Cliente>();
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
                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getBoolean(17) );

                cliente.setListAppuntamenti(this.getAppuntamentiCliente(rs.getInt(18))); // chiedi a Luisa
                cliente.setListContratti(this.getContrattiCliente(rs.getInt(19)));

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
      * user del Cliente da eliminare
      * @throws java.sql.SQLException
 
     public void eliminazioneLogica(Cliente user)throws SQLException{

         ArrayList<Cliente> list = new ArrayList<Cliente>();
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
                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getBoolean(17) );

                cliente.setListAppuntamenti(this.getAppuntamentiCliente(rs.getInt(18))); // chiedi a Luisa
                cliente.setListContratti(this.getContrattiCliente(rs.getInt(19)));

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


    /** Metodo per inserire un nuovo Cliente
     * @param user
     * user del Cliente da inserire
     * @throws java.sql.SQLException
 
    public void inserisci(Cliente user)throws SQLException{

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
     
            stmt.setInt(9, user.getIdExtraAzienda());
            stmt.setString(10, user.getCognome());
            stmt.setString(11, user.getNome());
            stmt.setString(12, user.getRagioneSociale());
            stmt.setString(13, user.getPIva());
            stmt.setString(14, user.getFax());
            stmt.setString(15, user.getRuolo());
            stmt.setArrayList(16, user.getListAppuntamenti());
            stmt.setArrayList(17, user.getListContratti());
            stmt.setInt(18, user.getIdCliente());


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


    /** Metodo che permette la modifica di un Cliente presente nel sistema
     * @param user
     * user del Cliente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
  
    public Cliente modifica(Cliente user)throws SQLException{

        ArrayList<BeanGuiCliente> list = new ArrayList<BeanGuiCliente>();
        Connection con = null;
        PreparedStatement stmt = null;
        Cliente cliente = null;
       
        try {
             // Obtain a db connection
            con = ConnectionPool.getConnection();

           
            // Create a statement
            stmt = con.prepareStatement("UPDATE Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )"  +"where idUtente="+ user.getIdUtente());

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
            stmt.setArrayList(16, user.getListAppuntamenti());
            stmt.setArrayList(17, user.getListContratti());
            stmt.setInt(18, user.getIdCliente());

            stmt.execute();
                            // Force the commit
            con.commit();
            cliente= this.visualizza(user.getIdUtente());

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
      return cliente;
    

        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Cliente
     * @param id
     * id del Cliente
     * @return il bean con i dettagli del Cliente
     * @throws java.sql.SQLException
   
    public Cliente visualizzaDati(Integer id) throws SQLException{

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

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
                cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getBoolean(17) );

                cliente.setListAppuntamenti(this.getAppuntamentiCliente(rs.getInt(18))); // chiedi a Luisa
                cliente.setListContratti(this.getContrattiCliente(rs.getInt(19)));

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

        return cliente;

        throw new UnsupportedOperationException("Not supported yet.");}


    /**
     * metodo che si occupa di ricercare tutti gli appuntamenti legati ad un cliente grazie all'id del cliente
     * @param id identificativo del cliente
     * @return lista degli appuntamenti associati al cliente
     * @throws java.sql.SQLException
 
    public ArrayList<Appuntamento> getAppuntamentiCliente(Integer id) throws SQLException {

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
                    "  from cliente, appuntamentoAssociato, appuntamento" + " where idCliente=cliente " + "and appuntamento=idAppuntamento;" + "and idCliente=" + id);

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

    public ArrayList<Contratto> getContrattiCliente(Integer id) throws SQLException {

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
                    "  from cliente, contrattoAssociato, contratto" + " where idCliente=cliente " + "and contratto=idContratto;" + "and idCliente=" + id);

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
*/
}
