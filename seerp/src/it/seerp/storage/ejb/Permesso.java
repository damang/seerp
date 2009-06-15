
package it.seerp.storage.ejb;

import it.seerp.jaas.AccessPermission;
import java.util.ArrayList;

/**
 * classe per la gestione del bean Permesso
 * @author matteo
 */
public class Permesso {

    private Integer idPermesso;
    private AccessPermission perm;

   

    /**
     * costruttore per la classe Permesso
     * @param idPermesso
     * @param task
     * @param action
     */
    public Permesso(Integer idPermesso, String task, String action) {
       this.idPermesso=idPermesso;
       this.perm=new AccessPermission(task, action);

    }

    /**
     * metodo che permette di restituire l'action di un permesso
     * @return l'action del permesso
     */
    public String getAction() {
        return perm.getActions();
    }

    /**
     * metodo che permette di restituire il codice identificativo di un permesso
     * @return l'id del permesso
     */
    public Integer getIdPermesso() {
        return idPermesso;
    }

    /**
     * metodo che permtte di restituire le informazioni relative all'incarico
     * @return le informazioni relative all'incarico
     */
    public AccessPermission getPermesso() {
        return perm;
    }

    /**
     * metodo che permette di restitire il task di un permesso
     * @return il task del permesso
     */
    public String getTask() {
        return perm.getName();
    }

    /**
     * metodo che permette di settare il permesso
     * @param action rappresenta l'action del permesso
     */
    public void setPermesso(String task,String action) {
        this.perm = new AccessPermission(task, action);
    }

    public void setPermesso(AccessPermission p) {
        this.perm = p;
    }

    /**
     * metodo che permette di settare il codice identificativo del permesso
     * @param idPermesso rappresenta l'id del permesso
     */
    public void setIdPermesso(Integer idPermesso) {
        this.idPermesso = idPermesso;
    }
}
