package it.seerp.application.conversioni;
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
 *
 * @author Tommaso Cattolico - Matteo D'Auria
 */
public class Conversione
{

    public Conversione() {}


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

        Contratto contratto = new Contratto(pGui.getStato().getText(), Date.valueOf(pGui.getData().getText()),
                Integer.parseInt(pGui.getDurata().getText()), pGui.getTipo().getText(),
                Integer.parseInt(pGui.getIdContratto().getText()), pGui.getNote().getText(),
                Integer.parseInt(pGui.getDipendente().getText()), Integer.parseInt(pGui.getExtraAzienda().getText()), 
                listPag, listSer);
        
        return contratto;
    }



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

    public Evento conversioneEvento(BeanGuiEvento pGui)
    {
        Evento evento = new Evento(pGui.getLuogo().getText(), pGui.getTema().getText(), pGui.getNome().getText(), 
                pGui.getNote().getText(), Date.valueOf(pGui.getData().getText()), Time.valueOf(pGui.getOra().getText()),
                Integer.parseInt(pGui.getIdEvento().getText()), Integer.parseInt(pGui.getAgenda().getText()),
                Boolean.parseBoolean(pGui.getNotifica().getText()));

        return evento;
    }

    public BeanGuiEvento conversioneEvento(Evento e)
    {
        BeanGuiEvento gui = new BeanGuiEvento();
        JTextField a = new JTextField();
        JTextArea b = new JTextArea();

        a.setText(e.getLuogo());
        gui.setLuogo(a);
        a.setText(e.getTema());
        gui.setTema(a);
        a.setText(e.getNome());
        gui.setNome(a);
        a.setText(e.getNote());
        gui.setNote(b);
        a.setText(e.getData().toString());
        gui.setData(a);
        a.setText(e.getOra().toString());
        gui.setOra(a);
        a.setText(Integer.toString(e.getIdEvento()));
        gui.setIdEvento(a);
        a.setText(e.getAgenda().toString());
        gui.setAgenda(a);

        return gui;
    }

    public Servizio conversioneServizio(BeanGuiServizio pGui)
    {
        ArrayList<Contratto> list= new ArrayList<Contratto>();

        for(BeanGuiContratto c : pGui.getListContratti())
        {
            Contratto c1 = conversioneContratto(c);
            list.add(c1);
        }

        Servizio servizio = new Servizio(pGui.getDescrizione().getText(), Boolean.parseBoolean(pGui.getDisponibilita().getText()),
                Integer.parseInt(pGui.getQuantita().getText()), pGui.getNote().getText(),
                Double.parseDouble(pGui.getPrezzo().getText()), Integer.parseInt(pGui.getIdServizio().getText()),
                Integer.parseInt(pGui.getIva().getText()), pGui.getNote().getText(), list);

        return servizio;
    }

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

    public Pagamento conversionePagamento(BeanGuiPagamento p)
    {
        Pagamento pagamento = new Pagamento(p.getNote().getText(), Date.valueOf(p.getDataScadenza().getText()),
                p.getDescrizione().getText(), Double.parseDouble(p.getImporto().getText()), p.getModalitaPagamento().getText(),
                p.getStato().getText(), p.getAltreInformazioni().getText(), Integer.parseInt(p.getIdPagamento().getText()),
                Integer.parseInt(p.getContratto().getText()), Integer.parseInt(p.getBanca().getText()));

        return pagamento;
    }

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


    public Utente conversioneUtente(BeanGuiUtente bUtente)
    {
        Utente utente = new Utente(Integer.parseInt(bUtente.getIdUtenteTxt().getText()),bUtente.getTxtUsername().getText(),bUtente.getTxtPassword().getText(),
                bUtente.getTxtCittà().getText(),bUtente.getTxtProvincia().getText(),bUtente.getTxtTelefono().getText(),
                bUtente.getTxtEmail().getText(),bUtente.getTxtNote().getText(),Boolean.parseBoolean(bUtente.getTxtNotifica().getText()));

        return utente;
    }

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
        return utente;
        }

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

        Personale p = new Personale(Integer.parseInt(bp.getIdUtenteTxt().getText()),bp.getTxtUsername().getText(),bp.getTxtPassword().getText(),
                bp.getTxtCittà().getText(),bp.getTxtProvincia().getText(),bp.getTxtTelefono().getText(),
                bp.getTxtEmail().getText(),bp.getTxtNote().getText(),Integer.parseInt(bp.getIdPersonale().getText()),bp.getCognome().getText(),bp.getNome().getText(),
                bp.getCodiceFiscale().getText(),bp.getTipo().getToolTipText(),a,a1,Boolean.parseBoolean(bp.getTxtNotifica().getText()));
        return p;
    }

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
        return bp;
    }

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


        ExtraAzienda extra = new ExtraAzienda(Integer.parseInt(e.getIdUtenteTxt().getText()),e.getTxtUsername().getText(),e.getTxtPassword().getText(),
                e.getTxtCittà().getText(),e.getTxtProvincia().getText(),e.getTxtTelefono().getText(),
                e.getTxtEmail().getText(),e.getTxtNote().getText(),Integer.parseInt(e.getIdExtraAziendaTxt().getText()),e.getTxtCognome().getText(),
                e.getTxtNome().getText(),e.getTxtRagioneSociale().getText(),e.getTxtPIva().getText(),e.getTxtFax().getText(),
                e.getCmbRuolo().getToolTipText(),a,a1,Boolean.parseBoolean(e.getTxtNotifica().getText()));
        return extra;
    }

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

        Responsabile  res = new Responsabile(Integer.parseInt(r.getIdUtenteTxt().getText()),r.getTxtUsername().getText(),r.getTxtPassword().getText(),r.getTxtCittà().getText(),r.getTxtProvincia().getText(),r.getTxtTelefono().getText(),
                r.getTxtEmail().getText(),r.getTxtNote().getText(),Integer.parseInt(r.getIdPersonale().getText()),r.getCognome().getText(),r.getNome().getText(),
                r.getCodiceFiscale().getText(),r.getTipo().getToolTipText(),a,a1,Boolean.parseBoolean(r.getTxtNotifica().getText()),Integer.parseInt(r.getIdResponsabileTxt().getText()));
        return res;
    }

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

        Dipendente  dip = new Dipendente(Integer.parseInt(r.getIdUtenteTxt().getText()),r.getTxtUsername().getText(),r.getTxtPassword().getText(),r.getTxtCittà().getText(),r.getTxtProvincia().getText(),r.getTxtTelefono().getText(),
                r.getTxtEmail().getText(),r.getTxtNote().getText(),Integer.parseInt(r.getIdPersonale().getText()),r.getCognome().getText(),r.getNome().getText(),
                r.getCodiceFiscale().getText(),r.getTipo().getToolTipText(),a,a1,Boolean.parseBoolean(r.getTxtNotifica().getText()),Integer.parseInt(r.getIdDipendenteTxt().getText()),a2,a3);
        return dip;
    }

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


        Contatto cont = new Contatto (Integer.parseInt(e.getIdUtenteTxt().getText()),e.getTxtUsername().getText(),e.getTxtPassword().getText(),
                e.getTxtCittà().getText(),e.getTxtProvincia().getText(),e.getTxtTelefono().getText(),
                e.getTxtEmail().getText(),e.getTxtNote().getText(),Integer.parseInt(e.getIdExtraAziendaTxt().getText()),e.getTxtCognome().getText(),
                e.getTxtNome().getText(),e.getTxtRagioneSociale().getText(),e.getTxtPIva().getText(),e.getTxtFax().getText(),
                e.getCmbRuolo().getToolTipText(),a,a1,Boolean.parseBoolean(e.getTxtNotifica().getText()),Integer.parseInt(e.getIdContattoTxt().getText()),Integer.parseInt(e.getTxtFeedback().getText()));
        return cont;
    }

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

    public Cliente conversioneCliente(BeanGuiCliente e){

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
        Cliente cl= new Cliente(Integer.parseInt(e.getIdUtenteTxt().getText()),e.getTxtUsername().getText(),e.getTxtPassword().getText(),
                e.getTxtCittà().getText(),e.getTxtProvincia().getText(),e.getTxtTelefono().getText(),
                e.getTxtEmail().getText(),e.getTxtNote().getText(),Integer.parseInt(e.getIdExtraAziendaTxt().getText()),e.getTxtCognome().getText(),
                e.getTxtNome().getText(),e.getTxtRagioneSociale().getText(),e.getTxtPIva().getText(),e.getTxtFax().getText(),
                e.getCmbRuolo().getToolTipText(),a,a1,Integer.parseInt(e.getIdClienteTxt().getText()),Boolean.parseBoolean(e.getTxtNotifica().getText()));
        return cl;
    }

    public BeanGuiCliente conversioneCliente(Cliente e){

         BeanGuiCliente cl = new BeanGuiCliente();

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
        JComboBox d = new JComboBox();
        d.setToolTipText(e.getRuolo());
        cl.setCmbRuolo(d);
        cl.setListAppuntamenti(a);
        cl.setListContratti(a1);
        c.setText(e.getIdCliente().toString());
        cl.setIdClienteTxt(c);
        return cl;

    }

    public Fornitore conversioneFornitore(BeanGuiFornitore e){


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
        Fornitore cl= new Fornitore(Integer.parseInt(e.getIdUtenteTxt().getText()),e.getTxtUsername().getText(),e.getTxtPassword().getText(),
                e.getTxtCittà().getText(),e.getTxtProvincia().getText(),e.getTxtTelefono().getText(),
                e.getTxtEmail().getText(),e.getTxtNote().getText(),Integer.parseInt(e.getIdExtraAziendaTxt().getText()),e.getTxtCognome().getText(),
                e.getTxtNome().getText(),e.getTxtRagioneSociale().getText(),e.getTxtPIva().getText(),e.getTxtFax().getText(),
                e.getCmbRuolo().getToolTipText(),a,a1,Integer.parseInt(e.getIdFornitoreTxt().getText()),Boolean.parseBoolean(e.getTxtNotifica().getText()));
        return cl;

    }


    public BeanGuiFornitore conversioneFornitore(Fornitore e){
        BeanGuiFornitore fo = new BeanGuiFornitore();

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

    public BeanGuiAppuntamento conversioneAppuntamento(Appuntamento b) {

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

    public Appuntamento conversioneAppuntamento(BeanGuiAppuntamento b) {

        Date a = new Date(Long.parseLong(b.getData().getText()));
        Time c = new Time(Long.parseLong(b.getOra().getText()));

        Appuntamento app = new Appuntamento(a,c,Integer.parseInt(b.getIdAppuntamento().getText()),b.getNote().getText(),Integer.parseInt(b.getDipendente().getText()),
                Integer.parseInt(b.getExtraAzienda().getText()),Boolean.parseBoolean(b.getNotifica().getText()));
        return app;
    }

    public Permesso conversionePermesso(BeanGuiPermesso b) {

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

        Permesso p= new Permesso (Integer.parseInt(b.getIdPermesso().getText()),b.getNome().getText(),a,c);

        return p;

    }

    public BeanGuiPermesso conversionePermesso(Permesso b) {

        ArrayList<BeanGuiPersonale> a = new ArrayList<BeanGuiPersonale>();
        ArrayList<BeanGuiRuolo> c = new ArrayList<BeanGuiRuolo>();

        for(Personale d: b.getListPersonale()){
            BeanGuiPersonale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(Ruolo d : b.getListPermessi()){
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

    public Ruolo conversioneRuolo(BeanGuiRuolo b) {


        ArrayList<Personale> a = new ArrayList<Personale>();
        ArrayList<Permesso> c = new ArrayList<Permesso>();

        for(BeanGuiPersonale d: b.getListPersonale()){
            Personale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(BeanGuiPermesso d:b.getListPermessi()){
            Permesso d1= conversionePermesso(d);
            c.add(d1);
        }

        Ruolo r= new Ruolo (Integer.parseInt(b.getIdRuolo().getText()),b.getNome().getText(),a,c);

        return r;

    }

    public BeanGuiRuolo conversioneRuolo(Ruolo b) {


        ArrayList<BeanGuiPersonale> a = new ArrayList<BeanGuiPersonale>();
        ArrayList<BeanGuiPermesso> c = new ArrayList<BeanGuiPermesso>();

        for(Personale d: b.getListPersonale()){
            BeanGuiPersonale d1 = conversionePersonale(d);
            a.add(d1);
        }

        for(Permesso d : b.getListPermessi()){
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
