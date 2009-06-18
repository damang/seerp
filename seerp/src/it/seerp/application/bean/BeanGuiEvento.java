package it.seerp.application.bean;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.validation.NotEmptyValidator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Luisa - Tommaso Cattolico
 */
public class BeanGuiEvento {

    private JTextField luogo;
    private JTextField tema;
    private JTextField nome;
    private JTextArea note;
    private JTextField data;
    private JTextField ora;
    private JTextField idEvento;
    private BeanGuiAgenda agenda;
    private JTextField notifica;
    private JXPanel grafica;
    private NotEmptyValidator val;

    /**
     * Costruttore a cui viene passato un componente grafico necessario alla
     * validazione del campo
     * @param c
     */
    public BeanGuiEvento(JXPanel c) {
        grafica = c;
    }

    /**
     *Costruttore vuoto per la classe Bean Gui Evento
     */
    public BeanGuiEvento() {
    }

    /**
     *
     * @param luogo
     * @param tema
     * @param nome
     * @param note
     * @param data
     * @param ora
     * @param idEvento
     * @param notifica
     * @param grafica
     */
    public BeanGuiEvento(JTextField luogo, JTextField tema, JTextField nome, JTextArea note, JTextField data, JTextField ora, JTextField idEvento, JTextField notifica, JXPanel grafica) {
        this.luogo = luogo;
        this.tema = tema;
        this.nome = nome;
        this.note = note;
        this.data = data;
        this.ora = ora;
        this.idEvento = idEvento;
        this.notifica = notifica;
        this.grafica = grafica;
    }

   

    /**
     * metodo che restituisce il campo contenente la notifica dell'Evento
     * @return il campo di notifica
     */
    public JTextField getNotifica() {
        return notifica;
    }

    /**
     * metodo che setta il campo notifica dell'Evento
     * @param notifica rappresenta il campo notifica
     */
    public void setNotifica(JTextField notifica) {
        this.notifica = notifica;
    }

    

    

    
    /**
     * 
     * @return
     * @throws java.lang.Exception
     */
    public BeanGuiAgenda getAgenda() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return agenda;
    }

    /**
     *
     * @param pagenda
     */
    public void setAgenda(BeanGuiAgenda pagenda) {
        this.agenda = pagenda;
      
    }

    /**
     * metodo che restituisce il campo contenente la data dell'Evento
     * @return il campo data dell'Evento
     * @throws ValidatorException
     */
    public JTextField getData() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return data;
    }

    /**
     * metodo che setta il campo data dell'Evento
     * @param pdata rappresenta il campo data da inserire
     */
    public void setData(JTextField pdata) {
        this.data = pdata;
        val = new NotEmptyValidator(grafica, data, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che testituisce il campo contenente l'id dell'Evento
     * @return il campo id dell'Evento
     * @throws ValidatorException
     */
    public JTextField getIdEvento() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return idEvento;
    }

    /**
     * metodo che permette di settare il campo id dell'Evento
     * @param pidEvento rappresenta il campo id  da inserire
     */
    public void setIdEvento(JTextField pidEvento) {
        this.idEvento = pidEvento;
        val = new NotEmptyValidator(grafica, idEvento, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente il luogo dell'Evento
     * @return il campo luogo dell'Evento
     * @throws ValidatorException
     */
    public JTextField getLuogo() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return luogo;
    }

    /**
     *metodo che setta il campo luogo dell'Evento
     * @param pluogo rappresenta il campo luogo da inserire
     */
    public void setLuogo(JTextField pluogo) {
        this.luogo = pluogo;
        val = new NotEmptyValidator(grafica, luogo, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contenente il nome dell'Evento
     * @return il campo nome dell'Evente
     * @throws ValidatorException
     */
    public JTextField getNome() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return nome;
    }

    /**
     * metodo che setta il campo nome dell'Evento
     * @param pnome rappresenta il campo nome da inserire
     */
    public void setNome(JTextField pnome) {
        this.nome = pnome;
        val = new NotEmptyValidator(grafica, nome, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
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
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return ora;
    }

    /**
     * metodo che setta il campo ora dell'Evento
     * @param pora rappesenta il campo ora  da inserire
     */
    public void setOra(JTextField pora) {
        this.ora = pora;
        val = new NotEmptyValidator(grafica, ora, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }

    /**
     * metodo che restituisce il campo contentente il tema dell'Evento
     * @return il campo tema
     * @throws ValidatorException
     */
    public JTextField getTema() throws ValidatorException {
        if (!val.shouldYieldFocus(grafica)) {
            throw new ValidatorException("Errore nella grafica!");
        }
        return tema;
    }

    /**
     * metodo che setta il campo tema dell'Evento
     * @param ptema rappresenta il campo tema da inserire
     */
    public void setTema(JTextField ptema) {
        this.tema = ptema;
        val = new NotEmptyValidator(grafica, tema, "Il campo non può essere vuoto.");
        grafica.setInputVerifier(val);
    }
}
