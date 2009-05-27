
package it.seerp.storage.ejb;

import java.sql.Date;
import java.sql.Time;

/**
 *classe utilizzata per gestire un evento
 * @author Luisa
 */
public class Evento {

    private String luogo;
    private String tema;
    private String nome;
    private String note;
    private Date data;
    private Time ora;
    private int idEvento;
    private Integer agenda;
    private Boolean notifica;

    public Boolean getNotifica() {
        return notifica;
    }

    public void setNotifica(Boolean notifica) {
        this.notifica = notifica;
    }

    public Evento(String luogo, String tema, String nome, String note, Date data, Time ora, int idEvento, Integer agenda, Boolean not) {
        this.luogo = luogo;
        this.notifica=not;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
        this.agenda = agenda;
    }

    /**
     * metodo che restituisce identificativo dell'agenda associata a quell'evento
     * @return identificativo dell'agenda associata a quell'evento
     */
    public Integer getAgenda() {
        return agenda;
    }

    /**
     * metodo che setta l'identificativo dell'agenda associata a quell'evento
     * @param agenda identificativo dell'agenda associata a quell'evento
     */
    public void setAgenda(Integer agenda) {
        this.agenda = agenda;
    }

    /**
     *  metodo che restituisce le note dell'evento
     * @return note dell'evento
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note dell'evento
     * @param note note dell'evento
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * metodo che restituisce l'identifictivo dell'evento
     * @return l'identifictivo dell'evento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * metodo che setta l'identifictivo dell'evento
     * @param idEvento l'identifictivo dell'evento
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * metodo che restituisce la data dell'evento
     * @return data la data dell'evento
     */
    public Date getData() {
        return data;
    }

    /**
     * metodo che setta la data dell'evento
     * @param data la data dell'evento
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * metodo che restituisece il luogo dell'evento
     * @return luogo dell'evento
     */
    public String getLuogo() {
        return luogo;
    }

    /**
     *  metodo che setta il luogo dell'evento
     * @param luogo il luogo dell'evento
     */
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    /**
     * metodo che restituisce il nome dell'evento
     * @return nome dell'evento
     */
    public String getNome() {
        return nome;
    }

    /**
     * metodo chr setta il nome dell'evento
     * @param nomeEvento il nome dell'evento
     */
    public void setNome(String nomeEvento) {
        this.nome = nomeEvento;
    }

    /**
     * metodo che restituisce l'ora dell'evento
     * @return ora dell'evento
     */
    public Time getOra() {
        return ora;
    }

    /**
     * metodo che setta l'ora dell'evento
     * @param ora l'ora dell'evento
     */
    public void setOra(Time ora) {
        this.ora = ora;
    }

    /**
     * metodo che  restituisce il tema dell'evento
     * @retur tema dell'evento
     */
    public String getTema() {
        return tema;
    }

    /**
     * metodo setta il tema dell'evento
     * @param tema il tema dell'evento
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
}
