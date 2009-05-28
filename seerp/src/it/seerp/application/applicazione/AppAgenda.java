package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.interfacce.GestioneAgenda;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Tommaso Cattolico
 */
public class AppAgenda implements GestioneAgenda<BeanGuiEvento>
{

    public ArrayList<BeanGuiEvento> visualizzaListaEventi() throws DatiErrati
    {
        ArrayList<BeanGuiEvento> list = new ArrayList<BeanGuiEvento>();

        return list;
    }

    public BeanGuiEvento visualizzaDettagli(JTextField nome)
    {
        BeanGuiEvento bgev = new BeanGuiEvento();

        return bgev;
    }

    public void notificaEventi(BeanGuiEvento beanGuiEventi)
    {

    }

    public void inserimento(BeanGuiEvento beanGuiEventi) throws DatiErrati, DatiDuplicati
    {
        throw new DatiErrati("Dati errati.");
        //throw new DatiDuplicati("Dati duplicati.");
    }

    public BeanGuiEvento modifica(BeanGuiEvento beanGuiEventi) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiEvento> ricerca(JTextField Nome, JTextField Referente, JTextField data) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiEvento> ricercaPerNome(JTextField Nome) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiEvento> ricercaPerGiorno(JTextField giorno) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public void cancellaEvento(BeanGuiEvento beanGuiEventi) throws RicercaFallita
    {
        throw new RicercaFallita("RicercaFallita.");
    }
}
