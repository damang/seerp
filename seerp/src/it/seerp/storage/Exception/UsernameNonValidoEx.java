

package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * Username già presente nel database, viene richiamata durante la fase di
 * inserimento di un nuovo utente
 */
public class UsernameNonValidoEx extends Exception{

    /**
     *
     */
    public UsernameNonValidoEx() {
    }

    /**
     *
     * @param msg
     */
    public UsernameNonValidoEx(String msg) {
        super(msg);
    }

}
