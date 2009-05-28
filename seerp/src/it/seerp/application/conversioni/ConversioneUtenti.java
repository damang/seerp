/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.conversioni;


import it.seerp.application.bean.BeanGuiAppuntamento;
import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiContatto;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.application.bean.BeanGuiRuolo;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Utente;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class ConversioneUtenti {


    public Utente conversioneUtente(BeanGuiUtente bUtente){

        Utente utente = new Utente(Integer.parseInt(bUtente.getIdUtenteTxt().getText()),bUtente.getTxtUsername().getText(),bUtente.getTxtPassword().getText(),
                bUtente.getTxtCittà().getText(),bUtente.getTxtProvincia().getText(),bUtente.getTxtTelefono().getText(),
                bUtente.getTxtEmail().getText(),bUtente.getTxtNote().getText(),Boolean.parseBoolean(bUtente.getTxtNotifica().getText()));
        return utente;
    }

    public BeanGuiUtente conversioneUtente(Utente user){
        BeanGuiUtente utente= new BeanGuiUtente();
        JTextField a = new JTextField();
        a.setText(user.getIdUtente().toString());
        utente.setIdUtenteText(a);
        a.setText(user.getPassword());
        utente.setTxtPassword(a);
        a.setText(user.getCittà());
        utente.setTxtCittà(a);
        a.setText(user.getEmail());
        utente.setTxtEmail(a);
        a.setText(user.getProvincia());
        utente.setTxtProvincia(a);
        a.setText(user.getTelefono());
        utente.setTxtTelefono(a);
        a.setText(user.getNote().toString());
        utente.setTxtUsername(a);
        a.setText(user.getVisible().toString());
        utente.setTxtnotifica(a);
        return utente;
        }

    public Personale conversionePersonale(BeanGuiPersonale bp){

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

    public BeanGuiPersonale conversionePersonale(Personale p){
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
            Contratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            BeanGuiContratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            Contratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            BeanGuiContratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            Contratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            BeanGuiContratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            Contratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            BeanGuiContratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            Contratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
            BeanGuiContratto b1 = it.seerp.application.conversioni.Conversione.conversioneContratto(b);
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
