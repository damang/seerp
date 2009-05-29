package it.seerp.application.bean;

import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

    /**
     * Costruttore vuoto per la classe Bean Gui Personale
     */
    public BeanGuiDipendente() {

    }

    /**
     * Costruttore per la classe Bean Gui Personale
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param listPermessi
     * @param listRuoli
     * @param listAppuntamenti
     * @param listContratti
     * @param idDipendenteTxt
     */
    public BeanGuiDipendente(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, ArrayList<BeanGuiAppuntamento> listAppuntamenti, ArrayList<BeanGuiContratto> listContratti, JTextField idDipendenteTxt) {
        super(idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
        this.idDipendenteTxt = idDipendenteTxt;
    }

   private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
   private ArrayList<BeanGuiContratto> listContratti;
   private JTextField idDipendenteTxt;

     /**
      * metodo che restituisce la lista degli appuntamenti che un Personale deve ricevere
      * @return la lista degli appuntamenti
      */
     public ArrayList<BeanGuiAppuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * metodo che restituisce la lista dei contratti che un Personale ha stipulato
     * @return la lista dei contratti
     */
    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    /**
     * metodo che setta la lista degli appuntamenti di un Personale
     * @param listAppuntamenti rappresenta la lista degli appuntamenti da inserire
     */
    public void setListAppuntamenti(ArrayList<BeanGuiAppuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    /**
     * metodo che setta la lista dei contratti di un Personale
     * @param listContratti rappresenta la lista dei contratti da inserire
     */
    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
    }

     /**
      * metodo che restituisce il campo contenente l'id del Personale
      * @return il campo id del Personale
      */
     public JTextField getIdDipendenteTxt() {
        return idDipendenteTxt;
    }

      

    /**
     * metodo che setta il campi id del Personale
     * @param idDipendenteTxt rappresenta il campo id da inserire
     */
    public void setIdDipendenteTxt(JTextField idDipendenteTxt) {
        this.idDipendenteTxt = idDipendenteTxt;
    }
}
