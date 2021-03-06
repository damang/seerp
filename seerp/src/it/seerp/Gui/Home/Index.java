package it.seerp.Gui.Home;

import java.awt.event.ItemEvent;
import java.sql.SQLException;



import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.AreaPersonale.AreaPersonalePanel;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Utenti.AreaUtentePanel;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import it.seerp.Gui.Gestione.Servizi.GestioneServizi;
import it.seerp.Gui.Gestione.InfoAzienda.InfoAzienda;
import it.seerp.Gui.Gestione.Init.GestioneInit;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import it.seerp.Gui.Gestione.agenda.notificaEventi;
import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.Gui.observablePanel.ObservableJPanel;
import it.seerp.application.applicazione.AppInit;
import it.seerp.storage.jaas.ejb.Permesso;
import it.seerp.storage.ejb.opPersonaleRuolo.AuthPolicy;
import it.seerp.application.jaas.JaasUtil;
import it.seerp.application.jaas.SujGest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.security.Policy;
import javax.security.auth.Subject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.auth.LoginAdapter;
import org.jdesktop.swingx.auth.LoginEvent;

/**
 *
 * @author Andrea
 */
public class Index extends javax.swing.JFrame implements ActionListener, ItemListener {

    /** Creates new form Index
     * @param sub
     */
  /*  private Index(JaasUtil ja) {
        ut_jaas = ja;
        tipDay = new notificaEventi(SujGest.getIdUtente(ut_jaas.getSubject()));
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        settaPermessi();
        setVisible(true);
        tipDay.showDialog(this);
    }*/

    public Index() {
                login();
    }

    private void login() {
        final JaasUtil ja = new JaasUtil();
                final JFrame io= this;
                ja.addLoginListener(new LoginAdapter() {
                    @Override
                    public void loginSucceeded(LoginEvent source) {
                        super.loginSucceeded(source);
                    //    java.awt.EventQueue.invokeLater(new Runnable() {

                      //      public void run() {
                                ut_jaas = ja;
                                tipDay = new notificaEventi(SujGest.getIdUtente(ut_jaas.getSubject()));
                                initComponents();
                                io.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                io.pack();
                                settaPermessi();
                                io.setVisible(true);
                                tipDay.showDialog(io);
                           // }
                    //    });
                    }
                });
                JXLoginPane p = new JXLoginPane(ja);
                JXLoginPane.showLoginFrame(p).setVisible(true);
    }

