package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotMinNumberValidator;
import it.seerp.application.validation.NotNumericValidator;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    protected boolean validator=true;

    public boolean isValidator() {
        return validator;
    }

    public void setValidator(boolean validator) {
        this.validator = validator;
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiServizio(JPanel c) {
        this.grafica = c;
    }
    public BeanGuiServizio(JFrame c) {
        this.grafica = c;
    }
    public BeanGuiServizio() {
        
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiServizioAssociato> getListServiziAssociati() {
        return listServiziAssociati;
    }

    /**
     *
     * @param listServiziAssociati
     */
    public void setListServiziAssociati(ArrayList<BeanGuiServizioAssociato> listServiziAssociati) {
        this.listServiziAssociati = listServiziAssociati;
    }

    /**
     *
     * @param c
     */
    public void removeServizio(BeanGuiServizioAssociato c) {
        listServiziAssociati.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addServizio(BeanGuiServizioAssociato c) {
        listServiziAssociati.add(c);
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getDescrizione() throws ValidatorException {
     if (!descrizione.getInputVerifier().shouldYieldFocus(descrizione) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!descrizione.getInputVerifier().shouldYieldFocus(descrizione) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return descrizione;
    }

    /**
     *
     * @param pdescrizione
     */
    public void setDescrizione(JTextField pdescrizione) {
        this.descrizione = pdescrizione;
        descrizione.setInputVerifier(new NotEmptyValidator((JPanel) grafica,descrizione, "Il campo non può essere vuoto."));
        descrizione.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica,descrizione, "La stringa inserita deve essere alfabetica."));
    }

    /**
     *
     * @return
     */
    public JTextField getDisponibilita() {
        return disponibilita;
    }

    /**
     *
     * @param disponibilita
     */
    public void setDisponibilita(JTextField disponibilita) {
        this.disponibilita = disponibilita;
    }

    /**
     *
     * @return
     */
    public JTextField getIdServizio() {
        return idServizio;
    }

    /**
     *
     * @param idServizio
     */
    public void setIdServizio(JTextField idServizio) {
        this.idServizio = idServizio;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getIva() throws ValidatorException {
        if (iva.getInputVerifier().shouldYieldFocus(iva) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!iva.getInputVerifier().shouldYieldFocus(iva) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return iva;
    }

    /**
     *
     * @param piva
     */
    public void setIva(JTextField piva) {
        this.iva = piva;
        iva.setInputVerifier(new NotEmptyValidator((JPanel) grafica,iva, "Il campo non può essere vuoto."));
        iva.setInputVerifier(new NotNumericValidator((JPanel) grafica,iva, "Il campo deve essere numerico."));
    }

    /**
     *
     * @return
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     *
     * @param pnote
     */
    public void setNote(JTextArea pnote) {
        this.note = pnote;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getPrezzo() throws ValidatorException {
       if (!prezzo.getInputVerifier().shouldYieldFocus(prezzo) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!prezzo.getInputVerifier().shouldYieldFocus(prezzo) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return prezzo;
    }

    /**
     *
     * @param pprezzo
     */
    public void setPrezzo(JTextField pprezzo) {
        this.prezzo = pprezzo;
        prezzo.setInputVerifier(new NotEmptyValidator((JPanel) grafica,prezzo, "Il campo non può essere vuoto."));
        prezzo.setInputVerifier(new NotNumericValidator((JPanel) grafica,prezzo, "Il campo deve essere numerico."));
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getQuantita() throws ValidatorException {
        if (!quantita.getInputVerifier().shouldYieldFocus(quantita) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!quantita.getInputVerifier().shouldYieldFocus(quantita) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return quantita;
    }

    /**
     *
     * @param pquantita
     */
    public void setQuantita(JTextField pquantita) {
        this.quantita = pquantita;
        quantita.setInputVerifier(new NotEmptyValidator((JPanel) grafica,quantita, "Il campo non può essere vuoto."));
        quantita.setInputVerifier(new NotMinNumberValidator((JPanel) grafica,quantita, "Il campo non può essere minore di 1.", 1));
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTipo() throws ValidatorException {
        if (!tipo.getInputVerifier().shouldYieldFocus(tipo) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!tipo.getInputVerifier().shouldYieldFocus(tipo) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return tipo;
    }

    /**
     *
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator((JPanel) grafica,tipo, "Il campo non può essere vuoto."));
        tipo.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica,tipo, "La stringa inserita deve essere alfabetica."));
    }
}
