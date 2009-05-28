package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.interfacce.GestioneContratti;
import java.util.ArrayList;
import javax.swing.JTextField;


/**
 * Classe del livello application riguardante la Gestione dei Contratti
 * @author Tommaso Cattolico
 */
public class AppContratti implements GestioneContratti<BeanGuiContratto>
{
    /**
     * Metodo che permette la visualizzazione della lista dei contratti
     * @return ArrayList dei contratti presenti nel sistema
     */
    public ArrayList<BeanGuiContratto> visualizza() {
        ArrayList<BeanGuiContratto> list = new ArrayList<BeanGuiContratto>();

        return list;
    }

    /**
     * Metodo che permette la visualizzazione di un singolo contratto
     * @param nome
     * criterio di visualizzazione del contratto
     * @return Bean Gui del contratto che è stato selezionato
     */
    public BeanGuiContratto visualizzaContratto(JTextField nome) {
        BeanGuiContratto bgcon = new BeanGuiContratto();

        return bgcon;
    }

    /**
     * Metodo che permette la ricerca di un contratto
     * @param id
     * id del contratto
     * @return il Bean Gui del contratto ricercato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    public BeanGuiContratto ricerca(JTextField id) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette la ricerca per dipendente
     * @param nomeDipendente
     * nome del dipendente
     * @return ArrayList contentente tutti i Bean Gui dei contratti appartenenti al dipendente immesso
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiContratto> ricercaPerDipendente(JTextField nomeDipendente) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette l'inserimento di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui il contratto da inserire esista già
     */
    public void inserisci(BeanGuiContratto BeanGuiContratto) throws DatiErrati, DatiDuplicati {
        throw new DatiErrati("Dati errati.");
        // throw new DatiDuplicati("Dati già presenti.");
    }

    /**
     * Metodo che permette la modifica di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da modificare
     * @return il Bean Gui del contratto modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati

     */
    public BeanGuiContratto modifica(BeanGuiContratto BeanGuiContratto) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

}
