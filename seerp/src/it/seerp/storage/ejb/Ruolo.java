/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public class Ruolo {
     private ArrayList<Personale> listPersonale;
     private ArrayList<Permesso> listPermessi;
     private String nome;
     private Integer idRuolo;

    public Ruolo(ArrayList<Personale> listPersonale, ArrayList<Permesso> listPermessi, String nome, Integer idRuolo) {
        this.listPersonale = listPersonale;
        this.listPermessi = listPermessi;
        this.nome = nome;
        this.idRuolo = idRuolo;
    }

  

    public Integer getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(Integer idRuolo) {
        this.idRuolo = idRuolo;
    }

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void removePersonale(Personale c){
     listPersonale.remove(c);}
    public void addPersonale(Personale c){
      listPersonale.add(c);}

      public void removePermesso(Permesso c){
     listPermessi.remove(c);}
    public void addPermesso(Permesso c){
     listPermessi.add(c);}
 

}
