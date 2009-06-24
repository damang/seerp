package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è controllare che la lunghezza minima del campo sia giusta.
 * @author Tommaso Cattolico
 */
public class NotMaxLengthValidator extends AbstractValidator {

    private int length;

    /**
     *
     * @param parent
     * @param c
     * @param message
     * @param length
     */
    public NotMaxLengthValidator(JPanel parent, JTextField c, String message, int length) {
        super(parent, c, message);
        this.length = length;
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        if (((JTextField) c).getText().length() > length) {
            return false;
        }
        return true;
    }
}
