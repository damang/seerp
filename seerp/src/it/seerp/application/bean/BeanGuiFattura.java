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
public class BeanGuiFattura {
        private JTextField data;
    private JTextField idFattura;
    private JTextField imponibile;
    private JTextField importo;
    private JTextField iva;
    private JTextField tipo;
    private JTextArea note;

    /**
     * metodo che
     * @return
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che
     * @param data
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIdFattura() {
        return idFattura;
    }

    /**
     * metodo che
     * @param idFattura
     */
    public void setIdFattura(JTextField idFattura) {
        this.idFattura = idFattura;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getImponibile() {
        return imponibile;
    }

    /**
     * metodo che
     * @param imponibile
     */
    public void setImponibile(JTextField imponibile) {
        this.imponibile = imponibile;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getImporto() {
        return importo;
    }

    /**
     * metodo che
     * @param importo
     */
    public void setImporto(JTextField importo) {
        this.importo = importo;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIva() {
        return iva;
    }

    /**
     * metodo che
     * @param iva
     */
    public void setIva(JTextField iva) {
        this.iva = iva;
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
