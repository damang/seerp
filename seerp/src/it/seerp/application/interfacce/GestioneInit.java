package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.sql.SQLException;

/**
 * Interfaccia della Gestione Init
 * @param <G> 
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneInit<G> {

    /**
     * Metodo che inserisce l'Amministratore dell'Azienda
     * @param beanGuiAmministratore Bean Gui dell'Amministratore da inserire
     * @throws SQLException
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserimento(G beanGuiAmministratore) throws SQLException, DatiErrati, DatiDuplicati;

    /**
     * Metodo che controlla se esiste già un Amministratore nel sistema
     * @return true o false a seconda del controllo
     */
    public boolean check();
}
