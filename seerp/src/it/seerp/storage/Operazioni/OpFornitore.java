/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpFornitore extends OpExtraAzienda {

    public OpFornitore(){
    super();
    }

    /** Metodo che permette la visualizzazione della lista dei Fornitori
     * @return ArrayList contenente la lista dei  Fornitori
     * @throws java.sql.SQLException
     */
    public ArrayList<Fornitore> elencaFornitore()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un Fornitore
      * @param cognome
      * cognome del Fornitore da ricercare
      * @param ruolo
      * ruolo che il Fornitore ricopre all'interno dell'azienda
      * @return la lista dei Fornitori che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Fornitore> ricercaFornitore(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Fornitore già esistente
      * @param user
      * user del Fornitore da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Fornitore user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user del Fornitore da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Fornitore user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Fornitore
     * @param user
     * user del Fornitore da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Fornitore user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un Fornitore presente nel sistema
     * @param user
     * user del Fornitore da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Fornitore modifica(Fornitore user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Fornitore
     * @param id
     * id del Fornitore
     * @return il bean con i dettagli del Fornitore
     * @throws java.sql.SQLException
     */
    public Fornitore visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


}
