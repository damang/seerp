package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Ruolo
 * @author Luisa-Matteo
 */
public class Ruolo {
     private ArrayList<Incarico> listIncarico;
     private String nome;
     private Personale personale;

     /**
      * costruttore per la classe Ruolo
      * @param idRuolo
      * @param nome
      */
     public Ruolo(String nome) {
        this.listIncarico = new ArrayList<Incarico>();
        this.nome = nome;
        
    }

     /**
      * motodo che permette di restituire le informazioni relative al personale
      * associato al ruolo
      * @return le informazioni del personale
      */
     public Personale getPersonale() {
        return personale;
    }

    /**
     * metodo che permtte di settare le informazioni realtive al pesonale
     * associato al ruolo
     * @param personale rappresenta le informazioni del personale
     */
    public void setPersonale(Personale personale) {
        this.personale = personale;
    }

   

    /**
     * metodo che permette di restituire la lista degli incarichi di un ruolo
     * @return la lista degli incarichi
     */
    public ArrayList<Incarico> getListIncarico() {
        return listIncarico;
    }

    /**
     * metodo che permette di settare la lista degli incarichi di un ruolo
     * @param listIncarico rappresenta la lista degli incarichi
     */
    public void setListIncarico(ArrayList<Incarico> listIncarico) {
        this.listIncarico = listIncarico;
    }
 
    /**
     * metodo che permette di restituire il nome di un ruolo
     * @return il nome di un ruolo
     */
    public String getNome() {
        return nome;
    }

    /**
     * metodo che permette di inserire il nome del ruolo
     * @param nome rappresenta il nome del ruolo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * metodo che permette di rimuovere un incarico dalla lista degli incarichi
     * @param c rappresenta l'incarico da eliminare
     */
    public void removeIncarico(Incarico c){
     listIncarico.remove(c);
    }

    /**
     * metodo che permette di aggiungere un incarico alla lista degli incarichi
     * @param c rappresenta l'incarico da inserire
     */
    public void addIncarico(Incarico c){
      listIncarico.add(c);
    }

}
