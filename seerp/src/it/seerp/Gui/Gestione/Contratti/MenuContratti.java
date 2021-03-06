
package it.seerp.Gui.Gestione.Contratti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;

import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class MenuContratti extends javax.swing.JPanel implements ActionListener {

    GestioneContratti contratti = null;

    /** Creates new form Economia */
    public MenuContratti() {
        initComponents();
    }

    /**
     ** questo metodo associa il pannello Gestione Contratti al menù gestone contratti
     * @param contratti vine passato come parametro il pannello da associare al menù agenda
     */
    public void setPannello(GestioneContratti contratti) {
        this.contratti = contratti;
        contratti.setMenu(this);
        this.aggiungiButtonContratti1.setAreaContratti(contratti);
        this.modificaButtonContratti1.setAreaContratti(contratti);

    }

    /**
     *
     * @return
     */
    public JButton getModifica() {
        return modificaButtonContratti1;
    }

    /**
     *
     * @return
     */
    public JButton getAggiungi() {
        return aggiungiButtonContratti1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButtonContratti1 = new it.seerp.Gui.Gestione.Contratti.AggiungiButtonContratti(this);
        modificaButtonContratti1 = new it.seerp.Gui.Gestione.Contratti.ModificaButtonContratti(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contratti", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButtonContratti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/page_add.png"))); // NOI18N
        aggiungiButtonContratti1.setToolTipText("Aggiungi");
        aggiungiButtonContratti1.setName("aggiungiButtonContratti1"); // NOI18N

        modificaButtonContratti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/page_edit.png"))); // NOI18N
        modificaButtonContratti1.setToolTipText("Modifica");
        modificaButtonContratti1.setName("modificaButtonContratti1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aggiungiButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificaButtonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.Contratti.AggiungiButtonContratti aggiungiButtonContratti1;
    private it.seerp.Gui.Gestione.Contratti.ModificaButtonContratti modificaButtonContratti1;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
