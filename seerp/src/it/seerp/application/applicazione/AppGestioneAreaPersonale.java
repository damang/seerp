package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class AppGestioneAreaPersonale implements GestioneAreaPersonale  {

    /**
     * 
     * @param utente
     * @param list
     * @return
     */
    public BeanGuiUtente visualizzaDati(BeanGuiUtente utente, ArrayList list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param utente
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public BeanGuiUtente modificaPassword(BeanGuiUtente utente) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param utente
     * @return
     */
    public ArrayList visualizzaContratti(BeanGuiUtente utente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
