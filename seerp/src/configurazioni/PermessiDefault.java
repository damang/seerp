package configurazioni;

import it.seerp.jaas.PermessoCollection;
import it.seerp.jaas.PermissionRoleDBAdapter;

/**
 *
 * @author peppe
 */
public class PermessiDefault {
   

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
