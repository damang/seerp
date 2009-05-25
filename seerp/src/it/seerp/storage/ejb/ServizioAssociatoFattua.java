/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

/**
 * classe che contiene le informazione sui servizi associati ad una fattura
 * @author Luisa
 */
public class ServizioAssociatoFattua {

    private Integer quantita;
    private Integer servizio;
    private Integer fattura;
    private Integer contratto;
        private String note;



    /**
     * metodo che restutisce l'id del contratto a cui sono associati dei servizi di una determinata fattura
     * @return l'id del contratto a cui sono associati dei servizi di una determinata fattura
     */
    public Integer getContratto() {
        return contratto;
    }

    /**
     * metodo che setta l'id del contratto a cui sono associati dei servizi di una determinata fattura
     * @param contratto l'id del contratto a cui sono associati dei servizi di una determinata fattura
     */
    public void setContratto(Integer contratto) {
        this.contratto = contratto;
    }
  
    /**
     *  metodo che restituisce l'id della fattura alla quale sono associati determinati servizi di un contratto
     * @return  l'id della fattura alla quale sono associati determinati servizi di un contratto

     */
    public Integer getFattura() {
        return fattura;
    }

    /**
     *  metodo che setta della fattura alla quale sono associati determinati servizi di un contratto
     * @param Fattura_idFattura l'id della fattura alla quale sono associati determinati servizi di un contratto
     */
    public void setFattura(Integer Fattura_idFattura) {
        this.fattura = Fattura_idFattura;
    }

    /**
     *  metodo che restituisce l'identificativo del servizio associati a quella fattura in un determinato contratto
     * @return 'identificativo del servizio associati a quella fattura in un determinato contratto
     */
    public Integer getServizio() {
        return servizio;
    }

    /**
     *  metodo che setta 'identificativo del servizio associati a quella fattura in un determinato contratto
     * @param ServizioAssociato_idServizioAssociato 'identificativo del servizio associati a quella fattura in un determinato contratto
     */
    public void setServizio(Integer ServizioAssociato_idServizioAssociato) {
        this.servizio = ServizioAssociato_idServizioAssociato;
    }

    /**
     *  metodo che restituisce le note del servizio associato ad una fattura
     * @return note le note del servizio associato ad una fattura
     */
    public String getNote() {
        return note;
    }

    /**
     *  metodo che setta le note del servizio associato ad una fattura
     * @param note le note del servizio associato ad una fattura
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *  metodo che restituisce la quantità di un servizio associato ad una fattura
     * @return la quantità di un servizio associato ad una fattura
     */
    public Integer getQuantita() {
        return quantita;
    }

    /**
     *  metodo che setta la quantita di un servizio associato ad una fattura
     * @param quantita la quantità di un servizio associato ad una fattura
     */
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
