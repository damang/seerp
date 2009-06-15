package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è assicurarsi che i campi incomincino con una determinata stringa.
 * @author Tommaso Cattolico
 */
public class StartWithValidator extends AbstractValidator {

    public StartWithValidator(JXPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

    protected boolean validationCriteria(JComponent c) {
        if (!(((JTextField) c).getText().startsWith("dipendente_") || ((JTextField) c).getText().startsWith("responsabile_"))) {
            return false;
        }
        return true;
    }
}