/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonRuoli extends JButton implements CommandInterface{
     GestioneRuoli areaServ;

    public void setAreaServ(GestioneRuoli areaServ) {
        this.areaServ = areaServ;
    }



    public EiminaButtonRuoli() {
        super();
    }

    public EiminaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }


}
