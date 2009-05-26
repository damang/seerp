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
public class BeanGuiServizio {
    private JTextField descrizione;
    private JTextField disponibilita;
    private JTextField quantita;
    private JTextField tipo;
    private JTextField prezzo;
    private JTextField idServizio;
    private JTextField iva;
    private JTextArea note;

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

    public JTextField getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(JTextField descrizione) {
        this.descrizione = descrizione;
    }

    public JTextField getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(JTextField disponibilita) {
        this.disponibilita = disponibilita;
    }

    public JTextField getIdServizio() {
        return idServizio;
    }

    public void setIdServizio(JTextField idServizio) {
        this.idServizio = idServizio;
    }

    public JTextField getIva() {
        return iva;
    }

    public void setIva(JTextField iva) {
        this.iva = iva;
    }

    public JTextArea getNote() {
        return note;
    }

    public void setNote(JTextArea note) {
        this.note = note;
    }

    public JTextField getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(JTextField prezzo) {
        this.prezzo = prezzo;
    }

    public JTextField getQuantita() {
        return quantita;
    }

    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    public JTextField getTipo() {
        return tipo;
    }

    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }

}
