package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
import it.seerp.application.Exception.DatiErrati;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public interface GestioneAreaPersonale <E extends Utente,U extends BeanGuiUtente>{

    public U visualizzaDati(JTextField user);

   
   
    public U modificaPassword(JTextField user) throws DatiErrati;

    public ArrayList<U> visualizzaContratti(JTextField  username);


}
