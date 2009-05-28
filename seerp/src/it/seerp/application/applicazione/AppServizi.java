package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.interfacce.GestioneServizi;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Classe del livello application riguardante la Gestione dei Servizi
 * @author Tommaso Cattolico
 */
public class AppServizi implements GestioneServizi<BeanGuiServizio>
{

    /**
     * Metodo che permette di visualizzare l'elenco dei servizi
     * @return ArrayList contenente i servizi
     */
    public ArrayList<BeanGuiServizio> elenca() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la ricerca di un servizio
     * @param nome
     * nome del servizio
     * @return ArrayList con i servizi che corrispondono al nome inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produce risultati
     */
    public ArrayList<BeanGuiServizio> ricerca(JTextField nome) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette l'inserimento di un nuovo servizio
     * @param BeansGuiServizio
     * Bean Gui del servizio da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    public void inserisci(BeanGuiServizio BeansGuiServizio) throws DatiErrati, DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la visualizzazione di un servizio
     * @param nome
     * nome del servizio
     * @return Bean Gui del servizio da visualizzare
     */
    public BeanGuiServizio visualizza(JTextField nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la modifica di un servizio
     * @param BeansGuiServizio
     * Bean Gui del Servizio da mofidicare
     * @return Bean Gui del servizio modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati durante la modifica
     */
    public BeanGuiServizio modifica(BeanGuiServizio BeansGuiServizio) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
