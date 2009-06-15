/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;

import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class RuoloTm extends Generica<Ruolo> {
 private JTable table;

    public RuoloTm() throws SQLException {
        Object[] list = new Object[]{ "nome" };

        super.setColumnIdentifiers(list);
        //super.setColumnCount(1);

       // AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
       /* Iterator<Cliente> it = op.visualizzaClienti().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    /**
     *
     * @param table
     */
    public RuoloTm(JTable table) throws SQLException {
        this();
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Ruolo newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Vector creaArrayObjectData(Ruolo o) {
        Vector c = new Vector();
        c.add(o.getNome());
        return c;
    }

    @Override
    protected void modifyArrayObjectData(Ruolo element, Object aValue, int column) {
        Ruolo p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Ruolo c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
