/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.BottoniGenerici;

import it.seerp.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.FrameServizi;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
