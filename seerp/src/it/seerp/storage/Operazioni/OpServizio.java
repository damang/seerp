package it.seerp.storage.Operazioni;

import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;

import it.seerp.storage.ejb.Servizio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.Exception.DatiErratiEx;
/**
 * la classe storage che si occupa di interfacciarsi con il dbms e compiere operazioni sui servizi
 * @author Ila
 */
public class OpServizio implements OpeEntity<Servizio, BeanGuiServizio> {

    private Connection conn;

    public OpServizio()throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

/**
         * metodo che si occupa di inserire un nuovo servizio nel database
         * @param se il unovo servizio da inserire
         * @throws java.sql.SQLException
         */
    public void inserimento(Servizio serv) throws SQLException, DatiErratiEx {
    
        PreparedStatement stmt = null;
        try {
      
            String query = "INSERT INTO Servizio VALUE (?,?,?,?,?,?,?)";
            stmt = (PreparedStatement) conn.prepareStatement(query);

            stmt.setString(2, serv.getDescrizione());
            stmt.setBoolean(3, serv.getDisponibilita());
            stmt.setInt(4, serv.getQuantita());
            stmt.setString(5, serv.getTipo());
            stmt.setDouble(6, serv.getPrezzo());
            stmt.setInt(7, serv.getIva());
            stmt.setString(8, serv.getNote());

            stmt.executeUpdate();
           
        } catch (SQLException se) {
            System.out.println("Errore nell'inserimento di un nuovo servizio");
          
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
/**
         * metodo che si occupa di ricercare un servizio in base all'id
         * @param nome del servizio
         * @return lista di servizi che rispettano i parametri di ricerca
         * @throws java.sql.SQLException
         */
    public ArrayList<Servizio> ricerca(String nome) throws SQLException {

        ArrayList<BeanGuiServizio> lista = this.visualizzaElenco();
        ArrayList<Servizio> b = new ArrayList<Servizio>();
        for (BeanGuiServizio a : lista) {
            Servizio contr = it.seerp.application.conversioni.Conversione.conversioneServizio(a);
            b.add(contr);
        }
        return b;
    }
/**
         * metodo che si occupa di modificare un servizio in base al contenuto di bean
         * @param servizio parametro che contiene le informazioni da modificare
         * @return servizio modificato
         * @throws java.sql.SQLException
         */
    public Servizio modifica(Servizio servizio) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        try {
           

            // Create a statement
            stmt = (PreparedStatement) conn.prepareStatement("UPDATE Servizio SET (?, ?, ?, ?, ?, ?)"
                    + "where idServizio=" + servizio.getIdServizio());
            stmt.setString(2, servizio.getDescrizione());
            stmt.setBoolean(3, servizio.getDisponibilita());
            stmt.setInt(4, servizio.getQuantita());
            stmt.setString(5, servizio.getTipo());
            stmt.setDouble(6, servizio.getPrezzo());
            stmt.setInt(7, servizio.getIva());
            stmt.setString(8, servizio.getNote());

            stmt.execute();
          
        } 
        catch (SQLException se) {
            System.out.println("Errore nella modifica del servizio");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return servizio;
    }
  /**
         * metodo che si occupa di visualizzare tutti i servizi
         * @return lista dei servizi contenuti nel database
         * @throws java.sql.SQLException
         */
    public ArrayList<BeanGuiServizio> visualizzaElenco() throws SQLException {
    
        PreparedStatement stmt = null;
        ResultSet rs = null;

         ArrayList<BeanGuiServizio> lista = new ArrayList<BeanGuiServizio>();
        BeanGuiServizio gui = new BeanGuiServizio();

        try {
            String query = "SELECT * FROM Servizio ";
            stmt = (PreparedStatement) conn.prepareStatement(query);
            
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                Servizio e = new Servizio(rs.getInt(1),rs.getString(1), rs.getBoolean(2),
                        rs.getInt(3), rs.getString(4), rs.getDouble(5),
                        rs.getInt(6),rs.getString(7));
                
                 lista.add(it.seerp.application.conversioni.Conversione.conversioneServizio(e, gui));
            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dell'elenco dei servizi");

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

     /**
         * metodo che si occupa di ricercare un servizio in base all'identificativo
         * @param nome identificativo del servizio e parametro di ricerca
         * @return servizio che corrisponde a quell'identificativo
         * @throws java.sql.SQLException
         */
    public Servizio visualizza(BeanGuiServizio ser) throws SQLException {
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servizio serv = null;

        try {
            String query="SELECT * FROM Servizio WHERE servizio.idServizio= ?";
            stmt = (PreparedStatement) conn.prepareStatement(query);
         stmt.setInt(1, Integer.parseInt(ser.getIdServizio().toString()));

            rs = stmt.executeQuery(query);

            // Define the resource list
            while (rs.next()) {
                serv = new Servizio(rs.getInt(1),rs.getString(1), rs.getBoolean(2),
                        rs.getInt(3), rs.getString(4), rs.getDouble(5),
                        rs.getInt(6),rs.getString(7));
            

            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione di un servizio");

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

        return serv;
    }

}
