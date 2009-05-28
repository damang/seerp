/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class AppGestioneUtente implements GestioneUtenti<Utente,BeanGuiUtente> {

    public AppGestioneUtente() {
    }

    
    public ArrayList<Utente> elenca() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BeanGuiUtente ricerca(JTextField username) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void elimina(BeanGuiUtente user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminazioneLogica(BeanGuiUtente user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inserisci(BeanGuiUtente user) throws DatiErrati, DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BeanGuiUtente modifica(BeanGuiUtente user) throws DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Utente> ricerca(JTextField cognome, JTextField ruolo) throws DatiErrati, RicercaFallita {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BeanGuiUtente visualizzaDati(JTextField user) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
