package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneInit;
import it.seerp.storage.Operazioni.OpInit;
import it.seerp.storage.ejb.Amministratore;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Lato application della gestione Init
 * @author Ila - Tommaso Cattolico
 */
public class AppInit implements GestioneInit<BeanGuiAmministratore> {
  
    @Override
    public boolean check() throws SQLException {
        boolean check = false;
            OpInit op = new OpInit();
            check = op.check();
        return check;
    }

    @Override
    public void inserimento(BeanGuiAmministratore beanGuiAmministratore) throws SQLException, DatiErrati, DatiDuplicati, ValidatorException {

            OpInit op = new OpInit();
            Amministratore a = Conversione.conversioneAmministratore(beanGuiAmministratore);
            op.inserimento(a);
         
    }

  
}
