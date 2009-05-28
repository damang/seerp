package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.interfacce.GestioneAgenda;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Tommaso Cattolico
 */
public class AppServizi implements GestioneAgenda<BeanGuiServizio>
{

    public ArrayList<BeanGuiServizio> visualizzaListaEventi() throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public BeanGuiServizio visualizzaDettagli(JTextField nome)
    {
        BeanGuiServizio bgser = new BeanGuiServizio();

        return bgser;
    }

    public void notificaEventi(BeanGuiServizio beanGuiEventi)
    {

    }

    public void inserimento(BeanGuiServizio beanGuiEventi) throws DatiErrati, DatiDuplicati
    {
        throw new DatiErrati("Dati errati.");
        //throw new DatiDuplicati("Dati duplicati.");
    }

    public BeanGuiServizio modifica(BeanGuiServizio beanGuiEventi) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiServizio> ricerca(JTextField Nome, JTextField Referente, JTextField data) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiServizio> ricercaPerNome(JTextField Nome) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiServizio> ricercaPerGiorno(JTextField giorno) throws DatiErrati
    {
        throw new DatiErrati("Dati errati.");
    }

    public void cancellaEvento(BeanGuiServizio beanGuiEventi) throws RicercaFallita
    {
        throw new RicercaFallita("Ricerca Fallita.");
    }
}
