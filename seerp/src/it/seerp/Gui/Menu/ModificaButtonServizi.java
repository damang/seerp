/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;

import it.seerp.Gui.GestioneServizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonServizi extends JButton implements CommandInterface {

    GestioneServizi areaServ = null;

    public ModificaButtonServizi() {
        super();
    }

    public ModificaButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void setAreaServizi(GestioneServizi areaServ) {
        this.areaServ = areaServ;
    }

    public void execute() {

        areaServ.getSalva().setEnabled(true);
        areaServ.getAnnulla().setEnabled(true);
        areaServ.editabile (true);}
}
