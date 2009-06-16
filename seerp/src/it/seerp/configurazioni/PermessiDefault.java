package it.seerp.configurazioni;

import it.seerp.jaas.PermessoCollection;
import it.seerp.jaas.PermissionRoleDBAdapter;

/**
 *
 * @author peppe
 */
public class PermessiDefault {
   
    public static enum Categoria_Permesso {
        GestioneRuoli,
        GestioneDipendenti,
        GestioneClienti,
        GestioneFornitori,
        GestioneContratti,
        GestioneServizi
    }

    public static String valueOf(Categoria_Permesso con) {
        if (con.equals(Categoria_Permesso.GestioneRuoli)) {
            return "gestione_ruoli";
        } else if (con.equals(Categoria_Permesso.GestioneDipendenti)) {
            return "gestione_dipendenti";
        } else if (con.equals(Categoria_Permesso.GestioneClienti)) {
            return "gestione_clienti";
        } else if (con.equals(Categoria_Permesso.GestioneFornitori)) {
            return "gestione_fornitori";
        } else if (con.equals(Categoria_Permesso.GestioneContratti)) {
            return "gestione_contratti";
        } else if (con.equals(Categoria_Permesso.GestioneServizi)) {
            return "gestione_servizi";
        }
        return null;
    }
    
    public static enum Operazione_Permesso {
        AGGIUNGI,
        ELIMINA,
        MODIFICA,
        RICERCA,
        ELENCA,
        VISUALIZZA
    }

    public static String valueOf(Operazione_Permesso con) {
        if (con.equals(Operazione_Permesso.AGGIUNGI)) {
            return "aggiungi";
        } else if (con.equals(Operazione_Permesso.ELIMINA)) {
            return "elimina";
        } else if (con.equals(Operazione_Permesso.MODIFICA)) {
            return "modifica";
        } else if (con.equals(Operazione_Permesso.RICERCA)) {
            return "ricerca";
        } else if (con.equals(Operazione_Permesso.ELENCA)) {
            return "elenca";
        } else if (con.equals(Operazione_Permesso.VISUALIZZA)) {
            return "visualizza";
        }
        return null;
    }

    private static PermessoCollection dipendente;
    private static PermessoCollection responsabile;
    private static PermessoCollection amministratore;


 //   private PermessiDefault perms;

    public static void init(){
        dipendente=PermissionRoleDBAdapter.getPermissionsUt("dipendente");
        responsabile=PermissionRoleDBAdapter.getPermissionsUt("responsabile");
        amministratore=PermissionRoleDBAdapter.getPermissionsUt("amministratore");
    }


    /**
     * Get the value of amministratore
     *
     * @return the value of amministratore
     */
    public static PermessoCollection getPermessiAmministratore() {
        return amministratore;
    }


    /**
     * Get the value of responsabile
     *
     * @return the value of responsabile
     */
    public static PermessoCollection getPermessiResponsabile() {
        return responsabile;
    }

    public static PermessoCollection getPermessiDipendete () {
        return dipendente;
    }

}
