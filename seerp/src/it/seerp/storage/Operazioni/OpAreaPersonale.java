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
        Personale per=new  Personale();/* = (Personale) super.visualizza(usr);*/
        String sql="SELECT username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita, nome, cognome, codicefiscale,ruolo FROM utente, personale WHERE idUtente=idPersonale and username=?";
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, usr);
     
        rs=stmt.executeQuery();
        while(rs.next()){
            per.setUsername(rs.getString(1));
            per.setPassword(rs.getString(2));
            per.setEmail(rs.getString(3));
            per.setCitta(rs.getString(4));
            per.setProvincia(rs.getString(5));
            per.setTelefono(rs.getString(6));
            per.setCap(rs.getString(7));
            per.setNote(rs.getString(8));
            per.setTipo(rs.getString(9));
            per.setVisible(rs.getBoolean(10));
            per.setNome(rs.getString(11));
            per.setCognome(rs.getString(12));
            per.setCodiceFiscale(rs.getString(13));
            per.setRuolo(new Ruolo(rs.getString(14)));
             }
        return per;
    }


      public ExtraAzienda visualizzaDatiExtraAzienda(String usr) throws SQLException {
        ResultSet rs=null;
        ExtraAzienda extra = (ExtraAzienda) super.visualizza(usr);
        String sql="SELECT username,password,email,citta,prov,telefono,CAP,note,tipo,visibilita" +
                   "nome, cognome,fax,piva,ragioneSociale,ruolo,codicefiscale," +
                   "FROM utente join extraazienda on idUtente=idExtraAzienda" +
                   "WHERE username=?";
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setString(1, usr);
        rs=stmt.executeQuery();
        while(rs.next()){
           extra.setUsername(rs.getString(1));
           extra.setPassword(rs.getString(2));
           extra.setEmail(rs.getString(3));
           extra.setCitta(rs.getString(4));
           extra.setProvincia(rs.getString(5));
           extra.setTelefono(rs.getString(6));
           extra.setCap(rs.getString(7));
           extra.setNote(rs.getString(8));
           extra.setTipo(rs.getString(9));
           extra.setVisible(rs.getBoolean(10));
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
