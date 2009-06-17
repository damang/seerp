/**
 * AuthPrincipal.java
 *
 * @author ghuang
 *
 * Create:5-Mar-2003
 *
 * $Header$
 * $Log$
 */

package it.seerp.storage.jaas;

import java.security.Principal;

/**
 * @author ghuang
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AuthPrincipal implements Principal 
{

    private String _type;
   	private String _name;

    /**
     *
     * @param name
     * @param type
     */
    public AuthPrincipal(String name,String type)
	{
		_name = name;
        _type=type;
	}

	 /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return _type;
    }
    /**
	 * @see java.security.Principal#getName()
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * Compares the specified Object with this <code>AuthPrincipal</code>.
	 * Returns true if the specified object is an instance of
	 * <code>AuthPrincipal</code> and has the same name as this AuthPrincipal.
	 *
	 * @param object Object to be compared
	 *
	 * @return true if the specified Object is equal to this
	 * <code>AuthPrincipal</code>.
	 */
    @Override
	public boolean equals(Object object) {
		if(object == null)
			return false;

		if(!(object instanceof AuthPrincipal))
			return false;

		if(object == this)
			return true;

		AuthPrincipal principal = (AuthPrincipal) object;
		if (getName().equals(principal.getName()) && getType().equals(principal.getType()))
			return true;

		return false;
	}


	/**
	 *
	 */
	public int hashCode()
	{
		return _type.hashCode();
        //return (int)(Math.random()*100);
	}

    public String toString() {
         return _type+ ": " + _name;
    }

}
