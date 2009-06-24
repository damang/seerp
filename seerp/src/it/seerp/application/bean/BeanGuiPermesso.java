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

    /**
     *
     * @param c
     * @param path
     * @param cat
     */
    public BeanGuiPermesso(JXPanel c, JCheckBox path, String cat) {
        this.act = path;
        this.idPermesso = -1;
        this.cat = cat;
    }

    /**
     *
     * @return
     */
    public int getIdPermesso() {
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
    }

    /**
     *
     * @return
     */
    public JCheckBox getAct() {
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