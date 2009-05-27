/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiContatto extends BeanGuiExtraAzienda{

    public BeanGuiContatto(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idContattoTxt, JTextField txtFeedback) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idContattoTxt = idContattoTxt;
        this.txtFeedback = txtFeedback;
    }
    


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
