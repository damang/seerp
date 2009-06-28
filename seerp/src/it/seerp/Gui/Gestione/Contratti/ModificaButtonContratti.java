
package it.seerp.Gui.Gestione.Contratti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea-Luisa
 */
public class ModificaButtonContratti extends JButton  implements CommandInterface {
GestioneContratti areaContr=null;

/**
 *
 */
public ModificaButtonContratti() {
        super();
    }

    /**
     *
     * @param l
     */
    public ModificaButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);
    }



    /**
     *
     * @param areaContr
     */
    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr =  areaContr;
    }
    public void execute() {
       
      JOptionPane.showMessageDialog(null, "funzionalità non abilitata");
    }
}
