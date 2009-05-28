/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiAmministratore extends BeanGuiPersonale {

    public BeanGuiAmministratore() {
        
    }

    public BeanGuiAmministratore(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, JTextField idAmministratoreTxt) {
        super(idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.idAmministratoreTxt = idAmministratoreTxt;
    }

   

    

  

    private JTextField idAmministratoreTxt;

   /**
     *
     * @return
     */
    public JTextField getIdAmministratoreTxt() {
        return idAmministratoreTxt;
    }

    /**
     * 
     * @param idAmministratoreTxt
     */
    public void setIdAmministratoreTxt(JTextField idAmministratoreTxt) {
        this.idAmministratoreTxt = idAmministratoreTxt;
    }


}
