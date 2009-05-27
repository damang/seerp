/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
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

    public ArrayList<Pagamento> getListPagamento() {
        return listPagamento;
    }

    public void setListPagamento(ArrayList<Pagamento> listPagamento) {
        this.listPagamento = listPagamento;
    }

  

    

    /**
     *
     * @return
     */
    public String getAbi() {
        return abi;
    }

    /**
     *
     * @return
     */
    public String getAgenzia() {
        return agenzia;
    }

    /**
     *
     * @return
     */
    public String getCab() {
        return cab;
    }

    /**
     *
     * @return
     */
    public String getCap() {
        return cap;
    }

    /**
     *
     * @return
     */
    public String getCittà() {
        return città;
    }

    /**
     *
     * @return
     */
    public String getFiliale() {
        return filiale;
    }

    /**
     *
     * @return
     */
    public Double getImportoInAvere() {
        return importoInAvere;
    }

    /**
     *
     * @return
     */
    public Double getImportoInDare() {
        return importoInDare;
    }

    /**
     * 
     * @return
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     *
     * @return
     */
    public String getNazione() {
        return nazione;
    }

    /**
     *
     * @return
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     *
     * @param abi
     */
    public void setAbi(String abi) {
        this.abi = abi;
    }

    /**
     *
     * @param agenzia
     */
    public void setAgenzia(String agenzia) {
        this.agenzia = agenzia;
    }

    /**
     *
     * @param cab
     */
    public void setCab(String cab) {
        this.cab = cab;
    }

    /**
     *
     * @param cap
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     *
     * @param città
     */
    public void setCittà(String città) {
        this.città = città;
    }

    /**
     *
     * @param filiale
     */
    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    /**
     *
     * @param importoInAvere
     */
    public void setImportoInAvere(Double importoInAvere) {
        this.importoInAvere = importoInAvere;
    }

    /**
     *
     * @param importoInDare
     */
    public void setImportoInDare(Double importoInDare) {
        this.importoInDare = importoInDare;
    }

    /**
     *
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     *
     * @param nazione
     */
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    /**
     *
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

   public void removePagamento(Pagamento p){
     listPagamento.remove(p);}
    public void addPagamento(Pagamento p){
     listPagamento.add(p);}

}
