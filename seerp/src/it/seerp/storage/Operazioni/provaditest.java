/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.operazioni;

import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.ejb.Evento;
import java.awt.image.DataBuffer;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ila
 */
public class provaditest {
       public static void main(String []args){
        try {
            OpeEvento op = new OpeEvento();
            Date d = new Date(2009,12,12);
            Time t = new Time(3,12,34);
              System.out.println("Prova");
            Evento e = new Evento("Fisciano", "boh", "note", "boh2",d,t, 1, 1, false);
            op.inserimento(e);
            //op.ricercaEvento("ERasmo");
        } catch (Exception e){
            e.printStackTrace();
        }
       }
}
