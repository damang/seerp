/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

/**
 *la classe gestisce le informazioni sulle fatture ricevute
 * @author Luisa
 */
public class FatturaRicevuta extends Fattura {

    private Integer idFatturaRicevuta;
    private Integer numeroProgressivo;
    private Double ivaCredito;

    public FatturaRicevuta(Date data, Integer idFattura, Double imponibile, Double importo, Double iva, String tipo, String note, ArrayList<NotaDiCredito> listNote, ArrayList<ServizioAssociato> listServizio, Integer idFatturaRicevuta, Integer numeroProgressivo, Double ivaCredito) {
        super(data, idFattura, imponibile, importo, iva, tipo, note, listNote, listServizio);
        this.idFatturaRicevuta = idFatturaRicevuta;
        this.numeroProgressivo = numeroProgressivo;
        this.ivaCredito = ivaCredito;
    }

    /**
     * cotruttore della classe FatturaRicevuta
     */
  

    /**
     * metodo che restituisce l'identificativo della fattura
     * @return idFattura l'identificativo della fattura
     */
    public Integer getIdFatturaRicevuta() {
        return idFatturaRicevuta;
    }

    /**
     * metodo che setta l'identificativo della fattura
     * @param idFatturaRicevuta l'identificativo della fattura
     */
    public void setIdFatturaRicevuta(Integer idFatturaRicevuta) {
        this.idFatturaRicevuta = idFatturaRicevuta;
    }

    /**
     *  metodo che restutisc l'iva a credito sul totale delle fatture ricevute
     * @return l'iva a credito sulle fatture
     */
    public Double getIvaDebito() {
        return ivaCredito;
    }

    /**
     * metodo che setta l'iva a credito sul totale delle fatture ricevute
     * @param iva l'iva a credito sulle fatture
     */
    public void setIvaCredito(Double iva) {
        this.ivaCredito = iva;
    }

    /**
     * metodo che restituisce il numero progressivo delle fatture
     * @return il numero progressivo della fattura
     */
    public Integer getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * metodo che setta il numero progressivo della fattura
     * @param numeroProgressivo il numero progressivo della fattura
     */
    public void setNumeroProgressivo(Integer numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }


}
