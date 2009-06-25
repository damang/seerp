/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.configurazioni.Gui;

/**
 *
 * @author peppe
 */
public class RegexpDef {
    public static enum VAL {
        NOME_RUOLO

    }

    public static String valueOf(VAL c) {
        if (c.equals(VAL.NOME_RUOLO))
            return "(dipendente[_]?[a-z]*|responsabile[_]?[a-z]*)";
        return "";
    }
}
