/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

    public BeanGuiDipendente() {

    }

   

     

     private ArrayList<BeanGuiAppuntamento> listAppuntamenti;

    public BeanGuiDipendente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idDipendenteTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
        this.idDipendenteTxt = idDipendenteTxt;
    }
     private ArrayList<BeanGuiContratto> listContratti;

    public ArrayList<BeanGuiAppuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    public void setListAppuntamenti(ArrayList<BeanGuiAppuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
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
