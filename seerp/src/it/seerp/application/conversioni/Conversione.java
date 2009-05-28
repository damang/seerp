package it.seerp.application.conversioni;

import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiAppuntamento;
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
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Ruolo;

import it.seerp.storage.ejb.Servizio;
import it.seerp.storage.ejb.Utente;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe che permette la conversione tra diversi tipi di Bean e Bean Gui
 * @author Tommaso Cattolico - Matteo D'Auria
 */
public class Conversione
{
    /**
     * Metodo che converte un Bean Gui Contratto in un normale Bean Contratto
     * @param pGui
     * Il Bean Gui Contratto da convertire
     * @return Il Bean Contratto convertito
     */
    public Contratto conversioneContratto(BeanGuiContratto pGui)
    {
        ArrayList<Pagamento> listPag= new ArrayList<Pagamento>();
        ArrayList<Servizio> listSer= new ArrayList<Servizio>();

        for(BeanGuiPagamento p : pGui.getListPagamento())
        {
            Pagamento p1 = conversionePagamento(p);
            listPag.add(p1);
        }

        for(BeanGuiServizio s : pGui.getListServizio())
        {
            Servizio s1 = conversioneServizio(s);
            listSer.add(s1);
        }

        String stato =  pGui.getStato().getText();
        Date data = Date.valueOf(pGui.getData().getText());
        int durata = Integer.parseInt(pGui.getDurata().getText());
        String tipo = pGui.getTipo().getText();
        int idContratto = Integer.parseInt(pGui.getIdContratto().getText());
        String note = pGui.getNote().getText();
        int dipendente = Integer.parseInt(pGui.getDipendente().getText());
        int extraAzienda = Integer.parseInt(pGui.getExtraAzienda().getText());

        Contratto contratto = new Contratto(stato, data, durata, tipo, idContratto, note, dipendente, extraAzienda, listPag, listSer);
        
        return contratto;
    }



