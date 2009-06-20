/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AreaPersonalePanel.java
 *
 * Created on 28-mag-2009, 17.59.24
 */
package it.seerp.Gui.Gestione.Ruoli;

import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.observablePanel.ObservableJPanel;
import it.seerp.application.tabelle.RuoloTm;
import it.seerp.application.applicazione.AppRuoli;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiRuolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Andrea
 */
public class GestioneRuoli extends ObservableJPanel implements ActionListener {
    private TableModel tModel;
    private BeanGuiRuolo be;

    /** Creates new form AreaPersonalePanel
     * @throws SQLException
     */
    public GestioneRuoli() throws SQLException {
        tModel=new RuoloTm();
        be=new BeanGuiRuolo();
        initComponents();
        legameBean();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_nruolo = new javax.swing.JTextField();
        pan_gest = new javax.swing.JPanel();
        gest_cli = new javax.swing.JCheckBox();
        gest_for = new javax.swing.JCheckBox();
        gest_ser = new javax.swing.JCheckBox();
        gest_dip = new javax.swing.JCheckBox();
        gest_ruo = new javax.swing.JCheckBox();
        gest_contr = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        pan_gest_cli = new javax.swing.JPanel();
        cli_mod = new javax.swing.JCheckBox();
        cli_el = new javax.swing.JCheckBox();
        cli_ele = new javax.swing.JCheckBox();
        cli_ric = new javax.swing.JCheckBox();
        cli_agg = new javax.swing.JCheckBox();
        pan_gest_con = new javax.swing.JPanel();
        con_mod = new javax.swing.JCheckBox();
        con_el = new javax.swing.JCheckBox();
        con_ele = new javax.swing.JCheckBox();
        con_ric = new javax.swing.JCheckBox();
        con_agg = new javax.swing.JCheckBox();
        pan_gest_for = new javax.swing.JPanel();
        for_el = new javax.swing.JCheckBox();
        for_ele = new javax.swing.JCheckBox();
        for_ric = new javax.swing.JCheckBox();
        for_mod = new javax.swing.JCheckBox();
        for_agg = new javax.swing.JCheckBox();
        pan_gest_ser = new javax.swing.JPanel();
        ser_el = new javax.swing.JCheckBox();
        ser_ele = new javax.swing.JCheckBox();
        ser_ric = new javax.swing.JCheckBox();
        ser_mod = new javax.swing.JCheckBox();
        ser_agg = new javax.swing.JCheckBox();
        pan_gest_dip = new javax.swing.JPanel();
        dip_el = new javax.swing.JCheckBox();
        dip_ele = new javax.swing.JCheckBox();
        dip_ric = new javax.swing.JCheckBox();
        dip_mod = new javax.swing.JCheckBox();
        dip_agg = new javax.swing.JCheckBox();
        pan_gest_ruo = new javax.swing.JPanel();
        ruo_el = new javax.swing.JCheckBox();
        ruo_ele = new javax.swing.JCheckBox();
        ruo_ric = new javax.swing.JCheckBox();
        ruo_mod = new javax.swing.JCheckBox();
        ruo_agg = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jXFindBar3 = new org.jdesktop.swingx.JXFindBar();

        setBackground(new java.awt.Color(0, 204, 0));
        setMinimumSize(new java.awt.Dimension(500, 250));
        setLayout(new java.awt.GridBagLayout());

        jXLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel2.setText("Gestione Ruoli");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jXLabel2.setName("jXLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jXLabel2, gridBagConstraints);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(700, 450));
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1000, 564));

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel2.setMinimumSize(new java.awt.Dimension(695, 403));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 400));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Permesso"));
        jPanel3.setName("pan_nruolo"); // NOI18N

        txt_nruolo.setEnabled(false);
        txt_nruolo.setName("Nome Permesso"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nruolo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txt_nruolo)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(jPanel3, gridBagConstraints);
        jPanel3.getAccessibleContext().setAccessibleName("Nome Ruolo");

        pan_gest.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestioni"));
        pan_gest.setName("pan_gestioni"); // NOI18N
        pan_gest.setLayout(new java.awt.GridBagLayout());

        gest_cli.setText("Gestione Clienti");
        gest_cli.setEnabled(false);
        gest_cli.setName("GestioneClienti"); // NOI18N
        gest_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gest_cliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest.add(gest_cli, gridBagConstraints);

        gest_for.setText("Gestione Fornitori");
        gest_for.setEnabled(false);
        gest_for.setName("GestioneFornitori"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest.add(gest_for, gridBagConstraints);

        gest_ser.setText("Gestione Servizi");
        gest_ser.setEnabled(false);
        gest_ser.setName("GestioneServizi"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest.add(gest_ser, gridBagConstraints);

        gest_dip.setText("Gestione Dipendenti");
        gest_dip.setEnabled(false);
        gest_dip.setName("gest_dip"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pan_gest.add(gest_dip, gridBagConstraints);

        gest_ruo.setText("Gestione Ruoli");
        gest_ruo.setEnabled(false);
        gest_ruo.setName("gest_ruo"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest.add(gest_ruo, gridBagConstraints);

        gest_contr.setText("Gestione Contratti");
        gest_contr.setEnabled(false);
        gest_contr.setName("gest_contr"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest.add(gest_contr, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 0);
        jPanel2.add(pan_gest, gridBagConstraints);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Permessi"));
        jPanel14.setMinimumSize(new java.awt.Dimension(650, 169));
        jPanel14.setName("jPanel14"); // NOI18N
        jPanel14.setPreferredSize(new java.awt.Dimension(650, 169));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        pan_gest_cli.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Clienti"));
        pan_gest_cli.setName("pan_gest_cli"); // NOI18N
        pan_gest_cli.setLayout(new java.awt.GridBagLayout());

        cli_mod.setText("Modifica");
        cli_mod.setEnabled(false);
        cli_mod.setName("GestioneClientiModifica"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_cli.add(cli_mod, gridBagConstraints);

        cli_el.setText("Elimina");
        cli_el.setEnabled(false);
        cli_el.setName("GestioneClientiElimina"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_cli.add(cli_el, gridBagConstraints);

        cli_ele.setText("Elenca");
        cli_ele.setEnabled(false);
        cli_ele.setName("GestioneClientiElenca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_cli.add(cli_ele, gridBagConstraints);

        cli_ric.setText("Ricerca");
        cli_ric.setEnabled(false);
        cli_ric.setName("GestioneClientiRicerca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_cli.add(cli_ric, gridBagConstraints);

        cli_agg.setText("Aggiungi");
        cli_agg.setEnabled(false);
        cli_agg.setName("GestioneClientiAggiungi"); // NOI18N
        pan_gest_cli.add(cli_agg, new java.awt.GridBagConstraints());

        jPanel14.add(pan_gest_cli);

        pan_gest_con.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Contratti"));
        pan_gest_con.setName("pan_gest_con"); // NOI18N
        pan_gest_con.setLayout(new java.awt.GridBagLayout());

        con_mod.setText("Modifica");
        con_mod.setEnabled(false);
        con_mod.setName("GestioneContrttiModifica"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_con.add(con_mod, gridBagConstraints);

        con_el.setText("Elimina");
        con_el.setEnabled(false);
        con_el.setName("GestioneContrttiElimina"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_con.add(con_el, gridBagConstraints);

        con_ele.setText("Elenca");
        con_ele.setEnabled(false);
        con_ele.setName("GestioneContrttiElenca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_con.add(con_ele, gridBagConstraints);

        con_ric.setText("Ricerca");
        con_ric.setEnabled(false);
        con_ric.setName("GestioneContrttiRicerca"); // NOI18N
        con_ric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                con_ricActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_con.add(con_ric, gridBagConstraints);

        con_agg.setText("Aggiungi");
        con_agg.setEnabled(false);
        con_agg.setName("con_agg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_con.add(con_agg, gridBagConstraints);

        jPanel14.add(pan_gest_con);

        pan_gest_for.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Fornitori"));
        pan_gest_for.setName("pan_gest_for"); // NOI18N
        pan_gest_for.setLayout(new java.awt.GridBagLayout());

        for_el.setText("Elimina");
        for_el.setEnabled(false);
        for_el.setName("GestioneFornitoriElimina"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_for.add(for_el, gridBagConstraints);

        for_ele.setText("Elenca");
        for_ele.setEnabled(false);
        for_ele.setName("GestioneFornitoriElenca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_for.add(for_ele, gridBagConstraints);

        for_ric.setText("Ricerca");
        for_ric.setEnabled(false);
        for_ric.setName("GestioneFornitoriRicerca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_for.add(for_ric, gridBagConstraints);

        for_mod.setText("Modifica");
        for_mod.setEnabled(false);
        for_mod.setName("GestioneFornitoriModifica"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_for.add(for_mod, gridBagConstraints);

        for_agg.setText("Aggiungi");
        for_agg.setEnabled(false);
        for_agg.setName("for_agg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_for.add(for_agg, gridBagConstraints);

        jPanel14.add(pan_gest_for);

        pan_gest_ser.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Servizi"));
        pan_gest_ser.setName("pan_gest_ser"); // NOI18N
        pan_gest_ser.setLayout(new java.awt.GridBagLayout());

        ser_el.setText("Elimina");
        ser_el.setEnabled(false);
        ser_el.setName("GestioneServiziElimina"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ser.add(ser_el, gridBagConstraints);

        ser_ele.setText("Elenca");
        ser_ele.setEnabled(false);
        ser_ele.setName("GestioneServiziElenca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ser.add(ser_ele, gridBagConstraints);

        ser_ric.setText("Ricerca");
        ser_ric.setEnabled(false);
        ser_ric.setName("GestioneServiziRicerca"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ser.add(ser_ric, gridBagConstraints);

        ser_mod.setText("Modifica");
        ser_mod.setEnabled(false);
        ser_mod.setName("GestioneServiziModifica"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ser.add(ser_mod, gridBagConstraints);

        ser_agg.setText("Aggiungi");
        ser_agg.setEnabled(false);
        ser_agg.setName("ser_agg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ser.add(ser_agg, gridBagConstraints);

        jPanel14.add(pan_gest_ser);

        pan_gest_dip.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Dipendenti"));
        pan_gest_dip.setName("pan_gest_dip"); // NOI18N
        pan_gest_dip.setLayout(new java.awt.GridBagLayout());

        dip_el.setText("Elimina");
        dip_el.setEnabled(false);
        dip_el.setName("dip_el"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_dip.add(dip_el, gridBagConstraints);

        dip_ele.setText("Elenca");
        dip_ele.setEnabled(false);
        dip_ele.setName("dip_ele"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_dip.add(dip_ele, gridBagConstraints);

        dip_ric.setText("Ricerca");
        dip_ric.setEnabled(false);
        dip_ric.setName("dip_ric"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_dip.add(dip_ric, gridBagConstraints);

        dip_mod.setText("Modifica");
        dip_mod.setEnabled(false);
        dip_mod.setName("dip_mod"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_dip.add(dip_mod, gridBagConstraints);

        dip_agg.setText("Aggiungi");
        dip_agg.setEnabled(false);
        dip_agg.setName("dip_agg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_dip.add(dip_agg, gridBagConstraints);

        jPanel14.add(pan_gest_dip);

        pan_gest_ruo.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Ruoli"));
        pan_gest_ruo.setName("pan_gest_ruo"); // NOI18N
        pan_gest_ruo.setLayout(new java.awt.GridBagLayout());

        ruo_el.setText("Elimina");
        ruo_el.setEnabled(false);
        ruo_el.setName("ruo_el"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ruo.add(ruo_el, gridBagConstraints);

        ruo_ele.setText("Elenca");
        ruo_ele.setEnabled(false);
        ruo_ele.setName("ruo_ele"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ruo.add(ruo_ele, gridBagConstraints);

        ruo_ric.setText("Ricerca");
        ruo_ric.setEnabled(false);
        ruo_ric.setName("ruo_ric"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ruo.add(ruo_ric, gridBagConstraints);

        ruo_mod.setText("Modifica");
        ruo_mod.setEnabled(false);
        ruo_mod.setName("ruo_mod"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ruo.add(ruo_mod, gridBagConstraints);

        ruo_agg.setText("Aggiungi");
        ruo_agg.setEnabled(false);
        ruo_agg.setName("ruo_agg"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pan_gest_ruo.add(ruo_agg, gridBagConstraints);

        jPanel14.add(pan_gest_ruo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel14, gridBagConstraints);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Note"));
        jPanel17.setMinimumSize(new java.awt.Dimension(650, 133));
        jPanel17.setName("jPanel17"); // NOI18N
        jPanel17.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id","Cognome", "Nome"
            }
        ));
        jXTable2.setName("jXTable2"); // NOI18N
        jXTable2.setPreferredScrollableViewportSize(new java.awt.Dimension(300, 80));
        jXTable2.setPreferredSize(new java.awt.Dimension(300, 80));
        jScrollPane1.setViewportView(jXTable2);

        jPanel17.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel17, gridBagConstraints);
        jPanel17.getAccessibleContext().setAccessibleName("Personale");

        jTabbedPane1.addTab("Permessi", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(jTabbedPane1, gridBagConstraints);

        jXPanel1.setMinimumSize(new java.awt.Dimension(350, 300));
        jXPanel1.setName("jXPanel1"); // NOI18N
        jXPanel1.setPreferredSize(new java.awt.Dimension(350, 300));
        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Elenco ");
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel1.add(jLabel1, gridBagConstraints);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(300, 300));
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jXTable1.setModel(tModel);
        jXTable1.setName("jXTable1"); // NOI18N
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jXTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel1.add(jScrollPane2, gridBagConstraints);

        jXFindBar3.setMinimumSize(new java.awt.Dimension(10, 100));
        jXFindBar3.setName("jXFindBar3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel1.add(jXFindBar3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 31);
        add(jXPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        //JOptionPane.showMessageDialog(null, ));
        AppRuoli r= new AppRuoli();
        r.visualizzaDati((String)jXTable1.getValueAt(jXTable1.convertRowIndexToModel(jXTable1.getSelectedRow()), 0), be);
    }//GEN-LAST:event_jXTable1MouseClicked

    private void con_ricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_con_ricActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_con_ricActionPerformed

    private void gest_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gest_cliActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_gest_cliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cli_agg;
    private javax.swing.JCheckBox cli_el;
    private javax.swing.JCheckBox cli_ele;
    private javax.swing.JCheckBox cli_mod;
    private javax.swing.JCheckBox cli_ric;
    private javax.swing.JCheckBox con_agg;
    private javax.swing.JCheckBox con_el;
    private javax.swing.JCheckBox con_ele;
    private javax.swing.JCheckBox con_mod;
    private javax.swing.JCheckBox con_ric;
    private javax.swing.JCheckBox dip_agg;
    private javax.swing.JCheckBox dip_el;
    private javax.swing.JCheckBox dip_ele;
    private javax.swing.JCheckBox dip_mod;
    private javax.swing.JCheckBox dip_ric;
    private javax.swing.JCheckBox for_agg;
    private javax.swing.JCheckBox for_el;
    private javax.swing.JCheckBox for_ele;
    private javax.swing.JCheckBox for_mod;
    private javax.swing.JCheckBox for_ric;
    private javax.swing.JCheckBox gest_cli;
    private javax.swing.JCheckBox gest_contr;
    private javax.swing.JCheckBox gest_dip;
    private javax.swing.JCheckBox gest_for;
    private javax.swing.JCheckBox gest_ruo;
    private javax.swing.JCheckBox gest_ser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXFindBar jXFindBar3;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JPanel pan_gest;
    private javax.swing.JPanel pan_gest_cli;
    private javax.swing.JPanel pan_gest_con;
    private javax.swing.JPanel pan_gest_dip;
    private javax.swing.JPanel pan_gest_for;
    private javax.swing.JPanel pan_gest_ruo;
    private javax.swing.JPanel pan_gest_ser;
    private javax.swing.JCheckBox ruo_agg;
    private javax.swing.JCheckBox ruo_el;
    private javax.swing.JCheckBox ruo_ele;
    private javax.swing.JCheckBox ruo_mod;
    private javax.swing.JCheckBox ruo_ric;
    private javax.swing.JCheckBox ser_agg;
    private javax.swing.JCheckBox ser_el;
    private javax.swing.JCheckBox ser_ele;
    private javax.swing.JCheckBox ser_mod;
    private javax.swing.JCheckBox ser_ric;
    private javax.swing.JTextField txt_nruolo;
    // End of variables declaration//GEN-END:variables


    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }

    private void legameBean() {
        be.setNome(txt_nruolo);
        HashMap<String, ArrayList<BeanGuiPermesso>> listPermessi= new HashMap<String, ArrayList<BeanGuiPermesso>>();
        ArrayList<BeanGuiPermesso> perm1 = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiPermesso> perm2 = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiPermesso> perm3 = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiPermesso> perm4 = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiPermesso> perm5 = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiPermesso> perm6 = new ArrayList<BeanGuiPermesso>();
        perm1.add(new BeanGuiPermesso(this, cli_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti)));
        perm1.add(new BeanGuiPermesso(this, cli_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti)));
        perm1.add(new BeanGuiPermesso(this, cli_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti)));
        perm1.add(new BeanGuiPermesso(this, cli_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti)));
        perm1.add(new BeanGuiPermesso(this, cli_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti), perm1);
        perm2.add(new BeanGuiPermesso(this, ruo_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli)));
        perm2.add(new BeanGuiPermesso(this, ruo_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli)));
        perm2.add(new BeanGuiPermesso(this, ruo_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli)));
        perm2.add(new BeanGuiPermesso(this, ruo_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli)));
        perm2.add(new BeanGuiPermesso(this, ruo_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli), perm2);
        perm3.add(new BeanGuiPermesso(this, con_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti)));
        perm3.add(new BeanGuiPermesso(this, con_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti)));
        perm3.add(new BeanGuiPermesso(this, con_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti)));
        perm3.add(new BeanGuiPermesso(this, con_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti)));
        perm3.add(new BeanGuiPermesso(this, con_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti), perm3);
        
        perm4.add(new BeanGuiPermesso(this, for_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori)));
        perm4.add(new BeanGuiPermesso(this, for_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori)));
        perm4.add(new BeanGuiPermesso(this, for_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori)));
        perm4.add(new BeanGuiPermesso(this, for_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori)));
        perm4.add(new BeanGuiPermesso(this, for_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori), perm4);
        perm5.add(new BeanGuiPermesso(this, ser_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi)));
        perm5.add(new BeanGuiPermesso(this, ser_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi)));
        perm5.add(new BeanGuiPermesso(this, ser_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi)));
        perm5.add(new BeanGuiPermesso(this, ser_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi)));
        perm5.add(new BeanGuiPermesso(this, ser_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi), perm5);
        
        perm6.add(new BeanGuiPermesso(this, dip_agg,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti)));
        perm6.add(new BeanGuiPermesso(this, dip_mod,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti)));
        perm6.add(new BeanGuiPermesso(this, dip_el,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti)));
        perm6.add(new BeanGuiPermesso(this, dip_ele,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti)));
        perm6.add(new BeanGuiPermesso(this, dip_ric,PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti)));
        listPermessi.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti), perm6);
          
        be.setListPermessi(listPermessi);
        HashMap<String, JCheckBox> p_all=new HashMap<String, JCheckBox>();
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti), gest_dip);
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti), gest_cli);
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneContratti), gest_contr);
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori), gest_for);
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli), gest_ruo);
        p_all.put(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi), gest_ser);
        be.setPermGen(p_all);
    }



}