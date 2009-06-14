
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che si occupa di gestire le informazioni sui servizi
 * @author Luisa-Matteo
 */
public class Servizio {

    private Integer idServizio;
    private String descrizione;
    private Boolean disponibilita;
    private Integer quantita;
    private String tipo;
    private Double prezzo;
    private Integer iva;
    private String note;
    private ArrayList<ServizioAssociato> listServiAssociati;


    /**
     * costruttore vuoto
     */
    public Servizio()
   {}

    /**
     *
     * @param idServizio
     * @param descrizione
     * @param disponibilita
     * @param quantita
     * @param tipo
     * @param prezzo
     * @param iva
     * @param note
     */
    public Servizio(Integer idServizio, String descrizione, Boolean disponibilita, Integer quantita, String tipo, Double prezzo, Integer iva, String note) {
        this.idServizio = idServizio;
        this.descrizione = descrizione;
        this.disponibilita = disponibilita;
        this.quantita = quantita;
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.iva = iva;
        this.note = note;
        this.listServiAssociati =new ArrayList<ServizioAssociato>();
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
     */
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

    /**
     *  metodo che restituisce la lista dei servizi associati al contratto
     * @return la lista dei servizi associati al contratto
     */
    public ArrayList<ServizioAssociato> getListServiziAssociati() {
        return listServiAssociati;
    }

    /**
     *  metodo che setta la lista dei servizi associati al contratto
     * @param listSA
     */
    public void setListServiziAssociati(ArrayList<ServizioAssociato> listSA) {
        this.listServiAssociati = listSA;
    }

    /**
     * metodo che permette di rimuovere un servizio associato dalla lista
     * @param c rappresenta il servizio associato da rimuovere
     */
    public void removeServizioAssociato(ServizioAssociato c) {
        listServiAssociati.remove(c);
    }

    /**
     * metodo che permette di aggiungere un servizio associato dalla lista
     * @param c rappresenta il servizio associato da inserire
     */
    public void addServizioAssociato(ServizioAssociato c) {
        listServiAssociati.add(c);
    }

    /**
     *
     * @return
     */
    public Integer getIdServizio() {
        return idServizio;
    }

    /**
     * 
     * @param idServizio
     */
    public void setIdServizio(Integer idServizio) {
        this.idServizio = idServizio;
    }


}
