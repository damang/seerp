package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.Gui.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dei Servizi
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiServizio {

    private JTextField descrizione;
    private JTextField disponibilita;
    private JTextField quantita;
    private JTextField tipo;
    private JTextField prezzo;
    private JTextField idServizio;
    private JTextField iva;
    private JTextArea note;
    private ArrayList<BeanGuiServizioAssociato> listServiziAssociati;
    private Object grafica;
    protected boolean validator = true;

    /**
     * metodo che restituisce il campo validator del bean gui servizio
     * @return il campo validator
     */
    public boolean isValidator() {
        return validator;
    }

    /**
     * Metodo che setta il campo validator del bean gui servizio
     * @param validator
     */
    public void setValidatorE(boolean validator) {
        this.validator = validator;
        ((NotEmptyValidator) descrizione.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) quantita.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) tipo.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) prezzo.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) iva.getInputVerifier()).setEnabled(validator);

        ((NotEmptyValidator) descrizione.getInputVerifier()).reset(descrizione);
        ((NotEmptyValidator) quantita.getInputVerifier()).reset(quantita);
        ((NotEmptyValidator) tipo.getInputVerifier()).reset(tipo);
        ((NotEmptyValidator) prezzo.getInputVerifier()).reset(prezzo);
        ((NotEmptyValidator) iva.getInputVerifier()).reset(iva);
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiServizio(Object c) {
        this.grafica = c;
    }

    /**
     * costruttore vuoto del bean gui servizio
     */
    public BeanGuiServizio() {
    }

    /**
     * metodo che restituisce la lista dei servizi associati del bean gui servizio
     * @return la lista di servizi associati
     */
    public ArrayList<BeanGuiServizioAssociato> getListServiziAssociati() {
        return listServiziAssociati;
    }

    /**
     * metodo che setta la lista dei servizi associati al bean gui servizio
     * @param listServiziAssociati
     */
    public void setListServiziAssociati(ArrayList<BeanGuiServizioAssociato> listServiziAssociati) {
        this.listServiziAssociati = listServiziAssociati;
    }

    /**
     * metodo che rimuove un servizio associato dal bean gui servizio
     * @param c
     */
    public void removeServizio(BeanGuiServizioAssociato c) {
        listServiziAssociati.remove(c);
    }

    /**
     * metodo che aggiunge un servizio associato alììdal bean gui servizio
     * @param c
     */
    public void addServizio(BeanGuiServizioAssociato c) {
        listServiziAssociati.add(c);
    }

    /**
     * metodo che restituisce il campo descrizione del bean gui personale
     * @return il campo descrizione
     * @throws ValidatorException lanciata quando il formato non è valido
     */
    public JTextField getDescrizione() throws ValidatorException {
        if (validator == true) {
            if (!descrizione.getInputVerifier().shouldYieldFocus(descrizione)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return descrizione;
    }

    /**
     * metodo che setta il campo descrizione del bean gui servizio
     * @param pdescrizione
     */
    public void setDescrizione(JTextField pdescrizione) {
        this.descrizione = pdescrizione;
        descrizione.setInputVerifier(new NotEmptyValidator(grafica, descrizione, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     * metodo che restituisce il campo disponibilita del bean gui servizio
     * @return il campo disponibile
     */
    public JTextField getDisponibilita() {
        return disponibilita;
    }

    /**
     * metodo che setta il campo disponibilita del bean gui servizio
     * @param disponibilita
     */
    public void setDisponibilita(JTextField disponibilita) {
        this.disponibilita = disponibilita;
    }

    /**
     * metodo che restituisce il campo ide del bean gui servizion
     * @return il campo id
     */
    public JTextField getIdServizio() {
        return idServizio;
    }

    /**
     * metodo che setta il campo id del bean gui servizio
     * @param idServizio
     */
    public void setIdServizio(JTextField idServizio) {
        this.idServizio = idServizio;
    }

    /**
     * metodo che restituisce il campo iva del bean gui servizio
     * @return il campo iva
     * @throws ValidatorException lanciata se il formato della partita iva non è valido
     */
    public JTextField getIva() throws ValidatorException {
        if (validator == true) {
            if (iva.getInputVerifier().shouldYieldFocus(iva) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return iva;
    }

    /**
     * metodo che setta il campo iva del bean gui servizio
     * @param piva
     */
    public void setIva(JTextField piva) {
        this.iva = piva;
        iva.setInputVerifier(new NotEmptyValidator(grafica, iva, "Il campo IVA deve essere di 11 caratteri.", RegexpDef.valueOf(RegexpDef.VAL.PIVA))); //espressione
    }

    /**
     * metodo che restituisce il campo note del bean gui servizio
     * @return il campo note
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note del bean gui servizio
     * @param pnote
     */
    public void setNote(JTextArea pnote) {
        this.note = pnote;
    }

    /**
     * metodo che restituisce il campo prezzo del bean gui servizio
     * @return il campo prezzo
     * @throws ValidatorException lanciata se il formato del campo prezzo nno è valido
     */
    public JTextField getPrezzo() throws ValidatorException {
        if (validator == true) {
            if (!prezzo.getInputVerifier().shouldYieldFocus(prezzo) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return prezzo;
    }

    /**
     * metodo che setta il campo prezzo del bean gui servizio
     * @param pprezzo
     */
    public void setPrezzo(JTextField pprezzo) {
        this.prezzo = pprezzo;
        prezzo.setInputVerifier(new NotEmptyValidator(grafica, prezzo, "Prezzo inserito non valido.", RegexpDef.valueOf(RegexpDef.VAL.PREZZO)));
    }

    /**
     * metodo che restituisce il campo quantita del bean gui servizio
     * @return il campo quantita
     * @throws ValidatorException lanciata se il formato della quantita non è valido
     */
    public JTextField getQuantita() throws ValidatorException {
        if (validator == true) {
            if (!quantita.getInputVerifier().shouldYieldFocus(quantita) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return quantita;
    }

    /**
     * metodo che setta il campo quantita del bean gui servizio
     * @param pquantita
     */
    public void setQuantita(JTextField pquantita) {
        this.quantita = pquantita;
        quantita.setInputVerifier(new NotEmptyValidator(grafica, quantita, "Inserire una quantità positiva.", RegexpDef.valueOf(RegexpDef.VAL.NUMPOS)));
    }

    /**
     * metodo che restituisce il campo tipo del bean gui servizio
     * @return il campo tipo
     * @throws ValidatorException lanciata se il formato del tipo non è valido
     */
    public JTextField getTipo() throws ValidatorException {
        if (validator == true) {
            if (!tipo.getInputVerifier().shouldYieldFocus(tipo) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return tipo;
    }

    /**
     * metodo che setta il campo tipo del bean gui servizio
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }
}
