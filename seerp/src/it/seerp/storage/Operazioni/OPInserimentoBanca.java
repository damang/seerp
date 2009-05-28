/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Banca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.seerp.storage.db.ConnectionPool;
import java.util.ArrayList;


/**
 *
 * @author LuNy
 
public class OPInserimentoBanca {

    public void insert (Banca banca) throws SQLException
    {
        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Banca VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, banca.getAgenzia());
            stmt.setString(2, banca.getAbi());
            stmt.setString(3, banca.getCab());
            stmt.setString(4, banca.getCittà());
            stmt.setString(5, banca.getProvincia());
            stmt.setString(6, banca.getIndirizzo());
            stmt.setString(7, banca.getCap());
            stmt.setString(8, banca.getFiliale());
            stmt.setString(9, banca.getNazione());
            stmt.setDouble(10, banca.getImportoInDare());
            stmt.setDouble(11, banca.getImportoInAvere());
            stmt.setArrayList(12, banca.getListPagamento());
           

            stmt.executeUpdate();

            conn.commit();
    }

            catch(SQLException e){
                e.getMessage();


       }


        finally{
            if (stmt != null)
            	stmt.close();
        	if (conn != null)
        	ConnectionPool.releaseConnection(conn);

        }
}


}
*/