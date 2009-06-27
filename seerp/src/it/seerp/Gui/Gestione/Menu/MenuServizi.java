
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.jaas.JaasUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.security.auth.Subject;
import javax.swing.JButton;

/**
 *
 * @author Andrea-Luisa
 */
public class MenuServizi extends javax.swing.JPanel implements ActionListener {

    GestioneServizi pannello = null;
    private Subject ut_sub;

    /** Creates new form Preventivi */
    public MenuServizi() {
        initComponents();
    }
    public MenuServizi(Subject s) {
        ut_sub=s;
        initComponents();
    }

    /**
     * questo metodo permette di associare il pannello GestioneServizi al MenuServizi
     * @param pannello, vine passato come parametro il pannello da associare al MenuServizi
     */
    public void setPannello(GestioneServizi pannello) {

        this.pannello = pannello;
        pannello.setMenu(this);

        setEnabledByPerm();

        this.modificaButtonServizi1.setAreaServizi(pannello);
        this.aggiungiButtonServizi1.setServizi(pannello);
  

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButtonServizi1 = new it.seerp.Gui.Gestione.Menu.AggiungiButtonServizi(this);
        modificaButtonServizi1 = new it.seerp.Gui.Gestione.Menu.ModificaButtonServizi(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Servizi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButtonServizi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/shopping_cart_down.png"))); // NOI18N
        aggiungiButtonServizi1.setToolTipText("Aggiungi");
        aggiungiButtonServizi1.setName("aggiungiButtonServizi1"); // NOI18N
        aggiungiButtonServizi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonServizi1ActionPerformed(evt);
            }
        });

        modificaButtonServizi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/window_edit.png"))); // NOI18N
        modificaButtonServizi1.setToolTipText("Modifica");
        modificaButtonServizi1.setName("modificaButtonServizi1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButtonServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificaButtonServizi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificaButtonServizi1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(aggiungiButtonServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiButtonServizi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonServizi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aggiungiButtonServizi1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.Menu.AggiungiButtonServizi aggiungiButtonServizi1;
    private it.seerp.Gui.Gestione.Menu.ModificaButtonServizi modificaButtonServizi1;
    // End of variables declaration//GEN-END:variables



    /**
     *
     * @return
     */
    public JButton getModifica() {
        return modificaButtonServizi1;
    }

        /**
         *
         * @return
         */
        public JButton getAggiungi() {
        return aggiungiButtonServizi1;
    }
          public void setButtonEnabled (boolean b) {
        if(b)
            setEnabledByPerm();
        else {
                this.modificaButtonServizi1.setEnabled(b);
                this.aggiungiButtonServizi1.setEnabled(b);
        }
    }
    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }

    private void setEnabledByPerm() {
        this.aggiungiButtonServizi1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.AGGIUNGI))));
        this.modificaButtonServizi1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.MODIFICA))));
    }
}
