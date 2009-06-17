/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.bottoni.gestioni;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.observerButton.ObserverButton;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class ButtonServizi extends ObserverButton implements CommandInterface {

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private JPanel menu;
    GestioneServizi panel;

    /**
     *
     * @param pan
     * @param menu
     * @param act
     */
    public ButtonServizi(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;

        this.panel = new GestioneServizi();
        this.addActionListener(act);
        panel.register(this);
    }

    /**
     *
     */
    public ButtonServizi() {
        super();
    }

    public void execute() {

        JOptionPane.showMessageDialog(null, isPresente);

        if (!isPresente) {

            isPresente = true;



            panel.repaint();
            this.tabbedPane.addTab("Servizi", panel);

            ButtonTabComponent button = new ButtonTabComponent(this.tabbedPane, this.panel, this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount() - 1, button);
            this.tabbedPane.setSelectedComponent(panel);
            panel.setVisible(true);
        //    menu.setVisible(true);
           this.setEnabled(false);

            panel.repaint();


        }


    }
}
