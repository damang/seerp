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
 *
 * @author matteo
 */
public class AppGestionePersonale extends AppGestioneUtente{

    /**
     *
     */
    public AppGestionePersonale(){
    super();
    }


    /**
     *
     * @param user
     */
    public void inserisciDipendente(BeanGuiDipendente user){
      super.inserisci(user);
      OpDipendente a = new OpDipendente();
      Dipendente dip= it.seerp.application.conversioni.Conversione.conversioneDipendente(user);
        try {
            a.inserisci(dip);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param user
     */
    public void inserisciAmministratore(BeanGuiAmministratore user){
      super.inserisci(user);
      OpAmministratore a = new OpAmministratore();
      Amministratore amm= it.seerp.application.conversioni.Conversione.conversioneAmministratore(user);
        try {
            a.inserisci(amm);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     /**
      *
      * @param user
      */
     public void inserisciResponsabile(BeanGuiResponsabile user){
      super.inserisci(user);
      OpResponsabile a = new OpResponsabile();
      Responsabile dip= it.seerp.application.conversioni.Conversione.conversioneResponsabile(user);
        try {
            a.inserisci(dip);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     /**
      * 
      * @param user
      * @return
      */
     public BeanGuiDipendente modificaDipendente(BeanGuiDipendente user){
      super.modifica(user);
      OpDipendente a = new OpDipendente();
      Dipendente dip= it.seerp.application.conversioni.Conversione.conversioneDipendente(user);
        try {
            dip = a.modifica(dip);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
          return it.seerp.application.conversioni.Conversione.conversioneDipendente(dip, user);
      }


      /**
       *
       * @param user
       * @return
       */
      public BeanGuiAmministratore modificaAmministratore(BeanGuiAmministratore user){
      super.modifica(user);
      OpAmministratore a = new OpAmministratore();
      Amministratore amm= it.seerp.application.conversioni.Conversione.conversioneAmministratore(user);
        try {
            amm = (Amministratore) a.modifica(amm);
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
          return it.seerp.application.conversioni.Conversione.conversioneAmministratore(amm, user);
      }

      /**
       *
       * @param user
       * @return
       */
      public BeanGuiResponsabile modificaResponsabile(BeanGuiResponsabile user){
      super.modifica(user);
      OpResponsabile a = new OpResponsabile();
      Responsabile res= it.seerp.application.conversioni.Conversione.conversioneResponsabile(user);
        try {
            res = a.modifica(res);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
          return it.seerp.application.conversioni.Conversione.conversioneResponsabile(res, user);
      }


}
