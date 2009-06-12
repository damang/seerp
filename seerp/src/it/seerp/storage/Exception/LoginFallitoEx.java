
package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 */

/* LoginFallitoEX viene lanciata quando username o password di un utente sono
 sbagliate o non esistenti all'interno del database
 */

 public class LoginFallitoEx extends RuntimeException{

     public LoginFallitoEx() {
    }

    
    public LoginFallitoEx(String msg) {
        super(msg);
    }

}
