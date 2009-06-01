package configurazioni.pattern.observer;


/**
 * Interfaccia che deve implementare l'oggetto che si vuole osservare
 * ( OBSERVER PATTERN )
 * @author Angelo
 */
public interface Observable {

    /**
     * notifica l'evento agli osservatori
     */
    public void notifyObservers();

    /**
     * inscrive un osservatore per questo oggetto
     * 
     * @param osservatore 
     */
    public void register(Observer osservatore);

    /**
     * disiscrive un osservatore per questo oggetto
     * 
     * @param osservatore
     */
    public void unRegister(Observer osservatore);
}

