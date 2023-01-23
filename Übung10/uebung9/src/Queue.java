public interface Queue {
    public void addLast (Object o); // Objekt hinten anfuegen
    public Object removeFirst (); //erstes Element entfernen und
    //eine Referenz darauf zurueck geben.
    public Object get(int i); // Das ite Element zu rueck geben
    public boolean empty(); // Testen, die Queue leer ist
    public boolean full() ; // Testen, ob noch Elemente einfuegbar sind
    public int size(); // Anzahl eingefuegter Elemente

    //dans l'énoncé :
    public void print(Queue q);
    //rajouté :
    public Object queueZeigen(Queue q, int index);
}