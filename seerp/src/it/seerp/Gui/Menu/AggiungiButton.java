/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class AggiungiButton extends JButton implements CommandInterface {
    AreaUtentePanel areaUt;

    public AggiungiButton() {
        super();
    }

    public AggiungiButton(ActionListener l) {
        super();
        this.addActionListener(l);
     //   areaUt=panel;
    }

    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }
    public void execute() {

      //areaUt.getSalva().setVisible(true);
    }
}
