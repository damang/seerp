
package it.seerp.Gui.Gestione.Utenti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class AggiungiButtonUtenti extends JButton implements CommandInterface {
    
    AreaUtentePanel areaUt;

    /**
     *
     */
    public AggiungiButtonUtenti() {
        super();
    }

    /**
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public AggiungiButtonUtenti(ActionListener l) {
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
        areaUt.getMenu().setButtonEnabled(false);
        areaUt.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI);
        areaUt.inizializzazione("");
        areaUt.editabile(true);
        areaUt.validation(true);
        areaUt.getSalva().setEnabled(true);
        areaUt.getAnnulla().setEnabled(true);

    }

   
}
