/**
 * AuthLoginModule.java
 *
 * @author ghuang
 *
 * Create:5-Mar-2003
 *
 * $Header$
 * $Log$
 */

package it.seerp.storage.jaas;

import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.*;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.callback.*;
import javax.swing.JOptionPane;


/**
 *
 * @author LesAnge
 */
public class AuthLoginModule implements LoginModule
{
	private Subject _subject;
	private CallbackHandler _cbHandler;
	private Map _sharedState;
	private Map _options;
	private String _userId;
	private char[] _password;
	private boolean _loginOK = false;
	private boolean _commitOK = false;
	//private boolean _debug = false;
	private LoginSourceAdapter _adapter;

	/**
	 * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject, javax.security.auth.callback.CallbackHandler, java.util.Map, java.util.Map)
	 */
	public void initialize(Subject subject, CallbackHandler callbackHandler,
								Map sharedState, Map options)
	{
		_subject = subject;
		_cbHandler = callbackHandler;
		_sharedState = sharedState;
		_options = options;

		// initialize configuration options
		//_debug = "true".equalsIgnoreCase((String) options.get("debug"));

	}

	/**
     * @throws LoginException
     * @see javax.security.auth.spi.LoginModule#login()
	 */
	public boolean login() throws LoginException
	{
		if (Debug.DEBUG)
			Debug.trace("UserLoginModule::login");
		if (_cbHandler == null)
			throw new LoginException("ERROR: CallbackHandler cannot be null");
           
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("userid: ");
		callbacks[1] = new PasswordCallback("password: ", false);

		try
		{
			_cbHandler.handle(callbacks);
			_userId = ((NameCallback) callbacks[0]).getName();
			char[] tmpPassword = ((PasswordCallback) callbacks[1]).getPassword();

			if (tmpPassword == null)
			{
				// treat a NULL password as an empty password
				tmpPassword = new char[0];
			}
			_password = new char[tmpPassword.length];
			System.arraycopy(tmpPassword, 0, _password, 0, tmpPassword.length);
			((PasswordCallback) callbacks[1]).clearPassword();

		}
		catch (java.io.IOException e)
		{
			throw new LoginException(e.getMessage());
		}
		catch (UnsupportedCallbackException e)
		{
			throw new LoginException("Error: " + e.getMessage());
		}

		//now validate user
        
		if (validate(_userId, _password))
		{
			_loginOK = true;
		}
		else
		{
			_loginOK = false;
			// clear the values
			_userId = null;
			_password = null;
			throw new FailedLoginException("Invalid userid or password");
		}


		return _loginOK;
	}

	/**
     * @throws LoginException
     * @see javax.security.auth.spi.LoginModule#commit()
	 */
	public boolean commit() throws LoginException
	{
		if (Debug.DEBUG)
			Debug.trace("AuthLoginModule::commit");
			
		if(_loginOK == false)
			return false;
       
        _subject.getPrincipals().add(new AuthPrincipal(_userId,"username"));
        _subject.getPrincipals().add(new AuthPrincipal(getUserGroup(),"ruolo"));
        _subject.getPrincipals().add(new AuthPrincipal(getUserId(),"id"));
		_subject.getPrincipals().add(new AuthPrincipal(getTipoUtente(),"tipo"));
		_userId = null;
		_password = null;

		_commitOK = true;
		return true;
	}

	/**
     * @throws LoginException
     * @see javax.security.auth.spi.LoginModule#abort()
	 */
	public boolean abort() throws LoginException
	{
		if (_loginOK == false)
			return false;

		if(_loginOK == true && _commitOK == false)
		{
			// login succeeded but overall authentication failed
			_loginOK = false;
			_userId = null;
			_password = null;
		}
		else
		{
			// overall authentication succeeded and commit
			// succeeded, but someone else's commit failed.
			logout();
		}

		return true;
	}

	/**
     * @throws LoginException
     * @see javax.security.auth.spi.LoginModule#logout()
	 */
	public boolean logout() throws LoginException
	{
		_subject.getPrincipals().clear();
		_loginOK = false;
		_commitOK = false;
		_userId = null;
		_password = null;

		if (_adapter != null)
			_adapter.terminate ();
		_adapter = null;

		return true;
	}

	private boolean validate (String user, char[] password)
	{
		//access to database table using user and get password
		if (Debug.DEBUG)
			Debug.trace("validate: user="+ user + ", password=" + new String(password));

		boolean bOK = false;
		_adapter = LoginSourceAdapterFactory.getLoginAdapter();
		if (_adapter != null)
		{
			bOK = _adapter.authenticate (user, password);
		}

		return bOK;
	}

	private String getUserGroup()
	{
		//access data base table using userId, get the groups this user belongs to
		//suppose return String[]
		String groupName = null;

		if (_adapter != null)
			try {
            groupName = _adapter.getGroupName();
        } catch (LoginException ex) {
            return null;
        }
		if (groupName == null)
			return null;
		return groupName;
	}
    private String getUserId()
	{
		//access data base table using userId, get the groups this user belongs to
		//suppose return String[]
		String id = null;

		if (_adapter != null)
			try {
            id = _adapter.getUserId();
        } catch (LoginException ex) {
            return null;
        }
		if (id == null)
			return null;
		return id;
	}
     private String getTipoUtente()
	{
	
		String tipo = null;

		if (_adapter != null)
			try {
            tipo = _adapter.getTipoUtente();
        } catch (LoginException ex) {
            return null;
        }
		if (tipo == null)
			return null;
		return tipo;
	}
}
