/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.bottoni.gestioni;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.configurazioni.Gui.ConfigurazioneUtente.TIPO_UTENTE_CONST;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Menu.MenuRuoli;
import it.seerp.Gui.Menu.MenuUtente;
import it.seerp.Gui.command.ObserverButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


/**
 *
 * @author peppe
 */
public class ButtonRuoli extends ObserverButton implements CommandInterface{

    protected JTabbedPane tabbedPane;
    private MenuRuoli menu;
    GestioneRuoli panel;
    String s = "";

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public ButtonRuoli(JTabbedPane pan, MenuRuoli menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

    //panel.register(this);
        this.addActionListener(act);


    }

    public ButtonRuoli() {
        super();
    }

    public void execute() {

        if (!isPresente) {
            try {
                this.setAreaRuolo();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "problemi di comunicazione col DBMS");
            }


            isPresente = true;
            this.tabbedPane.addTab(s, panel);
            System.out.println(this.tabbedPane.getTabCount() - 1);
            ButtonTabComponent button = new ButtonTabComponent(this.tabbedPane, this.panel, this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount() - 1, button);
            panel.setVisible(true);



            panel.repaint();
            this.tabbedPane.setSelectedComponent(panel);
            this.setEnabled(false);


        }
    }

    private void setAreaRuolo() throws SQLException {

              this.panel = new GestioneRuoli();
              panel.register(this);


    }

}
