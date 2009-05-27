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
public class Permesso {

    private Integer idPermesso;
    private String Nome;
    private ArrayList<Personale> listPersonale;
    private ArrayList<Ruolo> listRuolo;

    public Permesso(Integer idPermesso, String Nome, ArrayList<Personale> listPersonale, ArrayList<Ruolo> listRuolo) {
        this.idPermesso = idPermesso;
        this.Nome = Nome;
        this.listPersonale = listPersonale;
        this.listRuolo = listRuolo;
    }

    public ArrayList<Ruolo> getListPermessi() {
        return listRuolo;
    }

    public void setListPermessi(ArrayList<Ruolo> listPermessi) {
        this.listRuolo = listPermessi;
    }

    public ArrayList<Personale> getListPersonale() {
        return listPersonale;
    }

    public void setListPersonale(ArrayList<Personale> listPersonale) {
        this.listPersonale = listPersonale;
    }




    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @return
     */
    public Integer getIdPermesso() {
        return idPermesso;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * 
     * @param idPermesso
     */
    public void setIdPermesso(Integer idPermesso) {
        this.idPermesso = idPermesso;
    }
       public void removePersonale(Personale c){
     listPersonale.remove(c);}
    public void addPersonale(Personale c){
      listPersonale.add(c);}

      public void removeRuolo(Ruolo c){
     listRuolo.remove(c);}
    public void addRuolo(Ruolo c){
     listRuolo.add(c);}


}
