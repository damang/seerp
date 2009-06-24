package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 * Classe relativa ai componenti grafici della gestione dell Contatto
 * @author matteo - Tommaso Cattolico
 */
public class BeanGuiContatto extends BeanGuiExtraAzienda {

    private JTextField txtFeedback;

    /**
     * metodo che restituisce il campo contenente il feedback del Contatto
     * @return il campo feedback
     */
    public JTextField getTxtFeedback() {
        return txtFeedback;
    }

    /**
     * metodo che permette di settare il campo contenente il feedback del Contatto
     * @param txtFeedback rappresenta il campo feedback  da inserire
     */
    public void setTxtFeedback(JTextField txtFeedback) {
        this.txtFeedback = txtFeedback;
    }
}
