/*
 * Economia.java
 *
 * Created on 29-mag-2009, 3.42.04
 */

package it.seerp.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class Economia extends javax.swing.JPanel implements ActionListener {

    /** Creates new form Economia */
    public Economia() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BottoneBanche = new javax.swing.JButton();
        BottoneLiquidità = new javax.swing.JButton();
        BottoneModificaUtenti2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Econimia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        BottoneBanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/commercial-building-32x32.png"))); // NOI18N
        BottoneBanche.setToolTipText("Banche");
        BottoneBanche.setBorder(null);
        BottoneBanche.setContentAreaFilled(false);
        BottoneBanche.setHideActionText(true);
        BottoneBanche.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneBanche.setName("BottoneBanche"); // NOI18N
        BottoneBanche.setRequestFocusEnabled(false);

        BottoneLiquidità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/green-dollar-32x32.png"))); // NOI18N
        BottoneLiquidità.setToolTipText("Liquidità");
        BottoneLiquidità.setBorder(null);
        BottoneLiquidità.setContentAreaFilled(false);
        BottoneLiquidità.setHideActionText(true);
        BottoneLiquidità.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneLiquidità.setName("BottoneLiquidità"); // NOI18N
        BottoneLiquidità.setRequestFocusEnabled(false);

        BottoneModificaUtenti2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/Credit-Card-32x32.png"))); // NOI18N
        BottoneModificaUtenti2.setToolTipText("Pagamenti");
        BottoneModificaUtenti2.setBorder(null);
        BottoneModificaUtenti2.setContentAreaFilled(false);
        BottoneModificaUtenti2.setHideActionText(true);
        BottoneModificaUtenti2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneModificaUtenti2.setName("BottoneModificaUtenti2"); // NOI18N
        BottoneModificaUtenti2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BottoneBanche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BottoneLiquidità)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BottoneModificaUtenti2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BottoneModificaUtenti2)
                    .addComponent(BottoneLiquidità)
                    .addComponent(BottoneBanche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneBanche.addActionListener(this);
        BottoneBanche.addActionListener(this);
        BottoneBanche.addActionListener(this);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BottoneBanche;
    private javax.swing.JButton BottoneLiquidità;
    private javax.swing.JButton BottoneModificaUtenti2;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
