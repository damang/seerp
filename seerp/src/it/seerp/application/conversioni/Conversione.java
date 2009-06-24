package it.seerp.application.conversioni;

import it.seerp.Gui.Gestione.agenda.EventInstance;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiAgenda;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiAppuntamento;
import it.seerp.application.bean.BeanGuiAzienda;
import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiContatto;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiPagamento;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.bean.BeanGuiRuolo;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.bean.BeanGuiServizioAssociato;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.tabelle.PersonaleTm;
import it.seerp.storage.Operazioni.OpEvento;
import it.seerp.storage.jaas.PermessoCollection;
import it.seerp.storage.ejb.Agenda;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Azienda;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Fattura;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Ruolo;

import it.seerp.storage.ejb.Servizio;
import it.seerp.storage.ejb.ServizioAssociato;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe che permette la conversione tra diversi tipi di Bean e Bean Gui
 * @author  Matteo D'Auria
 */
public class Conversione {

    /**
     * Metodo che converte un Bean Gui Contratto in un normale Bean Contratto
     * @param pGui
     * Il Bean Gui Contratto da convertire
     * @return Il Bean Contratto convertito
     * @throws Exception
     */
    public static Contratto conversioneContratto(BeanGuiContratto pGui) throws ValidatorException {
        ArrayList<Pagamento> listPag = new ArrayList<Pagamento>();
        ArrayList<ServizioAssociato> listSer = new ArrayList<ServizioAssociato>();
        ArrayList<Fattura> listFatt = new ArrayList<Fattura>();

        for (BeanGuiPagamento p : pGui.getListPagamento()) {
            Pagamento p1 = conversionePagamento(p);
            listPag.add(p1);
        }

        for (BeanGuiServizioAssociato s : pGui.getListServizio()) {
            ServizioAssociato s1 = conversioneAssociato(s);
            listSer.add(s1);
        }
        Contratto contratto = new Contratto();
        String stato = pGui.getStato().getText();
        contratto.setStato(stato);
        GregorianCalendar data = null;
        data.setTimeInMillis(Long.parseLong(pGui.getData().getText()));
        contratto.setData(data);
        int durata = Integer.parseInt(pGui.getDurata().getText());
        contratto.setDurata(durata);
        String tipo = pGui.getTipo().getText();
        contratto.setTipo(tipo);
        int idContratto = Integer.parseInt(pGui.getIdContratto().getText());
        contratto.setIdContratto(idContratto);
        String note = pGui.getNote().getText();
        contratto.setNote(note);
        contratto.setDipendente(conversioneDipendente(pGui.getDipendente()));
        contratto.setExtraAzienda(conversioneExtraAzienda(pGui.getExtraAzienda()));
        return contratto;
    }

    /**
     * Metodo che converte un Bean Contratto in un Bean Gui Contratto
     * @param c il Bean Contratto da convertire
     * @param gui il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Contratto convertito
     * @throws Exception
     */
    public static BeanGuiContratto conversioneContratto(Contratto c, BeanGuiContratto gui) throws ValidatorException {
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();

        field.setText(c.getStato());
        gui.setStato(field);
        field.setText(c.getData().toString());
        gui.setData(field);
        field.setText(c.getDurata().toString());
        gui.setDurata(field);
        field.setText(c.getTipo());
        gui.setTipo(field);
        field.setText(c.getIdContratto().toString());
        gui.setIdContratto(field);
        area.setText(c.getNote());
        gui.setNote(area);
        gui.setDipendente(conversioneDipendente(c.getDipendente(), gui.getDipendente()));
        gui.setExtraAzienda(conversioneExtraAzienda(c.getExtraAzienda(), new BeanGuiExtraAzienda()));
        gui.setListPagamento(gui.getListPagamento());
        gui.setListServizio(gui.getListServizio());

        return gui;
    }

    public static Evento conversioneEvento(EventInstance e) throws SQLException {
        OpEvento o= new OpEvento();

        return o.getEventoPerId(e.getEventoId());
    }

    /**
     * Metodo che converte un Bean Gui Evento in un normale Bean Evento
     * @param pGui
     * Il Bean Gui Evento da convertire
     * @return Il Bean Evento convertito
     * @throws Exception
     */
    public static Evento conversioneEvento(BeanGuiEvento pGui) throws ValidatorException {
        Evento evento = new Evento();
        evento.setLuogo(pGui.getLuogo().getText());
        evento.setTema((String)pGui.getTema().getSelectedItem());
        evento.setNome(pGui.getNome().getText());
        evento.setNote(pGui.getNote().getText());
        GregorianCalendar data = new GregorianCalendar();
        data.setTimeInMillis(pGui.getData().getDate().getTime());
        evento.setData(data);
        
        GregorianCalendar ora = new GregorianCalendar();
        String t[]= pGui.getOra().getText().split(":");

        ora.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(t[0]));
        ora.set(GregorianCalendar.MINUTE, Integer.parseInt(t[1]));
        ora.set(GregorianCalendar.SECOND, Integer.parseInt(t[2]));

