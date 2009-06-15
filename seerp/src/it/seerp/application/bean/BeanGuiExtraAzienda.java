package it.seerp.application.bean;

import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import it.seerp.application.validation.NotMinLengthValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiExtraAzienda extends BeanGuiUtente {

    private JTextField idExtraAziendaTxt;
    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtRagioneSociale;
    private JTextField txtPIva;
    private JTextField txtFax;
    private JComboBox cmbRuolo;
    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;
    private JXPanel grafica;
    private NotEmptyValidator val;
    private NotEqualLengthValidator valEqLen;
    private NotMinLengthValidator valMinLen;
    private NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiExtraAzienda(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto per la classe Bean Gui ExtraAzienda
     */
    public BeanGuiExtraAzienda() {
    }

    /**
     *Costruttore per la classe Bean Gui ExtraAzienda
     * @param idExtraAziendaTxt
     * @param txtCognome
     * @param txtNome
     * @param txtRagioneSociale
     * @param txtPIva
     * @param txtFax
     * @param cmbRuolo
     */
    public BeanGuiExtraAzienda(JTextField idExtraAziendaTxt, JTextField txtCognome, JTextField txtNome, JTextField txtRagioneSociale, JTextField txtPIva, JTextField txtFax, JComboBox cmbRuolo) {
        this.idExtraAziendaTxt = idExtraAziendaTxt;
        this.txtCognome = txtCognome;
        this.txtNome = txtNome;
        this.txtRagioneSociale = txtRagioneSociale;
        this.txtPIva = txtPIva;
        this.txtFax = txtFax;
        this.cmbRuolo = cmbRuolo;
        this.listAppuntamenti= new ArrayList<BeanGuiAppuntamento>();
        this.listContratti= new ArrayList<BeanGuiContratto>();
    }

    /**
     * metodo che restituisce la lista degli appuntamenti di un ExtraAzienda
     * @return la lista degli appuntamenti
     */
    public ArrayList<BeanGuiAppuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * metodo che restituisce la lista dei contratti a cui un ExtraAzienda è associato
     * @return la lista dei contratti
     */
    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    /**
     * metodo che setta la lista degli appuntamenti di un ExtraAzienda
     * @param listAppuntamenti la lista degli appuntamenti da ineserire
     */
    public void setListAppuntamenti(ArrayList<BeanGuiAppuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    /**
     * metodo che setta la lista degli contratti di un ExtraAzienda
     * @param listContratti la lista dei contratto da inserire
     */
    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
    }

    /**
     * metodo che setta il campo contenente il ruolo dell'ExtraAzienda
     * @param cmbRuolo rappresenta il campo ruolo da inserire
     */
    public void setCmbRuolo(JComboBox cmbRuolo) {
        this.cmbRuolo = cmbRuolo;
    }

    /**
     * metodo che setta il campo contenente l'id dell'ExtraAzienda
     * @param idExtraAziendaTxt rappresenta il campo id da inserire
     */
    public void setIdExtraAziendaTxt(JTextField idExtraAziendaTxt) {
        this.idExtraAziendaTxt = idExtraAziendaTxt;
    }

    /**
     *metodo che setta il campo contenente il cognome dell'ExtraAzienda
     * @param ptxtCognome rappresenta il campo cognome da inserire
     */
    public void setTxtCognome(JTextField ptxtCognome) {
        this.txtCognome = ptxtCognome;
        val = new NotEmptyValidator(grafica, txtCognome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, txtCognome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     * metodo che setta il campo contenente il nome dell'ExtraAzienda
     * @param ptxtNome rappresenta il campo nome da inserire
     */
    public void setTxtNome(JTextField ptxtNome) {
        this.txtNome = ptxtNome;
        val = new NotEmptyValidator(grafica, txtNome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, txtNome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     *metodo che setta il campo contenente il fax dell'ExtraAzienda
     * @param ptxtFax rappresenta il campo fax da inserire
     */
    public void setTxtFax(JTextField ptxtFax) {
        this.txtFax = ptxtFax;
        valMinLen = new NotMinLengthValidator(grafica, txtFax, "Il campo deve essere di almeno 8 caratteri", 8);
        grafica.setInputVerifier(valMinLen);
    }

    /**
     *metodo che setta il campo contenente la partita iva dell'ExtraAzienda
     * @param ptxtPIva rappresenta il campo partita iva da inserire
     */
    public void setTxtPIva(JTextField ptxtPIva) {
        this.txtPIva = ptxtPIva;
        val = new NotEmptyValidator(grafica, txtPIva, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEqLen = new NotEqualLengthValidator(grafica, txtPIva, "Il campo deve essere di 11 caratteri", 11);
        grafica.setInputVerifier(valEqLen);
    }

    /**
     * metodo che setta il campo contenente la ragione sociale dell'ExtraAzienda
     * @param ptxtRagioneSociale rappresenta il campo ragione sociale da inserire
     */
    public void setTxtRagioneSociale(JTextField ptxtRagioneSociale) {
        this.txtRagioneSociale = ptxtRagioneSociale;
        val = new NotEmptyValidator(grafica, txtRagioneSociale, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente il ruolo dell'ExtraAzienda
     * @return il campo ruolo dell'ExtraAzienda
     */
    public JComboBox getCmbRuolo() {
        return cmbRuolo;
    }

    /**
     * metodo che restituisce il campo contenente l'id  dell'ExtraAzienda
     * @return il campo id dell'ExtraAzienda
     */
    public JTextField getIdExtraAziendaTxt() {
        return idExtraAziendaTxt;
    }

    /**
     * metodo che restituisce il campo contenente il cognome dell'ExtraAzienda
     * @return il campo cognome dell'ExtraAzienda
     */
    public JTextField getTxtCognome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtCognome;
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'ExtraAzienda
     * @return il campo nome dell'ExtraAzieda
     */
    public JTextField getTxtNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtNome;
    }

    /**
     * metodo che restituisce il campo contenente il fax dell'ExtraAzienda
     * @return il campo fax dell'extraAzienda
     */
    public JTextField getTxtFax() throws Exception {
        if (!valMinLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtFax;
    }

    /**
     * metodo che restituisce il campo contenente la partita iva dell'ExtraAzienda
     * @return il campo partita iva dell'extraAzienda
     */
    public JTextField getTxtPIva() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        } else if (!valEqLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtPIva;
    }

    /**
     * metodo che restituisce il campo contenente la ragione sociale dell'ExtraAzienda
     * @return il campo ragione sociale dell'extraAzienda
     */
    public JTextField getTxtRagioneSociale() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtRagioneSociale;
    }

    /**
     * metodo che rimuove un appuntamento dalla lista degli appuntamenti
     * @param p rappresenta l'asspuntamento da rimuovere
     */
    public void removeAppuntamento(BeanGuiAppuntamento p) {
        listAppuntamenti.remove(p);
    }

    /**
     * metodo che aggiunge un appuntamento nella lista degli appuntamenti
     * @param p rappresenta l'appuntamento che si vuole inserire
     */
    public void addAppuntamento(BeanGuiAppuntamento p) {
        listAppuntamenti.add(p);
    }

    /**
     * metodo che rimuove un contratto dalla lista dei contratti
     * @param c rappresenta il contratto che si vuole eliminare
     */
    public void removeContratto(BeanGuiContratto c) {
        listContratti.remove(c);
    }

    /**
     * metodo che aggiunge un contratto alla lista dei contratti
     * @param c rappresenta il contratto che si vuole inserire
     */
    public void addContratto(BeanGuiContratto c) {
        listContratti.add(c);
    }
}
