
package it.seerp.Gui.Home.bottoni.gestioni;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Ruoli.MenuRuoli;
import it.seerp.Gui.observerButton.ObserverButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


/**
 *
 * @author peppe
 */
public class ButtonRuoli extends ObserverButton implements CommandInterface{

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private MenuRuoli menu;
    GestioneRuoli panel;
    String s = "Gestione Ruoli";

    /**
     *
     * @param pan
     * @param menu
     * @param act
     * @throws SQLException
     */
    public ButtonRuoli(JTabbedPane pan, MenuRuoli menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

     //  panel.register(this);
        this.addActionListener(act);


    }

    /**
     *
     */
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
        //    System.out.println(this.tabbedPane.getTabCount() - 1);
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
