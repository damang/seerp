package it.seerp.storage.Operazioni;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.db.ConnectionPool;
import it.seerp.storage.ejb.Responsabile;


import java.sql.ResultSet;
import java.sql.Statement;

/** Classe riguardante la gestione Personale
 *
 * @author Matteo
 */
public class OpResponsabile extends OpeUtente {

    Connection con = null;

    /**
     * costruttore per la classe
     * @throws java.sql.SQLException
     */
    public OpResponsabile() throws SQLException {
        super();
        con = (Connection) ConnectionPool.getConnection();
    }

    /** Metodo che permette la visualizzazione
     * della lista dei responsabili
     * @return ArrayList contenente la lista dei responsabili
     * @throws java.sql.SQLException*/
    public ArrayList<Responsabile> elencaResponsabile() throws SQLException {

        ArrayList<Responsabile> list = new ArrayList<Responsabile>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
            String sql = "SELECT idUtente,username,password,citta,provincia," +
                    "telefono,cap,email,note,tipo,cognome,nome,codiceFiscale," +
                    "ruolo,visible FROM responsabile,utente,personale WHERE Visible='true' and idPersonale=idUtente " +
                    "and idPersonale=idResponsabile";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {

                /*
                 * Integer idUtente1, String username2, String password3,
            String città4, String provincia5, String telefono6, String cap7, String email8,
            String note9, String tipo10, String cognome11, String nome12, String
            codiceFiscale13, String ruolo14, Boolean v15
                 */
      Responsabile responsabile = new Responsabile(rs.getInt(1), rs.getString(2),
              rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
              rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
              rs.getString(11),rs.getString(12),rs.getString(13), new Ruolo(rs.getString(14)),
              rs.getBoolean(15));

      list.add(responsabile);
       rs.close();
       stmt.close();
       ConnectionPool.releaseConnection(con);
       
        }
        return list;
    }


    /** Metodo che permette la ricerca di un membro dei responsabili
     * @return la lista dei membri dei responsabili che corrispondono ai criteri di ricerca
     * @throws java.sql.SQLException*/
    public ArrayList<Responsabile> ricercaResponsabile() throws SQLException {
        ArrayList<Responsabile> list = this.elencaResponsabile();
        return list;
    }

    /** Metodo che permette di eliminare un membro dei responsabili già esistente
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void elimina(Responsabile user) throws SQLException {
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try{
            con.setAutoCommit(false);
             String sql = "DELETE * FROM utente where username = ?";
             String sql1 ="DELETE * FROM personale where idPersonale=?";
             String sql2 = "DELETE * FROM responsabile where idResponsabile=?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt1= (PreparedStatement) con.prepareStatement(sql1);
            stmt2= (PreparedStatement) con.prepareStatement(sql2);
            stmt.setString(1, user.getUsername());
            stmt1.setInt(1,user.getIdUtente());
            stmt2.setInt(1,user.getIdUtente());
            // Execute the query
            stmt.executeQuery(sql);
            stmt1.executeQuery(sql1);
            stmt2.executeQuery(sql2);
            con.commit();
        }
        catch(SQLException se){
            con.rollback();
            System.out.println("eliminazione fallita");}
    
                stmt.close();
          
                ConnectionPool.releaseConnection(con);
            

    }

    /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
     * @param user
     * user dell'utente da eliminare
     * @throws java.sql.SQLException*/
    public void eliminazioneLogica(Responsabile user) throws SQLException {

        PreparedStatement stmt = null;
                   String sql = "UPDATE utente(visibilita) SET visibilita='false' where username = ? ";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);

            // Execute the query
            stmt.executeQuery();
     
                stmt.close();
          
