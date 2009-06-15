/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import configurazioni.Gui.ConfigurazioneUtente.TIPO_UTENTE_CONST;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.Menu.MenuUtente;
import it.seerp.Gui.command.ObserverButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class AreaUtenteButton extends ObserverButton implements CommandInterface {

    protected JTabbedPane tabbedPane;
    private MenuUtente menu;
    AreaUtentePanel panel;
    String s = "";

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public AreaUtenteButton(JTabbedPane pan, MenuUtente menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;

        this.addActionListener(act);


    }

    public AreaUtenteButton() {
        super();
    }

    public void execute() {

        if (!isPresente) {
            try {
                this.setAreaUtente();
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

    private void setAreaUtente() throws SQLException {

        String tipoUtente = (this.getText());
        System.out.println("testo" + this.getText());
        if (tipoUtente.compareToIgnoreCase("Clienti") == 0) {
            this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);
            s = "Area Clienti";
            panel.register(this);

        } else if (tipoUtente.compareToIgnoreCase("Dipendenti") == 0) {
            this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.DIPENDENTE);
            panel.setBackground(Color.CYAN);
            s = "Area Dipendeti";
            panel.register(this);

        } else if (tipoUtente.compareToIgnoreCase("Fornitori") == 0) {
            this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.FORNITORE);
            panel.setBackground(Color.CYAN);
            s = "Area Fornitori";
            panel.register(this);


        } else if (tipoUtente.compareToIgnoreCase("Responsabili") == 0) {
            this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.RESPONSABILE);
            panel.setBackground(Color.CYAN);
            s = "Area Responsabili";
            panel.register(this);
        } else {
            JOptionPane.showMessageDialog(null, "Panello nn settato");
        }
    }
}
