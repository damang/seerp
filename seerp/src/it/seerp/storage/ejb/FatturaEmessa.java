/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

/**
 * classe che gestisce le informazioni su una fattura emessa
 * @author Luisa
 */
public class FatturaEmessa extends Fattura {

    private Integer idFatturaEmessa;
    private Integer numeroProgressivo;
    private Double ivaDebito;
    private String tipoFatt;
    private ArrayList<DDT> listDDT;

    public FatturaEmessa(Date data, Integer idFattura, Double imponibile, Double importo, Double iva, String tipoFat, String note, ArrayList<NotaDiCredito> listNote, ArrayList<ServizioAssociato> listServizio, Integer idFatturaEmessa, Integer numeroProgressivo, Double ivaDebito, String tipo, ArrayList<DDT> listDDT) {
        super(data, idFattura, imponibile, importo, iva, tipo, note, listNote, listServizio);
        this.idFatturaEmessa = idFatturaEmessa;
        this.numeroProgressivo = numeroProgressivo;
        this.ivaDebito = ivaDebito;
        this.tipoFatt = tipoFat;
        this.listDDT = listDDT;
    }

    public ArrayList<DDT> getListDDT() {
        return listDDT;
    }

    public void setListDDT(ArrayList<DDT> listDDT) {
        this.listDDT = listDDT;
    }

    /**
     * cotruttore della classe FatturaEmessa
     */
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
        return tipoFatt;
    }

    /**
     * metodo che setta il tipo della fattura
     * @param tipo il tipo della fattura
     */
    public void setTipo(String tipo) {
        this.tipoFatt = tipo;
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
      public void removeDDT(DDT c){
     listDDT.remove(c);}
    public void addDDT(DDT c){
     listDDT.add(c);}

}
