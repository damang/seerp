package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è controllare che la lunghezza del campo sia giusta.
 * @author Tommaso Cattolico
 */
public class NotEqualLengthValidator extends AbstractValidator {

    private int length;

    public NotEqualLengthValidator(JXPanel parent, JTextField c, String message, int length) {
        super(parent, c, message);
        this.length = length;
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        if (((JTextField) c).getText().length() != length) {
            return false;
        }
        return true;
    }
}
