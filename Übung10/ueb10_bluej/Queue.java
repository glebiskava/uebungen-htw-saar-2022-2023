/**
 * Dieses Interface gibt eine Schnittstelle fuer eine sehr einfache Implementierung einer WarteschlangenKlasse vor
 */
public interface Queue {

    /**
     * Objekt hinten anfuegen
     * @param o angefuegtes element
     */
    public void addLast(Object o);

    /**
     * erstes Element entfernen und eine Referenz darauf zurueckgeben
     */
    public Object removeFirst();

    /**
     * letztes element entfernen und refeerenz zurueckgeben
     */
    public Object removeLast();

    /**
     * Das i'te Element zurueckgeben
     * @param i stelle des elements im Array
     */
    public Object get(int i);

    /**
     * Testen ob die Queue leer ist
     */
    public boolean empty();

    /**
     * Testen ob Elemente einfuebar sind
     */
    public boolean full();

    /**
     * Anzahl eingefuegter Elemente
     */
    public int size();

    /**
     * gibt die Queue aus
     * @param q queue die ausgegeben werden soll
     */
    public void print(Queue q);

}