    /**
     * Metodo che converte un Bean Contratto in un Bean Gui Contratto
     * @param c
     * Il Bean Contratto da convertire
     * @return Il Bean Gui Contratto convertito
     */
    public BeanGuiContratto conversioneContratto(Contratto c)
    {
        BeanGuiContratto gui = new BeanGuiContratto();
        ArrayList<BeanGuiPagamento> listPag= new ArrayList<BeanGuiPagamento>();
        ArrayList<BeanGuiServizio> listSer= new ArrayList<BeanGuiServizio>();

        for(Pagamento p : c.getListPagamento())
        {
            BeanGuiPagamento p1= conversionePagamento(p);
            listPag.add(p1);
        }

        for(Servizio s : c.getListServizio())
        {
            BeanGuiServizio s1 = conversioneServizio(s);
            listSer.add(s1);
        }

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
        field.setText(c.getDipendente().toString());
        gui.setDipendente(field);
        field.setText(c.getExtraAzienda().toString());
        gui.setExtraAzienda(field);
        gui.setListPagamento(listPag);
        gui.setListServizio(listSer);

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Evento in un normale Bean Evento
     * @param pGui
     * Il Bean Gui Evento da convertire
     * @return Il Bean Evento convertito
     */
    public Evento conversioneEvento(BeanGuiEvento pGui)
    {
        String luogo = pGui.getLuogo().getText();
        String tema = pGui.getTema().getText();
        String nome = pGui.getNome().getText();
        String note = pGui.getNote().getText();
        Date data = Date.valueOf(pGui.getData().getText());
        Time ora = Time.valueOf(pGui.getOra().getText());
        int idEvento = Integer.parseInt(pGui.getIdEvento().getText());
        int agenda = Integer.parseInt(pGui.getAgenda().getText());
        boolean notifica = Boolean.parseBoolean(pGui.getNotifica().getText());

        Evento evento = new Evento(luogo, tema, nome, note, data, ora, idEvento, agenda, notifica);

        return evento;
    }

    /**
     * Metodo che converte un Bean Evento  in un Bean Gui Evento
     * @param e
     * Il Bean Evento da convertire
     * @return Il Bean Gui Evento convertito
     */
    public BeanGuiEvento conversioneEvento(Evento e)
    {
        BeanGuiEvento gui = new BeanGuiEvento();
        
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
        field.setText(e.getAgenda().toString());
        gui.setAgenda(field);

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Servizio in un normale Bean Servizio
     * @param pGui
     * Il Bean Gui Servizio da convertire
     * @return Il Bean Servizio convertito
     */
    public Servizio conversioneServizio(BeanGuiServizio pGui)
    {
        ArrayList<Contratto> list= new ArrayList<Contratto>();

        for(BeanGuiContratto c : pGui.getListContratti())
        {
            Contratto c1 = conversioneContratto(c);
            list.add(c1);
        }
        
        String descrizione = pGui.getDescrizione().getText();
        boolean disponibilita = Boolean.parseBoolean(pGui.getDisponibilita().getText());
        int quantita = Integer.parseInt(pGui.getQuantita().getText());
        String tipo = pGui.getTipo().getText();
        double prezzo = Double.parseDouble(pGui.getPrezzo().getText());
        int idServizio = Integer.parseInt(pGui.getIdServizio().getText());
        int iva = Integer.parseInt(pGui.getIva().getText());
        String note = pGui.getNote().getText();
        
        Servizio servizio = new Servizio(descrizione, disponibilita, quantita, tipo, prezzo, idServizio, iva, note, list);

        return servizio;
    }

    /**
     * Metodo che converte un Bean Servizio in un Bean Gui Servizio
     * @param s
     * Il Bean Servizio da convertire
     * @return Il Bean Gui Servizio convertito
     */
    public BeanGuiServizio conversioneServizio(Servizio s)
    {
        BeanGuiServizio gui = new BeanGuiServizio();
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();

        ArrayList<BeanGuiContratto> list = new ArrayList<BeanGuiContratto>();

        for(Contratto c : s.getListContratti())
        {
            BeanGuiContratto c1 = conversioneContratto(c);
            list.add(c1);
        }

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
        gui.setListContratti(list);

        return gui;
    }

    /**
     * Metodo che converte un Bean Gui Pagamento in un normale Bean Pagamento
     * @param p
     * Il Bean Gui Pagamento da convertire
     * @return Il Bean Pagamento convertito
     */
    public Pagamento conversionePagamento(BeanGuiPagamento p)
    {
        String note = p.getNote().getText();
        Date dataScadenza = Date.valueOf(p.getDataScadenza().getText());
        String descrizione = p.getDescrizione().getText();
        double importo = Double.parseDouble(p.getImporto().getText());
        String modalitaPagamento = p.getModalitaPagamento().getText();
        String stato = p.getStato().getText();
        String altreInformazioni = p.getAltreInformazioni().getText();
        int idPagamento = Integer.parseInt(p.getIdPagamento().getText());
        int contratto = Integer.parseInt(p.getContratto().getText());
        int banca = Integer.parseInt(p.getBanca().getText());
        
        Pagamento pagamento = new Pagamento(note, dataScadenza, descrizione, importo, modalitaPagamento, stato, altreInformazioni, idPagamento, contratto, banca);

        return pagamento;
    }

    /**
     * Metodo che converte un Bean Pagamento in un Bean Gui Pagamento
     * @param p
     * Il Bean Pagamento da convertire
     * @return Il Bean Gui Pagamento convertito
     */
    public BeanGuiPagamento conversionePagamento(Pagamento p)
    {
        BeanGuiPagamento pagamento = new BeanGuiPagamento();
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();
        area.setText(p.getNote());
        pagamento.setNote(area);
        field.setText(p.getDataScadenza().toString());
        pagamento.setDataScadenza(field);
        field.setText(p.getDescrizione());
        pagamento.setDescrizione(field);
        field.setText(p.getImporto().toString());
        pagamento.setImporto(field);
        field.setText(p.getModalitaPagamento());
        pagamento.setModalitaPagamento(field);
        field.setText(p.getStato());
        pagamento.setStato(field);
        field.setText(p.getAltreInformazioni());
        pagamento.setAltreInformazioni(field);
        field.setText(p.getIdPagamento().toString());
        pagamento.setIdPagamento(field);
        field.setText(p.getContratto().toString());
        pagamento.setContratto(field);
        field.setText(p.getBanca().toString());
        pagamento.setBanca(field);
        return pagamento;
    }


    /**
     * Metodo che converte un Bean Gui Utente in un normale Bean Utente
     * @param bUtente
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Utente conversioneUtente(BeanGuiUtente bUtente)
    {
        Integer id =Integer.parseInt(bUtente.getIdUtenteTxt().getText());
        String username=bUtente.getTxtUsername().getText();
        String password=bUtente.getTxtPassword().getText();
        String città= bUtente.getTxtCittà().getText();
        String prov = bUtente.getTxtProvincia().getText();
        String telefono = bUtente.getTxtTelefono().getText();
        String email = bUtente.getTxtEmail().getText();
        String note = bUtente.getTxtNote().getText();
        String ruolo =bUtente.getRuolo().getText();
        Boolean notifica = Boolean.parseBoolean(bUtente.getTxtNotifica().getText()); 
        Utente utente = new Utente(id,username,password,città,prov,telefono,email,ruolo,note,notifica);
        return utente;
    }

    /**
     * Metodo che converte un Bean Utente in un Bean Gui Utente
     * @param user
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiUtente conversioneUtente(Utente user){
        BeanGuiUtente utente= new BeanGuiUtente();
        JTextField field = new JTextField();
        field.setText(user.getIdUtente().toString());
        utente.setIdUtenteText(field);
        field.setText(user.getPassword());
        utente.setTxtPassword(field);
        field.setText(user.getCittà());
        utente.setTxtCittà(field);
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
        field.setText(user.getRuolo());
        utente.setRuolo(field);
        return utente;
        }

    /**
     * Metodo che converte un Bean Gui Personale in un normale Bean Personale
     * @param bp
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Personale conversionePersonale(BeanGuiPersonale bp)
    {
        ArrayList<Permesso> a = new ArrayList<Permesso>();
        ArrayList<Ruolo> a1 = new ArrayList<Ruolo>();

        for( BeanGuiPermesso b : bp.getListPermessi() ){
            Permesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( BeanGuiRuolo b : bp.getListRuoli() ){
            Ruolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

         Integer id = Integer.parseInt(bp.getIdUtenteTxt().getText());
         String username= bp.getTxtUsername().getText();
         String password = bp.getTxtPassword().getText();
         String città = bp.getTxtCittà().getText();
         String prov=  bp.getTxtProvincia().getText();
         String telefono= bp.getTxtTelefono().getText();
         String email = bp.getTxtEmail().getText();
         String note= bp.getTxtNote().getText();
         Integer idp=Integer.parseInt(bp.getIdPersonale().getText());
         String cognome= bp.getCognome().getText();
         String nome=bp.getNome().getText();
         String codiceFiscale = bp.getCodiceFiscale().getText();
         String tipo= bp.getTipo().getToolTipText();
         String ruolo= bp.getRuolo().getText();
         Boolean notifica = Boolean.parseBoolean(bp.getTxtNotifica().getText());
        Personale p = new Personale(id,username,password,città,prov,telefono,email,note,ruolo,idp,cognome,nome,codiceFiscale,tipo, a,a1,notifica);
        return p;
    }

    /**
     * Metodo che converte un Bean Personale in un Bean Gui Personale
     * @param p
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiPersonale conversionePersonale(Personale p)
    {
        BeanGuiPersonale bp = new BeanGuiPersonale();

        ArrayList<BeanGuiPermesso> a = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiRuolo> a1 = new ArrayList<BeanGuiRuolo>();

        for( Permesso b : p.getListaPermessi() ){
            BeanGuiPermesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( Ruolo b : p.getListaRuoli() ){
            BeanGuiRuolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();
        c.setText(p.getIdUtente().toString());
        bp.setIdUtenteText(c);
        c.setText(p.getPassword());
        bp.setTxtPassword(c);
        c.setText(p.getCittà());
        bp.setTxtCittà(c);
        c.setText(p.getEmail());
        bp.setTxtEmail(c);
        c.setText(p.getProvincia());
        bp.setTxtProvincia(c);
        c.setText(p.getTelefono());
        bp.setTxtTelefono(c);
        c.setText(p.getNote().toString());
        bp.setTxtUsername(c);
        c.setText(p.getIdPersonale().toString());
        bp.setIdPersonale(c);
        c.setText(p.getCognome());
        bp.setCognome(c);
        c.setText(p.getNome());
        bp.setNome(c);
        c.setText(p.getCodiceFiscale());
        bp.setCodiceFiscale(c);
        d.setToolTipText(p.getTipo());
        bp.setTipo(d);
        bp.setListPermessi(a);
        bp.setListRuoli(a1);
        c.setText(p.getVisible().toString());
        bp.setTxtnotifica(c);
        c.setText(p.getRuolo());
        bp.setRuolo(c);
        return bp;
    }

    /**
     * Metodo che converte un Bean Gui ExtraAzienda in un normale Bean ExtraAzienda
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public ExtraAzienda conversioneExtraAzienda(BeanGuiExtraAzienda e){


        ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for( BeanGuiAppuntamento b : e.getListAppuntamenti() ){
            Appuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( BeanGuiContratto b : e.getListContratti() ){
            Contratto b1 = conversioneContratto(b);
            a1.add(b1);
           }
         
         Integer id = Integer.parseInt(e.getIdUtenteTxt().getText());
         String username= e.getTxtUsername().getText();
         String password = e.getTxtPassword().getText();
         String città = e.getTxtCittà().getText();
         String prov=  e.getTxtProvincia().getText();
         String telefono= e.getTxtTelefono().getText();
         String email = e.getTxtEmail().getText();
         String note= e.getTxtNote().getText();
         Integer ide = Integer.parseInt(e.getIdExtraAziendaTxt().getText());
         String cognome= e.getTxtCognome().getText();
         String nome=e.getTxtNome().getText();
         String ragSoc=e.getTxtRagioneSociale().getText();
         String pIva=e.getTxtPIva().getText();
         String fax=e.getTxtFax().getText();
         String ruolo= e.getCmbRuolo().getToolTipText();
         Boolean notifica= Boolean.parseBoolean(e.getTxtNotifica().getText());
         
         ExtraAzienda extra = new ExtraAzienda(id,username,password,città,prov,telefono,email,note,ide,cognome,nome,ragSoc,pIva,fax,ruolo,a,a1,notifica);
        return extra;
    }

    /**
     * Metodo che converte un Bean ExtraAzienda in un Bean Gui ExtraAzienda
     * @param e
     * il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiExtraAzienda conversazioneExtraAzienda(ExtraAzienda e){
        BeanGuiExtraAzienda extra = new BeanGuiExtraAzienda();

         ArrayList<BeanGuiAppuntamento> a = new ArrayList<BeanGuiAppuntamento>();
        ArrayList<BeanGuiContratto> a1 = new ArrayList<BeanGuiContratto>();

        for( Appuntamento b : e.getListAppuntamenti() ){
            BeanGuiAppuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( Contratto b : e.getListContratti() ){
            BeanGuiContratto b1 = conversioneContratto(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        extra.setIdUtenteText(c);
        c.setText(e.getPassword());
        extra.setTxtPassword(c);
        c.setText(e.getCittà());
        extra.setTxtCittà(c);
        c.setText(e.getEmail());
        extra.setTxtEmail(c);
        c.setText(e.getProvincia());
        extra.setTxtProvincia(c);
        c.setText(e.getTelefono());
        extra.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        extra.setTxtUsername(c);
        c.setText(e.getVisible().toString());
        extra.setTxtnotifica(c);
        c.setText(e.getIdExtraAzienda().toString());
        extra.setIdExtraAziendaTxt(c);
        c.setText(e.getCognome().toString());
        extra.setTxtCognome(c);
        c.setText(e.getNome().toString());
        extra.setTxtNome(c);
        c.setText(e.getRagioneSociale().toString());
        extra.setTxtRagioneSociale(c);
        c.setText(e.getPIva().toString());
        extra.setTxtPIva(c);
        c.setText(e.getFax().toString());
        extra.getTxtFax();
        JComboBox d = new JComboBox();
        d.setToolTipText(e.getRuolo());
        extra.setCmbRuolo(d);
        extra.setListAppuntamenti(a);
        extra.setListContratti(a1);
        return extra;
    }

    /**
     * Metodo che converte un Bean Gui Responsabile in un normale Bean Responsabile
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Responsabile conversioneResponsabile(BeanGuiResponsabile r){

        ArrayList<Permesso> a = new ArrayList<Permesso>();
        ArrayList<Ruolo> a1 = new ArrayList<Ruolo>();

        for( BeanGuiPermesso b : r.getListPermessi() ){
            Permesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( BeanGuiRuolo b : r.getListRuoli() ){
            Ruolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }
         
         Integer id = Integer.parseInt(r.getIdUtenteTxt().getText());
         String username= r.getTxtUsername().getText();
         String password = r.getTxtPassword().getText();
         String città = r.getTxtCittà().getText();
         String prov=  r.getTxtProvincia().getText();
         String telefono= r.getTxtTelefono().getText();
         String email = r.getTxtEmail().getText();
         String note= r.getTxtNote().getText();
         Integer idp=Integer.parseInt(r.getIdPersonale().getText());
         String cognome= r.getCognome().getText();
         String nome=r.getNome().getText();
         String codiceFiscale = r.getCodiceFiscale().getText();
         String tipo= r.getTipo().getToolTipText();
         Boolean notifica = Boolean.parseBoolean(r.getTxtNotifica().getText());
         Integer idr=Integer.parseInt(r.getIdResponsabileTxt().getText());
         String ruolo = r.getRuolo().getText();

        Responsabile  res = new Responsabile(id,username,password,città,prov,telefono,email,note,ruolo,idp,cognome,nome,codiceFiscale,tipo,a,a1,notifica,idr);
        return res;
    }

    /**
     * Metodo che converte un Bean Responsabile in un Bean Gui Responsabile
     * @param e
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiResponsabile conversioneResponsabile(Responsabile e){

        BeanGuiResponsabile br = new BeanGuiResponsabile();

        ArrayList<BeanGuiPermesso> a = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiRuolo> a1 = new ArrayList<BeanGuiRuolo>();

        for( Permesso b : e.getListaPermessi() ){
            BeanGuiPermesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( Ruolo b : e.getListaRuoli() ){
            BeanGuiRuolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();
        c.setText(e.getIdUtente().toString());
        br.setIdUtenteText(c);
        c.setText(e.getPassword());
        br.setTxtPassword(c);
        c.setText(e.getCittà());
        br.setTxtCittà(c);
        c.setText(e.getEmail());
        br.setTxtEmail(c);
        c.setText(e.getProvincia());
        br.setTxtProvincia(c);
        c.setText(e.getTelefono());
        br.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        br.setTxtUsername(c);
        c.setText(e.getIdPersonale().toString());
        br.setIdPersonale(c);
        c.setText(e.getCognome());
        br.setCognome(c);
        c.setText(e.getNome());
        br.setNome(c);
        c.setText(e.getCodiceFiscale());
        br.setCodiceFiscale(c);
        d.setToolTipText(e.getTipo());
        br.setTipo(d);
        br.setListPermessi(a);
        br.setListRuoli(a1);
        c.setText(e.getVisible().toString());
        br.setTxtnotifica(c);
        c.setText(e.getIdResponsabile().toString());
        br.setIdResponsabileTxt(c);
        return br;
    }

    /**
     * Metodo che converte un Bean Gui Dipendente in un normale Bean Dipendente
     * @param r
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Dipendente conversioneDipendente(BeanGuiDipendente r){

        ArrayList<Permesso> a = new ArrayList<Permesso>();
        ArrayList<Ruolo> a1 = new ArrayList<Ruolo>();

         ArrayList<Appuntamento> a2 = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a3 = new ArrayList<Contratto>();

        for( BeanGuiAppuntamento b : r.getListAppuntamenti() ){
            Appuntamento c = conversioneAppuntamento(b);
            a2.add(c);
           }

         for( BeanGuiContratto b : r.getListContratti() ){
            Contratto b1 = conversioneContratto(b);
            a3.add(b1);
           }

        for( BeanGuiPermesso b : r.getListPermessi() ){
            Permesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( BeanGuiRuolo b : r.getListRuoli() ){
            Ruolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }
         
         Integer id = Integer.parseInt(r.getIdUtenteTxt().getText());
         String username= r.getTxtUsername().getText();
         String password = r.getTxtPassword().getText();
         String città = r.getTxtCittà().getText();
         String prov=  r.getTxtProvincia().getText();
         String telefono= r.getTxtTelefono().getText();
         String email = r.getTxtEmail().getText();
         String note= r.getTxtNote().getText();
         Integer idp=Integer.parseInt(r.getIdPersonale().getText());
         String cognome= r.getCognome().getText();
         String nome=r.getNome().getText();
         String codiceFiscale = r.getCodiceFiscale().getText();
         String tipo= r.getTipo().getToolTipText();
         Boolean notifica = Boolean.parseBoolean(r.getTxtNotifica().getText());
         Integer idd=Integer.parseInt(r.getIdDipendenteTxt().getText());



        Dipendente  dip = new Dipendente(id,username,password,città,prov,telefono,email,note,idp,cognome,nome,codiceFiscale,tipo,a,a1,notifica,idd,a2,a3);
        return dip;
    }

     /**
      * Metodo che converte un Bean Responsabile in un Bean Gui Responsabile
      * @param e
      * Il Bean da convertire
      * @return il Bean Gui convertito
      */
     public BeanGuiDipendente conversioneResponsabile(Dipendente e){

        BeanGuiDipendente br = new BeanGuiDipendente();

        ArrayList<BeanGuiPermesso> a = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiRuolo> a1 = new ArrayList<BeanGuiRuolo>();


         ArrayList<BeanGuiAppuntamento> a2 = new ArrayList<BeanGuiAppuntamento>();
        ArrayList<BeanGuiContratto> a3 = new ArrayList<BeanGuiContratto>();

        for( Appuntamento b : e.getListAppuntamenti() ){
            BeanGuiAppuntamento b1 = conversioneAppuntamento(b);
            a2.add(b1);
           }

         for( Contratto b : e.getListContratti() ){
            BeanGuiContratto b1 = conversioneContratto(b);
            a3.add(b1);
           }



        for( Permesso b : e.getListaPermessi() ){
            BeanGuiPermesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( Ruolo b : e.getListaRuoli() ){
            BeanGuiRuolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();
        c.setText(e.getIdUtente().toString());
        br.setIdUtenteText(c);
        c.setText(e.getPassword());
        br.setTxtPassword(c);
        c.setText(e.getCittà());
        br.setTxtCittà(c);
        c.setText(e.getEmail());
        br.setTxtEmail(c);
        c.setText(e.getProvincia());
        br.setTxtProvincia(c);
        c.setText(e.getTelefono());
        br.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        br.setTxtUsername(c);
        c.setText(e.getIdPersonale().toString());
        br.setIdPersonale(c);
        c.setText(e.getCognome());
        br.setCognome(c);
        c.setText(e.getNome());
        br.setNome(c);
        c.setText(e.getCodiceFiscale());
        br.setCodiceFiscale(c);
        d.setToolTipText(e.getTipo());
        br.setTipo(d);
        br.setListPermessi(a);
        br.setListRuoli(a1);
        c.setText(e.getVisible().toString());
        br.setTxtnotifica(c);
        c.setText(e.getIdDipendente().toString());
        br.setIdDipendenteTxt(c);
        br.setListAppuntamenti(a2);
        br.setListContratti(a3);
        return br;
    }

      /**
      * Metodo che converte un Bean Amministratore in un Bean Gui Amministratore
      * @param e
      * Il Bean da convertire
      * @return il Bean Gui convertito
      */

     public BeanGuiAmministratore conversioneAmministratore(Amministratore e){

        BeanGuiAmministratore br = new BeanGuiAmministratore();

         ArrayList<BeanGuiPermesso> a = new ArrayList<BeanGuiPermesso>();
        ArrayList<BeanGuiRuolo> a1 = new ArrayList<BeanGuiRuolo>();

        for( Permesso b : e.getListaPermessi() ){
            BeanGuiPermesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( Ruolo b : e.getListaRuoli() ){
            BeanGuiRuolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();
        c.setText(e.getIdAmministratore().toString());
        br.setIdAmministratoreTxt(c);
        c.setText(e.getIdUtente().toString());
        br.setIdUtenteText(c);
        c.setText(e.getPassword());
        br.setTxtPassword(c);
        c.setText(e.getCittà());
        br.setTxtCittà(c);
        c.setText(e.getEmail());
        br.setTxtEmail(c);
        c.setText(e.getProvincia());
        br.setTxtProvincia(c);
        c.setText(e.getTelefono());
        br.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        br.setTxtUsername(c);
        c.setText(e.getIdPersonale().toString());
        br.setIdPersonale(c);
        c.setText(e.getCognome());
        br.setCognome(c);
        c.setText(e.getNome());
        br.setNome(c);
        c.setText(e.getCodiceFiscale());
        br.setCodiceFiscale(c);
        d.setToolTipText(e.getTipo());
        br.setTipo(d);
        br.setListPermessi(a);
        br.setListRuoli(a1);
        c.setText(e.getVisible().toString());
        br.setTxtnotifica(c);
       
        return br;
    }

      /**
      * Metodo che converte un Bean Gui Responsabile in un normale Bean Responsabile
      * @param e
      * Il Bean Gui da convertire
      * @return il Bean convertito
      */

    public Amministratore conversioneAmministratore(BeanGuiAmministratore r){

        ArrayList<Permesso> a = new ArrayList<Permesso>();
        ArrayList<Ruolo> a1 = new ArrayList<Ruolo>();

        for( BeanGuiPermesso b : r.getListPermessi() ){
            Permesso b1 = conversionePermesso(b);
            a.add(b1);
           }

         for( BeanGuiRuolo b : r.getListRuoli() ){
            Ruolo b1 = conversioneRuolo(b);
            a1.add(b1);
           }

         Integer id = Integer.parseInt(r.getIdUtenteTxt().getText());
         String username= r.getTxtUsername().getText();
         String password = r.getTxtPassword().getText();
         String città = r.getTxtCittà().getText();
         String prov=  r.getTxtProvincia().getText();
         String telefono= r.getTxtTelefono().getText();
         String email = r.getTxtEmail().getText();
         String note= r.getTxtNote().getText();
         Integer idp=Integer.parseInt(r.getIdPersonale().getText());
         String cognome= r.getCognome().getText();
         String nome=r.getNome().getText();
         String codiceFiscale = r.getCodiceFiscale().getText();
         String tipo= r.getTipo().getToolTipText();
         Boolean notifica = Boolean.parseBoolean(r.getTxtNotifica().getText());
         Integer ida= Integer.parseInt(r.getIdAmministratoreTxt().getText());
        Amministratore amm= new Amministratore(id,username,password,città,prov,telefono,email,note,tipo,idp,cognome,nome,codiceFiscale,tipo,a,a1,notifica,ida);
        return amm;
    }
     

     /**
      * Metodo che converte un Bean Gui Contatto in un normale Bean Contatto
      * @param e
      * Il Bean Gui da convertire
      * @return il Bean convertito
      */
     public Contatto conversioneContatto(BeanGuiContatto e){

        ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for( BeanGuiAppuntamento b : e.getListAppuntamenti() ){
            Appuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( BeanGuiContratto b : e.getListContratti() ){
            Contratto b1 = conversioneContratto(b);
            a1.add(b1);
           }

         Integer id = Integer.parseInt(e.getIdUtenteTxt().getText());
         String username= e.getTxtUsername().getText();
         String password = e.getTxtPassword().getText();
         String città = e.getTxtCittà().getText();
         String prov=  e.getTxtProvincia().getText();
         String telefono= e.getTxtTelefono().getText();
         String email = e.getTxtEmail().getText();
         String note= e.getTxtNote().getText();
         Integer ide = Integer.parseInt(e.getIdExtraAziendaTxt().getText());
         String cognome= e.getTxtCognome().getText();
         String nome=e.getTxtNome().getText();
         String ragSoc=e.getTxtRagioneSociale().getText();
         String pIva=e.getTxtPIva().getText();
         String fax=e.getTxtFax().getText();
         String ruolo= e.getCmbRuolo().getToolTipText();
         Boolean notifica= Boolean.parseBoolean(e.getTxtNotifica().getText());
         Integer idc=Integer.parseInt(e.getIdContattoTxt().getText());
         Integer feedback=Integer.parseInt(e.getTxtFeedback().getText());


        Contatto cont = new Contatto (id,username,password,città,prov,telefono,email,note,ide,cognome,nome,ragSoc,pIva,fax,ruolo,a,a1,notifica,idc,feedback);
        return cont;
    }

     /**
      * Metodo che converte un Bean Contatto in un Bean Gui Contatto
      * @param e
      * Il Bean da convertire
      * @return il Bean Gui convertito
      */
     public BeanGuiContatto conversioneContatto(Contatto e){
        BeanGuiContatto cont = new BeanGuiContatto();

         ArrayList<BeanGuiAppuntamento> a = new ArrayList<BeanGuiAppuntamento>();
        ArrayList<BeanGuiContratto> a1 = new ArrayList<BeanGuiContratto>();

        for( Appuntamento b : e.getListAppuntamenti() ){
            BeanGuiAppuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( Contratto b : e.getListContratti() ){
            BeanGuiContratto b1 = conversioneContratto(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        c.setText(e.getIdUtente().toString());
        cont.setIdUtenteText(c);
        c.setText(e.getPassword());
        cont.setTxtPassword(c);
        c.setText(e.getCittà());
        cont.setTxtCittà(c);
        c.setText(e.getEmail());
        cont.setTxtEmail(c);
        c.setText(e.getProvincia());
        cont.setTxtProvincia(c);
        c.setText(e.getTelefono());
        cont.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        cont.setTxtUsername(c);
        c.setText(e.getVisible().toString());
        cont.setTxtnotifica(c);
        c.setText(e.getIdExtraAzienda().toString());
        cont.setIdExtraAziendaTxt(c);
        c.setText(e.getCognome().toString());
        cont.setTxtCognome(c);
        c.setText(e.getNome().toString());
        cont.setTxtNome(c);
        c.setText(e.getRagioneSociale().toString());
        cont.setTxtRagioneSociale(c);
        c.setText(e.getPIva().toString());
        cont.setTxtPIva(c);
        c.setText(e.getFax().toString());
        cont.getTxtFax();
        JComboBox d = new JComboBox();
        d.setToolTipText(e.getRuolo());
        cont.setCmbRuolo(d);
        cont.setListAppuntamenti(a);
        cont.setListContratti(a1);
        c.setText(e.getIdContatto().toString());
        cont.setIdContattoTxt(c);
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
    public Cliente conversioneCliente(BeanGuiCliente e)
    {
        ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for( BeanGuiAppuntamento b : e.getListAppuntamenti() )
        {
            Appuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( BeanGuiContratto b : e.getListContratti() )
         {
            Contratto b1 = conversioneContratto(b);
            a1.add(b1);
           }


         Integer id = Integer.parseInt(e.getIdUtenteTxt().getText());
         String username= e.getTxtUsername().getText();
         String password = e.getTxtPassword().getText();
         String città = e.getTxtCittà().getText();
         String prov=  e.getTxtProvincia().getText();
         String telefono= e.getTxtTelefono().getText();
         String email = e.getTxtEmail().getText();
         String note= e.getTxtNote().getText();
         Integer ide = Integer.parseInt(e.getIdExtraAziendaTxt().getText());
         String cognome= e.getTxtCognome().getText();
         String nome=e.getTxtNome().getText();
         String ragSoc=e.getTxtRagioneSociale().getText();
         String pIva=e.getTxtPIva().getText();
         String fax=e.getTxtFax().getText();
         String ruolo= e.getCmbRuolo().getToolTipText();
         Boolean notifica= Boolean.parseBoolean(e.getTxtNotifica().getText());
         Integer idc=Integer.parseInt(e.getIdClienteTxt().getText());

         Cliente cl= new Cliente(id,username,password,città,prov,telefono,email,note,ide,cognome,nome,ragSoc,pIva,fax,ruolo,a,a1,idc,notifica);

        return cl;
    }

    /**
     * Metodo che converte un Bean Cliente in un Bean Gui Cliente
     * @param e
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiCliente conversioneCliente(Cliente e)
    {
        BeanGuiCliente cl = new BeanGuiCliente();

        ArrayList<BeanGuiAppuntamento> a = new ArrayList<BeanGuiAppuntamento>();
        ArrayList<BeanGuiContratto> a1 = new ArrayList<BeanGuiContratto>();

        for( Appuntamento b : e.getListAppuntamenti() )
        {
            BeanGuiAppuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
        }

        for( Contratto b : e.getListContratti() )
        {
            BeanGuiContratto b1 = conversioneContratto(b);
            a1.add(b1);
        }

        JTextField c = new JTextField();
        JComboBox d = new JComboBox();

        c.setText(e.getIdUtente().toString());
        cl.setIdUtenteText(c);
        c.setText(e.getPassword());
        cl.setTxtPassword(c);
        c.setText(e.getCittà());
        cl.setTxtCittà(c);
        c.setText(e.getEmail());
        cl.setTxtEmail(c);
        c.setText(e.getProvincia());
        cl.setTxtProvincia(c);
        c.setText(e.getTelefono());
        cl.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        cl.setTxtUsername(c);
        c.setText(e.getVisible().toString());
        cl.setTxtnotifica(c);
        c.setText(e.getIdExtraAzienda().toString());
        cl.setIdExtraAziendaTxt(c);
        c.setText(e.getCognome().toString());
        cl.setTxtCognome(c);
        c.setText(e.getNome().toString());
        cl.setTxtNome(c);
        c.setText(e.getRagioneSociale().toString());
        cl.setTxtRagioneSociale(c);
        c.setText(e.getPIva().toString());
        cl.setTxtPIva(c);
        c.setText(e.getFax().toString());
        cl.getTxtFax();
        d.setToolTipText(e.getRuolo());
        cl.setCmbRuolo(d);
        cl.setListAppuntamenti(a);
        cl.setListContratti(a1);
        c.setText(e.getIdCliente().toString());
        cl.setIdClienteTxt(c);
        
        return cl;
    }

    /**
     * Metodo che converte un Bean Gui Fornitore in un normale Bean Fornitore
     * @param e
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Fornitore conversioneFornitore(BeanGuiFornitore e)
    {
        ArrayList<Appuntamento> a = new ArrayList<Appuntamento>();
        ArrayList<Contratto> a1 = new ArrayList<Contratto>();

        for( BeanGuiAppuntamento b : e.getListAppuntamenti() )
        {
            Appuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
        }

        for( BeanGuiContratto b : e.getListContratti() )
        {
            Contratto b1 = conversioneContratto(b);
            a1.add(b1);
        }

         Integer id = Integer.parseInt(e.getIdUtenteTxt().getText());
         String username= e.getTxtUsername().getText();
         String password = e.getTxtPassword().getText();
         String città = e.getTxtCittà().getText();
         String prov=  e.getTxtProvincia().getText();
         String telefono= e.getTxtTelefono().getText();
         String email = e.getTxtEmail().getText();
         String note= e.getTxtNote().getText();
         Integer ide = Integer.parseInt(e.getIdExtraAziendaTxt().getText());
         String cognome= e.getTxtCognome().getText();
         String nome=e.getTxtNome().getText();
         String ragSoc=e.getTxtRagioneSociale().getText();
         String pIva=e.getTxtPIva().getText();
         String fax=e.getTxtFax().getText();
         String ruolo= e.getCmbRuolo().getToolTipText();
         Boolean notifica= Boolean.parseBoolean(e.getTxtNotifica().getText());
         Integer idf=Integer.parseInt(e.getIdFornitoreTxt().getText());

         
        Fornitore cl= new Fornitore(id,username,password,città,prov,telefono,email,note,ide,cognome,nome,ragSoc,pIva,fax,ruolo,a,a1,idf,notifica);
 
        return cl;
    }


    /**
     * Metodo che converte un Bean Fornitore in un Bean Gui Fornitore
     * @param e
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiFornitore conversioneFornitore(Fornitore e)
    {
        BeanGuiFornitore fo = new BeanGuiFornitore();

        ArrayList<BeanGuiAppuntamento> a = new ArrayList<BeanGuiAppuntamento>();
        ArrayList<BeanGuiContratto> a1 = new ArrayList<BeanGuiContratto>();

        for( Appuntamento b : e.getListAppuntamenti() )
        {
            BeanGuiAppuntamento b1 = conversioneAppuntamento(b);
            a.add(b1);
           }

         for( Contratto b : e.getListContratti() )
         {
            BeanGuiContratto b1 = conversioneContratto(b);
            a1.add(b1);
           }

        JTextField c = new JTextField();
        
        c.setText(e.getIdUtente().toString());
        fo.setIdUtenteText(c);
        c.setText(e.getPassword());
        fo.setTxtPassword(c);
        c.setText(e.getCittà());
        fo.setTxtCittà(c);
        c.setText(e.getEmail());
        fo.setTxtEmail(c);
        c.setText(e.getProvincia());
        fo.setTxtProvincia(c);
        c.setText(e.getTelefono());
        fo.setTxtTelefono(c);
        c.setText(e.getNote().toString());
        fo.setTxtUsername(c);
        c.setText(e.getVisible().toString());
        fo.setTxtnotifica(c);
        c.setText(e.getIdExtraAzienda().toString());
        fo.setIdExtraAziendaTxt(c);
        c.setText(e.getCognome().toString());
        fo.setTxtCognome(c);
        c.setText(e.getNome().toString());
        fo.setTxtNome(c);
        c.setText(e.getRagioneSociale().toString());
        fo.setTxtRagioneSociale(c);
        c.setText(e.getPIva().toString());
        fo.setTxtPIva(c);
        c.setText(e.getFax().toString());
        fo.getTxtFax();
        JComboBox d = new JComboBox();
        d.setToolTipText(e.getRuolo());
        fo.setCmbRuolo(d);
        fo.setListAppuntamenti(a);
        fo.setListContratti(a1);
        c.setText(e.getIdFornitore().toString());
        fo.setIdFornitoreTxt(c);
        
        return fo;
    }

    /**
     * Metodo che converte un Bean Appuntamento in un Bean Gui Appuntamento
     * @param b
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiAppuntamento conversioneAppuntamento(Appuntamento b) 
    {
        BeanGuiAppuntamento app = new BeanGuiAppuntamento();

        JTextField c = new JTextField();
        c.setText(b.getData().toString());
        app.setData(c);
        c.setText(b.getDipendente().toString());
        app.setDipendente(c);
        c.setText(b.getExtraAzienda().toString());
        app.setExtraAzienda(c);
        c.setText(b.getIdAppuntamento().toString());
        app.setIdAppuntamento(c);
        c.setText(b.getNotifica().toString());
        app.setNotifica(c);
        c.setText(b.getOra().toString());
        app.setOra(c);
        JTextArea d = new JTextArea();
        d.setText(b.getNote());
        app.setNote(d);

        return app;
    }

    /**
     * Metodo che converte un Bean Gui Appuntamento in un normale Bean Appuntamento
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Appuntamento conversioneAppuntamento(BeanGuiAppuntamento b)
    {
        Date a = new Date(Long.parseLong(b.getData().getText()));
        Time c = new Time(Long.parseLong(b.getOra().getText()));
        Integer id = Integer.parseInt(b.getIdAppuntamento().getText());
        Integer idd = Integer.parseInt(b.getDipendente().getText());
        Integer ide = Integer.parseInt(b.getExtraAzienda().getText());
        Boolean notifica = Boolean.parseBoolean(b.getNotifica().getText());
        String note = b.getNote().getText();

        Appuntamento app = new Appuntamento(a,c,id,note,idd,ide, notifica);

        return app;
    }

    /**
     * Metodo che converte un Bean Gui Permesso in un normale Bean Permesso
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Permesso conversionePermesso(BeanGuiPermesso b)
    {
        ArrayList<Personale> a = new ArrayList<Personale>();
        ArrayList<Ruolo> c = new ArrayList<Ruolo>();

        for(BeanGuiPersonale d: b.getListPersonale()){
            Personale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(BeanGuiRuolo d:b.getListRuolo()){
            Ruolo d1= conversioneRuolo(d);
            c.add(d1);
        }

        Integer id =  Integer.parseInt(b.getIdPermesso().getText());
        String nome = b.getNome().getText();


        Permesso p= new Permesso (id,nome,a,c);

        return p;
    }

    /**
     * Metodo che converte un Bean Permesso in un Bean Gui Permesso
     * @param b
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiPermesso conversionePermesso(Permesso b)
    {
        ArrayList<BeanGuiPersonale> a = new ArrayList<BeanGuiPersonale>();
        ArrayList<BeanGuiRuolo> c = new ArrayList<BeanGuiRuolo>();

        for(Personale d: b.getListPersonale())
        {
            BeanGuiPersonale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(Ruolo d : b.getListPermessi())
        {
            BeanGuiRuolo d1= conversioneRuolo(d);
            c.add(d1);
        }

        BeanGuiPermesso p = new BeanGuiPermesso();

        JTextField d = new JTextField();

        d.setText(b.getIdPermesso().toString());
        p.setIdPermesso(d);
        d.setText(b.getNome());
        p.setNome(d);
        p.setListPersonale(a);
        p.setListRuolo(c);

        return p;

    }

    /**
     * Metodo che converte un Bean Gui Ruolo in un normale Bean Ruolo
     * @param b
     * Il Bean Gui da convertire
     * @return il Bean convertito
     */
    public Ruolo conversioneRuolo(BeanGuiRuolo b) 
    {
        ArrayList<Personale> a = new ArrayList<Personale>();
        ArrayList<Permesso> c = new ArrayList<Permesso>();

        for(BeanGuiPersonale d: b.getListPersonale())
        {
            Personale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(BeanGuiPermesso d:b.getListPermessi())
        {
            Permesso d1= conversionePermesso(d);
            c.add(d1);
        }

        Integer id = Integer.parseInt(b.getIdRuolo().getText());
        String nome=b.getNome().getText();

        Ruolo r= new Ruolo (id,nome,a,c);

        return r;
    }

    /**
     * Metodo che converte un Bean Ruolo in un Bean Gui Ruolo
     * @param b
     * Il Bean da convertire
     * @return il Bean Gui convertito
     */
    public BeanGuiRuolo conversioneRuolo(Ruolo b)
    {
        ArrayList<BeanGuiPersonale> a = new ArrayList<BeanGuiPersonale>();
        ArrayList<BeanGuiPermesso> c = new ArrayList<BeanGuiPermesso>();

        for(Personale d: b.getListPersonale())
        {
            BeanGuiPersonale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(Permesso d : b.getListPermessi())
        {
            BeanGuiPermesso d1= conversionePermesso(d);
            c.add(d1);
        }

        BeanGuiRuolo p = new BeanGuiRuolo();

        JTextField d = new JTextField();

        d.setText(b.getIdRuolo().toString());
        p.setIdRuolo(d);
        d.setText(b.getNome());
        p.setNome(d);
        p.setListPersonale(a);
        p.setListPermessi(c);
        return p;
    }

    
}