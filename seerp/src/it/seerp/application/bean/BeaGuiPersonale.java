/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeaGuiPersonale extends BeanGuiUtente {

    private JTextField idPersonaleTxt;
    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtCodiceFiscale;
    private JComboBox cmbTipo;

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
