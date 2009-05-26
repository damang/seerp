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
public class BeanGuiNotaDiCredito {
    private JTextField motivazione;
    private  JTextField nFattura;
    private  JTextArea note;
    private  JTextField importo;
    private  JTextField idNotaDiCredito;
    private  JTextField iva;
    private JTextField data;
    private  JTextField fattureEmesse;

    /**
     *
     * @return
     */
    public JTextField getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getFattureEmesse() {
        return fattureEmesse;
    }

    /**
     * metodo che
     * @param fattureEmesse
     */
    public void setFattureEmesse(JTextField fattureEmesse) {
        this.fattureEmesse = fattureEmesse;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIdNotaDiCredito() {
        return idNotaDiCredito;
    }

    /**
     * metodo che
     * @param idNotaDiCredito
     */
    public void setIdNotaDiCredito(JTextField idNotaDiCredito) {
        this.idNotaDiCredito = idNotaDiCredito;
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
    public JTextField getMotivazione() {
        return motivazione;
    }

    /**
     * metodo che
     * @param motivazione
     */
    public void setMotivazione(JTextField motivazione) {
        this.motivazione = motivazione;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getNFattura() {
        return nFattura;
    }

    /**
     * metodo che
     * @param nFattura
     */
    public void setNFattura(JTextField nFattura) {
        this.nFattura = nFattura;
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
}
