import java.util.List;
import java.util.Random;

/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine Producer-Klasse die zufällig generierte Zahlen erzeugt und in einer ArrayList speichert
 */

class Producer {

    /**
     * Erzeugen einer Arraylist zum Speichern der Zahlen
     * Erzeugen eines Random Objekts
     */
    private List<Integer> arrayList;
    private final Random random;

    /**
     * Konstruktor
     * @param arrayList ArrayListe die erstellt wird
     */
    public Producer(List<Integer> arrayList) {
        this.arrayList = arrayList;
        this.random = new Random();
    }

    /**
     * Methode welche einen zufälligen Integer zwischen
     * 0 und 1000 erzeugt und zurückgibt
     * @return Zahl die hinzugefügt wurde
     */
    public int produce() {
        int number = random.nextInt(1001); // Zufälliger Integer zwischen 0 und 1000
        arrayList.add(number);
        System.out.println("Nummer : " + number + " wurde hinzugefügt.");
        return number;
    }
}