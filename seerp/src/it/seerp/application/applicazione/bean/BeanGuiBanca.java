package it.seerp.application.applicazione.bean;

import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione della Banca
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiBanca {

    private JTextField agenzia;
    private JTextField abi;
    private JTextField cab;
    private JTextField citta;
    private JTextField provincia;
    private JTextField indirizzo;
    private JTextField cap;
    private JTextField filiale;
    private JTextField nazione;
    private JTextField importoInDare;
    private JTextField importoInAvere;

    /**
     * metodo che restituisce il campo contente l'abi della Banca
     * @return il campo Abi
     */
    public JTextField getAbi() {
        return abi;
    }

    /**
       metodo che restituisce il campo contente l'agenzia della Banca
     * @return il campo Agenzia
     */
    public JTextField getAgenzia() {
        return agenzia;
    }

    /**
     *  metodo che restituisce il campo contente il cab della Banca
     * @return il campo Cab
     */
    public JTextField getCab() {
        return cab;

    }

    /**
     *  metodo che restituisce il campo contente il cap della provincia della Banca
     * @return il campo Cap
     */
    public JTextField getCap() {
        return cap;
    }

    /**
     *  metodo che restituisce il campo contente la città della Banca
     * @return il campo città
     */
    public JTextField getCitta() {
        return citta;
    }

    /**
     *  metodo che restituisce il campo contente la filiale della Banca
     * @return il campo Filiale
     */
    public JTextField getFiliale() {
        return filiale;
    }

    /**
     *  metodo che restituisce il campo contente l'importo in avere della Banca
     * @return il campo importo in avere
     */
    public JTextField getImportoInAvere() {
        return importoInAvere;
    }

    /**
     *  metodo che restituisce il campo contente l'importo in dare della Banca
     * @return il campo importo in avere
     */
    public JTextField getImportoInDare() {
        return importoInDare;
    }

    /**
     *  metodo che restituisce il campo contente l'indirizzo della Banca
     * @return il campo indirizzo
     */
    public JTextField getIndirizzo() {
        return indirizzo;
    }

    /**
     *  metodo che restituisce il campo contente la nazione della Banca
     * @return il campo nazione
     */
    public JTextField getNazione() {
        return nazione;
    }

    /**
     *  metodo che restituisce il campo contente la provincia della Banca
     * @return il campo provincia
     */
    public JTextField getProvincia() {
        return provincia;
    }

    /**
     * metodo che setta il campo contenente l'abi della Banca
     * @param abi che rapprenta il campi abi da inserire
     */
    public void setAbi(JTextField abi) {
        this.abi = abi;
    }

    /**
     * metodo che setta il campo contenente l'agenzia della Banca
     * @param agenzia che rappresenta il campo Agenzia da inserire
     */
    public void setAgenzia(JTextField agenzia) {
        this.agenzia = agenzia;
    }

    /**
     * metodo che setta il campo contenente il cab della Banca
     * @param cab che rappresenta il campo cab da inserire
     */
    public void setCab(JTextField cab) {
        this.cab = cab;
    }

    /**
     * metodo che setta il campo contenente il cap della Banca
     * @param cap che rappresenta il campo cap da inserire
     */
    public void setCap(JTextField cap) {
        this.cap = cap;
    }

    /**
     * metodo che setta il campo contenente la città della Banca
     * @param citta
     */
    public void setCitta(JTextField citta) {
        this.citta = citta;
    }

    /**
     * metodo che setta il campo contenente la filiale della Banca
     * @param filiale che rappresenta il campo filiale da inserire
     */
    public void setFiliale(JTextField filiale) {
        this.filiale = filiale;
    }

    /**
     * metodo che setta il campo contenente l'importo in avere della Banca
     * @param importoInAvere che rappresenta il campo importo in avere  da inserire
     */
    public void setImportoInAvere(JTextField importoInAvere) {
        this.importoInAvere = importoInAvere;
    }

    /**
     * metodo che setta il campo contenente l'importo in dare della Banca
     * @param importoInDare che rappresenta il campo l'importo in dare da inserire
     */
    public void setImportoInDare(JTextField importoInDare) {
        this.importoInDare = importoInDare;
    }

    /**
     * metodo che setta il campo contenente l'indirizzo della Banca
     * @param indirizzo che rappresenta il campo indirizzo da inserire
     */
    public void setIndirizzo(JTextField indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * metodo che setta il campo contenente la nazione della Banca
     * @param nazione che rappresenta il campo nazione da inserire
     */
    public void setNazione(JTextField nazione) {
        this.nazione = nazione;
    }

    /**
     * metodo che setta il campo contenente la provincia della Banca
     * @param provincia che rappresenta il campo provinacia da inserire
     */
    public void setProvincia(JTextField provincia) {
        this.provincia = provincia;
    }
}
