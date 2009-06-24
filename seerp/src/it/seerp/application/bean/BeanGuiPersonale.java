package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotAlphabeticValidator;
import it.seerp.application.validation.NotEmptyValidator;
import it.seerp.application.validation.NotEqualLengthValidator;
import javax.swing.JPanel;
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
     *
     */
    public BeanGuiPersonale() {
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiPersonale(JPanel c) {
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
        if (!codiceFiscale.getInputVerifier().shouldYieldFocus(codiceFiscale)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!codiceFiscale.getInputVerifier().shouldYieldFocus(codiceFiscale)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return codiceFiscale;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getCognome() throws ValidatorException {
        if (!cognome.getInputVerifier().shouldYieldFocus(cognome)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!cognome.getInputVerifier().shouldYieldFocus(cognome)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return cognome;
    }

    /**
     *
     * @return
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return nome;
    }

    /**
     * 
     * @param pcodiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.codiceFiscale = pcodiceFiscale;
        codiceFiscale.setInputVerifier(new NotEmptyValidator((JPanel) grafica, codiceFiscale, "Il campo non può essere vuoto."));
        codiceFiscale.setInputVerifier(new NotEqualLengthValidator((JPanel) grafica, codiceFiscale, "Il campo deve essere di 16 caratteri", 16));

    }

    /**
     *
     * @param pcognome
     */
    public void setCognome(JTextField pcognome) {
        this.cognome = pcognome;
        cognome.setInputVerifier(new NotEmptyValidator((JPanel) grafica, cognome, "Il campo non può essere vuoto."));
        cognome.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica, cognome, "La stringa inserita deve essere alfabetica."));
    }

    /**
     *
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
       nome.setInputVerifier(new NotEmptyValidator((JPanel) grafica, nome, "Il campo non può essere vuoto."));
        nome.setInputVerifier(new NotAlphabeticValidator((JPanel) grafica, nome, "La stringa inserita deve essere alfabetica."));
    }
}
