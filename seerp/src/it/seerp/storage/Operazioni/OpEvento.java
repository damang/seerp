package it.seerp.storage.Operazioni;

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

    private Connection connessione;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpEvento() throws SQLException {

        connessione = (Connection) ConnectionPool.getConnection();
    }

    /** crea la query per inserire l'evento e nel database
     * @param e l'evento da inserire
     * @throws SQLException
     * @throws DatiErratiEx eccezione lanciata se si inseriscono dati errati
     * @throws DatiDuplicatiEx eccezione lanciata se esiste già un evento con lo stesso nome
     */
    public void inserimento(Evento e) throws DatiDuplicatiEx, DatiErratiEx, SQLException {

        PreparedStatement stmt = null;
        String query = "INSERT INTO evento(data,ora,agenda,luogo,nome,tema,note,notifica) VALUES (?,?,?,?,?,?,?,?)";
        stmt = (PreparedStatement) connessione.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(e.getData().getTimeInMillis());
            stmt.setDate(1, sqlDate);
            java.sql.Time sqlTime = new java.sql.Time(e.getOra().getTimeInMillis());
            stmt.setTime(2, sqlTime);
            stmt.setInt(3, e.getAgenda());
            stmt.setString(4, e.getLuogo());
            stmt.setString(5, e.getNome());
            stmt.setString(6, e.getTema());
            stmt.setString(7, e.getNote());
            stmt.setBoolean(8, e.getNotifica());
            stmt.execute();
            stmt.close();
           ConnectionPool.releaseConnection(connessione);
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
        String query = "UPDATE evento SET data=?, ora=?, luogo=?, nome=?, tema=?, note=?, notifica=? where idEvento=?";
        stmt = (PreparedStatement) connessione.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(e.getData().getTimeInMillis());
            stmt.setDate(1, sqlDate);
            java.sql.Time sqlTime = new java.sql.Time(e.getOra().getTimeInMillis());
            stmt.setTime(2, sqlTime);
            stmt.setString(3,e.getLuogo());
            stmt.setString(4,e.getNome());
            stmt.setString(5, e.getTema());
            stmt.setString(6, e.getNote());
            stmt.setBoolean(7,e.getNotifica());
            stmt.setInt(8, e.getIdEvento());
            stmt.execute();
        stmt.close();
        ConnectionPool.releaseConnection(connessione);
        return e;
    }

    /** crea la query per visualizzare i dettagli
     * di un evento presente nel database
     * @return i dettagli dell'evento
     * @param id
     * @throws SQLException
     */
    public Evento visualizza(Integer id) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Evento ev = null;

        String query = "SELECT idEvento, data, ora, luogo, nome, tema, note, notifica" +
                       " FROM evento join agenda on agenda=idAgenda" +
                       "where idAgenda=?";

        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();

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
        ConnectionPool.releaseConnection(connessione);

        return ev;

    }

    /**
     * Crea la query per visualizzare tutti gli eventi
     * corrispondenti ad un id Agenda
     * @return	La lista degli eventi
     * @throws SQLException
     */
    public ArrayList<Evento> visualizzaElenco(String usr) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        ArrayList<Evento> lista = new ArrayList<Evento>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT idEvento,data, ora,luogo,nome,tema,evento.note,notifica" +
                       " FROM evento, agenda, utente " +
                       "WHERE evento.agenda=agenda.idAgenda and agenda.idAgenda=utente.idUtente and username= ? ";
        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.setString(1, usr);
        rs = stmt.executeQuery();

        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(2).getTime());

            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(rs.getTime(3).getTime());

            Evento ev = new Evento();
            ev.setIdEvento(rs.getInt("idEvento"));
            ev.setData(date);
            ev.setOra(time);
            ev.setLuogo(rs.getString("luogo"));
            ev.setNome(rs.getString("nome"));
            ev.setNote(rs.getString("evento.note"));
            ev.setNotifica(rs.getBoolean("notifica"));
            ev.setTema(rs.getString("tema"));

            lista.add(ev);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(connessione);
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

        String query = "DELETE FROM evento WHERE idEvento=?";
        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.setInt(1, e.getIdEvento());
        stmt.executeUpdate();
        stmt.close();

        ConnectionPool.releaseConnection(connessione);
    }
   
    /**
     * crea la query per settare il campo notifica a true
     * @param e l'evento da notificare
     * @throws SQLException
     */
    public void notificaEvento(Evento e) throws SQLException {

        PreparedStatement stmt = null;


        String query = "UPDATE evento SET  notifica='true'" +
                "WHERE idEvento=?";
        stmt.setInt(1, e.getIdEvento());
        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.executeUpdate();

        stmt.close();

        ConnectionPool.releaseConnection(connessione);
    }

     /**
     * crea la query per mostrare gli eventi che devono essere notificati all'utente
     * @param data il giorno da cui il sistema deve notificare l'evento
      * @return
      * @throws SQLException
     */
    public ArrayList<Evento> eventiNotificati(int id, GregorianCalendar data) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ArrayList<Evento> evNotificati = new ArrayList<Evento>();

        String query = "SELECT nome,tema,`data`,ora FROM evento WHERE agenda=? and notifica=true and data>=?";
        stmt= (PreparedStatement) connessione.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(data.getTimeInMillis());
        stmt.setInt(1,id);
        stmt.setDate(2, sqlDate);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Evento e = new Evento();
            GregorianCalendar d = new GregorianCalendar();
            GregorianCalendar o = new GregorianCalendar();
            e.setNome(rs.getString(1));
            e.setTema(rs.getString(2));
            d.setTimeInMillis(rs.getDate(3).getTime());
            e.setData(d);
            o.setTimeInMillis(rs.getTime(4).getTime());
            e.setOra(o);
            evNotificati.add(e);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(connessione);

        return evNotificati;

    }


    public ArrayList<Evento> visualizzaElenco() throws SQLException {

        ArrayList<Evento> lista = new ArrayList<Evento>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT idEvento,data, ora,luogo,nome,tema,evento.note,notifica" +
                       " FROM evento, agenda, utente " +
                       "WHERE evento.agenda=agenda.idAgenda and agenda.idAgenda=utente.idUtente";
        stmt = (PreparedStatement) connessione.prepareStatement(query);

        rs = stmt.executeQuery();

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
        ConnectionPool.releaseConnection(connessione);
        return lista;
    }

    public Evento getEventoPerId(Integer id) throws SQLException{
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Evento ev = null;

        String query = "SELECT idEvento, data, ora, luogo, nome, tema, evento.note, notifica FROM evento, agenda WHERE agenda=idAgenda and idEvento=?";

        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery();

        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(2).getTime());

            GregorianCalendar time = new GregorianCalendar();
            time.setTimeInMillis(rs.getTime(3).getTime());

            ev = new Evento();
            ev.setIdEvento(rs.getInt("idEvento"));
            ev.setData(date);
            ev.setOra(time);
            ev.setLuogo(rs.getString("luogo"));
            ev.setNome(rs.getString("nome"));
            ev.setNote(rs.getString("evento.note"));
            ev.setNotifica(rs.getBoolean("notifica"));
            ev.setTema(rs.getString("tema"));

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(connessione);

        return ev;


    }
    public int getIdAgendaUtCorr(String username) throws SQLException {
        connessione = (Connection) ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT agenda FROM evento,agenda,utente WHERE agenda=idAgenda and idAgenda=idUtente and username=?";

        stmt = (PreparedStatement) connessione.prepareStatement(query);
        stmt.setString(1, username);
        // Execute the query
        rs = stmt.executeQuery();
        int id=-1;
        if(rs.next()) {
            id=rs.getInt(1);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(connessione);
        return id;
    }
}
