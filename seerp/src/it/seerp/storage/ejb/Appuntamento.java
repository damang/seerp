/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;
import java.sql.Time;

/**
 * classe che gestisce gli appuntamenti
 * @author Luisa
 */
public class Appuntamento {

    private Date data;
    private Time ora;
    private int idAppuntamento;
    private String note;
    private Integer dipendente;
    private Integer extraAzienda;

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
    public int getIdAppuntamento() {
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
