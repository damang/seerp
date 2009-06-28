/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.application.bean.tabelle;

import it.seerp.application.applicazione.AppContratti;
import it.seerp.application.applicazione.AppGestioneExtraAzienda;
import it.seerp.storage.ejb.Contratto;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class ContrattoTm extends Generica<Contratto> {

    private JTable table;

    /**
     *
     * @throws java.sql.SQLException
     */
    public ContrattoTm() throws SQLException {
        Object[] list = new Object[]{
            "id",
            "data",
            "durata",};

        super.setColumnIdentifiers(list);
        super.setColumnCount(3);

       // refresh();
    }

  /*  public void refresh() {
        AppContratti op = new AppContratti();
        Iterator<Contratto> it = op.visualizzaTabella().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }
    }*/

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    protected Vector creaArrayObjectData(Contratto o) {
        Vector c = new Vector();
        c.add(o.getIdContratto());
        c.add(o.getData());
        c.add(o.getDurata());


        return c;
    }

    @Override
    protected void modifyArrayObjectData(Contratto element, Object aValue, int column) {
        Contratto p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Contratto c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Contratto newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
