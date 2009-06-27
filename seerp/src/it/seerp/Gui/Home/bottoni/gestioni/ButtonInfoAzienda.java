
package it.seerp.Gui.Home.bottoni.gestioni;
import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.InfoAzienda.InfoAzienda;
import it.seerp.Gui.Gestione.InfoAzienda.MenuInfoAzienda;
import it.seerp.Gui.observerButton.ObserverButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea-Luisa
 */
public class ButtonInfoAzienda  extends ObserverButton implements CommandInterface{

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private MenuInfoAzienda menu;
    InfoAzienda panel;
    String s = "Info Azienda";


    /**
     *
     * @param pan
     * @param menu
     * @param act
     * @throws SQLException
     */
    public ButtonInfoAzienda(JTabbedPane pan, MenuInfoAzienda menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

    //panel.register(this);
        this.addActionListener(act);


    }

    /**
     *
     */
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
