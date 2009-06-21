package it.seerp.application.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi;
    private JTextField nome;
    private HashMap<String,JCheckBox> perm_all;
    private JXTable tabRuo;

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
        this.nome = nome;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public JTextField getNome() {
        /*  if (!valStartW.shouldYieldFocus(grafica)) {
        throw new ValidatorException("Errore nella grafica!");
        }*/
        return nome;
    }

    public void resetAll() {
        nome.setText("");
        Iterator<ArrayList<BeanGuiPermesso>> l = listPermessi.values().iterator();
        ArrayList<BeanGuiPermesso> ar;

        while (l.hasNext()) {
            ar = l.next();
            for (int i = 0; i < ar.size(); i++) {
                ar.get(i).getAct().setSelected(false);
            }
        }
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
//        valStartW = new StartWithValidator(grafica, nome, "Il campo non può essere vuoto.");
    //      grafica.setInputVerifier(valStartW);
    }

    /**
     *
     * @return
     */
    public HashMap<String, ArrayList<BeanGuiPermesso>> getListPermessi() {
        return listPermessi;
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiPersonale> getListPersonale() {
        return listPersonale;
    }

    /**
     * 
     * @param listPermessi
     */
    public void setListPermessi(HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     *
     * @param listPersonale
     */
    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }
    public HashMap<String, JCheckBox> getPermGen() {
        return perm_all;
    }
    public void setPermGen(HashMap<String, JCheckBox> p) {
        perm_all=p;
    }
    public JXTable getTabUt() {
        return  tabRuo;
    }
    public void setTabUt(JXTable t) {
        tabRuo=t;
    }
}
