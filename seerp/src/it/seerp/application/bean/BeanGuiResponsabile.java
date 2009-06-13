package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
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

    /**
     *
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param listPermessi
     * @param listRuoli
     * @param idResponsabileTxt
     */
    public BeanGuiResponsabile(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, JTextField idResponsabileTxt) {
        super(idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
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
