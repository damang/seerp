
package it.seerp.Gui.Gestione.Utenti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonUtente extends JButton implements CommandInterface {

    AreaUtentePanel areaUt = null;

    /**
     *
     */
    public ModificaButtonUtente() {
        super();
    }

    /**
     *
     * @param l
     */
    public ModificaButtonUtente(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    /**
     *
     * @param areaUt
     */
    public void setAreaUt(AreaUtentePanel areaUt) {
        this.areaUt = areaUt;
    }

    public void execute() {
        areaUt.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.MODIFICA);
        areaUt.getMenu().setButtonEnabled(false);
        areaUt.editabile(true);
        areaUt.getSalva().setEnabled(true);
        areaUt.getAnnulla().setEnabled(true);
        areaUt.validation(true);

    }
}
