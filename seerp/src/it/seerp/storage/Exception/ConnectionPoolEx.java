

package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * /**
 * Classe che gestisce le eccezioni sollevate a runtime dalla classe ConnectionPool
 *
 */
public class ConnectionPoolEx extends RuntimeException{
    public ConnectionPoolEx()
    {}

     public ConnectionPoolEx(String msg) {
        super(msg);
    }


}
