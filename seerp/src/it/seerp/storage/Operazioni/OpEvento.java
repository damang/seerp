package it.seerp.storage.operazioni;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.GregorianCalendar;

/**
 *
 * @author Ila
 */
public class OpEvento implements OpeEntity<Evento, Integer> {

    private Connection conn;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpEvento() throws SQLException {

        conn = (Connection) ConnectionPool.getConnection();
    }

    /** crea la query per inserire l'evento e nel database
     * @param e l'evento da inserire
     * @throws SQLException
     * @throws DatiErratiEx eccezione lanciata se si inseriscono dati errati
     * @throws DatiDuplicatiEx eccezione lanciata se esiste già un evento con lo stesso nome
     */
    public void inserimento(Evento e) throws DatiDuplicatiEx, DatiErratiEx, SQLException {

        PreparedStatement stmt = null;
        Statement stmt1 = null;
        String query = "INSERT INTO evento(data, ora,agenda,luogo,nome,tema,note,notifica)" +
                " VALUE (?,?,?,?,?,?,?,?)";
        //da controllare campi
        String sqlTest = "SELECT * FROM evento WHERE nome='" + e.getNome() + "' ";

        stmt1 = conn.createStatement();
        stmt = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("evento già esistente nel database");
        } else {
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(1, sqlDate);
            java.sql.Date sqlTime = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(2, sqlTime);
            stmt.setInt(3, e.getAgenda().getIdAgenda());
            stmt.setString(4, e.getLuogo());
            stmt.setString(5, e.getNome());
            stmt.setString(6, e.getTema());
            stmt.setString(7, e.getNote());
            stmt.setBoolean(8, e.getNotifica());

            stmt.execute();
            stmt.close();
            rs.close();
            ConnectionPool.releaseConnection(conn);
        }
    }

    /** crea la query per modificare un evento nel database
     * @return
     * @param e l'evento da modificare
     * @throws DatiDuplicatiEx
     * @throws DatiErratiEx
     * @throws SQLException
     */
    public Evento modifica(Evento e) throws DatiDuplicatiEx, DatiErratiEx, SQLException {

        PreparedStatement stmt = null;
        Statement stmt1 = null;
        String query = "UPDATE evento(data, ora,luogo,nome,tema,note,notifica) VALUE (?,?,?,?,?,?,?)";
        //da controllare campi
        String sqlTest = "SELECT * FROM evento WHERE nome='" + e.getNome() + "' ";

        stmt1 = conn.createStatement();
        stmt = (PreparedStatement) conn.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("evento già esistente nel database");
        } else {

            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(1, sqlDate);
            java.sql.Date sqlTime = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(2, sqlTime);
            stmt.setString(3, e.getLuogo());
            stmt.setString(4, e.getNome());
            stmt.setString(5, e.getTema());
            stmt.setString(6, e.getNote());
            stmt.setBoolean(7, e.getNotifica());

            stmt.execute();

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return e;
    }

    /** crea la query per visualizzare i dettagli
     * di un evento presente nel database
     * @return i dettagli dell'evento
     * @param id
     * @throws SQLException
     */
    public Evento visualizza(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Evento ev = null;

        String query = "SELECT idEvento,data, ora,luogo,nome,tema,note,notifica" +
                " FROM evento, agenda" +
                "where evento.idAgenda=agenda.idAgenda and idAgenda=?";

        stmt = (PreparedStatement) conn.prepareStatement(query);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery(query);

        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(2).getTime());

            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(rs.getTime(3).getTime());

            ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), date, time, rs.getInt(7),
                    rs.getBoolean(8));

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return ev;

    }

    /**
     * Crea la query per visualizzare tutti gli eventi
     * corrispondenti ad un id Agenda
     * @return	La lista degli eventi
     * @throws SQLException
     */
    public ArrayList<Evento> visualizzaElenco() throws SQLException {

        ArrayList<Evento> lista = new ArrayList<Evento>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT idEvento,data, ora,luogo,nome,tema,evento.note,notifica" +
                " FROM evento, agenda, utente " +
                "WHERE evento.agenda=agenda.idAgenda and agenda.idAgenda=utente.idUtente ";
        stmt = (PreparedStatement) conn.prepareStatement(query);
        rs = stmt.executeQuery(query);

        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(2).getTime());

            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(rs.getTime(3).getTime());

            Evento ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), date, time, rs.getInt(7), rs.getBoolean(8));

            lista.add(ev);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);
        return lista;
    }

    /**
     * Crea la query per ricercare un evento
     * e restituisce la lista degli eventi risultante.
     * @return	La lista degli eventi ricercata
     * @throws SQLException
     */
    public ArrayList<Evento> ricercaEvento() throws SQLException {

        ArrayList<Evento> b = this.visualizzaElenco();
        return b;
    }

    /**
     * Crea la query per cancellare l'evento e dal database
     * @param e l'evento da cancellare
     * @throws SQLException
     */
    public void cancella(Evento e) throws SQLException {

        PreparedStatement stmt = null;

        String query = "DELETE FROM evento WHERE idEvento='" + e.getIdEvento() + "'";
        stmt = (PreparedStatement) conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();

        ConnectionPool.releaseConnection(conn);
    }
   
    /**
     * crea la query per settare il campo notifica a true
     * @param e l'evento da notificare
     * @throws SQLException
     */
    public void notificaEvento(Evento e) throws SQLException {

        PreparedStatement stmt = null;


        String query = "UPDATE evento(notifica) SET (true) " +
                "WHERE idEvento='" + e.getIdEvento() + "'";
        stmt.setBoolean(1, e.getNotifica());
        stmt = (PreparedStatement) conn.prepareStatement(query);
        stmt.executeUpdate();

        stmt.close();

        ConnectionPool.releaseConnection(conn);
    }

     /**
     * crea la query per mostrare gli eventi che devono essere notificati all'utente
     * @param data il giorno da cui il sistema deve notificare l'evento
      * @return
      * @throws SQLException
     */
    public ArrayList<Evento> eventiNotificati(GregorianCalendar data) throws SQLException {

        PreparedStatement stmt = null;
        ArrayList<Evento> evNotificati = new ArrayList<Evento>();

        GregorianCalendar gc = new GregorianCalendar();
        Date a = new Date(gc.getTimeInMillis());
        String query = "SELECT nome,tema,data FROM evento" +
                " WHERE notifica=true and data<='" + a.toString() + "'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Evento e = new Evento();

            GregorianCalendar g = new GregorianCalendar();

            e.setNome(rs.getString(1));
            e.setTema(rs.getString(2));
            g.setTimeInMillis(rs.getDate(3).getTime());
            e.setData(g);


            evNotificati.add(e);
            stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.executeUpdate();

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return evNotificati;

    }
}
