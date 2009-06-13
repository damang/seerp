package it.seerp.application.validation;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Tommaso Cattolico
 */
public class EmailValidator extends AbstractValidator {

    public EmailValidator(JXPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

    @Override
    protected boolean validationCriteria(JComponent c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
