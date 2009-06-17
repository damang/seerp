/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;


import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class DipendenteTm extends Generica <Dipendente>{
 private JTable table;

 /**
  *
  * @throws java.sql.SQLException
  */
 public DipendenteTm() throws SQLException {
        Object[] list = new Object[]{
            "id",
            "nome",
            "cognome",
            "Data Di Nasciata",

        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(4);

       /* AppGestionePersonale op = new AppGestionePersonale();
        Iterator<Dipendente> it = op.visualizzaDipedenti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    /**
     *
     * @param table
     * @throws SQLException
     */
    public DipendenteTm(JTable table) throws SQLException {
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
        Iterator<Dipendente> it = op.visualizzaDipedenti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }



    @Override
    protected Vector creaArrayObjectData(Dipendente o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getNome());
        c.add(o.getCognome());
        c.add(o.getEmail());


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
