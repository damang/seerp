

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

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * classe per la gestione  ExtraAzienda
 * @author LuNy
*/


public class OpExtraAzienda extends OpeUtente {

    Connection con = null;

     public OpExtraAzienda()throws SQLException {
        super();
        con = ConnectionPool.getConnection();
    }

     /** Metodo che permette la visualizzazione della lista del personale ExtraAzienda
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException*/

    public ArrayList<ExtraAzienda> elencaExtraAzienda()throws SQLException{

        ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM ExtraAzienda where Visible='true'";
            stmt = (PreparedStatement) con.prepareStatement(sql);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                        
                list.add(extraazienda);
            }}

        catch (SQLException se) {
            System.out.println("errore nella visualizzazione dell'elenco");

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
        }return list;

       }


     /** Metodo che permette la ricerca di un membro del personale ExtraAzienda
      * @param cognome
      * cognome del membro del personale da ricercare
      * @param ruolo
      * ruolo che il membro del personale ricopre all'interno dell'azienda
      * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException*/
  
     public  ArrayList<ExtraAzienda> ricercaExtraAzienda(String cognome, String ruolo)throws SQLException{

         ArrayList<ExtraAzienda> list = new ArrayList<ExtraAzienda>();
            
             Statement stmt = null;
             ResultSet rs = null;

            try {
           String sql = "SELECT * FROM ExtraAzienda where cognome = ? AND ruolo = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, cognome);
            stmt.setString(2, ruolo);
            // Execute the query
            rs = stmt.executeQuery(sql);

            // Define the resource list
            while (rs.next()) {
                 ExtraAzienda extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );

            }}

              catch (SQLException se) {
            System.out.println("errore nella ricerca");

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
        return list;

       }


     /** Metodo che permette di eliminare un membro del personale ExtraAzienda già esistente
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException*/
   
     public void elimina(ExtraAzienda user)throws SQLException{

         PreparedStatement stmt = null;
            try {
           String sql = "DELETE * FROM ExtraAzienda where username =?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            // Execute the query
            stmt.executeQuery(sql);
 }

              catch (SQLException se) {
            System.out.println("errore nell'eliminazione del personale");

        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
     }

        


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException*/
  
     public void eliminazioneLogica(ExtraAzienda user)throws SQLException{

          PreparedStatement stmt = null;

            try {
           String sql = "UPDATE ExtraAzienda SET Visible='false' where username = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);

            // Execute the query
            stmt.executeQuery();
                  
            } catch (SQLException se) {
            System.out.println("errore nell'eliminazione logica dell'utente");

        } finally {
            // Release the resources
            
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
        
        }


    /** Metodo per inserire un nuovo membro del personale ExtraAzienda
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException*/
    
    public void inserisci(ExtraAzienda user)throws SQLException,DatiDuplicatiEx{
         PreparedStatement stmt = null;
        try {

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
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getRuolo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getRuolo());
            stmt.setString(10, user.getNote());
            stmt.setBoolean(11, user.getVisible());
            stmt.setInt(12, user.getIdExtraAzienda());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());
           

            stmt.execute();
            }
        } catch (SQLException se) {
            System.out.println("errore di inserimento del personale");


        } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
      }


    /** Metodo che permette la modifica di un membro del personale ExtraAzienda presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException*/

    public ExtraAzienda modifica(ExtraAzienda user) throws SQLException, DatiErratiEx, DatiDuplicatiEx {
     PreparedStatement stmt = null;
        ExtraAzienda extraazienda = null;

        try {

            Statement stmt1 = con.createStatement();
            String sqlTest =  "SELECT * FROM ExtraAzienda WHERE nome='" + user.getPIva() + "' ";
            ResultSet rs = stmt1.executeQuery(sqlTest);

            if (rs.next()) {
                throw new DatiDuplicatiEx("utente già esistente nel database");
            } else {

            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement("UPDATE ExtraAzienda VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )" + "where idUtente=" + user.getIdUtente());

            stmt.setInt(1, user.getIdUtente());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCittà());
            stmt.setString(5, user.getRuolo());
            stmt.setString(6, user.getProvincia());
            stmt.setString(7, user.getTelefono());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getRuolo());
            stmt.setString(10, user.getNote());
            stmt.setBoolean(11, user.getVisible());
            stmt.setInt(12, user.getIdExtraAzienda());
            stmt.setString(13, user.getCognome());
            stmt.setString(14, user.getNome());
            stmt.setString(15, user.getRagioneSociale());
            stmt.setString(16, user.getPIva());
            stmt.setString(17, user.getFax());
            
            stmt.execute();

                extraazienda = this.visualizzaDati(user.getIdExtraAzienda());
        } 
        }catch (SQLException se) {
            System.out.println("errore nella modifica");


           } finally {
            // Release the resources
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                ConnectionPool.releaseConnection(con);
            }
        }
      return extraazienda;

       }

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale ExtraAzienda
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException*/

    public ExtraAzienda visualizzaDati(Integer id) throws SQLException{

        ExtraAzienda extraazienda = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM ExtraAzienda where idUtente= ? ";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, id.toString());
            // Execute the query
            rs = stmt.executeQuery();
            
            // Define the resource list
            while (rs.next()) {
               extraazienda = new ExtraAzienda (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) );
                                                        
               PreparedStatement stmt1;
               String sql2 = "Select nome From Appuntamento,ExtraAzienda where idAppuntamento=appuntamento and idExtraAzienda = ?";
                stmt1 = (PreparedStatement) con.prepareStatement(sql2);
                stmt1.setInt(1, extraazienda.getIdExtraAzienda());
                ResultSet rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    Appuntamento appuntamento = new Appuntamento(rs.getString(1));
                    extraazienda.addAppuntamento(appuntamento);

               PreparedStatement stmt2;
               String sql3 = "Select nome From Contratto,ExtraAzienda where idContratto=contratto and idExtraAzienda = ?";
                stmt2 = (PreparedStatement) con.prepareStatement(sql3);
                stmt2.setInt(1, extraazienda.getIdExtraAzienda());
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    Contratto contratto = new Contratto(rs.getString(1));
                    extraazienda.addContratto(contratto);
            }}
        }}
         catch (SQLException se) {
            System.out.println("errore di visualizzazione");

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


        return extraazienda;

       }

     /**
     * metodo che si occupa di ricercare tutti gli appuntamenti legati ad un cliente grazie all'id del cliente
     * @param id identificativo del cliente
     * @return lista degli appuntamenti associati al cliente
     * @throws java.sql.SQLException*/

    public ArrayList<Appuntamento> getAppuntamentiExtraAzienda(Integer id) throws SQLException {

        ArrayList<Appuntamento> list = new ArrayList<Appuntamento>();
       
        Statement stmt = null;
        ResultSet rs = null;

     try {
            String sql = "Select nome From Appuntamento,ExtraAzienda where idAppuntamento=appuntamento and idExtraAzienda = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, id);
            // Execute the query
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Appuntamento appuntamento = new Appuntamento(rs.getString(1));
                list.add(appuntamento);
            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione degli appuntamenti");
            

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
        return list;
    }

/**
     * metodo che si occupa di ricercare tutti i contratti legati ad un ExtraAzienda grazie all'id dell'ExtraAzienda
     * @param id identificativo del cliente
     * @return lista dei contratti associati al cliente
     * @throws java.sql.SQLException*/

    public ArrayList<Contratto> getContrattiExtraAzienda(Integer id) throws SQLException {

        ArrayList<Contratto> list = new ArrayList<Contratto>();
      
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "Select nome From Contratto,ExtraAzienda where idContratto=contratto and idExtraAzienda = ?";
            // Create a statement
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, id);
            // Execute the query
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Contratto contratto = new Contratto(rs.getString(1));
                list.add(contratto);
            }
        } catch (SQLException se) {
            System.out.println("errore nella visualizzazione dei contratti");


            

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
        return list;
    }

}
