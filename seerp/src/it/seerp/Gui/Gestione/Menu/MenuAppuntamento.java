/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * Created on 10-giu-2009, 22.33.09
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class MenuAppuntamento extends javax.swing.JPanel implements ActionListener {

    GestioneRuoli pannello = null;

    /** Creates new form Preventivi */
    public  MenuAppuntamento() {
        initComponents();
    }

    /**
     *
     * @param pannello
     */
    public void setPannello(GestioneRuoli pannello) {

        this.pannello = pannello;
   /*     this.modificaButtonServizi1.setAreaServizi(pannello);
        this.aggiungiButtonServizi1.setServizi(pannello);
        this.eiminaButtonServizi1.setAreaServ(pannello);*/

    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButtonAppuntamento1 = new it.seerp.Gui.Gestione.Menu.AggiungiButtonAppuntamento();
        eiminaButtonAppuntamento1 = new it.seerp.Gui.Gestione.Menu.EiminaButtonAppuntamento();
        modificaButtonAppuntamento1 = new it.seerp.Gui.Gestione.Menu.ModificaButtonAppuntamento();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Appuntamenti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButtonAppuntamento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/add.png"))); // NOI18N
        aggiungiButtonAppuntamento1.setToolTipText("Aggiungi");
        aggiungiButtonAppuntamento1.setName("aggiungiButtonAppuntamento1"); // NOI18N

        eiminaButtonAppuntamento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/remove.png"))); // NOI18N
        eiminaButtonAppuntamento1.setToolTipText("Elimina");
        eiminaButtonAppuntamento1.setName("eiminaButtonAppuntamento1"); // NOI18N

        modificaButtonAppuntamento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/application_edit.png"))); // NOI18N
        modificaButtonAppuntamento1.setToolTipText("Modifica");
        modificaButtonAppuntamento1.setName("modificaButtonAppuntamento1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiminaButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eiminaButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificaButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aggiungiButtonAppuntamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.Menu.AggiungiButtonAppuntamento aggiungiButtonAppuntamento1;
    private it.seerp.Gui.Gestione.Menu.EiminaButtonAppuntamento eiminaButtonAppuntamento1;
    private it.seerp.Gui.Gestione.Menu.ModificaButtonAppuntamento modificaButtonAppuntamento1;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
