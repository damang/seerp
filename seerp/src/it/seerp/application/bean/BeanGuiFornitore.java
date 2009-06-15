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
public class BeanGuiFornitore extends BeanGuiExtraAzienda {

    private JTextField idFornitoreTxt;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiFornitore(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore per vuoto per la classe BeanGuiFornitore
     */
    public BeanGuiFornitore() {
    }

    /**
     * 
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     * @param idFornitoreTxt
     */
    public BeanGuiFornitore(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, JTextField idFornitoreTxt) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo);
        this.idFornitoreTxt = idFornitoreTxt;
    }

    

    /**
     * Metodo che permette di restituire il campo id di un Fornitore
     * @return il campo id del Fornitore
     * @throws Exception
     */
    public JTextField getIdFornitoreTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idFornitoreTxt;
    }

    /**
     * Metodo che permette di settare il campo id del Fornitore
     * @param pidFornitoreTxt rappresenta l'id da inserire
     */
    public void setIdFornitoreTxt(JTextField pidFornitoreTxt) {
        this.idFornitoreTxt = pidFornitoreTxt;
        val = new NotEmptyValidator(grafica, idFornitoreTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }
}
