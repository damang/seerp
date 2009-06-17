/*
 *Debug.java
 *
 *
 *
 *
 * @author ghuang
 *
 * Created on 2-May-2003
 *
 * $Header$
 * $Log$
 */
package it.seerp.storage.jaas;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 *
 * @author LesAnge
 */
public class Debug
{
    /**
     *
     */
    public static boolean DEBUG =false;//true;
	
    /**
     *
     * @param text
     */
    public static void trace(String text)
	{
		if (DEBUG)
			System.out.println(text);
	}
	
    /**
     *
     * @param ex
     */
    public static void log(Throwable ex)
	{
		System.out.println(getExceptionString(ex));		
	}
	
    /**
     *
     * @param except
     * @return
     */
    public static String getExceptionString(Throwable except)
	{
		StringWriter sw = new StringWriter ();
		PrintWriter pw = new PrintWriter (sw);
		except.printStackTrace (pw);
		return sw.toString();
	}
}
