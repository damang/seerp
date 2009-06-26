package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneInit;
import it.seerp.storage.Operazioni.OpInit;
import it.seerp.storage.ejb.Amministratore;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ila
 */
public class AppInit implements GestioneInit<BeanGuiAmministratore> {
  

    @Override
    public boolean check() {
        boolean check = false;
        try {
            OpInit op = new OpInit();
            check = op.check();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return check;
    }

    @Override
    public void inserimento(BeanGuiAmministratore beanGuiAmministratore) throws SQLException, DatiErrati, DatiDuplicati {
        try {
            OpInit op = new OpInit();
            Amministratore a = Conversione.conversioneAmministratore(beanGuiAmministratore);
            op.inserimento(a);
            
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
    }

  
}
