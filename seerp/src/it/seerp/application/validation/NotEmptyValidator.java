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
    String regexp;
    /**
     *
     * @param parent
     * @param c
     * @param message
     */
    public NotEmptyValidator(JPanel parent, JTextField c, String message) {
        super(parent, c, message);
    }

   /* public NotEmptyValidator(JComponent c, String message, String regexp) {
        super(c, message);
        this.regexp=regexp;
    }*/
    public NotEmptyValidator(Object l,JComponent c, String message, String regexp) {
        super(l, c, message);
        this.regexp=regexp;
    }


    
    @Override
    protected boolean validationCriteria(JComponent c) {
       return true;//((JTextField) c).getText().matches(regexp);
    }
}
