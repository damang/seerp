/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class AppGestioneAreaPersonale implements GestioneAreaPersonale{

    public BeanGuiUtente visualizzaDati(JTextField user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BeanGuiUtente modificaPassword(JTextField user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList visualizzaContratti(JTextField username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
