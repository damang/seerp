package it.seerp.application.bean;

import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiIncarico {

    private JTextField txtPersonale;
    private JTextField txtPermesso;
    private JTextField txtRuolo;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     */
    public BeanGuiIncarico(JXPanel c) {
        grafica = c;
    }

    /**
     * Costruttore per la classe BeanGuiIncarico
     * @param txtPersonale
     * @param txtPermesso
     * @param txtRuolo
     */
    public BeanGuiIncarico(JTextField txtPersonale, JTextField txtPermesso, JTextField txtRuolo) {
        this.txtPersonale = txtPersonale;
        this.txtPermesso = txtPermesso;
        this.txtRuolo = txtRuolo;
    }

    /**
     * Metodo che permette di restituire il campo permesso dell'Incarico
     * @return il campo permesso
     */
    public JTextField getTxtPermesso() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtPermesso;
    }

    /**
     * Metodo che permette di restituire il campo personale dell'Incarico
     * @return il campo personale
     */
    public JTextField getTxtPersonale() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtPersonale;
    }

    /**
     * Metodo che permette di restituire il campo ruolo dell'Incarico
     * @return il campo ruolo
     */
    public JTextField getTxtRuolo() throws Exception {
        if (!val.shouldYieldFocus(grafica)) {
            throw new Exception("Errore nella grafica!");
        }
        return txtRuolo;
    }

    /**
     * Metodo che permette di settare il campo permesso di un Incarico
     * @param ptxtPermesso rappresenta il campo permesso da inserire
     */
    public void setTxtPermesso(JTextField ptxtPermesso) {
        this.txtPermesso = ptxtPermesso;
        val = new NotEmptyValidator(grafica, txtPermesso, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * Metodo che permette di settare il campo personale di un incarico
     * @param ptxtPersonale rappresenta il campo persnale da inserire
     */
    public void setTxtPersonale(JTextField ptxtPersonale) {
        this.txtPersonale = ptxtPersonale;
        val = new NotEmptyValidator(grafica, txtPersonale, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * Metodo che permette di settare il campo ruolo di un incarico
     * @param ptxtRuolo rappresenta il campo ruolo da inserire
     */
    public void setTxtRuolo(JTextField ptxtRuolo) {
        this.txtRuolo = ptxtRuolo;
        val = new NotEmptyValidator(grafica, txtRuolo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }
}
