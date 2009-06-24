package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.tabelle.RuoloTm;
import it.seerp.application.validation.StartWithValidator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author peppe
 */
public class BeanGuiRuolo {

    private ArrayList<BeanGuiPersonale> listPersonale;
    private HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi;
    private JTextField nome;
    private HashMap<String, JCheckBox> perm_all;
    private JXTable tabRuo,  tabPers;
    private Object grafica;
    protected boolean validator=true;

    public boolean isValidator() {
        return validator;
    }

    public void setValidator(boolean validator) {
        this.validator = validator;
    }

    /**
     *
     * @param pannello
     */
    public BeanGuiRuolo(JPanel pannello) {
        this.grafica = pannello;
    }

    /**
     * 
     * @param nome
     */
    public BeanGuiRuolo(JTextField nome) {
        this.nome = nome;
    }

     public BeanGuiRuolo() {

    }

    /**
     *
     * @return
     */
    public JTextField getNome() {
        if (!nome.getInputVerifier().shouldYieldFocus(nome) && validator==true) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return nome;
    }

    /**
     * 
     */
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
     * @throws java.sql.SQLException
     */
    public void resetTableUt() throws SQLException {
        tabRuo.setModel(new RuoloTm());
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        nome.setInputVerifier(new StartWithValidator((JPanel) grafica, nome, "Il campo non può essere vuoto."));
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

    /**
     *
     * @return
     */
    public HashMap<String, JCheckBox> getPermGen() {
        return perm_all;
    }

    /**
     *
     * @param p
     */
    public void setPermGen(HashMap<String, JCheckBox> p) {
        perm_all = p;
    }

    /**
     *
     * @return
     */
    public JXTable getTabUt() {
        return tabRuo;
    }

    /**
     *
     * @param t
     */
    public void setTabUt(JXTable t) {
        tabRuo = t;
    }

    /**
     *
     * @return
     */
    public JXTable getTabPers() {
        return tabPers;
    }

    /**
     *
     * @param t
     */
    public void setTabPers(JXTable t) {
        tabPers = t;
    }
}
