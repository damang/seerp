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
public class BeanGuiAmministratore extends BeanGuiPersonale {

    private JTextField idAmministratoreTxt;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
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
     *  Costruttore per la classe Beang Gui Amministratore
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param listPermessi
     * @param listRuoli
     * @param idAmministratoreTxt
     */
    public BeanGuiAmministratore(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, JTextField idAmministratoreTxt) {
        super(idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.idAmministratoreTxt = idAmministratoreTxt;
    }

    /**
     * metodo che restituisce l'identificatore dell'amministatore dal campo associato
     * @return l'identificatore dell'Amministratore
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
}
