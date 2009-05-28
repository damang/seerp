/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private ArrayList<BeanGuiPermesso> listPermessi;
    private JTextField nome;
    private JTextField idRuolo;

    public BeanGuiRuolo() {
        
    }

    public BeanGuiRuolo(JTextField idRuolo, JTextField nome,ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPersonale = listPersonale;
        this.listPermessi = listPermessi;
        this.nome = nome;
        this.idRuolo = idRuolo;
    }

    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
    }

    public ArrayList<BeanGuiPersonale> getListPersonale() {
        return listPersonale;
    }

    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
    }

    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }

    

    public JTextField getIdRuolo() {
        return idRuolo;
    }

    public JTextField getNome() {
        return nome;
    }

    public void setIdRuolo(JTextField idRuolo) {
        this.idRuolo = idRuolo;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public void removePersonale(BeanGuiPersonale c){
     listPersonale.remove(c);}

    public void addPersonale(BeanGuiPersonale c){
      listPersonale.add(c);}

    public void removePermesso(BeanGuiPermesso c){
     listPermessi.remove(c);}
    
    public void addPermesso(BeanGuiPermesso c){
     listPermessi.add(c);}



}
