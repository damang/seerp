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
public class BeanGuiAmministratore extends BeanGuiPersonale {

    private JTextField idAmministratoreTxt;
    private BeanGuiAzienda azienda;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiAmministratore(JXPanel c) {
        grafica = c;
    }

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
     * @param txtCittà
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param Ruolo
     * @param visible
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param idAmministratoreTxt
     */
    public BeanGuiAmministratore(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField Ruolo, JTextField visible, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, JTextField idAmministratoreTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, Ruolo, visible, idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo);
        this.idAmministratoreTxt = idAmministratoreTxt;
    }

 

    /**
     * metodo che restituisce l'identificatore dell'amministatore dal campo associato
     * @return l'identificatore dell'Amministratore
     * @throws Exception
     */
    public JTextField getIdAmministratoreTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idAmministratoreTxt;
    }

    /**
     *  metodo che permette di settare l'identificatico dell'amministraotre nel campo associato
     * @param pidAmministratoreTxt rappresenta l'identificativo dell'Amministratore da inserire
     */
    public void setIdAmministratoreTxt(JTextField pidAmministratoreTxt) {
        this.idAmministratoreTxt = pidAmministratoreTxt;
        val = new NotEmptyValidator(grafica, idAmministratoreTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
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
