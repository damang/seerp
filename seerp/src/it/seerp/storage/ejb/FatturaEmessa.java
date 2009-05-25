/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

/**
 * classe che gestisce le informazioni su una fattura emessa
 * @author Luisa
 */
public class FatturaEmessa extends Fattura {

    private String note;
    private Integer idFatturaEmessa;
    private Integer numeroProgressivo;
    private Double ivaDebito;
    private String tipo;

    /**
     * cotruttore della classe FatturaEmessa
     */
    public FatturaEmessa() {
        super();
    }

    /**
     * metodo che restituisce l'identificativo della fattura
     * @return l'identificativo della fattura
     */
    public Integer getIdFatturaEmessa() {
        return idFatturaEmessa;
    }

    /**
     * metodo che setta l'identificativo della fattura
     * @param idFatturaEmessa l'identificativo della fattura
     */
    public void setIdFatturaEmessa(Integer idFatturaEmessa) {
        this.idFatturaEmessa = idFatturaEmessa;
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

    /**
     * metodo che  restutisc l'iva a debito dul totale delle fatture ricevute
     * @return l'iva a debito sulle fatture
     */
    public Double getIvaDebito() {
        return ivaDebito;
    }

    /**
     * metodo che setta l'iva a credito sulle fatture
     * @param iva l'iva a debito sulle fatture
     */
    public void setIvaDebito(Double iva) {
        this.ivaDebito = iva;
    }

    /**
     * metodo che  restituisce il numero progressivo delle fatture
     * @return numeroProgressivo numero progressivo della fattura
     */
    public Integer getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * metodo che  setta il numero progressivo della fattura
     * @param numeroProgressivo numero progressivo della fattura
     */
    public void setNumeroProgressivo(Integer numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    /**

    /**
     *  metodo che restituisce le note dell'azienda
     * @return le note dell'azienda
     */
    public String getNote() {
        return note;
    }

    /**
     * metodo che setta le note dell'azienda
     * @param note le note dell'azienda
     */
    public void setNote(String note) {
        this.note = note;
    }
}
