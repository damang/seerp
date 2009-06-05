package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeanGuiFattureRicevute {
  private JTextArea note;
    private JTextField idFatturaRicevuta;
    private JTextField numeroProgressivo;
    private JTextField ivaCredito;

    public BeanGuiFattureRicevute(JTextArea note, JTextField idFatturaRicevuta, JTextField numeroProgressivo, JTextField ivaCredito) {
        this.note = note;
        this.idFatturaRicevuta = idFatturaRicevuta;
        this.numeroProgressivo = numeroProgressivo;
        this.ivaCredito = ivaCredito;
    }

    /**
     * metodo che permette di restituire il codice identificativo di una Fattura Ricevuta
     * @return l'id della Fattura
     */
    public JTextField getIdFatturaRicevuta() {
        return idFatturaRicevuta;
    }

    /**
     * metodo che permette di settare il codice identificativo della Fattura
     * @param idFatturaRicevuta rappresenta l'id da inserire
     */
    public void setIdFatturaRicevuta(JTextField idFatturaRicevuta) {
        this.idFatturaRicevuta = idFatturaRicevuta;
    }

    /**
     * metodo che permette di restituire l'iva a credito di una Fattura
     * @return l'iva a credito della Fattura
     */
    public JTextField getIvaCredito() {
        return ivaCredito;
    }

    /**
     * metodo che permette di settare l'iva a credito di una Fattura
     * @param ivaCredito rappresenta l'iva da inserire
     */
    public void setIvaCredito(JTextField ivaCredito) {
        this.ivaCredito = ivaCredito;
    }

    /**
     * metodo che permette di restituire le note di una Fattura
     * @return le note della Fattura
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che permette di settare le note di una Fattura
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che permette di restituire il numero progressivo di una Fattura
     * @return il numero della Fattura
     */
    public JTextField getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * metodo che permette di settare il numero progressivo di una Fattura
     * @param numeroProgressivo rappresenta il numero che si vuole inserire
     */
    public void setNumeroProgressivo(JTextField numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }
}
