/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.application.bean.tabelle;

import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;
import it.seerp.application.applicazione.AppGestioneExtraAzienda;

/**
 *
 * @author Luisa
 */
public class FornitoreTm extends Generica<Fornitore> {

    private JTable table;

    /**
     *
     * @throws java.sql.SQLException
     */
    public FornitoreTm() throws SQLException {
        Object[] list = new Object[]{
            "Id",
            "Ragione sociale",
            "Username"
        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(3);

        refresh();
    }

    public void refresh() throws SQLException {
        AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
        Iterator<Fornitore> it = op.visualizzaTabellaFornitore().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }
    }

    @Override
    public Fornitore newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void modifyArrayObjectData(Fornitore element, Object aValue, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateData(Fornitore c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    protected Vector creaArrayObjectData(Fornitore o) {
        Vector c = new Vector();
        c.add(o.getIdUtente());
        c.add(o.getRagioneSociale());
        c.add(o.getUsername());


        return c;
    }
}
