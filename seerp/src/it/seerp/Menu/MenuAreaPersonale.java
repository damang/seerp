/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AreaPersonalePanel.java
 *
 * Created on 28-mag-2009, 19.29.04
 */

package it.seerp.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class MenuAreaPersonale extends javax.swing.JPanel implements ActionListener {

    /** Creates new form AreaPersonalePanel */
    public MenuAreaPersonale() {
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

        BottoneModificaUtenti = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Area Personale", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        BottoneModificaUtenti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/HP-Control-32x32.png"))); // NOI18N
        BottoneModificaUtenti.setToolTipText("Modifica");
        BottoneModificaUtenti.setBorder(null);
        BottoneModificaUtenti.setContentAreaFilled(false);
        BottoneModificaUtenti.setHideActionText(true);
        BottoneModificaUtenti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneModificaUtenti.setName("BottoneModificaUtenti"); // NOI18N
        BottoneModificaUtenti.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(BottoneModificaUtenti)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BottoneModificaUtenti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneModificaUtenti.addActionListener(this);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BottoneModificaUtenti;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}