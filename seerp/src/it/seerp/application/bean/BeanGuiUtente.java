package it.seerp.application.bean;

import it.seerp.application.validation.EmailValidator;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotMaxLengthValidator;
import it.seerp.application.validation.NotMinLengthValidator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
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
    private JTextField tipo;
    private JTextField visible;
    protected JXPanel grafica;
    protected NotEmptyValidator val;
    protected NotEqualLengthValidator valEqLen;
    protected NotMinLengthValidator valMinLen;
    protected NotMaxLengthValidator valMaxLen;
    protected EmailValidator valEma;
    protected NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiUtente(JXPanel c) {
        grafica = c;
    }

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
    public BeanGuiUtente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo,JTextField visible) {
        this.idUtenteTxt = idUtenteTxt;
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.txtCittà = txtCittà;
        this.txtProvincia = txtProvincia;
        this.txtTelefono = txtTelefono;
        this.txtEmail = txtEmail;
        this.txtNote = txtNote;
        this.txtNotifica = txtNotifica;
        this.tipo = tipo;
        this.visible=visible;
    }

    /**
     *
     * @return
     */
    public JTextField getTipo() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return tipo;
    }

    /**
     *
     * @param pRuolo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        val = new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
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
        val = new NotEmptyValidator(grafica, idUtenteTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
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
     */
    public JTextField getIdUtenteTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idUtenteTxt;
    }

    /**
     * 
     * @return
     */
    public JTextField getTxtCittà() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtCittà;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtEmail() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valEma.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtEmail;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPassword() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valMinLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtPassword;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtProvincia() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        } else if (!valEqLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtProvincia;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtTelefono() throws Exception {
        if (!valMinLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtTelefono;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtUsername() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valMinLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtUsername;
    }

    /**
     *
     * @param pidUtenteTxt
     */
    public void setIdUtenteText(JTextField pidUtenteTxt) {
        this.idUtenteTxt = pidUtenteTxt;
        val = new NotEmptyValidator(grafica, idUtenteTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     *
     * @param ptxtCittà
     */
    public void setTxtCittà(JTextField ptxtCittà) {
        this.txtCittà = ptxtCittà;
        val = new NotEmptyValidator(grafica, txtCittà, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, txtCittà, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     *
     * @param ptxtEmail
     */
    public void setTxtEmail(JTextField ptxtEmail) {
        this.txtEmail = ptxtEmail;
        val = new NotEmptyValidator(grafica, txtEmail, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEma = new EmailValidator(grafica, txtEmail, "Formato e-mail inserito non valido.");
        grafica.setInputVerifier(valEma);
    }

    /**
     *
     * @param ptxtPassword
     */
    public void setTxtPassword(JTextField ptxtPassword) {
        this.txtPassword = ptxtPassword;
        val = new NotEmptyValidator(grafica, txtPassword, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valMaxLen = new NotMaxLengthValidator(grafica, txtProvincia, "Il campo deve essere di massimo 15 caratteri", 16);
        grafica.setInputVerifier(valMaxLen);
    }

    /**
     *
     * @param ptxtProvincia
     */
    public void setTxtProvincia(JTextField ptxtProvincia) {
        this.txtProvincia = ptxtProvincia;
        val = new NotEmptyValidator(grafica, txtProvincia, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEqLen = new NotEqualLengthValidator(grafica, txtProvincia, "Il campo deve essere di 2 caratteri", 2);
        grafica.setInputVerifier(valEqLen);
    }

    /**
     *
     * @param ptxtTelefono
     */
    public void setTxtTelefono(JTextField ptxtTelefono) {
        this.txtTelefono = ptxtTelefono;
        valMinLen = new NotMinLengthValidator(grafica, txtTelefono, "Il campo deve essere di almeno 8 caratteri", 8);
        grafica.setInputVerifier(valMinLen);
    }

    /**
     *
     * @param ptxtUsername
     */
    public void setTxtUsername(JTextField ptxtUsername) {
        this.txtUsername = ptxtUsername;
        val = new NotEmptyValidator(grafica, txtUsername, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valMaxLen = new NotMaxLengthValidator(grafica, txtProvincia, "Il campo deve essere di massimo 15 caratteri", 16);
        grafica.setInputVerifier(valMaxLen);
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