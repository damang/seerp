package it.seerp.application.bean;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * Classe relativa ai componenti grafici della gestione del Dipendente
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;

    /**
     * Costruttore vuoto per la classe Bean Gui Personale
     */
    public BeanGuiDipendente() {
    }

    public BeanGuiDipendente(JXPanel c) {
        super(c);
    }

    /**
     *
     * @param idUtenteTxt
     * @param txtUsername
     * @param txtPassword
     * @param txtCitta
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param tipo
     * @param visible
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param ruolo
     */
    public BeanGuiDipendente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCitta, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField codiceFiscale, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCitta, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible, cognome, nome, codiceFiscale, ruolo);
    }

    /**
     * metodo che restituisce la lista degli appuntamenti che un Personale deve ricevere
     * @return la lista degli appuntamenti
     */
    public ArrayList<BeanGuiAppuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * metodo che restituisce la lista dei contratti che un Personale ha stipulato
     * @return la lista dei contratti
     */
    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    /**
     * metodo che setta la lista degli appuntamenti di un Personale
     * @param listAppuntamenti rappresenta la lista degli appuntamenti da inserire
     */
    public void setListAppuntamenti(ArrayList<BeanGuiAppuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    /**
     * metodo che setta la lista dei contratti di un Personale
     * @param listContratti rappresenta la lista dei contratti da inserire
     */
    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
    }

    /**
     *
     * @param c
     */
    public void removeAppuntamento(BeanGuiAppuntamento c) {
        listAppuntamenti.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addAppuntamento(BeanGuiAppuntamento c) {
        listAppuntamenti.add(c);
    }

    /**
     *
     * @param c
     */
    public void removeContratto(BeanGuiContratto c) {
        listContratti.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addContratto(BeanGuiContratto c) {
        listContratti.add(c);
    }
}
