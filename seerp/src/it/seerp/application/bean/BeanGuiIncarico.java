/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiIncarico {

 private JTextField txtPersonale;
 private JTextField txtPermesso;
 private  JTextField txtRuolo;

 /**
  * 
  * @param txtPersonale
  * @param txtPermesso
  * @param txtRuolo
  */
 public BeanGuiIncarico(JTextField txtPersonale, JTextField txtPermesso, JTextField txtRuolo) {
        this.txtPersonale = txtPersonale;
        this.txtPermesso = txtPermesso;
        this.txtRuolo = txtRuolo;
    }

 

    /**
     *
     * @return
     */
    public JTextField getTxtPermesso() {
        return txtPermesso;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPersonale() {
        return txtPersonale;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtRuolo() {
        return txtRuolo;
    }

    /**
     *
     * @param txtPermesso
     */
    public void setTxtPermesso(JTextField txtPermesso) {
        this.txtPermesso = txtPermesso;
    }

    /**
     *
     * @param txtPersonale
     */
    public void setTxtPersonale(JTextField txtPersonale) {
        this.txtPersonale = txtPersonale;
    }

    /**
     *
     * @param txtRuolo
     */
    public void setTxtRuolo(JTextField txtRuolo) {
        this.txtRuolo = txtRuolo;
    }



}
