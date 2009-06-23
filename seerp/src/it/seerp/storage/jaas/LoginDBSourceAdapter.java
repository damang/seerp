/**
 * LoginDBSourceAdapter.java
 *
 * @author ghuang
 *
 * $Header$
 * $Log$
 */

package it.seerp.storage.jaas;


import it.seerp.storage.db.ConnectionPool;
import java.util.Hashtable;


import java.sql.*;
import javax.security.auth.login.LoginException;


/**
 *
 * @author LesAnge
 */
public class LoginDBSourceAdapter implements LoginSourceAdapter
{
//	private Hashtable _htConnProp;
	private Connection _connection;
	private String _group,_id;
    boolean bOK = false;
    private String _tipo;

    /**
     *
     */
    public LoginDBSourceAdapter()
	{
	}

    /**
     *
     * @param htProperty
     */
    public void initialize(Hashtable htProperty)
	{
		//_htConnProp = htProperty;
	}

    /**
     *
     * @param userID
     * @param password
     * @return
     */
    public boolean authenticate(String userID, char[] password)
	{
		Connection conn=null;
        try {
            conn = getConnection();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
		if (conn == null)
		{
			System.out.println("No connection");
			return false;
		}

		bOK = false;

		String sql = "SELECT username, `password`, r.nome as role , idUtente, tipo FROM utente u, personale p, ruolo r "+
                    "WHERE idUtente=idPersonale AND p.ruolo=r.nome AND username=?";
       
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String strPw = new String (password);
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userID);
			rs = stmt.executeQuery();
			if (rs != null)
			{
				while (rs.next ())
				{
					String pw = rs.getString ("password");
					if (pw.equals (strPw))
					{
						_group=rs.getString("role");
                        _id=rs.getString("idUtente");
                        _tipo=rs.getString("utente.tipo");
						bOK = true;
						break;
					}
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
			}

			return bOK;
		}


	}

    /**
     *
     * @return
     * @throws javax.security.auth.login.LoginException
     */
    public String getGroupName() throws LoginException
	{
		if(bOK == true)
            return _group;
        throw new LoginException();
	}

    /**
     *
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

	//////////////////////////////////////////////
	private Connection getConnection () throws SQLException
	{
		/*if (_htConnProp == null)
			return null;

		String driver = (String)_htConnProp.get ("driver");
		String url = (String)_htConnProp.get ("url");
		String user = (String)_htConnProp.get ("username");
		String password = (String)_htConnProp.get("password");
        
		Connection connection = null;

		// load the driver, if it is not loaded
		try
		{
			Class.forName(driver);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		// Get the connection to the database
		try
		{
			connection =
				DriverManager.getConnection(url, user, password);

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return connection;*/
        return ConnectionPool.getConnection();
	}

    @Override
    public String getUserId() throws LoginException {
        if(bOK == true)
            return _id;
        throw new LoginException();
    }
    @Override
    public String getTipoUtente() throws LoginException {
        if(bOK == true)
            return _tipo;
        throw new LoginException();
    }
}
