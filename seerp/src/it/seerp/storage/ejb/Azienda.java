package it.seerp.storage.ejb;

/**
 * classe che modella le informazioni sull'Azienda
 * @author Luisa-Matteo
 */
public class Azienda {

    private String citta;
    private String email;
    private String fax;
    private String indirizzo;
    private String nazione;
    private String pIVA;
    private String ragioneSociale;
    private String telefono;
    private int idAzienda;
    private String note;
    private Amministratore amministratore;

    public Azienda() {
        
    }

    /**
     * costruttore per la classe Azienda
     * @param città
     * @param email
     * @param fax
     * @param indirizzo
     * @param nazione
     * @param pIVA
     * @param ragioneSociale
     * @param telefono
     * @param idAzienda
     */
    public Azienda(String citta, String email, String fax, String inidirizzo, String nazione, String pIVA, String ragioneSociale, String telefono, int idAzienda) {
        this.citta = citta;
        this.email = email;
        this.fax = fax;
        this.indirizzo = indirizzo;
        this.nazione = nazione;
        this.pIVA = pIVA;
        this.ragioneSociale = ragioneSociale;
        this.telefono = telefono;
        this.idAzienda = idAzienda;
    }

    /**
     * metodo che restituisce le informazioni dell'amministratore dell'azienda
     * @return le informazioni dell'amministratore
     */
    public Amministratore getAmministratore() {
        return amministratore;
    }

    /**
     * metodo che restituisce le informazioni relative alla partita iva dell'azienda
     * @return la partita ida dell'azienda
     */
    public String getPIVA() {
        return pIVA;
    }

    /**
     * metodo che permette di settare le informazioni relative all'amministratore dell'azienda
     * @param amministratore rappresenta le informazioni dell'amministratore
     */
    public void setAmministratore(Amministratore amministratore) {
        this.amministratore = amministratore;
    }

    /**
     * metodo che permette di settare le informazioni della partita iva dell'azienda
     * @param pIVA rappresenta la partita iva
     */
    public void setPIVA(String pIVA) {
        this.pIVA = pIVA;
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
    public String getCitta() {
        return citta;
    }

    /**
     * il metodo che setta la città dell'Azienda
     * @param città
     */
    public void setCitta(String citta) {
        this.citta = citta;
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
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     *il metodo che setta l'indirizzo dell'Azienda
     * @param inidirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
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