        evento.setOra(ora);
        try {
            evento.setIdEvento(Integer.parseInt(pGui.getIdEvento().getText()));
        }
        catch (NumberFormatException e) {
            evento.setIdEvento(-1);
        }

        //evento.setAgenda(conversioneAgenda(pGui.getAgenda()));
        evento.setNotifica(Boolean.parseBoolean(pGui.getNotifica().getText()));
        evento.setAgenda(pGui.getIdAgenda());

        return evento;
    }

    /**
     * Metodo che converte un Bean Evento  in un Bean Gui Evento
     * @param e il Bean Evento da convertire
     * @param gui il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Evento convertito
     */
    public static BeanGuiEvento conversioneEvento(Evento e, BeanGuiEvento gui) {
        gui.getData().setDate(e.getData().getTime());
        gui.getIdEvento().setText(""+e.getIdEvento());
        gui.getLuogo().setText(e.getLuogo());
        gui.getNome().setText(e.getNome());
        gui.getNote().setText(e.getNote());
        gui.getNotifica().setSelected(e.getNotifica());
        gui.getOra().setText(e.getOra().get(GregorianCalendar.HOUR_OF_DAY)+ ":" + e.getOra().get(GregorianCalendar.MINUTE)+ ":" + e.getOra().get(GregorianCalendar.SECOND));
        gui.getTema().setSelectedItem(e.getTema());
        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Servizio in un normale Bean Servizio
     * @param pGui
     * Il Bean Gui Servizio da convertire
     * @return Il Bean Servizio convertito
     * @throws Exception
     */
    public static Servizio conversioneServizio(BeanGuiServizio pGui) throws ValidatorException {
        /*  ArrayList<ServizioAssociato> list = new ArrayList<ServizioAssociato>();

        for (BeanGuiServizioAssociato c : pGui.getListServiziAssociati()) {
        ServizioAssociato c1 = conversioneAssociato(c);
        list.add(c1);
        }*/
        Servizio servizio = new Servizio();

        servizio.setDescrizione(pGui.getDescrizione().getText());
        servizio.setDisponibilita(Boolean.parseBoolean(pGui.getDisponibilita().getText()));
        servizio.setQuantita(Integer.parseInt(pGui.getQuantita().getText()));
        servizio.setTipo(pGui.getTipo().getText());
        servizio.setPrezzo(Double.parseDouble(pGui.getPrezzo().getText()));
        //   servizio.setIdServizio(Integer.parseInt(pGui.getIdServizio().getText()));
        servizio.setIva(Integer.parseInt(pGui.getIva().getText()));
        servizio.setNote(pGui.getNote().getText());
        //  servizio.setListServiziAssociati(list);
        return servizio;
    }

    /**
     * Metodo che converte un Bean Servizio in un Bean Gui Servizio
     * @param s il Bean Servizio da convertire
     * @param gui il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Servizio convertito
     */
    public static BeanGuiServizio conversioneServizio(Servizio s, BeanGuiServizio gui) {

        gui.getDescrizione().setText(s.getDescrizione());
        gui.getDisponibilita().setText(s.getDisponibilita().toString());
        gui.getQuantita().setText(s.getQuantita().toString());
        gui.getPrezzo().setText(s.getPrezzo().toString());
        gui.getIva().setText(s.getIva().toString());


        /*gui.setDisponibilita(field);
        field.setText(s.getQuantita().toString());
        gui.setQuantita(field);
        field.setText(s.getTipo());
        gui.setTipo(field);
        field.setText(s.getPrezzo().toString());
        gui.setPrezzo(field);
        field.setText(s.getIdServizio().toString());
        gui.setIdServizio(field);
        field.setText(s.getIva().toString());
        gui.setIva(field);
        area.setText(s.getNote());
        gui.setNote(area);
        gui.setListServiziAssociati(gui.getListServiziAssociati());*/

        return gui;


    }

    /**
     * Metodo che converte un Bean Gui Pagamento in un normale Bean Pagamento
     * @param p
     * Il Bean Gui Pagamento da convertire
     * @return Il Bean Pagamento convertito
     * @throws Exception
     */
    public static Pagamento conversionePagamento(BeanGuiPagamento p) throws ValidatorException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Pagamento in un Bean Gui Pagamento
     * @param p il Bean Pagamento da convertire
     * @param pagamento il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Pagamento convertito
     * @throws Exception
     */
    public static BeanGuiPagamento conversionePagamento(Pagamento p, BeanGuiPagamento pagamento) throws ValidatorException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Gui Utente in un normale Bean Utente
     * @param bUtente
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Utente conversioneUtente(BeanGuiUtente bUtente) throws ValidatorException {

        Utente utente = new Utente();

        //   utente.setIdUtente(Integer.parseInt(bUtente.getIdUtenteTxt().getText()));
        utente.setUsername(bUtente.getTxtUsername().getText());
        utente.setPassword(bUtente.getTxtPassword().getText());
        utente.setCitta(bUtente.getTxtCitta().getText());
        utente.setProvincia(bUtente.getTxtProvincia().getText());
        utente.setCap(bUtente.getCap().getText());
        utente.setTelefono(bUtente.getTxtTelefono().getText());
        utente.setEmail(bUtente.getTxtEmail().getText());
        utente.setNote(bUtente.getTxtNote().getText());
        //      utente.setTipo(bUtente.getTipo().getText());
        //    utente.setVisible(Boolean.parseBoolean(bUtente.getTxtNotifica().getText()));

        return utente;
    }

    public static BeanGuiUtente conversioneUtente(Utente user, BeanGuiUtente utente) {

        //   utente.getIdUtenteTxt().setText(user.getIdUtente().toString());


        utente.getTxtUsername().setText(user.getUsername());

        utente.getTxtPassword().setText(user.getPassword());
        utente.getTxtCitta().setText(user.getCitta());
        utente.getTxtEmail().setText(user.getEmail());

        utente.getTxtProvincia().setText(user.getProvincia());
        utente.getTxtTelefono().setText(user.getTelefono());
//        utente.getTxtNote().setText(user.getNote());
//        utente.getVisible().setText(user.getVisible().toString());
        //    utente.getTipo().setText(user.getTipo());
        return utente;
    }

    /**
     * Metodo che converte un Bean Utente in un Bean Gui Utente
     * @param user il Bean da convertire
     * @param utente il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiUtente conversioneAreaPersonalePer(Personale user, BeanGuiPersonale utente) {

        utente.getTxtUsername().setText(user.getUsername());
        utente.getTxtUsername2().setText(user.getUsername());
        conversionePersonale(user, utente);

        

        return utente;
    }
    public static BeanGuiUtente conversioneAreaPersonaleExtra(ExtraAzienda user, BeanGuiExtraAzienda utente) {

        utente.getTxtUsername().setText(user.getUsername());
        utente.getTxtUsername2().setText(user.getUsername());
        conversioneExtraAzienda(user, utente);



        return utente;
    }
    /**
     * Metodo che converte un Bean Gui Personale in un normale Bean Personale
     * @param bp
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Personale conversionePersonale(BeanGuiPersonale bp) throws ValidatorException {


        Personale utente = new Personale();

        //   utente.setIdUtente(Integer.parseInt(bp.getIdUtenteTxt().getText()));
        utente.setUsername(bp.getTxtUsername().getText());
        utente.setPassword(bp.getTxtPassword().getText());
        utente.setCitta(bp.getTxtCitta().getText());
        utente.setProvincia(bp.getTxtProvincia().getText());
        utente.setCap(bp.getCap().getText());
        utente.setTelefono(bp.getTxtTelefono().getText());
        utente.setEmail(bp.getTxtEmail().getText());
        utente.setNote(bp.getTxtNote().getText());
        // utente.setTipo(bp.getTipo().getText());
        utente.setVisible(Boolean.parseBoolean(bp.getTxtNotifica().getText()));
        utente.setCognome(bp.getCognome().getText());
        utente.setNome(bp.getNome().getText());
        utente.setCodiceFiscale(bp.getCodiceFiscale().getText());
        utente.setRuolo(new Ruolo(bp.getRuolo().getText()));
        return utente;
    }

    /**
     * Metodo che converte un Bean Personale in un Bean Gui Personale
     * @param p il Bean da convertire
     * @param bp il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiPersonale conversionePersonale(Personale p, BeanGuiPersonale bp) {

        Conversione.conversioneUtente(p, bp);

        bp.getCognome().setText(p.getCognome());
      //  System.out.println("luisacognome" + p.getUsername());
        bp.getNome().setText(p.getNome());
        bp.getCodiceFiscale().setText(p.getCodiceFiscale());
        
        bp.getRuolo().setText(p.getRuolo().getNome());

        return bp;
    }

    /**
     * Metodo che converte un Bean Gui ExtraAzienda in un normale Bean ExtraAzienda
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static ExtraAzienda conversioneExtraAzienda(BeanGuiExtraAzienda e) throws ValidatorException {


        /*   ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : e.getListAppuntamenti()) {
        Appuntamento b1 = conversioneAppuntamento(b);
        a.add(b1);
        }

        for (BeanGuiContratto b : e.getListContratti()) {
        Contratto b1 = conversioneContratto(b);
        a1.add(b1);
        }*/
        ExtraAzienda utente = new ExtraAzienda();
        // utente.setIdUtente(Integer.parseInt(e.getIdUtenteTxt().getText()));
        utente.setUsername(e.getTxtUsername().getText());
        utente.setPassword(e.getTxtPassword().getText());
        utente.setCitta(e.getTxtCitta().getText());
        utente.setProvincia(e.getTxtProvincia().getText());
        utente.setCap(e.getCap().getText());
        utente.setTelefono(e.getTxtTelefono().getText());
        utente.setEmail(e.getTxtEmail().getText());
        utente.setNote(e.getTxtNote().getText());
        //  utente.setTipo(e.getTipo().getText());
        //utente.setVisible(Boolean.parseBoolean(e.getTxtNotifica().getText()));
        utente.setCognome(e.getCognome().getText());
        utente.setNome(e.getNome().getText());
        utente.setRagioneSociale(e.getRagioneSociale().getText());
        utente.setPIva(e.getPIva().getText());
        // utente.setFax(e.getFax().getText());
        //utente.setTipo(e.getTipo().getText());
        //utente.setListAppuntamenti(a);
        // utente.setListContratti(a1);
        return utente;
    }

    /**
     * Metodo che converte un Bean ExtraAzienda in un Bean Gui ExtraAzienda
     * @param e il Bean da convertire
     * @param extra il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     * @throws Exception
     */
    public static BeanGuiExtraAzienda conversioneExtraAzienda(ExtraAzienda e, BeanGuiExtraAzienda extra) throws ValidatorException {

        conversioneUtente(e, extra);
        //   extra.getIdUtenteTxt().setText(e.getIdUtente().toString());
        extra.getCognome().setText(e.getCognome());
        extra.getNome().setText(e.getNome());
        extra.getRagioneSociale().setText(e.getRagioneSociale());
        extra.getPIva().setText(e.getPIva());
        extra.getFax().setText(e.getFax());
        extra.getCodiceFiscale().setText(e.getCodiceFiscale());


        // extra.setListAppuntamenti(extra.getListAppuntamenti());
        // extra.setListContratti(extra.getListContratti());
        return extra;
    }

    /**
     * Metodo che converte un Bean Gui Responsabile in un normale Bean Responsabile
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Responsabile conversioneResponsabile(BeanGuiResponsabile r) throws ValidatorException {

        Responsabile utente = new Responsabile();
//        utente.setIdUtente(Integer.parseInt(r.getIdUtenteTxt().getText()));
        utente.setUsername(r.getTxtUsername().getText());
        utente.setPassword(r.getTxtPassword().getText());
        utente.setCitta(r.getTxtCitta().getText());
        utente.setProvincia(r.getTxtProvincia().getText());
        utente.setTelefono(r.getTxtTelefono().getText());
        utente.setEmail(r.getTxtEmail().getText());
        utente.setNote(r.getTxtNote().getText());
        // utente.setVisible(Boolean.parseBoolean(r.getTxtNotifica().getText()));
        utente.setCognome(r.getCognome().getText());
        utente.setNome(r.getNome().getText());
        utente.setCodiceFiscale(r.getCodiceFiscale().getText());
        utente.setRuolo(new Ruolo(r.getRuolo().getText()));
        return utente;

    }

    /**
     * Metodo che converte un Bean Responsabile in un Bean Gui Responsabile
     * @param e il Bean da convertire
     * @param br il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiResponsabile conversioneResponsabile(Responsabile e, BeanGuiResponsabile br) {
        conversioneUtente(e, br);

        return br;
    }

    /**
     * Metodo che converte un Bean Gui Dipendente in un normale Bean Dipendente
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Dipendente conversioneDipendente(BeanGuiDipendente r) throws ValidatorException {

        /* ArrayList<Appuntamento> a2 = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a3 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : r.getListAppuntamenti()) {
        Appuntamento c = conversioneAppuntamento(b);
        a2.add(c);
        }

        for (BeanGuiContratto b : r.getListContratti()) {
        Contratto b1 = conversioneContratto(b);
        a3.add(b1);
        }*/

        Dipendente utente = new Dipendente();
