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
public class BeanGuiDipendente extends BeanGuiPersonale {

    public BeanGuiDipendente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, JTextField idDipendenteTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.idDipendenteTxt = idDipendenteTxt;
    }

  

    

     private JTextField idDipendenteTxt;
    

     /**
      *
      * @return
      */
     public JTextField getIdDipendenteTxt() {
        return idDipendenteTxt;
    }

      

    /**
     *
     * @param idDipendenteTxt
     */
    public void setIdDipendenteTxt(JTextField idDipendenteTxt) {
        this.idDipendenteTxt = idDipendenteTxt;
    }

  



}
