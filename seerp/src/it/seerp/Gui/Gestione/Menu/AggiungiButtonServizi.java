
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
public class AggiungiButtonServizi extends JButton implements CommandInterface {

    GestioneServizi areaSer;

    /**
     *
     */
    public AggiungiButtonServizi() {
        super();
    }

    /**
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public AggiungiButtonServizi(ActionListener l) {
        super();
        this.addActionListener(l);
    //   areaUt=panel;
    }

    /**
     * Costruttore della classe
     * @param areaSer
     */
    public void setServizi(GestioneServizi areaSer) {
        this.areaSer = areaSer;
    }

    public void execute() {
        areaSer.getMenu().setButtonEnabled(false);
        areaSer.inizializza("");
        areaSer.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI);
        areaSer.getSalva().setEnabled(true);  
        areaSer.editabile(true);
        areaSer.validation(true);
        areaSer.getAnnulla().setEnabled(true);
    }
}
