package it.seerp.storage.ejb;

import it.seerp.jaas.PermessoCollection;
import it.seerp.jaas.PermissionRoleDBAdapter;
import java.util.ArrayList;

/**
 * classe per la gestione del bean Ruolo
 * @author Luisa-Matteo
 */
public class Ruolo {
     private PermessoCollection listPermesso;
     private String nome;
     private ArrayList<Personale> listPersonale;
     private boolean perm_syncro;

     /**
      * costruttore per la classe Ruolo
      * @param idRuolo
      * @param nome
      */
     public Ruolo(String nome) {
        this.listPermesso=null;
        this.nome = nome;
        this.listPersonale= null;
        perm_syncro=true;
    }

    public void setListPersonale(ArrayList<Personale> listPersonale) {
        this.listPersonale = listPersonale;
    }

     /**
      * motodo che permette di restituire le informazioni relative al personale
      * associato al ruolo
      * @return le informazioni del personale
      */
     public ArrayList<Personale> getPersonale() {
        return listPersonale;
    }

     /**
     * metodo che permette di restituire la lista degli incarichi di un ruolo
     * @return la lista degli incarichi
     */
    public PermessoCollection getListPermesso() {
        if (perm_syncro)
            return PermissionRoleDBAdapter.getPermissionsUt(nome);
        else return listPermesso;
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
    public void removePermesso(Permesso c){
     listPermesso.remove(c);
    }

    /**
     * metodo che permette di aggiungere un incarico alla lista degli incarichi
     * @param c rappresenta l'incarico da inserire
     */
    public void addPermesso(Permesso c){
      listPermesso.add(c);
    }
    public void setPermSyncro(boolean b) {
        perm_syncro=b;
        if(perm_syncro==false) {
            listPermesso=new PermessoCollection();
        }
    }

}
