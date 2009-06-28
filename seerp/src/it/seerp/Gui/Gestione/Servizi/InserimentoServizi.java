package it.seerp.Gui.Gestione.Servizi;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.FrameServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class InserimentoServizi extends JButton implements CommandInterface {

    /** Creates new form ButtonAnnulla */
    public InserimentoServizi() {
        super();
    }

    
    /**
     *
     * @param listner
     */
    public InserimentoServizi(ActionListener listner) {
        super();
        this.addActionListener(listner);
    }
    public void execute() {
       JOptionPane.showMessageDialog(null, "luisa");
       FrameServizi servizi= new FrameServizi();
       servizi.setVisible(true);
    }
}
