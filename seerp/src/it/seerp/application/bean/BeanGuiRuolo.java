package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private ArrayList<BeanGuiPermesso> listPermessi;
    private JTextField nome;
    private JTextField idRuolo;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiRuolo(JXPanel c) {
        grafica = c;
    }

    /**
     *
     */
    public BeanGuiRuolo() {
    }

    /**
     *
     * @param idRuolo
     * @param nome
     * @param listPersonale
     * @param listPermessi
     */
    public BeanGuiRuolo(JTextField idRuolo, JTextField nome, ArrayList<BeanGuiPersonale> listPersonale, ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPersonale = listPersonale;
        this.listPermessi = listPermessi;
        this.nome = nome;
        this.idRuolo = idRuolo;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
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
     * @param listPermessi
     */
    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
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
     * @return
     */
    public JTextField getIdRuolo() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idRuolo;
    }

    /**
     *
     * @return
     */
    public JTextField getNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return nome;
    }

    /**
     *
     * @param pidRuolo
     */
    public void setIdRuolo(JTextField pidRuolo) {
        this.idRuolo = pidRuolo;
        val = new NotEmptyValidator(grafica, idRuolo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        val = new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.");
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
    public void removePermesso(BeanGuiPermesso c) {
        listPermessi.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addPermesso(BeanGuiPermesso c) {
        listPermessi.add(c);
    }
}
