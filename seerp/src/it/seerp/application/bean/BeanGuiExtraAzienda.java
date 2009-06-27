package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.Gui.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
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

    @Override
    public void setValidatorEnabled(boolean validator) {
        super.setValidatorEnabled(validator);
        ((NotEmptyValidator) nome.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) cognome.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) codiceFiscale.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) pIva.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) fax.getInputVerifier()).setEnabled(validator);
        // ((NotEmptyValidator) cliente.getRagioneSociale().getInputVerifier()).setEnabled(f);
        ((NotEmptyValidator) nome.getInputVerifier()).reset(nome);
        ((NotEmptyValidator) cognome.getInputVerifier()).reset(cognome);
        ((NotEmptyValidator) codiceFiscale.getInputVerifier()).reset(codiceFiscale);
        ((NotEmptyValidator) pIva.getInputVerifier()).reset(pIva);
        ((NotEmptyValidator) fax.getInputVerifier()).reset(fax);
    }

    /**
     *
     * @return
     */
    public JTextField getCodiceFiscale() throws ValidatorException {
        if (validator == true) {
            if (!codiceFiscale.getInputVerifier().shouldYieldFocus(codiceFiscale)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return codiceFiscale;
    }

    /**
     *
     * @param codiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.codiceFiscale = pcodiceFiscale;
        codiceFiscale.setInputVerifier(new NotEmptyValidator(grafica, codiceFiscale, "Il CF deve essere di 16 caratteri", RegexpDef.valueOf(RegexpDef.VAL.CODFIS)));
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiExtraAzienda(Object c) {
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
        cognome.setInputVerifier(new NotEmptyValidator(grafica, cognome, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     * metodo che setta il campo contenente il nome dell'ExtraAzienda
     * @param ptxtNome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField ptxtNome) {
        this.nome = ptxtNome;
        nome.setInputVerifier(new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     *metodo che setta il campo contenente il fax dell'ExtraAzienda
     * @param ptxtFax rappresenta il campo fax da inserire
     */
    public void setFax(JTextField ptxtFax) {
        this.fax = ptxtFax;
        fax.setInputVerifier(new NotEmptyValidator(grafica, fax, "Il campo deve essere di almeno 8 caratteri", RegexpDef.valueOf(RegexpDef.VAL.TELEFONO)));
    }

    /**
     *metodo che setta il campo contenente la partita iva dell'ExtraAzienda
     * @param ppIva
     */
    public void setPIva(JTextField ppIva) {
        this.pIva = ppIva;
        pIva.setInputVerifier(new NotEmptyValidator(grafica, pIva, "Il campo IVA deve essere di 11 caratteri.", RegexpDef.valueOf(RegexpDef.VAL.PIVA)));
    }

    /**
     * metodo che setta il campo contenente la ragione sociale dell'ExtraAzienda
     * @param ptxtRagioneSociale rappresenta il campo ragione sociale da inserire
     */
    public void setTxtRagioneSociale(JTextField ptxtRagioneSociale) {
        this.ragioneSociale = ptxtRagioneSociale;
        ragioneSociale.setInputVerifier(new NotEmptyValidator(grafica, ragioneSociale, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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
        if (validator == true) {
            if (!cognome.getInputVerifier().shouldYieldFocus(cognome)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return cognome;
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'ExtraAzienda
     * @return il campo nome dell'ExtraAzieda
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (validator == true) {
            if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return nome;
    }

    /**
     * metodo che restituisce il campo contenente il fax dell'ExtraAzienda
     * @return il campo fax dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getFax() throws ValidatorException {
        if (validator == true) {
            if (!fax.getInputVerifier().shouldYieldFocus(fax)) {
                throw new ValidatorException("Il campo deve essere di almeno 8 caratteri");
            }
        }
        return fax;
    }

    /**
     * metodo che restituisce il campo contenente la partita iva dell'ExtraAzienda
     * @return il campo partita iva dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getPIva() throws ValidatorException {
        if (validator == true) {
            if (!pIva.getInputVerifier().shouldYieldFocus(pIva)) {
                throw new ValidatorException("Il campo IVA deve essere di 11 caratteri.");
            }
        }
        return pIva;
    }

    /**
     * metodo che restituisce il campo contenente la ragione sociale dell'ExtraAzienda
     * @return il campo ragione sociale dell'extraAzienda
     * @throws ValidatorException
     */
    public JTextField getRagioneSociale() throws ValidatorException {
        //  if (validator == true) {
        //    if (!ragioneSociale.getInputVerifier().shouldYieldFocus(ragioneSociale)) {
        //    throw new ValidatorException("Il campo non può essere vuoto.");
        //  }
        // }
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
