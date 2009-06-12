package it.seerp.storage.operazioni;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.storage.ejb.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.db.ConnectionPool;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.GregorianCalendar;

/**
 *
 * @author Ila
 */
public class OpeEvento {
    
        /** crea la query per inserire l'evento e nel database
         * @param e l'evento da inserire
         * @throws SQLException
         * @throws DatiErrati
         * @throws DatiDuplicati
       */
    public void inserimento(Evento e) throws DatiErrati, DatiDuplicati, SQLException {
        
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO evento(data, ora, luogo, nome, tema, note) VALUE (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

           // stmt.setDate(1, e.getData());
          //  stmt.setTime(2, e.getOra());
            stmt.setString(3, e.getLuogo());
            stmt.setString(4, e.getNome());
            stmt.setString(5, e.getTema());
            stmt.setString(6, e.getNote());

            stmt.executeUpdate();

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
        }

        finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
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
    public Evento modifica(Evento e) throws SQLException {
        


        Connection con = null;
        PreparedStatement stmt = null;
        Evento evento = new Evento();

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            // Create a statement
            stmt = con.prepareStatement("UPDATE Evento(data, ora, luogo, nome," +
                    " tema, note) SET (?, ?, ?, ?, ?, ?)" + "where idEvento=" +
                    e.getIdEvento());
            //stmt.setString(1, e.getData().stampaData());
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(1, sqlDate);
            java.sql.Date sqlTime = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(2, sqlTime);
            stmt.setString(3, e.getLuogo());
            stmt.setString(4, e.getNome());
            stmt.setString(5, e.getTema());
            stmt.setString(6, e.getNote());

            stmt.execute();
            // Force the commit
            con.commit();
            evento = this.visualizza(e.getIdEvento());
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
        return evento;
    }
       /** crea la query per visualizzare i dettagli
         * di un evento presente nel database
         * @return i dettagli dell'evento
         * @param nome è il nome dell'evento da visualizzare
         * @throws SQLException
         */
  
    public Evento visualizza(Integer id) throws SQLException {

       

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Evento ev = null;

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Create a statement
            stmt = con.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Evento, Agenda" +
                    "where Evento.Agenda=Agenda.idAgenda");

            // Define the resource list
            while (rs.next()) {

                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(5).getTime());

                GregorianCalendar time = new GregorianCalendar();
                time.setTimeInMillis(rs.getTime(6).getTime());



                ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), date, time, rs.getInt(7),
                        rs.getInt(8), rs.getBoolean(9));
//(1String luogo, 2String tema, 3String nome, 4String note,5 Date data, 6Time ora, 7int idEvento, 8int agenda, 9Boolean not)


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

        return ev;

    }
        /**
         * Crea la query per visualizzare tutti gli eventi
         * corrispondenti ad un id Agenda
         * @return	La lista degli eventi
         * @throws SQLException
         * @throws ClassNotFoundException
         */

    public ArrayList<Evento> visualizzaElenco() throws SQLException {
       

        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Evento> lista = new ArrayList<Evento>();

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Evento, Agenda, Utente " +
                    "WHERE agenda=idAgenda and idAgenda=idUtente ";

            rs = stmt.executeQuery(query);


             while (rs.next()) {
                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(5).getTime());

                GregorianCalendar time = new GregorianCalendar();
                time.setTimeInMillis(rs.getTime(6).getTime());



                Evento ev = new Evento(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), date, time, rs.getInt(7),
                        rs.getInt(8), rs.getBoolean(9));
