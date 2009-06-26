package it.seerp.Gui.configurazioni.pattern.observer;

/**
 * Interfaccia da implementare per monitorare gli eventi generati dall'oggetto osservato
 * ( OBSERVER PATTERN )
 * 
 * @author Luisa
 */
public interface Observer {
    
    /**
     * aggiorna lo stato in base all'evento scatenato dall'oggetto osservato
     * 
     * @param osservato
     */
    public void refreshData(Observable osservato);
}


