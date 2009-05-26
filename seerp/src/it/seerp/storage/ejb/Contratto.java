/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.sql.Date;

/**
 * classe che gestisce le informazioni sui contratti
 * @author Luisa
 */
public class Contratto {

    private String stato;
    private Date data;
    private Integer durata;
    private String tipo;
    private Integer idContratto;
    private String note;
    private Integer dipendente;
    private Integer extraAzienda;


    public Contratto(String st, Date da, Integer d,String t, Integer i, String n, Integer dip,Integer e)
    {
        this.stato=st;
        this.data=da;
        this.durata=d;
        this.tipo=t;
        this.idContratto=i;
        this.note=n;
        this.dipendente=dip;
       this.extraAzienda=e;}
    /**
     *  metodo che restituisce l'id dipendente che ha stipulato il contratto
     * @return id dipendente che ha stipulato il contratto
     */
    public Integer getDipendente() {
        return dipendente;
    }

    /**
     *  metodo che setta id dipendente che ha stipulato il contratto
     * @param dipendente id dipendente che ha stipulato il contratto
     */
    public void setDipendente(Integer dipendente) {
        this.dipendente = dipendente;
    }

    /**
     * metodo che restituisce id soggetto con il quale è stato stipulato il contratto
     * @return: id soggetto con il quale è stato stipulato il contratto
     */
    public Integer getExtraAzienda() {
        return extraAzienda;
    }

    /**
     *  metodo che setta id soggetto con il quale è stato stipulato il contratto
     * @param extraAzienda id soggetto con il quale è stato stipulato il contratto
     */
    public void setExtraAzienda(Integer extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    /**
     *  metodo che restituisce le note del contratti
     * @return : le note del contratti
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note dell'evento
     * @param note le note dell'evento
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce la data di stipula del contratto
     * @return : la data di stipula del contratto
     */
    public Date getData() {
        return data;
    }

    /**
     * metodo che setta la data di stipula del contratto
     * @param data la data di stipula del contratto
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * metodo che restituisce la durata del contratto
     * @return: durata del contratto
     */
    public Integer getDurata() {
        return durata;
    }

    /**
     * metodo che setta la durata del contratto
     * @param durata la durata del contratto
     */
    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    /**
     * metodo che restituisce l'identificativo univoco del contratto
     * @return l'identificativo univoco del contratto
     */
    public Integer getIdContratto() {
        return idContratto;
    }

    /**
     * metodo che setta l'identificativo del contratto
     * @param idContratto l'identificativo univoco del contratto
     */
    public void setIdContratto(Integer idContratto) {
        this.idContratto = idContratto;
    }

    /**
     * metodo che restituisce lo stato del contratto
     * @return stato del contratto
     */
    public String getStato() {
        return stato;
    }

    /**
     * metodo che setta lo stato del contratto
     * @param stato stato del contratto
     */
    public void setStato(String stato) {
        this.stato = stato;
    }

    /**
     * metofdo che restituisce il tipo di contratto
     * @return tipo di contratto
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo che setta il tipo di contratto
     * @param tipo tipo di contratto
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
