package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.interfacce.GestioneAgenda;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Classe del livello application riguardante la Gestione dell'Agenda
 * @author Tommaso Cattolico
 */
public class AppAgenda implements GestioneAgenda<BeanGuiEvento>
{

    /**
     * Metodo che permette la visualizzazione della lista degli eventi
     * @return  Array List contenente la lista degli eventi
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public ArrayList<BeanGuiEvento> visualizzaListaEventi() throws DatiErrati
    {
        ArrayList<BeanGuiEvento> list = new ArrayList<BeanGuiEvento>();

        return list;
    }

    /**
     * Metodo che permette la visualizzazione dei dettagli di un singolo evento
     * @param nome
     * nome dell'evento
     * @return Bean Gui dell'evento
     */
    public BeanGuiEvento visualizzaDettagli(JTextField nome)
    {
        BeanGuiEvento bgev = new BeanGuiEvento();

        return bgev;
    }

    /**
     * Metodo che permette la gestione delle notifiche
     * @param beanGuiEventi
     * Bean Gui dell'evento da visualizzare
     */
    public void notificaEventi(BeanGuiEvento beanGuiEventi)
    {

    }

    /**
     * Metodo che permette l'inserimento di un nuovo evento
     * @param beanGuiEventi
     * Bean Gui dell'evento da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * in caso di inserimento di dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui esista l'evento che si tenta di inserire
     */
    public void inserimento(BeanGuiEvento beanGuiEventi) throws DatiErrati, DatiDuplicati
    {
        throw new DatiErrati("Dati errati.");
        //throw new DatiDuplicati("Dati duplicati.");
    }

    /**
     * Metodo che permette la modifica di un evento
     * @param beanGuiEventi
     * Bean Gui dell'evento da modificare
     * @return
     * Bean Gui dell'evento modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public BeanGuiEvento modifica(BeanGuiEvento beanGuiEventi) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette la ricerca di un evento
     * @param Nome
     * nome dell'evento da ricercare
     * @param Referente
     * nome del referente
     * @param data
     * data dell'evento da ricercare
     * @return la lista degli eventi che corrispondono ai criteri di ricerca
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiEvento> ricerca(JTextField Nome, JTextField Referente, JTextField data) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette la ricerca per nome
     * @param Nome
     * nome dell'evento da ricercare
     * @return la lista degli eventi che corrispondono al nome inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiEvento> ricercaPerNome(JTextField Nome) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette la ricerca per giorno di un evento
     * @param giorno
     * giorno dell'evento da ricercare
     * @return lista degli eventi che corrispondono al giorno inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiEvento> ricercaPerGiorno(JTextField giorno) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    /**
     * Metodo che permette la cancellazione di un evento già esistente
     * @param beanGuiEventi
     * Bean Gui dell'evento da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione dell'evento
     */
    public void cancellaEvento(BeanGuiEvento beanGuiEventi) throws CancellazioneFallita
    {
        throw new RicercaFallita("Cancellazione Fallita.");
    }
}
