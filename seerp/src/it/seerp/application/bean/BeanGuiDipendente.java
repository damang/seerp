package it.seerp.application.bean;

import java.util.ArrayList;

/**
 * Classe relativa ai componenti grafici della gestione del Dipendente
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiDipendente extends BeanGuiPersonale {

    private ArrayList<BeanGuiAppuntamento> listAppuntamenti;
    private ArrayList<BeanGuiContratto> listContratti;

    /**
     * Costruttore vuoto per la classe Bean Gui Personale
     */
    public BeanGuiDipendente() {
    }

    /**
     * metodo che restituisce la lista degli appuntamenti che un Personale deve ricevere
     * @return la lista degli appuntamenti
     */
    public ArrayList<BeanGuiAppuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * metodo che restituisce la lista dei contratti che un Personale ha stipulato
     * @return la lista dei contratti
     */
    public ArrayList<BeanGuiContratto> getListContratti() {
        return listContratti;
    }

    /**
     * metodo che setta la lista degli appuntamenti di un Personale
     * @param listAppuntamenti rappresenta la lista degli appuntamenti da inserire
     */
    public void setListAppuntamenti(ArrayList<BeanGuiAppuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    /**
     * metodo che setta la lista dei contratti di un Personale
     * @param listContratti rappresenta la lista dei contratti da inserire
     */
    public void setListContratti(ArrayList<BeanGuiContratto> listContratti) {
        this.listContratti = listContratti;
    }

    /**
     *
     * @param c
     */
    public void removeAppuntamento(BeanGuiAppuntamento c) {
        listAppuntamenti.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addAppuntamento(BeanGuiAppuntamento c) {
        listAppuntamenti.add(c);
    }

    /**
     *
     * @param c
     */
    public void removeContratto(BeanGuiContratto c) {
        listContratti.remove(c);
    }

    /**
     *
     * @param c
     */
    public void addContratto(BeanGuiContratto c) {
        listContratti.add(c);
    }
}
