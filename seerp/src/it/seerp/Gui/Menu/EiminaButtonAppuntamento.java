/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonAppuntamento extends JButton implements CommandInterface{
     GestioneRuoli areaServ;

    public void setAreaServ(GestioneRuoli areaServ) {
        this.areaServ = areaServ;
    }



    public EiminaButtonAppuntamento() {
        super();
    }

    public EiminaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }


}
