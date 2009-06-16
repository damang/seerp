/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import it.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonRuoli extends JButton implements CommandInterface {

    GestioneRuoli areaUt = null;

    public ModificaButtonRuoli() {
        super();
    }

    public ModificaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void setAreaUt(GestioneRuoli areaUt) {
        this.areaUt = areaUt;
    }

    public void execute() {
         this.setEnabled(false);
        
    }
}
