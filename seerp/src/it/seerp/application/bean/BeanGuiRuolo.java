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
class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private ArrayList<BeanGuiPermesso> listPermessi;
    private JTextField nome;
    private JTextField idRuolo;

    public BeanGuiRuolo(ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiPermesso> listPermessi, JTextField nome, JTextField idRuolo) {
        this.listPersonale = listPersonale;
        this.listPermessi = listPermessi;
        this.nome = nome;
        this.idRuolo = idRuolo;
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
