package it.seerp.application.conversioni;

import it.seerp.configurazioni.PermessiDefault;
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
import it.seerp.jaas.PermessoCollection;
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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import java.util.Set;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
     */
    public static Contratto conversioneContratto(BeanGuiContratto pGui) throws Exception {
        ArrayList<Pagamento> listPag = new ArrayList<Pagamento>();
        ArrayList<ServizioAssociato> listSer = new ArrayList<ServizioAssociato>();
        ArrayList<Fattura> listFatt= new ArrayList<Fattura>();

        for (BeanGuiPagamento p : pGui.getListPagamento()) {
            Pagamento p1 = conversionePagamento(p);
            listPag.add(p1);
        }

        for (BeanGuiServizioAssociato s : pGui.getListServizio()) {
            ServizioAssociato s1 = conversioneAssociato(s);
            listSer.add(s1);
        }
        Contratto contratto= new Contratto();
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
     */
    public static BeanGuiContratto conversioneContratto(Contratto c, BeanGuiContratto gui) throws Exception {
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
        gui.setDipendente(conversioneDipendente(c.getDipendente(), new BeanGuiDipendente()));
        gui.setExtraAzienda(conversazioneExtraAzienda(c.getExtraAzienda(), new BeanGuiExtraAzienda()));
        gui.setListPagamento(gui.getListPagamento());
        gui.setListServizio(gui.getListServizio());

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Evento in un normale Bean Evento
     * @param pGui
     * Il Bean Gui Evento da convertire
     * @return Il Bean Evento convertito
     */
    public static Evento conversioneEvento(BeanGuiEvento pGui) throws Exception {
        Evento evento= new Evento();
        evento.setLuogo(pGui.getLuogo().getText());
        evento.setTema(pGui.getTema().getText());
        evento.setNome(pGui.getNome().getText());
        evento.setNote(pGui.getNote().getText());
        GregorianCalendar data = null;
        data.setTimeInMillis(Long.parseLong(pGui.getData().getText()));
        evento.setData(data);
        GregorianCalendar ora= null;
        ora.setTimeInMillis(Long.parseLong(pGui.getOra().getText()));
        evento.setOra(ora);
        evento.setIdEvento(Integer.parseInt(pGui.getIdEvento().getText()));
        evento.setAgenda(conversioneAgenda(pGui.getAgenda()));
        evento.setNotifica(Boolean.parseBoolean(pGui.getNotifica().getText()));

        return evento;
    }

    /**
     * Metodo che converte un Bean Evento  in un Bean Gui Evento
     * @param e il Bean Evento da convertire
     * @param gui il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Evento convertito
     */
    public static BeanGuiEvento conversioneEvento(Evento e, BeanGuiEvento gui) {

        JTextField field = new JTextField();
        JTextArea area = new JTextArea();

        field.setText(e.getLuogo());
        gui.setLuogo(field);
        field.setText(e.getTema());
        gui.setTema(field);
        field.setText(e.getNome());
        gui.setNome(field);
        field.setText(e.getNote());
        gui.setNote(area);
        field.setText(e.getData().toString());
        gui.setData(field);
        field.setText(e.getOra().toString());
        gui.setOra(field);
        field.setText(Integer.toString(e.getIdEvento()));
        gui.setIdEvento(field);
        gui.setAgenda(conversioneAgenda(e.getAgenda(), new BeanGuiAgenda()));

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Servizio in un normale Bean Servizio
     * @param pGui
     * Il Bean Gui Servizio da convertire
     * @return Il Bean Servizio convertito
     */
    public static Servizio conversioneServizio(BeanGuiServizio pGui) throws Exception {
        ArrayList<ServizioAssociato> list = new ArrayList<ServizioAssociato>();

        for (BeanGuiServizioAssociato c : pGui.getListServiziAssociati()) {
            ServizioAssociato c1 = conversioneAssociato(c);
            list.add(c1);
        }
        Servizio servizio = new Servizio();
        servizio.setDescrizione(pGui.getDescrizione().getText());
        servizio.setDisponibilita(Boolean.parseBoolean(pGui.getDisponibilita().getText()));
        servizio.setQuantita(Integer.parseInt(pGui.getQuantita().getText()));
        servizio.setTipo( pGui.getTipo().getText());
        servizio.setPrezzo(Double.parseDouble(pGui.getPrezzo().getText()));
        servizio.setIdServizio(Integer.parseInt(pGui.getIdServizio().getText()));
        servizio.setIva(Integer.parseInt(pGui.getIva().getText()));
        servizio.setNote(pGui.getNote().getText());
        servizio.setListServiziAssociati(list);
        return servizio;
    }

    /**
     * Metodo che converte un Bean Servizio in un Bean Gui Servizio
     * @param s il Bean Servizio da convertire
     * @param gui il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Servizio convertito
     */
    public static BeanGuiServizio conversioneServizio(Servizio s, BeanGuiServizio gui) {

        JTextField field = new JTextField();
        JTextArea area = new JTextArea();

        field.setText(s.getDescrizione());
        gui.setDescrizione(field);
        field.setText(s.getDisponibilita().toString());
        gui.setDisponibilita(field);
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
        gui.setListServiziAssociati(gui.getListServiziAssociati());

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Pagamento in un normale Bean Pagamento
     * @param p
     * Il Bean Gui Pagamento da convertire
     * @return Il Bean Pagamento convertito
     */
    public static Pagamento conversionePagamento(BeanGuiPagamento p) throws Exception {
       throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Pagamento in un Bean Gui Pagamento
     * @param p il Bean Pagamento da convertire
     * @param pagamento il Bean Grafico che deve essere modificato
     * @return Il Bean Gui Pagamento convertito
     */
    public static BeanGuiPagamento conversionePagamento(Pagamento p, BeanGuiPagamento pagamento) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo che converte un Bean Gui Utente in un normale Bean Utente
     * @param bUtente
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Utente conversioneUtente(BeanGuiUtente bUtente) throws Exception {
        Utente utente = new Utente();
        utente.setIdUtente(Integer.parseInt(bUtente.getIdUtenteTxt().getText()));
        utente.setUsername(bUtente.getTxtUsername().getText());
        utente.setPassword(bUtente.getTxtPassword().getText());
        utente.setCitta(bUtente.getTxtCitta().getText());
        utente.setProvincia(bUtente.getTxtProvincia().getText());
        utente.setCap(bUtente.getCap().getText());
        utente.setTelefono(bUtente.getTxtTelefono().getText());
        utente.setEmail(bUtente.getTxtEmail().getText());
        utente.setNote(bUtente.getTxtNote().getText());
        utente.setTipo(bUtente.getTipo().getText());
        utente.setVisible(Boolean.parseBoolean(bUtente.getTxtNotifica().getText()));
        return utente;
    }

    /**
     * Metodo che converte un Bean Utente in un Bean Gui Utente
     * @param user il Bean da convertire
     * @param utente il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiUtente conversioneUtente(Utente user, BeanGuiUtente utente) {
        JTextField field = new JTextField();
        field.setText(user.getIdUtente().toString());
        utente.setIdUtenteText(field);
        field.setText(user.getPassword());
        utente.setTxtPassword(field);
        field.setText(user.getCitta());
        utente.setTxtCitta(field);
        field.setText(user.getEmail());
        utente.setTxtEmail(field);
        field.setText(user.getProvincia());
        utente.setTxtProvincia(field);
        field.setText(user.getTelefono());
        utente.setTxtTelefono(field);
        field.setText(user.getNote().toString());
        utente.setTxtUsername(field);
        field.setText(user.getVisible().toString());
        utente.setTxtnotifica(field);
        field.setText(user.getTipo());
        utente.setTipo(field);
        return utente;
    }

    /**
     * Metodo che converte un Bean Gui Personale in un normale Bean Personale
     * @param bp
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Personale conversionePersonale(BeanGuiPersonale bp) throws Exception {
        

        Personale utente = new Personale();
        utente.setIdUtente(Integer.parseInt(bp.getIdUtenteTxt().getText()));
        utente.setUsername(bp.getTxtUsername().getText());
        utente.setPassword(bp.getTxtPassword().getText());
        utente.setCitta(bp.getTxtCitta().getText());
        utente.setProvincia(bp.getTxtProvincia().getText());
        utente.setCap(bp.getCap().getText());
        utente.setTelefono(bp.getTxtTelefono().getText());
        utente.setEmail(bp.getTxtEmail().getText());
        utente.setNote(bp.getTxtNote().getText());
        utente.setTipo(bp.getTipo().getText());
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

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();
        c.setText(p.getIdUtente().toString());
        bp.setIdUtenteText(c);
        c.setText(p.getPassword());
        bp.setTxtPassword(c);
        c.setText(p.getCitta());
        bp.setTxtCitta(c);
        c.setText(p.getEmail());
        bp.setTxtEmail(c);
        c.setText(p.getProvincia());
        bp.setTxtProvincia(c);
        c.setText(p.getTelefono());
        bp.setTxtTelefono(c);
        c.setText(p.getNote().toString());
        bp.setTxtUsername(c);
        c.setText(p.getCognome());
        bp.setCognome(c);
        c.setText(p.getNome());
        bp.setNome(c);
        c.setText(p.getCodiceFiscale());
        bp.setCodiceFiscale(c);
        c.setText(p.getRuolo().getNome());
        bp.setRuolo(c);
        bp.setTxtnotifica(c);
        return bp;
    }

    /**
     * Metodo che converte un Bean Gui ExtraAzienda in un normale Bean ExtraAzienda
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static ExtraAzienda conversioneExtraAzienda(BeanGuiExtraAzienda e) throws Exception {


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
        ExtraAzienda utente = new ExtraAzienda();
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
        return utente;
    }

    /**
     * Metodo che converte un Bean ExtraAzienda in un Bean Gui ExtraAzienda
     * @param e il Bean da convertire
     * @param extra il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiExtraAzienda conversazioneExtraAzienda(ExtraAzienda e, BeanGuiExtraAzienda extra) throws Exception {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        extra.setIdUtenteText(c);
        c.setText(e.getPassword());
        extra.setTxtPassword(c);
        c.setText(e.getCitta());
        extra.setTxtCitta(c);
        c.setText(e.getEmail());
        extra.setTxtEmail(c);
        c.setText(e.getProvincia());
        extra.setTxtProvincia(c);
        c.setText(e.getTelefono());
        extra.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        extra.setTxtUsername(c);
        c.setText(e.getCap().toString());
        extra.setCap(c);
        c.setText(e.getVisible().toString());
        extra.setTxtnotifica(c);
        
        c.setText(e.getCognome().toString());
        extra.setCognome(c);
        c.setText(e.getNome().toString());
        extra.setNome(c);
        c.setText(e.getRagioneSociale().toString());
        extra.setRagioneSociale(c);
        c.setText(e.getPIva().toString());
        extra.setPIva(c);
        c.setText(e.getFax().toString());
        extra.getFax();
        c.setText(e.getRuolo());
        extra.setRuolo(c);
        extra.setListAppuntamenti(extra.getListAppuntamenti());
        extra.setListContratti(extra.getListContratti());
        return extra;
    }

    /**
     * Metodo che converte un Bean Gui Responsabile in un normale Bean Responsabile
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Responsabile conversioneResponsabile(BeanGuiResponsabile r) throws Exception {

        Responsabile utente = new Responsabile();
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
        return utente;
       
    }

    /**
     * Metodo che converte un Bean Responsabile in un Bean Gui Responsabile
     * @param e il Bean da convertire
     * @param br il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiResponsabile conversioneResponsabile(Responsabile e, BeanGuiResponsabile br) {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        br.setIdUtenteText(c);
        c.setText(e.getPassword());
        br.setTxtPassword(c);
        c.setText(e.getCitta());
        br.setTxtCitta(c);
        c.setText(e.getEmail());
        br.setTxtEmail(c);
        c.setText(e.getProvincia());
        br.setTxtProvincia(c);
        c.setText(e.getTelefono());
        br.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        br.setTxtUsername(c);
        c.setText(e.getCognome());
        br.setCognome(c);
        c.setText(e.getNome());
        br.setNome(c);
        c.setText(e.getCodiceFiscale());
        br.setCodiceFiscale(c);
        c.setText(e.getRuolo().getNome());
        br.setRuolo(c);
        c.setText(e.getVisible().toString());
        br.setTxtnotifica(c);
        return br;
    }

    /**
     * Metodo che converte un Bean Gui Dipendente in un normale Bean Dipendente
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Dipendente conversioneDipendente(BeanGuiDipendente r) throws Exception {

        ArrayList<Appuntamento> a2 = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a3 = new ArrayList<Contratto>();

        for (BeanGuiAppuntamento b : r.getListAppuntamenti()) {
            Appuntamento c = conversioneAppuntamento(b);
            a2.add(c);
        }

        for (BeanGuiContratto b : r.getListContratti()) {
            Contratto b1 = conversioneContratto(b);
            a3.add(b1);
        }

        Dipendente utente = new Dipendente();
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
        utente.setListAppuntamenti(a2);
        utente.setListContratti(a3);
        return utente;
    }

    /**
     * Metodo che converte un Bean Dipendente in un Bean Gui Diependente
     * @param e il Bean da convertire
     * @param bd il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiDipendente conversioneDipendente(Dipendente e, BeanGuiDipendente bd) {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        bd.setIdUtenteText(c);
        c.setText(e.getPassword());
        bd.setTxtPassword(c);
        c.setText(e.getCitta());
        bd.setTxtCitta(c);
        c.setText(e.getEmail());
        bd.setTxtEmail(c);
        c.setText(e.getProvincia());
        bd.setTxtProvincia(c);
        c.setText(e.getTelefono());
        bd.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        bd.setTxtUsername(c);
        c.setText(e.getCognome());
        bd.setCognome(c);
        c.setText(e.getNome());
        bd.setNome(c);
        c.setText(e.getCodiceFiscale());
        bd.setCodiceFiscale(c);
        c.setText(e.getRuolo().getNome());
        bd.setRuolo(c);
        c.setText(e.getVisible().toString());
        bd.setTxtnotifica(c);
        bd.setListAppuntamenti(bd.getListAppuntamenti());
        bd.setListContratti(bd.getListContratti());
        return bd;
    }


    /**
     * Metodo che converte un Bean Amministratore in un Bean Gui Amministratore
     * @param e il Bean da convertire
     * @param br il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiAmministratore conversioneAmministratore(Amministratore e, BeanGuiAmministratore ba) {

       JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        ba.setIdUtenteText(c);
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
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Amministratore conversioneAmministratore(BeanGuiAmministratore r) throws Exception {

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
     */
    public static Contatto conversioneContatto(BeanGuiContatto e) throws Exception {

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
     */
    public static BeanGuiContatto conversioneContatto(Contatto e, BeanGuiContatto cont) throws Exception {

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        cont.setIdUtenteText(c);
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
     */
    public static Cliente conversioneCliente(BeanGuiCliente e) throws Exception {
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


        Cliente utente = new Cliente();
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
        return utente;
    }

    /**
     * Metodo che converte un Bean Cliente in un Bean Gui Cliente
     * @param e il Bean da convertire
     * @param cl il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiCliente conversioneCliente(Cliente e, BeanGuiCliente cl) throws Exception {

       JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        cl.setIdUtenteText(c);
        c.setText(e.getPassword());
        cl.setTxtPassword(c);
        c.setText(e.getCitta());
        cl.setTxtCitta(c);
        c.setText(e.getEmail());
        cl.setTxtEmail(c);
        c.setText(e.getProvincia());
        cl.setTxtProvincia(c);
        c.setText(e.getTelefono());
        cl.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        cl.setTxtUsername(c);
        c.setText(e.getCap().toString());
        cl.setCap(c);
        c.setText(e.getVisible().toString());
        cl.setTxtnotifica(c);

        c.setText(e.getCognome().toString());
        cl.setCognome(c);
        c.setText(e.getNome().toString());
        cl.setNome(c);
        c.setText(e.getRagioneSociale().toString());
        cl.setRagioneSociale(c);
        c.setText(e.getPIva().toString());
        cl.setPIva(c);
        c.setText(e.getFax().toString());
        cl.setFax(c);
        c.setText(e.getRuolo());
        cl.setRuolo(c);
        cl.setListAppuntamenti(cl.getListAppuntamenti());
        cl.setListContratti(cl.getListContratti());

        return cl;
    }

    /**
     * Metodo che converte un Bean Gui Fornitore in un normale Bean Fornitore
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Fornitore conversioneFornitore(BeanGuiFornitore e) throws Exception {
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

        Fornitore utente = new Fornitore();
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
        return utente;
    }

    /**
     * Metodo che converte un Bean Fornitore in un Bean Gui Fornitore
     * @param e il Bean da convertire
     * @param fo il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiFornitore conversioneFornitore(Fornitore e, BeanGuiFornitore fo) {


       JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        fo.setIdUtenteText(c);
        c.setText(e.getPassword());
        fo.setTxtPassword(c);
        c.setText(e.getCitta());
        fo.setTxtCitta(c);
        c.setText(e.getEmail());
        fo.setTxtEmail(c);
        c.setText(e.getProvincia());
        fo.setTxtProvincia(c);
        c.setText(e.getTelefono());
        fo.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        fo.setTxtUsername(c);
        c.setText(e.getCap().toString());
        fo.setCap(c);
        c.setText(e.getVisible().toString());
        fo.setTxtnotifica(c);

        c.setText(e.getCognome().toString());
        fo.setCognome(c);
        c.setText(e.getNome().toString());
        fo.setNome(c);
        c.setText(e.getRagioneSociale().toString());
        fo.setRagioneSociale(c);
        c.setText(e.getPIva().toString());
        fo.setPIva(c);
        c.setText(e.getFax().toString());
        fo.setFax(c);
        c.setText(e.getRuolo());
        fo.setRuolo(c);
        fo.setListAppuntamenti(fo.getListAppuntamenti());
        fo.setListContratti(fo.getListContratti());
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
     */
    public static Permesso conversionePermesso(BeanGuiPermesso b) throws Exception {

        Permesso p= new Permesso(b.getIdPermesso(),b.getCat(),b.getAct().getText());
        return p;
    }

    /**
     * Metodo che converte un Bean Permesso in un Bean Gui Permesso
     * @param b il Bean da convertire
     * @param p il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiPermesso conversionePermesso(Permesso b, BeanGuiPermesso p) {
           p.setIdPermesso(b.getId());
           p.setAct(new JCheckBox(b.getActions()));
           p.setCat(b.getName());
           return p;
    }

    /**
     * Metodo che converte un Bean Gui Ruolo in un normale Bean Ruolo
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public static Ruolo conversioneRuolo(BeanGuiRuolo b) throws Exception {
        Ruolo r = new Ruolo(b.getNome().getText());
        r.setPermSyncro(false);
       Iterator it = b.getListPermessi().entrySet().iterator();
       Map.Entry entry;
        while (it.hasNext()) {
          entry = (Map.Entry) it.next();
          ArrayList<BeanGuiPermesso> e= (ArrayList<BeanGuiPermesso>) entry.getValue();
            for (BeanGuiPermesso bean : e) {
                r.addPermesso(conversionePermesso(bean));
            }
        }
        return r;
    }

    /**
     * Metodo che converte un Bean Ruolo in un Bean Gui Ruolo
     * @param b il Bean da convertire
     * @para r il Bean Grafico che deve essere modificato
     * @return il Bean Gui convertito
     */
    public static BeanGuiRuolo conversioneRuolo(Ruolo b, BeanGuiRuolo r) {
        r.setNome(new JTextField(b.getNome()));
        HashMap<String, ArrayList<BeanGuiPermesso>> lipi = new HashMap<String, ArrayList<BeanGuiPermesso>>();
        PermessoCollection p = b.getListPermesso();
        Iterator<Permesso> it=p.iterator();
        Permesso f=null;
        while (it.hasNext())
            f=it.next();
            if(lipi.containsKey(f.getName())){
                lipi.get(f.getName()).add(new BeanGuiPermesso(new JCheckBox(f.getActions()), f.getId(), f.getName()));
            }
          /*  else {
                lipi.put(key, value)
            }*/


            r.setListPermessi(lipi);



        return r;
      
    }

    private static Agenda conversioneAgenda(BeanGuiAgenda agenda) throws Exception {
        ArrayList<Evento> a = new ArrayList<Evento>();
        for(BeanGuiEvento b : agenda.getArrEventi()){
            Evento e= conversioneEvento(b);
            a.add(e);
        }
        Agenda agenda1 = new Agenda();
        agenda1.setIdAgenda(Integer.parseInt(agenda.getIdAgenda().getText()));
        agenda1.setUtente(conversioneUtente(agenda.getUtente()));
        agenda1.setListEventi(a);
        return agenda1;
    }

    public static Azienda conversioneAzienda(BeanGuiAzienda azienda) throws Exception {
        Azienda azienda1= new Azienda();
        azienda1.setCitta(azienda.getCitta().getText());
        azienda1.setEmail(azienda.getEmail().getText());
        azienda1.setFax(azienda.getFax().getText());
        azienda1.setIndirizzo(azienda.getInidirizzo().getText());
        azienda1.setNazione(azienda.getNazione().getText());
        azienda1.setPIVA(azienda.getPIVA().getText());
        azienda1.setRagioneSociale(azienda.getRagioneSociale().getText());
        azienda1.setTelefono(azienda.getTelefono().getText());
        azienda1.setIdAzienda(Integer.parseInt(azienda.getIdAzienda().getText()));
        azienda1.setNote(azienda.getNote().getText());
        azienda1.setAmministratore(conversioneAmministratore(azienda.getAmministratore()));
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

    private static ServizioAssociato conversioneAssociato(BeanGuiServizioAssociato c) throws Exception {
        ServizioAssociato sa = new ServizioAssociato();
        sa.seServizio(conversioneServizio(c.getServizio()));
        sa.setContratto(conversioneContratto(c.getContratto()));
        sa.setNote(c.getNote().getText());
        sa.setPrezzoUnitario(Double.parseDouble(c.getPrezzoUnitario().getText()));
        sa.setQuantita(Integer.parseInt(c.getQuantita().getText()));
        return sa;
    }

    public static BeanGuiAzienda conversioneAzienda(Azienda a, BeanGuiAzienda bga) {

        JTextField c = new JTextField();
        c.setText(a.getCitta().toString());
        bga.setCitta(c);
        c.setText(a.getEmail().toString());
        bga.setEmail(c);
        c.setText(a.getFax().toString());
        bga.setFax(c);
        c.setText(a.getIndirizzo().toString());
        bga.setInidirizzo(c);
        c.setText(a.getNazione().toString());
        bga.setNazione(c);
        c.setText(a.getNote());
        bga.setNote(c);
        c.setText(a.getPIVA());
        bga.setPIVA(c);
        c.setText(a.getRagioneSociale());
        bga.setRagioneSociale(c);
        c.setText(a.getTelefono().toString());
        bga.setTelefono(c);
        bga.setAmministratore(bga.getAmministratore());

        return bga;
    }

    
}