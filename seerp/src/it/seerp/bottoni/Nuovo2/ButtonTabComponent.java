/** To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo2;

import it.seerp.Gui.frame.ObservableJPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Component to be used as tabComponent;
 * Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
public class ButtonTabComponent extends JPanel  {
    private final JTabbedPane pane;
    ObservableJPanel panel;
    JPanel menu;

    public ButtonTabComponent(final JTabbedPane pane, ObservableJPanel panel, JPanel menu) {

        //unset default FlowLayout' gaps
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
         
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
     this.pane=pane;
            this.panel=panel;
            this.menu=menu;
        setOpaque(false);
        //make JLabel read titles from JTabbedPane
        JLabel label = new JLabel() {
            @Override
            public String getText() {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
               
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        add(label);
        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new TabButton(this.pane,this.panel,this.menu);
      
        add(button);
        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

  
 

 /*   private final static MouseListener buttonMouseListener = new MouseAdapter() {
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
    };*/
}

