/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

     private JTextField idDipendenteTxt;
    

     /**
      *
      * @return
      */
     public JTextField getIdDipendenteTxt() {
        return idDipendenteTxt;
    }

      

    /**
     *
     * @param idDipendenteTxt
     */
    public void setIdDipendenteTxt(JTextField idDipendenteTxt) {
        this.idDipendenteTxt = idDipendenteTxt;
    }

  



}
