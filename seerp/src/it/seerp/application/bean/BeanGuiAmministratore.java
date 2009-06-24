package it.seerp.application.bean;

/**
 * Classe relativa ai componenti grafici della gestione dell'Amministratore
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiAmministratore extends BeanGuiPersonale {

    private BeanGuiAzienda azienda;

    /**
     * costruttore vuoto per il Bean Gui Amministratore
     */
    public BeanGuiAmministratore() {
    }

    /**
     * 
     * @return
     */
    public BeanGuiAzienda getAzienda() {
        return azienda;
    }

    /**
     *
     * @param azienda
     */
    public void setAzienda(BeanGuiAzienda azienda) {
        this.azienda = azienda;
    }
}
