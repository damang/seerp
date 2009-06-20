/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author peppe
 */
public class JCheckBoxRuoli extends javax.swing.JCheckBox implements CommandInterface {

    public JCheckBoxRuoli (ItemListener list) {
        this.addItemListener(list);
    }
    @Override
    public void execute() {
       JOptionPane.showMessageDialog(null, this.getText());
    }

}
