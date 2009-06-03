/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.command.ObserverButton;
import it.seerp.Gui.frame.ObservervableJTabbedPanel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andrea
 */
public class AreaPersonaleButton extends ObserverButton   implements CommandInterface  {


   protected ObservervableJTabbedPanel tabbedPane;
   private JPanel menu;


    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public AreaPersonaleButton (ObservervableJTabbedPanel pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;
        this.addActionListener(act);
    }

   public AreaPersonaleButton () {
        super();
    }


    public void execute() {

        if ( !isPresente) {
            AreaPersonalePanel panel = new AreaPersonalePanel();

            System.out.println("TABBED PANE = "+this.tabbedPane);

            this.tabbedPane.addTab("Area Personale",panel);

     
            isPresente = true;

            AreaPersonalePanel c = new AreaPersonalePanel();
           c.repaint();

            menu.add(c);
           
            menu.repaint();
        }

      
    }




}
