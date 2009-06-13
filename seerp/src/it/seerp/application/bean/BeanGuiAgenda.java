package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiAgenda {

    private ArrayList<BeanGuiEvento> listEventi = new ArrayList<BeanGuiEvento>();
    private JTextField idAgenda;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiAgenda(JXPanel c) {
        grafica = c;
    }

    /**
     *  costruttore per il Bean Gui
     * @param idAgenda
     * variabile che rappresenta l'identificatore dell'agenda
     */
    public BeanGuiAgenda(JTextField idAgenda) {
        this.idAgenda = idAgenda;
    }

    /**
     * metodo che permette di eliminare un Evento dalla lista degli Eventi
     * @param c rappresenta l'evento che deve essere eliminato
     */
    public void removeEvento(BeanGuiEvento c) {
        listEventi.remove(c);
    }

    /**
     *  metodo che permette di inserire un Evento nella lista degli Eventi
     * @param c rappresenta l'evento che si vuole inserire
     */
    public void addEvento(BeanGuiEvento c) {
        listEventi.add(c);
    }

    /**
     *  metodo che permette di prelevare la lista degli Eventi
     * @return rappresenta la lista degli eventi
     */
    public ArrayList<BeanGuiEvento> getArrEventi() {
        return listEventi;
    }

    /**
     * metodo che permette di settare la lista degli Eventi
     * @param arrEventi rappesenta la lista degli eventi
     */
    public void setArrEventi(ArrayList<BeanGuiEvento> arrEventi) {
        this.listEventi = arrEventi;
    }

    /**
     * metodo che restituisce l'id dell'agenda del campo associato
     * @return l'id dell'agenda
     */
    public JTextField getIdAgenda() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return idAgenda;
    }

    /**
     * metodi che permette di settare l'id dell'agenda nel campo associato
     * @param pidAgenda rappresenta l'id dell'agenda da inserire
     */
    public void setIdAgenda(JTextField pidAgenda) {
        this.idAgenda = pidAgenda;
        val = new NotEmptyValidator(grafica, idAgenda, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }
}
