package it.seerp.application.conversioni;

import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.bean.BeanGuiPermesso;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Ruolo;
import it.seerp.storage.ejb.Servizio;
import it.seerp.storage.ejb.Utente;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Tommaso Cattolico
 */
public class Conversione {
    public Contratto conversioneContratto(BeanGuiContratto pGui){
        Contratto contratto = new Contratto(pGui.getStato().getText(), Date.valueOf(pGui.getData().getText()),
                Integer.parseInt(pGui.getDurata().getText()), pGui.getTipo().getText(),
                Integer.parseInt(pGui.getIdContratto().getText()), pGui.getNote().getText(),
                Integer.parseInt(pGui.getDipendente().getText()), Integer.parseInt(pGui.getExtraAzienda().getText()));
        return contratto;
    }

    public BeanGuiContratto conversioneContratto(Contratto c){
        BeanGuiContratto gui = new BeanGuiContratto();
        JTextField a = new JTextField();
        JTextArea b = new JTextArea();
        a.setText(c.getStato());
        gui.setStato(a);
        a.setText(c.getData().toString());
        gui.setData(a);
        a.setText(c.getDurata().toString());
        gui.setDurata(a);
        a.setText(c.getTipo());
        gui.setTipo(a);
        a.setText(c.getIdContratto().toString());
        gui.setIdContratto(a);
        b.setText(c.getNote());
        gui.setNote(b);
        a.setText(c.getDipendente().toString());
        gui.setDipendente(a);
        a.setText(c.getExtraAzienda().toString());
        gui.setExtraAzienda(a);
        return gui;
    }

    public Evento conversioneEvento(BeanGuiEvento pGui){
        Evento evento = new Evento(pGui.getLuogo().getText(), pGui.getTema().getText(), pGui.getNome().getText(), pGui.getNote().getText(),
                Date.valueOf(pGui.getData().getText()), Time.valueOf(pGui.getOra().getText()),
                Integer.parseInt(pGui.getIdEvento().getText()), Integer.parseInt(pGui.getAgenda().getText()));
        return evento;
    }

    public BeanGuiEvento conversioneEvento(Evento e){
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

    public Servizio conversioneServizio(BeanGuiServizio pGui){
        Servizio servizio = new Servizio(pGui.getDescrizione().getText(), Boolean.parseBoolean(pGui.getDisponibilita().getText()),
                Integer.parseInt(pGui.getQuantita().getText()), Double.parseDouble(pGui.getPrezzo().getText()),
                Integer.parseInt(pGui.getIdServizio().getText()), Integer.parseInt(pGui.getIva().getText()), pGui.getNote().getText());
        return servizio;
    }

    public BeanGuiServizio conversioneServizio(Servizio s){
        BeanGuiServizio gui = new BeanGuiServizio();
        JTextField a = new JTextField();
        JTextArea b = new JTextArea();
        a.setText(s.getDescrizione());
        gui.setDescrizione(a);
        a.setText(s.getDisponibilita().toString());
        gui.setDisponibilita(a);
        a.setText(s.getQuantita().toString());
        gui.setQuantita(a);
        a.setText(s.getTipo());
        gui.setTipo(a);
        a.setText(s.getPrezzo().toString());
        gui.setPrezzo(a);
        a.setText(s.getIdServizio().toString());
        gui.setIdServizio(a);
        a.setText(s.getIva().toString());
        gui.setIva(a);
        b.setText(s.getNote());
        gui.setNote(b);
        return gui;
    }

}
