package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.Gui.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione del Contratto
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
    private Object grafica;
    public boolean validator = false;

    public boolean isValidator() {
        return validator;
    }

    public void setValidator(boolean validator) {
        this.validator = validator;
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiContratto(Object c) {
        grafica = c;
    }

    public BeanGuiContratto() {
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
    public JTextField getData() throws ValidatorException {
        if (validator == true) {
            if (!data.getInputVerifier().shouldYieldFocus(data)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return data;
    }

    /**
     * metodo che setta il campo data di stipula di un Contratto
     * @param data rappresenta il campo data di stipula da inserire
     */
    public void setData(JTextField data) {
        data.setInputVerifier(new NotEmptyValidator(grafica, data, "Il formato data deve essere GG/MM/AAAA.", RegexpDef.valueOf(RegexpDef.VAL.DATA)));
        this.data = data;
    }

    /**
     *
     * @return
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
        if (validator == true) {
            if (!durata.getInputVerifier().shouldYieldFocus(durata)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return durata;
    }

    /**
     * metodo che setta il campo durata del Contratto
     * @param pdurata rappresenta il campo durata  da inserire
     */
    public void setDurata(JTextField pdurata) {
        this.durata = pdurata;
        durata.setInputVerifier(new NotEmptyValidator(grafica, durata, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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
        if (validator == true) {
            if (!tipo.getInputVerifier().shouldYieldFocus(tipo)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return tipo;
    }

    /**
     * metodo che setta il campo tipo di un Contratto
     * @param ptipo rappresenta il campo tipo da inserire
     */
    public void setTipo(JTextField ptipo) {
        this.tipo = ptipo;
        tipo.setInputVerifier(new NotEmptyValidator(grafica, tipo, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
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
