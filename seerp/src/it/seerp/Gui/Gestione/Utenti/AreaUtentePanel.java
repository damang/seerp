package it.seerp.Gui.Gestione.Utenti;

import it.seerp.application.bean.tabelle.Generica;
import it.seerp.application.bean.tabelle.ClienteTm;
import it.seerp.application.bean.tabelle.ResponsabileTm;
import it.seerp.application.bean.tabelle.FornitoreTm;
import it.seerp.application.bean.tabelle.DipendenteTm;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneUtente.TIPO_UTENTE_CONST;
import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneUtente;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla;
import it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva;
import it.seerp.Gui.observablePanel.ObservableJPanel;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiFornitore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.security.auth.Subject;
import javax.swing.JOptionPane;
import it.seerp.Gui.configurazioni.Gui.ConfigurazioneOperazioni;
import it.seerp.Gui.configurazioni.PermessiDefault;
import it.seerp.application.applicazione.AppGestioneExtraAzienda;
import it.seerp.application.applicazione.AppGestionePersonale;

import it.seerp.application.applicazione.AppRuoli;
import it.seerp.application.applicazione.bean.BeanGuiCliente;
import it.seerp.application.applicazione.bean.BeanGuiDipendente;

import it.seerp.application.applicazione.bean.BeanGuiResponsabile;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.jaas.ejb.Permesso;
import it.seerp.application.jaas.JaasUtil;
import java.awt.Color;
import java.util.logging.Logger;

/**
 *
 * @author Andrea-Luisa
 */
public class AreaUtentePanel extends ObservableJPanel implements ActionListener {

    BeanGuiFornitore fornitore;
    BeanGuiCliente cliente;
    BeanGuiResponsabile responsabile;
    BeanGuiDipendente dipendente;
    ConfigurazioneUtente.TIPO_UTENTE_CONST tipoU;
    Generica tModel;
    MenuUtente menu;
    ConfigurazioneOperazioni.TIPO_OPE_CONST tipoOp;
    private Subject ut_sub;

    /** Creates new form AreaPersonalePanel */
    public AreaUtentePanel() {
        initComponents();

    }

    /**
     * Metodo che permette ti passare il tipo i utenti
     * @param tipoUtente
     * @throws java.sql.SQLException
     */
    public AreaUtentePanel(ConfigurazioneUtente.TIPO_UTENTE_CONST tipoUtente, Subject sub) throws SQLException {
        this.ut_sub = sub;
        this.tipoU = tipoUtente;
        this.settaTableModel();
        initComponents();
        settaPanel();
        responsabile = new BeanGuiResponsabile(this);
        dipendente = new BeanGuiDipendente(this);
        this.fornitore = new BeanGuiFornitore(this);
        this.cliente = new BeanGuiCliente(this);
        legameBeanResponsabile();
        legameBeanDipendente();
        legameBeanFornitore();
        legameBeanCliente();
        setEnabledByPerm();
        editabile(false);


    }

