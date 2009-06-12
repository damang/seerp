package it.seerp.storage.Operazioni;

import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;

import it.seerp.storage.ejb.Servizio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * la classe storage che si occupa di interfacciarsi con il dbms e compiere operazioni sui servizi
 * @author Luisa - Ila
 */
public class OpeServizio implements OpeEntity<Servizio, Integer> {

    public void inserimento(Servizio serv) throws SQLException {

        /**
         * metodo che si occupa di inserire un nuovo servizio nel database
         * @param se il unovo servizio da inserire
         * @throws java.sql.SQLException
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Servizio VALUE (?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, serv.getDescrizione());
            stmt.setBoolean(2, serv.getDisponibilita());
            stmt.setInt(3, serv.getQuantita());
            stmt.setString(4, serv.getTipo());
            stmt.setDouble(5, serv.getPrezzo());
            stmt.setInt(6, serv.getIva());
            stmt.setString(7, serv.getNote());

            stmt.executeUpdate();

            conn.commit();
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
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }

    }

    public ArrayList<Servizio> ricercaPerNome(String nome) throws SQLException {

        /**
         * metodo che si occupa di ricercare un servizio in base all'id
         * @param nome del servizio
         * @return lista di servizi che rispettano i parametri di ricerca
         * @throws java.sql.SQLException
         */

        // throw new UnsupportedOperationException("Not supported yet.");
        PreparedStatement stmt = null;
        Connection conn = null;
        ArrayList<Servizio> listaServizi = new ArrayList<Servizio>();
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM Servizio WHERE nome='" + nome + "'";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Servizio s = new Servizio();

                s.setDescrizione(rs.getString("descrizione"));
                s.setDisponibilita(rs.getBoolean("disponibilità"));
                s.setQuantita(rs.getInt("quantità"));
                s.setTipo(rs.getString("tipo"));
                s.setPrezzo(rs.getDouble("prezzo"));
                s.setIva(rs.getInt("iva"));
                s.setNote(rs.getString("note"));

                listaServizi.add(s);
            }
            return listaServizi;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }

        }
    }

    public Servizio modifica(Servizio servizio) throws SQLException {

        /**
         * metodo che si occupa di modificare un servizio in base al contenuto di bean
         * @param servizio parametro che contiene le informazioni da modificare
         * @return servizio modificato
         * @throws java.sql.SQLException
         */
        // throw new UnsupportedOperationException("Not supported yet.");
        Connection con = null;
        PreparedStatement stmt = null;
        Servizio serv = new Servizio();

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            // Create a statement
            stmt = con.prepareStatement("UPDATE Servizio SET (?, ?, ?, ?, ?, ?)" + "where idServizio=" + serv.getIdServizio());
            stmt.setString(1, servizio.getDescrizione());
            stmt.setBoolean(2, servizio.getDisponibilita());
            stmt.setInt(3, servizio.getQuantita());
            stmt.setString(4, servizio.getTipo());
            stmt.setDouble(5, servizio.getPrezzo());
            stmt.setInt(6, servizio.getIva());
            stmt.setString(7, servizio.getNote());

            stmt.execute();
            // Force the commit
            con.commit();
            serv = this.visualizza(servizio.getIdServizio());
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
        return serv;
    }

    public ArrayList<Servizio> visualizzaElenco() throws SQLException {

        /**
         * metodo che si occupa di visualizzare tutti i servizi
         * @return lista dei servizi contenuti nel database
         * @throws java.sql.SQLException
         */
        //throw new UnsupportedOperationException("Not supported yet.");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Servizio> lista = new ArrayList<Servizio>();

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Servizio ";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Servizio e = new Servizio(rs.getString(1), rs.getBoolean(2),
                        rs.getInt(3), rs.getString(4), rs.getDouble(5),
                        rs.getInt(6), rs.getInt(7), rs.getString(8));
                //(1String descrizione, 2Boolean disponibilita, 3Integer quantita,
                //4String tipo, 5Double prezzo, 6Integer idServizio, 7Integer iva, 8String note
                lista.add(e);
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
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return lista;
    }

    public Servizio visualizza(Integer idServizio) throws SQLException {

        /**
         * metodo che si occupa di ricercare un servizio in base all'identificativo
         * @param nome identificativo del servizio e parametro di ricerca
         * @return servizio che corrisponde a quell'identificativo
         * @throws java.sql.SQLException
         */
        //   throw new UnsupportedOperationException("Not supported yet.");
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Servizio serv = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query

            rs = stmt.executeQuery("SELECT * FROM Servizio WHERE servizio.idServizio= '" + idServizio + "'");

            // Define the resource list
            while (rs.next()) {
                Servizio e = new Servizio(rs.getString(1), rs.getBoolean(2),
                        rs.getInt(3), rs.getString(4), rs.getDouble(5),
                        rs.getInt(6), rs.getInt(7), rs.getString(8));
            //(1String descrizione, 2Boolean disponibilita, 3Integer quantita,
            //4String tipo, 5Double prezzo, 6Integer idServizio, 7Integer iva, 8String note

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

        return serv;
    }
}
