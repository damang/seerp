

package it.seerp.storage.Exception;

import java.sql.SQLException;

/**
 *
 * @author Ila
 */

/*
 * Si può verificare quando si inserisce un utente già inserito 
 */
public class DatiDuplicatiEx  extends SQLException{
	public DatiDuplicatiEx(String  c){
    super(c);
    }

}
