/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public class BeanGuiDDT {
    private JTextField merce;
    private JTextField quantita;
    private JTextField data;
    private JTextField idDDT;
    private JTextField numero;
    private JTextField fattureEmesse;
        private ArrayList<BeanGuiServizioAssociatoFattura> listServizio;

    public ArrayList<BeanGuiServizioAssociatoFattura> getListServizio() {
        return listServizio;
    }

    public void setListServizio(ArrayList<BeanGuiServizioAssociatoFattura> listServizio) {
        this.listServizio = listServizio;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che
     * @param data
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getFattureEmesse() {
        return fattureEmesse;
    }

    /**
     * metodo che
     * @param fattureEmesse
     */
    public void setFattureEmesse(JTextField fattureEmesse) {
        this.fattureEmesse = fattureEmesse;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getIdDDT() {
        return idDDT;
    }

    /**
     * metodo che
     * @param idDDT
     */
    public void setIdDDT(JTextField idDDT) {
        this.idDDT = idDDT;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getMerce() {
        return merce;
    }

    /**
     * metodo che
     * @param merce
     */
    public void setMerce(JTextField merce) {
        this.merce = merce;
    }

    /**
     * metodo che
     * @return
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che
     * @param note
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getNumero() {
        return numero;
    }

    /**
     * metodo che
     * @param numero
     */
    public void setNumero(JTextField numero) {
        this.numero = numero;
    }

    /**
     * metodo che
     * @return
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     * metodo che
     * @param quantita
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }
    private JTextArea note;
       public void removeServzio(BeanGuiServizioAssociatoFattura s){
     listServizio.remove(s);
      }
    public void addServizio(BeanGuiServizioAssociatoFattura s){
     listServizio.add(s);}

}
