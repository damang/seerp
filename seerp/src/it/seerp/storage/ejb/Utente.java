package it.seerp.storage.ejb;

/**
 * classe per la gestione del bean Utente
 * @author matteo
 */
public class Utente {

    private Integer idUtente;
    private String username;
    private String password;
    private String città;
    private String provincia;
    private String telefono;
    private String email;
    private String note;
    private String ruolo;
    private Boolean visible;


    /**
     * costruttore vuoto
     */
    public Utente() {
    }

    /**
     * costruttore per la classe Utente
     * @param idUtente
     * @param username
     * @param password
     * @param città
     * @param provincia
     * @param telefono
     * @param email
     * @param ruolo
     * @param note
     * @param v
     */
    public Utente(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String ruolo, String note, Boolean v) {
        this.idUtente = idUtente;
        this.username = username;
        this.password = password;
        this.città = città;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.note = note;
        this.ruolo = ruolo;
        this.visible = v;
    }


    /**
     * metodo che restituisce la visibilita dell utente
     * @return la visibilita dell'utente
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * metodo che setta la visibilita dell utente
     * @param visible
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * metodo che restituisce la visibilita dell utente
     * @return la visibilita dell'utente
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * ritorne le note inserite
     * @return una string contentente le note
     */
    public String getNote() {
        return note;
    }

    /**
     * setta le note per l'utente
     * @param note di tipo stringa
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * restituisce la città dove l'utente risiede
     * @return una stringa contente la città
     */
    public String getCittà() {
        return città;
    }

    /**
     * restituisce l'email dell'utente
     * @return una stringa con l'indirizzo e-mail dell'utente
     */
    public String getEmail() {
        return email;
    }

    /**
     * restituisce il codice identificativo dell'utente
     * @return un numero che identifica l'utente
     */
    public Integer getIdUtente() {
        return idUtente;
    }

    /**
     * restituisce la password che l'utente ha settato per effettuare la login
     * @return una stinga contente la password
     */
    public String getPassword() {
        return password;
    }

    /**
     * restituisce la provincia di residenza dell'utente
     * @return una stringa contente la provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * restitutisce il recapito telefonico di un utente
     * @return una stringa contente il numero di telefono dell'utente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * restituisce l'username che l'utente ha settato per effettuare il login
     * @return sitnga contenente l'username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setta il ruolo dell'utente
     * @param ruolo di tipo stringa
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * setta la città di residenza dell'utente
     * @param città di tipo stringa
     */
    public void setCittà(String città) {
        this.città = città;
    }

    /**
     *setta l'e-mail dell'utente
     * @param email di tipo stringa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setta il codice identificativo dell'utente
     * @param idUtente di tipo int
     */
    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    /**
     *setta la password dell'utente
     * @param password di tipo stringa
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *setta la provincia di residenza dell'utente
     * @param provincia di tipo stringa
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * setta il numero telefonico dell'utente
     * @param telefono di tipo stringa
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * setta l'username dell'utente
     * @param username di tipo stringa
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
