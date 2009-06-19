
package it.seerp.Gui.configurazioni.Gui;

import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.bean.BeanGuiUtente;

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
        AZIENDA,
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
    };

    /**
     *
     * @param tipo
     * @return
     */
    public static BeanGuiUtente istanziaBean(TIPO_UTENTE_CONST tipo) {

        if (tipo.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.CLIENTE)) {
            return new BeanGuiCliente();
        } else if (tipo.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.DIPENDENTE)) {
            return new BeanGuiDipendente();
        } else if (tipo.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.FORNITORE)) {
            return new BeanGuiFornitore();
        } else if (tipo.equals(ConfigurazioneUtente.TIPO_UTENTE_CONST.RESPONSABILE)) {
            return new BeanGuiResponsabile();
        }

        return null;
    }

    /**
     *
     * @param con
     * @return
     */
    public static int valueOf(TIPO_UTENTE_CONST con) {

        if (con.equals(TIPO_UTENTE_CONST.CLIENTE)) {
            return 0;
        } else if (con.equals(TIPO_UTENTE_CONST.RESPONSABILE)) {
            return 1;
        } else if (con.equals(TIPO_UTENTE_CONST.DIPENDENTE)) {
            return 2;
        }
        if (con.equals(TIPO_UTENTE_CONST.FORNITORE)) {
            return 3;
        }

        return -1;
    }
}
