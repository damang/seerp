/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import it.seerp.Gui.Gestione.Ruoli.sceltaRuolo;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class AggiungiButtonRuoli extends JButton implements CommandInterface {

    GestioneRuoli area;

    /**
     *
     */
    public AggiungiButtonRuoli() {
        super();
    }

    /**
     *
     * @param l
     */
    public AggiungiButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    /**
     *
     * @param areaContr
     */
    public void setArea(GestioneRuoli areaContr) {
        this.area = areaContr;
    }

    public void execute() {
        // this.setEnabled(false);
         String r=sceltaRuolo.getRuolo();
         if (r==null) {
             JOptionPane.showMessageDialog(area, "Non hai selezionato nessun ruolo", "Errore", JOptionPane.ERROR_MESSAGE);
         }
         else {         
                 area.getMenu().setButtonEnabled(false);
                 area.getBeanGuiRuolo().resetAll();
                 area.getBeanGuiRuolo().getNome().setText(r+"_");
                 area.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI);
                 area.getSalva().setVisible(true);
                 area.getAnnulla().setVisible(true);
                 area.setEditable(true);
         }
    }
}
