package it.seerp.application.bean;

import it.seerp.Gui.configurazioni.Gui.RegexpDef;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione del Personale
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiPersonale extends BeanGuiUtente {

    private JTextField cognome;
    private JTextField nome;
    private JTextField codiceFiscale;
    private JComboBox ruolo;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiPersonale(Object c) {
        super(c);
    }

    /**
     * metodo che restituisce il campo ruolo del bean gui personale
     * @return il campo ruolo
     */
    public JComboBox getRuolo() {
        return ruolo;
    }

    /**
     * metodo che setta il campo ruolo del bean gui personale
     * @param ruolo
     */
    public void setRuolo(JComboBox ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * metodo che restituisce il campo codice fiscale del bean gui personale
     * @return il campo codice fiscale
     * @throws ValidatorException lanciata se il formato del codice fiscale non è valido
     */
    public JTextField getCodiceFiscale() throws ValidatorException {
        if (validator == true) {
            if (!codiceFiscale.getInputVerifier().shouldYieldFocus(codiceFiscale)) {
                throw new ValidatorException("Il CF deve essere di 16 caratteri");
            }
        }
        return codiceFiscale;
    }

    /**
     * metodo che restituisce il campo cognome del bean gui personale
     * @return il campo cognome
     * @throws ValidatorException lanciata se il formato del cognome non è valido
     */
    public JTextField getCognome() throws ValidatorException {
        if (validator == true) {
            if (!cognome.getInputVerifier().shouldYieldFocus(cognome)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return cognome;
    }

    /**
     * metodo che restituisce il campo nome del bean gui personale
     * @return il campo nome
     * @throws ValidatorException lancaiata se il formato del cognome non è valido
     */
    public JTextField getNome() throws ValidatorException {
        if (validator == true) {
            if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return nome;
    }

    /**
     * metodo che setta il campo codice fiscale del bean gui personale
     * @param pcodiceFiscale
     */
    public void setCodiceFiscale(JTextField pcodiceFiscale) {
        this.codiceFiscale = pcodiceFiscale;
        codiceFiscale.setInputVerifier(new NotEmptyValidator(grafica, codiceFiscale, "Il CF deve essere di 16 caratteri", RegexpDef.valueOf(RegexpDef.VAL.CODFIS)));
    }

    /**
     * metodo che setta il campo cognome del bean gui personale
     * @param pcognome
     */
    public void setCognome(JTextField pcognome) {
        this.cognome = pcognome;
        cognome.setInputVerifier(new NotEmptyValidator(grafica, cognome, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    /**
     * metodo che setta il campo note del bean gui personale
     * @param pnome
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        nome.setInputVerifier(new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.", RegexpDef.valueOf(RegexpDef.VAL.VUOTO)));
    }

    @Override
    public void setValidatorEnabled(boolean validator) {
        super.setValidatorEnabled(validator);
        ((NotEmptyValidator) nome.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) cognome.getInputVerifier()).setEnabled(validator);
        ((NotEmptyValidator) codiceFiscale.getInputVerifier()).setEnabled(validator);

        ((NotEmptyValidator) nome.getInputVerifier()).reset(nome);
        ((NotEmptyValidator) cognome.getInputVerifier()).reset(cognome);
        ((NotEmptyValidator) codiceFiscale.getInputVerifier()).reset(codiceFiscale);

    }
}
