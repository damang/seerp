/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiUtente {
   
    private JTextField idUtenteTxt;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtCittà;
    private JTextField txtProvincia;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextArea txtNote;
    private JTextField txtNotifica;
    private JTextField Ruolo;

    /**
     *
     */
    public BeanGuiUtente() {
       
    }

    /**
     *
     * @param idUtenteTxt
     * @param txtUsername
     * @param txtPassword
     * @param txtCittà
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param Ruolo
     */
    public BeanGuiUtente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField Ruolo) {
        this.idUtenteTxt = idUtenteTxt;
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.txtCittà = txtCittà;
        this.txtProvincia = txtProvincia;
        this.txtTelefono = txtTelefono;
        this.txtEmail = txtEmail;
        this.txtNote = txtNote;
        this.txtNotifica = txtNotifica;
        this.Ruolo = Ruolo;
    }

    

    /**
     *
     * @return
     */
    public JTextField getRuolo() {
        return Ruolo;
    }

    /**
     *
     * @param Ruolo
     */
    public void setRuolo(JTextField Ruolo) {
        this.Ruolo = Ruolo;
    }

    /**
     *
     * @param txtNotifica
     */
    public void setTxtNotifica(JTextField txtNotifica) {
        this.txtNotifica = txtNotifica;
    }




    /**
     * 
     * @return
     */
    public JTextField getTxtNotifica() {
        return txtNotifica;
    }

    /**
     *
     * @param txtnotifica
     */
    public void setTxtnotifica(JTextField txtnotifica) {
        this.txtNotifica = txtnotifica;
    }

    /**
     *
     * @param idUtenteTxt
     */
    public void setIdUtenteTxt(JTextField idUtenteTxt) {
        this.idUtenteTxt = idUtenteTxt;
    }

    /**
     *
     * @param txtNote
     */
    public void setTxtNote(JTextArea txtNote) {
        this.txtNote = txtNote;
    }

    /**
     *
     * @return
     */
    public JTextArea getTxtNote() {
        return txtNote;
    }

    /**
     *
     * @return
     */
    public JTextField getIdUtenteTxt() {
        return idUtenteTxt;
    }

    /**
     * 
     * @return
     */
    public JTextField getTxtCittà() {
        return txtCittà;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPassword() {
        return txtPassword;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtProvincia() {
        return txtProvincia;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     *
     * @param idUtenteTxt
     */
    public void setIdUtenteText(JTextField idUtenteTxt) {
        this.idUtenteTxt = idUtenteTxt;
    }

    /**
     *
     * @param txtCittà
     */
    public void setTxtCittà(JTextField txtCittà) {
        this.txtCittà = txtCittà;
    }

    /**
     *
     * @param txtEmail
     */
    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    /**
     *
     * @param txtPassword
     */
    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    /**
     *
     * @param txtProvincia
     */
    public void setTxtProvincia(JTextField txtProvincia) {
        this.txtProvincia = txtProvincia;
    }

    /**
     *
     * @param txtTelefono
     */
    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    /**
     *
     * @param txtUsername
     */
    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

}
