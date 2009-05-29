package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiContatto extends BeanGuiExtraAzienda{

    /**
     * Costruttore vuoto per la classe Bean Gui Contatto
     */
    public BeanGuiContatto() {
        
    }

    /**
     * Costruttore per la classe Bean Gui Contatto
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     * @param listAppuntamenti
     * @param listContratti
     * @param idContattoTxt
     * @param txtFeedback
     */
    public BeanGuiContatto(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idContattoTxt, JTextField txtFeedback) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idContattoTxt = idContattoTxt;
        this.txtFeedback = txtFeedback;
    }

    private JTextField idContattoTxt;
    private JTextField txtFeedback;

    /**
     * metodo che restituisce il campo contenente l'id del Contatto
     * @return il campo id del Contatto
     */
    public JTextField getIdContattoTxt() {
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
     * @param idContattoTxt rappresenta il campo id da inserire
     */
    public void setIdContattoTxt(JTextField idContattoTxt) {
        this.idContattoTxt = idContattoTxt;
    }

    /**
     * metodo che permette di settare il campo contenente il feedback del Contatto
     * @param txtFeedback rappresenta il campo feedback  da inserire
     */
    public void setTxtFeedback(JTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }



}
