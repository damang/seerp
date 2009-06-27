package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiAzienda;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneAzienda;
import it.seerp.storage.Operazioni.OpAzienda;
import it.seerp.storage.ejb.Azienda;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dell'Azienda
 * @author Tommaso Cattolico
 */
public class AppAzienda implements GestioneAzienda<BeanGuiAzienda> {

    @Override
    public BeanGuiAzienda modifica(BeanGuiAzienda beanGui) throws ValidatorException, SQLException {
            OpAzienda ope = new OpAzienda();
            Azienda azi = Conversione.conversioneAzienda(beanGui);
            azi.setIdAzienda(1);
            ope.modifica(azi);
           //beanGui = Conversione.conversioneAzienda(azi, beanGui);
        return beanGui;
    }

    @Override
    public BeanGuiAzienda visualizzaAzienda(BeanGuiAzienda gui) throws SQLException {
       
            OpAzienda ope = new OpAzienda();
            Azienda azi = ope.visualizza();
           
            Conversione.conversioneAzienda(azi, gui);
       
        return gui;
    }

    @Override
    public void inserimento(BeanGuiAzienda BeanGuiAzienda) throws SQLException, ValidatorException {
        
            OpAzienda op = new OpAzienda();
            Azienda a = Conversione.conversioneAzienda(BeanGuiAzienda);
            op.inserimento(a);
        
    }
}
