/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Ruoli;

//import configurazioni.PermessiDefault;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author peppe
 */
public class NewClass {
    public static void main (String[] args)
    {
       // PermessiDefault.init();
        JFrame f = new JFrame();
        f.add(new GestioneRuoli());
        f.setSize(1400, 700);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
       // JOptionPane.showMessageDialog(null, PermessiDefault.getPermessiAmministratore().size());

    }
}
