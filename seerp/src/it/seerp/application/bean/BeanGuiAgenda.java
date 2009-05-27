/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeanGuiAgenda {
  private ArrayList<BeanGuiEvento> listEventi= new  ArrayList<BeanGuiEvento>();
  private JTextField idAgenda;
    public void removeEvento(BeanGuiEvento c){
     listEventi.remove(c);}
    public void addEvento(BeanGuiEvento c){
     listEventi.add(c);}

    public ArrayList<BeanGuiEvento> getArrEventi() {
        return listEventi;
    }

    public void setArrEventi(ArrayList<BeanGuiEvento> arrEventi) {
        this.listEventi = arrEventi;
    }

    public JTextField getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(JTextField idAgenda) {
        this.idAgenda = idAgenda;
    }
}
