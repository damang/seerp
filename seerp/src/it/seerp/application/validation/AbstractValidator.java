package it.seerp.application.validation;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXPanel;

/**
 * Questa classe racchiude i meccanismi per la validazione di un componente grafico, tra cui tutti gli elementi come
 * caselle grafiche di aiuto e cambiamenti di colori
 *
 * @author Tommaso Cattolico
 * @see WantsValidationStatus
 */
public abstract class AbstractValidator extends InputVerifier implements KeyListener {

    protected  JDialog popup;
    private Object parent;
    private JLabel messageLabel;
    private JLabel image;
    private Point point;
    private Dimension cDim;
    private Color color;

    private AbstractValidator() {
        color = new Color(243, 255, 159);
    }

    protected AbstractValidator(JComponent c, String message) {
        this();
        c.addKeyListener(this);
        messageLabel = new JLabel(message + " ");
        image = new JLabel(new ImageIcon("/it/seerp/Gui/icone/ico16x16/remove.png"));
    }

    /**
     * @param parent Un JXPanel
     * @param c Il JComponent che deve essere validato.
     * @param message Il messaggio da mostrare nel popup se la validazione fallisce
     */
    public AbstractValidator(JPanel parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        popup = new JXDialog(parent);
        initComponents();
    }
   
    /**
     * @param parent Un JXPanel
     * @param c Il JComponent che deve essere validato.
     * @param message Il messaggio da mostrare nel popup se la validazione fallisce
     */
    public AbstractValidator(JFrame parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
    public AbstractValidator(Object parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        if (parent instanceof JFrame)
             popup = new JDialog((JFrame)parent);
        else if (parent instanceof JPanel) {
             popup = new JXDialog((JPanel)parent);
        }
        else if (parent instanceof JDialog)
            popup = new JDialog((JDialog)parent);
        else popup = new JDialog();
        initComponents();
    }

    /**
     * Implementare la logica di validazione in questo metodo. Il metodo deve ritornare false se i dati inseriti non
     * sono validi e true viceversa. E' comunque possibile settare il messaggio di popup tramite il metodo setMessage()
     * prima di ritornare, al fine di customizzare il testo per differenti tipi di validazioni
     * @param c Il JComponent che deve essere validato
     * @return false se i dati non sono validi, true se lo sono.
     */
    protected abstract boolean validationCriteria(JComponent c);

    /**
     * Questo metodo è chiamato da java quando un componente deve essere validato e non deve essere chiamato
     * direttamente. Non fare l'override del metodo se non si vuole veramente cambiare il comportamento della
     * validazione. Implementare validationCriteria()
     * @param c
     */
    @Override
    public boolean verify(final JComponent c) {
        if (!validationCriteria(c)) {
           
                /*   if (parent instanceof WantsValidationStatus) {
                ((WantsValidationStatus) parent).validateFailed();
                }*/
                   
                Runnable r= new Runnable() {

                @Override
                public void run() {
                    c.setBackground(Color.PINK);
                        popup.setSize(0, 0);
                        popup.setLocationRelativeTo(c);
                        point = popup.getLocation();
                        cDim = c.getSize();
                        popup.setLocation(point.x - (int) cDim.getWidth() / 2, point.y + (int) cDim.getHeight() / 2);
                        popup.pack();
                        popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        popup.setVisible(true);
                }
            };
                r.run();

                


                return false;
           
        }

        c.setBackground(Color.WHITE);
//
//        if (parent instanceof WantsValidationStatus) {
//            ((WantsValidationStatus) parent).validatePassed();
//        }
        return true;
    }

    public void reset(final JComponent c) {
       c.setBackground(Color.WHITE);
       popup.setVisible(false);
    }
    /**
     * Cambia il messagglio che appare nel popup quando il dato nel componente non è valido. Le sottoclassi
     * possono usare questo metodo per  sensibilizzare il messaggio in base a quello che l'utente fa erroneamente
     * @param message
     */
    protected void setMessage(String message) {
        messageLabel.setText(message);
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyPressed(KeyEvent e) {
        popup.setVisible(false);
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * @param e
     * @see KeyListener
     */
    @Override
    public void keyReleased(KeyEvent e) {
        verify((JComponent)e.getSource());

    }

    private void initComponents() {
        popup.getContentPane().setLayout(new FlowLayout());
        if (popup instanceof JXDialog)
            popup.getContentPane().remove(0);
         //   popup.getContentPane().getComponent(0).setVisible(false);
            
        popup.setUndecorated(true);
        popup.getContentPane().setBackground(color);
        popup.getContentPane().add(image);
        popup.getContentPane().add(messageLabel);
        popup.setFocusableWindowState(false);
    }
}
