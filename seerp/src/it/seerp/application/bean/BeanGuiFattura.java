package it.seerp.application.bean;

import java.util.ArrayList;
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
      private ArrayList<BeanGuiNotaDiCredito> listNotaDiCredito;

      /**
       * Costruttore per la classe Bean Gui Fattura
       * @param data
       * @param idFattura
       * @param imponibile
       * @param importo
       * @param iva
       * @param tipo
       * @param note
       * @param listNotaDiCredito
       * @param listServizio
       */

      public BeanGuiFattura(JTextField data, JTextField idFattura, JTextField imponibile, JTextField importo, JTextField iva, JTextField tipo, JTextArea note, ArrayList<BeanGuiNotaDiCredito> listNotaDiCredito, ArrayList<BeanGuiServizioAssociato> listServizio) {
        this.data = data;
        this.idFattura = idFattura;
        this.imponibile = imponibile;
        this.importo = importo;
        this.iva = iva;
        this.tipo = tipo;
        this.note = note;
        this.listNotaDiCredito = listNotaDiCredito;
        this.listServizio = listServizio;
    }
    private ArrayList<BeanGuiServizioAssociato> listServizio;

    /**
     * metodo che restituisce il campo contenente la data della Fattura
     * @return il campo data della Fattura
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che setta il campo data della Fattura
     * @param data rappresenta il campo data da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che restituisce il campo contenente l'id della Fattura
     * @return il campo id della Fattura
     */
    public JTextField getIdFattura() {
        return idFattura;
    }

    /**
     * metodo che setta il campo id della Fattura
     * @param idFattura rappresenta il campo id da inserire
     */
    public void setIdFattura(JTextField idFattura) {
        this.idFattura = idFattura;
    }

    /**
     * metodo che restituisce il campo contenente l'imponibile della Fattura
     * @return il campo imponibile della Fattura
     */
    public JTextField getImponibile() {
        return imponibile;
    }

    /**
     * metodo che setta il campo imponibile della Fattura
     * @param imponibile rappresenta il campo imponibile da inserire
     */
    public void setImponibile(JTextField imponibile) {
        this.imponibile = imponibile;
    }

    /**
     * metodo che restituisce il campo contenente l'importo della Fattura
     * @return il campo importo della Fattura
     */
    public JTextField getImporto() {
        return importo;
    }

    /**
     * metodo che setta il campo importo della Fattura
     * @param importo rappresenta il campo importo da inserire
     */
    public void setImporto(JTextField importo) {
        this.importo = importo;
    }

    /**
     * metodo che restituisce il campo contenente la partita iva della Fattura
     * @return il campo iva della Fattura
     */
    public JTextField getIva() {
        return iva;
    }

    /**
     * metodo che setta il campo iva delle Fattura
     * @param iva rappresenta il campo iva da inserire
     */
    public void setIva(JTextField iva) {
        this.iva = iva;
    }

    /**
     * metodo che restituisce il campo contenente le note della Fattura
     * @return il campo note della Fattura
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note di una Fattura
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il campo contenente il tipo di Fattura
     * @return il campo tipo di Fattura
     */
    public JTextField getTipo() {
        return tipo;
    }

    /**
     * metodo che setta il campo tipo di Fattura
     * @param tipo rappresenta il campo tipo da inserire
     */
    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }
    /**
     * metodo che rimuove un servizio dalla lista dei serzivi associati ad una Fattura
     * @param c rappresenta il servizio da rimuovere
     */
    public void removeServizio(BeanGuiServizioAssociato c){
     listServizio.remove(c);}
    /**
     * metodo che inserisce un servizio nella lista dei serzivi associati ad una Fattura
     * @param c rappresenta il servizio da inserire
     */
    public void addServizio(BeanGuiServizioAssociato c){
     listServizio.add(c);}
}
