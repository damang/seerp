package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione del Personale
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiPersonale extends BeanGuiUtente {

    private JTextField cognome;
    private JTextField nome;
    private JTextField codiceFiscale;
    private JTextField ruolo;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiPersonale(Object c) {
        super(c);
    }

    /**
     *
     * @return
     */
    public JTextField getRuolo() {
        return ruolo;
    }

    /**
     *
     * @param ruolo
     */
    public void setRuolo(JTextField ruolo) {
        this.ruolo = ruolo;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getCodiceFiscale() throws ValidatorException {
        if (validator == true) {
            if (!codiceFiscale.getInputVerifier().shouldYieldFocus(codiceFiscale)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return codiceFiscale;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getCognome() throws ValidatorException {
        if (validator == true) {
            if (!cognome.getInputVerifier().shouldYieldFocus(cognome)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return cognome;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (validator == true) {
            if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
                throw new ValidatorException("Errore nella grafica!");
            }
        }
        return nome;
    }

    /**
     * 
     * @param pcodiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.codiceFiscale = pcodiceFiscale;
        codiceFiscale.setInputVerifier(new NotEmptyValidator(grafica, codiceFiscale, "Il campo non può essere vuoto.", "")); //espressione
    }

    /**
     *
     * @param pcognome
     */
    public void setCognome(JTextField pcognome) {
        this.cognome = pcognome;
        cognome.setInputVerifier(new NotEmptyValidator(grafica, cognome, "Il campo non può essere vuoto.", "")); //espressione
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        nome.setInputVerifier(new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.", "")); //espressione
    }
}
