/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.Operazioni;

import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Servizio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public class OpeContratto implements OpeEntity<Contratto> {

    public void inserimento(Contratto contratto) throws SQLException {
  
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            stmt = con.prepareStatement("INSERT INTO Contratto VALUES (?, ?, ?, ?, ?, ? )");
            stmt.setInt(1, contratto.getDurata());
            stmt.setDate(2, contratto.getData());
            stmt.setString(3, contratto.getTipo());
            stmt.setString(4, contratto.getNote());
            stmt.setInt(5, contratto.getDipendente());
            stmt.setInt(6, contratto.getExtraAzienda());

            stmt.execute();




            // Force the commit
            con.commit();
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
    }

    public ArrayList<Contratto> visualizzaElenco() throws SQLException {
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
            rs = stmt.executeQuery("SELECT * FROM Contratto");

            // Define the resource list
            while (rs.next()) {
                Contratto contratto = new Contratto (rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                                    //(1String stato, 2Date data, 3Integer durata, 4String tipo, 5String note, 6Integer dipendente, Integer extraAzienda)
                contratto.setListPagamento(this.getPagamentiContratto(rs.getInt(8)));
                contratto.setListServizio(this.getServizioContratto(rs.getInt(9)));
                list.add(contratto);
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




    }
     //finire modifica
    public Contratto modifica(Contratto contratto) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet.");
        ArrayList<BeanGuiContratto> list = new ArrayList<BeanGuiContratto>();
        Connection con = null;
       

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            PreparedStatement stmt = null;
            // Create a statement
            stmt = con.prepareStatement("UPDATE Contratto VALUES (?, ?, ?, ?, ?, ? )");
            stmt.setInt(1, contratto.getDurata());
            stmt.setDate(2, contratto.getData());
            stmt.setString(3, contratto.getTipo());
            stmt.setString(4, contratto.getNote());
            stmt.setInt(5, contratto.getDipendente());
            stmt.setInt(6, contratto.getExtraAzienda());
          

        } finally {
         
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }

    }

    public Contratto visualizza(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Servizio> getServizioContratto(Integer id) throws SQLException {

        ArrayList<Servizio> list = new ArrayList<Servizio>();
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
                    "  from contratto, servizioAssociato, servizio" + " where idContratto=contratto "
                    + "and servizio=idServizio;"
                    +"and idContatto="+ id);

            while (rs.next()) {
                Servizio servizio = new Servizio(rs.getString(1), rs.getBoolean(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
                //(1String descrizione, 2Boolean disponibilita, 3Integer quantita, 4String tipo,5 Double prezzo, 6Integer idServizio, 7Integer iva, 8String note)
                list.add(servizio);
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
     private ArrayList<Pagamento> getPagamentiContratto(Integer id) throws SQLException {

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
                    "  from contratto, pagamento" +
                    " where idContratto=contratto "
                    +"and idContatto="+ id);

            while (rs.next()) {
                Pagamento pag = new Pagamento(rs.getString(1), rs.getDate(2),rs.getString(3), rs.getDouble(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),rs.getInt(9),rs.getInt(10));
            // public Pagamento(1String note, 2Date dataScadenza, 3String descrizione, 4Double importo, 5String modalitaPagamento, 6String stato, 7String altreInformazioni, 8Integer idPagamento, Integer contratto, Integer banca

                list.add(pag);
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
