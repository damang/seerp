/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Menu.MenuAreaPersonale;
import it.seerp.Gui.Menu.MenuUtente;
import it.seerp.Gui.command.ObserverButton;
import it.seerp.Gui.frame.ObservervableJTabbedPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    MenuAreaPersonale menuUt;

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public AreaPersonaleButton(JTabbedPane pan, JPanel menu, ActionListener act) {
        this.tabbedPane = pan;
        this.menu = menu;
        this.menuUt= new MenuAreaPersonale();
        this.panel=new AreaPersonalePanel();

        this.addActionListener(act);
        panel.register(this);
    }

    public AreaPersonaleButton() {
        super();
    }

    public void execute() {JOptionPane.showMessageDialog(null,isPresente);

        JOptionPane.showMessageDialog(null, tabbedPane.getTabCount()-1);



        if (!isPresente) {

            isPresente = true;
        
          menu.add(menuUt);
            panel.repaint();
            this.tabbedPane.addTab("Area Personale", panel);
            System.out.println(this.tabbedPane.getTabCount()-1);
            ButtonTabComponent button=new ButtonTabComponent(this.tabbedPane,this.panel,this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount()-1,button );

            panel.setVisible(true);
            menu.setVisible(true);
            panel.repaint();

        }

         


    }
}
