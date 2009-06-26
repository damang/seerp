
package it.seerp.Gui.bottoni.gestioni;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import it.seerp.Gui.observerButton.ObserverButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea-Luisa
 */
public class ButtonContratti extends ObserverButton implements CommandInterface {

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private JPanel menu;
    GestioneContratti panel;

    /**
     *
     * @param pan
     * @param act 
     * @param menu
     */
    public ButtonContratti(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;

        this.panel = new GestioneContratti();
        this.addActionListener(act);
        panel.register(this);
    }

    /**
     *
     */
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
