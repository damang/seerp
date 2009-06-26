
package it.seerp.Gui.configurazioni.Gui;

/**
 *
 * @author Luisa
 */
public class ConfigurazioneUtente {

    /**
     *
     */
    public static enum TIPO_UTENTE_CONST {

        /**
         *
         */
        EXTRAAZIENDA,
        /**
         *
         */
        FORNITORE,
        /**
         *
         */
        CLIENTE,
        /**
         *
         */
        RESPONSABILE,
        /**
         *
         */
        DIPENDENTE,
        /**
         *
         */
        PERSONALE,
    };



    /**
     *
     * @param con
     * @return
     */
    public static String valueOf(TIPO_UTENTE_CONST con) {

        if (con.equals(TIPO_UTENTE_CONST.CLIENTE)) {
            return "cliente";
        } else if (con.equals(TIPO_UTENTE_CONST.RESPONSABILE)) {
            return "responsabile";
        } else if (con.equals(TIPO_UTENTE_CONST.DIPENDENTE)) {
            return "dipendente";
        }
        if (con.equals(TIPO_UTENTE_CONST.FORNITORE)) {
            return "fornitore";
        }
            if (con.equals(TIPO_UTENTE_CONST.EXTRAAZIENDA)) {
            return "extraazienda";
        }
            if (con.equals(TIPO_UTENTE_CONST.PERSONALE)) {
            return "personale";
        }
        return null;
    }
}
