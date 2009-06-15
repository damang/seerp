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
    private JTextField action;
    private JTextField path;
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

    public BeanGuiPermesso(JTextField idPermesso, JTextField action, JTextField path) {
        this.idPermesso = idPermesso;
        this.action = action;
        this.path = path;
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
     * @param pidPermesso
     */
    public void setIdPermesso(JTextField pidPermesso) {
        this.idPermesso = pidPermesso;
        val = new NotEmptyValidator(grafica, idPermesso, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    public void setAction(JTextField action) {
        this.action = action;
        val = new NotEmptyValidator(grafica, action,"il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

   
    public void setPath(JTextField path) {
        this.path = path;
        val = new NotEmptyValidator(grafica, path,"il campo non può eseere vuoto.");
        grafica.setInputVerifier(val);
    }

    public JTextField getAction() throws Exception {
          if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return action;
    }

  

    public JTextField getPath() throws Exception {
          if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return path;
    }

}