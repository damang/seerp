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
public class BeanGuiContatto extends BeanGuiExtraAzienda {

    private JTextField idContattoTxt;
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
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     * @param idContattoTxt
     * @param txtFeedback
     */
    public BeanGuiContatto(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, JTextField idContattoTxt, JTextField txtFeedback) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo);
        this.idContattoTxt = idContattoTxt;
        this.txtFeedback = txtFeedback;
    }

   

    /**
     * metodo che restituisce il campo contenente l'id del Contatto
     * @return il campo id del Contatto
     * @throws Exception
     */
    public JTextField getIdContattoTxt() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idContattoTxt;
    }

    /**
     * metodo che restituisce il campo contenente il feedback del Contatto
     * @return il campo feedback
     */
    public JTextField getTxtFeedback() {
        return txtFeedback;
    }

    /**
     * metodo che permette di settare il campo contenente l'id del Contatto
     * @param pidContattoTxt rappresenta il campo id da inserire
     */
    public void setIdContattoTxt(JTextField pidContattoTxt) {
        this.idContattoTxt = pidContattoTxt;
        val = new NotEmptyValidator(grafica, idContattoTxt, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che permette di settare il campo contenente il feedback del Contatto
     * @param txtFeedback rappresenta il campo feedback  da inserire
     */
    public void setTxtFeedback(JTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }
}
