/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che si occupa di gestire le informazioni sui servizi
 * @author Luisa
 */
public class Servizio {

    private String descrizione;
    private Boolean disponibilita;
    private Integer quantita;
    private String tipo;
    private Double prezzo;
    private Integer idServizio;
    private Integer iva;
    private String note;
    private ArrayList<Contratto> listContratti;

    public Servizio(String descrizione, Boolean disponibilita, Integer quantita, String tipo, Double prezzo, Integer idServizio, Integer iva, String note, ArrayList<Contratto> listContratti) {
        this.descrizione = descrizione;
        this.disponibilita = disponibilita;
        this.quantita = quantita;
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.idServizio = idServizio;
        this.iva = iva;
        this.note = note;
        this.listContratti = listContratti;
    }



    public ArrayList<Contratto> getListServizio() {
        return  listContratti;
    }

    public void setListServizio(ArrayList<Contratto> listServizio) {
        this. listContratti = listServizio;
    }



    /**
     *  metodo che restituisce le note dell'evento
     * @return le note del servizio
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note del servizio
     * @param note le note del servizio
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce l'identificativo del servizio
     * @return l'identificativo del servizio
     */
    public Integer getIdServizio() {
        return idServizio;
    }

    /**
     *  metodo che setta l'identificativo del servizio
     * @param idServizio l'identificativo del servizio
     */
    public void setIdServizio(Integer idServizio) {
        this.idServizio = idServizio;
    }

    /**
     *  metodo che restituisce la descrizone di un servizio
     * @return la descrizione del servizio
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     *   metodo che setta la descrizione del servizio
     * @param descrizione la descrizione del servizio
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * metodo che restituisce la disponibilità del servizio
     * @return la disponibilità del servizio
     */
    public Boolean getDisponibilita() {
        return disponibilita;
    }

    /**
     *  metodo che setta la disponibilità del servizio
     * @param disponibilita la disponibilità del servizio
     */
    public void setDisponibilita(Boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    /**
     * metodo che  restituisce l'aliquota iva sul prezzo del servizio
     * @return iva l'aliquota iva del servizio
     */
    public Integer getIva() {
        return iva;
    }

    /**
     * metodo che  setta l'aliquota iva del servizio
     * @param iva l'aliquota iva del servizio
     */
    public void setIva(Integer iva) {
        this.iva = iva;
    }

    /**
     * metodo che restituisce il prezzo del servizio
     * @return il prezzo del servizio
     */
    public Double getPrezzo() {
        return prezzo;
    }

    /**
     * metodo che setta il prezzo del servizio
     * @param prezzo il prezzo del servizio
     */
    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * metodo che restituisce la quantità del servizio
     * @return la quantità del servizio
    public Integer getQuantita() {
    return quantita;
    }

    /**
     *  metodo che setta la quantità del servizio
     * @param quantita la quantità del servizio
     */
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    /**
     *  metodo che restituisce il tipo del servizio
     * @return il tipo del servizio
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *  metodo che setta il tipo del servizio
     * @param tipo il tipo del servizio
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     public void removeContratto(Contratto c){
     listContratti.remove(c);}
    public void addContratto(Contratto c){
     listContratti.add(c);}
}
