/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiAmministratore extends BeanGuiUtente {

    public BeanGuiAmministratore(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idAmministratoreTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica);
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
