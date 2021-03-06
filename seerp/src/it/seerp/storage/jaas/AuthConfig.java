/*
 * @author ghuang
 *
 * Create:5-Mar-2003
 *
 *
 * $Header$
 * $Log$
 */
package it.seerp.storage.jaas;

import java.io.*;

import java.util.*;


/**
 *
 * @author LesAnge
 */
public class AuthConfig implements Serializable
{
	
	private String _loginHandlerClass;
	private Hashtable _htLoginInitParam;
	private String _authznHandlerClass;
	private Hashtable _htAuthznInitParam;
	private boolean _bLoaded = false;


	private static AuthConfig _instance;

    /**
     *
     * @return
     */
    public static AuthConfig getInstance()
	{
		if (_instance == null)
			_instance = new AuthConfig();
		return _instance;
	}

	private AuthConfig()
	{

	}

    /**
     *
     * @param handler
     */
    public void setLoginHandlerClassName(String handler)
	{
		_loginHandlerClass = handler;
	}

    /**
     *
     * @return
     */
    public String getLoginHandlerClassName()
	{
		return _loginHandlerClass;
	}

    /**
     *
     * @param key
     * @param value
     */
    public void addLoginInitParam(String key, Object value)
	{
		if (_htLoginInitParam == null)
			_htLoginInitParam = new Hashtable ();
		_htLoginInitParam.put(key, value);
	}

    /**
     *
     * @return
     */
    public Hashtable getLoginInitParam()
	{
		return _htLoginInitParam;
	}

    /**
     *
     * @param handler
     */
    public void setAuthznHandlerClassName(String handler)
	{
		_authznHandlerClass = handler;
	}

    /**
     *
     * @return
     */
    public String getAuthznHandlerClassName()
	{
		return _authznHandlerClass;
	}

    /**
     *
     * @param key
     * @param value
     */
    public void addAuthznInitParam(String key, Object value)
	{
		if (_htAuthznInitParam == null)
			_htAuthznInitParam = new Hashtable();
		_htAuthznInitParam.put (key, value);
	}

    /**
     *
     * @return
     */
    public Hashtable getAuthznInitParam()
	{
		return _htAuthznInitParam;
	}

    /**
     *
     * @return
     */
    public boolean isLoaded()
	{
		return _bLoaded;
	}

    /**
     *
     * @param file
     * @throws java.io.IOException
     */
    public void load(String file) throws IOException
	{
		
		//System.out.println("load config:" + file);
		FileInputStream in = new FileInputStream (file);
		load (in);
	}

    /**
     *
     * @param in
     * @throws java.io.IOException
     */
    public void load(InputStream in) throws IOException
	{
		try
		{
			build(in);
			_bLoaded = true;
		}
		catch (Exception aec)
		{
			aec.printStackTrace();
			throw new IOException (aec.getMessage());
		}
	}

	private String checkFile (String file)
	{
		File f = new File (file);
		if (f.exists())
			return file;
		else
			return file;
	}
	private void build(InputStream in) throws IOException
	{
		 Properties prop = new Properties ();
         InputStream is;
         try {
                    //leggo i nomi delle classi
                    is = in;//(FileInputStream)   //new FileInputStream("jaasutil_config.properties");
                    prop.load(is);
                    _loginHandlerClass=prop.getProperty("authentication");
                    _authznHandlerClass=prop.getProperty("authorization");
                 /*   //carico i paramtri di input del db
                    is = new FileInputStream("file_config\\database.properties");
                    Properties p2=new Properties();
                    p2.load(is);
                    _htLoginInitParam=p2;
                    _htAuthznInitParam=(Properties) p2.clone();*/
          }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
	}

}
