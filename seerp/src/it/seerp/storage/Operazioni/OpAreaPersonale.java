package it.seerp.storage.Operazioni;

import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.Operazioni.OpPersonale;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Ruolo;
import java.sql.ResultSet;


/**
 *
 * @author Ila
 */
public class OpAreaPersonale extends OpeUtente {

    private Connection conn;

    /**
     *
     * @throws java.sql.SQLException
     */
    public OpAreaPersonale() throws SQLException {

        conn = (Connection) ConnectionPool.getConnection();

    }

    /** Metodo che permette la visualizzazione dei dettagli
     * di un membro del personale nella propria area personale
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException*/

       public Personale visualizzaDatiPersonale(String usr) throws SQLException {

        ResultSet rs=null;
        Personale per = (Personale) super.visualizza(usr);
        String sql="SELECT nome, cognome, codicefiscale,ruolo " +
                   "FROM utente join personale on idUtente=idPersonale" +
                   "WHERE username=?";
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, usr);
        rs=stmt.executeQuery();
        while(rs.next()){
            per.setNome(rs.getString(1));
            per.setCognome(rs.getString(2));
            per.setCodiceFiscale(rs.getString(3));
            per.setRuolo(new Ruolo(rs.getString(4)));
        }
        return per;
    }


      public ExtraAzienda visualizzaDatiExtraAzienda(String usr) throws SQLException {
        ResultSet rs=null;
        ExtraAzienda extra = (ExtraAzienda) super.visualizza(usr);
        String sql="SELECT nome, cognome,fax,piva,ragioneSociale,ruolo,codicefiscale " +
                   "FROM utente join extraazienda on idUtente=idExtraAzienda" +
                   "WHERE username=?";
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, usr);
        rs=stmt.executeQuery();
        while(rs.next()){
           extra.setNome(rs.getString(1));
           extra.setCognome(rs.getString(2));
           extra.setFax(rs.getString(3));
           extra.setPIva(rs.getString(4));
           extra.setRagioneSociale(rs.getString(5));
           extra.setRuolo(rs.getString(6));
           extra.setCodiceFiscale(rs.getString(7));
        }
        return extra;
    }

    /** Metodo che permette la modifica della password
     * di un membro del personale nella propria area personale
     * @param u il bean di utente
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException
     * @throws DatiErratiEx se si modifica con una password errata
     */
    public Utente modificaPassword(Utente u) throws SQLException, DatiErratiEx {

        PreparedStatement stmt = null;

        String sql = "UPDATE utente SET password=? where username=?";
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, u.getPassword());
        stmt.setString(2, u.getUsername());

        stmt.execute();
        stmt.close();
        ConnectionPool.releaseConnection(conn);

        return u;
    }
}
