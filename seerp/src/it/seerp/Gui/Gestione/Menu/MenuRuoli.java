
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class MenuRuoli extends javax.swing.JPanel implements ActionListener {

    GestioneRuoli pannello = null;

    /** Creates new form Preventivi */
    public  MenuRuoli() {
        initComponents();
    }

    /**
     *
     * @param pannello
     */
    public void setPannello(GestioneRuoli pannello) {

        this.pannello = pannello;
        pannello.setMenu(this);
        this.modificaButtonRuoli1.setArea(pannello);
        this.aggiungiButtonRuoli1.setArea(pannello);
        this.eliminaButtonRuoli1.setArea(pannello);

    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButtonRuoli1 = new it.seerp.Gui.Gestione.Menu.AggiungiButtonRuoli(this);
        eliminaButtonRuoli1 = new it.seerp.Gui.Gestione.Menu.EiminaButtonRuoli(this);
        modificaButtonRuoli1 = new it.seerp.Gui.Gestione.Menu.ModificaButtonRuoli(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ruoli", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButtonRuoli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/add.png"))); // NOI18N
        aggiungiButtonRuoli1.setToolTipText("Aggiungi");
        aggiungiButtonRuoli1.setName("aggiungiButtonRuoli1"); // NOI18N

        eliminaButtonRuoli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/remove.png"))); // NOI18N
        eliminaButtonRuoli1.setToolTipText("Elimina");
        eliminaButtonRuoli1.setName("eliminaButtonRuoli1"); // NOI18N

        modificaButtonRuoli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/application_edit.png"))); // NOI18N
        modificaButtonRuoli1.setToolTipText("Modifica");
        modificaButtonRuoli1.setName("modificaButtonRuoli1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminaButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificaButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminaButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aggiungiButtonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.Menu.AggiungiButtonRuoli aggiungiButtonRuoli1;
    private it.seerp.Gui.Gestione.Menu.EiminaButtonRuoli eliminaButtonRuoli1;
    private it.seerp.Gui.Gestione.Menu.ModificaButtonRuoli modificaButtonRuoli1;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
    public void setButtonEnabled (boolean b) {
        this.modificaButtonRuoli1.setEnabled(b);
        this.aggiungiButtonRuoli1.setEnabled(b);
        this.eliminaButtonRuoli1.setEnabled(b);
    }
}
