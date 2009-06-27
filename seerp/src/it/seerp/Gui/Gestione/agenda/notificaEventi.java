/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.agenda;

import it.seerp.application.applicazione.AppAgenda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.tips.DefaultTip;
import org.jdesktop.swingx.tips.DefaultTipOfTheDayModel;
import org.jdesktop.swingx.tips.TipOfTheDayModel;
import org.jdesktop.swingx.tips.TipOfTheDayModel.Tip;

/**
 *
 * @author peppe
 */
public class notificaEventi extends JXTipOfTheDay {

    public notificaEventi(TipOfTheDayModel model) {
        super(model);
        
    }

    public notificaEventi(int id) {
        super();
        try {
            Collection<Tip> tips = new ArrayList<Tip>();
            AppAgenda a = new AppAgenda();
            Iterator<String> s;
            s=a.getEventiNotificare(id).iterator();
            String ev="";
            while (s.hasNext())
                ev+=s.next()+"\n";
            tips.add(new DefaultTip("evento", ev));
            TipOfTheDayModel model = new DefaultTipOfTheDayModel(tips);
            this.setModel(model);
            this.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }

        
    }

}
