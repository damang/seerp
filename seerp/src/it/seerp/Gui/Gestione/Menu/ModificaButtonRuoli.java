/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonRuoli extends JButton implements CommandInterface {

    GestioneRuoli area = null;

    /**
     *
     */
    public ModificaButtonRuoli() {
        super();
    }

    /**
     *
     * @param l
     */
    public ModificaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    /**
     *
     * @param areaUt
     */
    public void setArea(GestioneRuoli areaUt) {
        this.area = areaUt;
    }

    public void execute() {
         this.setEnabled(false);
        
    }
}
