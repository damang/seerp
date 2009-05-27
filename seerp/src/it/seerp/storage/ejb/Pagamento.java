/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;

/**
 * classe che gestisce le informazioni sui pagamenti
 * @author Luisa
 */
public class Pagamento {

    private String note;
    private Date dataScadenza;
    private String descrizione;
    private Double importo;
    private String modalitaPagamento;
    private String stato;
    private String altreInformazioni;
    private Integer idPagamento;
    private Integer contratto;
    private Integer banca;

    public Pagamento(String note, Date dataScadenza, String descrizione, Double importo, String modalitaPagamento, String stato, String altreInformazioni, Integer idPagamento, Integer contratto, Integer banca) {
        this.note = note;
        this.dataScadenza = dataScadenza;
        this.descrizione = descrizione;
        this.importo = importo;
        this.modalitaPagamento = modalitaPagamento;
        this.stato = stato;
        this.altreInformazioni = altreInformazioni;
        this.idPagamento = idPagamento;
        this.contratto = contratto;
        this.banca = banca;
    }

    /**
     * metodo che restituisce l'identificativo della banca a cui quel pagamento è asosciato
     * @return l'identificativo della banca a cui quel pagamento è asosciato
     */
    public Integer getBanca() {
        return banca;
    }

    /**
     *  metodo che setta l'identificativo della banca a cui quel pagamento è asosciato
     * @param banca l'identificativo della banca a cui quel pagamento è asosciato
     */
    public void setBanca(Integer banca) {
        this.banca = banca;
    }

    /**
     *  metodo che restituisce l'identificativo del contratto a cui quel pagamento è asosciato
     * @return l'identificativo del contratto a cui quel pagamento è asosciato
     */
    public Integer getContratto() {
        return contratto;
    }

    /**
     * metodo che setta l'identificativo del contratto a cui quel pagamento è asosciato
     * @param contratto l'identificativo del contratto a cui quel pagamento è asosciato
     */
    public void setContratto(Integer contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che restituisce informazioni aggiuntive sul pagamento
     * @return altreInformazioni informazioni aggiuntive sul pagamento
     */
    public String getAltreInformazioni() {
        return altreInformazioni;
    }

    /**
     *  metodo che  setta informazioni aggiuntive sul pagamento
     * @param altreInformazioni informazioni aggiuntive sul pagamento
     */
    public void setAltreInformazioni(String altreInformazioni) {
        this.altreInformazioni = altreInformazioni;
    }

    /**
     *  metodo che restituisce la scadenza del pagamento
     * @return dataScadenza la data di scadenza del pagamento
     */
    public Date getDataScadenza() {
        return dataScadenza;
    }

    /**
     *  metodo che setta la data di scadenza del pagamento
     * @param dataScadenza la data di scadenza del pagamento
     */
    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    /**
     *  metodo che restituisce la descrizione del pagamento
     * @return la descrizione del pagamento
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     *  metodo che setta la descrizione del pagamento
     * @param descrizione la descrizione del pagamento
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     *  metodo che restituisce l'identificativo del pagamento
     * @return l'identifiativo del pagamento
     */
    public Integer getIdPagamento() {
        return idPagamento;
    }

    /**
     *  metodo che setta l'identifiativo del pagamento
     * @param idPagamento l'identifiativo del pagamento
     */
    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     *  metodo che restituisce l'importo del pagamento
     * @return l'importo del pagamento
     */
    public Double getImporto() {
        return importo;
    }

    /**
     *  metodo che setta l'importo del pagamento
     * @param importo l'importo del pagamento
     */
    public void setImporto(Double importo) {
        this.importo = importo;
    }

    /**
     *  metodo che restituisce la modalità di pagamento
     * @return la modalità di pagamento
     */
    public String getModalitaPagamento() {
        return modalitaPagamento;
    }

    /**
     *  metodo che setta la modalità di pagamento
     * @param modalitàPagamento la modalità di pagamento
     */
    public void setModalitaPagamento(String modalitàPagamento) {
        this.modalitaPagamento = modalitàPagamento;
    }

    /**
     *  metodo che restituisce lo stao di un pagamento
     * @return lo stato di un pagamento
     */
    public String getStato() {
        return stato;
    }

    /**
     *  metodo che setta lo stato di un pagamento
     * @param stato lo stato di un pagamento
     */
    public void setStato(String stato) {
        this.stato = stato;
    }

    /**
     *  metodo che restituisce le note di un pagamento
     * @return le note di un pagamento
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note di un pagamento
     * @param note le note di un pagamento
     */
    public void setNote(String note) {
        this.note = note;
    }
}