//        utente.setIdUtente(Integer.parseInt(r.getIdUtenteTxt().getText()));
        utente.setUsername(r.getTxtUsername().getText());
        utente.setPassword(r.getTxtPassword().getText());
        utente.setCitta(r.getTxtCitta().getText());
        utente.setProvincia(r.getTxtProvincia().getText());
         utente.setCap(r.getCap().getText());
        utente.setTelefono(r.getTxtTelefono().getText());
        utente.setEmail(r.getTxtEmail().getText());
        utente.setNote(r.getTxtNote().getText());
        //utente.setTipo(r.getTipo().getText());
        //utente.setVisible(Boolean.parseBoolean(r.getTxtNotifica().getText()));
        utente.setCognome(r.getCognome().getText());
        utente.setNome(r.getNome().getText());
        utente.setCodiceFiscale(r.getCodiceFiscale().getText());
        utente.setRuolo(new Ruolo(r.getRuolo().getText()));
        //utente.setListAppuntamenti(a2);
        //utente.setListContratti(a3);
        return utente;
    }

    /**
     * Metodo che converte un Bean Dipendente in un Bean Gui Diependente
     * @param e il Bean da convertire
     * @param bd il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiDipendente conversioneDipendente(Dipendente e, BeanGuiDipendente bd) {

        conversionePersonale(e, bd);
        return bd;
    }

    /**
     * Metodo che converte un Bean Amministratore in un Bean Gui Amministratore
     * @param e il Bean da convertire
     * @param ba
     * @return il Bean Gui convertito
     */
    public static BeanGuiAmministratore conversioneAmministratore(Amministratore e, BeanGuiAmministratore ba) {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        ba.setIdUtenteTxt(c);
        c.setText(e.getPassword());
        ba.setTxtPassword(c);
        c.setText(e.getCitta());
        ba.setTxtCitta(c);
        c.setText(e.getEmail());
        ba.setTxtEmail(c);
        c.setText(e.getProvincia());
        ba.setTxtProvincia(c);
        c.setText(e.getTelefono());
        ba.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        ba.setTxtUsername(c);
        c.setText(e.getCognome());
        ba.setCognome(c);
        c.setText(e.getNome());
        ba.setNome(c);
        c.setText(e.getCodiceFiscale());
        ba.setCodiceFiscale(c);
        c.setText(e.getRuolo().getNome());
        ba.setRuolo(c);
        c.setText(e.getVisible().toString());
        ba.setTxtnotifica(c);
        ba.setAzienda(conversioneAzienda(e.getAzienda(), new BeanGuiAzienda()));
        return ba;
    }

    /**
     * Metodo che converte un Bean Gui Amministratore in un normale Bean Amministratore
     * @param r
     * @return il Bean convertito
     * @throws Exception
     */
    public static Amministratore conversioneAmministratore(BeanGuiAmministratore r) throws ValidatorException {

        Amministratore utente = new Amministratore();
        utente.setIdUtente(Integer.parseInt(r.getIdUtenteTxt().getText()));
        utente.setUsername(r.getTxtUsername().getText());
        utente.setPassword(r.getTxtPassword().getText());
        utente.setCitta(r.getTxtCitta().getText());
        utente.setProvincia(r.getTxtProvincia().getText());
        utente.setCap(r.getCap().getText());
        utente.setTelefono(r.getTxtTelefono().getText());
        utente.setEmail(r.getTxtEmail().getText());
        utente.setNote(r.getTxtNote().getText());
        utente.setTipo(r.getTipo().getText());
        utente.setVisible(Boolean.parseBoolean(r.getTxtNotifica().getText()));
        utente.setCognome(r.getCognome().getText());
        utente.setNome(r.getNome().getText());
        utente.setCodiceFiscale(r.getCodiceFiscale().getText());
        utente.setRuolo(new Ruolo(r.getRuolo().getText()));
        utente.setAzienda(conversioneAzienda(r.getAzienda()));
        return utente;
    }

    /**
     * Metodo che converte un Bean Gui Contatto in un normale Bean Contatto
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Contatto conversioneContatto(BeanGuiContatto e) throws ValidatorException {

        ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : e.getListAppuntamenti()) {
            Appuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
        }

        for (BeanGuiContratto b : e.getListContratti()) {
            Contratto b1 = conversioneContratto(b);
            a1.add(b1);
        }
        Contatto utente = new Contatto();
        utente.setIdUtente(Integer.parseInt(e.getIdUtenteTxt().getText()));
        utente.setUsername(e.getTxtUsername().getText());
        utente.setPassword(e.getTxtPassword().getText());
        utente.setCitta(e.getTxtCitta().getText());
        utente.setProvincia(e.getTxtProvincia().getText());
        utente.setCap(e.getCap().getText());
        utente.setTelefono(e.getTxtTelefono().getText());
        utente.setEmail(e.getTxtEmail().getText());
        utente.setNote(e.getTxtNote().getText());
        utente.setTipo(e.getTipo().getText());
        utente.setVisible(Boolean.parseBoolean(e.getTxtNotifica().getText()));
        utente.setCognome(e.getCognome().getText());
        utente.setNome(e.getNome().getText());
        utente.setRagioneSociale(e.getRagioneSociale().getText());
        utente.setPIva(e.getPIva().getText());
        utente.setFax(e.getFax().getText());
        utente.setTipo(e.getTipo().getText());
        utente.setListAppuntamenti(a);
        utente.setListContratti(a1);
        utente.setFeedback(Integer.parseInt(e.getTxtFeedback().getText()));
        return utente;
    }

    /**
     * Metodo che converte un Bean Contatto in un Bean Gui Contatto
     * @param e il Bean da convertire
     * @param cont il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     * @throws Exception
     */
    public static BeanGuiContatto conversioneContatto(Contatto e, BeanGuiContatto cont) throws ValidatorException {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        cont.setIdUtenteTxt(c);
        c.setText(e.getPassword());
        cont.setTxtPassword(c);
        c.setText(e.getCitta());
        cont.setTxtCitta(c);
        c.setText(e.getEmail());
        cont.setTxtEmail(c);
        c.setText(e.getProvincia());
        cont.setTxtProvincia(c);
        c.setText(e.getTelefono());
        cont.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        cont.setTxtUsername(c);
        c.setText(e.getCap().toString());
        cont.setCap(c);
        c.setText(e.getVisible().toString());
        cont.setTxtnotifica(c);

        c.setText(e.getCognome().toString());
        cont.setCognome(c);
        c.setText(e.getNome().toString());
        cont.setNome(c);
        c.setText(e.getRagioneSociale().toString());
        cont.setRagioneSociale(c);
        c.setText(e.getPIva().toString());
        cont.setPIva(c);
        c.setText(e.getFax().toString());
        cont.setFax(c);
        c.setText(e.getRuolo());
        cont.setRuolo(c);
        cont.setListAppuntamenti(cont.getListAppuntamenti());
        cont.setListContratti(cont.getListContratti());
        c.setText(e.getFeedback().toString());
        cont.setTxtFeedback(c);
        return cont;
    }

    /**
     * Metodo che converte un Bean Gui Cliente in un normale Bean Cliente
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Cliente conversioneCliente(BeanGuiCliente e) throws ValidatorException {
        /*   ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : e.getListAppuntamenti()) {
        Appuntamento b1 = conversioneAppuntamento(b);
        a.add(b1);
        }

        for (BeanGuiContratto b : e.getListContratti()) {
        Contratto b1 = conversioneContratto(b);
        a1.add(b1);
        }
         */

        Cliente utente = new Cliente();
