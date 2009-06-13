/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;

import java.util.Collection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luisa
 */
public abstract class Generica<E> extends DefaultTableModel implements InterfaceTM<E> {

    private Vector<E> listaDati;

    /**
     * Costruttore
     */
    public Generica() {
        listaDati = new Vector<E>();
    }

    public Vector<E> getDataCollection() {
        return this.listaDati;
    }

    public void setDataCollection(Vector<E> miaLista) {
        this.listaDati = miaLista;
    }

    /**
     *
     * @param i
     * @return
     */
    public E getData(int i) {
        return this.listaDati.get(i);
    }

    /**
     *
     * @return
     */
    public abstract E newData();

    public void addNewData(E oggetto) {
   
        boolean add = this.listaDati.add(oggetto);
        Vector lis = creaArrayObjectData(oggetto);
        this.addRow(lis);
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
//        Vector rowVector = creaArrayObjectData( listaDati.get(row) );
//        rowVector.setElementAt(aValue, column);
        E element = this.listaDati.get(row);

        modifyArrayObjectData(element, aValue, column);
    }

    @Override
    public void removeRow(int row) {
        this.listaDati.removeElementAt(row);
        super.removeRow(row);
    }

    /**
     *
     * @param row
     * @return
     */
    public E getSelectedSede(int row) {
        return this.listaDati.get(row);
    }

    /**
     *
     * @param object
     * @return
     */
    protected abstract Vector creaArrayObjectData(E object);

    /**
     *
     * @param element
     * @param aValue
     * @param column
     */
    protected abstract void modifyArrayObjectData(E element, Object aValue, int column);

    /**
     *
     * @param c
     * @param indice
     */
    public abstract void updateData(E c, int indice);


    /**
     *
     * @param lista
     * @param o
     * @return
     */
    public boolean ceckData(Collection<E> lista, E o){
        return true;
    }




}
