/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.jaas;

import it.seerp.storage.jaas.*;
import java.util.Iterator;
import javax.security.auth.Subject;

/**
 *
 * @author peppe
 */
public class SujGest {
       public static int getIdUtente(Subject s){
        Iterator<AuthPrincipal> it = s.getPrincipals(AuthPrincipal.class).iterator();
        AuthPrincipal p = new AuthPrincipal("id");
        AuthPrincipal i=null;
        while (it.hasNext()) {
            i=it.next();
            if(i.equals(p))
                return Integer.parseInt(i.getName());
        }
        return -1;
       }
       public static String getUsername(Subject s){
        Iterator<AuthPrincipal> it = s.getPrincipals(AuthPrincipal.class).iterator();
        AuthPrincipal p = new AuthPrincipal("username");
        AuthPrincipal i=null;
        while (it.hasNext()) {
            i=it.next();
            if(i.equals(p))
                return i.getName();
        }
        return null;
       }
       public static String getRuoloUtente(Subject s){
        Iterator<AuthPrincipal> it = s.getPrincipals(AuthPrincipal.class).iterator();
        AuthPrincipal p = new AuthPrincipal("ruolo");
        AuthPrincipal i=null;
        while (it.hasNext()) {
            i=it.next();
            if(i.equals(p))
                return i.getName();
        }
        return null;
       }
       public static String getTipoUtente(Subject s){
        Iterator<AuthPrincipal> it = s.getPrincipals(AuthPrincipal.class).iterator();
        AuthPrincipal p = new AuthPrincipal("tipo");
        AuthPrincipal i=null;
        while (it.hasNext()) {
            i=it.next();
            if(i.equals(p))
                return i.getName();
        }
        return null;
       }
}
