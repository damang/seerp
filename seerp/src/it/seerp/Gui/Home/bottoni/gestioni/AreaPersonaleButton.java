
package it.seerp.Gui.Home.bottoni.gestioni;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Home.Index;
import it.seerp.Gui.observerButton.ObserverButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea-Luisa
 */
public class AreaPersonaleButton extends ObserverButton implements CommandInterface {

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private JPanel menu;
    AreaPersonalePanel panel;

    /**
     * Metodo che associa un panello e un menu alla home page
     * @param pan  è il pannello sulla home
     * @param menu è il menù da associare
     * @param act parametro indice
     */
    public AreaPersonaleButton(JTabbedPane pan, JPanel menu, Index act) {
        this.tabbedPane = pan;
        this.menu = menu;
        this.panel = new AreaPersonalePanel(act.getSubject());
        this.addActionListener(act);
        panel.register(this);
    }

    /**
     *
     */
    public AreaPersonaleButton() {
        super();
    }

    @Override
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
