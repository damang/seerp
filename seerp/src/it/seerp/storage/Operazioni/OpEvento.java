package it.seerp.storage.operazioni;

import com.mysql.jdbc.PreparedStatement;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Evento;
import java.sql.Connection;
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
public class OpEvento implements OpeEntity<Evento, BeanGuiEvento> {

    private Connection conn;

    public OpEvento() throws SQLException {

        conn = ConnectionPool.getConnection();
    }

    /** crea la query per inserire l'evento e nel database
     * @param e l'evento da inserire
     * @throws SQLException
     * @throws DatiErrati
     * @throws DatiDuplicati
     */
    public void inserimento(Evento e) throws DatiDuplicatiEx, DatiErratiEx, SQLException {

        PreparedStatement stmt = null;
        Statement stmt1 = null;
        String query = "INSERT INTO evento(luogo, tema, nome, note,data, ora) VALUE (?,?,?,?,?,?)";
        //da controllare campi
        String sqlTest = "SELECT * FROM evento WHERE nome='" + e.getNome() + "' ";
        try {
            stmt1 = conn.createStatement();
            stmt = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("evento già esistente nel database");
            } else {

                //controllare campi
                stmt.setString(3, e.getLuogo());
                stmt.setString(5, e.getTema());
                stmt.setString(4, e.getNome());
                stmt.setString(6, e.getNote());
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                stmt.setDate(1, sqlDate);
                java.sql.Date sqlTime = new java.sql.Date(new java.util.Date().getTime());
                stmt.setDate(2, sqlTime);

                stmt.execute();

            }
        } catch (SQLException x) {
            System.out.println("Errore nell'inserimento sql non valido o db non connesso");
            x.printStackTrace();
        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }

    }

    /** crea la query per modificare un evento nel database
     * @return
     * @param e l'evento da modificare
     * @throws SQLException
     * @throws Dati Errati
     */
    public Evento modifica(Evento e) throws DatiDuplicatiEx, DatiErratiEx, SQLException {
        
        PreparedStatement stmt = null;
        Statement stmt1 = null;
        String query = "UPDATE evento(luogo, tema, nome, note,data, ora) VALUE (?,?,?,?,?,?)";
        //da controllare campi
        String sqlTest = "SELECT * FROM evento WHERE nome='" + e.getNome() + "' ";
        try {
            stmt1 = conn.createStatement();
            stmt = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("evento già esistente nel database");
            } else {

                //controllare campi
                stmt.setString(3, e.getLuogo());
                stmt.setString(5, e.getTema());
                stmt.setString(4, e.getNome());
                stmt.setString(6, e.getNote());
                java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                stmt.setDate(1, sqlDate);
                java.sql.Date sqlTime = new java.sql.Date(new java.util.Date().getTime());
                stmt.setDate(2, sqlTime);

                stmt.execute();

            }
        } catch (SQLException x) {
            System.out.println("Errore nella modifica sql non valido o db non connesso");
            x.printStackTrace();
        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (stmt1 != null) {
                stmt1.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
            return e;
        }

    }

    /** crea la query per visualizzare i dettagli
     * di un evento presente nel database
     * @return i dettagli dell'evento
     * @param nome è il nome dell'evento da visualizzare
     * @throws SQLException
     */
    public Evento visualizza(BeanGuiEvento eve) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Evento ev = new Evento();

        try {

            // Create a statement
            String query = "SELECT * FROM Evento, Agenda" +
                    "where Evento.idAgenda=Agenda.idAgenda and idAgenda=?";

            stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(eve.getIdEvento().toString()));
            // Execute the query
            rs = stmt.executeQuery(query);

            // Define the resource list
            while (rs.next()) {
                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(5).getTime());

                GregorianCalendar time = new GregorianCalendar();
                time.setTimeInMillis(rs.getTime(6).getTime());
                /*String luogo, String tema, String nome, String note,
                GregorianCalendar data, GregorianCalendar ora, int idEvento, Boolean not*/
                ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), date, time, rs.getInt(7),
                        rs.getBoolean(8));


            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dell'evento");

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

        return ev;

    }

    /**
     * Crea la query per visualizzare tutti gli eventi
     * corrispondenti ad un id Agenda
     * @return	La lista degli eventi
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<BeanGuiEvento> visualizzaElenco() throws SQLException {

        ArrayList<BeanGuiEvento> lista = new ArrayList<BeanGuiEvento>();
        BeanGuiEvento gui = new BeanGuiEvento();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM Evento, Agenda, Utente " +
                    "WHERE agenda=idAgenda and idAgenda=idUtente ";
            stmt = (PreparedStatement) conn.prepareStatement(query);
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(5).getTime());

                GregorianCalendar time = new GregorianCalendar();
                time.setTimeInMillis(rs.getTime(6).getTime());

                Evento ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), date, time, rs.getInt(7),
                        rs.getBoolean(8));
//(1String luogo, 2String tema, 3String nome, 4String note,5 Date data,
                //6Time ora, 7int idEvento, 8Boolean not)
                lista.add(it.seerp.application.conversioni.Conversione.conversioneEvento(ev, gui));
            }
        } catch (SQLException se) {
            System.out.println("Errore nella visualizzazione dell'elenco");

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
     * Crea la query per ricercare gli eventi conformi al parametro 'nome'
     * e restituisce la lista degli eventi risultante.
     * @param nome	Il nome dell'evento da ricercare
     * @return	La lista degli eventi ricercata
     * @throws SQLException
     */
    public ArrayList<Evento> ricercaEvento(String nome) throws SQLException {
        ArrayList<BeanGuiEvento> lista = this.visualizzaElenco();
        ArrayList<Evento> b = new ArrayList<Evento>();
        for (BeanGuiEvento a : lista) {
            Evento evento = it.seerp.application.conversioni.Conversione.conversioneEvento(a);
            b.add(evento);
        }
        return b;
 }

    /**
     * Crea la query per ricercare gli eventi conformi al parametro 'tema'
     * e restituisce la lista degli eventi risultante.
     * @param tema	Il tema dell'evento da ricercare
     * @return	La lista degli eventi ricercata
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    /**
     * Crea la query per cancellare l'evento e dal database
     * @param e l'evento da cancellare
     * @throws SQLException
     */
    public void cancella(Evento e) throws SQLException {

        PreparedStatement stmt = null;

        try {

            String query = "DELETE FROM evento WHERE idEvento='" + e.getIdEvento() + "'";
            stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("Errore nell'eliminazione dell'elenco");

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
    }
    /*crea la query per settare il campo notifica a true*/

    public void notificaEvento(Evento e) throws SQLException {

        PreparedStatement stmt = null;

        try {
            String query = "UPDATE Evento(notifica) SET (?) " +
                    "WHERE idEvento='" + e.getIdEvento() + "'";
            stmt.setBoolean(1, e.getNotifica());
            stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.executeUpdate();

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
    }

    public ArrayList<Evento> eventiNotificati(GregorianCalendar data) throws SQLException {

        PreparedStatement stmt = null;
        ArrayList<Evento> evNotificati = new ArrayList<Evento>();
        try {

            GregorianCalendar gc = new GregorianCalendar();
            Date a = new Date(gc.getTimeInMillis());
            String query = "SELECT nome,tema,data FROM Evento" +
                    " WHERE notifica=true and data<='" + a.toString() + "'";
            ResultSet rs = stmt.executeQuery(query);
         
            while (rs.next()) {
                Evento e = new Evento();

                GregorianCalendar g = new GregorianCalendar();
                g.setTimeInMillis(rs.getDate("data").getTime());
                e.setData(g);
                e.setNome(rs.getString("Nome"));
                e.setTema(rs.getString("Tema"));

                evNotificati.add(e);
                stmt = (PreparedStatement) conn.prepareStatement(query);
                stmt.executeUpdate();

            }
        }
            catch (SQLException se) {
            System.out.println("Errore nella visualizzazione dell'elenco");

            }
         finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return evNotificati;
    
}

  }