package it.seerp.Gui.Home.bottoni.gestioni;

import it.seerp.Gui.observablePanel.ObservableJPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luisa
 */
public class TabButton extends JButton implements ActionListener {

    JTabbedPane pane;
    ObservableJPanel pannel;
    JPanel menu;
  

    /**
     *
     * @param pane
     * @param panel
     * @param menu
     */
    public TabButton(JTabbedPane pane, ObservableJPanel panel, JPanel menu) {
        this.pane = pane;
        this.pannel = panel;
        this.menu = menu;
        int size = 17;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("close this tab");
        //Make the button looks the same for all Laf's
        setUI(new BasicButtonUI());
        //Make it transparent
        setContentAreaFilled(false);
        //No need to be focusable
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        //Making nice rollover effect
        //we use the same listener for all buttons
         addMouseListener(buttonMouseListener);
        setRolloverEnabled(true);
        //Close the proper tab by clicking the button
        addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        int i=pane.indexOfComponent(this.pannel);
        if (i != -1) {
            pane.remove(i);
            pane.repaint();
           // menu.setVisible(false);
            pannel.notifyObservers();
        }
    }

    //we don't want to update UI for this button
    public void updateUI() {
    }

    //paint the cross
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/seerp/Gui/icone/ico16x16/remove.png")));
    /* Graphics2D g2 = (Graphics2D) g.create();
    //shift the image for pressed buttons
    if (getModel().isPressed()) {
    g2.translate(1, 1);
    }
    g2.setStroke(new BasicStroke(2));
    g2.setColor(Color.BLACK);
    if (getModel().isRollover()) {
    g2.setColor(Color.MAGENTA);
    }
    int delta = 6;
    g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
    g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
    g2.dispose();*/
    }
     private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
}
