/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonUtente extends JButton implements CommandInterface {

    AreaUtentePanel areaUt = null;

    public ModificaButtonUtente() {
        super();
    }

    public ModificaButtonUtente(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }

    public void execute() {
        areaUt.setTipoOp("modifica");
        this.setEnabled(false);
        areaUt.editabile(true);
        areaUt.getSalva().setEnabled(true);
        areaUt.getAnnulla().setEnabled(true);

    }
}
