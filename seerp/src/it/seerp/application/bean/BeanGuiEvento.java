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
     *Costruttore per la Classe Bean Gui Evento
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
     * metodo che restituisce il campo contenente la notifica dell'Evento
     * @return il campo di notifica
     */
    public JTextField getNotifica() {
        return notifica;
    }

    /**
     * metodo che setta il campo notifica dell'Evento
     * @param notifica rappresenta il campo notifica
     */
    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }

    /**
     *Costruttore per la classe Bean Gui Evento
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
     *Costruttore vuoto per la classe Bean Gui Evento
     */
    public BeanGuiEvento() {}

    


    /**
     * metodo che restituisce il campo contenente l'id dell'Agenda
     * @return il campo id dell'Agenda
     */
    public JTextField getAgenda() {
        return agenda;
    }

    /**
     * metodo che setta il campo id dell'Agenda
     * @param agenda rappresenta il campo id dell'Agenda da inserire
     */
    public void setAgenda(JTextField agenda) {
        this.agenda = agenda;
    }

    /**
     * metodo che restituisce il campo contenente la data dell'Evento
     * @return il campo data dell'Evento
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che setta il campo data dell'Evento
     * @param data rappresenta il campo data da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che testituisce il campo contenente l'id dell'Evento
     * @return il campo id dell'Evento
     */
    public JTextField getIdEvento() {
        return idEvento;
    }

    /**
     * metodo che permette di settare il campo id dell'Evento
     * @param idEvento rappresenta il campo id  da inserire
     */
    public void setIdEvento(JTextField idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * metodo che restituisce il campo contenente il luogo dell'Evento
     * @return il campo luogo dell'Evento
     */
    public JTextField getLuogo() {
        return luogo;
    }

    /**
     *metodo che setta il campo luogo dell'Evento
     * @param luogo rappresenta il campo luogo da inserire
     */
    public void setLuogo(JTextField luogo) {
        this.luogo = luogo;
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'Evento
     * @return il campo nome dell'Evente
     */
    public JTextField getNome() {
        return nome;
    }

    /**
     * metodo che setta il campo nome dell'Evento
     * @param nome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    /**
     * metodo che restituisce il campo contenente le note dell'Evento
     * @return il campo note dell'Evento
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note dell'Evento
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il campo contenente l'ora dell'Evento
     * @return il campo ora
     */
    public JTextField getOra() {
        return ora;
    }

    /**
     * metodo che setta il campo ora dell'Evento
     * @param ora rappesenta il campo ora  da inserire
     */
    public void setOra(JTextField ora) {
        this.ora = ora;
    }


    
    /**
     * metodo che restituisce il campo contentente il tema dell'Evento
     * @return il campo tema
     */
    public JTextField getTema() {
        return tema;
    }

    /**
     * metodo che setta il campo tema dell'Evento
     * @param tema rappresenta il campo tema da inserire
     */
    public void setTema(JTextField tema) {
        this.tema = tema;
    }

}
