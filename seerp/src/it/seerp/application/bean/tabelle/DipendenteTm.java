/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean.tabelle;


import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.application.applicazione.AppGestionePersonale;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class DipendenteTm extends Generica <Dipendente>{
 

 /**
  *
  * @throws java.sql.SQLException
  */
 public DipendenteTm() throws SQLException {
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
        Iterator<Dipendente> it = op.visualizzaTabellaDipendenti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }}

    public boolean isCellEditable(int row, int column) {
        return false;
    }



    @Override
    protected Vector creaArrayObjectData(Dipendente o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getUsername());
        c.add(o.getRuolo().getNome());


        return c;
    }

    @Override
    protected void modifyArrayObjectData(Dipendente element, Object aValue, int column) {
    Dipendente p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Dipendente c, int indice) {
       
    }

    @Override
    public Dipendente newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
