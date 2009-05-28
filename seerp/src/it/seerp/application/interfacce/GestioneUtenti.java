package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public interface GestioneUtenti<E extends Utente,U extends BeanGuiUtente> {

    
    public ArrayList<E> elenca();

  
    public ArrayList<E> ricerca(JTextField cognome, JTextField ruolo)throws DatiErrati,RicercaFallita;
    
    public void elimina(U user);
    
    public void eliminazioneLogica(U user);//??

   
    public void inserisci(U user)throws DatiErrati,DatiDuplicati;

   
    public U modifica(U user)throws DatiErrati;

    public U visualizzaDati(JTextField user) throws DatiErrati;

    




}
