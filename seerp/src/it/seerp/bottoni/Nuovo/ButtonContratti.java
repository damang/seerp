/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.bottoni.Nuovo;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.GestioneContratti.GestioneContratti;
import it.seerp.Gui.command.ObserverButton;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class ButtonContratti extends ObserverButton implements CommandInterface {

    protected JTabbedPane tabbedPane;
    private JPanel menu;
    GestioneContratti panel;

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public ButtonContratti(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;

        this.panel = new GestioneContratti();
        this.addActionListener(act);
        panel.register(this);
    }

    public ButtonContratti() {
        super();
    }

    public void execute() {

        if (!isPresente) {

            isPresente = true;



            panel.repaint();
            this.tabbedPane.addTab("Contratti", panel);

            ButtonTabComponent button = new ButtonTabComponent(this.tabbedPane, this.panel, this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount() - 1, button);
            this.tabbedPane.setSelectedComponent(panel);
            this.setEnabled(false);
            panel.setVisible(true);
           // menu.setVisible(true);
            panel.repaint();


        }


    }
}
