
package it.seerp.Gui.Gestione.InfoAzienda;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.InfoAzienda.InfoAzienda;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea-Luisa
 */
public class ModificaButtonInfoAzienda extends JButton implements CommandInterface {

    InfoAzienda azienda = null;

    /**
     *
     */
    public ModificaButtonInfoAzienda() {
        super();
    }

    /**
     *
     * @param l
     */
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
