package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.interfacce.GestioneServizi;
import it.seerp.storage.Operazioni.OpeServizio;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
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
    public ArrayList<BeanGuiServizio> elenca(ArrayList<BeanGuiServizio> listGui)
    {
        OpeServizio ope = new OpeServizio();
        try
        {
            ArrayList<Servizio> list = ope.visualizzaElenco();
            for (Servizio serv : list)
            {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = it.seerp.application.conversioni.Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
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
     * Metodo che permette la ricerca di un servizio
     * @param nome
     * nome del servizio
     * @return ArrayList con i servizi che corrispondono al nome inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produce risultati
    
    public ArrayList<BeanGuiServizio> ricerca(JTextField nome, ArrayList<BeanGuiServizio> listGui) throws DatiErrati
    {
        OpeServizio ope = new OpeServizio();
        try
        {
            ArrayList<Servizio> list = ope.ricercaPerNome(nome.getText());
            for (Servizio serv : list)
            {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = it.seerp.application.conversioni.Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
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
     * Metodo che permette l'inserimento di un nuovo servizio
     * @param BeansGuiServizio
     * Bean Gui del servizio da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    public void inserisci(BeanGuiServizio beanGui) throws DatiErrati, DatiDuplicati
    {
        OpeServizio a = new OpeServizio();
        Servizio serv = it.seerp.application.conversioni.Conversione.conversioneServizio(beanGui);
        try
        {
            a.inserimento(serv);
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
     * Metodo che permette la visualizzazione di un servizio
     * @param nome
     * nome del servizio
     * @return Bean Gui del servizio da visualizzare
     */
    public BeanGuiServizio visualizza(JTextField nome, BeanGuiServizio beanGui)
    {
        OpeServizio ope = new OpeServizio();
        try
        {
            Servizio serv = ope.visualizza(Integer.parseInt(nome.getText()));
            beanGui = it.seerp.application.conversioni.Conversione.conversioneServizio(serv, beanGui);
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
     * Metodo che permette la modifica di un servizio
     * @param BeansGuiServizio
     * Bean Gui del Servizio da mofidicare
     * @return Bean Gui del servizio modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati durante la modifica
     */
    public BeanGuiServizio modifica(BeanGuiServizio beanGui) throws DatiErrati
    {
        OpeServizio ope = new OpeServizio();
        Servizio serv = it.seerp.application.conversioni.Conversione.conversioneServizio(beanGui);
        try
        {
            serv = ope.modifica(serv);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneServizio(serv, beanGui);
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

    public ArrayList<BeanGuiServizio> ricerca(JTextField nome, ArrayList<BeanGuiServizio> list) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
