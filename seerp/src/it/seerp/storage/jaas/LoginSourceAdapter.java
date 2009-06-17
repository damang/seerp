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

public interface LoginSourceAdapter
{
	public void initialize (Hashtable htProperty);
	public boolean authenticate (String userID, char[] password);
	public String getGroupName () throws LoginException;
	public void terminate ();
}
