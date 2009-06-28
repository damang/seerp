package it.seerp.application.applicazione.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dell'Appuntamento
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiAppuntamento {

    private JTextField data;
    private JTextField ora;
    private JTextField idAppuntamento;
    private JTextArea note;
    private BeanGuiDipendente dipendente;
    private BeanGuiExtraAzienda extraAzienda;
    private JTextField notifica;

    /**
     * Metodo che restituisce il campo contenente il messaggio di notifica dell'appuntamento
     * @return la notifica dell'appuntamento
     */
    public JTextField getNotifica() {
        return notifica;
    }

    /**
     * Metodo che setta il campo contenente messaggio di notifica dell'appuntamento
     * @param notifica rappresenta il messaggio di notifica da inserire
     */
    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }

    /**
     * Metodo che restituisce il campo contenente la data dell'appuntamento
     * @return la data dell'appuntamento
     */
    public JTextField getData() {
        return data;
    }

    /**
     * Metodo che restituisce il Dipendente associato all'Appuntamento
     * @return Bean Gui del Dipendente
     */
    public BeanGuiDipendente getDipendente() {
        return dipendente;
    }

    /**
     * Metodo che restituisce l'ExtraAzienda associato all'Appuntamento
     * @return Bean Gui dell' Extra Azienda
     */
    public BeanGuiExtraAzienda getExtraAzienda() {
        return extraAzienda;
    }

    /**
     * Metodo che restituisce il campo contenente l'identificativo dell'Appuntamento
     * @return l'ID dell'Appuntamento
     */
    public JTextField getIdAppuntamento() {
        return idAppuntamento;
    }

    /**
     * Metodo che restituisce il campo contenente le note
     * @return le note dell'Appuntamento
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * Metodo che restituisce il campo contenente l'ora dell'Appuntamento
     * @return l'ora dell'Appuntamento
     */
    public JTextField getOra() {
        return ora;
    }

    /**
     * Metodo che restuisce il campo contenente la data dell'Appuntamento
     * @param data la data dell'Appuntamento da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * Metodo che setta il Dipendente associato all'Appuntamento
     * @param dipendente Bean Gui del Dipendente
     */
    public void setDipendente(BeanGuiDipendente dipendente) {
        this.dipendente = dipendente;
    }

    /**
     * Metodo che setta l'Extra Azienda associato all'Appuntamento
     * @param extraAzienda Bean Gui dell'Extra Azienda
     */
    public void setExtraAzienda(BeanGuiExtraAzienda extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    /**
     * Metodo che setta il campo contenente l'id dell'Appuntamento
     * @param idAppuntamento rappresenta il campo id dell'Appuntamento da inserire
     */
    public void setIdAppuntamento(JTextField idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }

    /**
     * Metodo che setta il campo contenente le note
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * Metodo che setta il campo contenente l'ora dell'Appuntamento
     * @param ora rappresenta il campo ora da inserire
     */
    public void setOra(JTextField ora) {
        this.ora = ora;
    }
}
