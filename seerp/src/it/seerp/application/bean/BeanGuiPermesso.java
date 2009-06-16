package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo
 */
public class BeanGuiPermesso {

    private JCheckBox path;
    private int idPermesso;
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

    public BeanGuiPermesso(JCheckBox path, int id) {
        this.path = path;
        this.idPermesso=id;
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

    public void setPath(JCheckBox ppath) {
        this.path = ppath;
    //    val = new NotEmptyValidator(grafica, path, "Il campo non può eseere vuoto.");
      //  grafica.setInputVerifier(val);
    }

   public JCheckBox getPath() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return path;
    }
}