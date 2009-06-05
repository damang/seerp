package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Luisa
 */
public class BeanGuiFatturaEmessa {
private JTextArea note;
    private JTextField idFatturaEmessa;
    private JTextField numeroProgressivo;
    private JTextField ivaDebito;
    private JTextField tipo;
     private ArrayList<BeanGuiDDT> listDDT;

     /**
      * Costruttore della classe Bean Gui Fattura Emessa 
      * @param note
      * @param idFatturaEmessa
      * @param numeroProgressivo
      * @param ivaDebito
      * @param tipo
      * @param listDDT
      */
     public BeanGuiFatturaEmessa(JTextArea note, JTextField idFatturaEmessa, JTextField numeroProgressivo, JTextField ivaDebito, JTextField tipo, ArrayList<BeanGuiDDT> listDDT) {
        this.note = note;
        this.idFatturaEmessa = idFatturaEmessa;
        this.numeroProgressivo = numeroProgressivo;
        this.ivaDebito = ivaDebito;
        this.tipo = tipo;
        this.listDDT = listDDT;
    }

    /**
     * Metodo che restituisce la lista dei DDT associati ad una fattura
     * @return la lista dei DDT
     */
    public ArrayList<BeanGuiDDT> getListDDT() {
        return listDDT;
    }

    /**
     * Metodo che permette di settare la dei DDT
     * @param listDDT rappesenta la lista che vuole inserire
     */
    public void setListDDT(ArrayList<BeanGuiDDT> listDDT) {
        this.listDDT = listDDT;
    }

    /**
     * metodo che permette di restituire il codice identificativo di un Fattura Emessa
     * @return l'id dell Fattura
     */
    public JTextField getIdFatturaEmessa() {
        return idFatturaEmessa;
    }

    /**
     * metodo che permette di settare il codice identificativo di un Fattura Emessa
     * @param idFatturaEmessa rappresenta l'id che si vuole settare
     */
    public void setIdFatturaEmessa(JTextField idFatturaEmessa) {
        this.idFatturaEmessa = idFatturaEmessa;
    }

    /**
     * metodo che permette di restituire l'iva a debito di una Fattura Emessa
     * @return l'iva a debito della Fattura
     */
    public JTextField getIvaDebito() {
        return ivaDebito;
    }

    /**
     * metodo che permette di settare l'iva a debito di una Fattura Emessa
     * @param ivaDebito rappresenta l'iva a debito che si vuole settare
     */
    public void setIvaDebito(JTextField ivaDebito) {
        this.ivaDebito = ivaDebito;
    }

    /**
     * metodo che  permette di restituire le note relative ad un Fattura Emessa
     * @return le note di una Fattura
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che permette di settare le note di una Fattura
     * @param note rappresenta le note che si voglio inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che permette di restituire il numero progressivo della Fattura Emessa
     * @return il numero della Fattura
     */
    public JTextField getNumeroProgressivo() {
        return numeroProgressivo;
    }

    /**
     * metodo che permette di settare il numero progressivo della Fattura
     * @param numeroProgressivo rappresenta il numero da inserire
     */
    public void setNumeroProgressivo(JTextField numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    /**
     * metodo che permette di restituire il tipo di Fattura Emessa
     * @return il tipo di Fattura
     */
    public JTextField getTipo() {
        return tipo;
    }

    /**
     * metodo che permette di settare il tipo di Fattura Emessa
     * @param tipo rappresenta il tipo da inserire
     */
    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }
    /**
     * metodo che permette di rimuovere un DDT dalla lista dei DDT
     * di una Fattura Emessa
     * @param c rappresenta il DDT da rimuovere
     */
    public void removeDDT(BeanGuiDDT c){
     listDDT.remove(c);}


        /**
         * metodo che permette di inserire un DDT nella lista dei DDT
         * di una Fattura Emessa
         * @param c
         */
        public void addDDT(BeanGuiDDT c){
     listDDT.add(c);}
}
