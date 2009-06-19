package it.seerp.application.bean;

import javax.swing.JCheckBox;
import org.jdesktop.swingx.JXPanel;

/**
 * Classe relativa ai componenti grafici della gestione Permesso
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiPermesso {

    private JCheckBox act;
    private int idPermesso;
    private String cat;
    private JXPanel grafica;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
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
     * @param path
     * @param id
     * @param cat
     */
    public BeanGuiPermesso(JXPanel c, JCheckBox act, int id, String cat) {
        this(c);
        this.act = act;
        this.idPermesso = id;
        this.cat = cat;
    }

    public BeanGuiPermesso(JCheckBox path, int id, String cat) {
        this(null);
        this.act = path;
        this.idPermesso = id;
        this.cat = cat;
    }

    public BeanGuiPermesso(JXPanel c, JCheckBox path, String cat) {
        this(c);
        this.act = path;
        this.idPermesso = -1;
        this.cat = cat;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public int getIdPermesso() throws Exception {
        /*   if (!val.shouldYieldFocus(grafica)) {
        throw new Exception("Errore nella grafica!");
        }*/
        return idPermesso;
    }

    /**
     *
     * @param pidPermesso
     */
    public void setIdPermesso(int pidPermesso) {
        this.idPermesso = pidPermesso;
    }

    /**
     *
     * @param ppath
     */
    public void setAct(JCheckBox ppath) {
        this.act = ppath;
    //    val = new NotEmptyValidator(grafica, path, "Il campo non può eseere vuoto.");
    //  grafica.setInputVerifier(val);
    }

    /**
     *
     * @return
     * @throws java.lang.Exception
     */
    public JCheckBox getAct() throws Exception {
        /*     if (!val.shouldYieldFocus(grafica)) {
        throw new Exception("Errore nella grafica!");
        }*/
        return act;
    }

    /**
     *
     * @return
     */
    public String getCat() {
        return cat;
    }

    /**
     *
     * @param c
     */
    public void setCat(String c) {
        cat = c;
    }
}