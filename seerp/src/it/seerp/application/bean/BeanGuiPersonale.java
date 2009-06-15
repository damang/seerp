package it.seerp.application.bean;

import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiPersonale extends BeanGuiUtente {

    private JTextField cognome;
    private JTextField nome;
    private JTextField codiceFiscale;
    private JTextField ruolo;
    private JXPanel grafica;
    private NotEmptyValidator val;
    private NotEqualLengthValidator valEqLen;
    private NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiPersonale(JXPanel c) {
        grafica = c;
    }

    /**
     * 
     */
    public BeanGuiPersonale() {
    }

    public BeanGuiPersonale(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField codiceFiscale, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible);
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.ruolo = ruolo;
    }

   




    public JTextField getRuolo() {
        return ruolo;
    }

    public void setRuolo(JTextField ruolo) {
        this.ruolo = ruolo;
    }

    /**
     *
     * @return
     */
    public JTextField getCodiceFiscale() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valEqLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return codiceFiscale;
    }

    /**
     *
     * @return
     */
    public JTextField getCognome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return cognome;
    }
   

    public JTextField getNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return nome;
    }

    

    /**
     * 
     * @param pcodiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.codiceFiscale = pcodiceFiscale;
        val = new NotEmptyValidator(grafica, codiceFiscale, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEqLen = new NotEqualLengthValidator(grafica, codiceFiscale, "Il campo deve essere di 16 caratteri", 16);
        grafica.setInputVerifier(valEqLen);

    }

    /**
     *
     * @param pcognome
     */
    public void setCognome(JTextField pcognome) {
        this.cognome = pcognome;
        val = new NotEmptyValidator(grafica, cognome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, cognome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }


    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        val = new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, nome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }
}
