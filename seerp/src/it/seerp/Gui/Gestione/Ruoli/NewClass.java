/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Ruoli;

//import configurazioni.PermessiDefault;
import java.util.regex.Pattern;

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
       // PermessiDefault.init();
       /* JFrame f = new JFrame();
        try {
            f.add(new GestioneRuoli());
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setSize(1400, 700);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);*/
       // JOptionPane.showMessageDialog(null, PermessiDefault.getPermessiAmministratore().size());
        if (Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", "majinb@virgilio.it"))
               System.out.println(true);
            else
                System.out.println(false);

    }
}
