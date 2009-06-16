package it.seerp.application.validation;

import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 * La classe che sviluppa i meccanismi di validazione dei campi di testo.
 * Tutto quello che fa è controllare che il campo immesso sia numerico
 * @author Tommaso Cattolico
 */
public class NotNumericValidator extends AbstractValidator {

    public NotNumericValidator(JXPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        if (!(Pattern.matches("[[0-9.-]", ((JTextField) c).getText()))) {
            return false;
        }
        return true;
    }
}
