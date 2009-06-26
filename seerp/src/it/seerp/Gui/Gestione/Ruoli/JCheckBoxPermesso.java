
package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiRuolo;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author peppe
 */
public class JCheckBoxPermesso extends javax.swing.JCheckBox implements CommandInterface {
    private BeanGuiRuolo be;
    private boolean event;
    public JCheckBoxPermesso (GestioneRuoli list) {
        this.addItemListener(list);
        be=list.getBeanGuiRuolo();
        event=true;
    }
    @Override
    public void execute() {
        if(event) {
                JPanel j = (JPanel) this.getParent();
                ArrayList<BeanGuiPermesso> p = be.getListPermessi().get(j.getName());
                boolean check=true;
                for (int i=0;i<p.size()&& check==true;i++) {
                    try {

                            check = p.get(i).getAct().isSelected();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                JCheckBoxGestione cbott = (JCheckBoxGestione) be.getPermGen().get(j.getName());
                cbott.setEventEnabled(false);
                cbott.setSelected(check);
                cbott.setEventEnabled(true);
        }
    }
     void setEventEnabled(boolean b) {
        event=b;
    }

}
