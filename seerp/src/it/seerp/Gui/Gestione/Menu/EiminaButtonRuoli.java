
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class EiminaButtonRuoli extends JButton implements CommandInterface{
     GestioneRuoli area;

     /**
      *
      * @param areaServ
      */
     public void setArea(GestioneRuoli areaServ) {
        this.area = areaServ;
    }



     /**
      *
      */
     public EiminaButtonRuoli() {
        super();
    }

    /**
     *
     * @param l
     */
    public EiminaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
        area.eliminaSelected();

    }


}
