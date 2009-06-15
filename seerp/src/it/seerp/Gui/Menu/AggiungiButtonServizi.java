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
public class AggiungiButtonServizi extends JButton implements CommandInterface {
     GestioneServizi areaSer;

    public AggiungiButtonServizi() {
        super();
    }

    public AggiungiButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
     //   areaUt=panel;
    }

    public void setServizi(GestioneServizi areaSer) {
        this.areaSer = areaSer;
    }
    public void execute() {
    
     areaSer.getSalva().setEnabled(true);
     areaSer.getAnnulla().setEnabled(true);
     areaSer.editabile(true);
    }




}
