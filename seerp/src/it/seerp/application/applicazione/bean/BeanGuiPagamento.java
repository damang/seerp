package it.seerp.application.applicazione.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dei Pagamenti
 * @author Luisa - Tommaso Cattolico
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
     * Costruttore vuoto per la classe Bean Gui pagamento
     */
    public BeanGuiPagamento() {
    }

    /**
     * metodo che restituisce il campo altre informazioni del bean gui pagamento
     * @return il campo altre informazioni
     */
    public JTextField getAltreInformazioni() {
        return altreInformazioni;
    }

    /**
     * metodo che setta il campo altre informazioni del bean gui pagamento
     * @param altreInformazioni
     */
    public void setAltreInformazioni(JTextField altreInformazioni) {
        this.altreInformazioni = altreInformazioni;
    }

    /**
     * metodo che restituisce il campo banca del bean gui pagamento
     * @return il campo banca
     */
    public JTextField getBanca() {
        return banca;
    }

    /**
     * metodo che setta il campo banca del bean gui pagamento
     * @param banca
     */
    public void setBanca(JTextField banca) {
        this.banca = banca;
    }

    /**
     * metodo che restituisce il campo contratto del bean gui pagamento
     * @return il campo contratto
     */
    public BeanGuiContratto getContratto() {
        return contratto;
    }

    /**
     * metodo che setta il campo contratto del bean gui pagamento
     * @param contratto
     */
    public void setContratto(BeanGuiContratto contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che restituisce il campo data di scadenza del bean gui pagamento
     * @return il campo data di scadenza
     */
    public JTextField getDataScadenza() {
        return dataScadenza;
    }

    /**
     * metodo che setta il campo data di scadenza del bean gui pagamento
     * @param dataScadenza
     */
    public void setDataScadenza(JTextField dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    /**
     * metodo che restituisce il campo descrizione del bean gui pagamento
     * @return il campo pagamento
     */
    public JTextField getDescrizione() {
        return descrizione;
    }

    /**
     * metodo che setta il campo descrizione del bean gui pagamento
     * @param descrizione
     */
    public void setDescrizione(JTextField descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * metodo che restituisce il campo id del bean gui pagamento
     * @return il campo id
     */
    public JTextField getIdPagamento() {
        return idPagamento;
    }

    /**
     * metodo che setta il campo id del bean gui pagamento
     * @param idPagamento
     */
    public void setIdPagamento(JTextField idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * metodo che restituisce il campo importo del bean gui pagamento
     * @return il campo importo
     */
    public JTextField getImporto() {
        return importo;
    }

    /**
     * metodo che setta il campo importo del bean gui pagamento
     * @param importo
     */
    public void setImporto(JTextField importo) {
        this.importo = importo;
    }

    /**
     * metodo che restituisce il campo modalità di pagamento
     * @return il campo modalità di  pagamento
     */
    public JTextField getModalitaPagamento() {
        return modalitaPagamento;
    }

    /**
     * metodo che setta la modalità di pagamento del bean gui pagamento
     * @param modalitaPagamento
     */
    public void setModalitaPagamento(JTextField modalitaPagamento) {
        this.modalitaPagamento = modalitaPagamento;
    }

    /**
     * metodo che restituisce il campo note del bena gui pagamento
     * @return il campo note
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note del bean gui pagamento
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il campo stato del bean gui pagamento
     * @return il campo stato
     */
    public JTextField getStato() {
        return stato;
    }

    /**
     * metodo che setta il campo stato del bean gui pagamento
     * @param stato
     */
    public void setStato(JTextField stato) {
        this.stato = stato;
    }
}
