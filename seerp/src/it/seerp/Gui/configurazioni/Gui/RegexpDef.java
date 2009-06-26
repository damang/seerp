
package it.seerp.Gui.configurazioni.Gui;

/**
 *
 * @author peppe
 */
public class RegexpDef {

    public static enum VAL {

        NOME_RUOLO,
        MAIL,
        VUOTO,
        CODFIS,
        PROV,
        CAP,
        PIVA,
        DATA,
        ORA,
        TELEFONO,
        PREZZO,
        NUMPOS
    }

    public static String valueOf(VAL c) {
        if (c.equals(VAL.NOME_RUOLO))
            return "(dipendente[_]?[a-z]*|responsabile[_]?[a-z]*)";
        else if (c.equals(VAL.MAIL)) 
            return "^[\\w\\.\\-]+@\\w+[\\w\\.\\-]*?\\.\\w{1,4}$";
         else if (c.equals(VAL.CODFIS)) 
            return "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
         else if (c.equals(VAL.PROV)) 
            return "^[A-Z]{2}$";
         else if (c.equals(VAL.CAP)) 
            return "\\d{5}";
         else if(c.equals(VAL.PIVA))
            return "\\d{11}";
        else if (c.equals(VAL.DATA))
            return "^\\d{2}[\\/\\.]\\d{2}[\\/\\.]\\d{4}$";
        else if(c.equals(VAL.ORA))
            return "(?:[01]\\d|2[0-3])[.:](?:[0-5]\\d)[.:](?:[0-5]\\d)";
        else if (c.equals(VAL.TELEFONO))
            return "^[0-9]+\\d[0-9]+$";
        else if (c.equals(VAL.VUOTO))
            return"(.[a-z]*)*";
        else if (c.equals(VAL.PREZZO))
            return "(\\d{0,9})[.](\\d{2})";
        else if (c.equals(VAL.NUMPOS))
            return "\\d{0,9}";
        else return"";

    }
}
