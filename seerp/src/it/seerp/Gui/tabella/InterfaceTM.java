/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.tabella;

import java.util.Vector;

/**
 *
 * @author Luisa
 */
public interface InterfaceTM <E> {
 /**
     * Ritorna la lista degli oggetti memorizzati nella <code>JTableModel</code>
     * @return ritorna una collezione degli oggetti memorizzati nella table model
     */


    public Vector<E> getDataCollection();

    /**
     * Setta la lista degli oggetti contenuti nella <code>JTableModel</code>
     * @param miaLista
     */
    public void setDataCollection(Vector<E> miaLista);

    /**
     * Aggiungi un nuovo oggetto nella tabella
     * @param oggetto oggetto specifico che si vuole aggiungere
     */
    public void addNewData(E oggetto);

    /**
     * imposta un valore di un valore contenuto nell'oggetto
     *
     * @param aValue nuovo valore che si vuole assegnare alle coordinate indicanti
     * @param row numero di riga nella tabella
     * @param column numero di colonna nella tabella
     */
    public void setValueAt(Object aValue, int row, int column);

    /**
     * Rimuove riga
     * @param row indice della riga da rimuovere
     */
    public void removeRow(int row);


    /**
     * permette di specificare se una determinata cella è editabile o no
     * @param row indice della riga
     * @param column indice della colonna
     * @return ritorna <b>true</b> se la cella è editabile,  <b>false</b> altrimenti
     */
    public boolean isCellEditable(int row, int column);

}
