package it.configurazioni;

import java.awt.*;

/**
 * Serve per Gestire le operazioni di gestione, riposizionamento dei frame 
 * 
 * @author Andrea Cesaro
 */
public class Screen {

    /**
     * centra la finestra
     * @param com componente da centrare
     */
    static public void centraFinestra(Component com) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension comSize = com.getSize();
        if (comSize.height > screenSize.height) {
            comSize.height = screenSize.height;
        }
        if (comSize.width > screenSize.width) {
            comSize.width = screenSize.width;
        }
        com.setLocation((screenSize.width - comSize.width) / 2, (screenSize.height - comSize.height) / 2);
    }

    /**
     * centra la finestra
     * @param com componente da centrare
     */
    static public void centraFinestraInternal(Component com) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension comSize = com.getSize();
        if (comSize.height > screenSize.height) {
            comSize.height = screenSize.height;
        }
        if (comSize.width > screenSize.width) {
            comSize.width = screenSize.width;
        }
        com.setLocation((screenSize.width - comSize.width) / 2, (screenSize.height - comSize.height) / 2);
    }
     static public void settaFinestra(Component com) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       /* Dimension comSize = com.getSize();
        if (comSize.height > screenSize.height) {
            comSize.height = screenSize.height;
        }
        if (comSize.width > screenSize.width) {
            comSize.width = screenSize.width;
        }*/
        com.setSize(screenSize.width, screenSize.height);
    }
}
