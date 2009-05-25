package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa
 */
public class BeanGuiFatturaEmessa {
private JTextArea note;
    private JTextField idFatturaEmessa;
    private JTextField numeroProgressivo;
    private JTextField ivaDebito;
    private JTextField tipo;

    /**
     * metodo che
     * @return
     */
    public JTextField getIdFatturaEmessa() {
        return idFatturaEmessa;
    }

    /**
     * metodo che
     * @param idFatturaEmessa
     */
    public void setIdFatturaEmessa(JTextField idFatturaEmessa) {
        this.idFatturaEmessa = idFatturaEmessa;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIvaDebito() {
        return ivaDebito;
    }

    /**
     * metodo che
     * @param ivaDebito
     */
    public void setIvaDebito(JTextField ivaDebito) {
        this.ivaDebito = ivaDebito;
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

    /**
     * metodo che
     * @return
     */
    public JTextField getTipo() {
        return tipo;
    }

    /**
     * metodo che
     * @param tipo
     */
    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }
}
