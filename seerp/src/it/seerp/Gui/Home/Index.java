package it.seerp.Gui.Home;

import java.sql.SQLException;



import configurazioni.CommandInterface;
import it.seerp.Gui.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.GestioneContratti.GestioneContratti;
import it.seerp.Gui.GestioneServizi.GestioneServizi;
import it.seerp.Gui.frame.ObservableJPanel;
import it.seerp.Gui.frame.ObservervableJTabbedPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class Index extends javax.swing.JFrame implements ActionListener {

    ObservervableJTabbedPanel areaPersonaleFrame;

    /** Creates new form Index */
    public Index() {
        areaPersonaleFrame = new ObservervableJTabbedPanel();
        initComponents();
        areaPersonaleFrame.register(areaPersonaleButton1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanePrincipale = new javax.swing.JTabbedPane();
        menu = new javax.swing.JPanel();
        menuUtente1 = new it.seerp.Gui.Menu.MenuUtente();
        menuContratti1 = new it.seerp.Gui.Menu.MenuContratti();
        menuServizi1 = new it.seerp.Gui.Menu.MenuServizi();
        menuAreaPersonale2 = new it.seerp.Gui.Menu.MenuAreaPersonale();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jPanel1 = new javax.swing.JPanel();
        try{
            areaUtenteButton1 = new it.seerp.bottoni.Nuovo.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton2 = new it.seerp.bottoni.Nuovo.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton3 = new it.seerp.bottoni.Nuovo.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton4 = new it.seerp.bottoni.Nuovo.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
            jXPanel2 = new org.jdesktop.swingx.JXPanel();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            buttonContratti1 = new it.seerp.bottoni.Nuovo.ButtonContratti(this.jTabbedPanePrincipale,this.menuContratti1,this);
            buttonServizi1 = new it.seerp.bottoni.Nuovo.ButtonServizi(this.jTabbedPanePrincipale,this.menuUtente1,this);
            jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
            jXPanel3 = new org.jdesktop.swingx.JXPanel();
            areaPersonaleButton1 = new it.seerp.bottoni.Nuovo.AreaPersonaleButton(this.jTabbedPanePrincipale, this.menuAreaPersonale2, this);
            menuBar = new javax.swing.JMenuBar();
            fileMenu = new javax.swing.JMenu();
            openMenuItem = new javax.swing.JMenuItem();
            saveMenuItem = new javax.swing.JMenuItem();
            saveAsMenuItem = new javax.swing.JMenuItem();
            exitMenuItem = new javax.swing.JMenuItem();
            editMenu = new javax.swing.JMenu();
            cutMenuItem = new javax.swing.JMenuItem();
            copyMenuItem = new javax.swing.JMenuItem();
            pasteMenuItem = new javax.swing.JMenuItem();
            deleteMenuItem = new javax.swing.JMenuItem();
            helpMenu = new javax.swing.JMenu();
            contentsMenuItem = new javax.swing.JMenuItem();
            aboutMenuItem = new javax.swing.JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jTabbedPanePrincipale.setName("jTabbedPanePrincipale"); // NOI18N
            jTabbedPanePrincipale.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jTabbedPanePrincipaleStateChanged(evt);
                }
            });

            menu.setName("menu"); // NOI18N

            menuUtente1.setName("menuUtente1"); // NOI18N

            menuContratti1.setName("menuContratti1"); // NOI18N

            menuServizi1.setName("menuServizi1"); // NOI18N

            menuAreaPersonale2.setName("menuAreaPersonale2"); // NOI18N

            javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
            menu.setLayout(menuLayout);
            menuLayout.setHorizontalGroup(
                menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menuUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(menuContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(menuServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(menuAreaPersonale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(881, Short.MAX_VALUE))
            );
            menuLayout.setVerticalGroup(
                menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayout.createSequentialGroup()
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(menuContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuAreaPersonale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            this.menuUtente1.setVisible(false);
            this.menuContratti1.setVisible(false);
            menuServizi1.setVisible(false);
            menuAreaPersonale2.setVisible(false);

            jXTaskPaneContainer1.setName("jXTaskPaneContainer1"); // NOI18N

            jXPanel1.setName("jXPanel1"); // NOI18N

            jXLabel1.setText("mes di benvenuto");
            jXLabel1.setName("jXLabel1"); // NOI18N

            javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
            jXPanel1.setLayout(jXPanel1Layout);
            jXPanel1Layout.setHorizontalGroup(
                jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jXPanel1Layout.setVerticalGroup(
                jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jXTaskPaneContainer1.add(jXPanel1);

            jXTaskPane1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/24x24/community_users.png"))); // NOI18N
            jXTaskPane1.setTitle("Gestione Utenti");
            jXTaskPane1.setName("jXTaskPane1"); // NOI18N

            jPanel1.setName("jPanel1"); // NOI18N

        }
        catch (SQLException e){ JOptionPane.showMessageDialog(null, "problemi di connessione");}
        areaUtenteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/User-32x32.png"))); // NOI18N
        areaUtenteButton1.setText("Responsabili");
        areaUtenteButton1.setContentAreaFilled(false);
        areaUtenteButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton1.setName("areaUtenteButton1"); // NOI18N
        areaUtenteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaUtenteButton1ActionPerformed(evt);
            }
        });

        areaUtenteButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/users.png"))); // NOI18N
        areaUtenteButton2.setText("Dipendenti");
        areaUtenteButton2.setContentAreaFilled(false);
        areaUtenteButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton2.setName("areaUtenteButton2"); // NOI18N
        areaUtenteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaUtenteButton2ActionPerformed(evt);
            }
        });

        areaUtenteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/TruckYellow-32x32.png"))); // NOI18N
        areaUtenteButton3.setText("Fornitori");
        areaUtenteButton3.setContentAreaFilled(false);
        areaUtenteButton3.setFocusable(false);
        areaUtenteButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton3.setName("areaUtenteButton3"); // NOI18N

        areaUtenteButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/community_users.png"))); // NOI18N
        areaUtenteButton4.setText("Clienti");
        areaUtenteButton4.setContentAreaFilled(false);
        areaUtenteButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton4.setName("areaUtenteButton4"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaUtenteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(areaUtenteButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(areaUtenteButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(areaUtenteButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaUtenteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaUtenteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaUtenteButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaUtenteButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTaskPane1.getContentPane().add(jPanel1);

        jXTaskPaneContainer1.add(jXTaskPane1);

        jXTaskPane2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/24x24/calculator.png"))); // NOI18N
        jXTaskPane2.setTitle("Contabilità");
        jXTaskPane2.setName("jXTaskPane2"); // NOI18N

        jXPanel2.setName("jXPanel2"); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/page.png"))); // NOI18N
        jButton1.setText("Fatture");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/note_edit.png"))); // NOI18N
        jButton2.setText("Preventivi");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonContratti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/page.png"))); // NOI18N
        buttonContratti1.setText("Contratti");
        buttonContratti1.setContentAreaFilled(false);
        buttonContratti1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonContratti1.setName("buttonContratti1"); // NOI18N

        buttonServizi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/shopping_cart.png"))); // NOI18N
        buttonServizi1.setText("Servizi");
        buttonServizi1.setContentAreaFilled(false);
        buttonServizi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonServizi1.setName("buttonServizi1"); // NOI18N
        buttonServizi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServizi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonContratti1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(buttonServizi1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXTaskPane2.getContentPane().add(jXPanel2);

        jXTaskPaneContainer1.add(jXTaskPane2);

        jXTaskPane3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/24x24/lock.png"))); // NOI18N
        jXTaskPane3.setTitle("Area Personale");
        jXTaskPane3.setName("jXTaskPane3"); // NOI18N

        jXPanel3.setName("jXPanel3"); // NOI18N

        areaPersonaleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/HP-Control-32x32.png"))); // NOI18N
        areaPersonaleButton1.setText("Area Personale"); // NOI18N
        areaPersonaleButton1.setContentAreaFilled(false);
        areaPersonaleButton1.setName("areaPersonaleButton1"); // NOI18N

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaPersonaleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areaPersonaleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTaskPane3.getContentPane().add(jXPanel3);

        jXTaskPaneContainer1.add(jXTaskPane3);

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save As ...");
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText("Help");

        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPanePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, 1894, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPanePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void areaPersonaleButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaPersonaleButtomActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_areaPersonaleButtomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonServizi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServizi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonServizi1ActionPerformed

    private void areaUtenteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaUtenteButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaUtenteButton2ActionPerformed

    private void areaUtenteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaUtenteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaUtenteButton1ActionPerformed

    private void jTabbedPanePrincipaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPanePrincipaleStateChanged
        if (jTabbedPanePrincipale.getTabCount() > 0) {

            ObservableJPanel p = (ObservableJPanel) jTabbedPanePrincipale.getComponentAt(jTabbedPanePrincipale.getSelectedIndex());
            if (p.getClass().equals(AreaUtentePanel.class)) {
                this.menuContratti1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuUtente1.setVisible(true);
                this.menuUtente1.setPannello((AreaUtentePanel) p);
            } else if (p.getClass().equals(GestioneContratti.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuContratti1.setVisible(true);
                this.menuContratti1.setPannello((GestioneContratti)p);
            } else if (p.getClass().equals(GestioneServizi.class)) {
                this.menuContratti1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuUtente1.setVisible(false);
                this.menuServizi1.setVisible(true);
                this.menuServizi1.setPannello((GestioneServizi)p);
            } else if (p.getClass().equals(AreaPersonalePanel.class)) {
                this.menuContratti1.setVisible(false);
                this.menuUtente1.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuAreaPersonale2.setVisible(true);
            }}
            else
            {
                this.menuContratti1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuUtente1.setVisible(false);
                this.menuServizi1.setVisible(false);}
        
    }//GEN-LAST:event_jTabbedPanePrincipaleStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private it.seerp.bottoni.Nuovo.AreaPersonaleButton areaPersonaleButton1;
    private it.seerp.bottoni.Nuovo.AreaUtenteButton areaUtenteButton1;
    private it.seerp.bottoni.Nuovo.AreaUtenteButton areaUtenteButton2;
    private it.seerp.bottoni.Nuovo.AreaUtenteButton areaUtenteButton3;
    private it.seerp.bottoni.Nuovo.AreaUtenteButton areaUtenteButton4;
    private it.seerp.bottoni.Nuovo.ButtonContratti buttonContratti1;
    private it.seerp.bottoni.Nuovo.ButtonServizi buttonServizi1;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPanePrincipale;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JPanel menu;
    private it.seerp.Gui.Menu.MenuAreaPersonale menuAreaPersonale2;
    private javax.swing.JMenuBar menuBar;
    private it.seerp.Gui.Menu.MenuContratti menuContratti1;
    private it.seerp.Gui.Menu.MenuServizi menuServizi1;
    private it.seerp.Gui.Menu.MenuUtente menuUtente1;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
