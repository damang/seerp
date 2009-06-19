package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione del Cliente
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiCliente extends BeanGuiExtraAzienda {

    /**
     * Costruttore vuoto per la classe Bean Gui Cliente
     */
    public BeanGuiCliente() {
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
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     */
    public BeanGuiCliente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField ragioneSociale, JTextField pIva, JTextField fax, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible, cognome, nome, ragioneSociale, pIva, fax, ruolo);
    }
}
