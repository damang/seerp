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

    public BeanGuiIncarico(JTextField txtPersonale, JTextField txtPermesso, JTextField txtRuolo) {
        this.txtPersonale = txtPersonale;
        this.txtPermesso = txtPermesso;
        this.txtRuolo = txtRuolo;
    }

 

    public JTextField getTxtPermesso() {
        return txtPermesso;
    }

    public JTextField getTxtPersonale() {
        return txtPersonale;
    }

    public JTextField getTxtRuolo() {
        return txtRuolo;
    }

    public void setTxtPermesso(JTextField txtPermesso) {
        this.txtPermesso = txtPermesso;
    }

    public void setTxtPersonale(JTextField txtPersonale) {
        this.txtPersonale = txtPersonale;
    }

    public void setTxtRuolo(JTextField txtRuolo) {
        this.txtRuolo = txtRuolo;
    }



}
