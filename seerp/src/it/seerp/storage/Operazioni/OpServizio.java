package it.seerp.storage.Operazioni;

import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;

import it.seerp.storage.ejb.Servizio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.Exception.DatiErratiEx;

/**
 * la classe storage che si occupa di interfacciarsi con il dbms e compiere operazioni sui servizi
 * @author Ila
 */
public class OpServizio implements OpeEntity<Servizio, Integer> {

    private Connection conn;


    public OpServizio() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    /**
     * metodo che si occupa di inserire un nuovo servizio nel database
     * @param se il unovo servizio da inserire
     * @throws java.sql.SQLException
     */
    public void inserimento(Servizio serv) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;
        
        String query = "INSERT INTO Servizio(descrizione,disponibilita,quantita,tipo,prezzo,iva,note)" +
                          " VALUES (?,?,?,?,?,?,?)";
        stmt = (PreparedStatement) conn.prepareStatement(query);
        
        stmt.setString(1, serv.getDescrizione());
        stmt.setBoolean(2, serv.getDisponibilita());
        stmt.setInt(3, serv.getQuantita());
        stmt.setString(4, serv.getTipo());
        stmt.setDouble(5, serv.getPrezzo());
        stmt.setInt(6, serv.getIva());
        stmt.setString(7, serv.getNote());

        stmt.executeUpdate();



        stmt.close();
        ConnectionPool.releaseConnection(conn);

    }

    /**
     * metodo che si occupa di ricercare un servizio in base all'id
     * @param nome del servizio
     * @return lista di servizi che rispettano i parametri di ricerca
     * @throws java.sql.SQLException
     */
    public ArrayList<Servizio> ricerca() throws SQLException {

        ArrayList<Servizio> b = this.visualizzaElenco();
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
        String query="UPDATE Servizio(descrizione,disponibilità,quantità,tipo,prezzo,iva,note)" +
                " SET (?, ?, ?, ?, ?, ?)" +
                "where idServizio=" + servizio.getIdServizio();
        stmt = (PreparedStatement) conn.prepareStatement(query);

        stmt.setString(1, servizio.getDescrizione());
        stmt.setBoolean(2, servizio.getDisponibilita());
        stmt.setInt(3, servizio.getQuantita());
        stmt.setString(4, servizio.getTipo());
        stmt.setDouble(5, servizio.getPrezzo());
        stmt.setInt(6, servizio.getIva());
        stmt.setString(7, servizio.getNote());

        stmt.execute();

        stmt.close();
        ConnectionPool.releaseConnection(conn);

        return servizio;
    }

    /**
     * metodo che si occupa di visualizzare tutti i servizi
     * @return lista dei servizi contenuti nel database
     * @throws java.sql.SQLException
     */
    public ArrayList<Servizio> visualizzaElenco() throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Servizio> lista = new ArrayList<Servizio>();


        String query = "SELECT idServizio,descrizione,disponibilita,quantita,tipo,prezzo,iva,note" +
                        " FROM Servizio ";
        stmt = (PreparedStatement) conn.prepareStatement(query);

        rs = stmt.executeQuery(query);

        while (rs.next()) {

            Servizio e = new Servizio(rs.getInt(1), rs.getString(2), rs.getBoolean(3),
                    rs.getInt(4), rs.getString(5), rs.getDouble(6),
                    rs.getInt(7), rs.getString(8));

            lista.add(e);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);
        return lista;
    }

    /**
     * metodo che si occupa di ricercare un servizio in base all'identificativo
     * @param nome identificativo del servizio e parametro di ricerca
     * @return servizio che corrisponde a quell'identificativo
     * @throws java.sql.SQLException
     */
    public Servizio visualizza(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servizio serv = null;


        String query = "SELECT idServizio,descrizione,disponibilita,quantita,tipo,prezzo,iva,note" +
                " FROM Servizio WHERE servizio.idServizio= ?";
        stmt = (PreparedStatement) conn.prepareStatement(query);
        stmt.setInt(1, id);

        rs = stmt.executeQuery(query);

        // Define the resource list
        while (rs.next()) {
            serv = new Servizio(rs.getInt(1), rs.getString(2), rs.getBoolean(3),
                    rs.getInt(4), rs.getString(5), rs.getDouble(6),
                    rs.getInt(7), rs.getString(8));

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return serv;
    }
}
