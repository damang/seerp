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

    /**
     *
     * @param luogo
     * @param tema
     * @param nome
     * @param note
     * @param data
     * @param ora
     * @param idEvento
     * @param agenda
     * @param notifica
     */
    public BeanGuiEvento(JTextField luogo, JTextField tema, JTextField nome, JTextArea note, JTextField data, JTextField ora, JTextField idEvento, JTextField agenda, JTextField notifica) {
        this.luogo = luogo;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
        this.agenda = agenda;
        this.notifica = notifica;
    }

    


    /**
     *
     * @return
     */
    public JTextField getNotifica() {
        return notifica;
    }

    /**
     *
     * @param notifica
     */
    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }

    /**
     *
     * @param luogo
     * @param tema
     * @param nome
     * @param note
     * @param data
     * @param ora
     * @param idEvento
     * @param agenda
     */
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

    /**
     *
     */
    public BeanGuiEvento() {}

    


    /**
     *
     * @return
     */
    public JTextField getAgenda() {
        return agenda;
    }

    /**
     * 
     * @param agenda
     */
    public void setAgenda(JTextField agenda) {
        this.agenda = agenda;
    }

    /**
     *
     * @return
     */
    public JTextField getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public JTextField getIdEvento() {
        return idEvento;
    }

    /**
     *
     * @param idEvento
     */
    public void setIdEvento(JTextField idEvento) {
        this.idEvento = idEvento;
    }

    /**
     *
     * @return
     */
    public JTextField getLuogo() {
        return luogo;
    }

    /**
     *
     * @param luogo
     */
    public void setLuogo(JTextField luogo) {
        this.luogo = luogo;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     *
     * @return
     */
    public JTextField getOra() {
        return ora;
    }

    /**
     *
     * @param ora
     */
    public void setOra(JTextField ora) {
        this.ora = ora;
    }


    
    /**
     *
     * @return
     */
    public JTextField getTema() {
        return tema;
    }

    /**
     *
     * @param tema
     */
    public void setTema(JTextField tema) {
        this.tema = tema;
    }

}
