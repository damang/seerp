/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class ModificaButton extends JButton  implements CommandInterface {
    String s="luu";

    public ModificaButton() {
        super();
    }

    public ModificaButton(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, s);
    }

}
