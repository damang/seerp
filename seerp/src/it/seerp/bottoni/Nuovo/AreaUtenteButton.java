/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.command.ObserverButton;
import it.seerp.Gui.frame.ObservervableJTabbedPanel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class AreaUtenteButton extends ObserverButton   implements CommandInterface  {


    protected JTabbedPane tabbedPane;
    private JPanel menu;
    AreaUtentePanel panel;

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public AreaUtenteButton(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;

        this.panel=new AreaUtentePanel();
        this.addActionListener(act);
        panel.register(this);
    }

    public AreaUtenteButton() {
        super();
    }

    public void execute() {

        JOptionPane.showMessageDialog(null, isPresente);

        if (!isPresente) {

            isPresente = true;



            panel.repaint();
            this.tabbedPane.addTab("Area Utente", panel);
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
