/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;


import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpResponsabile extends OpeUtente {

    public OpResponsabile(){
    super();}

  /*  public void insert (Responsabile responsabile) throws SQLException
    {
        Connection conn=null;
        PreparedStatement stmt = null;
    	try {
            // Obtain a db connection
            conn = ConnectionPool.getConnection();

            // Create a statement

            String query = "INSERT INTO Responsabile VALUE (?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);

            stmt.setInt(1, responsabile.getIdPersonale());
            stmt.setString(2, responsabile.getCognome());
            stmt.setString(3, responsabile.getNome());
            stmt.setString(4, responsabile.getCodiceFiscale());
            stmt.setString(5, responsabile.getTipo());
            stmt.setArrayList(6, responsabile.getListp());
            stmt.setArrayList(7, responsabile.getListr());
            stmt.setInt(8, responsabile.getIdResponsabile());

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
}*/




    
     public ArrayList<Responsabile> elencaResponsabile()throws SQLException{
     throw new UnsupportedOperationException("Not supported yet.");}


    public  ArrayList<Responsabile> ricercaResponsabile(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    public void elimina(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    public void eliminazioneLogica(Responsabile user)throws SQLException{ 
        throw new UnsupportedOperationException("Not supported yet.");}


    public void inserisci(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    public Responsabile modifica(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

public Responsabile visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}}