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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la visualizzazione di un singolo contratto
     * @param nome
     * criterio di visualizzazione del contratto
     * @param list
     * lista di tutti i contratti
     * @return Bean Gui del contratto che è stato selezionato
     */

    public BeanGuiContratto visualizzaContratto(JTextField id, ArrayList<BeanGuiContratto> list) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     /**
     * Metodo che permette la ricerca di un contratto
     * @param id
     * id del contratto
     * @param list
     * lista di tutti i contratti
     * @return il Bean Gui del contratto ricercato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */

    public BeanGuiContratto ricerca(JTextField id, ArrayList<BeanGuiContratto> list) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

      /**
     * Metodo che permette la ricerca per dipendente
     * @param nomeDipendente
     * nome del dipendente
     * @param list
     * lista di tutti i contratti
     * @return ArrayList contentente tutti i Bean Gui dei contratti appartenenti al dipendente immesso
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */

    public ArrayList<BeanGuiContratto> ricercaPerDipendente(JTextField nomeDipendente, ArrayList<BeanGuiContratto> list) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public void inserisci(BeanGuiContratto beanGuiContratto) throws DatiErrati, DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la modifica di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da modificare
     * @return il Bean Gui del contratto modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    
    public BeanGuiContratto modifica(BeanGuiContratto beanGuiContratto) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    
  

   
   

  
   

  
   

    
   

}
