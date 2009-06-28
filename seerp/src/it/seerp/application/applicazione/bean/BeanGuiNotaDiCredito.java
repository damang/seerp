package it.seerp.application.applicazione.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione delle Note di Credito
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiNotaDiCredito {

    private JTextField motivazione;
    private JTextField nFattura;
    private JTextArea note;
    private JTextField importo;
    private JTextField idNotaDiCredito;
    private JTextField iva;
    private JTextField data;
    private JTextField fattureEmesse;

    /**
     * metodo che permette di restituire il campo data della Nota di Credito
     * @return il campo data
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che permette di settare il campo data della Nota di Credito
     * @param data rappresenta il campo data da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che permette di restituire il campo fatture emesse della Nota di Credito
     * @return il campo fatture emesse
     */
    public JTextField getFattureEmesse() {
        return fattureEmesse;
    }

    /**
     * metodo che permette di settare il campo fatture emesse della Nota di Credito
     * @param fattureEmesse rappresenta il campo da inserire
     */
    public void setFattureEmesse(JTextField fattureEmesse) {
        this.fattureEmesse = fattureEmesse;
    }

    /**
     * metodo che permette di restituire il campo identificativo della Nota di Credito
     * @return il campo id della Nota di Credito
     */
    public JTextField getIdNotaDiCredito() {
        return idNotaDiCredito;
    }

    /**
     * metodo che permette di settare il campo identificativo dell Nota di Credito
     * @param idNotaDiCredito rappresenta il campo id da inserire
     */
    public void setIdNotaDiCredito(JTextField idNotaDiCredito) {
        this.idNotaDiCredito = idNotaDiCredito;
    }

    /**
     * metodo che permette di restituire il campo importo della Nota di Credito
     * @return il campo importo
     */
    public JTextField getImporto() {
        return importo;
    }

    /**
     * metodo che permette di settare il campo importo della Nota di Credito
     * @param importo rappresenta il campo importo da inserire
     */
    public void setImporto(JTextField importo) {
        this.importo = importo;
    }

    /**
     * metodo che permette di resituire il campo iva della Nota di Credito
     * @return il campo iva
     */
    public JTextField getIva() {
        return iva;
    }

    /**
     * metodo che permette di settare il campo iva della Nota di Credito
     * @param iva rappresenta il campo iva da inserire
     */
    public void setIva(JTextField iva) {
        this.iva = iva;
    }

    /**
     * metodo che permette di restituire il campo motivazionde della Nota di Credito
     * @return il campo motivazione
     */
    public JTextField getMotivazione() {
        return motivazione;
    }

    /**
     * metodo che permette di settare il campo motivazione della Nota di Credito
     * @param motivazione rappresenta il campo motivazione da inserire
     */
    public void setMotivazione(JTextField motivazione) {
        this.motivazione = motivazione;
    }

    /**
     * metodo che permette di restituire il campo numero fattura della Nota di Credito
     * @return il campo numero fattura
     */
    public JTextField getNFattura() {
        return nFattura;
    }

    /**
     * metodo che permette di settare il campo numero fattura della Nota di Credito
     * @param nFattura rappresenta il campo da inserire
     */
    public void setNFattura(JTextField nFattura) {
        this.nFattura = nFattura;
    }

    /**
     * metodo che permette di settare il campo note della Nota di Credito
     * @return il campo note
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che permette di settare il campo note della Nota di Credito
     * @param note rappresenta il campo da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }
}
