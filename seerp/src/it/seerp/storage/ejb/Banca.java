/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che gestisce le informazione sulla banca
 * @author matteo
 */
public class Banca {

    private String agenzia;
    private String abi;
    private String cab;
    private String città;
    private String provincia;
    private String indirizzo;
    private String cap;
    private String filiale;
    private String nazione;
    private Double importoInDare;
    private Double importoInAvere;
    private ArrayList<Pagamento> listPagamento;


    /**
     * metodo cotruttore
     * @param agenzia
     * @param abi
     * @param cab
     * @param città
     * @param provincia
     * @param indirizzo
     * @param cap
     * @param filiale
     * @param nazione
     * @param importoInDare
     * @param importoInAvere
     * @param listPagamento
     */
    public Banca(String agenzia, String abi, String cab, String città, String provincia, String indirizzo, String cap, String filiale, String nazione, Double importoInDare, Double importoInAvere, ArrayList<Pagamento> listPagamento) {
        this.agenzia = agenzia;
        this.abi = abi;
        this.cab = cab;
        this.città = città;
        this.provincia = provincia;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.filiale = filiale;
        this.nazione = nazione;
        this.importoInDare = importoInDare;
        this.importoInAvere = importoInAvere;
        this.listPagamento = listPagamento;
    }

      /**
       * restituisce una lista di pagamenti associati ad una banca
       * @return una lista di pagamenti di una banca
       */
      public ArrayList<Pagamento> getListPagamento() {
        return listPagamento;
    }

    /**
     * setta la lista di pagamenti asociati ad una banca 
     * @param listPagamento lista di pagamenti di una banca
     */
    public void setListPagamento(ArrayList<Pagamento> listPagamento) {
        this.listPagamento = listPagamento;
    }

  

    

    /**
     * metodo che restituisce il codice Abi della  banca
     * @return il codice Abi della  banca
     */
    public String getAbi() {
        return abi;
    }

    /**
     * metodo che setta l'agenzia a cui e associata la banca
     * @return l'agenzia della banca
     */
    public String getAgenzia() {
        return agenzia;
    }

    /**
     * metodo che restituisce Cab della banca
     * @return Cab della banca
     */
    public String getCab() {
        return cab;
    }

    /**
     * metodo che restituisce Cap della banca
     * @return Cap della banca
     */
    public String getCap() {
        return cap;
    }

    /**
     * metodo che restutisce la citta della banca
     * @return citta della banca
     */
    public String getCittà() {
        return città;
    }

    /**
     * metodo che restituisce la filiale della banca
     * @return filiale della banca
     */
    public String getFiliale() {
        return filiale;
    }

    /**
     * metodo che restituisce l'importo in avere di una banca
     * @return l'importo in avere di una banca
     */
    public Double getImportoInAvere() {
        return importoInAvere;
    }

    /**
     * metodo che restituisce in dare di una banca
     * @return l'importo in dare di una banca
     */
    public Double getImportoInDare() {
        return importoInDare;
    }

    /**
     * metodo che restituisce l'indirizzo della banca
     * @return l'indirizzo della banca
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * metodo che restituisce la nazione della banca
     * @return la nazione della banca
     */
    public String getNazione() {
        return nazione;
    }

    /**
     * metodo che restituisce la ptrovincia della banca
     * @return la ptrovincia della banca
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * metodo che setta l'abi della banca
     * @param abi l'abi della banca
     */
    public void setAbi(String abi) {
        this.abi = abi;
    }

    /**
     * metodo che setta l'agenzia della banca
     * @param agenzia l'agenzia della banca
     */
    public void setAgenzia(String agenzia) {
        this.agenzia = agenzia;
    }

    /**
     * metodo che setta il cab della banca
     * @param cab il cab della banca
     */
    public void setCab(String cab) {
        this.cab = cab;
    }

    /**
     * metodo che setta il Cap della banca
     * @param cap il Cap della banca
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * metodo che setta la citta della banca
     * @param città la ditta della banca
     */
    public void setCittà(String città) {
        this.città = città;
    }

    /**
     * metodo che setta la filiale della banca
     * @param filiale la filiale della banca
     */
    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    /**
     * metodo che setta l'importo in avere della banca
     * @param importoInAvere l'importo in avere della banca
     */
    public void setImportoInAvere(Double importoInAvere) {
        this.importoInAvere = importoInAvere;
    }

    /**
     *  metodo che setta l'importo in dare della banca
     * @param importoInDare l'importo  in dare della banca
     */
    public void setImportoInDare(Double importoInDare) {
        this.importoInDare = importoInDare;
    }

    /**
     *  metodo che setta  l'indirizzo della banca
     * @param indirizzo l'indirizzo della banca
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * metodo che setta la nazione di una banca
     * @param nazione di una banca
     */
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    /**
     * metodo che setta la provincia di una banca
     * @param provincia della banca
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * metodo che rimuove un pagamento alla lista dei pagamenti
    * @param p pagamento da aggiungere
     */
    public void removePagamento(Pagamento p){
     listPagamento.remove(p);}
   /**
    * metodo che aggiunge un pagamento alla lista dei pagamenti
    * @param p pagamento da aggiungere
    */
   public void addPagamento(Pagamento p){
     listPagamento.add(p);}

}
