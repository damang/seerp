/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class EliminaButtonUtente extends JButton implements CommandInterface {

    AreaUtentePanel areaUt;

    /**
     *
     * @param areaUt
     */
    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }

    /**
     *
     */
    public EliminaButtonUtente() {
        super();
    }

    /**
     *
     * @param l
     */
    public EliminaButtonUtente(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
        areaUt.getMenu().setEnabled(false);
        Object[] options = {"Ok", "Annulla"};
        Integer i=JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if(i==1){
        JOptionPane.showMessageDialog(null, "Operazio annulata");}
        else{
        areaUt.elmina();}
    }
}
