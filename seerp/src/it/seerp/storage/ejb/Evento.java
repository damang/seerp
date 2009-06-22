package it.seerp.storage.ejb;

import java.util.GregorianCalendar;

/**
 * classe utilizzata per gestire un evento
 * @author Luisa-Matteo - Tommaso Cattolico
 */
public class Evento {

    private String luogo;
    private String tema;
    private String nome;
    private String note;
    private GregorianCalendar data;
    private GregorianCalendar ora;
    private int idEvento;
    private Boolean notifica;
    //private Agenda agd;
    private int agenda;

    /**
     * Costruttore vuoto
     */
    public Evento() {
    }

    /**
     * Costruttore per la classe Evento
     * @param luogo
     * @param tema
     * @param nome
     * @param note
     * @param data
     * @param ora
     * @param idEvento
     * @param not
     */
    public Evento(String luogo, String tema, String nome, String note, GregorianCalendar data, GregorianCalendar ora, int idEvento, Boolean not, int agd) {
        this.luogo = luogo;
        this.notifica = not;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
        this.agenda = agd;
    }

    public Evento(String luogo, String tema, String nome, String note, GregorianCalendar data, GregorianCalendar ora, int idEvento, Boolean not) {
        this.luogo = luogo;
        this.notifica = not;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if ((this.luogo == null) ? (other.luogo != null) : !this.luogo.equals(other.luogo)) {
            return false;
        }
        if ((this.tema == null) ? (other.tema != null) : !this.tema.equals(other.tema)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.note == null) ? (other.note != null) : !this.note.equals(other.note)) {
            return false;
        }
        if (this.data != other.data && (this.data == null || !this.data.equals(other.data))) {
            return false;
        }
        if (this.ora != other.ora && (this.ora == null || !this.ora.equals(other.ora))) {
            return false;
        }
        if (this.idEvento != other.idEvento) {
            return false;
        }
        if (this.notifica != other.notifica && (this.notifica == null || !this.notifica.equals(other.notifica))) {
            return false;
        }
        if (this.agenda != other.agenda) {
            return false;
        }
        return true;
    }

    /**
     * metodo che restituisce notificazione dell'evento
     * @return notificazione dell'evento
     */
    public Boolean getNotifica() {
        return notifica;
    }

    /**
     * motodo che permette di restituire l'agenda a cui l'evento appartiene
     * @return l'agenda dell'Evento
     */
    public int getAgenda() {
        return agenda;
    }

    /**
     * metodo che setta la notificazione dell'evento
     * @param notifica notificazione dell'evento
     */
    public void setNotifica(Boolean notifica) {
        this.notifica = notifica;
    }

    /**
     * metodo che setta l'identificativo dell'agenda associata a quell'evento
     * @param a
     */
    public void setAgenda(int a) {
        this.agenda = a;
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
    public GregorianCalendar getData() {
        return data;
    }

    /**
     * metodo che setta la data dell'evento
     * @param data la data dell'evento
     */
    public void setData(GregorianCalendar data) {
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
    public GregorianCalendar getOra() {
        return ora;
    }

    /**
     * metodo che setta l'ora dell'evento
     * @param ora l'ora dell'evento
     */
    public void setOra(GregorianCalendar ora) {
        this.ora = ora;
    }

    /**
     * metodo che  restituisce il tema dell'evento
     * @return
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
