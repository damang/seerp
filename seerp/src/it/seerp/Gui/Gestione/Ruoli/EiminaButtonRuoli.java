
package it.seerp.Gui.Gestione.Ruoli;

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
      * Costruttore della classe
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
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public EiminaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
        area.eliminaSelected();

    }


}
