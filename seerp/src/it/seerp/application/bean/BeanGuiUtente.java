package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.Gui.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    protected boolean validator = false;

    public boolean isValidatorEnabled() {
        return validator;
    }

    public void setValidatorEnabled(boolean validator) {
        this.validator = validator;
        ((NotEmptyValidator) txtProvincia.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) txtPassword.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) txtCitta.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) txtEmail.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) txtUsername.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) txtTelefono.getInputVerifier()).setEnabled(validator);

        ((NotEmptyValidator) txtProvincia.getInputVerifier()).reset(txtProvincia);
        ((NotEmptyValidator) txtPassword.getInputVerifier()).reset(txtPassword);
        ((NotEmptyValidator) txtCitta.getInputVerifier()).reset(txtCitta);
        ((NotEmptyValidator) txtEmail.getInputVerifier()).reset(txtEmail);
        ((NotEmptyValidator) txtUsername.getInputVerifier()).reset(txtUsername);
        ((NotEmptyValidator) txtTelefono.getInputVerifier()).reset(txtTelefono);
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiUtente(Object c) {
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
        if (validator == true) {
            if (!tipo.getInputVerifier().shouldYieldFocus(tipo)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }

        return tipo;
    }

    /**
     *
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     *
     * @return
     */
    public JTextField getCap() throws ValidatorException {
        if (validator == true) {
            if (!cap.getInputVerifier().shouldYieldFocus(cap)) {
                throw new ValidatorException("Inserire un valore numerico di 5 cifre.");
            }
        }
        return cap;
    }

    /**
     *
     * @param cap
     */
    public void setCap(JTextField cap) {
        this.cap = cap;
        cap.setInputVerifier(new NotEmptyValidator(grafica, cap, "Inserire un valore numerico di 5 cifre.", RegexpDef.valueOf(RegexpDef.VAL.CAP)));
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
        txtUsername2 = user1;
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
        idUtenteTxt.setInputVerifier(new NotEmptyValidator(grafica, idUtenteTxt, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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
        if (validator == true) {
            if (!idUtenteTxt.getInputVerifier().shouldYieldFocus(idUtenteTxt)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return idUtenteTxt;
    }

    /**
     * 
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtCitta() throws ValidatorException {
        if (validator == true) {
            if (!txtCitta.getInputVerifier().shouldYieldFocus(txtCitta)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return txtCitta;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtEmail() throws ValidatorException {
        if (validator == true) {
            if (!txtEmail.getInputVerifier().shouldYieldFocus(txtEmail)) {
                throw new ValidatorException("Email inserita non valida.");
            }
        }

        return txtEmail;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtPassword() throws ValidatorException {
        if (validator == true) {
            if (!txtPassword.getInputVerifier().shouldYieldFocus(txtPassword)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }

        return txtPassword;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtProvincia() throws ValidatorException {
        if (validator == true) {
            if (!txtProvincia.getInputVerifier().shouldYieldFocus(txtProvincia)) {
                throw new ValidatorException("La provincia deve essere di 2 caratteri.");
            }
        }
        return txtProvincia;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtTelefono() throws ValidatorException {
        if (validator == true) {
            if (!txtTelefono.getInputVerifier().shouldYieldFocus(txtTelefono)) {
                throw new ValidatorException("Il campo deve essere di almeno 8 caratteri");
            }
        }
        return txtTelefono;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTxtUsername() throws ValidatorException {
        if (validator == true) {
            if (!txtUsername.getInputVerifier().shouldYieldFocus(txtUsername)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }

        return txtUsername;
    }

    /**
     *
     * @param ptxtCitta
     */
    public void setTxtCitta(JTextField ptxtCitta) {
        this.txtCitta = ptxtCitta;
        txtCitta.setInputVerifier(new NotEmptyValidator(grafica, txtCitta, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     *
     * @param ptxtEmail
     */
    public void setTxtEmail(JTextField ptxtEmail) {
        this.txtEmail = ptxtEmail;
        txtEmail.setInputVerifier(new NotEmptyValidator(grafica, ptxtEmail, "Email inserita non valida.", RegexpDef.valueOf(RegexpDef.VAL.MAIL)));
    }

    /**
     *
     * @param ptxtPassword
     */
    public void setTxtPassword(JTextField ptxtPassword) {
        this.txtPassword = ptxtPassword;
        txtPassword.setInputVerifier(new NotEmptyValidator(grafica, txtPassword, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     *
     * @param ptxtProvincia
     */
    public void setTxtProvincia(JTextField ptxtProvincia) {
        this.txtProvincia = ptxtProvincia;
        txtProvincia.setInputVerifier(new NotEmptyValidator(grafica, txtProvincia, "La provincia deve essere di 2 caratteri.", RegexpDef.valueOf(RegexpDef.VAL.PROV)));
    }

    /**
     *
     * @param ptxtTelefono
     */
    public void setTxtTelefono(JTextField ptxtTelefono) {
        this.txtTelefono = ptxtTelefono;
        txtTelefono.setInputVerifier(new NotEmptyValidator(grafica, txtTelefono, "Il campo deve essere di almeno 7 caratteri", RegexpDef.valueOf(RegexpDef.VAL.TELEFONO)));
    }

    /**
     *
     * @param ptxtUsername
     */
    public void setTxtUsername(JTextField ptxtUsername) {
        this.txtUsername = ptxtUsername;
        txtUsername.setInputVerifier(new NotEmptyValidator(grafica, txtUsername, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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