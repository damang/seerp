/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.ejb.Personale;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class AppGestionePersonale extends AppGestioneUtente {

   
    public BeanGuiPersonale ricerca(JTextField username) throws DatiErrati {
        BeanGuiPersonale el= new BeanGuiPersonale();
        BeanGuiPersonale el1= new BeanGuiPersonale();
        el = (BeanGuiPersonale) super.ricerca(username);

       return el;
    }

    public void elimina(BeanGuiPersonale user) {
        super.elimina(user);
    }

    public void eliminazioneLogica(BeanGuiPersonale user) {
    
    }

    public void inserisci(BeanGuiPersonale user, BeanGuiUtente ut) throws DatiErrati, DatiDuplicati {


    }

    public BeanGuiPersonale modifica(BeanGuiPersonale user) throws DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
