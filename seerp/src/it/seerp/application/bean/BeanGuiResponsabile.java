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
public class BeanGuiResponsabile extends BeanGuiPersonale {

    private JTextField idResponsabileTxt;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiResponsabile(JXPanel c) {
        grafica = c;
    }

    /**
     * 
     */
    public BeanGuiResponsabile() {
    }

    public BeanGuiResponsabile(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField Ruolo, JTextField visible, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, JTextField idResponsabileTxt) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, Ruolo, visible, idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo);
        this.idResponsabileTxt = idResponsabileTxt;
    }

   

    /**
     *
     * @param pidResponsabileTxt
     */
    public void setIdResponsabileTxt(JTextField pidResponsabileTxt) {
        this.idResponsabileTxt = pidResponsabileTxt;
        val = new NotEmptyValidator(grafica, idResponsabileTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * 
     * @return
     */
    public JTextField getIdResponsabileTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idResponsabileTxt;
    }
}
