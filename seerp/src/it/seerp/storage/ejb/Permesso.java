
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Permesso
 * @author matteo
 */
public class Permesso {

    private Integer idPermesso;
    private String task;
    private String action;
    private Incarico incarico;
   

    /**
     * costruttore per la classe Permesso
     * @param idPermesso
     * @param task
     * @param action
     */
    public Permesso(Integer idPermesso, String task,String action) {
       this.idPermesso=idPermesso;
       this.action=action;
       this.task=task;

    }

    /**
     * metodo che permette di restituire l'action di un permesso
     * @return l'action del permesso
     */
    public String getAction() {
        return action;
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
    public Incarico getIncarico() {
        return incarico;
    }

    /**
     * metodo che permette di restitire il task di un permesso
     * @return il task del permesso
     */
    public String getTask() {
        return task;
    }

    /**
     * metodo che permette di settare l'action di un permesso
     * @param action rappresenta l'action del permesso
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * metodo che permette di settare il codice identificativo del permesso
     * @param idPermesso rappresenta l'id del permesso
     */
    public void setIdPermesso(Integer idPermesso) {
        this.idPermesso = idPermesso;
    }

    /**
     * metodo che permette di settare le informazioni relative all'incarico
     * @param incarico rappresenta le informazioni dell'incarico
     */
    public void setIncarico(Incarico incarico) {
        this.incarico = incarico;
    }

    /**
     * metodo che permette di settare il task del permesso
     * @param task rappresenta il task
     */
    public void setTask(String task) {
        this.task = task;
    }


}
