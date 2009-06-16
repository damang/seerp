package it.seerp.application.bean;

import configurazioni.PermessiDefault;
import configurazioni.PermessiDefault.Categoria_Permesso;
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
     */
    public BeanGuiPermesso(JXPanel c) {
        grafica = c;
    }

    /**
     *
     */
    public BeanGuiPermesso() {
    }

    public BeanGuiPermesso(JCheckBox path, int id, String cat) {
        this.act = path;
        this.idPermesso=id;
        this.cat=cat;
    }

    /**
     *
     * @return
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

    public void setAct(JCheckBox ppath) {
        this.act = ppath;
    //    val = new NotEmptyValidator(grafica, path, "Il campo non può eseere vuoto.");
      //  grafica.setInputVerifier(val);
    }

   public JCheckBox getAct() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return act;
    }
   public String getCat() {
        return cat;
    }
   public void setCat(String c) {
        cat=c;
    }
}