package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è assicurarsi che i campi incomincino con una determinata stringa.
 * @author Tommaso Cattolico
 */
public class StartWithValidator extends AbstractValidator {

    /**
     *
     * @param parent
     * @param c
     * @param message
     */
    public StartWithValidator(JPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

    protected boolean validationCriteria(JComponent c) {
        if (!(((JTextField) c).getText().startsWith("dipendente_") || ((JTextField) c).getText().startsWith("responsabile_"))) {
            return false;
        }
        return true;
    }
}