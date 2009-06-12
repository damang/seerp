
package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

/**
 * classe che gestisce le informazioni su una fattura emessa
 * @author Luisa-Matteo
 */
public class FatturaEmessa extends Fattura {

    private Integer idFatturaEmessa;
    private Integer numeroProgressivo;
    private Double ivaDebito;
    private String tipoFatt;
    private ArrayList<DDT> listDDT;
    private ArrayList<NotaDiCredito> listNC;

    /**
     * costruttore per la classe FatturaEmessa
     * @param data
     * @param idFattura
     * @param imponibile
     * @param importo
     * @param iva
     * @param tipoFat
     * @param note
     * @param idFatturaEmessa
     * @param numeroProgressivo
     * @param ivaDebito
     * @param tipo
     */
    public FatturaEmessa(Date data, Integer idFattura, Double imponibile, Double importo, Double iva, String tipoFat, String note, Integer idFatturaEmessa, Integer numeroProgressivo, Double ivaDebito, String tipo) {
        super(data, idFattura, imponibile, importo, iva, tipo, note);
        this.idFatturaEmessa = idFatturaEmessa;
        this.numeroProgressivo = numeroProgressivo;
        this.ivaDebito = ivaDebito;
        this.tipoFatt = tipoFat;
        this.listDDT = new ArrayList<DDT>();
        this.listNC = new ArrayList<NotaDiCredito>();
    }

    /**
     * metodo che setta la lista delle note di credito associato alla fattura emessa
     * @param listNC rappresenta la lista delle note di credito
     */
    public void setListNC(ArrayList<NotaDiCredito> listNC) {
        this.listNC = listNC;
    }

    /**
     * metodo che setta il tipo di fattura emessa
     * @param tipoFatt rappresenta il tipo di fattura
     */
    public void setTipoFatt(String tipoFatt) {
        this.tipoFatt = tipoFatt;
    }

    /**
     * metodo che restituisce la lista delle note di credito della fattura emessa
     * @return la lista delle note di credito
     */
    public ArrayList<NotaDiCredito> getListNC() {
        return listNC;
    }

    /**
     * metodo che restituisce il tipo di fattura
     * @return il tipo di fattura
     */
    public String getTipoFatt() {
        return tipoFatt;
    }

    /**
     * restituisce la lista dei DDT associati alla fattura
     * @return la lista dei DDT associati alla fattura
     */
    public ArrayList<DDT> getListDDT() {
        return listDDT;
    }

    /**
      * restituisce la lista dei DDT associati alla fattura
     * @param listDDT DDT associati alla fattura
     */
    public void setListDDT(ArrayList<DDT> listDDT) {
        this.listDDT = listDDT;
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

    /**
     *  metodo che rimuove un DDT alla lista
     * @param c DDT da  rimuovere dall lista
     */
    public void removeDDT(DDT c) {
        listDDT.remove(c);
    }

    /**
     *  metodo che aggiunge un DDT alla lista
     * @param c DDT da aggiungere dall lista
     */
    public void addDDT(DDT c) {

        listDDT.add(c);
    }
}
