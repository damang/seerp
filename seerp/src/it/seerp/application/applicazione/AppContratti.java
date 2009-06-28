package it.seerp.application.applicazione;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiContratto;
import it.seerp.application.applicazione.conversioni.Conversione;
import it.seerp.application.applicazione.interfacce.GestioneContratti;
import it.seerp.storage.Operazioni.OpContratto;
import it.seerp.storage.ejb.Contratto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe del livello application riguardante la Gestione dei Contratti
 * @author Tommaso Cattolico
 */
public class AppContratti implements GestioneContratti<BeanGuiContratto, Contratto> {

    @Override
    public ArrayList<BeanGuiContratto> elenca(ArrayList<BeanGuiContratto> listGui) throws SQLException, ValidatorException {
        OpContratto ope = new OpContratto();
        ArrayList<Contratto> list = ope.visualizzaElenco();
        for (Contratto cont : list) {
            BeanGuiContratto contGui = new BeanGuiContratto();
            contGui = Conversione.conversioneContratto(cont, contGui);
            listGui.add(contGui);
        }
        return listGui;
    }

    @Override
    public BeanGuiContratto visualizzaContratto(int id, BeanGuiContratto gui) throws SQLException, ValidatorException {
        OpContratto ope = new OpContratto();
        Contratto cont = ope.visualizza(id);
        gui = Conversione.conversioneContratto(cont, gui);
        return gui;
    }

    @Override
    public ArrayList<BeanGuiContratto> ricercaPerDipendente(ArrayList<BeanGuiContratto> listGui) throws SQLException, ValidatorException {
        OpContratto ope = new OpContratto();
        ArrayList<Contratto> list = ope.ricercaPerDipendente();
        for (Contratto cont : list) {
            BeanGuiContratto contGui = new BeanGuiContratto();
            contGui = Conversione.conversioneContratto(cont, contGui);
            listGui.add(contGui);
        }
        return listGui;
    }

    @Override
    public void inserisci(BeanGuiContratto beanGuiContratto) throws SQLException, ValidatorException {
        Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
        OpContratto a = new OpContratto();
        a.inserimento(contratto);
    }

    @Override
    public BeanGuiContratto modifica(BeanGuiContratto beanGuiContratto) throws SQLException, ValidatorException {
        Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
        OpContratto a = new OpContratto();
        Contratto b = a.modifica(contratto);
        beanGuiContratto = Conversione.conversioneContratto(b, beanGuiContratto);
        return beanGuiContratto;
    }

    @Override
    public ArrayList<Contratto> visualizzaTabella() throws SQLException {
        ArrayList<Contratto> list = new ArrayList<Contratto>();
        OpContratto ope = new OpContratto();
        list = ope.visualizzaElenco();
        return list;
    }
}
