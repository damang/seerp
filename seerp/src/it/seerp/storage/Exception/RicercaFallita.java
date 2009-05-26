/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Exception;

import java.sql.SQLException;

/**
 *
 * @author Luisa
 */
public class RicercaFallita extends SQLException {
	public RicercaFallita (String  c){
    super(c);
    }
}
