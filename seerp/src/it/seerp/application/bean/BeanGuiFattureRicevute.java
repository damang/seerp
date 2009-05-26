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
public class BeanGuiFattureRicevute {
  private JTextArea note;
    private JTextField idFatturaRicevuta;
    private JTextField numeroProgressivo;
    private JTextField ivaCredito;

    /**
     * metodo che
     * @return
     */
    public JTextField getIdFatturaRicevuta() {
        return idFatturaRicevuta;
    }

    /**
     * metodo che
     * @param idFatturaRicevuta
     */
    public void setIdFatturaRicevuta(JTextField idFatturaRicevuta) {
        this.idFatturaRicevuta = idFatturaRicevuta;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIvaCredito() {
        return ivaCredito;
    }

    /**
     * metodo che
     * @param ivaCredito
     */
    public void setIvaCredito(JTextField ivaCredito) {
        this.ivaCredito = ivaCredito;
    }

    /**
     * metodo che
     * @return
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * metodo che
     * @param numeroProgressivo
     */
    public void setNumeroProgressivo(JTextField numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }
}
