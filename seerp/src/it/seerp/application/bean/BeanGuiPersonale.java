
package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiPersonale extends BeanGuiUtente {

    private JTextField idPersonaleTxt;
    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtCodiceFiscale;
    private JComboBox cmbTipo;
    private ArrayList<BeanGuiPermesso> listPermessi;
    private ArrayList<BeanGuiRuolo> listRuoli;

    /**
     * 
     */
    public BeanGuiPersonale() {
        
    }

    /**
     *
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param listPermessi
     * @param listRuoli
     */
    public BeanGuiPersonale(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli) {
        this.idPersonaleTxt = idPersonaleTxt;
        this.txtCognome = txtCognome;
        this.txtNome = txtNome;
        this.txtCodiceFiscale = txtCodiceFiscale;
        this.cmbTipo = cmbTipo;
        this.listPermessi = listPermessi;
        this.listRuoli = listRuoli;
    }




    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiRuolo> getListRuoli() {
        return listRuoli;
    }

    /**
     *
     * @param listPermessi
     */
    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     *
     * @param listRuoli
     */
    public void setListRuoli(ArrayList<BeanGuiRuolo> listRuoli) {
        this.listRuoli = listRuoli;
    }

    /**
     *
     * @return
     */
    public JTextField getCodiceFiscale() {
        return txtCodiceFiscale;
    }

    /**
     *
     * @return
     */
    public JTextField getCognome() {
        return txtCognome;
    }

    /**
     *
     * @return
     */
    public JTextField getIdPersonale() {
        return idPersonaleTxt;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() {
        return txtNome;
    }

    /**
     *
     * @return
     */
    public JComboBox getTipo() {
        return cmbTipo;
    }

    /**
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(JTextField codiceFiscale) {
        this.txtCodiceFiscale = codiceFiscale;
    }

    /**
     *
     * @param cognome
     */
    public void setCognome(JTextField cognome) {
        this.txtCognome = cognome;
    }

    /**
     *
     * @param idPersonale
     */
    public void setIdPersonale(JTextField idPersonale) {
        this.idPersonaleTxt = idPersonale;
    }

    /**
     *
     * @param nome
     */
    public void setNome(JTextField nome) {
        this.txtNome = nome;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(JComboBox tipo) {
        this.cmbTipo = tipo;
    }
    
}
