public interface Queue {
    public void addLast(Object o); //Objekt hinten anfuegen
    public Object removeFirst(); // erstes Element entfernen und eine Referenz darauf zurueckgeben
    public Object get(int i); // Das i'te Element zurueckgeben
    public boolean empty(); // Testen ob die Queue leer ist
    public boolean full(); // Testen ob Elemente einfuebar sind
    public int size(); // Anzahl eingefuegter Elemente
}
