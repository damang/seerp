/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Dipendente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpDipendente extends OpPersonale {

   public OpDipendente(){
    super();
    }

    /** Metodo che permette la visualizzazione
     * della lista dei Dipendenti
     * @return ArrayList contenente la lista dei Dipendenti
     * @throws java.sql.SQLException
     */
    public ArrayList<Dipendente> elencaDipendente()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un Dipendente
      * @param cognome
      * cognome del Dipendente da ricercare
      * @param ruolo
      * ruolo che il Dipendente ricopre all'interno dell'azienda
      * @return la lista dei Dipendenti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Dipendente> ricercaDipendente(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Dipendente già esistente
      * @param user
      * user del Dipendente da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Dipendente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Nasconde il Dipendente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user del Dipendente da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Dipendente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Dipendente
     * @param user
     * user del Dipendente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Dipendente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un Dipendente presente nel sistema
     * @param user
     * user del Dipendente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Dipendente modifica(Dipendente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Dipendente
     * @param id
     * id del Dipendente
     * @return il bean con i dettagli del Dipendente
     * @throws java.sql.SQLException
     */
    public Dipendente visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


}
