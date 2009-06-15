/**
 * AuthPermissionCollection.java
 *
 * @author ghuang
 *
 * Create:5-Mar-2003
 *
 * $Header$
 * $Log$
 */

package it.seerp.jaas;

import it.seerp.storage.ejb.Permesso;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Iterator;

public class PermessoCollection extends PermissionCollection
{
	private Vector _perms = new Vector ();
	
	/* (non-Javadoc)
	 * @see java.security.PermissionCollection#add(java.security.Permission)
	 */
	public void add(Permission permission)
	{
		_perms.add(permission);
	}

	/* (non-Javadoc)
	 * @see java.security.PermissionCollection#implies(java.security.Permission)
	 */
	public boolean implies(Permission permission)
	{
		if (Debug.DEBUG)
			Debug.trace("AuthPermissionCollection.implies(" + permission + ") called");
		 for (Iterator i = _perms.iterator(); i.hasNext(); ) 
		 {
			 if (((Permission)i.next()).implies(permission)) 
			 {
				 return true;
			 }
		 }
		 return false;
	}

	/* (non-Javadoc)
	 * @see java.security.PermissionCollection#elements()
	 */
	public Enumeration elements()
	{
		return _perms.elements();
	}
    public int size() {
        return _perms.size();
    }
    public void remove (Permesso c) {
        _perms.remove(c);
    }


}