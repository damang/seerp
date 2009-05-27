/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

/**
 * classe che modella le informazione sull'Azienda
 * @author Luisa
 */
public class Azienda {

    private String città;
    private String email;
    private String fax;
    private String inidirizzo;
    private String nazione;
    private String pIVA;
    private String ragioneSociale;
    private String telefono;
    private int idAzienda;
    private String note;

    public Azienda(String città, String email, String fax, String inidirizzo, String nazione, String pIVA, String ragioneSociale, String telefono, int idAzienda) {
        this.città = città;
        this.email = email;
        this.fax = fax;
        this.inidirizzo = inidirizzo;
        this.nazione = nazione;
        this.pIVA = pIVA;
        this.ragioneSociale = ragioneSociale;
        this.telefono = telefono;
        this.idAzienda = idAzienda;
    }

    

    /**
     * il metodo che  restituisce  note dell'azienda
     * @return note di tipo string
     */
    public String getNote() {
        return note;
    }

    /**
     * il metodo che setta le note dell'azienda
     * @param note dell'azienda
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * il metodo che restituisce la città dell'Azienda
     * @return : città dell'Azienda
     */
    public String getCittà() {
        return città;
    }

    /**
     * il metodo che setta la città dell'Azienda
     * @param citta città dell'Azienda
     */
    public void setCittà(String città) {
        this.città = città;
    }

    /**
     *
     *il metodo che restituisce l'email dell'Azienda
     * @return email dell'Azienda
     */
    public String getEmail() {
        return email;
    }

    /**
     * il metodo che setta l'email dell'Azienda
     * @param email email dell'Azienda
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * il metodo che restituisce il fax dell'Azienda
     * @return :fax dell'Azienda
     */
    public String getFax() {
        return fax;
    }

    /**
     *  il metodo che setta il fax dell'Azienda
     * @param fax fax dell'Azienda
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *
     *il metodo che restituisce identificativo univoco dell'Azienda
     * @return : identificativo dell'Azienda
     */
    public int getIdAzienda() {
        return idAzienda;
    }

    /**
     *il metodo che setta l'identificativo dell'Azienda
     * @param idAzienda identificativo dell'Azienda
     */
    public void setIdAzienda(int idAzienda) {
        this.idAzienda = idAzienda;
    }

    /**
     *il metodo che restituisce l'indirizzo dell'Azienda
     * @return: indirizzo dell'Azienda
     */
    public String getInidirizzo() {
        return inidirizzo;
    }

    /**
     *il metodo che setta l'indirizzo dell'Azienda
     * @param indirizzo l'indirizzo dell'Azienda
     */
    public void setInidirizzo(String inidirizzo) {
        this.inidirizzo = inidirizzo;
    }

    /**
     *il metodo che restituisce la nazione dell'Azienda
     * @return: nazione dell'Azienda
     */
    public String getNazione() {
        return nazione;
    }

    /**
     *il metodo che setta la nazione dell'Azienda
     * @param nazione nazione dell'Azienda
     */
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    /**
     * il metodo che restituisce la partita Iva dell'Azienda
     * @return: partita Iva dell'Azienda
     */
    public String getPartitaIVA() {
        return pIVA;
    }

    /**
     *il metodo che setta la partita IVA dell'Azienda
     * @param pIva partita iva dell'azienda
     */
    public void setPartitaIVA(String partitaIVA) {
        this.pIVA = partitaIVA;
    }

    /**
     *
     *il metodo che restituisce la ragione sociale dell'Azienda
     * @return ragioneSociale ragione sociale dell'azienda
     */
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    /**
     *il metodo che setta la ragione sociale dell'Azienda
     * @param  ragioneSociale ragione sociale dell'azienda
     */
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    /**
     *
     *il metodo che restituisce la città dell'Azienda
     * @return : citta  dell'azienda
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *il metodo che setta il telefono dell'Azienda
     * @param telefono telefono  dell'azienda
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
