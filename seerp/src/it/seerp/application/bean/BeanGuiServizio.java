package it.seerp.application.bean;

import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotMinNumberValidator;
import it.seerp.application.validation.NotNumericValidator;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

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
    private GestioneServizi grafica;
    private NotEmptyValidator val;
    private NotAlphabeticValidator valApha;
    private NotMinNumberValidator valMinNum;
    private NotNumericValidator valNum;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiServizio(GestioneServizi c) {
        grafica = c;
    }

    /**
     *
     */
    public BeanGuiServizio() {
    }

    /**
     *
     * @param descrizione
     * @param disponibilita
     * @param quantita
     * @param tipo
     * @param prezzo
     * @param idServizio
     * @param iva
     * @param note
     */
    public BeanGuiServizio(JTextField descrizione, JTextField disponibilita, JTextField quantita, JTextField tipo, JTextField prezzo, JTextField idServizio, JTextField iva, JTextArea note) {
        this.descrizione = descrizione;
        this.disponibilita = disponibilita;
        this.quantita = quantita;
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.idServizio = idServizio;
        this.iva = iva;
        this.note = note;
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
     /*   if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }*/
        return descrizione;
    }

    /**
     *
     * @param pdescrizione
     */
    public void setDescrizione(JTextField pdescrizione) {
        this.descrizione = pdescrizione;
       
      /*  val = new NotEmptyValidator(grafica, descrizione, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, descrizione, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);7*/
        // System.out.println(this.getDescrizione().getText());
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
        /*if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valNum.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }*/
        return iva;
    }

    /**
     *
     * @param piva
     */
    public void setIva(JTextField piva) {
        this.iva = piva;
       /* val = new NotEmptyValidator(grafica, iva, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valNum = new NotNumericValidator(grafica, iva, "Il campo deve essere numerico.");
        grafica.setInputVerifier(valNum);*/
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

     /*   if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valNum.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }*/
        return prezzo;
    }

    /**
     *
     * @param pprezzo
     */
    public void setPrezzo(JTextField pprezzo) {
        this.prezzo = pprezzo;
       /* val = new NotEmptyValidator(grafica, prezzo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valNum = new NotNumericValidator(grafica, prezzo, "Il campo deve essere numerico.");
        grafica.setInputVerifier(valNum);*/
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getQuantita() throws ValidatorException {
      /*  if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valMinNum.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }*/
        return quantita;
    }

    /**
     *
     * @param pquantita
     */
    public void setQuantita(JTextField pquantita) {
        this.quantita = pquantita;
      /*  val = new NotEmptyValidator(grafica, quantita, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valMinNum = new NotMinNumberValidator(grafica, quantita, "Il campo non può essere minore di 1.", 1);
        grafica.setInputVerifier(valMinNum);*/
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getTipo() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica.getTipo())) {
            throw new ValidatorException("Errore nella grafica!");
        }
     /*   if (!valApha.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }*/
        return tipo;
    }

    /**
     *
     * @param ptipo
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        val = new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
      /*  valApha = new NotAlphabeticValidator(grafica, tipo, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);*/
    }
}
