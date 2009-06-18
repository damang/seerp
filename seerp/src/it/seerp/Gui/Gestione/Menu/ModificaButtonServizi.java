package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;

import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class ModificaButtonServizi extends JButton implements CommandInterface {

    GestioneServizi areaServ = null;

    /**
     *
     */
    public ModificaButtonServizi() {
        super();
    }

    /**
     *
     * @param l
     */
    public ModificaButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    /**
     *
     * @param areaServ
     */
    public void setAreaServizi(GestioneServizi areaServ) {
        this.areaServ = areaServ;
    }

    public void execute() {
        this.setEnabled(false);
        areaServ.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.MODIFICA);
        areaServ.getSalva().setEnabled(true);
        areaServ.getAnnulla().setEnabled(true);
        areaServ.editabile(true);
    }
}
