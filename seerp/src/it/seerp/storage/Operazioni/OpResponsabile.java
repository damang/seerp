/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpResponsabile extends OpPersonale {

     public OpResponsabile(){
    super();
    }

     /** Metodo che permette la visualizzazione della lista dei Responsabili
     * @return ArrayList contenente la lista dei responsabili
     * @throws java.sql.SQLException
     */
    public ArrayList<Responsabile> elencaResponsabile()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un Responsabile
      * @param cognome
      * cognome del Responsabile da ricercare
      * @param ruolo
      * ruolo che il Responsabile ricopre all'interno dell'azienda
      * @return la lista dei Responsabili che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Responsabile> ricercaResponsabile(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Responsabile già esistente
      * @param user
      * user del Responsabile da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Responsabile
     * @param user
     * user del Responsabile da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un Responsabile presente nel sistema
     * @param user
     * user del Responsabile da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Responsabile modifica(Responsabile user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Responsabile
     * @param id
     * id del Responsabile
     * @return il bean con i dettagli del Responsabile
     * @throws java.sql.SQLException
     */
    public Responsabile visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}
}

