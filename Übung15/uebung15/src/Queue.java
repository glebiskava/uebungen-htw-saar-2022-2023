/**
 * Dieses Interface gibt eine Schnittstelle fuer eine sehr einfache Implementierung einer WarteschlangenKlasse vor
 */
public interface Queue {

    /**
     * Objekt hinten anfuegen
     * @param o angefuegtes element
     */
     void addLast(Object o);

    /**
     * erstes Element entfernen und eine Referenz darauf zurueckgeben
     */
     Object removeFirst();

    /**
     * letztes element entfernen und refeerenz zurueckgeben
     */
     Object removeLast();

    /**
     * Das i'te Element zurueckgeben
     * @param i stelle des elements im Array
     */
     Object get(int i);

    /**
     * Testen ob die Queue leer ist
     */
     boolean empty();

    /**
     * Testen ob Elemente einfuebar sind
     */
     boolean full();

    /**
     * Anzahl eingefuegter Elemente
     */
     int size();

    /**
     * gibt die Queue aus
     */
     void print();

    /**
     * gitb den kleinsten lexikalischen Vornamen aus
     */
    String smallest();

}