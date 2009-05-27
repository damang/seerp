/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiResponsabile extends BeanGuiUtente {

    public BeanGuiResponsabile(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idResponsabileTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica);
        this.idResponsabileTxt = idResponsabileTxt;
    }

    

    

    private JTextField idResponsabileTxt;

    /**
     *
     * @param idResponsabileTxt
     */
    public void setIdResponsabileTxt(JTextField idResponsabileTxt) {
        this.idResponsabileTxt = idResponsabileTxt;
    }

    /**
     * 
     * @return
     */
    public JTextField getIdResponsabileTxt() {
        return idResponsabileTxt;
    }

}
