package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.interfacce.GestioneAgenda;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.operazioni.OpeEvento;
import java.sql.SQLException;
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

    public ArrayList<BeanGuiEvento> visualizzaListaEventi(ArrayList<BeanGuiEvento> listGui)
    {
        OpeEvento ope = new OpeEvento();
        try
        {
            ArrayList<Evento> list = ope.visualizzaElenco();
            for (Evento eve : list)
            {
                BeanGuiEvento eveGui = new BeanGuiEvento();
                eveGui = it.seerp.application.conversioni.Conversione.conversioneEvento(eve, eveGui);
                listGui.add(eveGui);
            }
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return listGui;
    }

    /**
     * Metodo che permette la visualizzazione dei dettagli di un singolo evento
     * @param nome
     * nome dell'evento
     * @param list
     * lista di tutti gli eventi
     * @return Bean Gui dell'evento
     */

    public BeanGuiEvento visualizzaDettagli(JTextField id, BeanGuiEvento gui) throws DatiErrati
    {
        OpeEvento ope = new OpeEvento();
        try
        {
            Evento eve = ope.visualizza(Integer.parseInt(id.getText()));
            it.seerp.application.conversioni.Conversione.conversioneEvento(eve, gui);
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return gui;
    }

     /**
     * Metodo che permette la gestione delle notifiche
     * @param beanGuiEventi
     * Bean Gui dell'evento da visualizzare
     */

    public void notificaEventi(BeanGuiEvento beanGui)
    {
        OpeEvento ope = new OpeEvento();
        Evento eve = it.seerp.application.conversioni.Conversione.conversioneEvento(beanGui);
        try
        {
            ope.notificaEvento(eve);
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
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

    public void inserimento(BeanGuiEvento beanGui) throws DatiErrati, DatiDuplicati
    {
        OpeEvento ope = new OpeEvento();
        Evento eve = it.seerp.application.conversioni.Conversione.conversioneEvento(beanGui);
        try
        {
            ope.inserimento(eve);
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
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

    public BeanGuiEvento modifica(BeanGuiEvento beanGui) throws DatiErrati
    {
        OpeEvento a = new OpeEvento();
        Evento eve = it.seerp.application.conversioni.Conversione.conversioneEvento(beanGui);

        try
        {
            eve = a.modifica(eve);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneEvento(eve, beanGui);
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return beanGui;
    }

     /**
     * Metodo che permette la ricerca di un evento
     * @param Nome
     * nome dell'evento da ricercare
     * @param Referente
     * nome del referente
     * @param data
     * data dell'evento da ricercare
     * @para list
      * lista di tutti gli eventi
     * @return la lista degli eventi che corrispondono ai criteri di ricerca
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */


    public ArrayList<BeanGuiEvento> ricerca(JTextField Nome, JTextField Referente, JTextField data, ArrayList<BeanGuiEvento> listGui) throws DatiErrati
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette la ricerca per nome di un evento
     * @param nome
     * nome dell'evento da ricercare
     * @param list
     * lista di tutti gli eventi
     * @return lista degli eventi che corrispondono al giorno inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produca risultati
     */

    public ArrayList<BeanGuiEvento> ricercaPerNome(JTextField Nome, ArrayList<BeanGuiEvento> list) throws DatiErrati, RicercaFallita {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * Metodo che permette la ricerca per giorno di un evento
     * @param giorno
     * giorno dell'evento da ricercare
     * @param list
     * lista di tutti gli eventi
     * @return lista degli eventi che corrispondono al giorno inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produca risultati
     */

    public ArrayList<BeanGuiEvento> ricercaPerGiorno(JTextField giorno, ArrayList<BeanGuiEvento> listGui) throws DatiErrati, RicercaFallita
    {
        OpeEvento ope = new OpeEvento();
        try
        {
            ArrayList<Evento> list = ope.ricercaPerGiorno(giorno.getText());
            for (Evento eve : list)
            {
                BeanGuiEvento eveGui = new BeanGuiEvento();
                eveGui = it.seerp.application.conversioni.Conversione.conversioneEvento(eve, eveGui);
                listGui.add(eveGui);
            }
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return listGui;
    }


    /**
     * Metodo che permette la cancellazione di un evento già esistente
     * @param beanGuiEventi
     * Bean Gui dell'evento da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione dell'evento
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produca risultati
     */

    public void cancellaEvento(BeanGuiEvento beanGui) throws CancellazioneFallita
    {
        OpeEvento ope = new OpeEvento();
        Evento eve = it.seerp.application.conversioni.Conversione.conversioneEvento(beanGui);
        try
        {
            ope.cancella(eve);
        }
        catch (SQLException se)
        {
            System.out.println("SQL Exception:");
            while (se != null)
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
    }
}
