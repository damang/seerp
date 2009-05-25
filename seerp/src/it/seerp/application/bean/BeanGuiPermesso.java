/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.application.bean;

import javax.swing.JTextField;

/**
 *
 * @author matteo
 */
public class BeanGuiPermesso {


    private JTextField idPermesso;
    private JTextField Nome;

    /**
     *
     * @return
     */
    public JTextField getNome() {
        return Nome;
    }

    /**
     *
     * @return
     */
    public JTextField getIdPermesso() {
        return idPermesso;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(JTextField Nome) {
        this.Nome = Nome;
    }

    /**
     *
     * @param idPermesso
     */
    public void setIdPermesso(JTextField idPermesso) {
        this.idPermesso = idPermesso;
    }

}
