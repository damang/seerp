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

    /**
     *costruttore vuoto per la classe bean gui servizio associato
     */
    public BeanGuiServizioAssociato() {
    }

    /**
     * metodo che restituisce il campo contratto del bean gui servizio associato
     * @return il campo contratto
     */
    public BeanGuiContratto getContratto() {
        return contratto;
    }

    /**
     * metodo che setta il campo contratto del bean gui servizio associato
     * @param contratto
     */
    public void setContratto(BeanGuiContratto contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che restituisce il campo note del bean gui servizio associato
     * @return il campo note
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note del bean gui servizio associato
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce il campo prezzo unitario del bean gui servizio associato
     * @return il campo prezzo unitaria
     */
    public JTextField getPrezzoUnitario() {
        return prezzoUnitario;
    }

    /**
     * metodo che setta il campo prezzo unitario del bean gui servizio
     * @param prezzoUnitario
     */
    public void setPrezzoUnitario(JTextField prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    /**
     * metodo che restituisce il campo quantità del bean gui servizio associato
     * @return il campo quantita
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     * metodo che setta il campo quantita del bean gui servizio associato
     * @param quantita
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    /**
     * metodo che restituisce il campo servizio del bean gui servizio associato
     * @return il campo servizio
     */
    public BeanGuiServizio getServizio() {
        return servizio;
    }

    /**
     * metodo che setta il campo servizio del bean gui servizio associato
     * @param servizio
     */
    public void setServizio(BeanGuiServizio servizio) {
        this.servizio = servizio;
    }
}
