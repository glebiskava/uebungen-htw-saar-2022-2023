/**
 * Dies ist eine einfache StringQueue Klasse die das Interface Queue implementiert
 */

class StringQueue implements Queue {

    /**
     * erstellen des Arrays
     */
    private String[] queue;

    /**
     * aktuelle groesse des Arrays
     */
    private int size;

    /**
     * vorgegebene Groesse 10 des Arrays --> wie in Aufgabenstellung
     */
    private static final int defaultSize = 10;

    /**
     * Konstruktor fuer die Queue mit Standardgroesse 10 und aktueller groesse 0
     */
    public StringQueue() { // demander à l'user
        this.queue = new String[defaultSize];
        this.size = 0;
    }

    /**
     * Methode die ein Element am Ende des Arrays anfuegt
     * @param o element welches angefuegt wird
     */
    public void addLast(Object o) {
        if (o instanceof String) {
            if (!full()) {
                queue[size] = (String) o;
                size++;
            } else {
                throw new IllegalArgumentException("Die Queue ist voll!");
            }
        } else {
            throw new IllegalArgumentException("Invalid input, input must be of type String");
        }
    }

    /**
     * Methode die das erste Element loescht und das geloeschte Element zurueckgibt
     * @return geloeschtes Element
     */
    public Object removeFirst() {
        if (!empty()) {
            Object item = queue[0];
            for (int i = 0; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            size--;
            return item;
        } else {
            throw new IllegalArgumentException("Die Queue ist leer");
        }
    }

    /**
     * Methode die das letzte Element loescht und das geloeschte Element zurueckgibt
     * @return geloeschtes Element
     */
    @Override
    public Object removeLast() {
        if (!empty()) {
            Object item = queue[size - 1];
            size--;
            return item;
        } else {
            throw new IllegalArgumentException("Die Queue ist leer");
        }
    }

    /**
     * Methode die das i'te Element zurueckgibt
     * @param i stelle (index) des Elements
     * @return element an i'ter Stelle
     */
    public Object get(int i) {
        if (i >= 0 && i < size) {
            return queue[i];
        } else {
            throw new IllegalArgumentException("Index außerhalb des zulässigen Bereichs.");
        }
    }

    /**
     * Methode schaut ob Queue leer ist
     * @return true, wenn sie leer ist und false, wenn nicht
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Methode schaut ob Queue voll ist also ob es noch anfuegbare Elemente gibt
     * @return true, wenn sie voll ist und false, wenn nicht
     */
    public boolean full() {
        return size == defaultSize;
    }

    /**
     * Mehode gibt die Anzahl der Elemente im Array also die Laenge des Arrays wieder
     * @return laenge des Arrays, anzahl der elemente
     */
    public int size() {
        return size;
    }

    /**
     * Methode die jeweilige Warteschlange mithilfe der get-Methode
     * sequenziell durchlaeuft und ausgibt
     * @param q
     */
    @Override
    public void print(Queue q) {
        for(int i = 0; i < q.size(); i++){
            System.out.println(i + " : " + q.get(i));
        }
    }


}