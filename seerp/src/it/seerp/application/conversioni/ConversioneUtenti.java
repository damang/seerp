/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.conversioni;

import it.seerp.application.bean.BeanGuiAppuntamento;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.application.bean.BeanGuiRuolo;
import it.seerp.storage.ejb.Appuntamento;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
        return extra;
    }

}
