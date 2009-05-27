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
class BeanGuiAppuntamento {

    private JTextField data;
    private JTextField ora;
    private JTextField idAppuntamento;
    private JTextField note;
    private JTextField dipendente;

    private JTextField extraAzienda;
     private JTextField notifica;

 

    public BeanGuiAppuntamento(JTextField data, JTextField ora, JTextField idAppuntamento, JTextField note, JTextField dipendente, JTextField extraAzienda,JTextField notifica) {
        this.data = data;
        this.ora = ora;
        this.idAppuntamento = idAppuntamento;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
        this.notifica=notifica;
    }

       public JTextField getNotifica() {
        return notifica;
    }

    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }


    public JTextField getData() {
        return data;
    }

    public JTextField getDipendente() {
        return dipendente;
    }

    public JTextField getExtraAzienda() {
        return extraAzienda;
    }

    public JTextField getIdAppuntamento() {
        return idAppuntamento;
    }

    public JTextField getNote() {
        return note;
    }

    public JTextField getOra() {
        return ora;
    }

    public void setData(JTextField data) {
        this.data = data;
    }

    public void setDipendente(JTextField dipendente) {
        this.dipendente = dipendente;
    }

    public void setExtraAzienda(JTextField extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    public void setIdAppuntamento(JTextField idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }

    public void setNote(JTextField note) {
        this.note = note;
    }

    public void setOra(JTextField ora) {
        this.ora = ora;
    }



}
