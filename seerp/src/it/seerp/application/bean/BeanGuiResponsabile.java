/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiResponsabile extends BeanGuiUtente {

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
