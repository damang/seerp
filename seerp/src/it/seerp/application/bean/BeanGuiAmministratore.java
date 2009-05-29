package it.seerp.application.bean;

import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Ruolo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiAmministratore extends BeanGuiPersonale {



    /**
     * costruttore vuoto per il Bean Gui Amministratore
     */
    public BeanGuiAmministratore() {
        
    }

    /**
     *  Costruttore per la classe Beang Gui Amministratore
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     * @param listPermessi
     * @param listRuoli
     * @param idAmministratoreTxt
     */
    public BeanGuiAmministratore(JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo, ArrayList<BeanGuiPermesso> listPermessi, ArrayList<BeanGuiRuolo> listRuoli, JTextField idAmministratoreTxt) {
        super(idPersonaleTxt, txtCognome, txtNome, txtCodiceFiscale, cmbTipo, listPermessi, listRuoli);
        this.idAmministratoreTxt = idAmministratoreTxt;
    }

   private JTextField idAmministratoreTxt;

   /**
     * metodo che restituisce l'identificatore dell'amministatore dal campo associato
     * @return l'identificatore dell'Amministratore
     */
    public JTextField getIdAmministratoreTxt() {
        return idAmministratoreTxt;
    }

    /**
     *  metodo che permette di settare l'identificatico dell'amministraotre nel campo associato
     * @param idAmministratoreTxt rappresenta l'identificativo dell'Amministratore da inserire
     */
    public void setIdAmministratoreTxt(JTextField idAmministratoreTxt) {
        this.idAmministratoreTxt = idAmministratoreTxt;
    }


}
