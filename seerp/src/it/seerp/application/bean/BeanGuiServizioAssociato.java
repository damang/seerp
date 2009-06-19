package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dei Servizi Associati
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiServizioAssociato {
 private JTextField quantita;
    private JTextField prezzoUnitario;
    private BeanGuiContratto contratto;
    private BeanGuiServizio servizio;
    private JTextArea note;

    public BeanGuiServizioAssociato() {
        
    }

    /**
     *
     * @param quantita
     * @param prezzoUnitario
     * @param note
     */
    public BeanGuiServizioAssociato(JTextField quantita, JTextField prezzoUnitario, JTextArea note) {
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.note = note;
    }

    /**
     * metodo che restituisce
     * @return
     */
    public BeanGuiContratto getContratto() {
        return contratto;
    }

    /**
     * metodo che
     * @param contratto
     */
    public void setContratto(BeanGuiContratto contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che restituisce
     * @return
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce
     * @return
     */
    public JTextField getPrezzoUnitario() {
        return prezzoUnitario;
    }

    /**
     * metodo che
     * @param prezzoUnitario
     */
    public void setPrezzoUnitario(JTextField prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    /**
     * metodo che restituisce
     * @return
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     * metodo che
     * @param quantita
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    /**
     * metodo che restituisce
     * @return
     */
    public BeanGuiServizio getServizio() {
        return servizio;
    }

    /**
     * metodo che setta
     * @param servizio
     */
    public void setServizio(BeanGuiServizio servizio) {
        this.servizio = servizio;
    }
}
