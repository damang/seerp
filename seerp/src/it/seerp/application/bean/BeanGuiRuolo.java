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

    /**
     *
     */
    public BeanGuiRuolo() {
        
    }

    /**
     *
     * @param idRuolo
     * @param nome
     * @param listPersonale
     * @param listPermessi
     */
    public BeanGuiRuolo(JTextField idRuolo, JTextField nome,ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPersonale = listPersonale;
        this.listPermessi = listPermessi;
        this.nome = nome;
        this.idRuolo = idRuolo;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPersonale> getListPersonale() {
        return listPersonale;
    }

    /**
     *
     * @param listPermessi
     */
    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     *
     * @param listPersonale
     */
    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }

    

    /**
     *
     * @return
     */
    public JTextField getIdRuolo() {
        return idRuolo;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() {
        return nome;
    }

    /**
     *
     * @param idRuolo
     */
    public void setIdRuolo(JTextField idRuolo) {
        this.idRuolo = idRuolo;
    }

    /**
     *
     * @param nome
     */
    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    /**
     *
     * @param c
     */
    public void removePersonale(BeanGuiPersonale c){
     listPersonale.remove(c);}

    /**
     *
     * @param c
     */
    public void addPersonale(BeanGuiPersonale c){
      listPersonale.add(c);}

    /**
     * 
     * @param c
     */
    public void removePermesso(BeanGuiPermesso c){
     listPermessi.remove(c);}
    
    /**
     *
     * @param c
     */
    public void addPermesso(BeanGuiPermesso c){
     listPermessi.add(c);}



}
