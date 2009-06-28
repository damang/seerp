/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.application.bean.tabelle;

import it.seerp.application.applicazione.AppGestioneExtraAzienda;
import it.seerp.application.applicazione.AppGestionePersonale;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class PersonaleTm extends Generica<Personale> {
    private Ruolo r;
   
    /**
     *
     * @throws java.sql.SQLException
     */
    public PersonaleTm() throws SQLException {
        Object[] list = new Object[]{"id","Cognome", "Nome","Tipo"};
        super.setColumnIdentifiers(list);
        super.setColumnCount(4);
        //refresh();
    }
     public PersonaleTm(Ruolo r) throws SQLException {
         this.r=r;
         Object[] list = new Object[]{"id","Cognome", "Nome","Tipo"};
         super.setColumnIdentifiers(list);
         super.setColumnCount(4);
         refreshRuolo();
    }

    public void refresh() throws SQLException {
        AppGestionePersonale op = new AppGestionePersonale();
        Iterator<Personale> it = op.visualizzaTabellaPersonale().iterator();
       while (it.hasNext()) {
           this.addNewData(it.next());
        }
    }
    public void refreshRuolo() throws SQLException {
        AppGestionePersonale op = new AppGestionePersonale();
        Iterator<Personale> it = op.visualizzaTabellaPersonaleRuolo(r).iterator();
       while (it.hasNext()) {
           this.addNewData(it.next());
        }
    }




    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Personale newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Vector creaArrayObjectData(Personale o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getCognome());
        c.add(o.getNome());
        c.add(o.getTipo());
        return c;
    }

    @Override
    protected void modifyArrayObjectData(Personale element, Object aValue, int column) {
        Personale p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Personale c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
