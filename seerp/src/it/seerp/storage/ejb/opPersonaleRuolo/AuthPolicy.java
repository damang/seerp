/**
 * GenericAuthPolicy.java
 *
 *  in java JRE /lib/security/java.security, set:
 *   policy.provider=com.jdj.jaas.AuthPolicy
 *
 *
 *
 * @author ghuang
 *
 *
 * $Header$
 * $Log$
 */



package it.seerp.storage.ejb.opPersonaleRuolo;

//import java.io.FilePermission;
import it.seerp.storage.jaas.*;
import it.seerp.storage.jaas.ejb.Permesso;
import java.security.*;
import java.security.PermissionCollection;
//import java.security.Policy;
import java.security.ProtectionDomain;


import javax.security.auth.Subject;

import java.util.Enumeration;
import java.util.Set;


/**
 *
 * @author LesAnge
 */
public class AuthPolicy extends java.security.Policy
//java.security.Policy//javax.security.auth.Policy
{
    /**
     *
     */
    protected PermissionAdapter _handler;

    /**
     *
     */
    public AuthPolicy()
	{
		super ();
	}

    /**
     *
     * @param subject
     * @param cs
     * @return
     */
    public PermissionCollection getPermissions(Subject subject, CodeSource cs)
	{
		if (Debug.DEBUG)
			Debug.trace("getPermissions(Subject subject, CodeSource cs)");

		if (_handler == null)
			_handler = PermissionAdapterFactory.getAdapter();

		PermissionCollection perms = null;
		try
		{
			Set set = subject.getPrincipals ();
			Principal[] pals = new Principal [set.size()];
			set.toArray (pals);

			perms = _handler.getPermissions(pals, cs);
		}
		catch (Exception e)
		{
		}
		catch (Throwable tab)
		{
		}

		if (perms == null)
			perms = new Permissions();

		return perms;
	}

	/* (non-Javadoc)
	 * @see java.security.Policy#getPermissions(java.security.CodeSource)
	 */
	public PermissionCollection getPermissions(CodeSource codesource)
	{
		if (Debug.DEBUG)
			Debug.trace("GenericAuthPolicy::getPermissions(CodeSource");
		
		if (_handler == null)
			_handler = PermissionAdapterFactory.getAdapter();
			
		if (_handler == null)
			return super.getPermissions(codesource);
			
		PermissionCollection perms = _handler.getPermissions(codesource);
		if (perms != null)
		{
			//addToCollection (perms, super.getPermissions(codesource));
			return perms;
		}
		else
		{
			return super.getPermissions(codesource);
		}
		
	}


	public PermissionCollection getPermissions(ProtectionDomain domain)
	{
		if (Debug.DEBUG)
		{
			Debug.trace("AuthPolicy::getPermissions(ProtectedDomain)");
		}

		if (!AuthConfig.getInstance().isLoaded())
			return super.getPermissions(domain);

		if (_handler == null)
			_handler = PermissionAdapterFactory.getAdapter();
			
		if (null == _handler)
			return super.getPermissions(domain);

		Principal[] pls = domain.getPrincipals();
		if (pls == null || pls.length == 0)
			return super.getPermissions(domain);


		PermissionCollection perms = null;

		perms = _handler.getPermissions(domain);

		if (perms != null)
		{
			java.util.Enumeration enu = perms.elements();
			while (enu.hasMoreElements())
			{
				Permesso item = (Permesso) enu.nextElement();
			}
					
			return perms;
		}

		return super.getPermissions(domain);
	}

	/* (non-Javadoc)
	 * @see java.security.Policy#refresh()
	 */
	public void refresh()
	{
		if (Debug.DEBUG)
			Debug.trace("AuthPolicy::refresh");
			
		super.refresh();
		
		if (_handler != null)
		{
			AuthConfig cfg = AuthConfig.getInstance();
			_handler.initialize (cfg.getAuthznInitParam());
		}
	}


	///////////////////////////////////////////////////////
	// protected

	private PermissionCollection addToCollection (PermissionCollection perms, PermissionCollection newPerms)
	{
		if (perms == null || newPerms == null)
			return perms;
			
		Enumeration enu = newPerms.elements();
		if (enu != null)
		{
			while (enu.hasMoreElements())
				perms.add((Permission)enu.nextElement());
		}
		
		return perms;
	}
}
