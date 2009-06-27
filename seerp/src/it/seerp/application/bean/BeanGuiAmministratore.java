package it.seerp.application.bean;

/**
 * Classe relativa ai componenti grafici della gestione dell'Amministratore
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiAmministratore extends BeanGuiPersonale {

    private BeanGuiAzienda azienda;

    /**
     * Costruttore vuoto per il Bean Gui Amministratore
     */
    public BeanGuiAmministratore(Object c) {
        super(c);
    }

    /**
     * Metodo che ritorna l'Azienda
     * @return Bean Gui dell'Azienda
     */
    public BeanGuiAzienda getAzienda() {
        return azienda;
    }

    /**
     * Metodo che setta l'Azienda
     * @param azienda Bean Gui dell'Azienda
     */
    public void setAzienda(BeanGuiAzienda azienda) {
        this.azienda = azienda;
    }
}
