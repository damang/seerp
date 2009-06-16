/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import it.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.Gestione.InfoAzienda.InfoAzienda;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class ModificaButtonInfoAzienda extends JButton implements CommandInterface {

    InfoAzienda azienda = null;

    public ModificaButtonInfoAzienda() {
        super();
    }

    public ModificaButtonInfoAzienda(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    void setnIfoAzienda(InfoAzienda pannello) {
        this.azienda = pannello;
    }

    public void execute() {
         this.setEnabled(false);
        azienda.editabile(true);
        azienda.getSalva().setEnabled(true);
        azienda.getAnnulla().setEnabled(true);

    }
}
