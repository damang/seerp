/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonServizi extends JButton implements CommandInterface{
     GestioneServizi areaServ;

    public void setAreaServ(GestioneServizi areaServ) {
        this.areaServ = areaServ;
    }



    public EiminaButtonServizi() {
        super();
    }

    public EiminaButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }


}