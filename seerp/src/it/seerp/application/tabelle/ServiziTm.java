/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.application.tabelle;

import it.seerp.application.applicazione.AppServizi;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;

/**
 *
 * @author Luisa
 */
public class ServiziTm extends Generica<Servizio> {

    private JTable table;

    public ServiziTm() throws SQLException {
        Object[] list = new Object[]{
            "ID",
            "Descrizione",
            "Prezzo",
            "Quantita",};

        super.setColumnIdentifiers(list);
        super.setColumnCount(4);

        refresh();

    }

    public void refresh() throws SQLException{
        AppServizi op = new AppServizi();
        Iterator<Servizio> it = op.visualizzaTabella().iterator();

        while (it.hasNext()) {
            this.addNewData(it.next());
        }
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Servizio newData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected Vector creaArrayObjectData(Servizio o) {
        Vector c = new Vector();
        c.add(o.getIdServizio());
        c.add(o.getDescrizione());
        c.add(o.getPrezzo());
        c.add(o.getQuantita());



        return c;
    }

    @Override
    protected void modifyArrayObjectData(Servizio element, Object aValue, int column) {
        Servizio p = super.getDataCollection().get(column);
        p = element;
    }

    @Override
    public void updateData(Servizio c, int indice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
