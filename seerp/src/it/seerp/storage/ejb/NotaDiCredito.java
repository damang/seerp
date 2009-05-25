/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;

/**
 *
 * @author Luisa
 */
public class NotaDiCredito {

    private String motivazione;
    private Integer nFattura;
    private String note;
    private Double importo;
    private Integer idNotaDiCredito;
    private Double iva;
    private Date data;
    private Integer fattureEmesse;

    /**
     * metodo che restituisce l'identificativo della fattura a cui la nota di credito è associato
     * @return identificativo della fattura a cui la nota di credito è associato
     */
    public Integer getFattureEmesse() {
        return fattureEmesse;
    }

    /**
     * metodo che setta l'identificativo della fattura a cui la nota di credito è associato
     * @param fattureEmesse identificativo della fattura a cui la nota di credito è associato
     */
    public void setFattureEmesse(Integer fattureEmesse) {
        this.fattureEmesse = fattureEmesse;
    }

    /**
     * metodo che restituisce la data della nota di credito
     * @return la data della nota di credito
     */
    public Date getData() {
        return data;
    }

    /**
     * metodo che setta la data della nota di credito
     * @param data la data della nota di credito
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *metodo che restituisce l'identificativo della nota di credito
     * @return l'identificativo della nota di credito
     */
    public Integer getIdNotaDiCredito() {
        return idNotaDiCredito;
    }

    /**
     * metodo che setta l'identificativo della nota di credito
     * @param idNotaDiCredito l'identificativo della nota di credito
     */
    public void setIdNotaDiCredito(Integer idNotaDiCredito) {
        this.idNotaDiCredito = idNotaDiCredito;
    }

    /**
     * metodo che restituisce l'importo della nota doi creito
     * @return l'importo della nota di credio
     */
    public Double getImporto() {
        return importo;
    }

    /**
     * metodo che setta l'importo della nota di credio
     * @param importo l'importo della nota di credio
     */
    public void setImporto(Double importo) {
        this.importo = importo;
    }

    /**
     * metodo che restituisce l'iva della nota di credito
     * @return l'iva della nota di credito
     */
    public Double getIva() {
        return iva;
    }

    /**
     * metodo che setta l'iva della nota di credito
     * @param iva l'iva della nota di credito
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }

    /**
     * metodo che restituisce la motivazione dell'emissione della nota di credito
     * @return motivazione la motivazione dell'emissione della nota di credito
     */
    public String getMotivazione() {
        return motivazione;
    }

    /**
     * metodo che setta la motivazione dell'emissione della nota di credito
     * @param motivazione la motivazione dell'emissione della nota di credito
     */
    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    /**
     * metodo che restituisce il numero della fattura a cui la nota di cedito fa riferimento
     * @return il numero della fattura a cui la nota di cedito fa riferimento
     */
    public Integer getNFattura() {
        return nFattura;
    }

    /**
     * metodo che setta restituisce il numero della fattura a cui la nota di cedito fa riferimento
     * @param nFattura il numero della fattura a cui la nota di cedito fa riferimento
     */
    public void setNFattura(Integer nFattura) {
        this.nFattura = nFattura;
    }

    /**
     * metodo che restituisce le note della nota di credito
     * @return le note della nota di credito
     */
    public String getNote() {
        return note;
    }

    /**
     * metodo che  setta le note della nota di credito
     * @param note le note della nota di credito
     */
    public void setNote(String note) {
        this.note = note;
    }
}
