
package it.seerp.storage.ejb;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * classe che gestisce le informazioni sui contratti
 * @author Luisa-Matteo
 */
public class Contratto {

    private String stato;
    private GregorianCalendar data;
    private Integer durata;
    private String tipo;
    private Integer idContratto;
    private String note;
    private Dipendente dipendente;
    private ExtraAzienda extraAzienda;
    private ArrayList<Pagamento> listPagamento;
    private ArrayList<ServizioAssociato> listServizio;
    private ArrayList<Fattura> listFattura;

    /**
     *
     */
    public Contratto() {
    }

    /**
     * costruttore
     * @param stato
     * @param data
     * @param durata
     * @param tipo
     * @param idContratto
     * @param note
     */
    public Contratto(String stato, GregorianCalendar data, Integer durata, String tipo,
            Integer idContratto, String note) {
        this.stato = stato;
        this.data = data;
        this.durata = durata;
        this.tipo = tipo;
        this.idContratto = idContratto;
        this.note = note;
        this.listPagamento = new ArrayList<Pagamento>();
        this.listServizio = new ArrayList<ServizioAssociato>();
        this.listFattura= new ArrayList<Fattura>();
    }

    /**
     * metodo che permette di settare la lista delle fatture associate al contratto
     * @param listFattura rappresenta la lista delle fatture
     */
    public void setListFattura(ArrayList<Fattura> listFattura) {
        this.listFattura = listFattura;
    }

    /**
     * metodo che restituisce la lista delle fatture associate al contratto
     * @return la lista delle fatture
     */
    public ArrayList<Fattura> getListFattura() {
        return listFattura;
    }

    /**
     *  metodo che restituisce la lista di servizi associati al contratto
     * @return la lista di servizi associati al contratto
     */
    public ArrayList<ServizioAssociato> getListServizio() {
        return listServizio;
    }

    /**
     *metodo che setta la lista di servizi associati al contratto
     * @param listServizio la lista di servizi associati al contratto
     */
    public void setListServizio(ArrayList<ServizioAssociato> listServizio) {
        this.listServizio = listServizio;
    }

    /**
     *  metodo che restituisce le informazioni del dipendente che ha stipulato il contratto
     * @return le infomazioni del dipendente che ha stipulato il contratto
     */
    public Dipendente getDipendente() {
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
     *  metodo che setta le informazioni dipendente che ha stipulato il contratto
     * @param dipendente rappresenta le informazioni dipendente che ha stipulato il contratto
     */
    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    /**
     * metodo che restituisce le informazioni del soggetto con il quale è stato stipulato il contratto
     * @return: le informazioni del soggetto con il quale è stato stipulato il contratto
     */
    public ExtraAzienda getExtraAzienda() {
        return extraAzienda;
    }

    /**
     *  metodo che setta le informazioni del soggetto con il quale è stato stipulato il contratto
     * @param extraAzienda rappresenta le informazioni del soggetto con il quale è stato stipulato il contratto
     */
    public void setExtraAzienda(ExtraAzienda extraAzienda) {
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
    public GregorianCalendar getData() {
        return data;
    }

    /**
     * metodo che setta la data di stipula del contratto
     * @param data la data di stipula del contratto
     */
    public void setData(GregorianCalendar data) {
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
    public void removeServzio(ServizioAssociato s) {
        listServizio.remove(s);
    }

    /**
     * metodo che aggiunge un servizio alla lista dei servizi
     * @param s servizio da aggiungere lista dei servizi
     */
    public void addServizio(ServizioAssociato s) {
        listServizio.add(s);
    }
}
