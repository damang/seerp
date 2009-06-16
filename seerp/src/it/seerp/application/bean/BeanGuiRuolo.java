package it.seerp.application.bean;

import it.seerp.application.validation.StartWithValidator;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi;
    private JTextField nome;
    private JXPanel grafica;
    private StartWithValidator valStartW;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
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
     * @param nome
     */
    public BeanGuiRuolo(JTextField nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public JTextField getNome() throws Exception {
        if (!valStartW.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return nome;
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        valStartW = new StartWithValidator(grafica, nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(valStartW);
    }

    /**
     *
     * @return
     */
    public HashMap<String, ArrayList<BeanGuiPermesso>> getListPermessi() {
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
    public void setListPermessi(HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     *
     * @param listPersonale
     */
    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }
}
