/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class helpme extends JButton implements CommandInterface  {

    public void execute() {
        JOptionPane.showMessageDialog(null, "ciao CLIENTE");

    }

}
