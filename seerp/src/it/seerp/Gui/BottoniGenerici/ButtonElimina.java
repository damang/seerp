/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ButtonElimina.java
 *
 * Created on 10-giu-2009, 23.00.56
 */

package it.seerp.Gui.BottoniGenerici;

import it.configurazioni.pattern.command.CommandInterface;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class ButtonElimina extends JButton implements CommandInterface {

    /** Creates new form ButtonElimina */
    public ButtonElimina() {
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

        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 0, 0));
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/remove.png"))); // NOI18N
        setText("Elimina");
    }// </editor-fold>//GEN-END:initComponents

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
