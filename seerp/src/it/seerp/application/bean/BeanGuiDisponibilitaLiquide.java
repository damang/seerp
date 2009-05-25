/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.application.bean;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * classe che gestisce i componenti grafici relativi alle disponibilita liquide
 * @author Luisa
 */
public class BeanGuiDisponibilitaLiquide {

    private JTextField importo;
    private JTextField tipo;
    private JTextArea note;
    private JTextField idDisponibilitaLiquide;
    private JTextField idPagamento;

    /**
     * metodo che restituisce l'identificativo delle disponibilita liquide dal campo associato
     * @return l'identificativo delle disponibilita liquide
     */
    public JTextField getIdDisponibilitaLiquide() {
        return idDisponibilitaLiquide;
    }

    /**
     *  metodo che setta l'identificativo delle disponibilita liquide dal campo associato
     * @param idDisponibilitaLiquide l'identificativo delle disponibilita liquide
     */
    public void setIdDisponibilitaLiquide(JTextField idDisponibilitaLiquide) {
        this.idDisponibilitaLiquide = idDisponibilitaLiquide;
    }

    /**
     * metodo che restituisce l'identificativo del pagamento relativo alle disponibilita liquide dal campo associato
     * @return l'identificativo del pagamento relativo alle disponibilita liquide dal campo associato
     */
    public JTextField getIdPagamento() {
        return idPagamento;
    }

    /**
     * metodo che setta l'identificativo del pagamento relativo alle disponibilita liquide dal campo associato
     * @param idPagamento l'identificativo del pagamento relativo alle disponibilita liquide dal campo associato
     */
    public void setIdPagamento(JTextField idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * metodo che restituisce l'importo delle disponibilita liquide dal campo associato
     * @return l'importo delle disponibilita liquide
     */
    public JTextField getImporto() {
        return importo;
    }

    /**
     * metodo che setta l'importo delle disponibilita liquide dal campo associato
     * @param importo l'importo delle disponibilita liquide
     */
    public void setImporto(JTextField importo) {
        this.importo = importo;
    }

    /**
     * metodo che setta le note delle disponibilita liquide dalla text area associata
     * @return le note delle disponibilita liquide 
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta le note delle disponibilita liquide dalla text area associata
     * @param note le note delle disponibilita liquide dalla
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il tipo della disponibilita liquida  dal campo associato
     * @return il tipo della disponibilita liquida
     */
    public JTextField getTipo() {
        return tipo;
    }

    /**
     * metodo che il tipo della disponibilita liquida  dal campo associato
     * @param tipo il tipo della disponibilita liquida
     */
    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }
}
