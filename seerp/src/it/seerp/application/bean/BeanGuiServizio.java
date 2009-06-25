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
    public BeanGuiServizio(Object c) {
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
        if (validator == true) {
            if (!descrizione.getInputVerifier().shouldYieldFocus(descrizione)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return descrizione;
    }

    /**
     *
     * @param pdescrizione
     */
    public void setDescrizione(JTextField pdescrizione) {
        this.descrizione = pdescrizione;
        descrizione.setInputVerifier(new NotEmptyValidator(grafica, descrizione, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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
        if (validator == true) {
            if (iva.getInputVerifier().shouldYieldFocus(iva) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return iva;
    }

    /**
     *
     * @param piva
     */
    public void setIva(JTextField piva) {
        this.iva = piva;
        iva.setInputVerifier(new NotEmptyValidator(grafica, iva, "Il campo IVA deve essere di 11 caratteri.", RegexpDef.valueOf(RegexpDef.VAL.PIVA))); //espressione
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
        if (validator == true) {
            if (!prezzo.getInputVerifier().shouldYieldFocus(prezzo) && validator == true) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return prezzo;
    }

    /**
     *
     * @param pprezzo
     */
    public void setPrezzo(JTextField pprezzo) {
        this.prezzo = pprezzo;
        prezzo.setInputVerifier(new NotEmptyValidator(grafica, prezzo, "Prezzo inserito non valido.", RegexpDef.valueOf(RegexpDef.VAL.PREZZO)));
    }

    /**
     *
     * @return
     * @throws ValidatorException
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
     *
     * @param pquantita
     */
    public void setQuantita(JTextField pquantita) {
        this.quantita = pquantita;
        quantita.setInputVerifier(new NotEmptyValidator(grafica, quantita, "Inserire una quantità positiva.", RegexpDef.valueOf(RegexpDef.VAL.NUMPOS)));
    }

    /**
     *
     * @return
     * @throws ValidatorException
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
     *
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }
}
