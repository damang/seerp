/**
 * AuthznDBHanlder.java
 *
 *
 *
 *
 * @author ghuang
 *
 * Create:4-Mar-2003
 *
 * $Header$
 * $Log$
 */



package it.seerp.jaas;

import it.seerp.storage.ejb.Permesso;
import it.seerp.storage.db.ConnectionPool;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Principal;
import java.security.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PermissionRoleDBAdapter implements PermissionAdapter
{
  //  private Hashtable _htConnProp;
	private Connection _connection;
	//private Hashtable _htPermissions;

	/**
	 *
	 */
	public PermissionRoleDBAdapter()
	{

	}

	/* (non-Javadoc)
	 * @see sample.auth.AuthznHandler#initialize(java.util.Hashtable)
	 */
	public void initialize(Hashtable initParams)
	{
	//	if (Debug.DEBUG)
	//		Debug.trace("PermissionRoleDBAdapter::initialize");
	//	_htConnProp = initParams;
		//_htPermissions = getAllPermissions ();

	}
	
	
	public PermissionCollection getPermissions (CodeSource codeSource)
	{
		if (Debug.DEBUG)
			Debug.trace("PermissionRoleDBAdapter::getPermissions (CodeSource codeSource)");
		
		//we just care about the role-based, so do nothing here
		return null;
	}
	
	public PermissionCollection getPermissions (ProtectionDomain domain)
	{
		if (Debug.DEBUG)
			Debug.trace("PermissionRoleDBAdapter::getPermissions(ProtectionDomain domain)");
		Principal[] principals = domain.getPrincipals();
		
		String role = principals[1].getName();
        PermessoCollection list=null;
        
            list = getPermissionsUt(role);

       
		//}
        return list;
		
	}


	/* (non-Javadoc)
	 * @see sample.auth.AuthznHandler#getPermissions(java.security.Principal[], java.security.CodeSource)
	 */
	public PermissionCollection getPermissions(
		Principal[] principals, CodeSource codeSource)
	{
		String role = principals[1].getName();
        PermessoCollection list=null;
      
            list = getPermissionsUt(role);
       
        return list;
	}


	/* (non-Javadoc)
	 * @see sample.auth.AuthznHandler#terminate()
	 */
	public void terminate()
	{
		try
		{
			if (_connection != null && !_connection.isClosed())
				ConnectionPool.releaseConnection(_connection);
			_connection = null;

		}
		catch (SQLException sqe)
		{
            sqe.printStackTrace();
		}

	}


		/*private boolean isTitleTo (String name, Principal[] principals)
	{
		if (principals == null || principals.length == 0)
			return true;

		int count = principals.length;
		for (int i = 0; i < count; i++)
		{
			if (name.equals (principals[i].getName()))
				return true;
		}

		return false;
	}
*/

	public static PermessoCollection getPermissionsUt(String role) {
		if (Debug.DEBUG)
			Debug.trace("PermissionRoleDBAdapter::getAllPermissions");
		String SQL="SELECT idPermesso, task, action FROM permesso p, incarico i, ruolo r WHERE idPermesso=i.permesso and i.ruolo=r.nome and r.nome=?";
        PermessoCollection perms = new PermessoCollection();

		Connection conn=null;
        try {
            conn = ConnectionPool.getConnection();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
		if (conn == null)
		{
			System.out.println("No connection");
			return perms;
		}

		boolean bOK = false;
	//	String sql =
		//PreparedStatement
		PreparedStatement stmt = null;
        ResultSet rs=null;
		try
		{
			stmt = conn.prepareStatement(SQL);
			//stmt = conn.createStatement();
            stmt.setString(1,role);
			rs = stmt.executeQuery();
			if (rs != null)
			{
				while (rs.next())
				{
                    int id= rs.getInt("idPermesso");
					String task = rs.getString ("task");
					String action = rs.getString ("action");
					perms.add(new Permesso(id,task, action));
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
			catch (SQLException sqe)
			{
				//ignore it
			}

			return perms;
		}
	}

}
