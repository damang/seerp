/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean.tabelle;

import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import it.seerp.application.applicazione.AppGestionePersonale;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class ResponsabileTm extends Generica <Responsabile>{
 private JTable table;

 /**
  *
  * @throws java.sql.SQLException
  * @throws java.sql.SQLException
  */
 public ResponsabileTm() throws SQLException, SQLException {
        Object[] list = new Object[]{
            "Id",
            "Username",
            "Ruolo"

        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(3);
          refresh();


    }
 public void refresh() throws SQLException{
        AppGestionePersonale op = new AppGestionePersonale();
        Iterator<Responsabile> it = op.visualizzaTabellaResponsabili().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }}
  
    public boolean isCellEditable(int row, int column) {
        return false;
    }



    @Override
    protected Vector creaArrayObjectData(Responsabile o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getUsername());
        c.add(o.getRuolo().getNome());
   


        return c;
    }

    @Override
    protected void modifyArrayObjectData(Responsabile element, Object aValue, int column) {
Responsabile p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Responsabile c, int indice) {

    }

    @Override
    public Responsabile newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
