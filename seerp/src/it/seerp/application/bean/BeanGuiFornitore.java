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
public class BeanGuiFornitore extends BeanGuiExtraAzienda {

    public BeanGuiFornitore(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idFornitoreTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idFornitoreTxt = idFornitoreTxt;
    }

    

    private JTextField idFornitoreTxt;

    /**
     * 
     * @return
     */
    public JTextField getIdFornitoreTxt() {
        return idFornitoreTxt;
    }

    /**
     *
     * @param idFornitoreTxt
     */
    public void setIdFornitoreTxt(JTextField idFornitoreTxt) {
        this.idFornitoreTxt = idFornitoreTxt;
    }



}
