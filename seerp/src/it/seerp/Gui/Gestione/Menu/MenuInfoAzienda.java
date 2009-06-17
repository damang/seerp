/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Preventivi.java
 *
 * Created on 10-giu-2009, 22.33.09
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.Gestione.InfoAzienda.InfoAzienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class MenuInfoAzienda extends javax.swing.JPanel implements ActionListener {

    InfoAzienda pannello = null;

    /** Creates new form Preventivi */
    public MenuInfoAzienda() {
        initComponents();
    }

    public void setPannello(InfoAzienda infoAzienda) {
        this.pannello = infoAzienda;
        pannello.setMenu(this);
        this.modificaButtonInfoAzienda1.setnIfoAzienda(pannello);
    }

    public JButton getModifica() {
        return modificaButtonInfoAzienda1;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        modificaButtonInfoAzienda1 = new it.seerp.Gui.Gestione.Menu.ModificaButtonInfoAzienda(this);

        jXTaskPane1.setName("jXTaskPane1"); // NOI18N

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Azienda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        modificaButtonInfoAzienda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/application_edit.png"))); // NOI18N
        modificaButtonInfoAzienda1.setToolTipText("Modifica");
        modificaButtonInfoAzienda1.setName("modificaButtonInfoAzienda1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modificaButtonInfoAzienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modificaButtonInfoAzienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private it.seerp.Gui.Gestione.Menu.ModificaButtonInfoAzienda modificaButtonInfoAzienda1;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
