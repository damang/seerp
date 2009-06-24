package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dell'Azienda
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiAzienda {

    private JTextField citta;
    private JTextField email;
    private JTextField fax;
    private JTextField inidirizzo;
    private JTextField nazione;
    private JTextField pIVA;
    private JTextField ragioneSociale;
    private JTextField telefono;
    private JTextField idAzienda;
    private JTextField note;
    private BeanGuiAmministratore amministratore;

    /**
     *  Costruttore vuoto
     */
    public BeanGuiAzienda() {
    }

    /**
     *
     * @param citta
     */
    public void setCitta(JTextField citta) {
        this.citta = citta;
    }

    /**
     *
     * @param email
     */
    public void setEmail(JTextField email) {
        this.email = email;
    }

    /**
     *
     * @param fax
     */
    public void setFax(JTextField fax) {
        this.fax = fax;
    }

    /**
     *
     * @param idAzienda
     */
    public void setIdAzienda(JTextField idAzienda) {
        this.idAzienda = idAzienda;
    }

    /**
     *
     * @param inidirizzo
     */
    public void setInidirizzo(JTextField inidirizzo) {
        this.inidirizzo = inidirizzo;
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
     * @param note
     */
    public void setNote(JTextField note) {
        this.note = note;
    }

    /**
     *
     * @param pIVA
     */
    public void setPIVA(JTextField pIVA) {
        this.pIVA = pIVA;
    }

    /**
     *
     * @param ragioneSociale
     */
    public void setRagioneSociale(JTextField ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @param amministratore
     */
    public void setAmministratore(BeanGuiAmministratore amministratore) {
        this.amministratore = amministratore;
    }


    /**
     *
     * @return
     */
    public BeanGuiAmministratore getAmministratore() {
        return amministratore;
    }

    /**
     *
     * @return
     */
    public JTextField getCitta() {
        return citta;
    }

    /**
     *
     * @return
     */
    public JTextField getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public JTextField getFax() {
        return fax;
    }

    /**
     *
     * @return
     */
    public JTextField getIdAzienda() {
        return idAzienda;
    }

    /**
     *
     * @return
     */
    public JTextField getInidirizzo() {
        return inidirizzo;
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
    public JTextField getNote() {
        return note;
    }

    /**
     *
     * @return
     */
    public JTextField getPIVA() {
        return pIVA;
    }

    /**
     *
     * @return
     */
    public JTextField getRagioneSociale() {
        return ragioneSociale;
    }

    /**
     *
     * @return
     */
    public JTextField getTelefono() {
        return telefono;
    }


}


