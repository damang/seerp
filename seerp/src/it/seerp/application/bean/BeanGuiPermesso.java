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
public class BeanGuiPermesso {


    private JTextField idPermesso;
    private JTextField Nome;
    private ArrayList<BeanGuiPersonale> listPersonale;
    private ArrayList<BeanGuiRuolo> listRuolo;

    /**
     *
     */
    public BeanGuiPermesso() {
        }

    /**
     *
     * @param idPermesso
     * @param Nome
     * @param listPersonale
     * @param listRuolo
     */
    public BeanGuiPermesso(JTextField idPermesso, JTextField Nome, ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiRuolo> listRuolo) {
        this.idPermesso = idPermesso;
        this.Nome = Nome;
        this.listPersonale = listPersonale;
        this.listRuolo = listRuolo;
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
     * @return
     */
    public ArrayList<BeanGuiRuolo> getListRuolo() {
        return listRuolo;
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
     * @param listRuolo
     */
    public void setListRuolo(ArrayList<BeanGuiRuolo> listRuolo) {
        this.listRuolo = listRuolo;
    }



    /**
     *
     * @return
     */
    public JTextField getNome() {
        return Nome;
    }

    /**
     *
     * @return
     */
    public JTextField getIdPermesso() {
        return idPermesso;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(JTextField Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @param idPermesso
     */
    public void setIdPermesso(JTextField idPermesso) {
        this.idPermesso = idPermesso;
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
    public void removeRuolo(BeanGuiRuolo c){
     listRuolo.remove(c);}

    /**
     * 
     * @param c
     */
    public void addRuolo(BeanGuiRuolo c){
     listRuolo.add(c);}

}
