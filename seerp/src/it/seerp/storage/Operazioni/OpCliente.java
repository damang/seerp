/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.ejb.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LuNy
 */
public class OpCliente extends OpExtraAzienda {

    public OpCliente(){
    super();
    }


    /** Metodo che permette la visualizzazione della lista dei Clienti
     * @return ArrayList contenente la lista dei Clienti
     * @throws java.sql.SQLException
     */
    public ArrayList<Cliente> elencaCliente()throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette la ricerca di un Cliente
      * @param cognome
      * cognome del Cliente da ricercare
      * @param ruolo
      * ruolo che il Cliente ricopre all'interno dell'azienda
      * @return la lista dei Clienti che corrispondono ai criteri di ricerca
      * @throws java.sql.SQLException
      */
     public  ArrayList<Cliente> ricercaCliente(String cognome, String ruolo)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Metodo che permette di eliminare un Cliente già esistente
      * @param user
      * user del Cliente da eliminare
      * @throws java.sql.SQLException
      */
     public void elimina(Cliente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


     /** Nasconde l'utente eliminato al sistema senza l'eliminazione fisica
      * @param user
      * user del Cliente da eliminare
      * @throws java.sql.SQLException
      */
     public void eliminazioneLogica(Cliente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo per inserire un nuovo Cliente
     * @param user
     * user del Cliente da inserire
     * @throws java.sql.SQLException
     */
    public void inserisci(Cliente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


    /** Metodo che permette la modifica di un Cliente presente nel sistema
     * @param user
     * user del Cliente da modificare
     * @return lo stesso oggetto modificato
     * @throws java.sql.SQLException
     */
    public Cliente modifica(Cliente user)throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}

    /** Metodo che permette la visualizzazione dei dettagli di un Cliente
     * @param id
     * id del Cliente
     * @return il bean con i dettagli del Cliente
     * @throws java.sql.SQLException
     */
    public Cliente visualizzaDati(Integer id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet.");}


}
