
package configurazioni;


/**
 * Definisce le costanti associate alle gui di gestione, inserimento e update
 * @author Andrea
 */
public class GuiUtility {

   public static enum TIPO_MOVIMENTAZIONE_CONST {
        /**
         * 
         */
        BANCA,
        /**
         * 
         */
        CASSA
    };
    
    /**
     * 
     */
    public static enum TIPO_FATTURA_CONST {
        /**
         * 
         */
        EMESSE,
        /**
         * 
         */
        PIANIFICATE
    };

    /**
     * 
     */
    public static enum TIPO_UTENTE_CONST {
        /**
         * 
         */
        AZIENDA,        
        /**
         *
         */
        FORNITORE,
        /**
         * 
         */
        CLIENTE,
        /**
         * 
         */
        COLLABORATORE,
        /**
         * 
         */
        DIPENDENTE,
        /**
         *
         */
        BANCA
    };
    
    
    /**
     * 
     */
    public static enum TIPO_CONTABILITA_CONST {
         TIPFATTURE,
        TIPSOTTOCONTI,
        ANNOCONTABILE
    };
    
    /**
     * 
     */
    public static enum TIPO_OPERAZIONE_CONST {
        NEW,
        UPDATE,
        DELETE,
        SEARCH
    };    
    

 
    
    
    /**
     * 
     * @param con
     * @return
     */
    public static int valueOf(TIPO_UTENTE_CONST con){
        
        if (con.equals(TIPO_UTENTE_CONST.CLIENTE)){
            return 0;
        }else if (con.equals(TIPO_UTENTE_CONST.COLLABORATORE)){
            return 1;
        }else if (con.equals(TIPO_UTENTE_CONST.DIPENDENTE)){
            return 2;
        }if (con.equals(TIPO_UTENTE_CONST.FORNITORE)){
            return 3;
        }
        
        return -1;
    }

    /**
     * 
     * @param con
     * @return
     */
    public static TIPO_UTENTE_CONST valueOf(Integer con){
       return TIPO_UTENTE_CONST.values()[con];       
    }
    
      
}
