/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Ruoli;

//import configurazioni.PermessiDefault;
import it.seerp.Gui.configurazioni.PermessiDefault;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author peppe
 */
public class NewClass {
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        PermessiDefault.init();
        JFrame f = new JFrame();
        try {
            f.getContentPane().add(new GestioneRuoli());
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       f.setSize(1000, 700);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
      //  JOptionPane.showMessageDialog(null, PermessiDefault.getPermessiAmministratore().size());
      }
}
