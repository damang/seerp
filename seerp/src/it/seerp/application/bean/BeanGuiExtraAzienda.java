package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import it.seerp.application.validation.NotMinLengthValidator;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione Extra Azienda
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiExtraAzienda extends BeanGuiUtente {

    private JTextField cognome;
    private JTextField nome;
    private JTextField ragioneSociale;
    private JTextField pIva;
    private JTextField codiceFiscale;
    private JTextField fax;
    private JTextField ruolo;
    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;

    /**
     *
     * @return
     */
    public JTextField getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     *
     * @param codiceFiscale
     */
    public void setCodiceFiscale(JTextField codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiExtraAzienda(JPanel c) {
        super(c);
    }

    /**
     * Costruttore vuoto per la classe Bean Gui ExtraAzienda
     */
    public BeanGuiExtraAzienda() {
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
        cognome.setInputVerifier(new NotEmptyValidator((JPanel) grafica, cognome, "Il campo non può essere vuoto."));
        cognome.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica, cognome, "La stringa inserita deve essere alfabetica."));
    }

    /**
     * metodo che setta il campo contenente il nome dell'ExtraAzienda
     * @param ptxtNome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField ptxtNome) {
        this.nome = ptxtNome;
        nome.setInputVerifier(new NotEmptyValidator((JPanel) grafica, nome, "Il campo non può essere vuoto."));
        nome.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica, nome, "La stringa inserita deve essere alfabetica."));
    }

    /**
     *metodo che setta il campo contenente il fax dell'ExtraAzienda
     * @param ptxtFax rappresenta il campo fax da inserire
     */
    public void setFax(JTextField ptxtFax) {
        this.fax = ptxtFax;
        fax.setInputVerifier(new NotMinLengthValidator((JPanel) grafica, fax, "Il campo deve essere di almeno 8 caratteri", 8));
    }

    /**
     *metodo che setta il campo contenente la partita iva dell'ExtraAzienda
     * @param ppIva
     */
    public void setPIva(JTextField ppIva) {
        this.pIva = ppIva;
        pIva.setInputVerifier(new NotEmptyValidator((JPanel) grafica, pIva, "Il campo non può essere vuoto."));
        pIva.setInputVerifier(new NotEqualLengthValidator((JPanel) grafica, pIva, "Il campo deve essere di 11 caratteri", 11));
    }

    /**
     * metodo che setta il campo contenente la ragione sociale dell'ExtraAzienda
     * @param ptxtRagioneSociale rappresenta il campo ragione sociale da inserire
     */
    public void setTxtRagioneSociale(JTextField ptxtRagioneSociale) {
        this.ragioneSociale = ptxtRagioneSociale;
        ragioneSociale.setInputVerifier(new NotEmptyValidator((JPanel) grafica, ragioneSociale, "Il campo non può essere vuoto."));
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
        if (!cognome.getInputVerifier().shouldYieldFocus(cognome) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!cognome.getInputVerifier().shouldYieldFocus(cognome) && validator==true) {
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
        if (!nome.getInputVerifier().shouldYieldFocus(nome) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!nome.getInputVerifier().shouldYieldFocus(nome) && validator==true) {
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
        if (!fax.getInputVerifier().shouldYieldFocus(fax) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return fax;
    }

    /**
     * metodo che restituisce il campo contenente la partita iva dell'ExtraAzienda
     * @return il campo partita iva dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getPIva() throws ValidatorException {
        if (!pIva.getInputVerifier().shouldYieldFocus(pIva) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        } else if (!pIva.getInputVerifier().shouldYieldFocus(pIva) && validator==true) {
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
        if (!ragioneSociale.getInputVerifier().shouldYieldFocus(ragioneSociale) && validator==true) {
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
