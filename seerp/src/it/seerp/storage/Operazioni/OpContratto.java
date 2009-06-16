package it.seerp.storage.Operazioni;

import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Servizio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.ejb.ServizioAssociato;

/**
 * classe storage che si occupa di interfacciarsi col DBMS e compiere operazioni sui contratti
 * @author Luisa-Ila
 */
public class OpContratto implements OpeEntity<Contratto, Integer> {

    private Connection conn;

    /**
     * 
     * @throws java.sql.SQLException
     */
    public OpContratto() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    /**
     * metodo che inserisce i dati del contratto
     * @throws java.sql.SQLException
     * @throws DatiErratiEx se si inseriscono dati errati
     */
    public void inserimento(Contratto contratto) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        String query = "INSERT INTO Contratto(durata,stato,tipo,extrazienda,dipendente,data,note)" +
                " VALUES (?, ?, ?, ?, ?, ?, ? )" + "where idContratto=" + contratto.getIdContratto();

        stmt = (PreparedStatement) conn.prepareStatement(query);

        stmt.setInt(1, contratto.getDurata());
        stmt.setString(2, contratto.getStato());
        stmt.setString(3, contratto.getTipo());
        stmt.setInt(4, contratto.getExtraAzienda().getIdUtente());
        stmt.setInt(5, contratto.getDipendente().getIdUtente());
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        stmt.setDate(6, sqlDate);
        stmt.setString(7, contratto.getNote());

        stmt.execute();

        stmt.close();
        ConnectionPool.releaseConnection(conn);
    }

    /**
     * metodo che ricerca i contratti associati a quel dipendente con identificativo uguale a id
     * @return una lista dei contratti ricercati in base all'identificati vo del dipendente
     * @throws java.sql.SQLException     
     */
    public ArrayList<Contratto> ricercaPerDipendente() throws SQLException {

        ArrayList<Contratto> lista = this.visualizzaElenco();
        return lista;
    }

    /**
     * metodo che ricerca tutti i contratti
     * @return una lista dei contratti ricercati  in base all'identificativo del dipendente
     * @throws java.sql.SQLException
     */
    public ArrayList<Contratto> visualizzaElenco() throws SQLException {

        ArrayList<Contratto> lista = new ArrayList<Contratto>();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contratto contratto = null;

        String sql = "SELECT idContratto,durata,stato,tipo,extrazienda,dipendente,data,note FROM Contratto";
        stmt = (PreparedStatement) conn.prepareStatement(sql);

        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(2).getTime());

            contratto = new Contratto(rs.getString(1), date,
                    rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));

            lista.add(contratto);

        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);
        return lista;

    }

    /**
     * ricerca il contratto con quell'identificativo
     * @param id l'id del contratto
     * @return un contratto con identificativo uguale al paramtero nome
     * @throws java.sql.SQLException
     */
    public Contratto visualizza(Integer id) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contratto contratto = null;


        String sql = "SELECT idContratto,durata,stato,tipo,extrazienda,dipendente,data,note " +
                "FROM Contratto WHERE idContratto= ?";
        stmt = (PreparedStatement) conn.prepareStatement(sql);

        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(rs.getDate(7).getTime());

            contratto = new Contratto(rs.getString(4), date, rs.getInt(1),
                    rs.getString(3), rs.getInt(2), rs.getString(8));

            PreparedStatement stmt1;
            String sql2 = "SELECT contratto,quantita,prezzoUnitario,servizio FROM contratto,serviziassociati " +
                    "WHERE contratto.idContratto=serviziassociati.contratto AND idContratto=?";
            stmt1 = (PreparedStatement) conn.prepareStatement(sql2);
            stmt1.setInt(1, id);
            ResultSet rs2 = stmt1.executeQuery();

            PreparedStatement stmt2;
            String sql3 = "SELECT idUtente,username,password,citta,provincia,telefono," +
                    "cap,email,note,tipo,cognome,nome,codicefiscale,ruolo,visible" +
                    " FROM contratto,dipendente,personale,utente" +
                    "  WHERE contratto.dipendente=dipendente.idDipendente " +
                    "AND dipendente.idDipendente=Personale.idPersonale " +
                    "AND Personale.idPersonale=Utente.idUtente" +
                    "AND dipendente=?";
            stmt2 = (PreparedStatement) conn.prepareStatement(sql3);
            stmt2.setInt(1, contratto.getDipendente().getIdUtente());
            ResultSet rs3 = stmt2.executeQuery();


            while (rs2.next()) {

                ServizioAssociato sa = new ServizioAssociato(rs.getInt(2), rs.getDouble(3), rs.getString(4));
                contratto.addServizio(sa);
            }

            while (rs3.next()) {
                Dipendente dip = new Dipendente(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), new Ruolo(rs.getString(14)),
                        rs.getBoolean(15));
            }
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);

        return contratto;
    }

    /**
     * metodo che si occupa di ricercare tutti i servizi legati ad un contratto grazie all'id del contratto
     * @param id identificativo del contratto
     * @return lista dei servizi associati al contratto
     * @throws java.sql.SQLException
     */
    public ArrayList<Servizio> getServizioContratto(Integer id) throws SQLException {

        ArrayList<Servizio> list = new ArrayList<Servizio>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servizio servizio = null;

        String sql = "SELECT idServizio,descrizione,disponibilita,quantita,tipo,prezzo,iva,note" +
                " FROM contratto, serviziAssociati, servizio " +
                "WHERE contratto.idContratto=serviziAssociati.contratto AND" +
                "serviziAssociati.servizio=servizio.idServizio AND idContratto= ?";
        // Create a statement
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setInt(1, id);
        // Execute the query
        rs = stmt.executeQuery(sql);

        while (rs.next()) {

            servizio = new Servizio(rs.getInt(1), rs.getString(2), rs.getBoolean(2),
                    rs.getInt(3), rs.getString(4), rs.getDouble(5),
                    rs.getInt(6), rs.getString(8));

            list.add(servizio);
        }
        stmt.close();
        rs.close();
        ConnectionPool.releaseConnection(conn);
        return list;
    }

    public Contratto modifica(Contratto bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
