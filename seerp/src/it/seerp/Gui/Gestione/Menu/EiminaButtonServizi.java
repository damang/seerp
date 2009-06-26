
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonServizi extends JButton implements CommandInterface{
     GestioneServizi areaServ;

     /**
      *
      * @param areaServ
      */
     public void setAreaServ(GestioneServizi areaServ) {
        this.areaServ = areaServ;
    }



    /**
     *
     */
    public EiminaButtonServizi() {
        super();
    }

    /**
     *
     * @param l
     */
    public EiminaButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }


}
