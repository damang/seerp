package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import it.seerp.storage.ejb.Utente;
import it.seerp.storage.operazioni.OpAreaPersonale;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class AppGestioneAreaPersonale implements GestioneAreaPersonale  {

    /**
     * 
     * @param utente
     * @param list
     * @return
     */
    public BeanGuiUtente visualizzaDati(BeanGuiUtente utente, ArrayList list)
    {
        return null;
    }

    /**
     *
     * @param utente
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
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
    }

    /**
     *
     * @param utente
     * @return
     */
    public ArrayList<BeanGuiUtente> visualizzaContratti(BeanGuiUtente beanGui)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
