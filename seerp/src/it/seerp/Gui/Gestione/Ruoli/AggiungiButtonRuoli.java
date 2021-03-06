package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Ruoli.sceltaRuolo;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.application.Exception.ValidatorException;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public AggiungiButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    /**
     * Costruttore della classe
     * @param areaContr
     */
    public void setArea(GestioneRuoli areaContr) {
        this.area = areaContr;
    }

    public void execute() {
        // this.setEnabled(false);
        try {
            String r = sceltaRuolo.getRuolo();
            if (r == null) {
                JOptionPane.showMessageDialog(area, "Non hai selezionato nessun ruolo o hai annullato l'operazione!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {

                area.getMenu().setButtonEnabled(false);
                area.getBeanGuiRuolo().resetAll();
                area.getBeanGuiRuolo().getNome().setText(r + "_");
                // area.getBeanGuiRuolo().getNome().setEnabled(true);
                area.getBeanGuiRuolo().setListPermessi(PermessiDefault.getPermessiGUI(r, area.getBeanGuiRuolo().getListPermessi()));
                area.setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI);
                area.getSalva().setVisible(true);
                area.getAnnulla().setVisible(true);
                area.setEditable(true);
                area.getBeanGuiRuolo().setValidator(true);
            //((NotEmptyValidator)area.getBeanGuiRuolo().getNome().getInputVerifier()).setEnabled(true);
            //((NotEmptyValidator)area.getBeanGuiRuolo().getNome().getInputVerifier()).setEnabled(true);
            }
        } catch (ValidatorException ex) {
            ex.printStackTrace();
        }
    }
}
