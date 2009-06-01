/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.Operazioni;

import it.seerp.storage.db.OpeEntity;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * la classe storage che si occupa di interfacciarsi con il dbms e compiere operazioni sui servizi
 * @author Luisa
 */
public class OpeServizio implements OpeEntity<Servizio, Integer> {

    public void inserimento(Servizio Bean) throws SQLException {
       
    }

    /**
     * metodo che si occupa di ricercare un servoizio in base al nome
     * @param nome del servizio
     * @return lista di servizi che rispettano i oarametri di ricerca
     * @throws java.sql.SQLException
     */
    public ArrayList<Servizio> ricercaPerNome(Integer nome)throws SQLException{
           throw new UnsupportedOperationException("Not supported yet.");};
              /**
     * metodo che si occupa di modificare un servizio in base al contenuto di bean
     * @param servizio parametro  che contiene le informazioni da modificare
     * @return servizio modificato
     * @throws java.sql.SQLException
     */

    public Servizio modifica(Servizio servizio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
              /**
     * metodo che si occupa di ricercare un servoizio in base all'identificativo
     * @param nome identificativo del servizio e prametro di ricerca
     * @return servizio che corrisponde a quell'identificativo
     * @throws java.sql.SQLException
     */
    public Servizio visualizza(Integer nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
           /**
     * metodo che si occupa di ricercare tutti i servizi
     * @return lista dei servizi contenuti nel database
     * @throws java.sql.SQLException
     */
    public ArrayList<Servizio> visualizzaElenco() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
