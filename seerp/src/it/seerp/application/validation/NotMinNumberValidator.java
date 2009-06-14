package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è controllare che l'email sia in un formato valido
 * @author Tommaso Cattolico
 */
public class NotMinNumberValidator extends AbstractValidator {

    int number;

    public NotMinNumberValidator(JXPanel parent, JTextField c, String message, int n) {
        super(parent, c, message);
        number = n;
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        if (Integer.parseInt(((JTextField) c).getText()) < number) {
            return false;
        }
        return true;
    }
}