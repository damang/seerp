package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
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
    private BeanGuiDipendente dipendente;
    private BeanGuiExtraAzienda extraAzienda;
    private ArrayList<BeanGuiPagamento> listPagamento;
    private ArrayList<BeanGuiServizioAssociato> listServizio;
    private ArrayList<BeanGuiFattura> listFatture;
    private JXPanel grafica;
    private NotEmptyValidator val;
    private NotMinNumberValidator valMinNum;
    private NotAlphabeticValidator valApha;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
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
     */
    public BeanGuiContratto(JTextField stato, JTextField data, JTextField durata, JTextField tipo, JTextField idContratto, JTextArea note) {
        this.stato = stato;
        this.data = data;
        this.durata = durata;
        this.tipo = tipo;
        this.idContratto = idContratto;
        this.note = note;
        this.listFatture = new ArrayList<BeanGuiFattura>();
        this.listPagamento = new ArrayList<BeanGuiPagamento>();
        this.listServizio = new ArrayList<BeanGuiServizioAssociato>();

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
    public ArrayList<BeanGuiServizioAssociato> getListServizio() {
        return listServizio;
    }

    /**
     * metodo che setta la lista dei servizi di un Contratto
     * @param listServizio rappresenta la lista dei servizi da inserire
     */
    public void setListServizio(ArrayList<BeanGuiServizioAssociato> listServizio) {
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
     *
     * @return
     * @throws java.lang.Exception
     */
    public BeanGuiDipendente getDipendente() {

        return dipendente;
    }

    /**
     *
     * @param pdipendente
     */
    public void setDipendente(BeanGuiDipendente pdipendente) {
        this.dipendente = pdipendente;

    }

    /**
     * metodo che restituisce il campo contenente la durata di un Contratto
     * @return il campo durata del Contratto
     * @throws ValidatorException
     */
    public JTextField getDurata() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
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
     *
     * @return
     */
    public BeanGuiExtraAzienda getExtraAzienda() {
        return extraAzienda;
    }

    /**
     *
     * @param extraAzienda
     */
    public void setExtraAzienda(BeanGuiExtraAzienda extraAzienda) {
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
     * @throws ValidatorException
     */
    public JTextField getTipo() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!valApha.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
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
     *
     * @param s
     */
    public void addServizio(BeanGuiServizioAssociato s) {
        listServizio.add(s);
    }

    /**
     *
     * @param s
     */
    public void removeServizio(BeanGuiServizioAssociato s) {
        listServizio.remove(s);
    }

    /**
     *
     * @param s
     */
    public void addFattura(BeanGuiFattura s) {
        listFatture.add(s);
    }

    /**
     *
     * @param s
     */
    public void removeFattura(BeanGuiFattura s) {
        listFatture.remove(s);
    }

    /**
     *
     * @return
     */
    public ArrayList<BeanGuiFattura> getListFatture() {
        return listFatture;
    }

    /**
     *
     * @param listFatture
     */
    public void setListFatture(ArrayList<BeanGuiFattura> listFatture) {
        this.listFatture = listFatture;
    }
}
