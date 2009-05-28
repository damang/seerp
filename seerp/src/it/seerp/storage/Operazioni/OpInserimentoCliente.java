/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.seerp.storage.db.ConnectionPool;
import java.util.ArrayList;
/**
 *
 * @author LuNy

public class OpInserimentoCliente {

    public void insert (Cliente cliente) throws SQLException
    {
        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Cliente VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, cliente.getIdUtente());
            stmt.setString(2, cliente.getUsername());
            stmt.setString(3, cliente.getPassword());
            stmt.setString(4, cliente.getCittà());
            stmt.setString(5, cliente.getProvincia());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getNote());
            stmt.setInt(9, cliente.getIdExtraAzienda());
            stmt.setString(10, cliente.getCognome());
            stmt.setString(11, cliente.getNome());
            stmt.setString(12, cliente.getRagioneSociale());
            stmt.setString(13, cliente.getPIva());
            stmt.setString(14, cliente.getFax());
            stmt.setString(15, cliente.getRuolo());
            stmt.setArrayList(16, cliente.getListAppuntamenti());
            stmt.setArrayList(17, cliente.getListContratti());
            stmt.setInt(18, cliente.getIdCliente());


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