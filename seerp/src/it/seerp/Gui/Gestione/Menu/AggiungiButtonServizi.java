/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class AggiungiButtonServizi extends JButton implements CommandInterface {

    GestioneServizi areaSer;

    /**
     *
     */
    public AggiungiButtonServizi() {
        super();
    }

    /**
     *
     * @param l
     */
    public AggiungiButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    //   areaUt=panel;
    }

    /**
     *
     * @param areaSer
     */
    public void setServizi(GestioneServizi areaSer) {
        this.areaSer = areaSer;
    }

    public void execute() {
        this.setEnabled(false);
        areaSer.setTipoOP("inserisci");
        areaSer.getSalva().setEnabled(true);
        areaSer.getAnnulla().setEnabled(true);
        areaSer.editabile(true);
    }
}