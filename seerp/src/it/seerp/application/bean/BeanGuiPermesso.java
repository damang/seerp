package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo
 */
public class BeanGuiPermesso {

    private JTextField idPermesso;
    private JTextField Nome;
    private ArrayList<BeanGuiPersonale> listPersonale;
    private ArrayList<BeanGuiRuolo> listRuolo;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiPermesso(JXPanel c) {
        grafica = c;
    }

    /**
     *
     */
    public BeanGuiPermesso() {
    }

    /**
     *
     * @param idPermesso
     * @param Nome
     * @param listPersonale
     * @param listRuolo
     */
    public BeanGuiPermesso(JTextField idPermesso, JTextField Nome, ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiRuolo> listRuolo) {
        this.idPermesso = idPermesso;
        this.Nome = Nome;
        this.listPersonale = listPersonale;
        this.listRuolo = listRuolo;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPersonale> getListPersonale() {
        return listPersonale;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiRuolo> getListRuolo() {
        return listRuolo;
    }

    /**
     *
     * @param listPersonale
     */
    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }

    /**
     *
     * @param listRuolo
     */
    public void setListRuolo(ArrayList<BeanGuiRuolo> listRuolo) {
        this.listRuolo = listRuolo;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return Nome;
    }

    /**
     *
     * @return
     */
    public JTextField getIdPermesso() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idPermesso;
    }

    /**
     *
     * @param pNome
     */
    public void setNome(JTextField pNome) {
        this.Nome = pNome;
        val = new NotEmptyValidator(grafica, Nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     *
     * @param pidPermesso
     */
    public void setIdPermesso(JTextField pidPermesso) {
        this.idPermesso = pidPermesso;
        val = new NotEmptyValidator(grafica, idPermesso, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     *
     * @param c
     */
    public void removePersonale(BeanGuiPersonale c) {
        listPersonale.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addPersonale(BeanGuiPersonale c) {
        listPersonale.add(c);
    }

    /**
     *
     * @param c
     */
    public void removeRuolo(BeanGuiRuolo c) {
        listRuolo.remove(c);
    }

    /**
     * 
     * @param c
     */
    public void addRuolo(BeanGuiRuolo c) {
        listRuolo.add(c);
    }
}
