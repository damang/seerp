package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.interfacce.GestioneContratti;
import it.seerp.storage.Operazioni.OpeeContratto;
import it.seerp.storage.ejb.Contratto;
import java.sql.SQLException;
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

    public ArrayList<BeanGuiContratto> visualizza(ArrayList<BeanGuiContratto> listGui)
    {
        OpeeContratto ope = new OpeeContratto();
        try
        {
            ArrayList<Contratto> list = ope.visualizzaElenco();
            int i = 0;
            for (Contratto cont : list)
            {
                    listGui.add(it.seerp.application.conversioni.Conversione.conversioneContratto(cont, listGui.get(i)));
                    i++;
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
     * Metodo che permette la visualizzazione di un singolo contratto
     * @param nome
     * criterio di visualizzazione del contratto
     * @param list
     * lista di tutti i contratti
     * @return Bean Gui del contratto che è stato selezionato
     */

    public BeanGuiContratto visualizzaContratto(JTextField id, BeanGuiContratto gui) throws DatiErrati
    {
        OpeeContratto ope = new OpeeContratto();
        try
        {
            Contratto cont = ope.visualizza(Integer.parseInt(id.getText()));
            it.seerp.application.conversioni.Conversione.conversioneContratto(cont, gui);
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
     * Metodo che permette la ricerca per dipendente
     * @param nomeDipendente
     * nome del dipendente
     * @param list
     * lista di tutti i contratti
     * @return ArrayList contentente tutti i Bean Gui dei contratti appartenenti al dipendente immesso
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */

    public ArrayList<BeanGuiContratto> ricercaPerDipendente(JTextField dipendente, ArrayList<BeanGuiContratto> listGui) throws DatiErrati
    {
        OpeeContratto ope = new OpeeContratto();
        try
        {
            ArrayList<Contratto> list = ope.visualizzaElenco();
            int i = 0;
            for (Contratto cont : list)
            {
                if (cont.getDipendente()== Integer.parseInt(dipendente.getText()))
                {
                    listGui.add(it.seerp.application.conversioni.Conversione.conversioneContratto(cont, listGui.get(i)));
                    i++;
                }
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
     * Metodo che permette l'inserimento di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui il contratto da inserire esista già
     */

    public void inserisci(BeanGuiContratto beanGuiContratto) throws DatiErrati, DatiDuplicati
    {
        OpeeContratto a = new OpeeContratto();
        Contratto contratto = it.seerp.application.conversioni.Conversione.conversioneContratto(beanGuiContratto);
        try
        {
            a.inserimento(contratto);
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
     * Metodo che permette la modifica di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da modificare
     * @return il Bean Gui del contratto modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    
    public BeanGuiContratto modifica(BeanGuiContratto beanGuiContratto) throws DatiErrati
    {
        OpeeContratto a = new OpeeContratto();
        Contratto contratto = it.seerp.application.conversioni.Conversione.conversioneContratto(beanGuiContratto);

        try
        {
            Contratto b = a.modifica(contratto);
            beanGuiContratto = it.seerp.application.conversioni.Conversione.conversioneContratto(b, beanGuiContratto);
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
        return beanGuiContratto;
    }
}
