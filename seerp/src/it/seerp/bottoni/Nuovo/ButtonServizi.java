/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import it.seerp.Gui.command.ObserverButton;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class ButtonServizi extends ObserverButton implements CommandInterface  {


    protected JTabbedPane tabbedPane;
    private JPanel menu;
    GestioneServizi panel;

     /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public ButtonServizi(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;

        this.panel=new GestioneServizi();
        this.addActionListener(act);
        panel.register(this);
    }

    public ButtonServizi() {
        super();
    }

    public void execute() {

        JOptionPane.showMessageDialog(null, isPresente);

        if (!isPresente) {

            isPresente = true;



            panel.repaint();
            this.tabbedPane.addTab("Servizi", panel);
            System.out.println(this.tabbedPane.getTabCount()-1);
            ButtonTabComponent button=new ButtonTabComponent(this.tabbedPane,this.panel,this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount()-1,button );
               System.out.println(tabbedPane);
            panel.setVisible(true);
            menu.setVisible(true);
            panel.repaint();


        }


    }


}
