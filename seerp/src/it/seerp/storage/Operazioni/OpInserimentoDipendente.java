/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Dipendente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.seerp.storage.db.ConnectionPool;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpInserimentoDipendente {

     public void insert (Dipendente dipendente) throws SQLException
    {
        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Dipendente VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, dipendente.getIdUtente());
            stmt.setString(2, dipendente.getUsername());
            stmt.setString(3, dipendente.getPassword());
            stmt.setString(4, dipendente.getCittà());
            stmt.setString(5, dipendente.getProvincia());
            stmt.setString(6, dipendente.getTelefono());
            stmt.setString(7, dipendente.getEmail());
            stmt.setString(8, dipendente.getNote());
            stmt.setInt(9, dipendente.getIdPersonale());
            stmt.setString(10, dipendente.getCognome());
            stmt.setString(11, dipendente.getNome());
            stmt.setString(12, dipendente.getCodiceFiscale());
            stmt.setString(13, dipendente.getTipo());
            stmt.setArrayList(14, dipendente.getListaPermessi());
            stmt.setArrayList(15, dipendente.getListaRuoli());
            stmt.setInt(16, dipendente.getIdDipendente());
            stmt.setArrayList(17, dipendente.getListAppuntamenti());
            stmt.setArrayList(18, dipendente.getListContratti());

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
