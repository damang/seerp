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
     * costruttore per la classe bean gui pagamento
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
     * metodo che restituisce il campo id del bean gui permesso
     * @return il campo id
     */
    public int getIdPermesso() {
        return idPermesso;
    }

    /**
     * metodo che setta il campo id del bean gui permesso
     * @param pidPermesso
     */
    public void setIdPermesso(int pidPermesso) {
        this.idPermesso = pidPermesso;
    }

    /**
     * metodo che setta il campo act del bean gui permesso
     * @param ppath
     */
    public void setAct(JCheckBox ppath) {
        this.act = ppath;
    }

    /**
     * metodo che restituisce il campo act del bean gui permesso
     * @return il campo act
     */
    public JCheckBox getAct() {
        return act;
    }

    /**
     * metodo che restituisce il campo cat del bean gui permesso
     * @return il campo cat
     */
    public String getCat() {
        return cat;
    }

    /**
     * metodo che setta il campo cat del bean gui permesso
     * @param c
     */
    public void setCat(String c) {
        cat = c;
    }
}