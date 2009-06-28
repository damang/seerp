
package it.seerp.Gui.Gestione.Utenti;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneUtente;
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
public class MenuUtente extends javax.swing.JPanel implements ActionListener {

    AreaUtentePanel pannello=null;
    private Subject ut_sub;
    /**
     *
     */
    public MenuUtente() {
         initComponents();
       }

    /** Creates new form MenuUtente
     * @param pannello
     */
    public MenuUtente(Subject s) {
        ut_sub=s;
        initComponents();
    }
    /**
     * Questo metoso permette di associare il pannello AreaUtente al menù MenuUtente
     * @param pannello, vine passato come parametro il pannello da associare al menù MenuUtente
     */
    public void setPannello(AreaUtentePanel pannello){
        this.pannello = pannello;
        pannello.setMenu(this);
        setEnabledByPerm();
        this.aggiungiButton1.setAreaUt(pannello);
        this.modificaButtonUtente1.setAreaUt(pannello);
        this.eliminaButton1.setAreaUt(pannello);
    }
     private void setEnabledByPerm() {
         if (pannello.getTipoUtente().equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
            this.aggiungiButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneResponsabili),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.AGGIUNGI))));
            this.modificaButtonUtente1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneResponsabili),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.MODIFICA))));
            this.eliminaButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneResponsabili),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELIMINA))));
        }
        else if (pannello.getTipoUtente().equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {
            this.aggiungiButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.AGGIUNGI))));
            this.modificaButtonUtente1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.MODIFICA))));
            this.eliminaButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELIMINA))));
        }
        else if (pannello.getTipoUtente().equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {
            this.aggiungiButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.AGGIUNGI))));
            this.modificaButtonUtente1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.MODIFICA))));
            this.eliminaButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELIMINA))));
        }
        else if (pannello.getTipoUtente().equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
            this.aggiungiButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.AGGIUNGI))));
            this.modificaButtonUtente1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.MODIFICA))));
            this.eliminaButton1.setEnabled(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti),PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELIMINA))));
        }
   }
    /**
     *
     * @return
     */
    public AreaUtentePanel getPannello() {
        return pannello;
    }
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aggiungiButton1 = new it.seerp.Gui.Gestione.Menu.AggiungiButtonUtenti(this);
        eliminaButton1 = new it.seerp.Gui.Gestione.Menu.EliminaButtonUtente(this);
        modificaButtonUtente1 = new it.seerp.Gui.Gestione.Menu.ModificaButtonUtente(this);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestione", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));

        aggiungiButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/user_add.png"))); // NOI18N
        aggiungiButton1.setToolTipText("Aggiungi");
        aggiungiButton1.setName("aggiungiButton1"); // NOI18N

        eliminaButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/user_remove.png"))); // NOI18N
        eliminaButton1.setToolTipText("Elimina");
        eliminaButton1.setName("eliminaButton1"); // NOI18N

        modificaButtonUtente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/application_edit.png"))); // NOI18N
        modificaButtonUtente1.setToolTipText("Modifica");
        modificaButtonUtente1.setName("modificaButtonUtente1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aggiungiButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificaButtonUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificaButtonUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aggiungiButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void actionPerformed(ActionEvent e) {
       CommandInterface cmd = (CommandInterface) e.getSource();
       cmd.execute();
    }

    /**
     *
     * @return
     */
    public JButton getModifica(){
      return modificaButtonUtente1;
  }

  public void setButtonEnabled (boolean b) {
      if (b)
          setEnabledByPerm();
      else {
        this.modificaButtonUtente1.setEnabled(b);
        this.aggiungiButton1.setEnabled(b);
        this.eliminaButton1.setEnabled(b);
      }
    }
    /**
     *
     * @return
     */
    public JButton getAggiungi(){
      return aggiungiButton1;
  }

    public Subject getUserSubject() {
        return ut_sub;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.Menu.AggiungiButtonUtenti aggiungiButton1;
    private it.seerp.Gui.Gestione.Menu.EliminaButtonUtente eliminaButton1;
    private it.seerp.Gui.Gestione.Menu.ModificaButtonUtente modificaButtonUtente1;
    // End of variables declaration//GEN-END:variables

}