//             utente.setIdUtente(Integer.parseInt(e.getIdUtenteTxt().getText()));
        utente.setUsername(e.getTxtUsername().getText());
        utente.setPassword(e.getTxtPassword().getText());
        utente.setCitta(e.getTxtCitta().getText());
        utente.setProvincia(e.getTxtProvincia().getText());
        utente.setCap(e.getCap().getText());
        utente.setTelefono(e.getTxtTelefono().getText());
        utente.setEmail(e.getTxtEmail().getText());
        utente.setNote(e.getTxtNote().getText());
        //      utente.setTipo(e.getTipo().getText());
        //  utente.setVisible(Boolean.parseBoolean(e.getTxtNotifica().getText()));
        utente.setCognome(e.getCognome().getText());
        utente.setNome(e.getNome().getText());
        utente.setRagioneSociale(e.getRagioneSociale().getText());
        utente.setPIva(e.getPIva().getText());
        utente.setCodiceFiscale(e.getCodiceFiscale().getText());
        utente.setFax(e.getFax().getText());
        //utente.setTipo(e.getTipo().getText());
        //utente.setListAppuntamenti(a);
        // utente.setListContratti(a1);
        return utente;
    }

    /**
     * Metodo che converte un Bean Cliente in un Bean Gui Cliente
     * @param e il Bean da convertire
     * @param cl il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     * @throws Exception
     */
    public static BeanGuiCliente conversioneCliente(Cliente e, BeanGuiCliente cl) throws ValidatorException {


        conversioneExtraAzienda(e, cl);
        //   cl.getRuolo().setText("Cliente");
       /* cl.setListAppuntamenti(cl.getListAppuntamenti());
        cl.setListContratti(cl.getListContratti());*/

        return cl;
    }

    /**
     * Metodo che converte un Bean Gui Fornitore in un normale Bean Fornitore
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Fornitore conversioneFornitore(BeanGuiFornitore e) throws ValidatorException {
        /* ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : e.getListAppuntamenti()) {
        Appuntamento b1 = conversioneAppuntamento(b);
        a.add(b1);
        }

        for (BeanGuiContratto b : e.getListContratti()) {
        Contratto b1 = conversioneContratto(b);
        a1.add(b1);
        }
         */
        Fornitore utente = new Fornitore();
        //   utente.setIdUtente(Integer.parseInt(e.getIdUtenteTxt().getText()));
        utente.setUsername(e.getTxtUsername().getText());
        utente.setPassword(e.getTxtPassword().getText());
        utente.setCitta(e.getTxtCitta().getText());
        utente.setProvincia(e.getTxtProvincia().getText());
        utente.setCap(e.getCap().getText());
        utente.setTelefono(e.getTxtTelefono().getText());
        utente.setEmail(e.getTxtEmail().getText());
        utente.setNote(e.getTxtNote().getText());
        utente.setCognome(e.getCognome().getText());
        utente.setCodiceFiscale(e.getCodiceFiscale().getText());
        //utente.setTipo(e.getTipo().getText());
        //utente.setVisible(Boolean.parseBoolean(e.getTxtNotifica().getText()));
        utente.setNome(e.getNome().getText());
        utente.setRagioneSociale(e.getRagioneSociale().getText());
        utente.setPIva(e.getPIva().getText());
        utente.setFax(e.getFax().getText());
        //utente.setTipo(e.getTipo().getText());
        //utente.setListAppuntamenti(a);
        //utente.setListContratti(a1);
        return utente;
    }

    /**
     * Metodo che converte un Bean Fornitore in un Bean Gui Fornitore
     * @param e il Bean da convertire
     * @param fo il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiFornitore conversioneFornitore(Fornitore e, BeanGuiFornitore fo) {

        conversioneExtraAzienda(e, fo);
        //  fo.getRuolo().setText("Fornitore");
        return fo;
    }

    /**
     * Metodo che converte un Bean Appuntamento in un Bean Gui Appuntamento
     * @param b il Bean da convertire
     * @param app il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiAppuntamento conversioneAppuntamento(Appuntamento b, BeanGuiAppuntamento app) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Gui Appuntamento in un normale Bean Appuntamento
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Appuntamento conversioneAppuntamento(BeanGuiAppuntamento b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Gui Permesso in un normale Bean Permesso
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Permesso conversionePermesso(BeanGuiPermesso b) {

        Permesso p = new Permesso(b.getIdPermesso(), b.getCat(), b.getAct().getText());
        return p;
    }

    /**
     * Metodo che converte un Bean Permesso in un Bean Gui Permesso
     * @param b il Bean da convertire
     * @param p il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiPermesso conversionePermesso(Permesso b, BeanGuiPermesso p) throws Exception {
        p.setIdPermesso(b.getId());
        p.getAct().setText(b.getActions());
        //p.setAct(new JCheckBox(b.getActions()));
        p.setCat(b.getName());
        return p;
    }

    /**
     * Metodo che converte un Bean Gui Ruolo in un normale Bean Ruolo
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     * @throws Exception
     */
    public static Ruolo conversioneRuolo(BeanGuiRuolo b) {
        Ruolo r = new Ruolo(b.getNome().getText());
        r.setPermSyncro(false);
        Iterator it = b.getListPermessi().entrySet().iterator();
        Map.Entry entry;
        while (it.hasNext()) {
            entry = (Map.Entry) it.next();
            ArrayList<BeanGuiPermesso> e = (ArrayList<BeanGuiPermesso>) entry.getValue();
            for (BeanGuiPermesso bean : e) {
                if (bean.getAct().isSelected()) {
                    r.addPermesso(conversionePermesso(bean));
                }
            }
        }
        return r;
    }

    /**
     * Metodo che converte un Bean Ruolo in un Bean Gui Ruolo
     * @param b il Bean da convertire
     * @param r
     * @para r il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiRuolo conversioneRuolo(Ruolo b, BeanGuiRuolo r) throws ValidatorException, SQLException {
        r.resetAll();
        r.getNome().setText(b.getNome());
        HashMap<String, ArrayList<BeanGuiPermesso>> lipi = r.getListPermessi();//new HashMap<String, ArrayList<BeanGuiPermesso>>();
        PermessoCollection p = b.getListPermesso();
        Iterator<Permesso> it = p.iterator();
        Permesso f = null;
        ArrayList<BeanGuiPermesso> c;
        while (it.hasNext()) {
            f = it.next();
            c = lipi.get(f.getName());
            for (BeanGuiPermesso bean : c) {
                if (bean.getAct().getText().equalsIgnoreCase(f.getActions())) {
                    bean.getAct().setSelected(true);
                    break;
                }
            }
        }
        r.getTabPers().setModel(new PersonaleTm(b));

        return r;

    }

    private static Agenda conversioneAgenda(BeanGuiAgenda agenda) throws ValidatorException {
        ArrayList<Evento> a = new ArrayList<Evento>();
        for (BeanGuiEvento b : agenda.getArrEventi()) {
            Evento e = conversioneEvento(b);
            a.add(e);
        }
        Agenda agenda1 = new Agenda();
        agenda1.setIdAgenda(Integer.parseInt(agenda.getIdAgenda().getText()));
        agenda1.setUtente(conversioneUtente(agenda.getUtente()));
        agenda1.setListEventi(a);
        return agenda1;
    }

    /**
     *
     * @param azienda
     * @return
     * @throws java.lang.Exception
     */
    public static Azienda conversioneAzienda(BeanGuiAzienda azienda) throws ValidatorException {
        Azienda azienda1 = new Azienda();
//        azienda1.setCitta(azienda.getCitta().getText());
        azienda1.setEmail(azienda.getEmail().getText());
        //      azienda1.setFax(azienda.getFax().getText());
        azienda1.setIndirizzo(azienda.getInidirizzo().getText());
        azienda1.setNazione(azienda.getNazione().getText());
        azienda1.setPIVA(azienda.getPIVA().getText());
        azienda1.setRagioneSociale(azienda.getRagioneSociale().getText());
        azienda1.setTelefono(azienda.getTelefono().getText());
        
        //    azienda1.setIdAzienda(Integer.parseInt(azienda.getIdAzienda().getText()));
        //azienda1.setNote(azienda.getNote().getText());
        //azienda1.setAmministratore(conversioneAmministratore(azienda.getAmministratore()));
        return azienda1;
    }

    private static BeanGuiAgenda conversioneAgenda(Agenda agenda, BeanGuiAgenda beanGuiAgenda) {
        JTextField c = new JTextField();
        c.setText(agenda.getIdAgenda().toString());
        beanGuiAgenda.setIdAgenda(c);
        beanGuiAgenda.setUtente(conversioneUtente(new Utente(), beanGuiAgenda.getUtente()));
        beanGuiAgenda.setArrEventi(beanGuiAgenda.getArrEventi());
        return beanGuiAgenda;
    }

    private static ServizioAssociato conversioneAssociato(BeanGuiServizioAssociato c) throws ValidatorException {
        ServizioAssociato sa = new ServizioAssociato();
        sa.seServizio(conversioneServizio(c.getServizio()));
        sa.setContratto(conversioneContratto(c.getContratto()));
        sa.setNote(c.getNote().getText());
        sa.setPrezzoUnitario(Double.parseDouble(c.getPrezzoUnitario().getText()));
        sa.setQuantita(Integer.parseInt(c.getQuantita().getText()));
        return sa;
    }

    /**
     *
     * @param a
     * @param bga
     * @return
     */
    public static BeanGuiAzienda conversioneAzienda(Azienda a, BeanGuiAzienda bga) {

//        bga.getCitta().setText(a.getCitta());
//
        bga.getEmail().setText(a.getEmail());
        //  bga.getFax().setText(a.getFax());

        bga.getInidirizzo().setText(a.getIndirizzo());

        bga.getNazione().setText(a.getNazione());
        bga.getPIVA().setText(a.getPIVA());
        bga.getRagioneSociale().setText(a.getRagioneSociale());
        bga.getTelefono().setText(a.getTelefono());
        //bga.setAmministratore(bga.getAmministratore());
        return bga;
    }
}
