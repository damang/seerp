package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.interfacce.GestioneContratti;
import java.util.ArrayList;
import javax.swing.JTextField;


/**
 *
 * @author Tommaso Cattolico
 */
public class AppContratti implements GestioneContratti<BeanGuiContratto>
{

    public ArrayList<BeanGuiContratto> visualizza() {
        ArrayList<BeanGuiContratto> list = new ArrayList<BeanGuiContratto>();

        return list;
    }

    public BeanGuiContratto visualizzaContratto(JTextField nome) {
        BeanGuiContratto bgcon = new BeanGuiContratto();

        return bgcon;
    }

    public BeanGuiContratto visualizzaContratto(BeanGuiContratto BeanGuiContatto) {

        return BeanGuiContatto;
    }

    public BeanGuiContratto ricerca(JTextField id) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

    public ArrayList<BeanGuiContratto> ricercaPerDipendente(JTextField nomeDipendente) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

    public void inserisci(BeanGuiContratto BeanGuiContratto) throws DatiErrati {
        throw new DatiErrati("Dati errati.");
    }

    public BeanGuiContratto modifica(BeanGuiContratto BeanGuiContratto) throws DatiErrati, DatiDuplicati {
        throw new DatiErrati("Dati errati.");
       // throw new DatiDuplicati("Dati già presenti.");
    }
}
