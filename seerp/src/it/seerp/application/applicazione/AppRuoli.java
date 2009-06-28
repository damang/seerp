package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiRuolo;
import it.seerp.application.applicazione.conversioni.Conversione;
import it.seerp.application.applicazione.interfacce.GestioneRuoli;
import it.seerp.storage.Operazioni.OpRuolo;
import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe del livello application riguardante la Gestione dei Ruoli
 * @author Tommaso Cattolico
 */
public class AppRuoli implements GestioneRuoli<BeanGuiRuolo, Ruolo> {

    @Override
    public void inserimento(BeanGuiRuolo beanGui) throws SQLException,ValidatorException{

            OpRuolo ope = new OpRuolo();
            Ruolo ruolo = Conversione.conversioneRuolo(beanGui);
            ope.inserimento(ruolo);
       
    }

    @Override
    public BeanGuiRuolo modifica(BeanGuiRuolo beanGui) throws SQLException,ValidatorException {
      
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(beanGui);
            ruo = ope.modifica(ruo);
        //beanGui = Conversione.conversioneRuolo(ruo, beanGui);

     
        return beanGui;
    }

    @Override
    public void elimina(BeanGuiRuolo r)throws SQLException,ValidatorException {
       
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(r);
            ope.elimina(ruo);
    
    }

    @Override
    public void elimina(String r)throws SQLException,ValidatorException {
   
            OpRuolo ope = new OpRuolo();
            ope.elimina(new Ruolo(r));
 
     
    }

    @Override
    public ArrayList<BeanGuiRuolo> getElenco()throws SQLException,ValidatorException  {
        ArrayList<Ruolo> list;
        ArrayList<BeanGuiRuolo> listGui = new ArrayList<BeanGuiRuolo>();
      
            OpRuolo ope = new OpRuolo();
            list = ope.visualizzaElenco();
            for (Ruolo eve : list) {
                BeanGuiRuolo eveGui = new BeanGuiRuolo(new JPanel());
                //    eveGui = Conversione.conversioneRuolo(eve, eveGui);
                listGui.add(eveGui);
            }
   
        return listGui;
    }

    @Override
    public ArrayList<Ruolo> visualizzaTabella()throws SQLException  {
        ArrayList<Ruolo> list;
        //ArrayList<BeanGuiRuolo> listGui= new ArrayList<BeanGuiRuolo>();
   
            OpRuolo ope = new OpRuolo();
            list = ope.visualizzaElenco();
            return list;
   
    }

    @Override
    public void visualizzaDati(String nome, BeanGuiRuolo b)throws SQLException,ValidatorException  {
       
            OpRuolo ope = new OpRuolo();
            Ruolo r = ope.visualizza(nome);
            Conversione.conversioneRuolo(r, b);
     

    }

    @Override
    public ArrayList<String> getNomeRuolo(String s) throws SQLException,ValidatorException {
        ArrayList<String> list = new ArrayList<String>();
        OpRuolo op;
      
            op = new OpRuolo();
            Iterator<Ruolo> it = op.GetListaRuoli(s).iterator();
            while (it.hasNext()) {
                list.add(it.next().getNome());
            }
      
        return list;
    }
}
