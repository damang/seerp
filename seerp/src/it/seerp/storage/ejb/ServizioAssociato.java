
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * la classe gestisce le informazioni
 * @author Luisa
 */
public class ServizioAssociato {

    private Integer quantita;
    private Double prezzoUnitario;
    private Contratto contratto;
    private Servizio servizio;
    private String note;
    ArrayList<ServizioAssociatoFattura> listServizioAssociatoFattura;

    /**
     *
     */
    public ServizioAssociato() {
        
    }
    

    /**
     * costruttore
     * @param quantita
     * @param prezzoUnitario
     * @param note
     */
    public ServizioAssociato(Integer quantita, Double prezzoUnitario, String note) {
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.note = note;
        this.listServizioAssociatoFattura= new ArrayList<ServizioAssociatoFattura>();


    }

    /**
     *  metodo che restituisce le note del servizio associato
     * @return note le note del servizio associato
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note del servizio associato
     * @param note le note del servizio associato
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce le informazioni del contratto a cui determinati servizi sono associati
     * @return le informazioni del contratto a cui determinati servizi sono associati
     */
    public Contratto getContratto() {
        return contratto;
    }

    /**
     * metodo che setta le informazioni del contratto a cui determinati servizi sono associati
     * @param contratto le informazioni del contratto a cui determinati servizi sono associati
     */
    public void setContratto(Contratto contratto) {
        this.contratto = contratto;
    }

    /**
     *  metodo che le informazioni di un servizio relazionatia ad un determinato contratto
     * @return le informazioni di un servizio relazionatia ad un determinato contratto
     */
    public Servizio getServizio() {
        return servizio;
    }

    /**
     *  metodo che setta le informazioni di un servizio relazionatia ad un determinato contratto
     * @param servizio le informazioni di un servizio relazionatia ad un determinato contratto
     */
    public void seServizio(Servizio servizio) {
        this.servizio = servizio;
    }

    /**
     *  metodo che restituisce il prezzo unitario di un servizio associato ad un contrato
     * @return prezzoUnitario il prezzo unitario di un servizio associato ad un contratto
     */
    public Double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    /**
     *  metodo che setta il prezzo unitario di un servizio associato ad un contratto
     * @param prezzoUnitario il prezzo unitario di un servizio associato ad un contratto
     */
    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    /**
     *  metodo che restituisce la quantità di un servizio associato ad un contratto
     * @return quantita la quantita di un servizio associato ad un contratto
     */
    public Integer getQuantita() {
        return quantita;
    }

    /**
     * metodo che setta la quantita di un servizio associato ad un contratto
     * @param quantita la quantita di un servizio associato ad un contratto
     */
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
