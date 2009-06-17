/**
 * LoginSourceAdapter.java
 *
 * @author ghuang
 * $Header$
 * $Log$
 */

package it.seerp.storage.jaas;


import java.util.Hashtable;
import javax.security.auth.login.LoginException;

/**
 *
 * @author LesAnge
 */
public interface LoginSourceAdapter
{
    /**
     *
     * @param htProperty
     */
    public void initialize(Hashtable htProperty);
    /**
     *
     * @param userID
     * @param password
     * @return
     */
    public boolean authenticate(String userID, char[] password);
    /**
     *
     * @return
     * @throws javax.security.auth.login.LoginException
     */
    public String getGroupName() throws LoginException;
    /**
     *
     */
    public void terminate();
}
