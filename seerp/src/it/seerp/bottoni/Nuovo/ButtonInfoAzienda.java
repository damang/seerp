/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Home.Index;
import it.seerp.Gui.InfoAzienda.InfoAzienda;
import it.seerp.Gui.Menu.MenuInfoAzienda;
import it.seerp.Gui.Menu.MenuRuoli;
import it.seerp.Gui.command.ObserverButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class ButtonInfoAzienda  extends ObserverButton implements CommandInterface{

    protected JTabbedPane tabbedPane;
    private MenuInfoAzienda menu;
    InfoAzienda panel;
    String s = "";


    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public ButtonInfoAzienda(JTabbedPane pan, MenuInfoAzienda menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

    //panel.register(this);
        this.addActionListener(act);


    }

    public ButtonInfoAzienda() {
        super();
    }

    public void execute() {

        if (!isPresente) {
            try {
                this.setAreaInfo();
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

    private void setAreaInfo() throws SQLException {

              this.panel = new InfoAzienda();
              panel.register(this);


    }

}
