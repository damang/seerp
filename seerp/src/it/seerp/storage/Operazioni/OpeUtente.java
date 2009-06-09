
package it.seerp.storage.Operazioni;


import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpeUtente implements OpeEntity<Utente,Integer> {

/*public ArrayList<BeanGuiUtente> visualizzaElenco() throws SQLException {
        ArrayList<BeanGuiUtente> list = new ArrayList<BeanGuiUtente>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            // Create a statement
            stmt = conn.createStatement();
            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM Utente");

             // Define the resource list
            while (rs.next()) {
                Utente utente = new Utente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9));
                                    //(1Integer idUtente, 2String username, 3Integer password, 4String città, 5String provincia, 6String telefono, 7String email, 8String note, 9Boolean v )
                list.add(utente);
            }}

            

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
        }return list;



        //modifica
        public BeanGuiUtente modifica(Utente utente) throws SQLException {
        // throw new UnsupportedOperationException("Not supported yet.");
        ArrayList<BeanGuiUtente> list = new ArrayList<BeanGuiUtente>();
        Connection conn = null;


        try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();
            PreparedStatement stmt = null;
            // Create a statement
            stmt = conn.prepareStatement("UPDATE Utente VALUES (?, ?, ?, ?, ?, ? )");
            stmt.setInt(1, contratto.getDurata());
            stmt.setDate(2, contratto.getData());
            stmt.setString(3, contratto.getTipo());
            stmt.setString(4, contratto.getNote());
            stmt.setInt(5, contratto.getDipendente());
            stmt.setInt(6, contratto.getExtraAzienda()); // devo modificare non ti spaventare


        } finally {

            if (conn != null) {
                ConnectionPool.releaseConnection(conn);
            }
        }

    }*/

    public void inserimento(Utente Bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utente modifica(Utente Bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utente visualizza(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Utente> elenca() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Utente> ricerca(String nome, String ruolo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utente  eliminaLogica(Utente ut) throws SQLException{
    throw new UnsupportedOperationException("Not supported yet.");}

    public void  elimina(Utente ut) throws SQLException{
    throw new UnsupportedOperationException("Not supported yet.");}

    public ArrayList<Utente> visualizzaElenco() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Integer getId(String u, String pw)throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
}
}



