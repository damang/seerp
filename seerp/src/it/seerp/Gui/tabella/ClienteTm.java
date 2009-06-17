/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;

import it.seerp.storage.ejb.Cliente;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class ClienteTm extends Generica <Cliente>{
 private JTable table;

 /**
  *
  * @throws java.sql.SQLException
  */
 public ClienteTm() throws SQLException {
        Object[] list = new Object[]{
            "id",
            "ragione Sociale",
            "nome",
            "cognome",
           
        };

        super.setColumnIdentifiers(list);
      //  super.setColumnCount(5);

       // AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
       /* Iterator<Cliente> it = op.visualizzaClienti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    /**
     *
     * @param table
     * @throws SQLException
     */
    public ClienteTm(JTable table) throws SQLException {
        this.table = table;
        Object[] list = new Object[]{
            "id",
            "ragione Sociale",
            "nome",
            "cognome",
        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(4);

       // AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
       /* Iterator<Cliente> it = op.visualizzaClienti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Cliente newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Vector creaArrayObjectData(Cliente o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getRagioneSociale());
        c.add(o.getNome());
        c.add(o.getCognome());
    

        return c;
    }

    @Override
    protected void modifyArrayObjectData(Cliente element, Object aValue, int column) {
        Cliente p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Cliente c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
