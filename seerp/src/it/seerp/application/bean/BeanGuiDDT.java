package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dei DDT
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiDDT {

    private JTextField merce;
    private JTextField quantita;
    private JTextField data;
    private JTextField idDDT;
    private JTextField numero;
    private JTextField fattureEmesse;
    private ArrayList<BeanGuiServizioAssociatoFattura> listServizio;
    private JTextArea note;

    /**
     * Costruttore per la classe Bean Gui DDT
     * @param merce
     * @param quantita
     * @param data
     * @param idDDT
     * @param numero
     * @param fattureEmesse
     * @param listServizio
     * @param note
     */
    public BeanGuiDDT(JTextField merce, JTextField quantita, JTextField data, JTextField idDDT, JTextField numero, JTextField fattureEmesse, ArrayList<BeanGuiServizioAssociatoFattura> listServizio, JTextArea note) {
        this.merce = merce;
        this.quantita = quantita;
        this.data = data;
        this.idDDT = idDDT;
        this.numero = numero;
        this.fattureEmesse = fattureEmesse;
        this.listServizio = listServizio;
        this.note = note;
    }

    /**
     * metodo che restituisce la lista dei servizi associati al DDT
     * @return la lista dei servizi
     */
    public ArrayList<BeanGuiServizioAssociatoFattura> getListServizio() {
        return listServizio;
    }

    /**
     * metodo che setta la lista dei servizi associati al DDT
     * @param listServizio rappresenta la lista dei servizi da inserire
     */
    public void setListServizio(ArrayList<BeanGuiServizioAssociatoFattura> listServizio) {
        this.listServizio = listServizio;
    }

    /**
     * metodo che restituisce il campo contenete la data di emissione del DDT
     * @return il campo data
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che setta il campo data di emissione di un DDT
     * @param data rappresenta il campo data da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che restituisce il campo contenente le fatture emesse per quel DDT
     * @return il campo fatture emesse
     */
    public JTextField getFattureEmesse() {
        return fattureEmesse;
    }

    /**
     * metodo che setta il campo fatture emesse per quel DDT
     * @param fattureEmesse rappresenta il campo fatture emesse da inserire
     */
    public void setFattureEmesse(JTextField fattureEmesse) {
        this.fattureEmesse = fattureEmesse;
    }

    /**
     * metodo che restituise il campo contenente l'id del DDT
     * @return il campo id del DDT
     */
    public JTextField getIdDDT() {
        return idDDT;
    }

    /**
     * metodo che setta il campo id del DDT
     * @param idDDT rappresenta il campo id da inserire
     */
    public void setIdDDT(JTextField idDDT) {
        this.idDDT = idDDT;
    }

    /**
     * metodo che restituisce il campo contenente la merce associata al DDT
     * @return il campo merce del DDT
     */
    public JTextField getMerce() {
        return merce;
    }

    /**
     * metodo che setta il campo merce del DDT
     * @param merce rappresenta il campo merce da inserire
     */
    public void setMerce(JTextField merce) {
        this.merce = merce;
    }

    /**
     * metodo che restituisce il campo contenente le note del DDT
     * @return il campo note del DDT
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note del DDT
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il campo contentente il numero del DDT
     * @return il campo numero
     */
    public JTextField getNumero() {
        return numero;
    }

    /**
     * metodo che setta il campo numerdo del DDT
     * @param numero rappresenta il campo numero da inserire
     */
    public void setNumero(JTextField numero) {
        this.numero = numero;
    }

    /**
     * metodo che restituisce il campo contenente la quantità di merce
     * interessata da DDT
     * @return il campo merce del DDT
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     * metodo che setta il campo quantità merce interessata dal DDT
     * @param quantita rappresenta il campo qunatità da inserire
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    /**
     *  metodo che permette di rimuovere un servizio dalla lista dei servizi
     * associati ad un DDT
     * @param s rappresenta  il servizio che si vuole rimuovere
     */
    public void removeServzio(BeanGuiServizioAssociatoFattura s) {
        listServizio.remove(s);
    }

    /**
     * metodo che permette di inserire un servizio nella lista dei servizi
     * associati ad un DDT
     * @param s rappresenta  il servizio che si vuole inserire
     */
    public void addServizio(BeanGuiServizioAssociatoFattura s) {
        listServizio.add(s);
    }
}
