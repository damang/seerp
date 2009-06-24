package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.EmailValidator;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotMaxLengthValidator;
import it.seerp.application.validation.NotMinLengthValidator;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * Classe relativa ai componenti grafici della gestione degli Utenti
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiUtente {

    private JTextField idUtenteTxt;
    private JTextField txtUsername;
    private JTextField txtUsername2;
    private JTextField txtPassword;
    private JTextField txtCitta;
    private JTextField txtProvincia;
    private JTextField cap;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextArea txtNote;
    private JTextField txtNotifica;
    private JTextField tipo;
    private JTextField visible;
    protected Object grafica;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiUtente(JPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto
     */
    public BeanGuiUtente() {
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTipo() throws ValidatorException {
        if (!tipo.getInputVerifier().shouldYieldFocus(tipo)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return tipo;
    }

    /**
     *
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator((JPanel) grafica,tipo, "Il campo non può essere vuoto."));
    }

    /**
     *
     * @return
     */
    public JTextField getCap() {
        return cap;
    }

    /**
     *
     * @param cap
     */
    public void setCap(JTextField cap) {
        this.cap = cap;
    }

    /**
     *
     * @param ptxtNotifica
     */
    public void setTxtNotifica(JTextField ptxtNotifica) {
        this.txtNotifica = ptxtNotifica;
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
     * @param user1
     */
    public void setTxtUsernameSec(JTextField user1) {
        txtUsername2=user1;
    }
    /**
     *
     * @return
     * @throws it.seerp.application.Exception.ValidatorException
     */
    public JTextField getTxtUsername2() throws ValidatorException {
        return txtUsername2;
    }

    /**
     *
     * @param ptxtnotifica
     */
    public void setTxtnotifica(JTextField ptxtnotifica) {
        this.txtNotifica = ptxtnotifica;
    }

    /**
     *
     * @param pidUtenteTxt
     */
    public void setIdUtenteTxt(JTextField pidUtenteTxt) {
       this.idUtenteTxt = pidUtenteTxt;
       idUtenteTxt.setInputVerifier(new NotEmptyValidator((JPanel) grafica,idUtenteTxt, "Il campo non può essere vuoto."));
    }


    /**
     *
     * @param ptxtNote
     */
    public void setTxtNote(JTextArea ptxtNote) {
        this.txtNote = ptxtNote;
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
     * @throws ValidatorException
     */
    public JTextField getIdUtenteTxt() throws ValidatorException {
        if (!idUtenteTxt.getInputVerifier().shouldYieldFocus(idUtenteTxt)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return idUtenteTxt;
    }

    /**
     * 
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtCitta() throws ValidatorException {
        if (!txtCitta.getInputVerifier().shouldYieldFocus(txtCitta)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!txtCitta.getInputVerifier().shouldYieldFocus(txtCitta)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtCitta;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtEmail() throws ValidatorException {
        if (!txtEmail.getInputVerifier().shouldYieldFocus(txtEmail)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!txtEmail.getInputVerifier().shouldYieldFocus(txtEmail)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtEmail;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtPassword() throws ValidatorException {
        if (!txtPassword.getInputVerifier().shouldYieldFocus(txtPassword)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!txtPassword.getInputVerifier().shouldYieldFocus(txtPassword)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtPassword;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtProvincia() throws ValidatorException {
        if (!txtProvincia.getInputVerifier().shouldYieldFocus(txtProvincia)) {
            throw new ValidatorException("Errore nella grafica!");
        } else if (!txtProvincia.getInputVerifier().shouldYieldFocus(txtProvincia)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtProvincia;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtTelefono() throws ValidatorException {
        if (!txtTelefono.getInputVerifier().shouldYieldFocus(txtTelefono)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtTelefono;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtUsername() throws ValidatorException {
       if (!txtUsername.getInputVerifier().shouldYieldFocus(txtUsername)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!txtUsername.getInputVerifier().shouldYieldFocus(txtUsername)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return txtUsername;
    }



    /**
     *
     * @param ptxtCitta
     */
    public void setTxtCitta(JTextField ptxtCitta) {
        this.txtCitta = ptxtCitta;
        txtCitta.setInputVerifier(new NotEmptyValidator((JPanel) grafica,txtCitta, "Il campo non può essere vuoto."));
        txtCitta.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica,txtCitta, "La stringa inserita deve essere alfabetica."));
    }

    /**
     *
     * @param ptxtEmail
     */
    public void setTxtEmail(JTextField ptxtEmail) {
        this.txtEmail = ptxtEmail;
        txtEmail.setInputVerifier(new NotEmptyValidator((JPanel) grafica,ptxtEmail, "Il campo non può essere vuoto."));
        txtEmail.setInputVerifier(new EmailValidator((JPanel) grafica,ptxtEmail, "Formato e-mail inserito non valido."));
    }

    /**
     *
     * @param ptxtPassword
     */
    public void setTxtPassword(JTextField ptxtPassword) {
        this.txtPassword = ptxtPassword;
        txtPassword.setInputVerifier(new NotEmptyValidator((JPanel) grafica,txtPassword, "Il campo non può essere vuoto."));
        txtPassword.setInputVerifier(new NotMaxLengthValidator((JPanel) grafica,txtPassword, "Il campo deve essere di massimo 15 caratteri", 16));
    }

    /**
     *
     * @param ptxtProvincia
     */
    public void setTxtProvincia(JTextField ptxtProvincia) {
        this.txtProvincia = ptxtProvincia;
        txtProvincia.setInputVerifier(new NotEmptyValidator((JPanel) grafica,txtProvincia, "Il campo non può essere vuoto."));
        txtProvincia.setInputVerifier(new NotEqualLengthValidator((JPanel) grafica,txtProvincia, "Il campo deve essere di 2 caratteri", 2));
    }

    /**
     *
     * @param ptxtTelefono
     */
    public void setTxtTelefono(JTextField ptxtTelefono) {
        this.txtTelefono = ptxtTelefono;
        txtTelefono.setInputVerifier(new NotMinLengthValidator((JPanel) grafica,txtTelefono, "Il campo deve essere di almeno 8 caratteri", 8));
    }

    /**
     *
     * @param ptxtUsername
     */
    public void setTxtUsername(JTextField ptxtUsername) {
        this.txtUsername = ptxtUsername;
        txtUsername.setInputVerifier(new NotEmptyValidator((JPanel) grafica,txtUsername, "Il campo non può essere vuoto."));
        txtUsername.setInputVerifier(new NotMaxLengthValidator((JPanel) grafica,txtUsername, "Il campo deve essere di massimo 15 caratteri", 16));
    }

    /**
     * 
     * @return
     */
    public JTextField getVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(JTextField visible) {
        this.visible = visible;
    }
}