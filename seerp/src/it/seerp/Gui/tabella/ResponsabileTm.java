/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;

import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
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
            "id",
            "nome",
            "cognome",
            "Data Di Nasciata",

        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(6);

       // AppGestionePersonale op = new AppGestionePersonale();
        /*Iterator<Responsabile> it = op.visualizzaResponsabili().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    /**
     *
     * @param table
     * @throws SQLException
     */
    public ResponsabileTm(JTable table) throws SQLException {
        this.table = table;
        Object[] list = new Object[]{
            "id",
            "nome",
            "cognome",
            "Data Di Nasciata",

        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(5);

       /* AppGestionePersonale op = new AppGestionePersonale();
        Iterator<Responsabile> it = op.visualizzaResponsabili().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
     }*/
    }
    public boolean isCellEditable(int row, int column) {
        return false;
    }



    @Override
    protected Vector creaArrayObjectData(Responsabile o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getNome());
        c.add(o.getCognome());
        c.add(o.getEmail());


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
