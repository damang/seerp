/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;
import java.sql.Time;

/**
 * costruttore
 * classe che gestisce gli appuntamenti
 * @author Luisa
 */
public class Appuntamento {

    private Date data;
    private Time ora;
    private Integer idAppuntamento;
    private String note;
    private Integer dipendente;
    private Integer extraAzienda;
    private Boolean notifica;

    /**
     *  costruttore
     * @param data
     * @param ora
     * @param idAppuntamento
     * @param note
     * @param dipendente
     * @param extraAzienda
     * @param notifica
     */
    public Appuntamento(Date data, Time ora, Integer idAppuntamento, String note, Integer dipendente, Integer extraAzienda, Boolean notifica) {
        this.data = data;
        this.ora = ora;
        this.idAppuntamento = idAppuntamento;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
        this.notifica = notifica;
   }

    /**
     * metodo che restituisce una notifica dell'appuntamento
     * @return notifica dell'appuntamento
     */
    public Boolean getNotifica() {
        return notifica;
    }

    /**
     * metodo che setta una notifica dell'appuntamento
     * @param notifica dell'appuntamento
     */
    public void setNotifica(Boolean notifica) {
        this.notifica = notifica;
    }

 
    /**
     * metodo che restituisce il dipendente con il quale si deve effettuare l'appuntamento
     * @return: dipendente con il quale si deve effettuare l'appuntamento
     */
    public Integer getDipendente() {
        return dipendente;
    }

    /**
     * metodo che setta dipendente con il quale si deve effettuare l'appuntamento
     * @param dipendente dipendente con il quale si deve effettuare l'appuntamento
     */
    public void setDipendente(Integer dipendente) {
        this.dipendente = dipendente;
    }

    /**
     * metodo che restituisce il soggeto che ha richiesto l'appuntamento
     * @return : soggeto che ha richiesto l'appuntamento
     */
    public Integer getExtraAzienda() {
        return extraAzienda;
    }

    /**
     * metodo che setta il soggeto che ha richiesto l'appuntamento
     * @param extraAzienda soggeto che ha richiesto l'appuntamento
     */
    public void setExtraAzienda(Integer extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    /**
     *  il metodo che restituisce le note dell'appuntamento
     * @return note dell'appuntamento
     */
    public String getNote() {
        return note;
    }

    /**
     *  il metodo che setta le note dell'appuntamento
     * @param note note dell'appuntamento
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * il metodo che restituisce la data dell'appuntamento
     * @return data dell'appuntamento
     */
    public Date getData() {
        return data;
    }

    /**
     *  il metodo che setta la data di un appuntamento
     * @param data data dell'appuntamento
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *  il metodo che rsetuisce l'identificativo univoco dell'appuntamento
     * @return identificativo dell'appuntamento
     */
    public Integer getIdAppuntamento() {
        return idAppuntamento;
    }

    /**
     * il metodo che setta l'identificativo univoco dell'appintamento
     * @param idAppuntamento identificativo dell'appuntamento
     */
    public void setIdAppuntamento(int idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }

    /**
     * il metodo che restituisce l'ora dell'appuntamento
     * @return: ora dell'appuntamento
     */
    public Time getOra() {
        return ora;
    }

    /**
     * il metodo che setta l'ora dell'appuntamento
     * @param ora l'ora dell'appuntamento
     */
    public void setOra(Time ora) {
        this.ora = ora;
    }
}
