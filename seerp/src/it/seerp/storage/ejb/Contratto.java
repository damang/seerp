
package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

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
    private ArrayList<Pagamento> listPagamento;
    private ArrayList<Servizio> listServizio;

    /**
     *
     */
    public Contratto() {
    }

    /**
     *
     * @param stato
     * @param data
     * @param durata
     * @param tipo
     * @param note
     * @param dipendente
     * @param extraAzienda
     */
    public Contratto(String stato, Date data, Integer durata, String tipo,
            String note, Integer dipendente, Integer extraAzienda) {
        this.stato = stato;
        this.data = data;
        this.durata = durata;
        this.tipo = tipo;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
    }

    /**
     * costruttore
     * @param stato
     * @param data
     * @param durata
     * @param tipo
     * @param idContratto
     * @param note
     * @param dipendente
     * @param extraAzienda
     * @param listPagamento
     * @param listServizio
     */
    public Contratto(String stato, Date data, Integer durata, String tipo,
            Integer idContratto, String note, Integer dipendente,
            Integer extraAzienda, ArrayList<Pagamento> listPagamento,
            ArrayList<Servizio> listServizio) {
        this.stato = stato;
        this.data = data;
        this.durata = durata;
        this.tipo = tipo;
        this.idContratto = idContratto;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
        this.listPagamento = listPagamento;
        this.listServizio = listServizio;
    }

    /**
     *
     * @param stt
     * @param da
     * @param d
     * @param t
     * @param i
     * @param n
     * @param dip
     * @param e
     * @param listS
     */
    public Contratto(String stt, Date da, Integer d, String t, Integer i,
            String n, Integer dip, Integer e, ArrayList<Servizio> listS) {
        this.listServizio = listS;
        this.stato = stt;
        this.data = da;
        this.durata = d;
        this.tipo = t;
        this.idContratto = i;
        this.note = n;
        this.dipendente = dip;
        this.extraAzienda = e;
    }

    /**
     *  metodo che restituisce la lista di servizi associati al contratto
     * @return la lista di servizi associati al contratto
     */
    public ArrayList<Servizio> getListServizio() {
        return listServizio;
    }

    /**
     *metodo che setta la lista di servizi associati al contratto
     * @param listServizio la lista di servizi associati al contratto
     */
    public void setListServizio(ArrayList<Servizio> listServizio) {
        this.listServizio = listServizio;
    }






    /**
     *  metodo che restituisce l'id dipendente che ha stipulato il contratto
     * @return id dipendente che ha stipulato il contratto
     */
    public Integer getDipendente() {
        return dipendente;
    }

    /**
     * metodo che restituisce la lista di pagamenti asociatia al contratto
     * @return la lista di pagamenti asociatia al contratto
     */
    


    public ArrayList<Pagamento> getListPagamento() {

        return listPagamento;
    }

    /**
     *metodo che setta la lista di pagamenti asociatia al contratto
     * @param listPagamento
     */
    public void setListPagamento(ArrayList<Pagamento> listPagamento) {
        this.listPagamento = listPagamento;
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

    /**
     * metodo che rimuovi un pagamento dalla lista dei pagamenti
     * @param p pagamento da rimuovere dalla lista
     */
    public void removePagamento(Pagamento p) {
        listPagamento.remove(p);
    }

    /**
     * metodo che aggiunge un  pagamento nella lista
     * @param p pagamento da inserire nella lista
     */
    public void addPagamento(Pagamento p) {
        listPagamento.add(p);
    }

    /**
     * metodo che rimuove un servizio alla lista dei servizi
     * @param s servizio da rimuovere lista dei servizi
     */
    public void removeServzio(Servizio s) {
        listServizio.remove(s);
    }

    /**
     * metodo che aggiunge un servizio alla lista dei servizi
     * @param s servizio da aggiungere lista dei servizi
     */
    public void addServizio(Servizio s) {
        listServizio.add(s);
    }


}
