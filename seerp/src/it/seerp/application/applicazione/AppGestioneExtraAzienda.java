package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiContatto;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.storage.Operazioni.OpCliente;
import it.seerp.storage.Operazioni.OpContatto;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;

/**
 * Classe che permette la gestione delle operazione relative agli ExtraAzienda
 * @author matteo
 */
public class AppGestioneExtraAzienda extends AppGestioneUtente {

    /**
     * Metodo che permette di inserire un nuovo Contatto
     * @param cont il Contatto che si vuole inserire
     */
    public void inserisciContatto(BeanGuiContatto cont){
      super.inserisci(cont);
      OpContatto a = new OpContatto();
      Contatto co= it.seerp.application.conversioni.Conversione.conversioneContatto(cont);
        try {
            a.inserisci(co);
        } catch (SQLException ex) {
             System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }


    /**
     * Metodo che permette di inserire un nuovo Cliente
     * @param clien il Cliente che si vuole inserire
     */
    public void inserisciCliente(BeanGuiCliente clien){
      super.inserisci(clien);
      OpCliente a = new OpCliente();
      Cliente cl= it.seerp.application.conversioni.Conversione.conversioneCliente(clien);
        try {
            a.inserisci(cl);
        } catch (SQLException ex) {
             System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Fornitore
     * @param forn il Fornitore che si vuole inserire
     */
    public void inserisciFornitore(BeanGuiFornitore forn){
      super.inserisci(forn);
      OpFornitore a = new OpFornitore();
      Fornitore fo= it.seerp.application.conversioni.Conversione.conversioneFornitore(forn);
        try {
            a.inserisci(fo);
        } catch (SQLException ex) {
             System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    /**
     * Metodo che permette di modificare i dati di un Contatto
     * @param cont il Contatto che si deve modificare
     * @return il Contatto modificato
     */
    public BeanGuiContatto modificaContatto(BeanGuiContatto cont){
      super.modifica(cont);
      OpContatto a = new OpContatto();
      Contatto co= it.seerp.application.conversioni.Conversione.conversioneContatto(cont);
        try {
            co = a.modifica(co);

        } catch (SQLException ex) {
            System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
          return it.seerp.application.conversioni.Conversione.conversioneContatto(co, cont);
      }

     /**
      * Metodo che permette di modificare i dati di un Cliente
      * @param clien il cliente che si deve modificare
      * @return il cliente modificato
      */
     public BeanGuiCliente modificaCliente(BeanGuiCliente clien){
      super.modifica(clien);
      OpCliente a = new OpCliente();
      Cliente cl= it.seerp.application.conversioni.Conversione.conversioneCliente(clien);
        try {
            cl = a.modifica(cl);

        } catch (SQLException ex) {
            System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
          return it.seerp.application.conversioni.Conversione.conversioneCliente(cl, clien);
      }

     /**
      * Metodo che permette di modificare i dati di un Fornitore
      * @param forn il Fornitore che si vuole modificare
      * @return il Fornitore modificato
      */
     public BeanGuiFornitore modificaFornitore(BeanGuiFornitore forn){
      super.modifica(forn);
      OpFornitore a = new OpFornitore();
      Fornitore fo= it.seerp.application.conversioni.Conversione.conversioneFornitore(forn);
        try {
            fo = a.modifica(fo);

        } catch (SQLException ex) {
            System.out.println("SQL Exception:");
            while (ex != null)
            {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
          return it.seerp.application.conversioni.Conversione.conversioneFornitore(fo, forn);
      }
}
