/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

/**
 * la classe gestisce le informazioni
 * @author Luisa
 */
public class ServizioAssociato {

    private Integer quantita;
    private Double prezzoUnitario;
    private Integer contratto;
    private Integer servizio;
    private String note;

    public ServizioAssociato(Integer quantita, Double prezzoUnitario, Integer contratto, Integer servizio, String note) {
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.contratto = contratto;
        this.servizio = servizio;
        this.note = note;
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
     *  metodo che restituisce l'id del contratto a cui determinati servizi sono associati
     * @return l'id del contratto a cui determinati servizi sono associati
     */
    public Integer getContratto() {
        return contratto;
    }

    /**
     * metodo che setta l'id del contratto a cui determinati servizi sono associati
     * @param Contratto_idContratto l'id del contratto a cui determinati servizi sono associati
     */
    public void setContratto(Integer Contratto_idContratto) {
        this.contratto = Contratto_idContratto;
    }

    /**
     *  metodo che l'id di un servizio relazionatia ad un determinato contratto
     * @return l'id di un servizio relazionatia ad un determinato contratto
     */
    public Integer getServizio() {
        return servizio;
    }

    /**
     *  metodo che setta l'id di un servizio relazionatia ad un determinato contratto
     * @param Servizio_idServizio l'id di un servizio relazionatia ad un determinato contratto
     */
    public void seServizio(Integer Servizio_idServizio) {
        this.servizio = Servizio_idServizio;
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
