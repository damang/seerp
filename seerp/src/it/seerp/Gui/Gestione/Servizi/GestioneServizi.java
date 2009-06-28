package it.seerp.Gui.Gestione.Servizi;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva;
import it.seerp.Gui.Gestione.Servizi.MenuServizi;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import it.seerp.Gui.observablePanel.ObservableJPanel;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.AppServizi;
import it.seerp.application.applicazione.bean.BeanGuiFornitore;
import it.seerp.application.applicazione.bean.BeanGuiServizio;
import it.seerp.application.bean.tabelle.ServiziTm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andrea-Luisa
 */
public class GestioneServizi extends ObservableJPanel implements ActionListener {

    ConfigurazioneOperazioni.TIPO_OPE_CONST tipoOp;
    BeanGuiServizio servi;
    String tipoOP;
    MenuServizi menu;

    /**
     * Metodo che associa il menù relativo al form
     * @return restituoisce un istanza di menù
     */
    public MenuServizi getMenu() {
        return menu;
    }
    ServiziTm tableModel = new ServiziTm();
    ;

    /**
     * Metodo che setta il menù
     * @param menu restituisce il menù
     */
    public void setMenu(MenuServizi menu) {
        this.menu = menu;
    }

    /**
     *questo metodo setta il form a secodna del tipo di utente passato
     * @param tipo viene passato il tipo di utente
     */
    public void setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST tipo) {
        this.tipoOp = tipo;
    }

    /** Creates new form GestioneContratti
     * @throws SQLException
     */
    public GestioneServizi() throws SQLException {
        initComponents();

        this.servi = new BeanGuiServizio(this);

        legameBeans();
        editabile(false);

    }

    /**
     * il metodo che permette di rendere editabile o menoo i campi presenti nella grafica
     * @ flag che permette di modificare i campi presenti sul form.
     */
    public void editabile(boolean flag) {


        qnt.setEnabled(flag);
        qnt.setBackground(Color.WHITE);
        prz.setEnabled(flag);
        prz.setBackground(Color.WHITE);
        disponibilita.setEnabled(flag);
        disponibilita.setBackground(Color.WHITE);
        tipo.setEnabled(flag);
        tipo.setBackground(Color.WHITE);
        iva.setEnabled(flag);
        iva.setBackground(Color.WHITE);
        descrizione.setEnabled(flag);
        descrizione.setBackground(Color.WHITE);
        jTextArea1.setEditable(flag);
        

    }

    /**
     * Il metodo permette di inizzalizzare i campi persenti sul form.
     * @ s sringa che permette l'inalizzazione, permette di inizzializare tutti i campi sul form.
     */
    public void inizializza(String s) {

        qnt.setText(s);
        prz.setText(s);
        disponibilita.setSelected(false);
        tipo.setText(s);
        iva.setText(s);
        descrizione.setText(s);

    }

    /**
     * 
     */
    public void legameBeans() {

        servi.setDisponibilita(disponibilita);
        servi.setTipo(tipo);
        servi.setPrezzo(prz);
        servi.setQuantita(qnt);
        servi.setDescrizione(descrizione);
        servi.setIva(iva);
        servi.setNote(jTextArea1);

    }

    /**
     * questo metodo 
     * @return
     */
    public ButtonSalva getSalva() {
        return this.buttonSalva1;
    }

    /**
     *
     * @return
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        qnt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        tipo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        prz = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        disponibilita = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        descrizione = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        iva = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jXFindBar1 = new JXFindBar(this.jXTable1.getSearchable());
        buttonAnnulla1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla();
        buttonSalva1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva();

        setBackground(new java.awt.Color(255, 255, 102));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantità"));
        jPanel4.setName("jPanel4"); // NOI18N

        qnt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        qnt.setName("Quantita"); // NOI18N
        qnt.setSelectedTextColor(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qnt, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(qnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        jPanel5.setName("jPanel5"); // NOI18N

        tipo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tipo.setName("Tipo"); // NOI18N
        tipo.setSelectedTextColor(new java.awt.Color(255, 0, 51));
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Prezzo"));
        jPanel7.setName("jPanel7"); // NOI18N

        prz.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        prz.setName("Prezzo"); // NOI18N
        prz.setSelectedTextColor(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prz, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(prz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Disponibilità"));
        jPanel8.setName("jPanel8"); // NOI18N

        disponibilita.setName("disponibilita"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(disponibilita)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(disponibilita)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Note"));
        jPanel10.setName("jPanel10"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrizione Del Prodotto"));
        jPanel11.setName("jPanel11"); // NOI18N

        descrizione.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descrizione.setName("descrizione"); // NOI18N
        descrizione.setSelectedTextColor(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(descrizione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA"));
        jPanel20.setName("jPanel20"); // NOI18N

        iva.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        iva.setName("Iva"); // NOI18N
        iva.setSelectedTextColor(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iva, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, 0, 466, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel20, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );

        jTabbedPane1.addTab("Dettagli Servizi", jPanel1);

        jXLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jXLabel2.setText("Gestione Servizi");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jXLabel2.setName("jXLabel2"); // NOI18N

        jXPanel1.setName("jXPanel1"); // NOI18N

        jLabel1.setText("Elenco ");
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jXTable1.setModel(tableModel);
        jXTable1.setName("jXTable1"); // NOI18N
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jXTable1);

        jXFindBar1.setName("jXFindBar1"); // NOI18N

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXFindBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        buttonAnnulla1.setName("buttonAnnulla1"); // NOI18N
        buttonAnnulla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAnnulla1MouseClicked(evt);
            }
        });
        buttonAnnulla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulla1ActionPerformed(evt);
            }
        });

        buttonSalva1.setName("buttonSalva1"); // NOI18N
        buttonSalva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSalva1MouseClicked(evt);
            }
        });
        buttonSalva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalva1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, 0, 0, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAnnulla1.setEnabled(false);
        buttonSalva1.setEnabled(false);
    }// </editor-fold>//GEN-END:initComponents

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tipoActionPerformed

    private void buttonAnnulla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAnnulla1MouseClicked
        menu.setButtonEnabled(true);
        JOptionPane.showMessageDialog(null, "operazione annulata");
        jTabbedPane1.setSelectedComponent(jPanel1);
        this.validation(false);
        editabile(false);
        buttonAnnulla1.setEnabled(false);
        buttonSalva1.setEnabled(false);
        if (this.tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI)) {
            this.inizializza("");
        }
    }//GEN-LAST:event_buttonAnnulla1MouseClicked

    private void buttonSalva1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalva1MouseClicked
    }//GEN-LAST:event_buttonSalva1MouseClicked

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked


        if (evt.getClickCount() == 2) {
            try {
                int i = jXTable1.getSelectedRow();
                if (i < 0) {
                    return;
                }
                Integer id = (Integer) jXTable1.getValueAt(i, 0);
                AppServizi operazione = new AppServizi();
                editabile(false);
                validation(false);
                servi = operazione.visualizza(id, servi);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore dal database: " + ex.getErrorCode());
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }



    }//GEN-LAST:event_jXTable1MouseClicked
    }
        private void buttonSalva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalva1ActionPerformed
            try {
            menu.setButtonEnabled(true);
            this.validation(false);
            if (tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.MODIFICA)) {

                int i = jXTable1.getSelectedRow();
                if (i < 0) {
                    return;
                }
                Integer id = (Integer) jXTable1.getValueAt(i, 0);
                AppServizi operazione = new AppServizi();
                
                    operazione.modifica(id, servi);
                    this.tableModel = new ServiziTm();

                    this.jXTable1.setModel(tableModel);
                    this.jXFindBar1.setSearchable(jXTable1.getSearchable());
                    this.jXTable1.updateUI();
                
                this.validation(false);
                editabile(false);
                buttonAnnulla1.setEnabled(false);
                buttonSalva1.setEnabled(false);
            }

            else if (tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI)) {
                
                    AppServizi operazione = new AppServizi();
                    operazione.inserisci(servi);
                    this.tableModel = new ServiziTm();
                    this.jXTable1.setModel(tableModel);
                    this.jXFindBar1.setSearchable(jXTable1.getSearchable());
                    this.jXTable1.updateUI();

                               editabile(false);
                buttonAnnulla1.setEnabled(false);
                buttonSalva1.setEnabled(false);
            }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore dal database: " + ex.getErrorCode());
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }//GEN-LAST:event_buttonSalva1ActionPerformed

        private void buttonAnnulla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulla1ActionPerformed
            menu.setButtonEnabled(true);
            JOptionPane.showMessageDialog(null, "operazione annulata");
            jTabbedPane1.setSelectedComponent(jPanel1);
            editabile(false);
            this.validation(false);
            buttonAnnulla1.setEnabled(false);
            buttonSalva1.setEnabled(false);
            if (this.tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI)) {
                this.inizializza("");
            }
        }//GEN-LAST:event_buttonAnnulla1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla buttonAnnulla1;
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva buttonSalva1;
    private javax.swing.JTextField descrizione;
    private javax.swing.JCheckBox disponibilita;
    private javax.swing.JTextField iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXFindBar jXFindBar1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField prz;
    private javax.swing.JTextField qnt;
    private javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo che restituisce il tipo di utente
     * @return il tipo di utente
     */
    public JTextField getTipo() {
        return tipo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();

    }

    public void validation(Boolean f) {
        servi.setValidator(f);
    }
}
