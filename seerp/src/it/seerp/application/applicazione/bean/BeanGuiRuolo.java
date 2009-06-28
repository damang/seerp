package it.seerp.application.applicazione.bean;

import it.seerp.application.configurazioni.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.tabelle.PersonaleTm;
import it.seerp.application.bean.tabelle.RuoloTm;
import it.seerp.application.validation.NotEmptyValidator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
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
    protected boolean validator = false;

    /**
     * metodo che ritorna il campo validator del bean gui ruolo
     * @return il camo validator
     */
    public boolean isValidator() {
        return validator;
    }

    /**
     * metodo che setta il campo validator del bean gui ruolo
     * @param validator
     */
    public void setValidator(boolean validator) {
        this.validator = validator;
        ((NotEmptyValidator) nome.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) nome.getInputVerifier()).reset(nome);
    }

    /**
     * metodo che setta il campo grafica del bean gui ruolo
     * @param pannello
     */
    public BeanGuiRuolo(JPanel pannello) {
        this.grafica = pannello;
    }

    /**
     * metodo che setta il campo nome del bean gui ruolo
     * @param nome
     */
    public BeanGuiRuolo(JTextField nome) {
        this.nome = nome;
    }

    /**
     * costruttore vuoto per il bean gui ruolo
     */
    public BeanGuiRuolo() {
    }

    /**
     * metodo che restituisce il campo nome del bean gui ruolo
     * @return il campo nome
     * @throws ValidatorException lanciata se è presente un errore nella grafica
     */
    public JTextField getNome() throws ValidatorException {
        if (validator == true) {
            if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
                throw new ValidatorException("Il nome inserito non è valido!");
            }
        }
        return nome;
    }

    /**
     * metodo che permette di risettare la grafica del bean gui ruolo
     */
    public void resetAll() {
        try {
            validator = false;

            nome.setText("");
            Iterator<ArrayList<BeanGuiPermesso>> l = listPermessi.values().iterator();
            ArrayList<BeanGuiPermesso> ar;
            while (l.hasNext()) {
                ar = l.next();
                for (int i = 0; i < ar.size(); i++) {
                    ar.get(i).getAct().setSelected(false);
                }
            }
            tabPers.setModel(new PersonaleTm());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(nome, "Errore dal database!!");
        }
    }

    /**
     * metodo che resetta la tabella dei ruoli
     * @throws java.sql.SQLException
     */
    public void resetTableUt() throws SQLException {
        tabRuo.setModel(new RuoloTm());
    }

    /**
     * metodo che setta il campo nome del bean gui ruolo
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        nome.setInputVerifier(new NotEmptyValidator(grafica, nome, "Il nome inserito non è valido!", RegexpDef.valueOf(RegexpDef.VAL.NOME_RUOLO)));
    }

    /**
     * metodo che restituisce la lista dei permessi associati al ruolo
     * @return una lista di permessi
     */
    public HashMap<String, ArrayList<BeanGuiPermesso>> getListPermessi() {
        return listPermessi;
    }

    /**
     * metodo che restituisce la lista del personale associata al ruolo
     * @return una lista di personale
     */
    public ArrayList<BeanGuiPersonale> getListPersonale() {
        return listPersonale;
    }

    /**
     * metodo che permette di settare la lista dei permessi di un ruolo
     * @param listPermessi
     */
    public void setListPermessi(HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi) {
        this.listPermessi = listPermessi;
    }

    /**
     * metodo che permette di settare la lista del personale di un ruolo
     * @param listPersonale
     */
    public void setListPersonale(ArrayList<BeanGuiPersonale> listPersonale) {
        this.listPersonale = listPersonale;
    }

    /**
     * metodo che restituisce la lista di tutte le check box dei permessi
     * @return la lista di check box
     */
    public HashMap<String, JCheckBox> getPermGen() {
        return perm_all;
    }

    /**
     *  metodo che setta la lista deelle check box dei permessi
     * @param p
     */
    public void setPermGen(HashMap<String, JCheckBox> p) {
        perm_all = p;
    }

    /**
     * metodo che setta la tabella dei ruoli del bean gui ruolo
     * @return la tabella dei ruoli
     */
    public JXTable getTabUt() {
        return tabRuo;
    }

    /**
     * metodo che setta la tabella dei ruoli del bean gui ruolo
     * @param t
     */
    public void setTabUt(JXTable t) {
        tabRuo = t;
    }

    /**
     * metodo che restituisce la tabella del personale del bean gui ruolo
     * @return la tabella del personale
     */
    public JXTable getTabPers() {
        return tabPers;
    }

    /**
     * metodo che setta la tabella del personale del bean gui ruolo
     * @param t
     */
    public void setTabPers(JXTable t) {
        tabPers = t;
    }
}
