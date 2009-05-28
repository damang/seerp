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
public class BeanGuiCliente extends BeanGuiExtraAzienda {

    public BeanGuiCliente() {
        
    }

    public BeanGuiCliente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idClienteTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idClienteTxt = idClienteTxt;
    }

   

    


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
