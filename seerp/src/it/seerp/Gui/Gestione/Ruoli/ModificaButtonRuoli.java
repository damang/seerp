
package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import it.seerp.application.Exception.ValidatorException;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Luisa-Luisa
 */
public class ModificaButtonRuoli extends JButton implements CommandInterface {

    GestioneRuoli area = null;

    /**
     *
     */
    public ModificaButtonRuoli() {
        super();
    }

    /**
     *
     * @param l
     */
    public ModificaButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    /**
     *
     * @param areaUt
     */
    public void setArea(GestioneRuoli areaUt) {
        this.area = areaUt;
    }

    public void execute() {
        try {
            area.getMenu().setButtonEnabled(false);
            area.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.MODIFICA);
            area.getSalva().setVisible(true);
            area.getAnnulla().setVisible(true);
            area.setEditable(true);
            area.getBeanGuiRuolo().getNome().setEnabled(false);
        } catch (ValidatorException ex) {
            ex.printStackTrace();
        }
    }
}
