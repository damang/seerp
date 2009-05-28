/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import java.util.ArrayList;
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
    private ArrayList<BeanGuiContratto> listContratti;

    /**
     *
     */
    public BeanGuiServizio() {    }

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
    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    /**
     *
     * @param listContratti
     */
    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
    }
    /**
     *
     * @param c
     */
    public void removeContratto(BeanGuiContratto c){
     listContratti.remove(c);}
      /**
       *
       * @param c
       */
      public void addContratto(BeanGuiContratto c){
     listContratti.add(c);}


      /**
       *
       * @return
       */
      public JTextField getDescrizione() {
        return descrizione;
    }

      /**
       * 
       * @param descrizione
       */
      public void setDescrizione(JTextField descrizione) {
        this.descrizione = descrizione;
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
     */
    public JTextField getIva() {
        return iva;
    }

    /**
     *
     * @param iva
     */
    public void setIva(JTextField iva) {
        this.iva = iva;
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
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     *
     * @return
     */
    public JTextField getPrezzo() {
        return prezzo;
    }

    /**
     *
     * @param prezzo
     */
    public void setPrezzo(JTextField prezzo) {
        this.prezzo = prezzo;
    }

    /**
     *
     * @return
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     *
     * @param quantita
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    /**
     *
     * @return
     */
    public JTextField getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }

}
