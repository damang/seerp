package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiDipendente(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto per la classe Bean Gui Personale
     */
    public BeanGuiDipendente() {
    }

    public BeanGuiDipendente(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField tipo, JTextField visible, JTextField cognome, JTextField nome, JTextField codiceFiscale, JTextField ruolo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, tipo, visible, cognome, nome, codiceFiscale, ruolo);
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
    public void removeAppuntamento(BeanGuiAppuntamento c){
     listAppuntamenti.remove(c);}


     /**
      *
      * @param c
      */
     public void addAppuntamento(BeanGuiAppuntamento c){
     listAppuntamenti.add(c);}


     /**
      *
      * @param c
      */
     public void removeContratto(BeanGuiContratto c){
     listContratti.remove(c);}


     /**
      * 
      * @param c
      */
     public void addContratto(BeanGuiContratto c){
     listContratti.add(c);}
}
