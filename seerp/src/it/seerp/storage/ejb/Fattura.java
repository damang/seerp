package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

/**
 * classe gstisce le informazioni sulle fatture
 * @author Luisa-Matteo
 */
public class Fattura {

    private Date data;
    private Integer idFattura;
    private Double imponibile;
    private Double importo;
    private Double iva;
    private String tipo;
    private String note;
    private ArrayList<NotaDiCredito> listNotaDiCredito;
    private ArrayList<ServizioAssociato> listServizio;
    private Contratto contratto;

    /**
     *
     * @param data
     * @param idFattura
     * @param imponibile
     * @param importo
     * @param iva
     * @param tipo
     * @param note
     */
    public Fattura(Date data, Integer idFattura, Double imponibile, Double importo, Double iva, String tipo, String note) {
        this.data = data;
        this.idFattura = idFattura;
        this.imponibile = imponibile;
        this.importo = importo;
        this.iva = iva;
        this.tipo = tipo;
        this.note = note;
        this.listNotaDiCredito = new ArrayList<NotaDiCredito>();
        this.listServizio = new ArrayList<ServizioAssociato>();
    }

    /**
     * metodo che setta le informazioni relative al contratto associato alla fattura
     * @param contratto rappresenta le informazioni del contratto
     */
    public void setContratto(Contratto contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che setta la lista delle note di credito associate alla fattura
     * @param listNotaDiCredito rappresenta la lista delle note di credito
     */
    public void setListNotaDiCredito(ArrayList<NotaDiCredito> listNotaDiCredito) {
        this.listNotaDiCredito = listNotaDiCredito;
    }

    /**
     * metodo che resituire le informazioni relative al contratto
     * associato alla fattura
     * @return le informazioni relative al contratto
     */
    public Contratto getContratto() {
        return contratto;
    }

    /**
     * metodo che restituisce la lista delle note di credito associato alla fattura
     * @return la lista dei delle note di credito
     */
    public ArrayList<NotaDiCredito> getListNotaDiCredito() {
        return listNotaDiCredito;
    }

    /**
     * metodo che restituisce la lista delle note di credito
     * @return la lista delle note di credito
     */
    public ArrayList<NotaDiCredito> getListNote() {
        return listNotaDiCredito;
    }

    /**
     * metodo che setta la lista delle note di credito
     * @param listNote la lista delle note di credito
     */
    public void setListNote(ArrayList<NotaDiCredito> listNote) {
        this.listNotaDiCredito = listNote;
    }

    /**
     * metodo che setta la lista del servizio associati alla fattura
     * @return restituisce la lista di servizi associati alla fattura
     */
    public ArrayList<ServizioAssociato> getListServizio() {
        return listServizio;
    }

    /**
     * metodo che setta la lista del servizio associati alla fattura
     * @param listServizio la lista dei servizi associati alla fattura
     */
    public void setListServizio(ArrayList<ServizioAssociato> listServizio) {
        this.listServizio = listServizio;
    }

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
    /**
     *
     *  metodo che rimuove alla lista la nota di credito
     * @param c nota di credito da rimuovere alla lista
     */
    public void removeNotaDiCredito(NotaDiCredito c){
     listNotaDiCredito.remove(c);}
    /**
     *  metodo che aggiunge alla lista la nota di credito
     * @param c nota di credito da aggiungere alla lista
     */
    public void addNotaDiCredito(NotaDiCredito c){
     listNotaDiCredito.add(c);}
         /**
     * metodo che rimuove un servizio alla lista dei servizi
     * @param s servizio da rimuovere lista dei servizi
     */
    public void removeServzio(ServizioAssociato s) {
        listServizio.remove(s);
    }

    /**
     * metodo che aggiunge un servizio alla lista dei servizi
     * @param s servizio da aggiungere lista dei servizi
     */
    public void addServizio(ServizioAssociato s) {
        listServizio.add(s);
    }
}
