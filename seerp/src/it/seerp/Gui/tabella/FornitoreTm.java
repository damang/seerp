/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;


import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTable;


/**
 *
 * @author Luisa
 */
public class FornitoreTm extends Generica <Fornitore>{
 private JTable table;

    public FornitoreTm() throws SQLException {
        Object[] list = new Object[]{
            "id",
            "p.iva",
            "nome aziwnda",
            "provincia",

        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(6);

     /*   AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
        Iterator<Fornitore> it = op.visualizzaFornitori().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
    }

    /**
     *
     * @param table
     */
    public FornitoreTm(JTable table) throws SQLException {
        this.table = table;
        Object[] list = new Object[]{
            "id",
            "ragione Sociale",
            "nome",
            "cognome",
        };

        super.setColumnIdentifiers(list);
        super.setColumnCount(5);

/*           AppGestioneExtraAzienda op = new AppGestioneExtraAzienda();
        Iterator<Fornitore> it = op.visualizzaFornitori().iterator();
        while (it.hasNext()) {
            this.addNewData(it.next());
        }*/
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
        c.add(o.getIdFornitore());
        c.add(o.getPIva());
        c.add(o.getRagioneSociale());
        c.add(o.getProvincia());


        return c;
    }








}
