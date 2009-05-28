package it.seerp.application.conversioni;

import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.bean.BeanGuiPagamento;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.storage.ejb.Contratto;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.ejb.Pagamento;
import it.seerp.storage.ejb.Servizio;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Tommaso Cattolico
 */
public class Conversione
{
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

    public BeanGuiPagamento conversionePagamento(Pagamento p)
    {

    }

    public Pagamento conversionePagamento(BeanGuiPagamento p)
    {

    }

}
