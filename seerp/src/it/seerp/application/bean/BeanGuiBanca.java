/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiBanca {

    private JTextField agenzia;
    private JTextField abi;
    private JTextField cab;
    private JTextField città;
    private JTextField provincia;
    private JTextField indirizzo;
    private JTextField cap;
    private JTextField filiale;
    private JTextField nazione;
    private JTextField importoInDare;
    private JTextField importoInAvere;

    public BeanGuiBanca(JTextField agenzia, JTextField abi, JTextField cab, JTextField città, JTextField provincia, JTextField indirizzo, JTextField cap, JTextField filiale, JTextField nazione, JTextField importoInDare, JTextField importoInAvere) {
        this.agenzia = agenzia;
        this.abi = abi;
        this.cab = cab;
        this.città = città;
        this.provincia = provincia;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.filiale = filiale;
        this.nazione = nazione;
        this.importoInDare = importoInDare;
        this.importoInAvere = importoInAvere;
    }

   



    /**
     *
     * @return
     */
    public JTextField getAbi() {
        return abi;
    }

    /**
     *
     * @return
     */
    public JTextField getAgenzia() {
        return agenzia;
    }

    /**
     *
     * @return
     */
    public JTextField getCab() {
        return cab;

    }

    /**
     *
     * @return
     */
    public JTextField getCap() {
        return cap;
    }

    /**
     *
     * @return
     */
    public JTextField getCittà() {
        return città;
    }

    /**
     *
     * @return
     */
    public JTextField getFiliale() {
        return filiale;
    }

    /**
     *
     * @return
     */
    public JTextField getImportoInAvere() {
        return importoInAvere;
    }

    /**
     *
     * @return
     */
    public JTextField getImportoInDare() {
        return importoInDare;
    }

    /**
     *
     * @return
     */
    public JTextField getIndirizzo() {
        return indirizzo;
    }

    /**
     *
     * @return
     */
    public JTextField getNazione() {
        return nazione;
    }

    /**
     *
     * @return
     */
    public JTextField getProvincia() {
        return provincia;
    }

    /**
     *
     * @param abi
     */
    public void setAbi(JTextField abi) {
        this.abi = abi;
    }

    /**
     *
     * @param agenzia
     */
    public void setAgenzia(JTextField agenzia) {
        this.agenzia = agenzia;
    }

    /**
     *
     * @param cab
     */
    public void setCab(JTextField cab) {
        this.cab = cab;
    }

    /**
     *
     * @param cap
     */
    public void setCap(JTextField cap) {
        this.cap = cap;
    }

    /**
     *
     * @param città
     */
    public void setCittà(JTextField città) {
        this.città = città;
    }

    /**
     *
     * @param filiale
     */
    public void setFiliale(JTextField filiale) {
        this.filiale = filiale;
    }

    /**
     *
     * @param importoInAvere
     */
    public void setImportoInAvere(JTextField importoInAvere) {
        this.importoInAvere = importoInAvere;
    }

    /**
     *
     * @param importoInDare
     */
    public void setImportoInDare(JTextField importoInDare) {
        this.importoInDare = importoInDare;
    }

    /**
     *
     * @param indirizzo
     */
    public void setIndirizzo(JTextField indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     *
     * @param nazione
     */
    public void setNazione(JTextField nazione) {
        this.nazione = nazione;
    }

    /**
     *
     * @param provincia
     */
    public void setProvincia(JTextField provincia) {
        this.provincia = provincia;
    }



}
