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
public class BeanGuiCliente extends BeanGuiUtente {


    private JTextField idClienteTxt;

    /**
     * 
     * @param idClienteTxt
     */
    public void setIdClienteTxt(JTextField idClienteTxt) {
        this.idClienteTxt = idClienteTxt;
    }

    /**
     *
     * @return
     */
    public JTextField getIdClienteTxt() {
        return idClienteTxt;
    }

}
