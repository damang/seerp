
package it.seerp.Gui.bottoni.gestioni;

import it.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.command.ObserverButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class AreaPersonaleButton extends ObserverButton implements CommandInterface {

    protected JTabbedPane tabbedPane;
    private JPanel menu;
    AreaPersonalePanel panel;

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public AreaPersonaleButton(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;
        this.panel = new AreaPersonalePanel();
        this.addActionListener(act);
        panel.register(this);
    }

    public AreaPersonaleButton() {
        super();
    }

    public void execute() {

        if (!isPresente) {

            isPresente = true;

            panel.repaint();
            this.tabbedPane.addTab("Area Personale", panel);

            ButtonTabComponent button = new ButtonTabComponent(this.tabbedPane, this.panel, this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount() - 1, button);
            this.tabbedPane.setSelectedComponent(panel);
            panel.setVisible(true);
            this.setEnabled(false);

            panel.repaint();

        }




    }
}
