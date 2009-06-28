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

package it.seerp.storage.ejb.jaas;

import it.seerp.storage.jaas.*;
import it.seerp.storage.jaas.ejb.Permesso;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Iterator;

/**
 *
 * @author LesAnge
 */
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
    /**
     *
     * @return
     */
    public int size() {
        return _perms.size();
    }
    /**
     *
     * @param c
     */
    public void remove(Permesso c) {
        _perms.remove(c);
    }
    /**
     *
     * @return
     */
    public Iterator<Permesso> iterator() {
        return _perms.iterator();
    }
    public Permesso get(int i) {
        return (Permesso)_perms.get(i);
    }


}
