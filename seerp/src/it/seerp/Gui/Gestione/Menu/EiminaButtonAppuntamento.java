/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonAppuntamento extends JButton implements CommandInterface{
     GestioneRuoli areaServ;

     /**
      *
      * @param areaServ
      */
     public void setAreaServ(GestioneRuoli areaServ) {
        this.areaServ = areaServ;
    }



     /**
      *
      */
     public EiminaButtonAppuntamento() {
        super();
    }

    /**
     *
     * @param l
     */
    public EiminaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }


}