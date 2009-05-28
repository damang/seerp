/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.ejb.ExtraAzienda;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class AppGestioneExtraAzienda extends AppGestioneUtente {

   
    public BeanGuiExtraAzienda ricerca(JTextField username) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void elimina(BeanGuiExtraAzienda user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminazioneLogica(BeanGuiExtraAzienda user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inserisci(BeanGuiExtraAzienda user) throws DatiErrati, DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BeanGuiExtraAzienda modifica(BeanGuiExtraAzienda user) throws DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
