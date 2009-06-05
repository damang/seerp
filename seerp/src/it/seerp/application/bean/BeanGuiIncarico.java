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
  * Costruttore per la classe BeanGuiIncarico
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
     * Metodo che permette di restituire il campo permesso dell'Incarico
     * @return il campo permesso
     */
    public JTextField getTxtPermesso() {
        return txtPermesso;
    }

    /**
     * Metodo che permette di restituire il campo personale dell'Incarico
     * @return il campo personale
     */
    public JTextField getTxtPersonale() {
        return txtPersonale;
    }

    /**
     * Metodo che permette di restituire il campo ruolo dell'Incarico
     * @return il campo ruolo
     */
    public JTextField getTxtRuolo() {
        return txtRuolo;
    }

    /**
     * Metodo che permette di settare il campo permesso di un Incarico
     * @param txtPermesso rappresenta il campo permesso da inserire
     */
    public void setTxtPermesso(JTextField txtPermesso) {
        this.txtPermesso = txtPermesso;
    }

    /**
     * Metodo che permette di settare il campo personale di un incarico
     * @param txtPersonale rappresenta il campo persnale da inserire
     */
    public void setTxtPersonale(JTextField txtPersonale) {
        this.txtPersonale = txtPersonale;
    }

    /**
     * Metodo che permette di settare il campo ruolo di un incarico
     * @param txtRuolo rappresenta il campo ruolo da inserire
     */
    public void setTxtRuolo(JTextField txtRuolo) {
        this.txtRuolo = txtRuolo;
    }

}
