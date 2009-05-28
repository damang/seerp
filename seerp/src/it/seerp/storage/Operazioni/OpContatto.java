/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Contatto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuNy
 */
public class OpContatto extends OpExtraAzienda{

     public OpContatto(){
    super();
    }
     
      /** Metodo che permette la visualizzazione della lista dei Contatti
     * @return ArrayList contenente la lista dei Contatti
     * @throws java.sql.SQLException
     */
    public ArrayList<Contatto> elencaContatto()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un Contatto
      * @param cognome
      * cognome del Contatto da ricercare
      * @param ruolo
      * ruolo che il Contatto ricopre all'interno dell'azienda
      * @return la lista dei Contatti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Contatto> ricercaContatto(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Contatto già esistente
      * @param user
      * user del Contatto da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Contatto user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Nasconde il Contatto eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user del Contatto da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Contatto user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Contatto
     * @param user
     * user del Contatto da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Contatto user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un Contatto presente nel sistema
     * @param user
     * user del Contatto da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Contatto modifica(Contatto user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Contatto
     * @param id
     * id del Contatto
     * @return il bean con i dettagli del Contatto
     * @throws java.sql.SQLException
     */
    public Contatto visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

}