    private void settaPermessi() {
        areaUtenteButton1.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneResponsabili), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
        areaUtenteButton2.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
        areaUtenteButton3.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
        areaUtenteButton4.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
        buttonServizi1.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneServizi), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
        buttonRuoli1.setEnabled(JaasUtil.checkPermission(ut_jaas.getSubject(), new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneRuoli), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.ELENCA))));
    }

    /**
     *
     * @return
     */
    public Subject getSubject() {
        return ut_jaas.getSubject();
    }

    public JaasUtil getUtilLogin() {
        return ut_jaas;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPanePrincipale = new javax.swing.JTabbedPane();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jPanel1 = new javax.swing.JPanel();
        try{
            areaUtenteButton1 = new it.seerp.Gui.Home.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton2 = new it.seerp.Gui.Home.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton3 = new it.seerp.Gui.Home.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            areaUtenteButton4 = new it.seerp.Gui.Home.AreaUtenteButton(this.jTabbedPanePrincipale,this.menuUtente1,this);
            jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
            jXPanel2 = new org.jdesktop.swingx.JXPanel();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            buttonContratti1 = new it.seerp.Gui.Home.bottoni.gestioni.ButtonContratti(this.jTabbedPanePrincipale,this.menuContratti1,this);
            buttonServizi1 = new it.seerp.Gui.Home.bottoni.gestioni.ButtonServizi(this.jTabbedPanePrincipale,this.menuServizi1,this);
            jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
            jXPanel3 = new org.jdesktop.swingx.JXPanel();
            buttonRuoli1 = new it.seerp.Gui.Home.bottoni.gestioni.ButtonRuoli(this.jTabbedPanePrincipale,this.menuRuoli1,this);
            buttonInfoAzienda1 = new it.seerp.Gui.Home.bottoni.gestioni.ButtonInfoAzienda(this.jTabbedPanePrincipale,this.menuInfoAzienda1,this);
            buttonAgenda1 = new it.seerp.Gui.Home.ButtonAgenda(this.jTabbedPanePrincipale,this.menuAgenda,this);
            areaPersonaleButton5 = new it.seerp.Gui.Home.AreaPersonaleButton(this.jTabbedPanePrincipale,this.menuAreaPersonale2,this);
            jXMonthView1 = new org.jdesktop.swingx.JXMonthView();
            jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
            menuUtente1 = new it.seerp.Gui.Gestione.Utenti.MenuUtente(getSubject());
            menuRuoli1 = new it.seerp.Gui.Gestione.Ruoli.MenuRuoli(getSubject());
            menuContratti1 = new it.seerp.Gui.Gestione.Contratti.MenuContratti();
            menuServizi1 = new it.seerp.Gui.Gestione.Servizi.MenuServizi(getSubject());
            menuInfoAzienda1 = new it.seerp.Gui.Gestione.InfoAzienda.MenuInfoAzienda();
            menuAreaPersonale2 = new it.seerp.Gui.Gestione.Menu.MenuAreaPersonale();
            menuAgenda = new it.seerp.Gui.Gestione.agenda.MenuAgenda();
            logout1 = new it.seerp.Gui.Home.bottoni.gestioni.Logout();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

            jTabbedPanePrincipale.setName("jTabbedPanePrincipale"); // NOI18N
            jTabbedPanePrincipale.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jTabbedPanePrincipaleStateChanged(evt);
                }
            });

            jXTaskPaneContainer1.setName("jXTaskPaneContainer1"); // NOI18N

            jXPanel1.setName("jXPanel1"); // NOI18N

            jXLabel1.setForeground(new java.awt.Color(0, 0, 204));
            jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/home.png"))); // NOI18N
            jXLabel1.setText("Benvenuto "+ SujGest.getUsername(ut_jaas.getSubject()));
            jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
            jXLabel1.setName("jXLabel1"); // NOI18N

            javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
            jXPanel1.setLayout(jXPanel1Layout);
            jXPanel1Layout.setHorizontalGroup(
                jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jXPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
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

            jXTaskPane1.setCollapsed(true);
            jXTaskPane1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico24x24/community_users.png"))); // NOI18N
            jXTaskPane1.setTitle("Gestione Utenti");
            jXTaskPane1.setName("jXTaskPane1"); // NOI18N
            jXTaskPane1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jXTaskPane1MouseClicked(evt);
                }
            });

            jPanel1.setName("jPanel1"); // NOI18N

        }
        catch(SQLException e){e.printStackTrace();}
        areaUtenteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/User-32x32.png"))); // NOI18N
        areaUtenteButton1.setText("Responsabili");
        areaUtenteButton1.setToolTipText("");
        areaUtenteButton1.setContentAreaFilled(false);
        areaUtenteButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton1.setName("areaUtenteButton1"); // NOI18N
        areaUtenteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaUtenteButton1ActionPerformed(evt);
            }
        });

        areaUtenteButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/user.png"))); // NOI18N
        areaUtenteButton2.setText("Dipendenti");
        areaUtenteButton2.setContentAreaFilled(false);
        areaUtenteButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton2.setName("areaUtenteButton2"); // NOI18N
        areaUtenteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaUtenteButton2ActionPerformed(evt);
            }
        });

        areaUtenteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/TruckYellow-32x32.png"))); // NOI18N
        areaUtenteButton3.setText("Fornitori");
        areaUtenteButton3.setContentAreaFilled(false);
        areaUtenteButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton3.setName("areaUtenteButton3"); // NOI18N

        areaUtenteButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/users.png"))); // NOI18N
        areaUtenteButton4.setText("Clienti");
        areaUtenteButton4.setContentAreaFilled(false);
        areaUtenteButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaUtenteButton4.setName("areaUtenteButton4"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(areaUtenteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(areaUtenteButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(areaUtenteButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(areaUtenteButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        jXTaskPane2.setCollapsed(true);
        jXTaskPane2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico24x24/calculator.png"))); // NOI18N
        jXTaskPane2.setTitle("Contabilità");
        jXTaskPane2.setName("jXTaskPane2"); // NOI18N
        jXTaskPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTaskPane2MouseClicked(evt);
            }
        });

        jXPanel2.setName("jXPanel2"); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/page.png"))); // NOI18N
        jButton1.setText("Fatture");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/note_edit.png"))); // NOI18N
        jButton2.setText("Preventivi");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonContratti1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/application.png"))); // NOI18N
        buttonContratti1.setText("Contratti");
        buttonContratti1.setContentAreaFilled(false);
        buttonContratti1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonContratti1.setName("buttonContratti1"); // NOI18N
        buttonContratti1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContratti1ActionPerformed(evt);
            }
        });

        buttonServizi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/shopping_cart.png"))); // NOI18N
        buttonServizi1.setText("Servizi");
        buttonServizi1.setContentAreaFilled(false);
        buttonServizi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonServizi1.setName("buttonServizi1"); // NOI18N

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonServizi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonContratti1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        this.buttonContratti1.setEnabled(false);

        jXTaskPane2.getContentPane().add(jXPanel2);

        jXTaskPaneContainer1.add(jXTaskPane2);

        jXTaskPane3.setCollapsed(true);
        jXTaskPane3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico24x24/lock.png"))); // NOI18N
        jXTaskPane3.setTitle("Utilità");
        jXTaskPane3.setName("jXTaskPane3"); // NOI18N
        jXTaskPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTaskPane3MouseClicked(evt);
            }
        });

        jXPanel3.setName("jXPanel3"); // NOI18N

        buttonRuoli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/attachment.png"))); // NOI18N
        buttonRuoli1.setText("Ruoli");
        buttonRuoli1.setContentAreaFilled(false);
        buttonRuoli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonRuoli1.setName("buttonRuoli1"); // NOI18N
        buttonRuoli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRuoli1ActionPerformed(evt);
            }
        });

        buttonInfoAzienda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/commercial-building-32x32.png"))); // NOI18N
        buttonInfoAzienda1.setText("Info Azienda");
        buttonInfoAzienda1.setContentAreaFilled(false);
        buttonInfoAzienda1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonInfoAzienda1.setName("buttonInfoAzienda1"); // NOI18N

        buttonAgenda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/addressbook-32x32.png"))); // NOI18N
        buttonAgenda1.setText("Agenda");
        buttonAgenda1.setContentAreaFilled(false);
        buttonAgenda1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAgenda1.setName("buttonAgenda1"); // NOI18N

        areaPersonaleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/HP-Control-32x32.png"))); // NOI18N
        areaPersonaleButton5.setText("Area Personale");
        areaPersonaleButton5.setContentAreaFilled(false);
        areaPersonaleButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        areaPersonaleButton5.setName("areaPersonaleButton5"); // NOI18N

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInfoAzienda1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(areaPersonaleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonAgenda1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(buttonRuoli1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addComponent(buttonInfoAzienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaPersonaleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAgenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jXTaskPane3.getContentPane().add(jXPanel3);

        jXTaskPaneContainer1.add(jXTaskPane3);

        jXMonthView1.setAutoscrolls(true);
        jXMonthView1.setDaysOfTheWeekForeground(new java.awt.Color(0, 0, 204));
        jXMonthView1.setName("jXMonthView1"); // NOI18N
        jXMonthView1.setTodayBackground(java.awt.Color.blue);
        jXMonthView1.setTraversable(true);
        jXMonthView1.setZoomable(true);
        jXMonthView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXMonthView1ActionPerformed(evt);
            }
        });
        jXTaskPaneContainer1.add(jXMonthView1);

        jXTitledPanel1.setName("jXTitledPanel1"); // NOI18N

        menuUtente1.setName("menuUtente1"); // NOI18N

        menuRuoli1.setName("menuRuoli1"); // NOI18N

        menuContratti1.setName("menuContratti1"); // NOI18N

        menuServizi1.setName("menuServizi1"); // NOI18N

        menuInfoAzienda1.setName("menuInfoAzienda1"); // NOI18N

        menuAreaPersonale2.setName("menuAreaPersonale2"); // NOI18N

        menuAgenda.setName("menuAgenda"); // NOI18N

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addComponent(menuUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuAreaPersonale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuInfoAzienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuUtente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuRuoli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuContratti1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuServizi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuAreaPersonale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuInfoAzienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        this.menuUtente1.setVisible(false);
        menuRuoli1.setVisible(false);
        this.menuContratti1.setVisible(false);
        menuServizi1.setVisible(false);
        this.menuInfoAzienda1.setVisible(false);
        menuAreaPersonale2.setVisible(false);
        menuAgenda.setVisible(false);

        logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico32x32/Log-Out-48x48.png"))); // NOI18N
        logout1.setToolTipText("Logout");
        logout1.setName("logout1"); // NOI18N
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPanePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPanePrincipale, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                this.menuAgenda.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuUtente1.setPannello((AreaUtentePanel) p);
            } else if (p.getClass().equals(GestioneContratti.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuAgenda.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuContratti1.setVisible(true);
                this.menuContratti1.setPannello((GestioneContratti) p);
            } else if (p.getClass().equals(GestioneServizi.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuAgenda.setVisible(false);
                this.menuContratti1.setVisible(false);
                this.menuServizi1.setVisible(true);
                this.menuServizi1.setPannello((GestioneServizi) p);
            } else if (p.getClass().equals(AreaPersonalePanel.class)) {
                this.menuContratti1.setVisible(false);
                this.menuUtente1.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuAgenda.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuAreaPersonale2.setVisible(true);
            } else if (p.getClass().equals(GestioneRuoli.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuContratti1.setVisible(false);
                this.menuAgenda.setVisible(false);
                this.menuRuoli1.setVisible(true);
                this.menuRuoli1.setPannello((GestioneRuoli) p);
            } else if (p.getClass().equals(InfoAzienda.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuContratti1.setVisible(false);
                this.menuAgenda.setVisible(false);
                this.menuInfoAzienda1.setVisible(true);
                this.menuInfoAzienda1.setPannello((InfoAzienda) p);
            } else if (p.getClass().equals(CalendarPanel.class)) {
                this.menuUtente1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuContratti1.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuAgenda.setVisible(true);
                this.menuAgenda.setPannello((CalendarPanel) p);
            } else {
                this.menuContratti1.setVisible(false);
                this.menuAreaPersonale2.setVisible(false);
                this.menuUtente1.setVisible(false);
                this.menuServizi1.setVisible(false);
                this.menuInfoAzienda1.setVisible(false);
                this.menuRuoli1.setVisible(false);
                this.menuAgenda.setVisible(false);
            }
        } else {
            this.menuContratti1.setVisible(false);
            this.menuAreaPersonale2.setVisible(false);
            this.menuUtente1.setVisible(false);
            this.menuServizi1.setVisible(false);
            this.menuInfoAzienda1.setVisible(false);
            this.menuRuoli1.setVisible(false);
            this.menuAgenda.setVisible(false);
        }

    }//GEN-LAST:event_jTabbedPanePrincipaleStateChanged

    private void areaPersonaleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaPersonaleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaPersonaleButton1ActionPerformed

    private void buttonContratti1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonContratti1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonContratti1ActionPerformed

    private void areaUtenteButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaUtenteButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaUtenteButton4ActionPerformed

    private void buttonRuoli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRuoli1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRuoli1ActionPerformed

    private void jXTaskPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTaskPane1MouseClicked
        // TODO add your handling code here:
        jXTaskPane2.setCollapsed(true);
        jXTaskPane3.setCollapsed(true);
        jXTaskPane1.setSpecial(true);
        jXTaskPane2.setSpecial(false);
        jXTaskPane3.setSpecial(false);
    }//GEN-LAST:event_jXTaskPane1MouseClicked

    private void jXTaskPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTaskPane2MouseClicked
        // TODO add your handling code here:
        jXTaskPane1.setCollapsed(true);
        jXTaskPane3.setCollapsed(true);
        jXTaskPane1.setSpecial(false);
        jXTaskPane2.setSpecial(true);
        jXTaskPane3.setSpecial(false);
    }//GEN-LAST:event_jXTaskPane2MouseClicked

    private void jXTaskPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTaskPane3MouseClicked
        // TODO add your handling code here:
        jXTaskPane1.setCollapsed(true);
        jXTaskPane2.setCollapsed(true);
        jXTaskPane1.setSpecial(false);
        jXTaskPane1.setSpecial(false);
        jXTaskPane2.setSpecial(false);
        jXTaskPane3.setSpecial(true);
    }//GEN-LAST:event_jXTaskPane3MouseClicked

    private void buttonAgenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgenda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAgenda1ActionPerformed

    private void jXMonthView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXMonthView1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXMonthView1ActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        ut_jaas.logout();
        Index i=this;
        this.dispose();
        i=new Index();
    }//GEN-LAST:event_logout1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         ut_jaas.logout();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            Policy.setPolicy(new AuthPolicy());
            System.setProperty("java.security.auth.login.config", "file_config\\jaasutil.config");
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
            AppInit app = new AppInit();
            if (!app.check()) {
                GestioneInit info = new GestioneInit();
            } else {
               java.awt.EventQueue.invokeLater(new Runnable() {

                            public void run() {
                                new Index();
                            }
                        });
                    }




        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Database non presente!!", "Errore", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1044:
                    JOptionPane.showMessageDialog(null, "Impossibile accedere al database! " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Errore di accesso al database: " + ex.getErrorCode());
                    break;
            }
            System.exit(0);
        }
    /*    final Subject _subject = new Subject();
    _subject.getPrincipals().add(new AuthPrincipal("majinb", "username"));
    _subject.getPrincipals().add(new AuthPrincipal("amministratore", "ruolo"));
    _subject.getPrincipals().add(new AuthPrincipal("1", "id"));
    _subject.getPrincipals().add(new AuthPrincipal("personale", "tipo"));
    java.awt.EventQueue.invokeLater(new Runnable() {

    public void run() {
    new Index(_subject);
    }
    });*/




    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Home.AreaPersonaleButton areaPersonaleButton5;
    private it.seerp.Gui.Home.AreaUtenteButton areaUtenteButton1;
    private it.seerp.Gui.Home.AreaUtenteButton areaUtenteButton2;
    private it.seerp.Gui.Home.AreaUtenteButton areaUtenteButton3;
    private it.seerp.Gui.Home.AreaUtenteButton areaUtenteButton4;
    private it.seerp.Gui.Home.ButtonAgenda buttonAgenda1;
    private it.seerp.Gui.Home.bottoni.gestioni.ButtonContratti buttonContratti1;
    private it.seerp.Gui.Home.bottoni.gestioni.ButtonInfoAzienda buttonInfoAzienda1;
    private it.seerp.Gui.Home.bottoni.gestioni.ButtonRuoli buttonRuoli1;
    private it.seerp.Gui.Home.bottoni.gestioni.ButtonServizi buttonServizi1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPanePrincipale;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXMonthView jXMonthView1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private it.seerp.Gui.Home.bottoni.gestioni.Logout logout1;
    private it.seerp.Gui.Gestione.agenda.MenuAgenda menuAgenda;
    private it.seerp.Gui.Gestione.Menu.MenuAreaPersonale menuAreaPersonale2;
    private it.seerp.Gui.Gestione.Contratti.MenuContratti menuContratti1;
    private it.seerp.Gui.Gestione.InfoAzienda.MenuInfoAzienda menuInfoAzienda1;
    private it.seerp.Gui.Gestione.Ruoli.MenuRuoli menuRuoli1;
    private it.seerp.Gui.Gestione.Servizi.MenuServizi menuServizi1;
    private it.seerp.Gui.Gestione.Utenti.MenuUtente menuUtente1;
    // End of variables declaration//GEN-END:variables
    private JaasUtil ut_jaas;
    private org.jdesktop.swingx.JXTipOfTheDay tipDay;

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }
}
