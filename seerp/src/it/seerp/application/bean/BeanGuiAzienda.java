package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiAzienda {

    private JTextField città;
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

    public BeanGuiAzienda() {
    }

    

    public BeanGuiAzienda(JTextField città, JTextField email, JTextField fax, JTextField inidirizzo, JTextField nazione, JTextField pIVA, JTextField ragioneSociale, JTextField telefono, JTextField idAzienda, JTextField note, BeanGuiAmministratore amministratore) {
        this.città = città;
        this.email = email;
        this.fax = fax;
        this.inidirizzo = inidirizzo;
        this.nazione = nazione;
        this.pIVA = pIVA;
        this.ragioneSociale = ragioneSociale;
        this.telefono = telefono;
        this.idAzienda = idAzienda;
        this.note = note;
        this.amministratore = amministratore;
    }

    public void setCittà(JTextField città) {
        this.città = città;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public void setFax(JTextField fax) {
        this.fax = fax;
    }

    public void setIdAzienda(JTextField idAzienda) {
        this.idAzienda = idAzienda;
    }

    public void setInidirizzo(JTextField inidirizzo) {
        this.inidirizzo = inidirizzo;
    }

    public void setNazione(JTextField nazione) {
        this.nazione = nazione;
    }

    public void setNote(JTextField note) {
        this.note = note;
    }

    public void setPIVA(JTextField pIVA) {
        this.pIVA = pIVA;
    }

    public void setRagioneSociale(JTextField ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    public void setAmministratore(BeanGuiAmministratore amministratore) {
        this.amministratore = amministratore;
    }


    public BeanGuiAmministratore getAmministratore() {
        return amministratore;
    }

    public JTextField getCittà() {
        return città;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getFax() {
        return fax;
    }

    public JTextField getIdAzienda() {
        return idAzienda;
    }

    public JTextField getInidirizzo() {
        return inidirizzo;
    }

    public JTextField getNazione() {
        return nazione;
    }

    public JTextField getNote() {
        return note;
    }

    public JTextField getPIVA() {
        return pIVA;
    }

    public JTextField getRagioneSociale() {
        return ragioneSociale;
    }

    public JTextField getTelefono() {
        return telefono;
    }


}


