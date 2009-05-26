/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeanGuiContratto {

     private JTextField stato;
    private JTextField data;
    private JTextField durata;
      private JTextField tipo;
    private JTextField idContratto;
    private JTextArea note;
    private JTextField dipendente;
    private JTextField extraAzienda;


    public JTextField getData() {
        return data;
    }

    public void setData(JTextField data) {
        this.data = data;
    }

    public JTextField getDipendente() {
        return dipendente;
    }

    public void setDipendente(JTextField dipendente) {
        this.dipendente = dipendente;
    }

    public JTextField getDurata() {
        return durata;
    }

    public void setDurata(JTextField durata) {
        this.durata = durata;
    }

    public JTextField getExtraAzienda() {
        return extraAzienda;
    }

    public void setExtraAzienda(JTextField extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    public JTextField getIdContratto() {
        return idContratto;
    }

    public void setIdContratto(JTextField idContratto) {
        this.idContratto = idContratto;
    }

    public JTextArea getNote() {
        return note;
    }

    public void setNote(JTextArea note) {
        this.note = note;
    }

    public JTextField getStato() {
        return stato;
    }

    public void setStato(JTextField stato) {
        this.stato = stato;
    }

    public JTextField getTipo() {
        return tipo;
    }

    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }

}
