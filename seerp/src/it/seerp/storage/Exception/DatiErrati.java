
//datierrati ricerca fallita
package it.seerp.storage.Exception;

import java.sql.SQLException;

/**
 *
 * @author Luisa
 */
public class DatiErrati extends SQLException {
	public DatiErrati(String  c){
    super(c);
    }
}