                ConnectionPool.releaseConnection(con);
             }

    /** Metodo per inserire un nuovo responsabile
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisci(Responsabile user) throws SQLException, DatiDuplicatiEx {


        PreparedStatement stmt = null;
        PreparedStatement stmtP = null;
        PreparedStatement stmtR = null;
        
            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM utente,personale,responsabile WHERE codiceFiscale='" + user.getCodiceFiscale() + "' and idUtente=idPersonale" +
                    "idPersonale=idResponsabile ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("responsabile già esistente nel database");
            } else {
                try{
                    con.setAutoCommit(false);
                String sqlu = "INSERT INTO utente(idUtente,username,password,email,citta,prov,telefono" +
                        "CAP,note,tipo,visibilita) VALUES(LAST_INSERT_ID()+1,?,?,?,?,?,?,?,?,?,?)";
                String sqlp = "INSERT INTO personale(idPersonale,nome,cognome,codicefiscale,ruolo)" +
                        "VALUES(LAST_INSERT_ID(),?,?,?,?)";
                String sqlr = "INSERT INTO responsabile (idResponsabile)" +
                        "VALUES(LAST_INSERT_ID())";

                stmt = (PreparedStatement) con.prepareStatement(sqlu);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getCitta());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getNote());
                stmt.setString(9, user.getTipo());
                stmt.setString(10, user.getVisible().toString());
                stmtP = (PreparedStatement) con.prepareStatement(sqlp);
                stmtP.setString(1, user.getNome());
                stmtP.setString(2, user.getCognome());
                stmtP.setString(3, user.getCodiceFiscale());
                stmtP.setString(4, user.getRuolo().getNome());
                stmtR= (PreparedStatement) con.prepareStatement(sqlr);
                stmtR.execute();
                stmtP.execute();
                stmtR.execute();
                con.commit();
            }catch(SQLException e){
                 con.rollback();
                 System.out.println("inserimento fallito");}
                  
                stmt.close();
                ConnectionPool.releaseConnection(con);
            
        }
    }

    /** Metodo che permette la modifica di un membro dei responsabili presente nel sistema
     * @param user
     * user del membro dei responsabili da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     * @throws DatiErratiEx
     * @throws DatiDuplicatiEx
     */
    public Responsabile modifica(Responsabile user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {

        PreparedStatement stmt = null;
        PreparedStatement stmtP = null;
        
            Statement stmt1 = con.createStatement();
            String sqlTest = "SELECT * FROM utente,personale,responsabile WHERE codiceFiscale='" + user.getCodiceFiscale() + "'" +
                    "and idPersonale=idUtente and idPersonale=idResponsabile ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("dipendente già esistente nel database");
            } else {
 try{
                    con.setAutoCommit(false);
                String sqlu = "UPDATE utente(username,password,email,citta,prov,telefono" +
                        "CAP,note,tipo,visibilita) SET username=?,,password=?,email=?,citta=?,prov=?," +
                        "telefono=?,CAP=?,note=?,tipo=?,visibilita=?";
                String sqlp = "UPDATE personale(nome,cognome,codicefiscale,ruolo)" +
                        "SET nome=?,cognome=?,codicefiscale=?,ruolo=? ";

                stmt = (PreparedStatement) con.prepareStatement(sqlu);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getCitta());
                stmt.setString(5, user.getProvincia());
                stmt.setString(6, user.getTelefono());
                stmt.setString(7, user.getCap());
                stmt.setString(8, user.getNote());
                stmt.setString(9, user.getTipo());
                stmt.setString(10, user.getVisible().toString());
                stmtP = (PreparedStatement) con.prepareStatement(sqlp);
                stmtP.setString(1, user.getNome());
                stmtP.setString(2, user.getCognome());
                stmtP.setString(3, user.getCodiceFiscale());
                stmtP.setString(4, user.getRuolo().getNome());
                stmt.execute();
                stmtP.execute();
                con.commit();
            }catch(SQLException e){
                 con.rollback();
                  System.out.println("modifica fallita");  }

            }
       
                stmt.close();
           
                ConnectionPool.releaseConnection(con);
       
        return user;

    }

    /** Metodo che permette la visualizzazione dei dettagli di un membro dei responsabili
     * @param id
     * id del membro dei responsabili
     * @return il bean con i dettagli del membro del personale
     * @throws SQLException
     */
    public Responsabile visualizzaDati(Integer id) throws SQLException {
        Responsabile responsabile = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


            String sql = "SELECT * FROM utente,personale,responbile where idPersonale=idUtente and idPersonale=idResponsabile and idResponsabile= ? ";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery();

            // Define the resource list
            while (rs.next()) {
                /*
                 * Integer idUtente1, String username2, String password3, String città4, String provincia5,
                 String telefono6, String cap7, String email8, String note9, String tipo10, String cognome11,
                 String nome12, String codiceFiscale13, Ruolo ruolo14, Boolean v15
                 */
                responsabile = new Responsabile(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                         new Ruolo(rs.getString(14)), rs.getBoolean(15));

                }
          
                rs.close();
           
                stmt.close();
            
                ConnectionPool.releaseConnection(con);
      

        return responsabile;

    }
}
