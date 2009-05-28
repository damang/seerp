/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewApplication.java
 *
 * Created on 25-mag-2009, 17.18.07
 */

package it.seerp.Home;

import configurazioni.CommandInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrea
 */
public class Home extends javax.swing.JFrame implements ActionListener {

    /** Creates new form NewApplication */
    public Home() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        BottoneResponsabili = new javax.swing.JButton();
        BottoneDipendenti = new javax.swing.JButton();
        BottoneFornitori = new javax.swing.JButton();
        BottoneClienti = new javax.swing.JButton();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        BottoneFatture = new javax.swing.JButton();
        BottoneContratti = new javax.swing.JButton();
        BottonePreventivi = new javax.swing.JButton();
        BottoneBanche = new javax.swing.JButton();
        jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXMonthView1 = new org.jdesktop.swingx.JXMonthView();
        jXPanel5 = new org.jdesktop.swingx.JXPanel();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
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

        jXLabel1.setText("Messaggio di Benvenuto");

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTaskPaneContainer1.add(jXPanel4);

        jXTaskPane1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/16x16/community_users.png"))); // NOI18N
        jXTaskPane1.setTitle("Gestione Utenti");

        BottoneResponsabili.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/User-32x32.png"))); // NOI18N
        BottoneResponsabili.setText("Responsabili");
        BottoneResponsabili.setBorder(null);
        BottoneResponsabili.setContentAreaFilled(false);
        BottoneResponsabili.setHideActionText(true);
        BottoneResponsabili.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneResponsabili.setRequestFocusEnabled(false);

        BottoneDipendenti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/user.png"))); // NOI18N
        BottoneDipendenti.setText("Dipendenti");
        BottoneDipendenti.setBorder(null);
        BottoneDipendenti.setBorderPainted(false);
        BottoneDipendenti.setContentAreaFilled(false);
        BottoneDipendenti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneDipendenti.setRequestFocusEnabled(false);

        BottoneFornitori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/TruckYellow-32x32.png"))); // NOI18N
        BottoneFornitori.setText("Fornitori");
        BottoneFornitori.setBorder(null);
        BottoneFornitori.setBorderPainted(false);
        BottoneFornitori.setContentAreaFilled(false);
        BottoneFornitori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneFornitori.setRequestFocusEnabled(false);

        BottoneClienti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/users.png"))); // NOI18N
        BottoneClienti.setText("Clienti");
        BottoneClienti.setBorder(null);
        BottoneClienti.setBorderPainted(false);
        BottoneClienti.setContentAreaFilled(false);
        BottoneClienti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneClienti.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BottoneClienti, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottoneFornitori, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottoneDipendenti, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottoneResponsabili, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addComponent(BottoneResponsabili)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneDipendenti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneFornitori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneClienti)
                .addContainerGap())
        );

        BottoneResponsabili.addActionListener(this);
        BottoneDipendenti.addActionListener(this);
        BottoneFornitori.addActionListener(this);
        BottoneClienti.addActionListener(this);

        jXTaskPane1.getContentPane().add(jXPanel1);

        jXTaskPaneContainer1.add(jXTaskPane1);

        jXTaskPane2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/16x16/calculator.png"))); // NOI18N
        jXTaskPane2.setTitle("Contabilità");

        BottoneFatture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/page.png"))); // NOI18N
        BottoneFatture.setText("Fatture");
        BottoneFatture.setBorder(null);
        BottoneFatture.setContentAreaFilled(false);
        BottoneFatture.setHideActionText(true);
        BottoneFatture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneFatture.setRequestFocusEnabled(false);
        BottoneFatture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneFattureActionPerformed(evt);
            }
        });

        BottoneContratti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/application.png"))); // NOI18N
        BottoneContratti.setText("Contratti");
        BottoneContratti.setBorder(null);
        BottoneContratti.setContentAreaFilled(false);
        BottoneContratti.setHideActionText(true);
        BottoneContratti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneContratti.setRequestFocusEnabled(false);

        BottonePreventivi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/notes_edit.png"))); // NOI18N
        BottonePreventivi.setText("Preventivi");
        BottonePreventivi.setBorder(null);
        BottonePreventivi.setContentAreaFilled(false);
        BottonePreventivi.setHideActionText(true);
        BottonePreventivi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottonePreventivi.setRequestFocusEnabled(false);

        BottoneBanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/icone/32x32/commercial-building-32x32.png"))); // NOI18N
        BottoneBanche.setText("Banche");
        BottoneBanche.setBorder(null);
        BottoneBanche.setContentAreaFilled(false);
        BottoneBanche.setHideActionText(true);
        BottoneBanche.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BottoneBanche.setRequestFocusEnabled(false);
        BottoneBanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneBancheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BottoneContratti, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottoneFatture, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottonePreventivi, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
            .addComponent(BottoneBanche, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addComponent(BottoneFatture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneContratti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottonePreventivi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneBanche)
                .addContainerGap())
        );

        BottoneFatture.addActionListener(this);
        BottoneResponsabili.addActionListener(this);
        BottoneResponsabili.addActionListener(this);
        BottoneResponsabili.addActionListener(this);

        jXTaskPane2.getContentPane().add(jXPanel2);

        jXTaskPaneContainer1.add(jXTaskPane2);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jXTaskPane3.getContentPane().add(jXPanel3);

        jXTaskPaneContainer1.add(jXTaskPane3);

        jXMonthView1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jXTaskPaneContainer1.add(jXMonthView1);

        jXPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jXPanel5Layout = new javax.swing.GroupLayout(jXPanel5);
        jXPanel5.setLayout(jXPanel5Layout);
        jXPanel5Layout.setHorizontalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jXPanel5Layout.setVerticalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jXPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jXPanel6Layout = new javax.swing.GroupLayout(jXPanel6);
        jXPanel6.setLayout(jXPanel6Layout);
        jXPanel6Layout.setHorizontalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        jXPanel6Layout.setVerticalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

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
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void BottoneFattureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneFattureActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_BottoneFattureActionPerformed

    private void BottoneBancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneBancheActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_BottoneBancheActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BottoneBanche;
    private javax.swing.JButton BottoneClienti;
    private javax.swing.JButton BottoneContratti;
    private javax.swing.JButton BottoneDipendenti;
    private javax.swing.JButton BottoneFatture;
    private javax.swing.JButton BottoneFornitori;
    private javax.swing.JButton BottonePreventivi;
    private javax.swing.JButton BottoneResponsabili;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXMonthView jXMonthView1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXPanel jXPanel5;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
       CommandInterface cmd = (CommandInterface)e.getSource();
       cmd.execute();
    }

}
