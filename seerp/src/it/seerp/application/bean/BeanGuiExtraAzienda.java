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
public class BeanGuiExtraAzienda extends BeanGuiUtente {

    private JTextField idExtraAziendaTxt;
    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtRagioneSociale;
    private JTextField txtPIva;
    private JTextField txtFax;
    private JComboBox cmbRuolo;
    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;

    public BeanGuiExtraAzienda() {
        
    }

    public BeanGuiExtraAzienda(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica);
        this.idExtraAziendaTxt = idExtraAziendaTxt;
        this.txtCognome = txtCognome;
        this.txtNome = txtNome;
        this.txtRagioneSociale = txtRagioneSociale;
        this.txtPIva = txtPIva;
        this.txtFax = txtFax;
        this.cmbRuolo = cmbRuolo;
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
    }

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

    

    /**
     *
     * @param cmbRuolo
     */
    public void setCmbRuolo(JComboBox cmbRuolo) {
        this.cmbRuolo = cmbRuolo;
    }

    /**
     *
     * @param idExtraAziendaTxt
     */
    public void setIdExtraAziendaTxt(JTextField idExtraAziendaTxt) {
        this.idExtraAziendaTxt = idExtraAziendaTxt;
    }

    /**
     *
     * @param txtCognome
     */
    public void setTxtCognome(JTextField txtCognome) {
        this.txtCognome = txtCognome;
    }

    /**
     * 
     * @param txtNome
     */
    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

    /**
     *
     * @param txtFax
     */
    public void setTxtFax(JTextField txtFax) {
        this.txtFax = txtFax;
    }

    /**
     *
     * @param txtPIva
     */
    public void setTxtPIva(JTextField txtPIva) {
        this.txtPIva = txtPIva;
    }

    /**
     *
     * @param txtRagioneSociale
     */
    public void setTxtRagioneSociale(JTextField txtRagioneSociale) {
        this.txtRagioneSociale = txtRagioneSociale;
    }

    /**
     *
     * @return
     */
    public JComboBox getCmbRuolo() {
        return cmbRuolo;
    }

    /**
     *
     * @return
     */
    public JTextField getIdExtraAziendaTxt() {
        return idExtraAziendaTxt;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtCognome() {
        return txtCognome;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtNome() {
        return txtNome;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtFax() {
        return txtFax;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPIva() {
        return txtPIva;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtRagioneSociale() {
        return txtRagioneSociale;
    }

    public void removeAppuntamento(BeanGuiAppuntamento p){
     listAppuntamenti.remove(p);}

    public void addAppuntamento(BeanGuiAppuntamento p){
     listAppuntamenti.add(p);}

       public void removeContratto(BeanGuiContratto c){
     listContratti.remove(c);}

    public void addContratto(BeanGuiContratto c){
     listContratti.add(c);}

}
