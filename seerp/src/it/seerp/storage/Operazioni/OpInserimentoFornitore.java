/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Fornitore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.seerp.storage.db.ConnectionPool;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 
public class OpInserimentoFornitore {

     public void insert (Fornitore fornitore) throws SQLException
    {
        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Fornitore VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, fornitore.getIdUtente());
            stmt.setString(2, fornitore.getUsername());
            stmt.setString(3, fornitore.getPassword());
            stmt.setString(4, fornitore.getCittà());
            stmt.setString(5, fornitore.getProvincia());
            stmt.setString(6, fornitore.getTelefono());
            stmt.setString(7, fornitore.getEmail());
            stmt.setString(8, fornitore.getNote());
            stmt.setInt(9, fornitore.getIdExtraAzienda());
            stmt.setString(10, fornitore.getCognome());
            stmt.setString(11, fornitore.getNome());
            stmt.setString(12, fornitore.getRagioneSociale());
            stmt.setString(13, fornitore.getPIva());
            stmt.setString(14, fornitore.getFax());
            stmt.setString(15, fornitore.getUsername());
            stmt.setArrayList(16, fornitore.getListAppuntamenti());
            stmt.setArrayList(17, fornitore.getListContratti());
            stmt.setInt(18, fornitore.getIdFornitore());

             stmt.executeUpdate();

            conn.commit();
    }

            catch(SQLException e){


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