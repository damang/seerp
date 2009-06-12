/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che contiene le informazione sui servizi associati ad una fattura
 * @author Luisa
 */
public class ServizioAssociatoFattura {

    private Integer quantita;
    private ServizioAssociato servizio;
    private Fattura fattura;
    private String note;
    private ArrayList<DDT> listDDT;

    public ServizioAssociatoFattura(Integer quantita, Integer servizio, Integer fattura, Integer contratto, String note, ArrayList<DDT> listDDT) {
        this.quantita = quantita;
        this.note = note;
        this.listDDT = listDDT;
    }

    /**
     * restituisce la lista dei DDT associati alla fattura
     * @return la lista dei DDT associati alla fattura
     */
    public ArrayList<DDT> getListDDT() {
        return listDDT;
    }

    /**
     * restituisce la lista dei DDT associati alla fattura
     * @param listDDT DDT associati alla fattura
     */
    public void setListDDT(ArrayList<DDT> listDDT) {
        this.listDDT = listDDT;
    }

   
    /**
     *  metodo che restituisce le informazioni della fattura alla quale sono associati determinati servizi di un contratto
     * @return  le informazioni della fattura alla quale sono associati determinati servizi di un contratto

     */
    public Fattura getFattura() {
        return fattura;
    }

    /**
     *  metodo che setta della fattura alla quale sono associati determinati servizi di un contratto
     * @param fattura le informazioni della fattura alla quale sono associati determinati servizi di un contratto
     */
    public void setFattura(Fattura fattura) {
        this.fattura = fattura;
    }

    /**
     *  metodo che restituisce l'identificativo del servizio associati a quella fattura in un determinato contratto
     * @return 'identificativo del servizio associati a quella fattura in un determinato contratto
     */
    public ServizioAssociato getServizio() {
        return servizio;
    }

    /**
     *  metodo che setta le informazioni del servizio associato a quella fattura in un determinato contratto
     * @param servizio rappresenta le informazioni del servizio associato a quella fattura in un determinato contratto
     */
    public void setServizio(ServizioAssociato servizio) {
        this.servizio = servizio;
    }

    /**
     *  metodo che restituisce le note del servizio associato ad una fattura
     * @return note le note del servizio associato ad una fattura
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note del servizio associato ad una fattura
     * @param note le note del servizio associato ad una fattura
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce la quantità di un servizio associato ad una fattura
     * @return la quantità di un servizio associato ad una fattura
     */
    public Integer getQuantita() {
        return quantita;
    }

    /**
     *  metodo che setta la quantita di un servizio associato ad una fattura
     * @param quantita la quantità di un servizio associato ad una fattura
     */
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public void removeDDT(DDT c) {
        listDDT.remove(c);
    }

    public void addDDT(DDT c) {
        listDDT.add(c);
    }
}
