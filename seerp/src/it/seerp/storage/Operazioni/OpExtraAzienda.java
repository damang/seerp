package it.seerp.storage.Operazioni;

import com.mysql.jdbc.PreparedStatement;

import it.seerp.storage.ejb.ExtraAzienda;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.db.ConnectionPool;
import java.sql.Connection;
import java.util.GregorianCalendar;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * classe per la gestione  ExtraAzienda
 * @author LuNy
 */
public class OpExtraAzienda extends OpeUtente {

    Connection con = null;

    public OpExtraAzienda() throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione della lista del personale ExtraAzienda
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException*/
    public ArrayList<ExtraAzienda> elencaExtraAzienda() throws SQLException {

        ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ExtraAzienda where Visible='true'";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        // Execute the query
        rs = stmt.executeQuery(sql);

        // Define the resource list
        while (rs.next()) {
            ExtraAzienda extraazienda = new ExtraAzienda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            //Integer idUtente, String username, String password, String città, String tipo 5 ,String provincia, String telefono,String cap, String email, String ruolo 10,               String note, Boolean v,           String cognome, String nome, String ragioneSociale 15, String pIva, String fax) {

            list.add(extraazienda);
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return list;

    }

    /** Metodo che permette la ricerca di un membro del personale ExtraAzienda
     * @param cognome
     * cognome del membro del personale da ricercare
     * @param ruolo
     * ruolo che il membro del personale ricopre all'interno dell'azienda
     * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<ExtraAzienda> ricercaExtraAzienda(String cognome, String ruolo) throws SQLException {

        ArrayList<ExtraAzienda> list = this.elencaExtraAzienda();
        return list;
    }

    /** Metodo che permette di eliminare un membro del personale ExtraAzienda già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(ExtraAzienda user) throws SQLException {

        PreparedStatement stmt = null;

        String sql = "DELETE * FROM ExtraAzienda where username =?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        // Execute the query
        stmt.executeQuery(sql);


        stmt.close();
        ConnectionPool.releaseConnection(con);
    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void eliminazioneLogica(ExtraAzienda user) throws SQLException {

        PreparedStatement stmt = null;


        String sql = "UPDATE ExtraAzienda SET Visible='false' where username = ?";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);

        // Execute the query
        stmt.executeQuery();

        stmt.close();
        ConnectionPool.releaseConnection(con);
    }

    /** Metodo per inserire un nuovo membro del personale ExtraAzienda
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException*/
    public void inserisci(ExtraAzienda user) throws SQLException, DatiDuplicatiEx {
        PreparedStatement stmt = null;
        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM ExtraAzienda WHERE nome='" + user.getPIva() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("utente già esistente nel database");
        } else {
            String sql = "INSERT INTO ExtraAzienda (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getTipo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getCap());
            stmt.setString(9, user.getEmail());
            stmt.setString(10, user.getRuolo());
            stmt.setString(11, user.getNote());
            stmt.setBoolean(12, user.getVisible());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());


            stmt.execute();
        }
        stmt.close();
        ConnectionPool.releaseConnection(con);

    }

    /** Metodo che permette la modifica di un membro del personale ExtraAzienda presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/
    public ExtraAzienda modifica(ExtraAzienda user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
        PreparedStatement stmt = null;
        ExtraAzienda extraazienda = null;



        Statement stmt1 = con.createStatement();
        String sqlTest = "SELECT * FROM ExtraAzienda WHERE nome='" + user.getPIva() + "' ";
        ResultSet rs = stmt1.executeQuery(sqlTest);

        if (rs.next()) {
            throw new DatiDuplicatiEx("utente già esistente nel database");
        } else {

            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE ExtraAzienda VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCitta());
            stmt.setString(5, user.getTipo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getCap());
            stmt.setString(9, user.getEmail());
            stmt.setString(10, user.getRuolo());
            stmt.setString(11, user.getNote());
            stmt.setBoolean(12, user.getVisible());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());

            stmt.execute();

        }
        stmt.close();
        ConnectionPool.releaseConnection(con);

        return extraazienda;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale ExtraAzienda
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException*/
    public ExtraAzienda visualizzaDati(Integer id) throws SQLException {

        ExtraAzienda extraazienda = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ExtraAzienda where idUtente= ? ";
        // Create a statement
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, id.toString());
        // Execute the query
        rs = stmt.executeQuery();

        // Define the resource list
        while (rs.next()) {
            extraazienda = new ExtraAzienda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            //Integer idUtente, String username, String password, String città, String ruol 5 ring provincia, String telefono, String email, String ruolo, String cap10String note, Boolean v, Integer idExtraAzienda, String cognome, String nome15String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti) {

            PreparedStatement stmt1;
            String sql2 = "Select nome From Appuntamento,ExtraAzienda where idAppuntamento=appuntamento and idExtraAzienda = ?";
            stmt1 = (PreparedStatement) con.prepareStatement(sql2);
            stmt1.setInt(1, extraazienda.getIdUtente());
            ResultSet rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                GregorianCalendar data1 = new GregorianCalendar();
                GregorianCalendar ora = new GregorianCalendar();
                ora.setTimeInMillis(Long.parseLong(rs.getString(2)));
                data1.setTimeInMillis(Long.parseLong(rs.getString(1)));
                Appuntamento appuntamento = new Appuntamento(data1, ora, rs.getInt(3), rs.getString(4), rs.getBoolean(5));
                extraazienda.addAppuntamento(appuntamento);

                PreparedStatement stmt2;
                String sql3 = "Select nome From Contratto,ExtraAzienda where idContratto=contratto and idExtraAzienda = ?";
                stmt2 = (PreparedStatement) con.prepareStatement(sql3);
                stmt2.setInt(1, extraazienda.getIdUtente());
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    GregorianCalendar data = new GregorianCalendar();
                    data.setTimeInMillis(Long.parseLong(rs.getString(2)));
                    Contratto contratto = new Contratto(rs.getString(1), data, rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));


                    extraazienda.addContratto(contratto);
                }
            }
        }
        rs.close();
        stmt.close();
        ConnectionPool.releaseConnection(con);
        return extraazienda;
    }
}
