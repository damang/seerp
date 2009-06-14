/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class EliminaButtonUtente extends JButton  implements CommandInterface {
     AreaUtentePanel areaUt;

    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }

    public EliminaButtonUtente() {
        super();
    }

    public EliminaButtonUtente(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }



}
