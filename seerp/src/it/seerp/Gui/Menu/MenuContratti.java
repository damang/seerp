/*
 * Economia.java
 *
 * Created on 29-mag-2009, 3.42.04
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class MenuContratti extends javax.swing.JPanel implements ActionListener {

    /** Creates new form Economia */
    public MenuContratti() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButton1 = new it.seerp.Gui.Menu.AggiungiButton(this);
        modificaButton1 = new it.seerp.Gui.Menu.ModificaButton(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contratti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/page_add.png"))); // NOI18N
        aggiungiButton1.setToolTipText("Aggiungi ");
        aggiungiButton1.setName("aggiungiButton1"); // NOI18N

        modificaButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/page_edit.png"))); // NOI18N
        modificaButton1.setToolTipText("Modifica");
        modificaButton1.setName("modificaButton1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(aggiungiButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aggiungiButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Menu.AggiungiButton aggiungiButton1;
    private it.seerp.Gui.Menu.ModificaButton modificaButton1;
    // End of variables declaration//GEN-END:variables

     public void actionPerformed(ActionEvent e) {
       CommandInterface cmd = (CommandInterface) e.getSource();
       cmd.execute();
    }
}
