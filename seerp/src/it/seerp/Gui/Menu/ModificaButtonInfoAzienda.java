/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.GestioneContratti.GestioneContratti;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import it.seerp.Gui.InfoAzienda.InfoAzienda;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class ModificaButtonInfoAzienda extends JButton  implements CommandInterface {
InfoAzienda areaContr=null;

    public ModificaButtonInfoAzienda() {
        super();
    }

    public ModificaButtonInfoAzienda(ActionListener l) {
        super();
        this.addActionListener(l);
    }


  void setnIfoAzienda(GestioneServizi pannello) {
         this.areaContr =  areaContr;
    }
    public void execute() {  
    }

   
  
}