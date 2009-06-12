package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Incarico
 * @author Luisa-Matteo
 */
public class Incarico {
  private ArrayList<Permesso> listPermessi;
  private Ruolo ruolo;


 /**
  * costruttore vuoto
  */
 public Incarico() {
      listPermessi= new ArrayList<Permesso>();
    }

    /**
     * metodo che restituisce la lista dei permessi legato all'incarico
     * @return permesso legato all'incarico
     */
    public ArrayList<Permesso> getListPermesso() {
        return listPermessi;
    }

    /**
     * metodo che setta la lista dei permessi legati all'incarico
     * @param listPermessi rappresenta la lista dei permessi
     */
    public void setPermesso(ArrayList<Permesso> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     * metodo che resttuisce il pesonale legato all incarico
     * @return le informazioni relative al personale
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * metodo che setta il personale legato all incarico
     * @param ruolo rappresenta il personale
     */
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

     /**
     * metodo che permette di rimuovere un permesso dalla lista dei permessi
     * @param c rappresenta il permesso da eliminare
     */
    public void removePermesso(Permesso c){
     listPermessi.remove(c);
    }

    /**
     * metodo che permette di aggiungere un permesso alla lista dei permessi
     * @param c rappresenta il permesso da inserire
     */
    public void addPermesso(Permesso c){
      listPermessi.add(c);
    }

}
