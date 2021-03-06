package it.seerp.Gui.Gestione.InfoAzienda;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva;
import it.seerp.Gui.Gestione.InfoAzienda.MenuInfoAzienda;
import it.seerp.Gui.observablePanel.ObservableJPanel;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiAzienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import it.seerp.application.applicazione.AppAzienda;
import java.awt.Color;

/**
 *
 * @author Andrea-Luisa
 */
public class InfoAzienda extends ObservableJPanel implements ActionListener {

    BeanGuiAzienda azienda;
    MenuInfoAzienda menu;

    /**
     * Permette di associare il menu all'area Azienda.
     * @param menu viene passato il menù da passare al campo
     *
     */
    public void setMenu(MenuInfoAzienda menu) {
        try {
            this.menu = menu;
            azienda = new BeanGuiAzienda(this);
            legameBean();
            AppAzienda operazione = new AppAzienda();
            operazione.visualizzaAzienda(azienda);
            editabile(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore dal database: "+ex.getErrorCode());
        }
    }

    /**
     * il metodo che permette di rendere editabile o menoo i campi presenti nella grafica
     * @ flag che permette di modificare i campi presenti sul form.
     */
    public void editabile(boolean flag) {

        mail.setEnabled(flag);
        nm.setBackground(Color.WHITE);
        piva.setEnabled(flag);
        piva.setBackground(Color.WHITE);
        tell.setEnabled(flag);
        tell.setBackground(Color.WHITE);
        via.setEnabled(flag);
        via.setBackground(Color.WHITE);
        nm.setEnabled(flag);
        mail.setBackground(Color.WHITE);
        naz.setEnabled(flag);
        naz.setBackground(Color.WHITE);

    }

    /**
     *
     */
    public void legameBean() {
        azienda.setEmail(mail);
        azienda.setPIVA(piva);
        azienda.setInidirizzo(via);
        azienda.setRagioneSociale(nm);
        azienda.setNazione(naz);
        azienda.setTelefono(tell);

    }

    /** Creates new form NewJPanel */
    public InfoAzienda() {
        initComponents();
    }

    /**
     * Il metodo restituisce il pulsante Salva
     * @ restituisce il riferimento al pulsate Salva
     */
    public ButtonSalva getSalva() {
        return this.buttonSalva1;

    }

    /**
     * Il metodo restituisce il pulsante Annulla
     * @restituisce il riferimento al pulsate Annulla
     */
    public ButtonAnnulla getAnnulla() {
        return this.buttonAnnulla1;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jPanel5 = new javax.swing.JPanel();
        nm = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        tell = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        naz = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        mail = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        piva = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        via = new javax.swing.JTextField();
        buttonAnnulla1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla();
        buttonSalva1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva();

        setBackground(new java.awt.Color(0, 102, 102));

        jXLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel4.setText("Info Azienda");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 1, 24));
        jXLabel4.setName("jXLabel4"); // NOI18N

        jXPanel1.setName("jXPanel1"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ragione Sociale"));
        jPanel5.setName("jPanel5"); // NOI18N

        nm.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nm.setFocusCycleRoot(true);
        nm.setName("nm"); // NOI18N
        nm.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tell"));
        jPanel10.setName("citta"); // NOI18N

        tell.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        tell.setFocusCycleRoot(true);
        tell.setName("tell"); // NOI18N
        tell.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tell, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(tell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Nazione"));
        jPanel11.setName("jPanel11"); // NOI18N

        naz.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        naz.setFocusCycleRoot(true);
        naz.setName("naz"); // NOI18N
        naz.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(naz, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(naz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("E-Mail"));
        jPanel12.setName("jPanel12"); // NOI18N

        mail.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        mail.setFocusCycleRoot(true);
        mail.setName("mail"); // NOI18N
        mail.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("P.IVA"));
        jPanel13.setName("jPanel13"); // NOI18N

        piva.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        piva.setFocusCycleRoot(true);
        piva.setName("piva"); // NOI18N
        piva.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(piva, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(piva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Indirizzo"));
        jPanel14.setName("jPanel14"); // NOI18N

        via.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        via.setFocusCycleRoot(true);
        via.setName("via"); // NOI18N
        via.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(via, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(via, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(197, 197, 197))
        );

        jPanel5.getAccessibleContext().setAccessibleName("");

        buttonAnnulla1.setName("buttonAnnulla1"); // NOI18N
        buttonAnnulla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAnnulla1MouseClicked(evt);
            }
        });

        buttonSalva1.setName("buttonSalva1"); // NOI18N
        buttonSalva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSalva1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalva1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalva1MouseClicked
        try {
            menu.getModifica().setEnabled(true);
            editabile(true);
            AppAzienda operazione = new AppAzienda();
            operazione.modifica(azienda);
            operazione.visualizzaAzienda(azienda);
            editabile(false);
            this.buttonAnnulla1.setEnabled(false);
            this.buttonSalva1.setEnabled(false);
        } catch (ValidatorException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore nel database: "+ ex.getErrorCode());
        }
    }//GEN-LAST:event_buttonSalva1MouseClicked

    private void buttonAnnulla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAnnulla1MouseClicked
        menu.getModifica().setEnabled(true);
        JOptionPane.showMessageDialog(null, "operazione annulata");
        editabile(false);
        this.buttonAnnulla1.setEnabled(false);
        this.buttonSalva1.setEnabled(false);
    }//GEN-LAST:event_buttonAnnulla1MouseClicked

    private void nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla buttonAnnulla1;
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva buttonSalva1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel5;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField naz;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField piva;
    private javax.swing.JTextField tell;
    private javax.swing.JTextField via;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
