/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;

/**
 * classe gstisce le informazioni sulle fatture
 * @author Luisa
 */
public class Fattura {

    private Date data;
    private Integer idFattura;
    private Double imponibile;
    private Double importo;
    private Double iva;
    private String tipo;
    private String note;

    /**
     * metodo che restituisce le note della fattura
     * @return le note della fattura
     */
    public String getNote() {
        return note;
    }

    /**
     * setta le note le note della fattura
     * @param note le note della fattura
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * metodo che restituisce la data della fattura
     * @return la data della fattura
     */
    public Date getData() {
        return data;
    }

    /**
     * metodo che setta la data della fattura
     * @param data la data della fattura
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * metodo che restituisce l'identificativo della fattura
     * @return idFattura l'identificativo della fattura
     */
    public Integer getIdFattura() {
        return idFattura;
    }

    /**
     * metodo che setta l'identificativo della fattura
     * @param idFattura l'identificativo della fattura
     */
    public void setIdFattura(Integer idFattura) {
        this.idFattura = idFattura;
    }

    /**
     * metodo che restituisce l'imponibile della fattura
     * @return imponibile l'imponibile della fattura
     */
    public Double getImponibile() {
        return imponibile;
    }

    /**
     * metodo che setta l'imponibile della fattura
     * @param imponibile l'imponibile della fattura
     */
    public void setImponibile(Double imponibile) {
        this.imponibile = imponibile;
    }

    /**
     * metodo che restituisce l'importo della Fattura
     * @return l'importo della fattura
     */
    public Double getImporto() {
        return importo;
    }

    /**
     * metodo che setta l'importo della fattura
     * @param importo l'importo della fattura
     */
    public void setImporto(Double importo) {
        this.importo = importo;
    }

    /**
     * metodo che restituisce l'iva della fattura
     * @return l'iva della fattura
     */
    public Double getIva() {
        return iva;
    }

    /**
     * metodo che setta l'iva della fattura
     * @param iva l'iva della fattura
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }

    /**
     * metodo che restituisce il tipo della fattura
     * @return il tipo della fattura
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo che setta il tipo della fattura
     * @param tipo il tipo della fattura
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
