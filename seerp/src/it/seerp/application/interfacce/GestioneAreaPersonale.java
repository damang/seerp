package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public interface GestioneAreaPersonale <E extends Utente,U extends BeanGuiUtente>{

    public BeanGuiUtente visualizzaDati(JTextField user);

   
   
    public BeanGuiUtente modificaPassword(JTextField user);

    public ArrayList<U> visualizzaContratti(JTextField  username);


}
