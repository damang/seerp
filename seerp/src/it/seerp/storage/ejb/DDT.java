package it.seerp.storage.ejb;

import java.sql.Date;
import java.util.ArrayList;

/**
 * la classe gestisce le informazioni sui documenti di trasporto
 * @author Luisa-Matteo
 */
public class DDT {

    private String merce;
    private Integer quantita;
    private Date data;
    private Integer idDDT;
    private Integer numero;
    private String note;
    private ArrayList<ServizioAssociatoFattura> listServizio;
    private Fattura fattura;

    /**
     * costruttore
     * @param merce
     * @param quantita
     * @param data
     * @param idDDT
     * @param numero
     * @param note
     */
    public DDT(String merce, Integer quantita, Date data, Integer idDDT, Integer numero, String note) {
        this.merce = merce;
        this.quantita = quantita;
        this.data = data;
        this.idDDT = idDDT;
        this.numero = numero;
        this.note = note;
        this.listServizio =new ArrayList<ServizioAssociatoFattura>();
    }

    /**
     * metodo che setta le informazioni della fattura a cui il DDT è associato
     * @param fattura rappresenta le informazioni della fattura
     */
    public void setFattura(Fattura fattura) {
        this.fattura = fattura;
    }

    /**
     * metodo che restituisce le informazioni della fattura a cui il DDT è associato
     * @return le informazioni della fattura
     */
    public Fattura getFattura() {
        return fattura;
    }

    /**
     * metodo che  restituisce la lista dei servizi associati ad un DDT
     * @return  la lista dei servizi associati ad un DDT
     */
    public ArrayList<ServizioAssociatoFattura> getListServizio() {
        return listServizio;
    }

    /**
     * metodo che  setta la lista dei servizi associati ad un DDT
         * @param listServizio  la lista dei servizi associati ad un DDT
     */
    public void setListServizio(ArrayList<ServizioAssociatoFattura> listServizio) {
        this.listServizio = listServizio;
    }

  
    /**
     *   metodo che restituisce la data del DDT
     * @return: la data del DDT
     */
    public Date getData() {
        return data;
    }

    /**
     * metodo che  setta la data del DDT
     * @param data la data del DDT
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * metodo che restituisce l'identificativo del DDT
     * @return idDDT l'identificativo del DDT
     */
    public Integer getIdDDT() {
        return idDDT;
    }

    /**
     * metodo che setta identificativo del DDT
     * @param idDDT l'identificativo del DDT
     */
    public void setIdDDT(Integer idDDT) {
        this.idDDT = idDDT;
    }

    /**
     *  metodo che restituisce la merce del DDT
     * @return  merce  la merce del DDT
     */
    public String getMerce() {
        return merce;
    }

    /**
     * metodo che setta la merce del DDT
     * @param merce la merce del DDT
     */
    public void setMerce(String merce) {
        this.merce = merce;
    }

    /**
     * metodo che restituisce il numero del DDT
     * @return numero del DDT
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     *  metodo che setta il numero del DDT
     * @param numero il numero del DDT
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * metodo che restituisce la quantita del DDT
     * @return  quantita del DDT
     */
    public Integer getQuantita() {
        return quantita;
    }

    /**
     *  metodo che setta la quantita del DDT
     * @param quantita la quantita del DDT
     */
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    /**
     * metodo che restituisce le note del DDT
     * @return note del DDT
     */
    public String getNote() {
        return note;
    }

    /**
     * metodo che setta le note del DDT
     * @param note del DDT
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * metodo che rimuove un servizio dalla lista di servizi
     * @param s servizio da aggiungere alla lista
     */
    public void removeServzio(ServizioAssociatoFattura s){
     listServizio.remove(s);}
      /**
       * metodo che aggiunge un servizio alla lista di servizi
       * @param s servizio da aggiungere alla lista
       */
      public void addServizio(ServizioAssociatoFattura s){
     listServizio.add(s);}
}
