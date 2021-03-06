/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ObserverJTabbedPanel.java
 *
 * Created on 3-giu-2009, 12.50.15
 */
package it.seerp.Gui.observablePanel;

import it.seerp.Gui.configurazioni.pattern.observer.Observable;
import it.seerp.Gui.configurazioni.pattern.observer.Observer;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrea
 */
public class ObservervableJTabbedPanel extends JPanel implements Observable {

    private Vector obs = new Vector();

    /** Creates new form ObserverJTabbedPanel */
    public ObservervableJTabbedPanel() {
        super();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();

        jTabbedPane2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setName("jTabbedPane2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
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

    public void unRegister(Observer o) {
        obs.removeElement(o);
    }

    /**
     *
     * @param messaggio
     * @param pan
     */
    public void addTab(String messaggio, JPanel pan) {
        // System.out.println(this.jTabbedPane2);
        this.jTabbedPane2.addTab(messaggio, pan);
       

    }

    /**
     *
     * @return
     */
    public JTabbedPane getTabbedPane(){
        return this.jTabbedPane2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
