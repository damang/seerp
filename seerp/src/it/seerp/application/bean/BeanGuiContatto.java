package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiContatto extends BeanGuiExtraAzienda {

    private JTextField txtFeedback;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiContatto(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto per la classe Bean Gui Contatto
     */
    public BeanGuiContatto() {
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
     * @param tipo
     * @param visible
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     * @param txtFeedback
     */
    public BeanGuiContatto(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField ragioneSociale, JTextField pIva, JTextField fax, JTextField ruolo, JTextField txtFeedback) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible, cognome, nome, ragioneSociale, pIva, fax, ruolo);
        this.txtFeedback = txtFeedback;
    }


    /**
     * metodo che restituisce il campo contenente il feedback del Contatto
     * @return il campo feedback
     */
    public JTextField getTxtFeedback() {
        return txtFeedback;
    }


    /**
     * metodo che permette di settare il campo contenente il feedback del Contatto
     * @param txtFeedback rappresenta il campo feedback  da inserire
     */
    public void setTxtFeedback(JTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }
}
