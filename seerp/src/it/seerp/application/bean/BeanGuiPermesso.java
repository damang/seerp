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
    private JTextField task;
    private JTextField action;
    private BeanGuiIncarico incarico;
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

    public BeanGuiPermesso(JTextField idPermesso, JTextField task, JTextField action) {
        this.idPermesso = idPermesso;
        this.task = task;
        this.action = action;
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
        val = new NotEmptyValidator(grafica, task,"il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    public void setIncarico(BeanGuiIncarico incarico) {
        this.incarico = incarico;

    }

    public void setTask(JTextField task) {
        this.task = task;
        val = new NotEmptyValidator(grafica, task,"il campo non può eseere vuoto.");
        grafica.setInputVerifier(val);
    }

    public JTextField getAction() throws Exception {
          if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return action;
    }

    public BeanGuiIncarico getIncarico() {
        return incarico;
    }

    public JTextField getTask() throws Exception {
          if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return task;
    }

}