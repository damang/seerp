

package it.seerp.storage.Exception;

import java.sql.SQLException;

/*
 * Si può verificare quando si inserisce un utente già inserito
 * @author Ila
 */
public class DatiDuplicatiEx  extends SQLException{
    /**
     *
     * @param c
     */
    public DatiDuplicatiEx(String  c){
    super(c);
    }

}
