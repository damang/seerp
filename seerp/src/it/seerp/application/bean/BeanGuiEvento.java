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
public class BeanGuiEvento {
    private JTextField luogo;
    private JTextField  tema;
    private JTextField  nome;
    private JTextArea  note;
    private JTextField  data;
    private JTextField  ora;
    private JTextField  idEvento;
    private JTextField  agenda;
    private JTextField  notifica;


    public JTextField getNotifica() {
        return notifica;
    }

    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }

    public BeanGuiEvento(JTextField luogo, JTextField tema, JTextField nome, JTextArea note, JTextField data, JTextField ora, JTextField idEvento, JTextField agenda) {
        this.luogo = luogo;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
        this.agenda = agenda;
    }

    public BeanGuiEvento() {}

    


    public JTextField getAgenda() {
        return agenda;
    }

    public void setAgenda(JTextField agenda) {
        this.agenda = agenda;
    }

    public JTextField getData() {
        return data;
    }

    public void setData(JTextField data) {
        this.data = data;
    }

    public JTextField getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(JTextField idEvento) {
        this.idEvento = idEvento;
    }

    public JTextField getLuogo() {
        return luogo;
    }

    public void setLuogo(JTextField luogo) {
        this.luogo = luogo;
    }

    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public JTextArea getNote() {
        return note;
    }

    public void setNote(JTextArea note) {
        this.note = note;
    }

    public JTextField getOra() {
        return ora;
    }

    public void setOra(JTextField ora) {
        this.ora = ora;
    }


    
    public JTextField getTema() {
        return tema;
    }

    public void setTema(JTextField tema) {
        this.tema = tema;
    }

}
