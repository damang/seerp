package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è controllare che l'email sia in un formato valido
 * @author Tommaso Cattolico
 */
public class NotMinNumberValidator extends AbstractValidator {

    int number;

    /**
     *
     * @param parent
     * @param c
     * @param message
     * @param n
     */
    public NotMinNumberValidator(JPanel parent, JTextField c, String message, int n) {
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