    private void setEnabledByPerm() {
        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
            this.find_bar.setVisible(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneResponsabili), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.RICERCA))));

        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {
            this.find_bar.setVisible(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneClienti), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.RICERCA))));

        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {
            this.find_bar.setVisible(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneFornitori), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.RICERCA))));
        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
            this.find_bar.setVisible(JaasUtil.checkPermission(ut_sub, new Permesso(PermessiDefault.valueOf(PermessiDefault.Categoria_Permesso.GestioneDipendenti), PermessiDefault.valueOf(PermessiDefault.Operazione_Permesso.RICERCA))));
        }
    }

    /**
     * Metodo che permette di restituire il tipo utente
     * @return il tipo di utente
     */
    public TIPO_UTENTE_CONST getTipoUtente() {
        return tipoU;
    }

    /**
     * Metodo che setta il tipo utente
     * @param tipoUtente
     */
    public void setTipoUtente(TIPO_UTENTE_CONST tipoUtente) {
        this.tipoU = tipoUtente;
    }

    /**
     * Metodo che associa il menù al form Area utente
     * @return il tipo di utente
     */
    public MenuUtente getMenu() {
        return menu;
    }

    /**
     *  Metodo che setta il tipo utente
     * @param tipo
     */
    public void setTipoOP(ConfigurazioneOperazioni.TIPO_OPE_CONST tipo) {
        this.tipoOp = tipo;
    }

    /**
     * Metodo che associa il menù al form Area utente
     * @param menu
     */
    public void setMenu(MenuUtente menu) {
        this.menu = menu;
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
        jPanel3 = new javax.swing.JPanel();
        nm = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cog = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        codFisc = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        mail = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        tell = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        provincia = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        ruolo = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        citta = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        fax = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        ragSoc = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        cap = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        piva = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        indirizzo = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        panel28 = new javax.swing.JPanel();
        user = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        pwd = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        find_bar = new org.jdesktop.swingx.JXFindBar(jXTable1.getSearchable());
        buttonAnnulla1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla();
        buttonSalva1 = new it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva();

        setBackground(new java.awt.Color(0, 153, 204));

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jPanel3.setName("jPanel3"); // NOI18N

        nm.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        nm.setName("Nome"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cognome"));
        jPanel4.setName("jPanel4"); // NOI18N

        cog.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        cog.setName("Cognome"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cog, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Codice Fiscale "));
        jPanel5.setName("jPanel5"); // NOI18N

        codFisc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        codFisc.setName("CodiceFiscale"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codFisc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(codFisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));
        jPanel6.setName("jPanel6"); // NOI18N

        mail.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        mail.setName("E-mail"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        jPanel7.setName("jPanel7"); // NOI18N

        tell.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        tell.setName("Telefono"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tell, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(tell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Provincia"));
        jPanel9.setName("jPanel9"); // NOI18N

        provincia.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        provincia.setName("Provincia"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Ruolo"));
        jPanel13.setName("jPanel13"); // NOI18N

        ruolo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ruolo.setName("ruolo"); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ruolo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(ruolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Città"));
        jPanel11.setName("jPanel11"); // NOI18N

        citta.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        citta.setName("citta"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(citta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(citta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("FAX"));
        jPanel19.setName("jPanel19"); // NOI18N

        fax.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        fax.setName("fax"); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Ragione Sociale"));
        jPanel14.setName("jPanel14"); // NOI18N

        ragSoc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        ragSoc.setName("ragSoc"); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ragSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(ragSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("CAP"));
        jPanel18.setName("jPanel18"); // NOI18N

        cap.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        cap.setName("cap"); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("P.IVA"));
        jPanel17.setName("jPanel17"); // NOI18N

        piva.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        piva.setName("piva"); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(piva, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(piva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Note"));
        jPanel10.setName("jPanel10"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        note.setColumns(20);
        note.setRows(5);
        note.setName("note"); // NOI18N
        jScrollPane1.setViewportView(note);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Indirizzo"));
        jPanel20.setName("jPanel20"); // NOI18N

        indirizzo.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        indirizzo.setName("indirizzo"); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(indirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(indirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(493, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel11.setVisible(true);

        jTabbedPane1.addTab("Dati Personali", jPanel1);

        jPanel27.setName("jPanel27"); // NOI18N

        panel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Username"));
        panel28.setName("panel28"); // NOI18N

        user.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        user.setName("Username"); // NOI18N

        javax.swing.GroupLayout panel28Layout = new javax.swing.GroupLayout(panel28);
        panel28.setLayout(panel28Layout);
        panel28Layout.setHorizontalGroup(
            panel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel28Layout.setVerticalGroup(
            panel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel28Layout.createSequentialGroup()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));
        jPanel29.setName("jPanel29"); // NOI18N

        pwd.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        pwd.setName("Password"); // NOI18N
        pwd.setSelectedTextColor(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(451, 451, 451))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(365, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dati LogIn", jPanel27);

        jXLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel2.setText("Gestione Utente");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jXLabel2.setName("jXLabel2"); // NOI18N

        jXPanel1.setName("jXPanel1"); // NOI18N

        jLabel1.setText("Elenco ");
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jXTable1.setModel(tModel);
        jXTable1.setName("jXTable1"); // NOI18N
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jXTable1);

        find_bar.setName("find_bar"); // NOI18N

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(find_bar, 0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(find_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addGap(296, 296, 296)
                        .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAnnulla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, 0, 0, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        buttonAnnulla1.setEnabled(false);
        buttonSalva1.setEnabled(false);
    }// </editor-fold>//GEN-END:initComponents

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        if (evt.getClickCount() == 2) {
            try {
                int i = jXTable1.getSelectedRow();
                if (i < 0) {
                    return;
                }

                Integer id = (Integer) jXTable1.getValueAt(i, 0);

                if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {

                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    operazione.visualizzaDatiCliente(id, cliente);
                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {

                    AppGestionePersonale operazione = new AppGestionePersonale();
                    operazione.visualizzaDatiDipendente(id, dipendente);
                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {

                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    operazione.visualizzaDatiFornitore(id, fornitore);
                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {

                    AppGestionePersonale operazione = new AppGestionePersonale();
                    operazione.visualizzaDatiResponsabile(id, responsabile);
                }

                editabile(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore nel database!!");
            } catch (ValidatorException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jXTable1MouseClicked

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_mailActionPerformed

    private void buttonSalva1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSalva1MouseClicked
    }//GEN-LAST:event_buttonSalva1MouseClicked

    private void buttonAnnulla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAnnulla1MouseClicked
    }//GEN-LAST:event_buttonAnnulla1MouseClicked

    private void buttonAnnulla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulla1ActionPerformed
        menu.setButtonEnabled(true);
        // JOptionPane.showMessageDialog(null, "operazione annulata");
        editabile(false);
        this.buttonAnnulla1.setEnabled(false);
        this.buttonSalva1.setEnabled(false);

        validation(false);
        if (this.tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI)) {
            this.inizializzazione("");
        }

    }//GEN-LAST:event_buttonAnnulla1ActionPerformed

    private void buttonSalva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalva1ActionPerformed
        try {
            menu.setButtonEnabled(true);
            if (tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.INSERISCI)) {

                if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {

                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    operazione.inserisciCliente(cliente);

                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {

                    AppGestionePersonale operazione = new AppGestionePersonale();
                    operazione.inserisciDipendente(dipendente);

                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {

                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    operazione.inserisciFornitore(fornitore);


                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {

                    AppGestionePersonale operazione = new AppGestionePersonale();
                    operazione.inserisciResponsabile(responsabile);

                }
                refresh();
                validation(false);
                editabile(false);
                this.buttonAnnulla1.setEnabled(false);
                this.buttonSalva1.setEnabled(false);
            }

            if (tipoOp.equals(ConfigurazioneOperazioni.TIPO_OPE_CONST.MODIFICA)) {
                int i = jXTable1.getSelectedRow();
                if (i < 0) {
                    return;
                }

                Integer id = (Integer) jXTable1.getValueAt(i, 0);
                if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {



                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    //cliente.setValidatorEnabled(true);
                    operazione.modificaCliente(id, cliente);

                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {

                    AppGestionePersonale operazione = new AppGestionePersonale();
                    //dipendente.setValidatorEnabled(true);
                    operazione.modificaDipendente(id, dipendente);


                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {


                    AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                    //fornitore.setValidatorEnabled(true);
                    operazione.modificaFornitore(id, fornitore);



                } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {



                    AppGestionePersonale operazione = new AppGestionePersonale();
                    //responsabile.setValidatorEnabled(true);
                    operazione.modificaResponsabile(id, responsabile);


                }
                refresh();
                editabile(false);
                validation(false);
                this.buttonAnnulla1.setEnabled(false);
                this.buttonSalva1.setEnabled(false);


            }
        } catch (ValidatorException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (DatiDuplicatiEx ex) {
            JOptionPane.showMessageDialog(null, "Hai inserito dati duplicati");
        //this.inizializzazione("");
        //editabile(false);
        //this.buttonAnnulla1.setEnabled(true);
        //this.buttonSalva1.setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore nel database: " + ex.getErrorCode());
        //this.inizializzazione("");
        //editabile(true);
        //this.buttonAnnulla1.setEnabled(true);
        //this.buttonSalva1.setEnabled(true);
        }
    }//GEN-LAST:event_buttonSalva1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonAnnulla buttonAnnulla1;
    private it.seerp.Gui.Gestione.BottoniGenerici.ButtonSalva buttonSalva1;
    private javax.swing.JTextField cap;
    private javax.swing.JTextField citta;
    private javax.swing.JTextField codFisc;
    private javax.swing.JTextField cog;
    private javax.swing.JTextField fax;
    private org.jdesktop.swingx.JXFindBar find_bar;
    private javax.swing.JTextField indirizzo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nm;
    private javax.swing.JTextArea note;
    private javax.swing.JPanel panel28;
    private javax.swing.JTextField piva;
    private javax.swing.JTextField provincia;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField ragSoc;
    private javax.swing.JComboBox ruolo;
    private javax.swing.JTextField tell;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void elmina() {
        try {
            int i = jXTable1.getSelectedRow();
            if (i < 0) {
                return;
            }

            Integer id = (Integer) jXTable1.getValueAt(i, 0);

            if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {

                AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                operazione.eliminaExtraAziena(id, cliente);

            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {

                AppGestionePersonale operazione = new AppGestionePersonale();
                operazione.eliminaDipendente(id, dipendente);


            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {

                AppGestioneExtraAzienda operazione = new AppGestioneExtraAzienda();
                operazione.eliminaExtraAziena(id, fornitore);
            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {

                AppGestionePersonale operazione = new AppGestionePersonale();
                operazione.eliminaResponsabile(id, responsabile);
            }
            refresh();
            editabile(false);
            inizializzazione("");
            this.buttonAnnulla1.setEnabled(false);
            this.buttonSalva1.setEnabled(false);
        } catch (ValidatorException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore nel database: " + ex.getErrorCode());
        }

    }

    public void actionPerformed(ActionEvent e) {
        CommandInterface cmd = (CommandInterface) e.getSource();
        cmd.execute();
    }

    /**
     * Metodo che restituice il bottone Salva
     * @return il bottone salva
     */
    public ButtonSalva getSalva() {
        return this.buttonSalva1;
    }

    /**
     * Metodo che restituisce il pulsante Annulla
     * @return il pulsate annulla
     */
    public ButtonAnnulla getAnnulla() {
        return this.buttonAnnulla1;
    }

    /**
     * Metodo che permette di inizzializzare i campi sul form
     * @param s sringa che permette l'inalizzazione, permette di inizzializare tutti i campi sul form.
     */
    public void inizializzazione(String s) {
        this.nm.setText(s);
        this.cog.setText(s);
        this.provincia.setText(s);
        this.citta.setText(s);
        this.tell.setText(s);
        this.mail.setText(s);
        this.user.setText(s);
        this.pwd.setText(s);
        this.indirizzo.setText(s);
        this.codFisc.setText(s);
        this.ragSoc.setText(s);
        this.fax.setText(s);
        this.piva.setText(s);
        this.cap.setText(s);
        this.note.setText(s);
    }

    /**
     *
     */
    public void legameBeanResponsabile() {
        responsabile.setNome(nm);
        responsabile.setCognome(cog);
        responsabile.setCodiceFiscale(codFisc);
        responsabile.setCap(cap);
        responsabile.setIndirizzo(indirizzo);
        responsabile.setTxtPassword(pwd);
        responsabile.setTxtUsername(user);
        responsabile.setTxtCitta(citta);
        responsabile.setTxtEmail(mail);
        responsabile.setTxtTelefono(tell);
        responsabile.setTxtProvincia(provincia);
        responsabile.setRuolo(ruolo);
        responsabile.setTxtNote(note);

    }

    /**
     *
     */
    public void legameBeanDipendente() {
        dipendente.setNome(nm);
        dipendente.setCognome(cog);
        dipendente.setCodiceFiscale(codFisc);
        dipendente.setIndirizzo(indirizzo);
        dipendente.setRuolo(ruolo);
        dipendente.setCap(cap);
        dipendente.setTxtPassword(pwd);
        dipendente.setTxtUsername(user);
        dipendente.setTxtCitta(citta);
        dipendente.setTxtEmail(mail);
        dipendente.setTxtTelefono(tell);
        dipendente.setTxtProvincia(provincia);
        dipendente.setTxtNote(note);


    }

    /**
     *
     */
    public void legameBeanFornitore() {

        fornitore.setTxtProvincia(provincia);
        fornitore.setTxtCitta(citta);
        fornitore.setTxtEmail(mail);
        fornitore.setCap(cap);
        fornitore.setPIva(piva);
        fornitore.setRagioneSociale(ragSoc);
        fornitore.setTxtTelefono(tell);
        fornitore.setTxtUsername(user);
        fornitore.setTxtPassword(pwd);
        fornitore.setFax(fax);
        fornitore.setNome(nm);
        fornitore.setCognome(cog);
        fornitore.setCodiceFiscale(codFisc);
        fornitore.setTxtNote(note);
        fornitore.setIndirizzo(indirizzo);
    }

    /**
     *
     */
    public void legameBeanCliente() {
        cliente.setTxtProvincia(provincia);
        cliente.setTxtCitta(citta);
        cliente.setTxtEmail(mail);
        cliente.setCap(cap);
        cliente.setPIva(piva);
        cliente.setRagioneSociale(ragSoc);
        cliente.setTxtTelefono(tell);
        cliente.setTxtUsername(user);
        cliente.setTxtPassword(pwd);
        cliente.setNome(nm);
        cliente.setFax(fax);
        cliente.setCognome(cog);
        cliente.setCodiceFiscale(codFisc);
        cliente.setTxtNote(note);
        cliente.setIndirizzo(indirizzo);

    }

    /**
     * Metodo setta il bean gui del cliente
     * @return il bean gui del cliente
     */
    public BeanGuiCliente getCliente() {
        return cliente;
    }

    /**
     * Metodo che setta il bean gui Dipendente
     * @return bean gui del Dipendente
     */
    public BeanGuiDipendente getDipendente() {
        return dipendente;
    }

    /**
     * Metodo che setta il bean gui fornitore
     * @return bean gui del Fornitore
     */
    public BeanGuiFornitore getFornitore() {
        return fornitore;
    }

    /**
     * Metodo che setta il bean gui Responsabile
     * @return bean gui del Responsabile
     */
    public BeanGuiResponsabile getResponsabile() {
        return responsabile;
    }

    /**
     * il metodo che permette di rendere editabile o menoo i campi presenti nella grafica
     * @ flag che permette di modificare i campi presenti sul form.
     */
    public void editabile(boolean flag) {
        this.nm.setEnabled(flag);
        nm.setBackground(Color.WHITE);
        this.cog.setEnabled(flag);
        cog.setBackground(Color.WHITE);
        this.provincia.setEnabled(flag);
        provincia.setBackground(Color.WHITE);
        this.tell.setEnabled(flag);
        tell.setBackground(Color.WHITE);
        this.mail.setEnabled(flag);
        mail.setBackground(Color.WHITE);
        this.ruolo.setEnabled(flag);
        ruolo.setBackground(Color.WHITE);
        this.indirizzo.setEnabled(flag);
        indirizzo.setBackground(Color.WHITE);
        this.codFisc.setEnabled(flag);
        codFisc.setBackground(Color.WHITE);
        this.pwd.setEnabled(flag);
        pwd.setBackground(Color.WHITE);
        this.user.setEnabled(flag);
        user.setBackground(Color.WHITE);
        this.ragSoc.setEnabled(flag);
        ragSoc.setBackground(Color.WHITE);
        this.fax.setEnabled(flag);
        fax.setBackground(Color.WHITE);
        this.piva.setEnabled(flag);
        piva.setBackground(Color.WHITE);
        this.citta.setEnabled(flag);
        citta.setBackground(Color.WHITE);
        this.cap.setEnabled(flag);
        cap.setBackground(Color.WHITE);
        this.note.setEnabled(flag);
        note.setBackground(Color.WHITE);

    }

    /**
     *
     */
    public void refresh() {
        try {
            this.settaTableModel();
        } catch (SQLException ex) {
            Logger.getLogger(AreaUtentePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jXTable1.setModel(tModel);
        this.find_bar.setSearchable(jXTable1.getSearchable());
        this.jXTable1.updateUI();
    }

    private void settaPanel() throws SQLException {
        try {
            if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {

                this.jPanel13.setVisible(false);
            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
                AppRuoli app = new AppRuoli();

                ruolo.removeAllItems();
                for (String s : app.getNomeRuolo("dipendente")) {

                    ruolo.addItem(s);
                }
                this.jPanel14.setVisible(false);

                this.jPanel19.setVisible(false);
                this.jPanel17.setVisible(false);
            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {

                this.jPanel13.setVisible(false);

            } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
                AppRuoli app = new AppRuoli();

                ruolo.removeAllItems();
                for (String s : app.getNomeRuolo("responsabile")) {

                    ruolo.addItem(s);
                }
                this.jPanel14.setVisible(false);

                this.jPanel19.setVisible(false);
                this.jPanel17.setVisible(false);
            }
        } catch (ValidatorException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void settaTableModel() throws SQLException {

        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {
            tModel = new ClienteTm();
            this.setBackground(Color.green);
        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
            tModel = new DipendenteTm();

            this.setBackground(Color.YELLOW);
        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {
            tModel = new FornitoreTm();
            this.setBackground(Color.ORANGE);

        } else if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
            tModel = new ResponsabileTm();
            this.setBackground(Color.GRAY);
        }

    }

    /**
     * Metodo che permette di validare i premessi agli utente loggati
     * @param f permessi degli utenti
     */
    public void validation(Boolean f) {
        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
            responsabile.setValidatorEnabled(f);
        }
        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {
            cliente.setValidatorEnabled(f);

        }
        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {
            fornitore.setValidatorEnabled(f);
        }
        if (tipoU.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
            dipendente.setValidatorEnabled(f);
        }
    }
}

