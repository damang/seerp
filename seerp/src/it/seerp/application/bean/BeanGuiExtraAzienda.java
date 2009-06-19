package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import it.seerp.application.validation.NotMinLengthValidator;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * Classe relativa ai componenti grafici della gestione Extra Azienda
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiExtraAzienda extends BeanGuiUtente {

    private JTextField cognome;
    private JTextField nome;
    private JTextField ragioneSociale;
    private JTextField pIva;
    private JTextField fax;
    private JTextField ruolo;
    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;


    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiExtraAzienda(JXPanel c) {
        super(c);
    }

    /**
     * Costruttore vuoto per la classe Bean Gui ExtraAzienda
     */
    public BeanGuiExtraAzienda() {
    }

    /**
     *
     * @param idUtenteTxt
     * @param txtUsername
     * @param txtPassword
     * @param txtCitta
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param tipo
     * @param visible
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     */
    public BeanGuiExtraAzienda(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField ragioneSociale, JTextField pIva, JTextField fax, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible);
        this.cognome = cognome;
        this.nome = nome;
        this.ragioneSociale = ragioneSociale;
        this.pIva = pIva;
        this.fax = fax;
        this.ruolo = ruolo;
    }

    /**
     *
     * @param ragioneSociale
     */
    public void setRagioneSociale(JTextField ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
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
     * @param ruolo
     */
    public void setRuolo(JTextField ruolo) {
        this.ruolo = ruolo;
    }

    /**
     *metodo che setta il campo contenente il cognome dell'ExtraAzienda
     * @param ptxtCognome rappresenta il campo cognome da inserire
     */
    public void setCognome(JTextField ptxtCognome) {
        this.cognome = ptxtCognome;
        val = new NotEmptyValidator(grafica, cognome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, cognome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     * metodo che setta il campo contenente il nome dell'ExtraAzienda
     * @param ptxtNome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField ptxtNome) {
        this.nome = ptxtNome;
        val = new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, nome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     *metodo che setta il campo contenente il fax dell'ExtraAzienda
     * @param ptxtFax rappresenta il campo fax da inserire
     */
    public void setFax(JTextField ptxtFax) {
        this.fax = ptxtFax;
        valMinLen = new NotMinLengthValidator(grafica, fax, "Il campo deve essere di almeno 8 caratteri", 8);
        grafica.setInputVerifier(valMinLen);
    }

    /**
     *metodo che setta il campo contenente la partita iva dell'ExtraAzienda
     * @param pIva
     */
    public void setPIva(JTextField pIva) {
        this.pIva = pIva;
        val = new NotEmptyValidator(grafica, pIva, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEqLen = new NotEqualLengthValidator(grafica, pIva, "Il campo deve essere di 11 caratteri", 11);
        grafica.setInputVerifier(valEqLen);
    }

    /**
     * metodo che setta il campo contenente la ragione sociale dell'ExtraAzienda
     * @param ptxtRagioneSociale rappresenta il campo ragione sociale da inserire
     */
    public void setTxtRagioneSociale(JTextField ptxtRagioneSociale) {
        this.ragioneSociale = ptxtRagioneSociale;
        val = new NotEmptyValidator(grafica, ragioneSociale, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente il ruolo dell'ExtraAzienda
     * @return il campo ruolo dell'ExtraAzienda
     */
    public JTextField getRuolo() {
        return ruolo;
    }

    /**
     * metodo che restituisce il campo contenente il cognome dell'ExtraAzienda
     * @return il campo cognome dell'ExtraAzienda
     * @throws ValidatorException
     */
    public JTextField getCognome() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return cognome;
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'ExtraAzienda
     * @return il campo nome dell'ExtraAzieda
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return nome;
    }

    /**
     * metodo che restituisce il campo contenente il fax dell'ExtraAzienda
     * @return il campo fax dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getFax() throws ValidatorException {
        if (!valMinLen.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return fax;
    }

    /**
     * metodo che restituisce il campo contenente la partita iva dell'ExtraAzienda
     * @return il campo partita iva dell'extraAzienda
     * @throws Exception
     */
    public JTextField getPIva() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        } else if (!valEqLen.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return pIva;
    }

    /**
     * metodo che restituisce il campo contenente la ragione sociale dell'ExtraAzienda
     * @return il campo ragione sociale dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getRagioneSociale() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return ragioneSociale;
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