//(1String luogo, 2String tema, 3String nome, 4String note,5 Date data,
                //6Time ora, 7int idEvento, 8int agenda, 9Boolean not)
                lista.add(ev);
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
        /**
         * Crea la query per ricercare gli eventi conformi al parametro 'nome'
         * e restituisce la lista degli eventi risultante.
         * @param nome	Il nome dell'evento da ricercare
         * @return	La lista degli eventi ricercata
         * @throws SQLException
         */

    public ArrayList<Evento> ricercaEvento(String nome) throws SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Evento> listaEventi;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM Evento e WHERE evento.nome='" + nome + "'";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            listaEventi = new ArrayList<Evento>();
            while (rs.next()) {
                Evento e = new Evento();
                GregorianCalendar g = new GregorianCalendar();
                g.setTimeInMillis(rs.getDate("data").getTime());
                e.setData(g);
                g.setTimeInMillis(rs.getTime("ora").getTime());
                e.setOra(g);
                e.setLuogo(rs.getString("Luogo"));
                e.setNome(rs.getString("Nome"));
                e.setTema(rs.getString("Tema"));
                e.setNote(rs.getString("Note"));

                listaEventi.add(e);
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }

        }
        return listaEventi;
    }
        /**
         * Crea la query per ricercare gli eventi conformi al parametro 'tema'
         * e restituisce la lista degli eventi risultante.
         * @param tema	Il tema dell'evento da ricercare
         * @return	La lista degli eventi ricercata
         * @throws SQLException
         * @throws ClassNotFoundException
         */

    public ArrayList<Evento> ricercaPerTema(String tema) throws SQLException {
       
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> listaEventi;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM Evento evento WHERE evento.tema='" + tema + "'";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            listaEventi = new ArrayList<Evento>();
            while (rs.next()) {
                Evento e = new Evento();
                GregorianCalendar g = new GregorianCalendar();
                g.setTimeInMillis(rs.getDate("data").getTime());
                e.setData(g);
                g.setTimeInMillis(rs.getTime("ora").getTime());
                e.setOra(g);
                e.setLuogo(rs.getString("Luogo"));
                e.setNome(rs.getString("Nome"));
                e.setTema(rs.getString("Tema"));
                e.setNote(rs.getString("Note"));

                listaEventi.add(e);
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }

        }
        return listaEventi;
    }
        /**
         * Crea la query per ricercare gli eventi conformi al parametro 'giorno'
         * e restituisce la lista degli eventi risultante.
         * @param data	La data dell'evento da ricercare
         * @return	La lista degli eventi ricercata
         * @throws SQLException
         */
 
    public ArrayList<Evento> ricercaPerGiorno(String data) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> listaEventi;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM Evento evento WHERE evento.data='" + data + "'";
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            listaEventi = new ArrayList<Evento>();
            while (rs.next()) {
                Evento e = new Evento();

                GregorianCalendar g = new GregorianCalendar();
                g.setTimeInMillis(rs.getDate("data").getTime());
                e.setData(g);
                g.setTimeInMillis(rs.getTime("ora").getTime());
                e.setOra(g);
                e.setLuogo(rs.getString("Luogo"));
                e.setNome(rs.getString("Nome"));
                e.setTema(rs.getString("Tema"));
                e.setNote(rs.getString("Note"));

                listaEventi.add(e);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return listaEventi;
    }
        /**
         * Crea la query per cancellare l'evento e dal database
         * @param e l'evento da cancellare
         * @throws SQLException
         */
  
    public void cancella(Evento e) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            String query = "DELETE FROM evento WHERE idEvento='" + e.getIdEvento() + "'";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            conn.commit();
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
 
    Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            String query = "UPDATE Evento(notifica) SET (?) " +
                    "WHERE idEvento='" + e.getIdEvento() + "'";
            stmt.setBoolean(1, e.getNotifica());
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            conn.commit();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
    }

    public ArrayList<Evento> eventiNotificati(Date data) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Evento> evNotificati;
        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            GregorianCalendar gc = new GregorianCalendar();
            Date a = new Date(gc.getTimeInMillis());
            String query = "SELECT nome,tema,data FROM Evento" +
                    " WHERE notifica=true and data<='" + a.toString() + "'";
            ResultSet rs = stmt.executeQuery(query);
            evNotificati = new ArrayList<Evento>();
            while (rs.next()) {
                Evento e = new Evento();

                GregorianCalendar g = new GregorianCalendar();
                g.setTimeInMillis(rs.getDate("data").getTime());
                e.setData(g);
                e.setNome(rs.getString("Nome"));
                e.setTema(rs.getString("Tema"));

                evNotificati.add(e);
                stmt = conn.prepareStatement(query);
                stmt.executeUpdate();
                conn.commit();
            }
        } finally {
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
