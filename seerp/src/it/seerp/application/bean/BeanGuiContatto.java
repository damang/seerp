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
public class BeanGuiContatto {

    private JTextField idContattoTxt;
    private JTextField txtFeedback;

    /**
     *
     * @return
     */
    public JTextField getIdContattoTxt() {
        return idContattoTxt;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtFeedback() {
        return txtFeedback;
    }

    /**
     *
     * @param idContattoTxt
     */
    public void setIdContattoTxt(JTextField idContattoTxt) {
        this.idContattoTxt = idContattoTxt;
    }

    /**
     * 
     * @param txtFeedback
     */
    public void setTxtFeedback(JTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }



}
