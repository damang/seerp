

package it.seerp.storage.operazioni;

import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.storage.Exception.CancellazioneFallita;
import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Exception.RicercaFallita;
import it.seerp.storage.ejb.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Ila
 */
public class OpEvento {



     public void inserimento(Evento e) throws SQLException, DatiErrati, DatiDuplicati
    {
     //   throw new UnsupportedOperationException("Not supported yet.");
         /** crea la query per inserire l'evento evento nel database
     * @param e l'evento da inserire
     * @throws ClassNotFoundException
	 * @throws SQLException
     * @throws DatiErrati
     * @throws DatiDuplicati
     */

    Connection conn=null;
    PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Evento VALUE (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setDate(1,e.getData());
            stmt.setTime(2,e.getOra());
            stmt.setString(3,e.getLuogo());
            stmt.setString(4,e.getNome());
            stmt.setString(5,e.getTema());
            stmt.setString(6,e.getNote());

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
        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }}

    public Evento modifica(Evento e) throws SQLException, DatiErrati {
        /* crea la query per modificare un evento nel database
         * @return
         * @param e l'evento da modificare
         * @throws SQLException
         * @throws Dati Errati
         */
        Connection con = null;
        PreparedStatement stmt = null;
         Evento evento=new Evento();

        try {
            // Obtain a db connection
            con = ConnectionPool.getConnection();
            // Obtain a db connection
            con = ConnectionPool.getConnection();

            // Create a statement
            stmt = con.prepareStatement("UPDATE Contratto SET (?, ?, ?, ?, ?, ?)"
                                        +"where idEvento="+ e.getIdEvento() );
            stmt.setDate(1,e.getData());
            stmt.setTime(2,e.getOra());
            stmt.setString(3,e.getLuogo());
            stmt.setString(4,e.getNome());
            stmt.setString(5,e.getTema());
            stmt.setString(6,e.getNote());


            stmt.execute();
                        // Force the commit
            con.commit();
            evento= this.visualizza(e.getIdEvento());
        }
        // Force the commit
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



    public Evento visualizza(Integer nome) throws SQLException {

        /* crea la query per visualizzare i dettagli
         di un evento presente nel database
         * @return i dettagli dell'evento
         * @param nome è il nome dell'evento da visualizzare
         * @throws SQLException
         */

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
            rs = stmt.executeQuery("SELECT * FROM Evento" +
                    "where Evento.Agenda=Agenda.idAgenda");

            // Define the resource list
            while (rs.next()) {
                ev = new Evento(rs.getDate(1), rs.getTime(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                //(1Date data, 2Time ora, 3String luogo, 4String nome, 5String tema, 6String note, 7Integer agenda)


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

    public ArrayList<Evento> visualizzaElenco() throws SQLException {
        
         /**
	 * Crea la query per visualizzare tutti gli eventi
     * corrispondenti ad un id Agenda
     * @return	La lista degli eventi
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
       Connection conn=null;
        Statement stmt = null;
        ResultSet rs=null;
        ArrayList<Evento> lista = new ArrayList<Evento>();

        try {
            // Obtain a db connection
           conn = ConnectionPool.getConnection();
            stmt = conn.createStatement();
           String query="SELECT * FROM Evento, Agenda " +
                        "WHERE agenda=idAgenda and idAgenda=idUtente ";

           rs = stmt.executeQuery(query);


            while (rs.next()) {
                Evento e = new Evento(rs.getDate(1), rs.getTime(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                  //(1Date data, 2Time ora, 3String luogo, 4String nome, 5String tema, 6String note, 7Int idAgenda)

                lista.add(e);
            }
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


      public ArrayList<Evento> ricercaEvento (String nome) throws SQLException, ClassNotFoundException
    {
          /**
	 * Crea la query per ricercare gli eventi conformi al parametro 'nome'
     * e restituisce la lista degli eventi risultante.
	 * @param nome	Il nome dell'evento da ricercare
	 * @return	La lista degli eventi ricercata
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
    Connection conn=null;
       Statement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query="SELECT * FROM Evento e WHERE evento.nome='"+nome+"'";
           stmt = conn.prepareStatement(query);
           ResultSet rs = stmt.executeQuery(query);
           ArrayList<Evento> listaEventi=new ArrayList<Evento>();
		while(rs.next()){
            Evento e =new Evento();
            e.setData(rs.getDate("data"));
            e.setOra(rs.getTime("ora"));
            e.setLuogo(rs.getString("Luogo"));
            e.setNome(rs.getString("Nome"));
            e.setTema(rs.getString("Tema"));
            e.setNote(rs.getString("Note"));

            listaEventi.add(e);
        }
            return listaEventi;
  }
        finally
        {
            if (stmt != null)
            	stmt.close();
        	if (conn != null)
        	ConnectionPool.releaseConnection(conn);

        }

}

public ArrayList<Evento> ricercaPerTema(String tema) throws SQLException, ClassNotFoundException
{
    /**
	 * Crea la query per ricercare gli eventi conformi al parametro 'tema'
     * e restituisce la lista degli eventi risultante.
	 * @param tema	Il tema dell'evento da ricercare
	 * @return	La lista degli eventi ricercata
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
Connection conn=null;
        PreparedStatement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query="SELECT * FROM Evento e WHERE evento.tema='"+tema+"'";
           stmt = conn.prepareStatement(query);
           ResultSet rs = stmt.executeQuery(query);
           ArrayList<Evento> listaEventi=new ArrayList<Evento>();
		while(rs.next()){
            Evento e =new Evento();
            e.setData(rs.getDate("data"));
            e.setOra(rs.getTime("ora"));
            e.setLuogo(rs.getString("Luogo"));
            e.setNome(rs.getString("Nome"));
            e.setTema(rs.getString("Tema"));
            e.setNote(rs.getString("Note"));

            listaEventi.add(e);
        }
            return listaEventi;
  }
        finally
        {
            if (stmt != null)
            	stmt.close();
        	if (conn != null)
        	ConnectionPool.releaseConnection(conn);

        }

}

 public ArrayList<Evento> ricercaPerGiorno(String data) throws SQLException, ClassNotFoundException
 {
     /**
	 * Crea la query per ricercare gli eventi conformi al parametro 'giorno'
     * e restituisce la lista degli eventi risultante.
	 * @param data	La data dell'evento da ricercare
	 * @return	La lista degli eventi ricercata
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

     Connection conn=null;
        PreparedStatement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            String query="SELECT * FROM Evento e WHERE evento.data='"+data+"'";
           stmt = conn.prepareStatement(query);
           ResultSet rs = stmt.executeQuery(query);
           ArrayList<Evento> listaEventi=new ArrayList<Evento>();
		while(rs.next()){
            Evento e =new Evento();

            e.setData(rs.getDate("data"));
            e.setOra(rs.getTime("ora"));
            e.setLuogo(rs.getString("Luogo"));
            e.setNome(rs.getString("Nome"));
            e.setTema(rs.getString("Tema"));
            e.setNote(rs.getString("Note"));

            listaEventi.add(e);
        }
            return listaEventi;
  }
        finally
        {
            if (stmt != null)
            	stmt.close();
        	if (conn != null)
        	ConnectionPool.releaseConnection(conn);

        }


 }

 public void cancella (Evento e) throws SQLException, ClassNotFoundException
      {/**
	 * Crea la query per cancellare l'evento e dal database
	 * @param e l'evento da cancellare
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

          Connection conn=null;
        PreparedStatement stmt = null;

        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            String query = "DELETE FROM evento WHERE idEvento='"+e.getIdEvento()+"'";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            conn.commit();
        }
        finally{
            if (stmt != null)
            	stmt.close();
        	if (conn != null)
        	ConnectionPool.releaseConnection(conn);
        }
    }


 public void notificaEvento(Evento e) throws SQLException, ClassNotFoundException
 {

 }


}
