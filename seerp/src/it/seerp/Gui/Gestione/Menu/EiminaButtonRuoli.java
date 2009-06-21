/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.application.applicazione.AppRuoli;
import it.seerp.application.tabelle.RuoloTm;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author Luisa
 */
public class EiminaButtonRuoli extends JButton implements CommandInterface{
     GestioneRuoli area;

     /**
      *
      * @param areaServ
      */
     public void setArea(GestioneRuoli areaServ) {
        this.area = areaServ;
    }



     /**
      *
      */
     public EiminaButtonRuoli() {
        super();
    }

    /**
     *
     * @param l
     */
    public EiminaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
        area.eliminaSelected();

    }


}
