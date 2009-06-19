package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dell'Amministratore
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiAmministratore extends BeanGuiPersonale {

    private BeanGuiAzienda azienda;

    /**
     * costruttore vuoto per il Bean Gui Amministratore
     */
    public BeanGuiAmministratore() {
    }

    /**
     *
     * @param idUtenteTxt
     * @param txtUsername
     * @param txtPassword
     * @param txtCitta
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param tipo
     * @param visible
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param ruolo
     */
    public BeanGuiAmministratore(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField codiceFiscale, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible, cognome, nome, codiceFiscale, ruolo);
    }

    /**
     * 
     * @return
     */
    public BeanGuiAzienda getAzienda() {
        return azienda;
    }

    /**
     *
     * @param azienda
     */
    public void setAzienda(BeanGuiAzienda azienda) {
        this.azienda = azienda;
    }
}
