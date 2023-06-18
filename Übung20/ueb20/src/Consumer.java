import java.util.*;


/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Dies ist eine Consumer-Klasse die von der Klasse Producer zufällig generierte Zahlen "konsumiert" und in einer
 * ArrayList speichert
 */
class Consumer {

    /**
     * quersummen zur Speicherung der Quersummen und zugehörigen Zeitstempel
     * digitSumsCount Map zur Speicherung der Häufigkeit der berechneten Quersummen
     */
    private Map<Integer, List<Long>> quersummen;
    private Map<Integer, Integer> quersummenCount;
    private Producer producer;

    /**
     * Konstruktor
     */
    public Consumer() {
        quersummen = new HashMap<>();
        quersummenCount = new HashMap<>();
    }

    /**
     * Diese Methode nimmt einen Integer entgegen und berechnet die Quersumme.
     * Für jede Berechnung wird der Zeitstempel der Berechnung gespeichert
     */
    public void consume() {
        int number = producer.produce();
        int sum = calculateDigitSum(number);
        long timestamp = System.currentTimeMillis();

        List<Long> timestamps = quersummen.getOrDefault(sum, new ArrayList<>());
        timestamps.add(timestamp);
        quersummen.put(sum, timestamps);

        int count = quersummenCount.getOrDefault(sum, 0);
        quersummenCount.put(sum, count + 1);

        System.out.println("Consumer calculated sum: " + sum);
    }

    /**
     * Berechnet die Quersumme einer gegebenen Zahl.
     *
     * @param number Die Zahl, für die die Quersumme berechnet werden soll.
     * @return Die berechnete Quersumme der gegebenen Zahl.
     */
    public int calculateDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    /**
     * gibt an, wie viele unterschiedliche Quersummen berechnet
     * wurden
     * @return anzahl an quersummen
     */
    public int numberOfDifferentResults() {
        return quersummen.size();
    }

    /**
     * gibt für einen gegebenen Integer an, wie häufig dieser als Ergebnis einer Berechnung vorkam
     * getOrDefault(number, 0) :  Returns the value to which the specified key is mapped,
     *                            or defaultValue if this map contains no mapping for the key
     * @param number Ergebnis wonach gesucht wird
     * @return der Wert, auf den der angegebene Schlüssel gemapped wird
     */
    public int numberOfOccurrences(int number) {
        return quersummenCount.getOrDefault(number, 0);
    }

    /**
     * gibt eine Collection zurück, welche die berechneten Quersummen in aufsteigender Reihenfolge enthält
     * keySet() : Returns a Set view of the keys contained in this map
     * @return Collection mit aufsteigender Sortierung
     */
    public List<Integer> getCrossTotalsAscending() {
        List<Integer> crossTotals = new ArrayList<>(quersummen.keySet());
        Collections.sort(crossTotals);
        return crossTotals;
    }

    /**
     * gibt eine Collection zurück, welche die berechneten Quersummen in absteigender Reihenfolge enthält
     * keySet() : Returns a Set view of the keys contained in this map
     * reverseOrder() : Returns a comparator that imposes the reverse of the natural ordering on a
     *                  collection of objects that implement the Comparable interface
     * @return Collection mit absteigender Sortierung
     */
    public List<Integer> getCrossTotalsDescending() {
        List<Integer> crossTotals = new ArrayList<>(quersummen.keySet());
        crossTotals.sort(Collections.reverseOrder());
        return crossTotals;
    }

    /**
     * nimmt einen Integer entgegen und gibt eine Collection zurück,
     * welche alle zugehörigen Zeitstempel enthält. D.h. die Zeitstempel der Berechnungen, die
     * zu dem gegebenen Ergebnis geführt haben
     * @param result Ergebnis wonach gesucht wird
     * @return Ergebnis oder eine leere ArrayList, wenn das Ergebnis nciht gefunden wurde
     */
    public List<Long> getTimestampsForResult(int result) {
        return quersummen.getOrDefault(result, new ArrayList<>());
    }


}
