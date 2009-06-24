package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo. 
 * Tutto quello che fa è assicurarsi che i campi non siano vuoti.
 * @author Tommaso Cattolico
 */
public class NotEmptyValidator extends AbstractValidator {

    /**
     *
     * @param parent
     * @param c
     * @param message
     */
    public NotEmptyValidator(JPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
       if (((JTextField) c).getText().equals("")) {
            return false;
        }
        return true;
    }
}
