/**
 * PermissionAdapter.java
 *
 * @author ghuang
 *
 * $Header$
 * $Log$
 */

package it.seerp.storage.jaas;


import java.util.Hashtable;
import java.security.PermissionCollection;
import java.security.Principal;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 *
 * @author LesAnge
 */
public interface PermissionAdapter
{
    /**
     *
     * @param initParams
     */
    public void initialize(Hashtable initParams);
    /**
     *
     * @param principals
     * @param codeSource
     * @return
     */
    public PermissionCollection getPermissions(Principal[] principals, CodeSource codeSource);
    /**
     *
     * @param codeSource
     * @return
     */
    public PermissionCollection getPermissions(CodeSource codeSource);
    /**
     *
     * @param domain
     * @return
     */
    public PermissionCollection getPermissions(ProtectionDomain domain);
    /**
     *
     */
    public void terminate();
}
