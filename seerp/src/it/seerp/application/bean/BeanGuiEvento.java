/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeanGuiEvento {
    private JTextField luogo;
    private JTextField  tema;
    private JTextField  nome;
    private JTextField  note;
    private JTextField  data;
    private JTextField  ora;
    private JTextField  idEvento;
    private JTextField  agenda;

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

    public JTextField getNote() {
        return note;
    }

    public void setNote(JTextField note) {
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
