/*
 * Economia.java
 *
 * Created on 29-mag-2009, 3.42.04
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;

import it.seerp.Gui.GestioneContratti.GestioneContratti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class MenuContratti extends javax.swing.JPanel implements ActionListener {
    GestioneContratti contratti=null;
      /** Creates new form Economia */
    public MenuContratti() {
     initComponents();
    }


    public void setPannello(GestioneContratti contratti) {
        this.contratti = contratti;
        this.aggiungiButtonContratti1.setAreaContratti(contratti);
        this.modificaButtonContratti1.setAreaContratti(contratti);
        
    }

  

 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButtonContratti1 = new it.seerp.Gui.Menu.AggiungiButtonContratti(this);
        modificaButtonContratti1 = new it.seerp.Gui.Menu.ModificaButtonContratti(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contratti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButtonContratti1.setText("aggiungiButtonContratti1");
        aggiungiButtonContratti1.setName("aggiungiButtonContratti1"); // NOI18N

        modificaButtonContratti1.setText("modificaButtonContratti1");
        modificaButtonContratti1.setName("modificaButtonContratti1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(modificaButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aggiungiButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificaButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Menu.AggiungiButtonContratti aggiungiButtonContratti1;
    private it.seerp.Gui.Menu.ModificaButtonContratti modificaButtonContratti1;
    // End of variables declaration//GEN-END:variables

     public void actionPerformed(ActionEvent e) {
       CommandInterface cmd = (CommandInterface) e.getSource();
       cmd.execute();
    }
}
