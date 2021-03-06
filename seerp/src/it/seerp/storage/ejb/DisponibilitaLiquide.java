
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che gestisce le informazioni sulle disponibilità liquide
 * @author Luisa
 */
public class DisponibilitaLiquide {

    private Double importo;
    private String tipo;
    private String note;
    private Integer idDisponibilitaLiquide;
    private Integer idPagamento;
    private ArrayList<Pagamento> listPagamento;

    /**
     * cotruttore
     * @param importo
     * @param tipo
     * @param note
     * @param idDisponibilitaLiquide
     * @param idPagamento
     */
    public DisponibilitaLiquide(Double importo, String tipo, String note, Integer idDisponibilitaLiquide, Integer idPagamento) {
        this.importo = importo;
        this.tipo = tipo;
        this.note = note;
        this.idDisponibilitaLiquide = idDisponibilitaLiquide;
        this.idPagamento = idPagamento;
        this.listPagamento = new ArrayList<Pagamento>();
    }

    /**
     * metodo che restituisce la lista dei pagamenti associai alle diposnibilita liquide
     * @return la lista di pagameni
     */
    public ArrayList<Pagamento> getListPagamento() {
        return listPagamento;
    }

    /**
     * metodo che setta la lista dei pagamenti associai alle diposnibilita liquide
     * @param listPagamento la lista dei pagamenti associai alle diposnibilita liquide
     */
    public void setListPagamento(ArrayList<Pagamento> listPagamento) {
        this.listPagamento = listPagamento;}

    /**
     *  metodo che restituisce l'identificativo del pagamento
     * @return: l'identificativo del pagamento
     */
    public Integer getIdPagamento() {
        return idPagamento;
    }

    /**
     * metodo che setta l'identificativo del pagamento
     * @param idPagamento l'identificativo del pagamento
     */
    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * metodo che restituisce le note delle disponibilita liquide
     * @return :  restituisce le note delle disponibilità liquide
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note delle disponibilita liquide
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * metodo che restutisce l'identificativo delle disponibilità liquide
     * @return :l'identificativo delle disponibilità liquide
     */
    public Integer getIdDisponibilitaLiquide() {
        return idDisponibilitaLiquide;
    }

    /**
     * metodo che setta l'identificativo delle disponibilità liquide
     * @param idDisponibilitaLiquide
     */
    public void setIdDisponibilitaLiquide(Integer idDisponibilitaLiquide) {
        this.idDisponibilitaLiquide = idDisponibilitaLiquide;
    }

    /**
     * metodo che restituisce l'importo delle disponiblità liquide
     * @return: l'importo delle disponiblità liquide
     *
     */
    public Double getImporto() {
        return importo;
    }

    /**
     *  metodo che setta l'importo delle disponbilità liquide
     * @param importo l'importo delle disponiblità liquide
     */
    public void setImporto(Double importo) {
        this.importo = importo;
    }

    /**
     * metodo che restituisce il tipo delle disponibilità liquide
     * @return tipo il tipo delle disponibilità liquide
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo che setta il tipo delle disponibilita liquide
     * @param tipo il tipo delle disponibilità liquide
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   /**
     * metodo che rimuove un pagamento alla lista dei pagamenti
    * @param p pagamento da aggiungere
     */
    public void removePagamento(Pagamento p){
     listPagamento.remove(p);}
   /**
    * metodo che aggiunge un pagamento alla lista dei pagamenti
    * @param p pagamento da aggiungere
    */
   public void addPagamento(Pagamento p){
     listPagamento.add(p);}
}
