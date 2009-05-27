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
public class Dipendente extends Personale{

     private Integer idDipendente;
     private ArrayList<Appuntamento> listAppuntamenti;
         private ArrayList<Contratto> listContratti;

    public Dipendente(Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listp, ArrayList<Ruolo> listr, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti) {
        super(idPersonale, cognome, nome, codiceFiscale, tipo, listp, listr);
        this.idDipendente = idDipendente;
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
    }



    public void setListContratti(ArrayList<Contratto> listContratti) {
        this.listContratti = listContratti;
    }

    public ArrayList<Contratto> getListContratti() {
        return listContratti;
    }

    public ArrayList<Appuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    public void setListAppuntamenti(ArrayList<Appuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }
  

    /**
     *  restituisce il codice identificativo del Dipendente
     * @return una stringa contenente l'identificativo del Dipendente
     */
    public Integer getIdDipendente() {
        return idDipendente;
    }

    /**
     * setta il codice identificativo del Dipendente
     * @param idDipendente di tipo int
     */
    public void setIdDipendente(Integer idDipendente) {
        this.idDipendente = idDipendente;
    }
  public void removeAppuntamento(Appuntamento p){
     listAppuntamenti.remove(p);}
    public void addAppuntamento(Appuntamento p){
     listAppuntamenti.add(p);}
       public void removeContratto(Contratto c){
     listContratti.remove(c);}
    public void addContratto(Contratto c){
     listContratti.add(c);}


}
