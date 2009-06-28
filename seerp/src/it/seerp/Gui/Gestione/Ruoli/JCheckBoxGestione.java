package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.application.applicazione.bean.BeanGuiPermesso;
import it.seerp.application.applicazione.bean.BeanGuiRuolo;
import java.util.ArrayList;

/**
 *
 * @author peppe
 */
public class JCheckBoxGestione extends javax.swing.JCheckBox implements CommandInterface {
    private BeanGuiRuolo be;
    private boolean event;
    public JCheckBoxGestione (GestioneRuoli list) {
        this.addItemListener(list);
        be=list.getBeanGuiRuolo();
        event=true;
    }
    @Override
    public void execute() {
        if (event) {
            ArrayList<BeanGuiPermesso> p = be.getListPermessi().get(this.getName());
            boolean sel=this.isSelected();
            //System.out.println(sel + " " + this.getName());
            JCheckBoxPermesso jcp;
            for (int i=0;i<p.size();i++) {
                try {
                      jcp=(JCheckBoxPermesso)p.get(i).getAct();
                      jcp.setEventEnabled(false);
                      jcp.setSelected(sel);
                      jcp.setEventEnabled(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    void setEventEnabled(boolean b) {
        event=b;
    }

}
