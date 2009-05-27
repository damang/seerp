/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.Exception;

/**
 *
 * @author Luisa
 */
public class CancellazioneFallita extends RuntimeException{
	public CancellazioneFallita (String  c){
    super(c);
    }
}
