/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.sql.SQLException;

/**
 *
 * @author Luisa
 */
public interface GestioneInit <G> {

    /**
     *
     * @param beanGuiEventi
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserimento(G beanGuiAmministratore) throws SQLException, DatiErrati, DatiDuplicati;

     public void check();
}
