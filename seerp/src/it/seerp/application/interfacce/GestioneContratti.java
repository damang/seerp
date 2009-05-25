/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.interfacce;

import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface GestioneContratti<E> {
    public void visualizzaContratti();
    public E ricercaContratto();
    public void InserisciContratto(E Contratto);



}
