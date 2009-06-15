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
public class BeanGuiCliente extends BeanGuiExtraAzienda {

    private JTextField idClienteTxt;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiCliente(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto per la classe Bean Gui Cliente
     */
    public BeanGuiCliente() {
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
     * @param idClienteTxt
     */
    public BeanGuiCliente(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, JTextField idClienteTxt) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo);
        this.idClienteTxt = idClienteTxt;
    }

   

    /**
     *  motodo che setta il campo contenente l'id del Cliente
     * @param pidClienteTxt rappresenta il campo id  da inserire
     */
    public void setIdClienteTxt(JTextField pidClienteTxt) {
        this.idClienteTxt = pidClienteTxt;
        val = new NotEmptyValidator(grafica, idClienteTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente l'id del Cliente
     * @return il campo id del Cliente
     * @throws Exception
     */
    public JTextField getIdClienteTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idClienteTxt;
    }
}
