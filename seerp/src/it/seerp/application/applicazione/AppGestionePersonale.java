package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.storage.Operazioni.OpAmministratore;
import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 * Classe che permette di effettuare delle operazioni sul Personale
 * @author matteo
 */
public class AppGestionePersonale extends AppGestioneUtente{

    /**
     *Costruttore vuoto per la classe AppGestionePersonale
     */
    public AppGestionePersonale(){
    super();
    }


    /**
     * Metodo che peremette di inserire un nuovo Dipendente
     * @param user il dipendente da inserire
     */
    public void inserisciDipendente(BeanGuiDipendente user){
      super.inserisci(user);
      OpDipendente a = new OpDipendente();
      Dipendente dip= it.seerp.application.conversioni.Conversione.conversioneDipendente(user);
        try {
            a.inserisci(dip);
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
      * Metodo che permette di inserire un nuovo Responsabile
      * @param user
      */
     public void inserisciResponsabile(BeanGuiResponsabile user){
      super.inserisci(user);
      OpResponsabile a = new OpResponsabile();
      Responsabile dip= it.seerp.application.conversioni.Conversione.conversioneResponsabile(user);
        try {
            a.inserisci(dip);
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
      * Metodo che permette di modificare i dati di un Dipendente
      * @param user rappresenta il Dipendente da modificare
      * @return il Dipendente modificato
      */
     public BeanGuiDipendente modificaDipendente(BeanGuiDipendente user){
      super.modifica(user);
      OpDipendente a = new OpDipendente();
      Dipendente dip= it.seerp.application.conversioni.Conversione.conversioneDipendente(user);
        try {
            dip = a.modifica(dip);
            
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
          return it.seerp.application.conversioni.Conversione.conversioneDipendente(dip, user);
      }


      /**
       * Metodo che permette di modificare i dati di un Amministratore
       * @param user rappresenta l'Amministratore da modificare
       * @return l'Amministratore modificato
       */
      public BeanGuiAmministratore modificaAmministratore(BeanGuiAmministratore user){
      super.modifica(user);
      OpAmministratore a = new OpAmministratore();
      Amministratore amm= it.seerp.application.conversioni.Conversione.conversioneAmministratore(user);
        try {
            amm = (Amministratore) a.modifica(amm);
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
          return it.seerp.application.conversioni.Conversione.conversioneAmministratore(amm, user);
      }

      /**
       * Metodo che permette di modificare i dati di un Responsabile
       * @param user il Responsabile da modificare
       * @return il Responsabile modificato
       */
      public BeanGuiResponsabile modificaResponsabile(BeanGuiResponsabile user){
      super.modifica(user);
      OpResponsabile a = new OpResponsabile();
      Responsabile res= it.seerp.application.conversioni.Conversione.conversioneResponsabile(user);
        try {
            res = a.modifica(res);

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
          return it.seerp.application.conversioni.Conversione.conversioneResponsabile(res, user);
      }


}
