package it.seerp.application.applicazione.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 * Classe relativa ai componenti grafici della gestione degli Eventi
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiEvento {

    private JTextField luogo;
    private JComboBox tema;
    private JTextField nome;
    private JTextArea note;
    private JXDatePicker data;
    private JTextField ora;
    private JTextField idEvento;
    private JCheckBox notifica;
    private Object grafica;
    private NotEmptyValidator val;
    private int idAgenda;
    private boolean validator = false;

    public boolean isValidator() {
        return validator;
    }

    public void setValidator(boolean validator) {
        this.validator = validator;
    }

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiEvento(Object c) {
        grafica = c;
    }

    public BeanGuiEvento() {
    }

    /**
     *
     * @return
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     *
     * @param idAgenda
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    /**
     * metodo che restituisce il campo contenente la notifica dell'Evento
     * @return il campo di notifica
     */
    public JCheckBox getNotifica() {
        return notifica;
    }

    /**
     * metodo che setta il campo notifica dell'Evento
     * @param notifica rappresenta il campo notifica
     */
    public void setNotifica(JCheckBox notifica) {
        this.notifica = notifica;
    }

    /**
     * metodo che restituisce il campo contenente la data dell'Evento
     * @return il campo data dell'Evento
     * @throws ValidatorException
     */
    public JXDatePicker getData() throws ValidatorException {
        if (validator == true) {
            if (!data.getInputVerifier().shouldYieldFocus(data)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return data;
    }

    /**
     * metodo che setta il campo data dell'Evento
     * @param pdata rappresenta il campo data da inserire
     */
    public void setData(JXDatePicker pdata) {
        this.data = pdata;
        //  data.setInputVerifier(new NotEmptyValidator(new JTextField(data.getDate().toString()), "Il capo non può essere vuoto."));
        data.setInputVerifier(new NotEmptyValidator(grafica, data, "Il campo non può essere vuoto.", " "));
    }

    /**
     * metodo che testituisce il campo contenente l'id dell'Evento
     * @return il campo id dell'Evento
     * @throws ValidatorException
     */
    public JTextField getIdEvento() throws ValidatorException {
        if (validator == true) {
            if (!idEvento.getInputVerifier().shouldYieldFocus(idEvento)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return idEvento;
    }

    /**
     * metodo che permette di settare il campo id dell'Evento
     * @param pidEvento rappresenta il campo id  da inserire
     */
    public void setIdEvento(JTextField pidEvento) {
        this.idEvento = pidEvento;
        idEvento.setInputVerifier(new NotEmptyValidator(grafica, idEvento, "Il campo non può essere vuoto.", " "));
    }

    /**
     * metodo che restituisce il campo contenente il luogo dell'Evento
     * @return il campo luogo dell'Evento
     * @throws ValidatorException
     */
    public JTextField getLuogo() throws ValidatorException {
        if (validator == true) {
            if (!luogo.getInputVerifier().shouldYieldFocus(luogo)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return luogo;
    }

    /**
     *metodo che setta il campo luogo dell'Evento
     * @param pluogo rappresenta il campo luogo da inserire
     */
    public void setLuogo(JTextField pluogo) {
        this.luogo = pluogo;
        luogo.setInputVerifier(new NotEmptyValidator(grafica, luogo, "Il campo non può essere vuoto.", " "));
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'Evento
     * @return il campo nome dell'Evente
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (validator == true) {
            if (!nome.getInputVerifier().shouldYieldFocus(nome)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return nome;
    }

    /**
     * metodo che setta il campo nome dell'Evento
     * @param pnome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        nome.setInputVerifier(new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.", " "));
    }

    /**
     * metodo che restituisce il campo contenente le note dell'Evento
     * @return il campo note dell'Evento
     */
    public JTextArea getNote() {
        return note;
    }

    /**
     * metodo che setta il campo note dell'Evento
     * @param pnote rappresenta il campo note da inserire
     */
    public void setNote(JTextArea pnote) {
        this.note = pnote;
    }

    /**
     * metodo che restituisce il campo contenente l'ora dell'Evento
     * @return il campo ora
     * @throws ValidatorException
     */
    public JTextField getOra() throws ValidatorException {
        if (validator == true) {
            if (!ora.getInputVerifier().shouldYieldFocus(ora)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return ora;
    }

    /**
     * metodo che setta il campo ora dell'Evento
     * @param pora rappesenta il campo ora  da inserire
     */
    public void setOra(JTextField pora) {
        this.ora = pora;
        ora.setInputVerifier(new NotEmptyValidator(grafica, ora, "Il campo non può essere vuoto.", " "));
    }

    /**
     * metodo che restituisce il campo contentente il tema dell'Evento
     * @return il campo tema
     * @throws ValidatorException
     */
    public JComboBox getTema() throws ValidatorException {
        if (validator == true) {
            if (!tema.getInputVerifier().shouldYieldFocus(tema)) {
                throw new ValidatorException("Il campo non può essere vuoto.");
            }
        }
        return tema;
    }

    /**
     * metodo che setta il campo tema dell'Evento
     * @param ptema rappresenta il campo tema da inserire
     */
    public void setTema(JComboBox ptema) {
        this.tema = ptema;
        //tema.setInputVerifier(new NotEmptyValidator(new JTextField((String) tema.getSelectedItem()), "Il campo non può essere vuoto."));
        tema.setInputVerifier(new NotEmptyValidator(grafica, tema, "Il campo non può essere vuoto.", " "));
    }
}
