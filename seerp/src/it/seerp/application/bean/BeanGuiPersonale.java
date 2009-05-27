
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

    public BeanGuiPersonale() {
        
    }



    public BeanGuiPersonale(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica);
        this.idPersonaleTxt = idPersonaleTxt;
        this.txtCognome = txtCognome;
        this.txtNome = txtNome;
        this.txtCodiceFiscale = txtCodiceFiscale;
        this.cmbTipo = cmbTipo;
        this.listPermessi = listPermessi;
        this.listRuoli = listRuoli;
    }

    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
    }

    public ArrayList<BeanGuiRuolo> getListRuoli() {
        return listRuoli;
    }

    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
    }

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
