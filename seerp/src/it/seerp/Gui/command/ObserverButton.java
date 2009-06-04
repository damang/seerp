/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.command;

import configurazioni.pattern.observer.Observable;
import configurazioni.pattern.observer.Observer;
import javax.swing.JButton;

/**
 *
 * @author Andrea
 */
public class ObserverButton extends JButton implements Observer {
    /**
     *
     */
    protected boolean isPresente = false;

    public synchronized void refreshData(Observable subject) {
        isPresente = false;
    }


}