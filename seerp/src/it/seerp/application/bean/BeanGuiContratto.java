package it.seerp.application.bean;

import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotMinNumberValidator;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiContratto {

    private JTextField stato;
    private JTextField data;
    private JTextField durata;
    private JTextField tipo;
    private JTextArea note;
    private JTextField idContratto;
    private JTextField dipendente;
    private JTextField extraAzienda;
    private ArrayList<BeanGuiPagamento> listPagamento;
    private ArrayList<BeanGuiServizio> listServizio;
    private JXPanel grafica;
    private NotEmptyValidator val;
    private NotMinNumberValidator valMinNum;
    private NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiContratto(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore vuoto per la classe Bean Gui Contratto
     */
    public BeanGuiContratto() {
    }

    /**
     * Costruttore per la classe Bean Gui Contratto
     * @param stato
     * @param data
     * @param durata
     * @param tipo
     * @param idContratto
     * @param note
     * @param dipendente
     * @param extraAzienda
     */
    public BeanGuiContratto(JTextField stato, JTextField data, JTextField durata, JTextField tipo, JTextField idContratto, JTextArea note, JTextField dipendente, JTextField extraAzienda) {
        this.stato = stato;
        this.data = data;
        this.durata = durata;
        this.tipo = tipo;
        this.idContratto = idContratto;
        this.note = note;
        this.dipendente = dipendente;
        this.extraAzienda = extraAzienda;
    }

    /**
     *  metodo che restituisce la lista dei pagamenti relativi ad un Contratto
     * @return la lista di pagamenti
     */
    public ArrayList<BeanGuiPagamento> getListPagamento() {
        return listPagamento;
    }

    /**
     * metodo che setta la lista dei pagamenti relativi ad un Contratto
     * @param listPagamento rappresenta la lista di pagamenti da inserire
     */
    public void setListPagamento(ArrayList<BeanGuiPagamento> listPagamento) {
        this.listPagamento = listPagamento;
    }

    /**
     * metodo che restituisce la lista dei servizi associati ad un Contratto
     * @return la lista dei servizi
     */
    public ArrayList<BeanGuiServizio> getListServizio() {
        return listServizio;
    }

    /**
     * metodo che setta la lista dei servizi di un Contratto
     * @param listServizio rappresenta la lista dei servizi da inserire
     */
    public void setListServizio(ArrayList<BeanGuiServizio> listServizio) {
        this.listServizio = listServizio;
    }

    /**
     * metodo che restituisce il campo contenente la data di stipula di un Contratto
     * @return la il campo data di stipula
     */
    public JTextField getData() {
        return data;
    }

    /**
     * metodo che setta il campo data di stipula di un Contratto
     * @param data rappresenta il campo data di stipula da inserire
     */
    public void setData(JTextField data) {
        this.data = data;
    }

    /**
     *  metodo che restituisce il campo contenente l'id del Dipendente
     *  che ha stipulato il Contratto
     * @return il campo id del Dipendente
     */
    public JTextField getDipendente() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return dipendente;
    }

    /**
     * metodo che setta il campo id del Dipendente che ha stipulato il Contratto
     * @param pdipendente rappresenta il campo id del Dipendente  da inserire
     */
    public void setDipendente(JTextField pdipendente) {
        this.dipendente = pdipendente;
        val = new NotEmptyValidator(grafica, dipendente, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, dipendente, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     * metodo che restituisce il campo contenente la durata di un Contratto
     * @return il campo durata del Contratto
     */
    public JTextField getDurata() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return durata;
    }

    /**
     * metodo che setta il campo durata del Contratto
     * @param pdurata rappresenta il campo durata  da inserire
     */
    public void setDurata(JTextField pdurata) {
        this.durata = pdurata;
        val = new NotEmptyValidator(grafica, durata, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente l'id dell'ExtraAzienda con
     * cui è stato stipulato il Contratto
     * @return il campo id dell'ExtraAzienda
     */
    public JTextField getExtraAzienda() {
        return extraAzienda;
    }

    /**
     * metodo che setta il campo id dell'ExtraAzienda
     * con cui è stato stipulato il Contratto
     * @param extraAzienda rappresenta il campo id da inserire
     */
    public void setExtraAzienda(JTextField extraAzienda) {
        this.extraAzienda = extraAzienda;
    }

    /**
     * metodo che setta il campo id del Contratto
     * @return il campo id del Contratto
     */
    public JTextField getIdContratto() {
        return idContratto;
    }

    /**
     * metodo che setta il campo id del Contratto
     * @param idContratto rappresenta il campo id del Contratto da inserire
     */
    public void setIdContratto(JTextField idContratto) {
        this.idContratto = idContratto;
    }

    /**
     * metodo che restituisce il campo contenente le note di un Contratto
     * @return il campo note
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note di un Contratto
     * @param note rappresenta il campo note da inserire
     */
    public void setNote(JTextArea note) {
        this.note = note;
    }

    /**
     * metodo che restituisce il campo contenente lo stato di un Contratto
     * @return il campo stato di un Contratto
     */
    public JTextField getStato() {
        return stato;
    }

    /**
     * metodo che setta il campo stato di un Contratto
     * @param stato rappresenta il campo stato da inserire
     */
    public void setStato(JTextField stato) {
        this.stato = stato;
    }

    /**
     * metodo che restituisce il campo contente il tipo di Contratto
     * @return il campo tipo
     */
    public JTextField getTipo() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return tipo;
    }

    /**
     * metodo che setta il campo tipo di un Contratto
     * @param ptipo rappresenta il campo tipo da inserire
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        val = new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
        valApha = new NotAlphabeticValidator(grafica, tipo, "La stringa inserita deve essere alfabetica.");
        grafica.setInputVerifier(valApha);
    }

    /**
     * metodo che permette di eliminare un pagamento dalla lista dei pagamenti
     * @param p rappresenta un pagamento da eliminare
     */
    public void removePagamento(BeanGuiPagamento p) {
        listPagamento.remove(p);
    }

    /**
     * metodo che permette di inserire un pagamento nella lista dei pagamenti
     * @param p rappresenta il pagamento da inserire
     */
    public void addPagamento(BeanGuiPagamento p) {
        listPagamento.add(p);
    }

    /**
     * metodo che permette di rimuovere un servizio dalla lista dei servizi
     * @param s rapprensenta il servizio che si vuole eliminare
     */
    public void removeServzio(BeanGuiServizio s) {
        listServizio.remove(s);
    }

    /**
     * metodo che permetted i inserire un servizio nella lista dei servizi
     * @param s rappresenta il servizio che si vuole inserire
     */
    public void addPagamento(BeanGuiServizio s) {
        listServizio.add(s);
    }
}
