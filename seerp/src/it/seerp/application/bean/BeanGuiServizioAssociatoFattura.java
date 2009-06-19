package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dei Servizi associati alle fatture
 * @author Luisa
 */
public class BeanGuiServizioAssociatoFattura {

    private JTextField quantita;
    private JTextField servizio;
    private JTextField fattura;
    private JTextField contratto;
    private JTextArea note;
    private ArrayList<BeanGuiDDT> listDDT;

    /**
     *
     * @param quantita
     * @param servizio
     * @param fattura
     * @param contratto
     * @param note
     * @param listDDT
     */
    public BeanGuiServizioAssociatoFattura(JTextField quantita, JTextField servizio, JTextField fattura, JTextField contratto, JTextArea note, ArrayList<BeanGuiDDT> listDDT) {
        this.quantita = quantita;
        this.servizio = servizio;
        this.fattura = fattura;
        this.contratto = contratto;
        this.note = note;
        this.listDDT = listDDT;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiDDT> getListDDT() {
        return listDDT;
    }

    /**
     *
     * @param listDDT
     */
    public void setListDDT(ArrayList<BeanGuiDDT> listDDT) {
        this.listDDT = listDDT;
    }
    /**
     * metodo che restituisce l'identificativo del contratto dal campo associato
     * @return identificativo del contratto
     */
    public JTextField getContratto() {
        return contratto;
    }

    /**
     * metodo che setta l'id del contratto dal campo associato
     * @param contratto id del contratto
     */
    public void setContratto(JTextField contratto) {
        this.contratto = contratto;
    }

    /**
     * metodo che che restituisce l'identificativo della fattura dal campo associato
     * @return l'identificativo della fattura
     */
    public JTextField getFattura() {
        return fattura;
    }

    /**
     * metodo che setta l'identificativo della fattura dal campo associato
     * @param fattura l'identificativo della fattura dal campo associato
     */
    public void setFattura(JTextField fattura) {
        this.fattura = fattura;
    }

    /**
     * metodo che restituisce le note relative a servizioAssociateFatture dalla text area associata
     * @return le note relative a servizioAssociateFatture
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta le note relative a servizioAssociateFatture dalla text area associata
     * @param note le note relative a servizioAssociateFatture
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che la quantita di un servizio associato ad una fattura dal campo corrispondente
     * @return la quantita di un servizio associato ad una fattura
     */
    public JTextField getQuantita() {
        return quantita;
    }

    /**
     * metodo che setta la quantita di un servizio associato ad una fattura dal campo corrispondente
     * @param quantita la quantita di un servizio associato ad una fattura
     */
    public void setQuantita(JTextField quantita) {
        this.quantita = quantita;
    }

    /**
     * metodo che restuisce l'identificativo del servizio relativo ad una fattura dal campo associato
     * @return l'identificativo del servizio relativo ad una fattura
     */
    public JTextField getServizio() {
        return servizio;
    }

    /**
     * metodo che setta l'identificativo del servizio relativo ad una fattura dal campo associato
     * @param servizio   l'identificativo del servizio relativo ad una fattura
     */
    public void setServizio(JTextField servizio) {
        this.servizio = servizio;
    }
}
