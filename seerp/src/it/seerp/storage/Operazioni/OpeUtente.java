package it.seerp.storage.Operazioni;

import com.mysql.jdbc.Connection;

import com.mysql.jdbc.PreparedStatement;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Utente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class OpeUtente implements OpeEntity<Utente, BeanGuiUtente> {

    private Connection conn;

    public OpeUtente() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    public ArrayList<BeanGuiUtente> visualizzaElenco() throws SQLException {

        ArrayList<BeanGuiUtente> list = new ArrayList<BeanGuiUtente>();
        BeanGuiUtente gui = new BeanGuiUtente();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Obtain a db connection

            // Create a statement
            String sql = "SELECT * FROM Utente where Visible='true'";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                Utente utente = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));
                //(1Integer idUtente, 2String username, 3Integer password, 4String città, 5String provincia, 6String telefono, 7String email, 8String note, 9Boolean v )
                list.add(it.seerp.application.conversioni.Conversione.conversioneUtente(utente, gui));
            }
        } catch (SQLException se) {
            System.out.println("errore di visualizzazione elenco");
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
        return list;
    }


    //modifica
    public Utente modifica(Utente utente) throws SQLException, DatiErrati {

        try {

            PreparedStatement stmt;
            // Create a statement
            String sql = "UPDATE Utente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, utente.getUsername());
            stmt.setString(2, utente.getPassword());
            stmt.setString(3, utente.getEmail());
            stmt.setString(4, utente.getCittà());
            stmt.setString(5, utente.getProvincia());
            stmt.setString(6, utente.getTelefono());
            stmt.setString(7, utente.getCap());
            stmt.setString(8, utente.getNote());
            stmt.setString(9, utente.getRuolo());
            stmt.setBoolean(10, utente.getVisible());

            stmt.execute();

        } catch (SQLException se) {
            System.out.println("modifica non effettuata");
        } finally {

            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }

        return utente;

    }

    public void inserimento(Utente bean) throws SQLException {

        try {
            String sql = "INSERT Utente VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, bean.getUsername());
            stmt.setString(2, bean.getPassword());
            stmt.setString(3, bean.getEmail());
            stmt.setString(4, bean.getCittà());
            stmt.setString(5, bean.getProvincia());
            stmt.setString(6, bean.getTelefono());
            stmt.setString(7, bean.getCap());
            stmt.setString(8, bean.getNote());
            stmt.setString(9, bean.getRuolo());
            stmt.setBoolean(10, bean.getVisible());

            stmt.execute();


        } catch (SQLException se) {
            System.out.println("errore di inserimento");
        } finally {

            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
    }

    public Utente visualizza(BeanGuiUtente bean) throws SQLException {

        Utente utente = new Utente();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            // Create a statement

            // Execute the query
            String sql = "SELECT * FROM Utente WHERE idUtente = ?";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(bean.getIdUtenteTxt().toString()));
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                utente = new Utente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));


            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dell'utente");
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
        return utente;
    }

    public ArrayList<Utente> ricerca(String nome, String ruolo) throws SQLException {
        ArrayList<BeanGuiUtente> list1 = this.visualizzaElenco();
        ArrayList<Utente> list = new ArrayList<Utente>();
        for (BeanGuiUtente a : list1) {
            list.add(it.seerp.application.conversioni.Conversione.conversioneUtente(a));
        }
        return list;
    }

    public void eliminaLogica(Utente ut) throws SQLException {

        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Utente SET Visible='false' where username = ?";
            // Create a statement
            stmt = (PreparedStatement) conn.prepareStatement(sql);

            // Execute the query
            stmt.executeQuery();
        } catch (SQLException se) {
            System.out.println("errore nell'eliminazione logica dell'utente");

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

    public void elimina(Utente ut) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE * FROM Utente where username =?";
            // Create a statement
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, ut.getUsername());
            // Execute the query
            stmt.executeQuery(sql);
        } catch (SQLException se) {
            System.out.println("errore nell'eliminazione dell'utente");

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
}



