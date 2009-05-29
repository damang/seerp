package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiAppuntamento {

    private JTextField data;
    private JTextField ora;
    private JTextField idAppuntamento;
    private JTextArea note;
    private JTextField dipendente;

    private JTextField extraAzienda;
     private JTextField notifica;

     /**
      * Costruttore vuoto per la classe Bean Gui Appuntamento
      */
     public BeanGuiAppuntamento() {
        
    }

 

     /**
      * Costruttore per la Classe Bean Gui Appuntamento
      * @param data
      * @param ora
      * @param idAppuntamento
      * @param note
      * @param dipendente
      * @param extraAzienda
      * @param notifica
      */
     public BeanGuiAppuntamento(JTextField data, JTextField ora, JTextField idAppuntamento, JTextArea note, JTextField dipendente, JTextField extraAzienda,JTextField notifica) {
        this.data = data;
        this.ora = ora;
        this.idAppuntamento = idAppuntamento;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
        this.notifica=notifica;
    }

     /**
      * metodo che restituisce il campo contenente il messaggio di notifica dell'appuntamento
      * @return la notifica dell'appuntamento
      */
     public JTextField getNotifica() {
        return notifica;
    }

       /**
        * metodo che setta il campo contenente messaggio di notifica dell'appuntamento
        * @param notifica rappresenta il messaggio di notifica da inserire
        */
       public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }


    /**
     * metodo che restituisce il campo contenente la data dell'appuntamento
     * @return la data dell'appuntamento
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che restituisce il campo contenente l'identificatico del dipente
     * @return l'id del dipendente
     */
    public JTextField getDipendente() {
        return dipendente;
    }

    /**
     * metodo che restituisce il campo contenente l'identificativo dell'ExtraAzienda
     * @return l'id dell'ExtraAzienda
     */
    public JTextField getExtraAzienda() {
        return extraAzienda;
    }

    /**
     *  metodo che restituisce il campo contenente l'identificativo dell'Appuntamento
     * @return l'id dell'Appuntamento
     */
    public JTextField getIdAppuntamento() {
        return idAppuntamento;
    }

    /**
     * metodo che restituisce il campo contenente le note
     * @return le note dell'Appuntamento
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che restituisce il campo contenente l'ora dell'Appuntamento
     * @return l'ora dell'Appuntamento
     */
    public JTextField getOra() {
        return ora;
    }

    /**
     * metodo che restuisce il campo contenente la data dell'Appuntamento
     * @param data la data dell'Appuntamento da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che setta il campo contenente l'id del Dipendente
     * @param dipendente rappresenta il campo id del Dipendente da inserire
     */
    public void setDipendente(JTextField dipendente) {
        this.dipendente = dipendente;
    }

    /**
     * metodo che setta il campo contentente l'id dell'ExtraAzienda
     * @param extraAzienda rappresenta il campo id dell'ExtraAzienda da inserire
     */
    public void setExtraAzienda(JTextField extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    /**
     * metodo che setta il campo contenente l'id dell'Appuntamento
     * @param idAppuntamento rappresenta il campo id dell'Appuntamento da inserire
     */
    public void setIdAppuntamento(JTextField idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }

    /**
     *  metodo che setta il campo contenente le note
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     *  metodo che setta il campo contenente l'ora dell'Appuntamento
     * @param ora rappresenta il campo ora da inserire
     */
    public void setOra(JTextField ora) {
        this.ora = ora;
    }



}
