package it.seerp.application.bean;

import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiPersonale extends BeanGuiUtente {

    private JTextField idPersonaleTxt;
    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtCodiceFiscale;
    private JComboBox cmbTipo;
    private ArrayList<BeanGuiRuolo> listRuoli;
    private JXPanel grafica;
    private NotEmptyValidator val;
    private NotEqualLengthValidator valEqLen;
    private NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiPersonale(JXPanel c) {
        grafica = c;
    }

    /**
     * 
     */
    public BeanGuiPersonale() {
    }

    /**
     *
     * @param idUtenteTxt
     * @param txtUsername
     * @param txtPassword
     * @param txtCittà
     * @param txtProvincia
     * @param txtTelefono
     * @param txtEmail
     * @param txtNote
     * @param txtNotifica
     * @param Ruolo
     * @param visible
     * @param idPersonaleTxt
     * @param txtCognome
     * @param txtNome
     * @param txtCodiceFiscale
     * @param cmbTipo
     */
    public BeanGuiPersonale(JTextField idUtenteTxt, JTextField txtUsername, JTextField txtPassword, JTextField txtCittà, JTextField txtProvincia, JTextField txtTelefono, JTextField txtEmail, JTextArea txtNote, JTextField txtNotifica, JTextField Ruolo, JTextField visible, JTextField idPersonaleTxt, JTextField txtCognome, JTextField txtNome, JTextField txtCodiceFiscale, JComboBox cmbTipo) {
        super(idUtenteTxt, txtUsername, txtPassword, txtCittà, txtProvincia, txtTelefono, txtEmail, txtNote, txtNotifica, Ruolo, visible);
        this.idPersonaleTxt = idPersonaleTxt;
        this.txtCognome = txtCognome;
        this.txtNome = txtNome;
        this.txtCodiceFiscale = txtCodiceFiscale;
        this.cmbTipo = cmbTipo;
        this.listRuoli= new ArrayList<BeanGuiRuolo>();
    }

   

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiRuolo> getListRuoli() {
        return listRuoli;
    }

  

    /**
     *
     * @param listRuoli
     */
    public void setListRuoli(ArrayList<BeanGuiRuolo> listRuoli) {
        this.listRuoli = listRuoli;
    }

    /**
     *
     * @return
     */
    public JTextField getCodiceFiscale() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valEqLen.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtCodiceFiscale;
    }

    /**
     *
     * @return
     */
    public JTextField getCognome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtCognome;
    }

    /**
     *
     * @return
     */
    public JTextField getIdPersonale() {
        return idPersonaleTxt;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtNome;
    }

    

    /**
     * 
     * @param pcodiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.txtCodiceFiscale = pcodiceFiscale;
        val = new NotEmptyValidator(grafica, txtCodiceFiscale, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valEqLen = new NotEqualLengthValidator(grafica, txtCodiceFiscale, "Il campo deve essere di 16 caratteri", 16);
        grafica.setInputVerifier(valEqLen);

    }

    /**
     *
     * @param pcognome
     */
    public void setCognome(JTextField pcognome) {
        this.txtCognome = pcognome;
        val = new NotEmptyValidator(grafica, txtCognome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, txtCognome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     *
     * @param idPersonale
     */
    public void setIdPersonale(JTextField idPersonale) {
        this.idPersonaleTxt = idPersonale;
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.txtNome = pnome;
        val = new NotEmptyValidator(grafica, txtNome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, txtNome, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(JComboBox tipo) {
        this.cmbTipo = tipo;
    }


     /**
      * 
      * @param c 
      */
     public void removeRuolo(BeanGuiRuolo c){
     listRuoli.remove(c);}

     /**
      *
      * @param c 
      */
     public void addRuolo(BeanGuiRuolo c){
     listRuoli.add(c);}
}
