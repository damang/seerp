/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeansGuiServizioAssociato {
 private JTextField quantita;
    private JTextField prezzoUnitario;
    private JTextField contratto;
    private JTextField servizio;
    private JTextArea note;

    /**
     * metodo che restituisce
     * @return
     */
    public JTextField getContratto() {
        return contratto;
    }

    /**
     * metodo che
     * @param contratto
     */
    public void setContratto(JTextField contratto) {
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
    public JTextField getServizio() {
        return servizio;
    }

    /**
     * metodo che setta
     * @param servizio
     */
    public void setServizio(JTextField servizio) {
        this.servizio = servizio;
    }
}
