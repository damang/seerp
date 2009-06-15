package it.seerp.storage.Operazioni;

import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Servizio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import com.sun.xml.internal.bind.v2.model.core.ID;
import it.seerp.storage.ejb.ServizioAssociato;

/**
 * classe storage che si occupa di interfacciarsi col DBMS e compiere operazioni sui contratti
 * @author Luisa-Ila
 */
public class OpContratto implements OpeEntity<Contratto, BeanGuiContratto> {

    private Connection conn;

    public OpContratto() throws SQLException {
        conn = (Connection) ConnectionPool.getConnection();
    }

    public void inserimento(Contratto contratto) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO Contratto VALUES (?, ?, ?, ?, ?, ?, ? )" + "where idContratto=" + contratto.getIdContratto();

            stmt = (PreparedStatement) conn.prepareStatement(query);

            stmt.setInt(2, contratto.getDurata());
            stmt.setString(3, contratto.getStato());
            stmt.setString(4, contratto.getTipo());
            stmt.setInt(5, contratto.getExtraAzienda().getIdExtraAzienda());
            stmt.setInt(6, contratto.getDipendente().getIdDipendente());
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(7, sqlDate);
            stmt.setString(8, contratto.getNote());

            stmt.execute();

        } catch (SQLException se) {
            System.out.println("Errore di inserimento del contratto");

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
     * metodo che ricerca i contratti associati a quel dipendente con identificativo uguale a id
     * @param id identificativo del dipendente
     * @return una lista dei contratti ricercati in base all'identificati vo del dipendente
     * @throws java.sql.SQLException     
     */
    public ArrayList<Contratto> ricercaPerDipendente(Integer id) throws SQLException {

        ArrayList<BeanGuiContratto> lista = this.visualizzaElenco();
        ArrayList<Contratto> b = new ArrayList<Contratto>();
        for (BeanGuiContratto a : lista) {
            Contratto contr = it.seerp.application.conversioni.Conversione.conversioneContratto(a);
            b.add(contr);
        }
        return b;



    }

    /**
     * metodo che ricerca tutti i contratti
     * @return una lista dei contratti ricercati  in base all'identificativo del dipendente
     * @throws java.sql.SQLException
     */
    public ArrayList<BeanGuiContratto> visualizzaElenco() throws SQLException {

        ArrayList<BeanGuiContratto> lista = new ArrayList<BeanGuiContratto>();
        BeanGuiContratto gui = new BeanGuiContratto();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Contratto";
            stmt = (PreparedStatement) conn.prepareStatement(sql);

            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(2).getTime());


                Contratto contratto = new Contratto(rs.getString(1), date,
                        rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));


                lista.add(it.seerp.application.conversioni.Conversione.conversioneContratto(contratto, gui));
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


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
     * metodo che si occupa della modifica di una tupla di contratto
     * @param contratto che contiene le informazioni da modificare
     * @return contratto dopo la query di update
     * @throws java.sql.SQLException
     *
     */
    public Contratto modifica(Contratto contr) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        ArrayList<Pagamento> listPag = contr.getListPagamento();
        try {

            stmt = (PreparedStatement) conn.prepareStatement("UPDATE Pagamento, Contratto " +
                    "(modalitàPagamento)SET (?)" + "where Pagamento.contratto=" +
                    "Contratto.idContratto and Contratto.idContratto='" +
                    contr.getIdContratto() + "'");

            for (Pagamento p : listPag) {
                stmt.setString(1, p.getModalitaPagamento());
                stmt.execute();
                listPag.add(p);
            }

        } catch (SQLException se) {
            System.out.println("Errore nella modifica della modalità pagamenti di contratto");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }
        return contr;
    }

    /**
     * ricerca il contratto con quell'identificativo
     * @param nome identificativo del contratto
     * @return un contratto con identificativo uguale al paramtero nome
     * @throws java.sql.SQLException
     */
    public Contratto visualizza(BeanGuiContratto bean) throws SQLException {
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contratto contratto = null;

        try {
            String sql="SELECT * FROM Contratto WHERE idContratto= ?";
            stmt = (PreparedStatement) conn.prepareStatement(sql);

            stmt.setString(1,bean.getIdContratto().toString());
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                GregorianCalendar date = new GregorianCalendar();
                date.setTimeInMillis(rs.getDate(7).getTime());

                contratto = new Contratto( rs.getString(4), date,rs.getInt(1),
                        rs.getString(3),rs.getInt(2),  rs.getString(8));
             
                PreparedStatement stmt1;
                String sql2="SELECT * FROM contratto,serviziassociati " +
                        "WHERE contratto.idContratto=serviziassociati.contratto AND idContratto=?";
                stmt1=(PreparedStatement) conn.prepareStatement(sql2);
                stmt1.setInt(1, contratto.getIdContratto());
                ResultSet rs2=stmt1.executeQuery();
                while (rs2.next())
                {
                    /*Integer quantita, Double prezzoUnitario, String note*/
                   ServizioAssociato sa=new ServizioAssociato(rs.getInt(2),rs.getDouble(3),rs.getString(4));
                   contratto.addServizio(sa);
                }
               }
        } catch (SQLException se) {
            System.out.println("Errore nella visualizzazione dei dati del contratto");

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

        try {
            String sql = "SELECT * FROM contratto, serviziAssociati, servizio " +
                    "WHERE contratto.idContratto=serviziAssociati.contratto AND" +
                    " serviziAssociati.servizio=servizio.idServizio AND idContratto= ?";
            // Create a statement
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setInt(1, id);
            // Execute the query
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                /*Integer idServizio, String descrizione, Boolean disponibilita, Integer quantita, String tipo, Double prezzo, Integer iva, String note, ArrayList<ServizioAssociato> listServiAssociati*/

                Servizio servizio = new Servizio(rs.getInt(1), rs.getString(2), rs.getBoolean(2),
                        rs.getInt(3), rs.getString(4), rs.getDouble(5),
                        rs.getInt(6), rs.getString(8));

                list.add(servizio);
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");


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
}
