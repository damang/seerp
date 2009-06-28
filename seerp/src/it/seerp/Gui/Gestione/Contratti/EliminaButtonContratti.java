

package it.seerp.Gui.Gestione.Contratti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EliminaButtonContratti extends JButton  implements CommandInterface {
   GestioneContratti areaContr;

   /**
    * Costruttore della classe
    * @param areaContr
    */
   public void setAreaContr(GestioneContratti areaContr) {
        this.areaContr = areaContr;
    }

    /**
     *
     */
    public EliminaButtonContratti() {
        super();
    }

    /**
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public EliminaButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }

}
