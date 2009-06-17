package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.Gui.configurazioni.PermessiDefault.Categoria_Permesso;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo
 */
public class BeanGuiPermesso {

    private JCheckBox act;
    private int idPermesso;
    private String cat;
    private JXPanel grafica;
    private NotEmptyValidator val;

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
    public BeanGuiPermesso(JCheckBox path, int id, String cat) {
        this.act = path;
        this.idPermesso=id;
        this.cat=cat;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public  int getIdPermesso() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
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
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
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
        cat=c;
    }
}