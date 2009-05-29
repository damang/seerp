package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiCliente extends BeanGuiExtraAzienda {

    /**
     * Costruttore vuoto per la classe Bean Gui Cliente
     */
    public BeanGuiCliente() {
        
    }

    /**
     *  Costruttore per la Classe Bean Gui Cliente
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     * @param listAppuntamenti
     * @param listContratti
     * @param idClienteTxt
     */
    public BeanGuiCliente(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idClienteTxt) {
        super(idExtraAziendaTxt, txtCognome, txtNome, txtRagioneSociale, txtPIva, txtFax, cmbRuolo, listAppuntamenti, listContratti);
        this.idClienteTxt = idClienteTxt;
    }

    private JTextField idClienteTxt;

    /**
     *  motodo che setta il campo contenente l'id del Cliente
     * @param idClienteTxt rappresenta il campo id  da inserire
     */
    public void setIdClienteTxt(JTextField idClienteTxt) {
        this.idClienteTxt = idClienteTxt;
    }

    /**
     * metodo che restituisce il campo contenente l'id del Cliente
     * @return il campo id del Cliente
     */
    public JTextField getIdClienteTxt() {
        return idClienteTxt;
    }

}
