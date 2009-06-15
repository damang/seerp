package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiIncarico {

    private BeanGuiRuolo ruolo;
    private ArrayList<BeanGuiPermesso> listPermessi;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiIncarico(JXPanel c) {
        grafica = c;
    }

    
    /**
     *
     */
    public BeanGuiIncarico() {
        this.listPermessi= new ArrayList<BeanGuiPermesso>();
         }

    /**
     *
     * @param listPermessi
     */
    public void setListPermessi(ArrayList<BeanGuiPermesso> listPermessi) {
        this.listPermessi = listPermessi;
    }


    
    /**
     *
     * @param pRuolo
     */
    public void setRuolo(BeanGuiRuolo pRuolo) {
        this.ruolo = pRuolo;
       }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPermesso> getListPermessi() {
        return listPermessi;
    }

    /**
     *
     * @return
     */
    public BeanGuiRuolo getRuolo() {
        return ruolo;
    }

    /**
     *
     * @param c
     */
    public void removePermesso(BeanGuiPermesso c){
     listPermessi.remove(c);
    }


    /**
     *
     * @param c
     */
    public void addPermesso(BeanGuiPermesso c){
      listPermessi.add(c);
    }

}
