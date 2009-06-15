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

    private BeanGuiPersonale personale;
    private ArrayList<BeanGuiIncarico> listIncarichi;
    private JTextField nome;
    private JXPanel grafica;
    private NotEmptyValidator val;

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
        this.listIncarichi = new ArrayList<BeanGuiIncarico>();
        this.nome = nome;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public JTextField getNome() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
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
        val = new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     *
     * @param c
     */
    public void removeIncarico(BeanGuiIncarico c) {
        listIncarichi.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addIncarico(BeanGuiIncarico c) {
        listIncarichi.add(c);
    }

    /**
     *
     * @return
     */
    public BeanGuiPersonale getPersonale() {
        return personale;
    }

    /**
     *
     * @param personale
     */
    public void setPersonale(BeanGuiPersonale personale) {
        this.personale = personale;
    }

    
}
