
package it.seerp.Gui.observablePanel;

import it.configurazioni.pattern.observer.Observable;
import it.configurazioni.pattern.observer.Observer;
import java.util.Iterator;
import java.util.Vector;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Luisa
 */
public class ObservableJPanel extends JXPanel implements Observable {

    private Vector obs = new Vector();

    /** Creates new form ObserverJTabbedPanel */


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */


    public void unRegister(Observer o) {
        obs.removeElement(o);
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void notifyObservers() {
        Iterator<Observer> it = obs.iterator();


        while (it.hasNext()) {
            Observer u = it.next();

            u.refreshData(this);
        }
    }

    public void register(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
