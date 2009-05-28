/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Amministratore;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpAmministratore extends OpPersonale{

    public OpAmministratore(){
    super();
    }


    /** Metodo che permette la visualizzazione dei dettagli dell'Amministratore
     * @return il bean con i dettagli del'amministratore
     * @throws java.sql.SQLException
     */
    public Amministratore visualizzaDati() throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}
}
