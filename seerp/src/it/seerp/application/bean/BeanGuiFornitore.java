package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiFornitore extends BeanGuiExtraAzienda {

    /**
     * Costruttore per vuoto per la classe BeanGuiFornitore
     */
    public BeanGuiFornitore() {
        
    }

    /**
     *  Costruttore per la classe BenaGuiFornitore
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     * @param listAppuntamenti
     * @param listContratti
     * @param idFornitoreTxt
     */
    public BeanGuiFornitore(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idFornitoreTxt) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idFornitoreTxt = idFornitoreTxt;
    }

    private JTextField idFornitoreTxt;

    /**
     * Metodo che permette di restituire il campo id di un Fornitore
     * @return il campo id del Fornitore
     */
    public JTextField getIdFornitoreTxt() {
        return idFornitoreTxt;
    }

   

    /**
     * Metodo che permette di settare il campo id del Fornitore
     * @param idFornitoreTxt rappresenta l'id da inserire
     */
    public void setIdFornitoreTxt(JTextField idFornitoreTxt) {
        this.idFornitoreTxt = idFornitoreTxt;
    }



}
