/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.ExtraAzienda;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpExtraAzienda extends OpeUtente {

     public OpExtraAzienda(){
    super();
    }

     /** Metodo che permette la visualizzazione della lista del personale ExtraAzienda
     * @return ArrayList contenente la lista del personale
     * @throws java.sql.SQLException
     */
    public ArrayList<ExtraAzienda> elencaExtraAzienda()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un membro del personale ExtraAzienda
      * @param cognome
      * cognome del membro del personale da ricercare
      * @param ruolo
      * ruolo che il membro del personale ricopre all'interno dell'azienda
      * @return la lista dei membri del personale che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<ExtraAzienda> ricercaExtraAzienda(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un membro del personale ExtraAzienda già esistente
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(ExtraAzienda user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user dell'utente da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(ExtraAzienda user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo membro del personale ExtraAzienda
     * @param user
     * user dell'utente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(ExtraAzienda user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un membro del personale ExtraAzienda presente nel sistema
     * @param user
     * user del membro del personale da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public ExtraAzienda modifica(ExtraAzienda user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un membro del personale ExtraAzienda
     * @param id
     * id del membro del personale
     * @return il bean con i dettagli del membro del personale
     * @throws java.sql.SQLException
     */
    public ExtraAzienda visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}
}
