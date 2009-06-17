/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andrea
 */
public class AggiungiButtonUtenti extends JButton implements CommandInterface {
    
    AreaUtentePanel areaUt;

    public AggiungiButtonUtenti() {
        super();
    }

    public AggiungiButtonUtenti(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }

    public void execute() {
        this.setEnabled(false);
        areaUt.setTipoOp("inserisci");
        areaUt.inizializzazione("");
        areaUt.editabile(true);
        areaUt.getSalva().setEnabled(true);
        areaUt.getAnnulla().setEnabled(true);}

   
}
