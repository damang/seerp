/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.Exception;

/**
 *
 * @author Luisa
 */
public class DatiErrati extends RuntimeException {
    /**
     *
     * @param c
     */
    public DatiErrati(String  c){
    super(c);
    }

}
