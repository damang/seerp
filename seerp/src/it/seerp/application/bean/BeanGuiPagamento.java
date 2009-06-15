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
public class BeanGuiPagamento {
        private JTextArea note;
    private JTextField dataScadenza;
      private JTextField descrizione;
    private JTextField importo;
    private JTextField modalitaPagamento;
    private JTextField stato;
    private JTextField altreInformazioni;
    private JTextField idPagamento;
    private BeanGuiContratto contratto;
    private JTextField banca;

    /**
     * 
     */
    public BeanGuiPagamento() {}

    /**
     *
     * @param note
     * @param dataScadenza
     * @param descrizione
     * @param importo
     * @param modalitaPagamento
     * @param stato
     * @param altreInformazioni
     * @param idPagamento
     * @param contratto
     * @param banca
     */
    public BeanGuiPagamento(JTextArea note, JTextField dataScadenza, JTextField descrizione, JTextField importo, JTextField modalitaPagamento, JTextField stato, JTextField altreInformazioni, JTextField idPagamento, JTextField banca) {
        this.note = note;
        this.dataScadenza = dataScadenza;
        this.descrizione = descrizione;
        this.importo = importo;
        this.modalitaPagamento = modalitaPagamento;
        this.stato = stato;
        this.altreInformazioni = altreInformazioni;
        this.idPagamento = idPagamento;
        
        this.banca = banca;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getAltreInformazioni() {
        return altreInformazioni;
    }

    /**
     * metodo che
     * @param altreInformazioni
     */
    public void setAltreInformazioni(JTextField altreInformazioni) {
        this.altreInformazioni = altreInformazioni;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getBanca() {
        return banca;
    }

    /**
     * metodo che
     * @param banca
     */
    public void setBanca(JTextField banca) {
        this.banca = banca;
    }

    /**
     * metodo che
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
     * metodo che
     * @return
     */
    public JTextField getDataScadenza() {
        return dataScadenza;
    }

    /**
     * metodo che
     * @param dataScadenza
     */
    public void setDataScadenza(JTextField dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getDescrizione() {
        return descrizione;
    }

    /**
     * metodo che
     * @param descrizione
     */
    public void setDescrizione(JTextField descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIdPagamento() {
        return idPagamento;
    }

    /**
     * metodo che
     * @param idPagamento
     */
    public void setIdPagamento(JTextField idPagamento) {
        this.idPagamento = idPagamento;
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
    public JTextField getModalitaPagamento() {
        return modalitaPagamento;
    }

    /**
     * metodo che
     * @param modalitaPagamento
     */
    public void setModalitaPagamento(JTextField modalitaPagamento) {
        this.modalitaPagamento = modalitaPagamento;
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
    public JTextField getStato() {
        return stato;
    }

    /**
     * metodo che
     * @param stato
     */
    public void setStato(JTextField stato) {
        this.stato = stato;
    }
  


}
