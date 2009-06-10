package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import it.seerp.storage.ejb.Utente;
import it.seerp.storage.operazioni.OpAreaPersonale;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che permette di effetture le principali operazioni relative
 * alla gestionde dellì'Area Personale
 * @author matteo - Tommaso Cattolico
 */
public class AppGestioneAreaPersonale /*implements GestioneAreaPersonale<Utente, BeanGuiUtente>*/
{
    /**
     * Metodo che permette di visualizzare tutti i dati relativi ad un utente
     * @param utente rappresenta il Bean grafico dell'utente che si vuole visualizzare
     * @return il Bean Grafico contenente i dati dell'utente
     
    public BeanGuiUtente visualizzaDati(BeanGuiUtente beanGui)
    {
        OpAreaPersonale ope = new OpAreaPersonale();
        Utente user = it.seerp.application.conversioni.Conversione.conversioneUtente(beanGui);

        try
        {
            user = ope.visualizzaDati(user.getIdUtente());
            beanGui = it.seerp.application.conversioni.Conversione.conversioneUtente(user, beanGui);
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
     * Metodo che permette di modificare la password di un utente
     * @param utente rappresenta il Bean grafico dell'utente interessato
     * @return il Bean grafico modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     
    public BeanGuiUtente modificaPassword(BeanGuiUtente beanGui) throws DatiErrati
    {
        OpAreaPersonale ope = new OpAreaPersonale();
        Utente user = it.seerp.application.conversioni.Conversione.conversioneUtente(beanGui);

        try
        {
            user = ope.modificaPassword(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneUtente(user, beanGui);
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
    }*/
}
